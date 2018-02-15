package com.datacomp.magicfinmart.motor.twowheeler.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.activity.InputQuoteBottmActivity;
import com.datacomp.magicfinmart.motor.privatecar.adapter.ActivityTabsPagerAdapter;
import com.datacomp.magicfinmart.motor.twowheeler.activity.BikeAddQuoteActivity;
import com.datacomp.magicfinmart.motor.twowheeler.adapter.BikeQuoteTabAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quoteapplication.QuoteApplicationController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.QuoteAppUpdateDeleteResponse;

/**
 * Created by Rajeev Ranjan on 02/02/2018.
 */

public class BikeQuoteTabFragment extends BaseFragment implements View.OnClickListener, IResponseSubcriber {

    public static final String FROM_QUOTE_BIKE = "from_quote";
    FloatingActionButton btnAddQuote;
    RecyclerView rvQuoteList;
    BikeQuoteTabAdapter bikeQuoteTabAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    List<QuoteListEntity> mQuoteList;
    QuoteListEntity removeQuoteEntity;
    ImageView ivSearch, ivAdd;
    TextView tvAdd, tvSearch;
    EditText etSearch;

    public BikeQuoteTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.bike_fragment_quote_tab, container, false);
        initView(view);
        setListener();
        setTextWatcher();
        mQuoteList = new ArrayList<>();
        if (getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.QUOTE_LIST) != null) {
            mQuoteList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.QUOTE_LIST);
        }

        rvQuoteList.setAdapter(null);
        bikeQuoteTabAdapter = new BikeQuoteTabAdapter(BikeQuoteTabFragment.this, mQuoteList);
        rvQuoteList.setAdapter(bikeQuoteTabAdapter);

        return view;
    }


    //redirect to input quote bottom
    public void redirectToInputQuote(QuoteListEntity entity) {
        startActivity(new Intent(getActivity(), InputQuoteBottmActivity.class).putExtra(FROM_QUOTE_BIKE, entity));
    }

    private void initView(View view) {
        ivSearch = (ImageView) view.findViewById(R.id.ivSearch);
        ivAdd = (ImageView) view.findViewById(R.id.ivAdd);
        tvAdd = (TextView) view.findViewById(R.id.tvAdd);
        tvSearch = (TextView) view.findViewById(R.id.tvSearch);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);

        btnAddQuote = (FloatingActionButton) view.findViewById(R.id.fbAddQuote);
        rvQuoteList = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        rvQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvQuoteList.setLayoutManager(layoutManager);
        btnAddQuote.setOnClickListener(this);

    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
    }

    private void setTextWatcher() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bikeQuoteTabAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
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
                startActivity(new Intent(getActivity(), BikeAddQuoteActivity.class));
                break;
            case R.id.tvSearch:
            case R.id.ivSearch:
                if (etSearch.getVisibility() == View.INVISIBLE) {
                    etSearch.setVisibility(View.VISIBLE);
                    etSearch.requestFocus();
                }

                break;
            case R.id.ivAdd:
            case R.id.tvAdd:
                startActivity(new Intent(getActivity(), BikeAddQuoteActivity.class));
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
                bikeQuoteTabAdapter.refreshAdapter(mQuoteList);
                bikeQuoteTabAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
    }

    //endregion
}
