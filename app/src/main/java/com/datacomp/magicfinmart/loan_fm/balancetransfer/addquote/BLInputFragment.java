package com.datacomp.magicfinmart.loan_fm.balancetransfer.addquote;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseBL;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberBL;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.personalloan.PersonalLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BLEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CustomerApplicationEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CustomerEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BLLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.BLDispalyResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetPersonalLoanResponse;

public class BLInputFragment extends BaseFragment implements View.OnClickListener, IResponseSubcriberBL {

    BLLoanRequest blLoanRequest;
    CustomerEntity customerEntity;
    CustomerApplicationEntity customerApplicationEntity;

    BLDispalyResponse getBLDispalyLoanResponse;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Button btnGetQuote;
    EditText etOutstanding, etCurrInc, ettenureyrs,etNameOfApplicant;

//    ArrayAdapter<String> salaryTypeAdapter;
//    LinearLayout llSalaried;


    RadioGroup rgloantype;
    RadioButton rbimghl, rbimgpl,rbimglap;

    Context mContext;


    public BLInputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_add_blquote, container, false);

        initilize(view);
        setListener();
//        if (getActivity().getIntent().getBooleanExtra("IS_EDIT", false)) {
//            customerEntity = getActivity().getIntent().getParcelableExtra("CUST_DETAILS");
//         //   fillCustomerDetails(customerEntity);
//        }
//        if (getActivity().getIntent().getBooleanExtra("IS_APP_EDIT", false)) {
//            customerApplicationEntity = getActivity().getIntent().getParcelableExtra("CUST_APP_DETAILS");
//           // fillCustomerApplicationDetails(customerApplicationEntity);
//        }
        return view;
    }

    private void initilize(View view) {

        btnGetQuote = (Button) view.findViewById(R.id.btnGetQuote);
        //endregion
        //region Property Initialize
        etOutstanding = (EditText) view.findViewById(R.id.etOutstanding);

        etCurrInc = (EditText) view.findViewById(R.id.etCurrInc);

        ettenureyrs = (EditText) view.findViewById(R.id.ettenureyrs);

        etNameOfApplicant = (EditText) view.findViewById(R.id.etNameOfApplicant);



//        llSalaried = (LinearLayout) view.findViewById(R.id.llSalaried);

        rgloantype = (RadioGroup) view.findViewById(R.id.rgloantype);
        rbimghl = (RadioButton) view.findViewById(R.id.rbimghl);
        rbimgpl = (RadioButton) view.findViewById(R.id.rbimgpl);
        rbimglap = (RadioButton) view.findViewById(R.id.rbimglap);

    }




    private void setApplicantDetails() {
        // region  HomeLoanRequest Binding

        blLoanRequest = new BLLoanRequest();
        blLoanRequest.setLoanamount( Integer.parseInt(etOutstanding.getText().toString()));
        blLoanRequest.setLoanterm(Integer.parseInt(ettenureyrs.getText().toString()));
        blLoanRequest.setLoaninterest(Double.parseDouble(etCurrInc.getText().toString()));
        blLoanRequest.setApplicantName(etNameOfApplicant.getText().toString());

        if (rbimghl.isChecked()) {
            blLoanRequest.setProduct_id(12);//hl
        } else if (rbimgpl.isChecked()) {
            blLoanRequest.setProduct_id(9);//pl
        }else if (rbimglap.isChecked()) {
            blLoanRequest.setProduct_id(7);//lap
        }

      //      blLoanRequest.setBrokerId("" + "0");
       // blLoanRequest.setempcode("" + "Rb40000428");
        //  personalLoanRequest.setBrokerId("" + new LoginFacade(PersonalLoanActivity.this).getUser().getBrokerId());
        //   personalLoanRequest.setempcode("" + new LoginFacade(PersonalLoanActivity.this).getUser().getEmpCode());



        //endregion
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

            if (TextUtils.isEmpty(Name)) {

                etNameOfApplicant.setError("Please Enter Name Of Applicant.");
                etNameOfApplicant.requestFocus();
                return;

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
            if (TextUtils.isEmpty(TenureInYear)) {

                ettenureyrs.setError("Please Enter Tenure (yrs).");
                ettenureyrs.requestFocus();
                return;

            }
            //endregion


            // endregion
            setApplicantDetails();
            showDialog();
            new PersonalLoanController(getActivity()).getBLQuote(blLoanRequest, this);

        }

    }




    //endegion

//    @Override
//    public void OnSuccess(APIResponse response, String message) {
//
//        cancelDialog();
//        if (response instanceof BLDispalyResponse) {
//            if (((BLDispalyResponse) response).getStatusbl() == 0) {
//
////                ((BLMainActivity)mContext).setQuoteCheck();
////
////                getBLDispalyLoanResponse = ((BLDispalyResponse) response);
////
////                Bundle bundle = new Bundle();
////                bundle.putParcelable(Constants.BL_LOAN_QUOTES, getBLDispalyLoanResponse);
////                BLQuoteFragment quoteFragment = new BLQuoteFragment();
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

    @Override
    public void OnSuccess(APIResponseBL response, String message) {

        cancelDialog();
        if (response instanceof BLDispalyResponse) {
            if (((BLDispalyResponse) response).getStatus() == 1) {

                ((BLMainActivity)mContext).setQuoteCheck();

                getBLDispalyLoanResponse = ((BLDispalyResponse) response);

                Bundle bundle = new Bundle();
                bundle.putParcelable(Constants.BL_LOAN_SERVICE, getBLDispalyLoanResponse.getSaving());
                bundle.putParcelable(Constants.BL_REQUEST, blLoanRequest);
                bundle.putParcelableArrayList(Constants.BL_LOAN_QUOTES, (ArrayList<BLEntity>) getBLDispalyLoanResponse.getData());

                BLQuoteFragment quoteFragment = new BLQuoteFragment();
                quoteFragment.setArguments(bundle);
                FragmentTransaction transaction_quote = getActivity().getSupportFragmentManager().beginTransaction();
                transaction_quote.replace(R.id.frame_layout, quoteFragment, "QUOTE");
                transaction_quote.addToBackStack("QUOTE");
                transaction_quote.show(quoteFragment);
                //  transaction_quote.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction_quote.commit();
//
            }
        }

    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void OnFailure(Throwable t) {
//        cancelDialog();
//        // startActivity(new Intent(HomeLoanActivity.this, QuoteActivity.class).putParcelableArrayListExtra(Constants.QUOTES, (ArrayList<QuoteEntity>) quoteEntities));
//        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//    }

}
