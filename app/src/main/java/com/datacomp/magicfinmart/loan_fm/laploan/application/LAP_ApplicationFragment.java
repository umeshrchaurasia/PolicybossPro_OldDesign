package com.datacomp.magicfinmart.loan_fm.laploan.application;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.laploan.LapLoanApplicationAdapter;

/**
 * Created by IN-RB on 22-01-2018.
 */

public class LAP_ApplicationFragment extends BaseFragment {
    RecyclerView rvApplicationList;
    LapLoanApplicationAdapter lapLoanApplicationAdapter;

    public LAP_ApplicationFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hl_application, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rvApplicationList = (RecyclerView) view.findViewById(R.id.rvApplicationList);
        rvApplicationList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvApplicationList.setLayoutManager(layoutManager);

        lapLoanApplicationAdapter = new LapLoanApplicationAdapter(getActivity());
        rvApplicationList.setAdapter(lapLoanApplicationAdapter);
    }
}
