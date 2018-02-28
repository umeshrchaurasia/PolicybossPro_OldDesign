package com.datacomp.magicfinmart.loan_fm.homeloan.quote;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.homeloan.ActivityTabsPagerAdapter_HL;
import com.datacomp.magicfinmart.loan_fm.homeloan.HomeLoan_QuoteAdapter;
import com.datacomp.magicfinmart.loan_fm.homeloan.addquote.HLMainActivity;


import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;

/**
 * Created by IN-RB on 19-01-2018.
 */

public class HL_QuoteFragment extends BaseFragment implements View.OnClickListener{

    public static final String FROM_QUOTE = "hl_from_quote";
    FloatingActionButton hlAddQuote;
    RecyclerView rvQuoteList;
    HomeLoan_QuoteAdapter homeLoan_QuoteAdapter;
    List<FmHomeLoanRequest> mQuoteList;

    FmHomeLoanRequest  removeQuoteEntity;

    ImageView ivSearch, ivAdd;
    TextView tvAdd, tvSearch;
    EditText etSearch;

    public HL_QuoteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hl_quote, container, false);
        initView(view);
        setListener();
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

        ivSearch = (ImageView) view.findViewById(R.id.ivSearch);
        ivAdd = (ImageView) view.findViewById(R.id.ivAdd);
        tvAdd = (TextView) view.findViewById(R.id.tvAdd);
        tvSearch = (TextView) view.findViewById(R.id.tvSearch);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);

        hlAddQuote = (FloatingActionButton) view.findViewById(R.id.hlAddQuote);

        rvQuoteList = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        rvQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvQuoteList.setLayoutManager(layoutManager);


        hlAddQuote.setOnClickListener(this);
    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
    }

    public void redirectQuoteHL(FmHomeLoanRequest request){
        Intent intent=new Intent(getActivity(), HLMainActivity.class);
        intent.putExtra( FROM_QUOTE,request);
        startActivity(intent);

    }
    public void removeQuoteHL(FmHomeLoanRequest entity) {

        removeQuoteEntity = entity;
        showDialog("Please wait,Removing quote..");
      //  new QuoteApplicationController(getContext()).deleteQuote("" + entity.getVehicleRequestID(),this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hlAddQuote:
                startActivity(new Intent(getActivity(), HLMainActivity.class));
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
                startActivity(new Intent(getActivity(), HLMainActivity.class));
                break;
        }
    }
    public void callnumber(String mobNumber)
    {
        dialNumber(mobNumber);
    }
}
