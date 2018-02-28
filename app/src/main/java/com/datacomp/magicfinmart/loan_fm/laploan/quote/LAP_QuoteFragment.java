package com.datacomp.magicfinmart.loan_fm.laploan.quote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import com.datacomp.magicfinmart.loan_fm.laploan.ActivityTabsPagerAdapter_LAP;
import com.datacomp.magicfinmart.loan_fm.laploan.LapLoan_QuoteAdapter;
import com.datacomp.magicfinmart.loan_fm.laploan.addquote.LAPMainActivity;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;

/**
 * Created by IN-RB on 22-01-2018.
 */

public class LAP_QuoteFragment  extends BaseFragment implements View.OnClickListener{
    public static final String FROM_QUOTE = "hl_from_quote";
    FloatingActionButton lapAddQuote;

    RecyclerView rvQuoteList;
    LapLoan_QuoteAdapter lapLoan_QuoteAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    List<FmHomeLoanRequest> mQuoteList;
    FmHomeLoanRequest  removeQuoteEntity;

    ImageView ivSearch, ivAdd;
    TextView tvAdd, tvSearch;
    EditText etSearch;
    public LAP_QuoteFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lap_quote, container, false);
        initView(view);
        setListener();
        mQuoteList = new ArrayList<>();
        if(getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_LAP.QUOTE_LIST) != null)
        {
            mQuoteList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_LAP.QUOTE_LIST);

        }

        lapLoan_QuoteAdapter = new LapLoan_QuoteAdapter(LAP_QuoteFragment.this,mQuoteList);
        rvQuoteList.setAdapter(lapLoan_QuoteAdapter);
        return view;
    }

    private void initView(View view) {

        ivSearch = (ImageView) view.findViewById(R.id.ivSearch);
        ivAdd = (ImageView) view.findViewById(R.id.ivAdd);
        tvAdd = (TextView) view.findViewById(R.id.tvAdd);
        tvSearch = (TextView) view.findViewById(R.id.tvSearch);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);

        lapAddQuote = (FloatingActionButton) view.findViewById(R.id.lapAddQuote);

        rvQuoteList = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        rvQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvQuoteList.setLayoutManager(layoutManager);


        lapAddQuote.setOnClickListener(this);
    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
    }

    public void redirectQuoteHL(FmHomeLoanRequest request){
        Intent intent=new Intent(getActivity(), LAPMainActivity.class);
        intent.putExtra( FROM_QUOTE,request);
        startActivity(intent);

    }

    public void removeQuote(FmHomeLoanRequest entity) {

        removeQuoteEntity = entity;
        showDialog("Please wait,Removing quote..");
        //  new QuoteApplicationController(getContext()).deleteQuote("" + entity.getVehicleRequestID(),this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lapAddQuote:
                startActivity(new Intent(getActivity(), LAPMainActivity.class));
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
                startActivity(new Intent(getActivity(), LAPMainActivity.class));
                break;
        }
    }
    public void callnumber(String mobNumber)
    {
        dialNumber(mobNumber);
    }
}
