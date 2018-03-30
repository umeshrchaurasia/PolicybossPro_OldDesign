package com.datacomp.magicfinmart.loan_fm.personalloan.addquote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.personalloan.loan_apply.PersonalLoanApplyActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.webviews.ShareQuoteACtivity;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.tracking.TrackingController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TrackingData;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TrackingRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.mainloan.MainLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.personalloan.PersonalLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BuyLoanQuerystring;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.PersonalQuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BankSaveRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.BankForNodeResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmSaveQuotePersonalLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetPersonalLoanResponse;

/**
 * Created by Rahul on 24/01/2018.
 */

public class QuoteFragment_pl extends BaseFragment implements View.OnClickListener, IResponseSubcriber, IResponseSubcriberFM {
    private static String INPUT_FRAGMENT = "input";

    TextView txtAppName, txtCostOfProp, txtLoanTenure, txtOccupation, txtMonthlyIncome, txtExistEmi, txtCount, txtInputSummary;
    CardView cvInputSummary;

    RecyclerView rvPLQuotes;

    PLQuoteAdapter mAdapter;
    int LoanRequireID = 0;
    BankSaveRequest bankSaveRequest;
    GetPersonalLoanResponse getPersonalLoanResponse;
    FmPersonalLoanRequest fmPersonalLoanRequest;
    PersonalLoanRequest personalLoanRequest;
    BuyLoanQuerystring buyLoanQuerystring;
    LinearLayout ivllEdit;
    int QuoteID = 0;
    ImageView ivShare;

    public QuoteFragment_pl() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_personal_loan_quote, container, false);
        initialise_widget(view);

        if (getArguments() != null) {
            fmPersonalLoanRequest = getArguments().getParcelable(PLMainActivity.PL_QUOTE_REQUEST);
            personalLoanRequest = fmPersonalLoanRequest.getPersonalLoanRequest();
            showDialog("Wait..,Fetching quote");
            new PersonalLoanController(getActivity()).getPersonalLoan(personalLoanRequest, this);
        }
        return view;
    }

    public void redirectToApplyBank(PersonalQuoteEntity entity) {
        setFmBankRequest(entity);
    }


    private void initialise_widget(View view) {
        ivShare = (ImageView) view.findViewById(R.id.ivShare);
        ivShare.setOnClickListener(this);
        cvInputSummary = (CardView) view.findViewById(R.id.cvInputSummary);

        txtInputSummary = (TextView) view.findViewById(R.id.txtInputSummary);
        txtAppName = (TextView) view.findViewById(R.id.txtAppName);
        txtCostOfProp = (TextView) view.findViewById(R.id.txtCostOfProp);
        txtLoanTenure = (TextView) view.findViewById(R.id.txtLoanTenure);
        txtOccupation = (TextView) view.findViewById(R.id.txtOccupation);
        txtMonthlyIncome = (TextView) view.findViewById(R.id.txtMonthlyIncome);
        txtExistEmi = (TextView) view.findViewById(R.id.txtExistEmi);
        txtCount = (TextView) view.findViewById(R.id.txtCount);

        ivllEdit = (LinearLayout) view.findViewById(R.id.ivllEdit);
        ivllEdit.setOnClickListener(this);
        rvPLQuotes = (RecyclerView) view.findViewById(R.id.rvQuotes);
        rvPLQuotes.setLayoutManager(new LinearLayoutManager(getActivity()));

// bundle.putParcelable(Constants.PL_REQUEST, personalLoanRequest);

    }

    public void quoteToApp() {
        //quote to application conversion
        //TODO : USE : LoanRequireID and "A"
    }

