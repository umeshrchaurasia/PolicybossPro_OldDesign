package com.datacomp.magicfinmart.loan_fm.personalloan.addquote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.PersonalQuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetPersonalLoanResponse;

public class PersonalLoanQuoteActivity extends AppCompatActivity {

    GetPersonalLoanResponse getPersonalLoanResponse;
    RecyclerView rvPLQuotes;

    PLQuoteAdapter mAdapter;
    PersonalLoanRequest personalLoanRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_loan_quote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getPersonalLoanResponse = getIntent().getParcelableExtra(Constants.PERSONAL_LOAN_QUOTES);
        rvPLQuotes = (RecyclerView) findViewById(R.id.rvPLQuotes);
        mAdapter = new PLQuoteAdapter(PersonalLoanQuoteActivity.this, getPersonalLoanResponse.getData());
        rvPLQuotes.setAdapter(mAdapter);
        rvPLQuotes.setLayoutManager(new LinearLayoutManager(this));
        personalLoanRequest = getIntent().getParcelableExtra(Constants.PL_REQUEST);
    }
    public void redirectToApplyLoan(PersonalQuoteEntity entity) {
//

//        startActivity(new Intent(this, PersonalLoanApplyActivity.class)
//                .putExtra("PL", entity)
//                .putExtra("PL_URL", getPersonalLoanResponse.getUrl())
//                .putExtra("PL_QUOTE_ID", getPersonalLoanResponse.getQuote_id()));
    }
}
