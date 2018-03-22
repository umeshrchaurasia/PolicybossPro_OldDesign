package com.datacomp.magicfinmart.loan_fm.homeloan.application;

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
import com.datacomp.magicfinmart.loan_fm.homeloan.ActivityTabsPagerAdapter_HL;
import com.datacomp.magicfinmart.loan_fm.homeloan.HomeLoanApplicationAdapter;
import com.datacomp.magicfinmart.loan_fm.homeloan.addquote.HLMainActivity;
import com.datacomp.magicfinmart.loan_fm.homeloan.loan_apply.HomeLoanApplyActivity;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;

/**
 * Created by IN-RB on 19-01-2018.
 */

public class HL_ApplicationFragment extends BaseFragment implements View.OnClickListener {
    RecyclerView rvApplicationList;
    HomeLoanApplicationAdapter homeLoanApplicationAdapter;
    List<FmHomeLoanRequest> mApplicationList;
    ImageView ivSearch, ivAdd;
    TextView tvAdd, tvSearch;
    EditText etSearch;

    public HL_ApplicationFragment() {
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

        if (getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_HL.APPLICATION_LIST) != null) {
            mApplicationList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_HL.APPLICATION_LIST);
        }

        homeLoanApplicationAdapter = new HomeLoanApplicationAdapter(HL_ApplicationFragment.this, mApplicationList);
        rvApplicationList.setAdapter(homeLoanApplicationAdapter);

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

    public void redirectHomeLoanApply(String ApplNum) {
        Intent intent = new Intent(getActivity(), HomeLoanApplyActivity.class);
        intent.putExtra(Utility.HMLOAN_APPLICATION, ApplNum);
        intent.putExtra("TypePage", "HL");
        startActivity(intent);

    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
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

    public void callnumber(String mobNumber) {
        dialNumber(mobNumber);
    }
}