//    public void redirectToApplyLoan(PersonalQuoteEntity entity, String url, int id) {
//        startActivity(new Intent(getActivity(), PersonalLoanApplyWebView.class)
//                .putExtra("PL", entity)
//                .putExtra("PL_URL", url)
//                .putExtra("PL_QUOTE_ID", id));
//    }


    public void redirectToApplyLoan() {
        startActivity(new Intent(getContext(), PersonalLoanApplyActivity.class)
                .putExtra("BuyLoanQuery", buyLoanQuerystring));
        new TrackingController(getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Buy PL : Buy button for PL"), Constants.PERSONA_LOAN), null);
    }


    private void bindQuotes() {

        if (getPersonalLoanResponse != null) {
            txtInputSummary.setVisibility(View.VISIBLE);
            cvInputSummary.setVisibility(View.VISIBLE);
            ivShare.setVisibility(View.VISIBLE);

            mAdapter = new PLQuoteAdapter(this, getPersonalLoanResponse.getData(), getPersonalLoanResponse);
            rvPLQuotes.setAdapter(mAdapter);

            if (getPersonalLoanResponse.getData().size() > 0) {
                txtCount.setText("" + getPersonalLoanResponse.getData().size() + " Results from www.rupeeboss.com");
                txtCount.setVisibility(View.VISIBLE);
            } else {
                txtCount.setText("");
                txtCount.setVisibility(View.GONE);
            }

            if (personalLoanRequest != null) {
                try {
                    txtAppName.setText("" + personalLoanRequest.getApplicantNme().toUpperCase());
                    txtCostOfProp.setText("" + personalLoanRequest.getLoanRequired());
                    txtLoanTenure.setText("" + personalLoanRequest.getLoanTenure() + " Years");


                    txtOccupation.setText("SALARIED");

                    txtMonthlyIncome.setText("" + personalLoanRequest.getApplicantIncome());
                    txtExistEmi.setText("" + personalLoanRequest.getApplicantObligations());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


    private void setFmPeronalLoanRequest(int tempQuoteID) {
        QuoteID = tempQuoteID;
        showDialog();


        personalLoanRequest.setQuote_id(QuoteID);
        fmPersonalLoanRequest.setPersonalLoanRequest(personalLoanRequest);
        new MainLoanController(getActivity()).savePLQuoteData(fmPersonalLoanRequest, this);

    }

    private void setFmBankRequest(PersonalQuoteEntity entity) {


        try {
            bankSaveRequest = new BankSaveRequest();
            bankSaveRequest.setLoan_requestID(fmPersonalLoanRequest.getLoan_requestID());
            bankSaveRequest.setBank_id((entity.getBank_Id()));
            bankSaveRequest.setType("PSL");

            buyLoanQuerystring = new BuyLoanQuerystring();
            buyLoanQuerystring.setBankId(entity.getBank_Id());

            buyLoanQuerystring.setProp_Loan_Eligible(String.valueOf(entity.getLoan_eligible()));
            buyLoanQuerystring.setProp_Processing_Fee(String.valueOf(entity.getProcessingfee()));
            buyLoanQuerystring.setQuote_id(QuoteID);
            buyLoanQuerystring.setProp_type(entity.getRoi_type());
            buyLoanQuerystring.setMobileNo(fmPersonalLoanRequest.getPersonalLoanRequest().getContact());
            buyLoanQuerystring.setPan(fmPersonalLoanRequest.getPersonalLoanRequest().getpanno());
            buyLoanQuerystring.setCity("");


            new MainLoanController(getActivity()).savebankFbABuyData(bankSaveRequest, this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void OnSuccessFM(APIResponseFM response, String message) {
        cancelDialog();
        if (response instanceof FmSaveQuotePersonalLoanResponse) {
            if (response.getStatusNo() == 0) {
                LoanRequireID = ((FmSaveQuotePersonalLoanResponse) response).getMasterData().get(0).getLoanRequestID();
                fmPersonalLoanRequest.setLoan_requestID(LoanRequireID);
                ((PLMainActivity) getActivity()).updateRequest(fmPersonalLoanRequest, true);

            }
        } else if (response instanceof BankForNodeResponse) {
            if (response.getStatusNo() == 0) {
                ((PLMainActivity) getActivity()).redirectInput(fmPersonalLoanRequest);

                redirectToApplyLoan();
            }
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof GetPersonalLoanResponse) {
            if (response.getStatus_Id() == 0) {

                getPersonalLoanResponse = ((GetPersonalLoanResponse) response);

                bindQuotes();
                setFmPeronalLoanRequest(getPersonalLoanResponse.getQuote_id());

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
            ((PLMainActivity) getActivity()).redirectInput(fmPersonalLoanRequest);
        } else if (v.getId() == R.id.ivShare) {
            if (getPersonalLoanResponse != null) {
                Intent intent = new Intent(getActivity(), ShareQuoteACtivity.class);
                intent.putExtra(Constants.SHARE_ACTIVITY_NAME, "PL_ALL_QUOTE");
                intent.putExtra("RESPONSE", getPersonalLoanResponse);
                intent.putExtra("NAME", personalLoanRequest.getApplicantNme());
                startActivity(intent);
            }
        }
    }
}
