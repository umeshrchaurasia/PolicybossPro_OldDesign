package com.datacomp.magicfinmart.loan_fm.balancetransfer.application;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.datacomp.magicfinmart.loan_fm.balancetransfer.ActivityTabsPagerAdapter_BL;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.BalanceTransferApplicationAdapter;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.loan_apply.BalanceTransferLoanApplyActivity;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.loan_apply.BalanceTransferPersonalApplyActivity;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BLLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmBalanceLoanRequest;

/**
 * A simple {@link Fragment} subclass.
 */
public class BL_ApplicationFragment extends BaseFragment implements View.OnClickListener{

    RecyclerView rvApplicationList;
    BalanceTransferApplicationAdapter balanceTransferApplicationAdapter;
    List<FmBalanceLoanRequest> mApplicationList;
    ImageView ivSearch, ivAdd;
    TextView tvAdd, tvSearch;
    EditText etSearch;
    public BL_ApplicationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bl__application, container, false);
        initView(view);

        setListener();
        setTextWatcher();

        mApplicationList = new ArrayList<>();

        if (getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_BL.APPLICATION_LIST) != null) {
            mApplicationList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_BL.APPLICATION_LIST);
        }

      // rvApplicationList.setAdapter(null);
        balanceTransferApplicationAdapter = new BalanceTransferApplicationAdapter(BL_ApplicationFragment.this,mApplicationList);
        rvApplicationList.setAdapter(balanceTransferApplicationAdapter);

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

    public void redirectBLLoanApply(String ApplNum,int Type){
//        Intent intent=new Intent(getActivity(), BalanceTransferLoanApplyActivity.class);
//        intent.putExtra(Utility.HMLOAN_APPLICATION,ApplNum);
//        intent.putExtra("TypePage","HL");
//        startActivity(intent);
      //  HLBT,PLBT,LAPBT

        if (Integer.toString(Type).matches("5")) {
//home

            Intent intenthl=new Intent(getActivity(), BalanceTransferLoanApplyActivity.class);
            intenthl.putExtra(Utility.HMLOAN_APPLICATION,ApplNum);
            intenthl.putExtra("TypePage","HLBT");
            startActivity(intenthl);


        }else if (Integer.toString(Type).matches("14")) {
            //personal

            Intent intentpl=new Intent(getActivity(), BalanceTransferPersonalApplyActivity.class);
            intentpl.putExtra(Utility.PLLOAN_APPLICATION,ApplNum);
            intentpl.putExtra("TypePage","PLBT");
            startActivity(intentpl);

        } else if (Integer.toString(Type).matches("2")) {
            //lap
            Intent intenthl=new Intent(getActivity(), BalanceTransferLoanApplyActivity.class);
            intenthl.putExtra(Utility.HMLOAN_APPLICATION,ApplNum);
            intenthl.putExtra("TypePage","LAPBT");
            startActivity(intenthl);

        }


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
    public void callnumber(String mobNumber)
    {
        dialNumber(mobNumber);
    }
}
