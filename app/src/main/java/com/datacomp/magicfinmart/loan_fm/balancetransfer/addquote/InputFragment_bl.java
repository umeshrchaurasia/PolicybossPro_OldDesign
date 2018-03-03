package com.datacomp.magicfinmart.loan_fm.balancetransfer.addquote;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.personalloan.PersonalLoanController;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BLLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmBalanceLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetBLDispalyResponse;

public class InputFragment_bl extends BaseFragment implements View.OnClickListener{


    DBPersistanceController databaseController;

    EditText etOutstanding, etCurrInc, ettenureyrs,etNameOfApplicant,etcontact;
    RadioGroup rgloantype;
    RadioButton rbimghl, rbimgpl,rbimglap;

    LoginResponseEntity loginEntity;
    GetBLDispalyResponse getblDispalyLoanResponse;
    BLLoanRequest blLoanRequest;
    FmBalanceLoanRequest fmBalanceLoanRequest;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Button btnGetQuote;

    Context mContext;


    public InputFragment_bl() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_add_blquote, container, false);

        init_widgets(view);

        databaseController = new DBPersistanceController(getActivity());
        loginEntity = databaseController.getUserData();
        setListener();

        if (getArguments() != null) {
            if (getArguments().getParcelable(BLMainActivity.BL_INPUT_REQUEST) != null) {
                fmBalanceLoanRequest = getArguments().getParcelable(BLMainActivity.BL_INPUT_REQUEST);
                blLoanRequest = fmBalanceLoanRequest.getBLLoanRequest();
                fillCustomerDetails();


            }
        } else {
            fmBalanceLoanRequest = new FmBalanceLoanRequest();
            fmBalanceLoanRequest.setFBA_id(new DBPersistanceController(getContext()).getUserData().getFBAId());
            fmBalanceLoanRequest.setBalanceTransferId(0);
            blLoanRequest = new BLLoanRequest();
            fmBalanceLoanRequest.setBLLoanRequest(blLoanRequest);
        }
        return view;
    }

    private void init_widgets(View view) {

        btnGetQuote = (Button) view.findViewById(R.id.btnGetQuote);
        //endregion
        //region Property Initialize
        etOutstanding = (EditText) view.findViewById(R.id.etOutstanding);

        etCurrInc = (EditText) view.findViewById(R.id.etCurrInc);

        ettenureyrs = (EditText) view.findViewById(R.id.ettenureyrs);

        etNameOfApplicant = (EditText) view.findViewById(R.id.etNameOfApplicant);
        etcontact = (EditText) view.findViewById(R.id.etcontact);


//        llSalaried = (LinearLayout) view.findViewById(R.id.llSalaried);

        rgloantype = (RadioGroup) view.findViewById(R.id.rgloantype);
        rbimghl = (RadioButton) view.findViewById(R.id.rbimghl);
        rbimgpl = (RadioButton) view.findViewById(R.id.rbimgpl);
        rbimglap = (RadioButton) view.findViewById(R.id.rbimglap);

    }

    private void setApplicantDetails() {
        // region  HomeLoanRequest Binding

        blLoanRequest = fmBalanceLoanRequest.getBLLoanRequest();
        blLoanRequest.setLoanamount( Double.parseDouble(etOutstanding.getText().toString()));
        blLoanRequest.setLoanterm(Double.parseDouble(ettenureyrs.getText().toString()));
        blLoanRequest.setLoaninterest(Double.parseDouble(etCurrInc.getText().toString()));
        blLoanRequest.setApplicantName(etNameOfApplicant.getText().toString());

        blLoanRequest.setContact(etcontact.getText().toString());


        if (rbimghl.isChecked()) {
            blLoanRequest.setProduct_id(12);//hl
        } else if (rbimgpl.isChecked()) {
            blLoanRequest.setProduct_id(9);//pl
        }else if (rbimglap.isChecked()) {
            blLoanRequest.setProduct_id(7);//lap
        }
        blLoanRequest.setbrokerid(Integer.parseInt(loginEntity.getLoanId()));
        blLoanRequest.setLoanID(Integer.parseInt(loginEntity.getLoanId()));

        blLoanRequest.setSource("Demo APP");
        blLoanRequest.setEmail("");
        //endregion
    }

    private void fillCustomerDetails() {

        Log.d("DETAILS", blLoanRequest.toString());

        try {

            etOutstanding.setText("" + blLoanRequest.getLoanamount());

            ettenureyrs.setText("" + blLoanRequest.getLoanterm());

            etCurrInc.setText("" + blLoanRequest.getLoaninterest());


            if (blLoanRequest.getApplicantName() != null)
                etNameOfApplicant.setText(blLoanRequest.getApplicantName());

            if (blLoanRequest.getContact() != null)
                etcontact.setText(blLoanRequest.getContact());

            if (Integer.toString(blLoanRequest.getProduct_id()).matches("12")) {
                rbimghl.setChecked(true);
            } else if (Integer.toString(blLoanRequest.getProduct_id()).matches("9")) {
                rbimgpl.setChecked(true);
            } else if (Integer.toString(blLoanRequest.getProduct_id()).matches("7")) {
                rbimglap.setChecked(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setListener() {
        btnGetQuote.setOnClickListener(this);
}



    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnGetQuote) {
            //region Validation
            //region Property Validation
            String Outstanding = etOutstanding.getText().toString();
            String CurrInc = etCurrInc.getText().toString();
            String TenureInYear = ettenureyrs.getText().toString();
            String Name = etNameOfApplicant.getText().toString();
            String Contact  = etcontact.getText().toString();
            if (TextUtils.isEmpty(Name)) {

                etNameOfApplicant.setError("Please Enter Name Of Applicant.");
                etNameOfApplicant.requestFocus();
                return;

            }
            if (TextUtils.isEmpty(Contact)) {


            }
            else {
                if (Contact.length()<10) {

                    etcontact.setError("Please Enter 10 digit Mobile Number.");
                    etcontact.requestFocus();
                    return;

                }

            }


            if (TextUtils.isEmpty(Outstanding)) {

                etOutstanding.setError("Please Enter Outstanding Amount.");
                etOutstanding.requestFocus();
                return;

            }
            if (TextUtils.isEmpty(CurrInc)) {

                etOutstanding.setError("Please Enter Curr Int Rate.");
                etOutstanding.requestFocus();
                return;

            }
            if (Double.parseDouble(CurrInc) > 100) {

                etCurrInc.setError("Please Check  Curr Int Rate.");
                etCurrInc.requestFocus();
                return;

            }
            if (TextUtils.isEmpty(TenureInYear)) {

                ettenureyrs.setError("Please Enter Tenure (yrs).");
                ettenureyrs.requestFocus();
                return;

            }
            if (Double.parseDouble(TenureInYear) > 100) {

                ettenureyrs.setError("Please Check Loan Tenure Year.");
                ettenureyrs.requestFocus();
                return;

            }

            //endregion


            // endregion
            setApplicantDetails();
           // showDialog();
          //  new PersonalLoanController(getActivity()).getBLQuote(blLoanRequest, this);
            ((BLMainActivity) getActivity()).getQuoteParameterBundle(fmBalanceLoanRequest);

        }

    }




    //endegion

//    @Override
//    public void OnSuccess(APIResponse response, String message) {
//
//        cancelDialog();
//        if (response instanceof GetBLDispalyResponse) {
//            if (((GetBLDispalyResponse) response).getStatusbl() == 0) {
//
////                ((BLMainActivity)mContext).setQuoteCheck();
////
////                getBLDispalyLoanResponse = ((GetBLDispalyResponse) response);
////
////                Bundle bundle = new Bundle();
////                bundle.putParcelable(Constants.BL_LOAN_QUOTES, getBLDispalyLoanResponse);
////                QuoteFragment_bl quoteFragment = new QuoteFragment_bl();
////                quoteFragment.setArguments(bundle);
////                FragmentTransaction transaction_quote = getActivity().getSupportFragmentManager().beginTransaction();
////                transaction_quote.replace(R.id.frame_layout, quoteFragment, "QUOTE");
////                transaction_quote.addToBackStack("QUOTE");
////                transaction_quote.show(quoteFragment);
////                //  transaction_quote.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
////                transaction_quote.commit();
//
//
//                Toast.makeText(getActivity(), "bbbbbbbbbllllllllll", Toast.LENGTH_SHORT).show();
//
//            } else {
//                Toast.makeText(getActivity(), response.getMsg(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

//    @Override
//    public void OnSuccess(APIResponse response, String message) {

//        cancelDialog();
//        if (response instanceof GetBLDispalyResponse) {
//            if (((GetBLDispalyResponse) response).getStatus() == 1) {
//
//                ((BLMainActivity)mContext).setQuoteCheck();
//
//                getBLDispalyLoanResponse = ((GetBLDispalyResponse) response);
//
//                Bundle bundle = new Bundle();
//                bundle.putParcelable(Constants.BL_LOAN_SERVICE, getBLDispalyLoanResponse.getSaving());
//                bundle.putParcelable(Constants.BL_REQUEST, blLoanRequest);
//                bundle.putParcelableArrayList(Constants.BL_LOAN_QUOTES, (ArrayList<BLEntity>) getBLDispalyLoanResponse.getData());
//
//                QuoteFragment_bl quoteFragment = new QuoteFragment_bl();
//                quoteFragment.setArguments(bundle);
//                FragmentTransaction transaction_quote = getActivity().getSupportFragmentManager().beginTransaction();
//                transaction_quote.replace(R.id.frame_layout, quoteFragment, "QUOTE");
//                transaction_quote.addToBackStack("QUOTE");
//                transaction_quote.show(quoteFragment);
//                //  transaction_quote.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                transaction_quote.commit();
////
//            }
//        }

//    }
//
//    @Override
//    public void OnFailure(Throwable t) {
//        cancelDialog();
//        Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
//    }


}
