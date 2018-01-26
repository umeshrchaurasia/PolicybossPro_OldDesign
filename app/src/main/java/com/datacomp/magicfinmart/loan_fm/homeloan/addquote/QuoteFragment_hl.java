package com.datacomp.magicfinmart.loan_fm.homeloan.addquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.QuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.HomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetQuoteResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment_hl extends Fragment {
    GetQuoteResponse getQuoteResponse;
    HomeLoanRequest homeLoanRequest;
    Toolbar toolbar;
    RecyclerView rvQuotes;
    HLQuoteAdapter mAdapter;


    public QuoteFragment_hl() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.content_home_loan_quote, container, false);
        initialise_widget(view);



        return view;
    }
    public void redirectToApplyLoan(QuoteEntity entity) {

//        startActivity(new Intent(this, HomeLoanApplyActivity.class)
//                .putExtra("QUOTE_ENTITY", entity)
//                .putExtra("URL", getQuoteResponse.getUrl())
//                .putExtra("QUOTE_ID", getQuoteResponse.getQuote_id())
//        );
    }

    private void initialise_widget(View view) {

        rvQuotes = (RecyclerView) view.findViewById(R.id.rvQuotes);
        rvQuotes.setLayoutManager(new LinearLayoutManager(getActivity()));

        Bundle bundle = getArguments();

        if (bundle != null) {
            getQuoteResponse = bundle.getParcelable(Constants.HOME_LOAN_QUOTES);
            homeLoanRequest = bundle.getParcelable(Constants.HL_REQUEST);
            if (getQuoteResponse != null) {

                mAdapter = new HLQuoteAdapter(getActivity(), getQuoteResponse.getData());
                rvQuotes.setAdapter(mAdapter);
            }
        }



    }


}
