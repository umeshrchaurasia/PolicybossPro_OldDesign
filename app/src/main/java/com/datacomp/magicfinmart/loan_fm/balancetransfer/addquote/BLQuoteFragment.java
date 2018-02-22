package com.datacomp.magicfinmart.loan_fm.balancetransfer.addquote;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import com.datacomp.magicfinmart.utility.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BLEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BLSavingEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.PersonalQuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BLLoanRequest;



public class BLQuoteFragment extends Fragment {

    RecyclerView rvBLQuotes;
    TextView txtAppName, txtLoanAmnt, txtLoanTenure, txtInputSummry, txtCount;
    BLQuoteAdapter mAdapter;
    List<BLEntity> BlListdata;
    List<BLSavingEntity> BlsavingEntity;
    CardView cvInputSummary;
    BLLoanRequest blLoanRequest;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_bl_loan_quote, container, false);
        initialize(view);
        return view;
    }

    private void initialize(View view) {

        cvInputSummary = (CardView) view.findViewById(R.id.cvInputSummary);

        txtInputSummry = (TextView) view.findViewById(R.id.txtInputSummry);
        txtAppName = (TextView) view.findViewById(R.id.txtAppName);
        txtLoanAmnt = (TextView) view.findViewById(R.id.txtLoanAmnt);
        txtLoanTenure = (TextView) view.findViewById(R.id.txtLoanTenure);
        txtCount = (TextView) view.findViewById(R.id.txtCount);

        rvBLQuotes = (RecyclerView) view.findViewById(R.id.rvbLQuotes);
        rvBLQuotes.setLayoutManager(new LinearLayoutManager(getActivity()));

        Bundle bundle = getArguments();

        if (bundle != null) {
            BlListdata = bundle.getParcelableArrayList(Constants.BL_LOAN_QUOTES);
            //  BlsavingEntity = bundle.getParcelableArrayList(Constants.BL_LOAN_SERVICE);
            blLoanRequest = bundle.getParcelable(Constants.BL_REQUEST);
            if (BlListdata != null) {
                txtInputSummry.setVisibility(View.VISIBLE);
                cvInputSummary.setVisibility(View.VISIBLE);

                mAdapter = new BLQuoteAdapter(getActivity(), BlListdata, blLoanRequest);
                rvBLQuotes.setAdapter(mAdapter);

                if (BlListdata.size() > 0) {
                    txtCount.setText("" + BlListdata.size() + "Results from www.rupeeboss.com");
                    txtCount.setVisibility(View.VISIBLE);
                } else {
                    txtCount.setText("");
                    txtCount.setVisibility(View.GONE);
                }

                if (blLoanRequest != null) {
                    //    txtAppName.setText(""+blLoanRequest.getApplicantNme().toUpperCase() );
                    txtLoanAmnt.setText("" + blLoanRequest.getLoanamount());
                    txtLoanTenure.setText("" + blLoanRequest.getLoanterm());
                    txtAppName.setText("" + blLoanRequest.getApplicantName());
                    ;
                }
            }
        }
    }

    public void redirectToApplyLoan(PersonalQuoteEntity entity) {

    }
}
