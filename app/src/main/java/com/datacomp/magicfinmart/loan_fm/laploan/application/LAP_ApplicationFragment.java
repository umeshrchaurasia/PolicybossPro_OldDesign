package com.datacomp.magicfinmart.loan_fm.laploan.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.homeloan.loan_apply.HomeLoanApplyActivity;
import com.datacomp.magicfinmart.loan_fm.laploan.ActivityTabsPagerAdapter_LAP;
import com.datacomp.magicfinmart.loan_fm.laploan.LapLoanApplicationAdapter;

/**
 * Created by IN-RB on 22-01-2018.
 */

 import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;

public class LAP_ApplicationFragment extends BaseFragment implements View.OnClickListener {
    RecyclerView rvApplicationList;
    LapLoanApplicationAdapter lapLoanApplicationAdapter;
    List<FmHomeLoanRequest> mApplicationList;
    ImageView ivSearch, ivAdd;
    TextView tvAdd, tvSearch;
    EditText etSearch;

    public LAP_ApplicationFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hl_application, container, false);
        initView(view);
        setListener();
        setTextWatcher();
        mApplicationList = new ArrayList<>();

        if (getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_LAP.APPLICATION_LIST) != null) {
            mApplicationList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_LAP.APPLICATION_LIST);
        }

        rvApplicationList.setAdapter(null);
        lapLoanApplicationAdapter = new LapLoanApplicationAdapter(LAP_ApplicationFragment.this,mApplicationList);
        rvApplicationList.setAdapter(lapLoanApplicationAdapter);

        return view;
    }

    private void initView(View view) {

        ivSearch = (ImageView) view.findViewById(R.id.ivSearch);
        ivAdd = (ImageView) view.findViewById(R.id.ivAdd);
        tvAdd = (TextView) view.findViewById(R.id.tvAdd);
        tvSearch = (TextView) view.findViewById(R.id.tvSearch);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);

        rvApplicationList = (RecyclerView) view.findViewById(R.id.rvApplicationList);
        rvApplicationList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvApplicationList.setLayoutManager(layoutManager);


    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
    }

    public void redirectLAPLoanApply(String ApplNum){
        Intent intent=new Intent(getActivity(), HomeLoanApplyActivity.class);
        intent.putExtra(Utility.HMLOAN_APPLICATION,ApplNum);
        intent.putExtra("TypePage","LAP");
        startActivity(intent);

    }
    private void setTextWatcher() {
//search
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

    public void callnumber(String mobNumber)
    {
        dialNumber(mobNumber);
    }
}
