package com.datacomp.magicfinmart.loan_fm.homeloan.addquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    RecyclerView rvQuotes;
    HLQuoteAdapter mAdapter;
    TextView  txtPropType , txtCostOfProp ,txtLoanTenure, txtOccupation, txtMonthlyIncome,txtExistEmi ,txtCount ,txtInputSummary ;
    CardView cvInputSummary ;
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

        txtInputSummary = (TextView) view.findViewById(R.id.txtInputSummary);
        txtPropType = (TextView) view.findViewById(R.id.txtPropType);
        txtCostOfProp = (TextView) view.findViewById(R.id.txtCostOfProp);
        txtLoanTenure = (TextView) view.findViewById(R.id.txtLoanTenure);
        txtOccupation = (TextView) view.findViewById(R.id.txtOccupation);
        txtMonthlyIncome = (TextView) view.findViewById(R.id.txtMonthlyIncome);
        txtExistEmi = (TextView) view.findViewById(R.id.txtExistEmi);
        txtCount = (TextView) view.findViewById(R.id.txtCount);
        cvInputSummary  = (CardView) view.findViewById(R.id.cvInputSummary );

        rvQuotes = (RecyclerView) view.findViewById(R.id.rvQuotes);
        rvQuotes.setLayoutManager(new LinearLayoutManager(getActivity()));

        Bundle bundle = getArguments();

        if (bundle != null) {
            getQuoteResponse = bundle.getParcelable(Constants.HOME_LOAN_QUOTES);
            homeLoanRequest = bundle.getParcelable(Constants.HL_REQUEST);
            if (getQuoteResponse != null) {
                txtInputSummary.setVisibility(View.VISIBLE);
                cvInputSummary.setVisibility(View.VISIBLE);

                mAdapter = new HLQuoteAdapter(getActivity(), getQuoteResponse.getData(),getQuoteResponse);
                rvQuotes.setAdapter(mAdapter);

                if(getQuoteResponse.getData().size() >0)
                {
                    txtCount.setText(""+getQuoteResponse.getData().size() + " Results from www.rupeeboss.com" );
                    txtCount.setVisibility(View.VISIBLE);
                }else{
                    txtCount.setText("");
                    txtCount.setVisibility(View.GONE);
                }

                if(homeLoanRequest != null)
                {

                   String strPropTyp =   getProperty(homeLoanRequest.getPropertyID());

                    txtPropType.setText(""+strPropTyp.toUpperCase() );
                    txtCostOfProp.setText(""+homeLoanRequest.getPropertyCost() );
                    txtLoanTenure.setText(""+homeLoanRequest.getLoanTenure() );

                    if(homeLoanRequest.getApplicantSource().equals("1"))
                    {
                        txtOccupation.setText("SALARIED" );
                    }else{
                        txtOccupation.setText("SELF-EMP" );
                    }

                    txtMonthlyIncome.setText(""+homeLoanRequest.getApplicantIncome() );
                    txtExistEmi.setText(""+homeLoanRequest.getApplicantObligations() );
                }

            }


        }



    }


    private String getProperty(String id)
    {
        String strProp = "";
        if(id.equals("1"))
        {
            strProp = "READY";
        }else if(id.equals("2"))
        {
            strProp = "UNDER CONS";
        }else if(id.equals("3"))
        {
            strProp = "SEARCHING";
        }else if(id.equals("4"))
        {
            strProp = "RESALE";
        }else if(id.equals("5"))
        {
            strProp = "FOR CONS";
        }else if(id.equals("5"))
        {
            strProp = "OTHER";
        }

        return strProp;

    }


}
