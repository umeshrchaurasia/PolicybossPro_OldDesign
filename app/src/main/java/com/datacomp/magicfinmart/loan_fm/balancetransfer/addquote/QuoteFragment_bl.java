package com.datacomp.magicfinmart.loan_fm.balancetransfer.addquote;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.loan_apply.BTLoanApplyWebView;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.mainloan.MainLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.personalloan.PersonalLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BLEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BLSavingEntity;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BLLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmBalanceLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmSaveQuoteBLResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetBLDispalyResponse;

public class QuoteFragment_bl extends BaseFragment implements View.OnClickListener, IResponseSubcriber, IResponseSubcriberFM {

    TextView txtAppName, txtLoanAmnt, txtLoanTenure, txtInputSummry, txtCount,txtType,txtcontact;
    TextView txtcurrloanemi,txtdropemi,txtnewemi,txtdropinterestrate,txtreducedintrest;
    BLQuoteAdapter mAdapter;
    List<BLEntity> BlListdata;
    List<BLSavingEntity> BlsavingEntity;
    CardView cvInputSummary;

    RecyclerView rvBLQuotes;
    int LoanRequireID = 0;
    int BalanceTransferId = 0;

    GetBLDispalyResponse getblDispalyResponse ;
    BLLoanRequest blLoanRequest;
    FmBalanceLoanRequest fmBalanceLoanRequest;
    LinearLayout ivllEdit;
    public QuoteFragment_bl() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_bl_loan_quote, container, false);
        initialise_widget(view);
        if (getArguments() != null) {
            fmBalanceLoanRequest = getArguments().getParcelable(BLMainActivity.BL_QUOTE_REQUEST);
            blLoanRequest = fmBalanceLoanRequest.getBLLoanRequest();
            showDialog("Wait..,Fetching quote");
            new PersonalLoanController(getActivity()).getBLQuote(blLoanRequest, this);
        }
        return view;
    }

    private void initialise_widget(View view) {

        cvInputSummary = (CardView) view.findViewById(R.id.cvInputSummary);

        txtInputSummry = (TextView) view.findViewById(R.id.txtInputSummry);
        txtAppName = (TextView) view.findViewById(R.id.txtAppName);
        txtLoanAmnt = (TextView) view.findViewById(R.id.txtLoanAmnt);
        txtLoanTenure = (TextView) view.findViewById(R.id.txtLoanTenure);
        txtCount = (TextView) view.findViewById(R.id.txtCount);
        txtType = (TextView) view.findViewById(R.id.txtType);
        txtcontact = (TextView) view.findViewById(R.id.txtcontact);

        txtcurrloanemi = (TextView) view.findViewById(R.id.txtcurrloanemi);
        txtdropemi = (TextView) view.findViewById(R.id.txtdropemi);
        txtnewemi = (TextView) view.findViewById(R.id.txtnewemi);
        txtdropinterestrate = (TextView) view.findViewById(R.id.txtdropinterestrate);
        txtreducedintrest = (TextView) view.findViewById(R.id.txtreducedintrest);


        ivllEdit = (LinearLayout) view.findViewById(R.id.ivllEdit);
        ivllEdit.setOnClickListener(this);
        rvBLQuotes = (RecyclerView) view.findViewById(R.id.rvbLQuotes);
        rvBLQuotes.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvBLQuotes.setNestedScrollingEnabled(false);

    }
    public void quoteToApp() {
        //quote to application conversion
        //TODO : USE : LoanRequireID and "A"
    }

    public void redirectToApplyLoan(BLEntity entity,String url, int id) {
        startActivity(new Intent(getActivity(), BTLoanApplyWebView.class)
                .putExtra("BL", entity)
                .putExtra("BL_Req", blLoanRequest)
                .putExtra("BL_QUOTE_ID", id));
    }

    private void bindQuotes() {

        if (getblDispalyResponse != null) {
            txtInputSummry.setVisibility(View.VISIBLE);
            cvInputSummary.setVisibility(View.VISIBLE);

            mAdapter = new BLQuoteAdapter(this, getblDispalyResponse.getData(),getblDispalyResponse,blLoanRequest.getLoanamount());
            rvBLQuotes.setAdapter(mAdapter);

            if(getblDispalyResponse.getData().size() >0)
            {
                txtCount.setText(""+getblDispalyResponse.getData().size() + " Results from www.rupeeboss.com" );
                txtCount.setVisibility(View.VISIBLE);
            }else{
                txtCount.setText("");
                txtCount.setVisibility(View.GONE);
            }

            if(blLoanRequest != null)
            {
                try {
                    txtAppName.setText(""+blLoanRequest.getApplicantName().toUpperCase() );
                    txtLoanAmnt.setText(""+blLoanRequest.getLoanamount() );
                    txtLoanTenure.setText(""+blLoanRequest.getLoanterm() + " Years" );

                    if (Integer.toString(blLoanRequest.getProduct_id()).matches("12")) {
                        txtType.setText("HOME LOAN");
                    } else if (Integer.toString(blLoanRequest.getProduct_id()).matches("9")) {
                        txtType.setText("PERSONAL LOAN");
                    } else if (Integer.toString(blLoanRequest.getProduct_id()).matches("7")) {
                        txtType.setText("LAP");
                    }

                    txtcontact.setText(""+blLoanRequest.getContact() );


//                    txtcurrloanemi.setText(""+blLoanRequest.get() );
//                    txtdropemi.setText(""+blLoanRequest.getContact() );
//                    txtnewemi.setText(""+blLoanRequest.getContact() );
//                    txtdropinterestrate.setText(""+blLoanRequest.getContact() );
//                    txtreducedintrest.setText(""+blLoanRequest.getContact() );

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

    }


    private void setFmBLoanRequest(int QuoteID) {

        showDialog();
        blLoanRequest.setQuote_id(QuoteID);
        fmBalanceLoanRequest.setBLLoanRequest(blLoanRequest);
        new MainLoanController(getActivity()).saveBLQuoteData(fmBalanceLoanRequest, this);

    }

    @Override
    public void OnSuccessFM(APIResponseFM response, String message) {
        cancelDialog();
        if (response instanceof FmSaveQuoteBLResponse) {
            if (response.getStatusNo() == 0) {
                LoanRequireID = ((FmSaveQuoteBLResponse) response).getMasterData().get(0).getLoanRequestID();
                fmBalanceLoanRequest.setBalanceTransferId(LoanRequireID);
                ((BLMainActivity) getActivity()).updateRequest(fmBalanceLoanRequest, true);

            }
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof GetBLDispalyResponse) {
            if (response.getStatus_Id() == 0) {

                getblDispalyResponse = ((GetBLDispalyResponse) response);

                bindQuotes();
                setFmBLoanRequest(getblDispalyResponse.getQuote_id());

            } else {
                Toast.makeText(getActivity(), response.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ivllEdit) {
            ((BLMainActivity) getActivity()).redirectInput(fmBalanceLoanRequest);
        }
    }
}
