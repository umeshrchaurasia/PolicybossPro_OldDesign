package com.datacomp.magicfinmart.loan_fm.homeloan.addquote;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.homeloan.application.HomeLoanApplyWebView;
import com.datacomp.magicfinmart.utility.Constants;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.homeloan.HomeLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.mainloan.MainLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.QuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BankSaveRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.HomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.BankForNodeResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmSaveQuoteHomeLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetQuoteResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment_hl extends BaseFragment implements View.OnClickListener, IResponseSubcriber, IResponseSubcriberFM {

    private static String INPUT_FRAGMENT = "input";

    GetQuoteResponse getQuoteResponse;

    HomeLoanRequest homeLoanRequest;
    RecyclerView rvQuotes;
    HLQuoteAdapter mAdapter;
    TextView txtPropertyType, txtCostOfProp, txtLoanTenure, txtOccupation, txtMonthlyIncome, txtExistEmi, txtCount, txtInputSummary;
    CardView cvInputSummary;

    LinearLayout ivllEdit;
    Fragment tabFragment = null;
    FragmentTransaction transactionSim;

    FmHomeLoanRequest fmHomeLoanRequest;
    int LoanRequireID = 0;
    BankSaveRequest bankSaveRequest;

    public QuoteFragment_hl() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.content_home_loan_quote, container, false);
        initialise_widget(view);

        if (getArguments() != null) {
            fmHomeLoanRequest = getArguments().getParcelable(HLMainActivity.HL_QUOTE_REQUEST);
            homeLoanRequest = fmHomeLoanRequest.getHomeLoanRequest();
            showDialog("Wait..,Fetching quote");
            new HomeLoanController(getActivity()).getHomeLoan(homeLoanRequest, this);
        }


        return view;
    }

    public void redirectToApplyBank(QuoteEntity entity) {
        setFmBankRequest(entity);
    }

    private void initialise_widget(View view) {

        txtInputSummary = (TextView) view.findViewById(R.id.txtInputSummary);
        txtPropertyType = (TextView) view.findViewById(R.id.txtPropertyType);
        txtCostOfProp = (TextView) view.findViewById(R.id.txtCostOfProp);
        txtLoanTenure = (TextView) view.findViewById(R.id.txtLoanTenure);
        txtOccupation = (TextView) view.findViewById(R.id.txtOccupation);
        txtMonthlyIncome = (TextView) view.findViewById(R.id.txtMonthlyIncome);
        txtExistEmi = (TextView) view.findViewById(R.id.txtExistEmi);
        txtCount = (TextView) view.findViewById(R.id.txtCount);
        cvInputSummary = (CardView) view.findViewById(R.id.cvInputSummary);
        ivllEdit = (LinearLayout) view.findViewById(R.id.ivllEdit);
        ivllEdit.setOnClickListener(this);

        rvQuotes = (RecyclerView) view.findViewById(R.id.rvQuotes);
        rvQuotes.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void quoteToApp() {
        //quote to application conversion
        //TODO : USE : LoanRequireID and "A"
    }

    public void redirectToApplyLoan(QuoteEntity entity, String url, int id) {
        startActivity(new Intent(getContext(), HomeLoanApplyWebView.class)
                .putExtra("QUOTE_ENTITY", entity)
                .putExtra("URL", url)
                .putExtra("QUOTE_ID", id));
    }

    private void bindQuotes() {
        if (getQuoteResponse != null) {
            txtInputSummary.setVisibility(View.VISIBLE);
            cvInputSummary.setVisibility(View.VISIBLE);

            mAdapter = new HLQuoteAdapter(this, getQuoteResponse.getData(), getQuoteResponse);
            rvQuotes.setAdapter(mAdapter);

            if (getQuoteResponse.getData().size() > 0) {
                txtCount.setText("" + getQuoteResponse.getData().size() + " Results from www.rupeeboss.com");
                txtCount.setVisibility(View.VISIBLE);
            } else {
                txtCount.setText("");
                txtCount.setVisibility(View.GONE);
            }

            if (homeLoanRequest != null) {

                try {
                    String strPropTyp = getProperty(homeLoanRequest.getPropertyID());

                    txtPropertyType.setText("" + strPropTyp.toString());
                    txtCostOfProp.setText("" + homeLoanRequest.getPropertyCost());
                    txtLoanTenure.setText("" + homeLoanRequest.getLoanTenure() + " Years");

                    if (homeLoanRequest.getApplicantSource().equals("1")) {
                        txtOccupation.setText("SALARIED");
                    } else {
                        txtOccupation.setText("SELF-EMP");
                    }

                    txtMonthlyIncome.setText("" + homeLoanRequest.getApplicantIncome());
                    txtExistEmi.setText("" + homeLoanRequest.getApplicantObligations());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }

        }
    }


    private String getProperty(String id) {
        String strProp = "";
        if (id.equals("1")) {
            strProp = "READY";
        } else if (id.equals("2")) {
            strProp = "UNDER CONS";
        } else if (id.equals("3")) {
            strProp = "SEARCHING";
        } else if (id.equals("4")) {
            strProp = "RESALE";
        } else if (id.equals("5")) {
            strProp = "FOR CONS";
        } else if (id.equals("6")) {
            strProp = "OTHER";
        }

        return strProp;

    }

//////

    private void loadFragment(Fragment fragment, String TAG) {
        transactionSim = getActivity().getSupportFragmentManager().beginTransaction();
        transactionSim.replace(R.id.frame_layout, fragment, TAG);
        transactionSim.addToBackStack(TAG);
        transactionSim.show(fragment);
        transactionSim.commit();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ivllEdit) {
//            tabFragment = getActivity().getSupportFragmentManager().findFragmentByTag(INPUT_FRAGMENT);
//            if (tabFragment != null) {
//                loadFragment(tabFragment, INPUT_FRAGMENT);
//
//            } else {
//                loadFragment(new InputFragment_hl(), INPUT_FRAGMENT);
//            }
            ((HLMainActivity) getActivity()).redirectInput(fmHomeLoanRequest);
        }

    }

    private void setFmHomeLoanRequest(int QuoteID) {

        showDialog();

        // fmHomeLoanRequest.setLoan_requestID(fmHomeLoanRequest.getLoan_requestID());
        //   fmHomeLoanRequest.setFba_id(new DBPersistanceController(getContext()).getUserData().getFBAId());
        homeLoanRequest.setQuote_id(QuoteID);
        fmHomeLoanRequest.setHomeLoanRequest(homeLoanRequest);
        new MainLoanController(getActivity()).saveHLQuoteData(fmHomeLoanRequest, this);

    }

    private void setFmBankRequest(QuoteEntity entity) {


        try{
            bankSaveRequest = new BankSaveRequest();
            bankSaveRequest.setLoan_requestID(fmHomeLoanRequest.getLoan_requestID());
            bankSaveRequest.setBank_id((entity.getBank_Id()));
            bankSaveRequest.setType("HML");
            new MainLoanController(getActivity()).savebankFbABuyData(bankSaveRequest, this);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    public void OnSuccessFM(APIResponseFM response, String message) {
        cancelDialog();
        if (response instanceof FmSaveQuoteHomeLoanResponse) {
            if (response.getStatusNo() == 0) {
                LoanRequireID = ((FmSaveQuoteHomeLoanResponse) response).getMasterData().get(0).getLoanRequestID();
                fmHomeLoanRequest.setLoan_requestID(LoanRequireID);
                ((HLMainActivity) getActivity()).updateRequest(fmHomeLoanRequest, true);

            }
        }else if(response instanceof BankForNodeResponse)
        {
            if (response.getStatusNo() == 0) {
                ((HLMainActivity) getActivity()).redirectInput(fmHomeLoanRequest);
            }
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof GetQuoteResponse) {
            if (response.getStatus_Id() == 0) {

                getQuoteResponse = ((GetQuoteResponse) response);

                bindQuotes();
                setFmHomeLoanRequest(getQuoteResponse.getQuote_id());

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
}
