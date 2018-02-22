package com.datacomp.magicfinmart.loan_fm.personalloan.quote;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.personalloan.ActivityTabsPagerAdapter_PL;
import com.datacomp.magicfinmart.loan_fm.personalloan.PesonalLoan_QuoteAdapter;
import com.datacomp.magicfinmart.loan_fm.personalloan.addquote.PLMainActivity;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;

/**
 * Created by IN-RB on 12-01-2018.
 */

public class PL_QuoteFragment  extends BaseFragment  implements View.OnClickListener{

    public static final String FROM_QUOTEPL = "pl_from_quote";
    FloatingActionButton plAddQuote;

    RecyclerView rvQuoteList;
    PesonalLoan_QuoteAdapter pesonalLoan_QuoteAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    List<FmPersonalLoanRequest> mQuoteList;

    FmPersonalLoanRequest  removeQuoteEntity;

    ImageView ivSearch, ivAdd;
    TextView tvAdd, tvSearch;
    EditText etSearch;

    public PL_QuoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pl_quote, container, false);
        initView(view);
        setListener();
        mQuoteList = new ArrayList<>();
        if(getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_PL.QUOTE_LIST) != null)
        {
            mQuoteList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_PL.QUOTE_LIST);

        }
        pesonalLoan_QuoteAdapter = new PesonalLoan_QuoteAdapter(PL_QuoteFragment.this,mQuoteList);
        rvQuoteList.setAdapter(pesonalLoan_QuoteAdapter);
        return view;
    }

    private void initView(View view) {


        ivSearch = (ImageView) view.findViewById(R.id.ivSearch);
        ivAdd = (ImageView) view.findViewById(R.id.ivAdd);
        tvAdd = (TextView) view.findViewById(R.id.tvAdd);
        tvSearch = (TextView) view.findViewById(R.id.tvSearch);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);

        plAddQuote = (FloatingActionButton) view.findViewById(R.id.plAddQuote);

        rvQuoteList = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        rvQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvQuoteList.setLayoutManager(layoutManager);


        plAddQuote.setOnClickListener(this);
    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
    }

    public void redirectQuotePL(FmPersonalLoanRequest request){
        Intent intent=new Intent(getActivity(), PLMainActivity.class);
        intent.putExtra( FROM_QUOTEPL,request);
        startActivity(intent);

    }
    public void removeQuotePL(FmPersonalLoanRequest entity) {

        removeQuoteEntity = entity;
        showDialog("Please wait,Removing quote..");
        //  new QuoteApplicationController(getContext()).deleteQuote("" + entity.getVehicleRequestID(),this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.plAddQuote:
                startActivity(new Intent(getActivity(), PLMainActivity.class));
                break;
            case R.id.tvSearch:
            case R.id.ivSearch:
                if (etSearch.getVisibility() == View.INVISIBLE) {
                    etSearch.setVisibility(View.VISIBLE);
                    etSearch.requestFocus();
                }

                break;
            case R.id.ivAdd:
            case R.id.tvAdd:
                startActivity(new Intent(getActivity(), PLMainActivity.class));
                break;
        }
    }
}
