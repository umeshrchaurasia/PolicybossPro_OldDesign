package com.datacomp.magicfinmart.loan_fm.laploan.quote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.laploan.LapLoan_QuoteAdapter;
import com.datacomp.magicfinmart.loan_fm.laploan.addquote.LAPMainActivity;


import java.text.SimpleDateFormat;

/**
 * Created by IN-RB on 22-01-2018.
 */

public class LAP_QuoteFragment  extends BaseFragment implements View.OnClickListener{
    FloatingActionButton lapAddQuote;

    RecyclerView rvQuoteList;
    LapLoan_QuoteAdapter lapLoan_QuoteAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public LAP_QuoteFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lap_quote, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        lapAddQuote = (FloatingActionButton) view.findViewById(R.id.lapAddQuote);

        rvQuoteList = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        rvQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvQuoteList.setLayoutManager(layoutManager);

        lapLoan_QuoteAdapter = new LapLoan_QuoteAdapter(getActivity());
        rvQuoteList.setAdapter(lapLoan_QuoteAdapter);
        lapAddQuote.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lapAddQuote:
                startActivity(new Intent(getActivity(), LAPMainActivity.class));
                break;
        }
    }
}
