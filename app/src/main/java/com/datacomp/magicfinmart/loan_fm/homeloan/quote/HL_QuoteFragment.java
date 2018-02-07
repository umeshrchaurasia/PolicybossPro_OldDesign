package com.datacomp.magicfinmart.loan_fm.homeloan.quote;

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
import com.datacomp.magicfinmart.loan_fm.homeloan.ActivityTabsPagerAdapter_HL;
import com.datacomp.magicfinmart.loan_fm.homeloan.HomeLoan_QuoteAdapter;
import com.datacomp.magicfinmart.loan_fm.homeloan.addquote.HLMainActivity;


import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.LoanQuoteEntity;

/**
 * Created by IN-RB on 19-01-2018.
 */

public class HL_QuoteFragment extends BaseFragment implements View.OnClickListener{

    public static final String FROM_QUOTE = "from_quote";
    FloatingActionButton hlAddQuote;
    RecyclerView rvQuoteList;
    HomeLoan_QuoteAdapter homeLoan_QuoteAdapter;
    List<LoanQuoteEntity> mQuoteList;

    LoanQuoteEntity  removeQuoteEntity;

    public HL_QuoteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hl_quote, container, false);
        initView(view);

        mQuoteList = new ArrayList<>();
        if(getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_HL.QUOTE_LIST) != null)
        {
            mQuoteList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_HL.QUOTE_LIST);

        }
        homeLoan_QuoteAdapter = new HomeLoan_QuoteAdapter(HL_QuoteFragment.this,mQuoteList);
        rvQuoteList.setAdapter(homeLoan_QuoteAdapter);
        return view;
    }

    private void initView(View view) {
        hlAddQuote = (FloatingActionButton) view.findViewById(R.id.hlAddQuote);

        rvQuoteList = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        rvQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvQuoteList.setLayoutManager(layoutManager);


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
