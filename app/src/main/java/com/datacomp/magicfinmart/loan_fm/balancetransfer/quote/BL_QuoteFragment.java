package com.datacomp.magicfinmart.loan_fm.balancetransfer.quote;


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
import com.datacomp.magicfinmart.loan_fm.balancetransfer.BalanceTransfer_QuoteAdapter;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.addquote.BLMainActivity;
import com.datacomp.magicfinmart.loan_fm.personalloan.PesonalLoan_QuoteAdapter;
import com.datacomp.magicfinmart.loan_fm.personalloan.addquote.PLMainActivity;

import java.text.SimpleDateFormat;


public class BL_QuoteFragment extends BaseFragment implements View.OnClickListener{

    FloatingActionButton blAddQuote;

    RecyclerView rvQuoteList;
    BalanceTransfer_QuoteAdapter balanceTransfer_QuoteAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public BL_QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bl__quote, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        blAddQuote = (FloatingActionButton) view.findViewById(R.id.blAddQuote);

        rvQuoteList = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        rvQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvQuoteList.setLayoutManager(layoutManager);

        balanceTransfer_QuoteAdapter = new BalanceTransfer_QuoteAdapter(getActivity());
        rvQuoteList.setAdapter(balanceTransfer_QuoteAdapter);
        blAddQuote.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blAddQuote:
                startActivity(new Intent(getActivity(), BLMainActivity.class));
                break;
        }
    }
}
