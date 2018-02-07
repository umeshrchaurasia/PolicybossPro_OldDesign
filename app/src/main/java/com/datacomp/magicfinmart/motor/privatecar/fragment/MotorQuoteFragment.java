package com.datacomp.magicfinmart.motor.privatecar.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.adapter.MotorQuoteAdapter;
import com.datacomp.magicfinmart.motor.privatecar.adapter.ActivityTabsPagerAdapter;
import com.datacomp.magicfinmart.motor.privatecar.activity.InputQuoteBottmActivity;
import com.datacomp.magicfinmart.utility.RecyclerItemClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quoteapplication.QuoteApplicationController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.QuoteAppUpdateDeleteResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class MotorQuoteFragment extends BaseFragment implements View.OnClickListener, IResponseSubcriber {

    public static final String FROM_QUOTE = "from_quote";
    FloatingActionButton btnAddQuote;
    RecyclerView rvQuoteList;
    MotorQuoteAdapter motorQuoteAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    List<QuoteListEntity> mQuoteList;
    QuoteListEntity removeQuoteEntity;

    public MotorQuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_motor_quote, container, false);
        initView(view);
        mQuoteList = new ArrayList<>();
        if (getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.QUOTE_LIST) != null) {
            mQuoteList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.QUOTE_LIST);
        }
        motorQuoteAdapter = new MotorQuoteAdapter(MotorQuoteFragment.this, mQuoteList);
        rvQuoteList.setAdapter(motorQuoteAdapter);

        //recyclerview item click listener
        rvQuoteList.addOnItemTouchListener(new RecyclerItemClickListener(rvQuoteList, onItemClickListener));
        return view;
    }

    RecyclerItemClickListener.OnItemClickListener onItemClickListener =
            new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                    QuoteListEntity entity = mQuoteList.get(position);

                    startActivity(new Intent(getActivity(), InputQuoteBottmActivity.class).putExtra(FROM_QUOTE, entity));
                }
            };

    private void initView(View view) {
        btnAddQuote = (FloatingActionButton) view.findViewById(R.id.fbAddQuote);
        rvQuoteList = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        rvQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvQuoteList.setLayoutManager(layoutManager);
        btnAddQuote.setOnClickListener(this);

    }

    public void removeQuote(QuoteListEntity entity) {

        removeQuoteEntity = entity;
        showDialog("Please wait,Removing quote..");
        new QuoteApplicationController(getContext()).deleteQuote("" + entity.getVehicleRequestID(),
                this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fbAddQuote:
                startActivity(new Intent(getActivity(), InputQuoteBottmActivity.class));
                break;
        }
    }


    //region server response

    @Override
    public void OnSuccess(APIResponse response, String message) {

        cancelDialog();
        if (response instanceof QuoteAppUpdateDeleteResponse) {
            if (response.getStatusNo() == 0) {
                mQuoteList.remove(removeQuoteEntity);
                motorQuoteAdapter.refreshAdapter(mQuoteList);
                motorQuoteAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
    }

    //endregion
}
