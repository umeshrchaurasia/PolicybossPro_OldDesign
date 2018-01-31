package com.datacomp.magicfinmart.loan_fm.homeloan.quote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.homeloan.HomeLoan_QuoteAdapter;
import com.datacomp.magicfinmart.loan_fm.homeloan.addquote.HLMainActivity;


import java.text.SimpleDateFormat;

/**
 * Created by IN-RB on 19-01-2018.
 */

public class HL_QuoteFragment extends BaseFragment implements View.OnClickListener{
    FloatingActionButton hlAddQuote;

    RecyclerView rvQuoteList;
    HomeLoan_QuoteAdapter homeLoan_QuoteAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public HL_QuoteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hl_quote, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        hlAddQuote = (FloatingActionButton) view.findViewById(R.id.hlAddQuote);

        rvQuoteList = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        rvQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvQuoteList.setLayoutManager(layoutManager);

        homeLoan_QuoteAdapter = new HomeLoan_QuoteAdapter(getActivity());
        rvQuoteList.setAdapter(homeLoan_QuoteAdapter);
        hlAddQuote.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hlAddQuote:
                startActivity(new Intent(getActivity(), HLMainActivity.class));
                break;
        }
    }
}
