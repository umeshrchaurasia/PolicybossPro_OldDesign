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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.ActivityTabsPagerAdapter_BL;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.BalanceTransfer_QuoteAdapter;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.addquote.BLMainActivity;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmBalanceLoanRequest;


public class BL_QuoteFragment extends BaseFragment implements View.OnClickListener{
    public static final String FROM_QUOTEBL = "bl_from_quote";
    FloatingActionButton blAddQuote;

    RecyclerView rvQuoteList;
    BalanceTransfer_QuoteAdapter balanceTransfer_QuoteAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    List<FmBalanceLoanRequest> mQuoteList;

    FmBalanceLoanRequest  removeQuoteEntity;

    ImageView ivSearch, ivAdd;
    TextView tvAdd, tvSearch;
    EditText etSearch;
    public BL_QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bl__quote, container, false);
        initView(view);
        setListener();
        mQuoteList = new ArrayList<>();
        if(getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_BL.QUOTE_LIST) != null)
        {
            mQuoteList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter_BL.QUOTE_LIST);

        }
        balanceTransfer_QuoteAdapter = new BalanceTransfer_QuoteAdapter(BL_QuoteFragment.this,mQuoteList);
        rvQuoteList.setAdapter(balanceTransfer_QuoteAdapter);
        return view;
    }

    private void initView(View view) {
        blAddQuote = (FloatingActionButton) view.findViewById(R.id.blAddQuote);

        ivSearch = (ImageView) view.findViewById(R.id.ivSearch);
        ivAdd = (ImageView) view.findViewById(R.id.ivAdd);
        tvAdd = (TextView) view.findViewById(R.id.tvAdd);
        tvSearch = (TextView) view.findViewById(R.id.tvSearch);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);



        rvQuoteList = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        rvQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvQuoteList.setLayoutManager(layoutManager);


        blAddQuote.setOnClickListener(this);
    }


    private void setListener() {
        ivSearch.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
    }

    public void redirectQuoteBL(FmBalanceLoanRequest request){
        Intent intent=new Intent(getActivity(), BLMainActivity.class);
        intent.putExtra( FROM_QUOTEBL,request);
        startActivity(intent);

    }
    public void removeQuoteBL(FmBalanceLoanRequest entity) {

        removeQuoteEntity = entity;
        showDialog("Please wait,Removing quote..");
        //  new QuoteApplicationController(getContext()).deleteQuote("" + entity.getVehicleRequestID(),this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blAddQuote:
                startActivity(new Intent(getActivity(), BLMainActivity.class));
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
                startActivity(new Intent(getActivity(), BLMainActivity.class));
                break;
        }
    }
}
