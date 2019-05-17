package com.datacomp.magicfinmart.motor.privatecar.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.activity.InputQuoteBottmActivity;
import com.datacomp.magicfinmart.motor.privatecar.adapter.ActivityTabsPagerAdapter;
import com.datacomp.magicfinmart.motor.privatecar.adapter.MotorLeadAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quoteapplication.QuoteApplicationController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MotorMyLeadEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.MotorLeadResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.MotorViewLeadResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.QuoteApplicationResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class MotorLeadFragment extends BaseFragment implements View.OnClickListener, IResponseSubcriber {

    public static final String FROM_QUOTE = "from_lead";

    RecyclerView rvLeadList;
    MotorLeadAdapter motorLeadAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    List<MotorMyLeadEntity> mLeadList;
    QuoteListEntity removeQuoteEntity;
    ImageView ivSearch;
    TextView tvSearch;
    EditText etSearch;
    RecyclerView.LayoutManager layoutManager;
    boolean isHit = false;
    String Type = "";

    public MotorLeadFragment() {
        // Required empty public constructor
    }

    //LEAD_LIST

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_motor_lead, container, false);
        initView(view);
        setListener();
        setTextWatcher();

        mLeadList = new ArrayList<>();
        if (getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.LEAD_LIST) != null) {
            mLeadList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.LEAD_LIST);
        }

        rvLeadList.setAdapter(null);
        motorLeadAdapter = new MotorLeadAdapter(MotorLeadFragment.this, mLeadList);
        rvLeadList.setAdapter(motorLeadAdapter);

        rvLeadList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastCompletelyVisibleItemPosition = 0;

                lastCompletelyVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                        .findLastVisibleItemPosition();


                if (lastCompletelyVisibleItemPosition == mLeadList.size() - 1) {
                    if (!isHit) {
                        isHit = true;
                        fetchMoreLeads(mLeadList.size());

                    }
                }
            }
        });
        return view;
    }

    public void fetchMoreLeads(int count) {
        //showDialog("Fetching.., Please wait.!");


        new QuoteApplicationController(getActivity()).getQuoteAppList(count, 3, "", "",
                new DBPersistanceController(getActivity()).getUserData().getFBAId(),
                1,
                "",
                this);
    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
    }

    private void setTextWatcher() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                motorLeadAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void initView(View view) {
        ivSearch = (ImageView) view.findViewById(R.id.ivSearch);

        tvSearch = (TextView) view.findViewById(R.id.tvSearch);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);

        rvLeadList = (RecyclerView) view.findViewById(R.id.rvLeadList);
        rvLeadList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rvLeadList.setLayoutManager(layoutManager);

    }


    //redirect to input quote bottom
    public void redirectToInputQuote(MotorMyLeadEntity entity) {

        showDialog();
        new QuoteApplicationController(getActivity()).ModifyLead(entity, this);

    }

    public void redirectViewToInputQuote(MotorMyLeadEntity entity) {

        showDialog();
        new QuoteApplicationController(getActivity()).ViewLead(entity.getVehicleRequestID(), entity.getLeadId(), this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.tvSearch:
            case R.id.ivSearch:
                if (etSearch.getVisibility() == View.INVISIBLE) {
                    etSearch.setVisibility(View.VISIBLE);
                    etSearch.requestFocus();
                }

                break;

        }

    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

        cancelDialog();
        if (response instanceof QuoteApplicationResponse) {
            List<MotorMyLeadEntity> list = ((QuoteApplicationResponse) response).getMasterData().getMyleads();
            if (list.size() > 0) {
                isHit = false;
                for (MotorMyLeadEntity entity : list) {
                    if (!mLeadList.contains(entity)) {
                        mLeadList.add(entity);
                    }
                }
            }
            motorLeadAdapter.refreshAdapter(mLeadList);
            motorLeadAdapter.notifyDataSetChanged();

        } else if (response instanceof MotorLeadResponse) {

            QuoteListEntity entity = ((MotorLeadResponse) response).getMasterData();


            startActivity(new Intent(getActivity(), InputQuoteBottmActivity.class).putExtra(FROM_QUOTE, entity));
        } else if (response instanceof MotorViewLeadResponse) {

            QuoteListEntity entity = ((MotorViewLeadResponse) response).getMasterData();

            startActivity(new Intent(getActivity(), InputQuoteBottmActivity.class).putExtra(FROM_QUOTE, entity));
        }


    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
