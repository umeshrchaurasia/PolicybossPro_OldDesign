package com.datacomp.magicfinmart.loan_fm.laploan.addquote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.homeloan.addquote.HLQuoteAdapter;
import com.datacomp.magicfinmart.loan_fm.homeloan.addquote.HomeLoanQuoteActivity;
import com.datacomp.magicfinmart.utility.Constants;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.QuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.HomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetQuoteResponse;

public class LapLoanQuoteActivity extends AppCompatActivity {

    GetQuoteResponse getQuoteResponse;
    HomeLoanRequest homeLoanRequest;
    Toolbar toolbar;
    RecyclerView rvQuotes;
    LAPQuoteAdapter mAdapter;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap_loan_quote);
        initialise_widget();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getQuoteResponse = getIntent().getParcelableExtra(Constants.QUOTES);
        homeLoanRequest = getIntent().getParcelableExtra(Constants.HL_REQUEST);
        mAdapter = new LAPQuoteAdapter(LapLoanQuoteActivity.this, getQuoteResponse.getData());
        rvQuotes.setAdapter(mAdapter);
    }
    public void redirectToApplyLoan(QuoteEntity entity) {

//        startActivity(new Intent(this, HomeLoanApplyActivity.class)
//                .putExtra("QUOTE_ENTITY", entity)
//                .putExtra("URL", getQuoteResponse.getUrl())
//                .putExtra("QUOTE_ID", getQuoteResponse.getQuote_id())
//        );
    }
    private void initialise_widget() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rvQuotes = (RecyclerView) findViewById(R.id.rvQuotes);
        rvQuotes.setLayoutManager(new LinearLayoutManager(LapLoanQuoteActivity.this));

    }
}