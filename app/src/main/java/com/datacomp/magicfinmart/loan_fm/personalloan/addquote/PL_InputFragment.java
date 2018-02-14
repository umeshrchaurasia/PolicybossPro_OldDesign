package com.datacomp.magicfinmart.loan_fm.personalloan.addquote;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.mainloan.MainLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.personalloan.PersonalLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CustomerApplicationEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CustomerEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmPersonalLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmSaveQuotePersonalLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetPersonalLoanResponse;

/**
 * Created by Rajeev Ranjan on 24/01/2018.
 */

public class PL_InputFragment extends BaseFragment implements View.OnClickListener, IResponseSubcriber, IResponseSubcriberFM, SeekBar.OnSeekBarChangeListener {

    DBPersistanceController databaseController;
    LoginResponseEntity loginEntity;

    PersonalLoanRequest personalLoanRequest;
    FmPersonalLoanRequest fmPersonalLoanRequest;
    CustomerEntity customerEntity;
    CustomerApplicationEntity customerApplicationEntity;
    GetPersonalLoanResponse getPersonalLoanResponse;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Button btnGetQuote;
    EditText etNameOfApplicant, et_DOB, etMonthlyInc, etEMI, etPAN, etCostOfProp;

    LinearLayout llSalaried, llSelfEmployeed;


    RadioGroup rgGender;
    RadioButton rbimgMale, rbimgFemale;

    TextView txtTenureInYear;
    TextView txtDispalayMinTenureYear, txtDispalayMaxTenureYear;
    SeekBar sbTenure;
    Context mContext;


    int seekBarTenureProgress = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_add_plquote, container, false);
        initilize(view);
        databaseController = new DBPersistanceController(getActivity());
        loginEntity = databaseController.getUserData();
        setListener();

        if (getActivity().getIntent().getBooleanExtra("IS_EDIT", false)) {
            customerEntity = getActivity().getIntent().getParcelableExtra("CUST_DETAILS");
            fillCustomerDetails(customerEntity);
        }
        if (getActivity().getIntent().getBooleanExtra("IS_APP_EDIT", false)) {
            customerApplicationEntity = getActivity().getIntent().getParcelableExtra("CUST_APP_DETAILS");
            fillCustomerApplicationDetails(customerApplicationEntity);
        }
        return view;
    }

    private void initilize(View view) {

        btnGetQuote = (Button) view.findViewById(R.id.btnGetQuote);

        //region Property Initialize
        etCostOfProp = (EditText) view.findViewById(R.id.etCostOfProp);
        etPAN = (EditText) view.findViewById(R.id.etPAN);
        txtDispalayMinTenureYear = (TextView) view.findViewById(R.id.txtDispalayMinTenureYear);
        txtDispalayMaxTenureYear = (TextView) view.findViewById(R.id.txtDispalayMaxTenureYear);
        txtTenureInYear = (TextView) view.findViewById(R.id.txtTenureInYear);


        sbTenure = (SeekBar) view.findViewById(R.id.sbTenure);
        sbTenure.setMax(5);
        sbTenure.setProgress(1);
        txtTenureInYear.setText("1");
        //endregion

        //region Applicant Initialize
        llSelfEmployeed = (LinearLayout) view.findViewById(R.id.llSelfEmployeed);
        llSalaried = (LinearLayout) view.findViewById(R.id.llSalaried);
        etNameOfApplicant = (EditText) view.findViewById(R.id.etNameOfApplicant);
        et_DOB = (EditText) view.findViewById(R.id.et_DOB);
        etMonthlyInc = (EditText) view.findViewById(R.id.etMonthlyInc);
        etEMI = (EditText) view.findViewById(R.id.etEMI);
        rgGender = (RadioGroup) view.findViewById(R.id.rgGender);
        rbimgMale = (RadioButton) view.findViewById(R.id.rbimgMale);
        rbimgFemale = (RadioButton) view.findViewById(R.id.rbimgFemale);

        //endregion

    }

    //region datePickerDialog Applicant
    protected View.OnClickListener datePickerDialogApplicant = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Constants.hideKeyBoard(view, getActivity());
            DateTimePicker.showDataPickerDialogBeforeTwentyOne(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(year, monthOfYear, dayOfMonth);
                    String currentDay = simpleDateFormat.format(calendar.getTime());
                    et_DOB.setText(currentDay);
                    //etDate.setTag(R.id.et_date, calendar.getTime());
                }
            });
        }
    };
    //endregion


    private void setApplicantDetails() {
        // region  HomeLoanRequest Binding

        personalLoanRequest = new PersonalLoanRequest();
        personalLoanRequest.setLoanRequired(etCostOfProp.getText().toString());
        personalLoanRequest.setLoanTenure(txtTenureInYear.getText().toString());
        personalLoanRequest.setApplicantNme(etNameOfApplicant.getText().toString());

        // region Default Salaried
        personalLoanRequest.setApplicantSource("1");
        personalLoanRequest.setApplicantIncome(etMonthlyInc.getText().toString());

        //endregion

        // region comment
//        if (personalLoanRequest.getApplicantSource() == "1") {
//                personalLoanRequest.setApplicantIncome(etMonthlyInc.getText().toString());
//        } else if (personalLoanRequest.getApplicantSource() == "2") {
//            personalLoanRequest.setApplicantIncome(etTurnOver.getText().toString());
//            //same in personal loan
//
//        }
        //endregion

        if (rbimgMale.isChecked()) {
            personalLoanRequest.setApplicantGender("M");
        } else {
            personalLoanRequest.setApplicantGender("F");
        }

        personalLoanRequest.setApplicantObligations(etEMI.getText().toString());
        personalLoanRequest.setApplicantDOB(et_DOB.getText().toString());
        personalLoanRequest.setBrokerId("" + loginEntity.getLoanId());
        personalLoanRequest.setEmpcode("");
        personalLoanRequest.setType("PSL");
        personalLoanRequest.setApi_source("Finmart");
    }

    private void fillCustomerApplicationDetails(CustomerApplicationEntity customerEntity) {
        if (customerEntity.getLoanRequired() != null)
            etCostOfProp.setText(customerEntity.getLoanRequired());
        if (customerEntity.getLoanTenure() != null)
            txtTenureInYear.setText(customerEntity.getLoanTenure());
        if (customerEntity.getApplicantNme() != null)
            etNameOfApplicant.setText(customerEntity.getApplicantNme());
        /*if (customerEntity.getApplicantGender().equals("M")) {
            rbimgMale.setSelected(true);
        } else {
            rbimgFemale.setSelected(true);
        }*/
        if (customerEntity.getApplicantDOB() != null)
            et_DOB.setText(customerEntity.getApplicantDOB());
        if (customerEntity.getApplicantIncome() != null)
            etMonthlyInc.setText("" + customerEntity.getApplicantIncome());


    }

    private void fillCustomerDetails(CustomerEntity customerEntity) {
        if (customerEntity.getLoanRequired() != null)
            etCostOfProp.setText(customerEntity.getLoanRequired());
        if (customerEntity.getLoanTenure() != null)
            txtTenureInYear.setText(customerEntity.getLoanTenure());
        if (customerEntity.getApplicantNme() != null)
            etNameOfApplicant.setText(customerEntity.getApplicantNme());
        /*if (customerEntity.getApplicantGender().equals("M")) {
            rbimgMale.setSelected(true);
        } else {
            rbimgFemale.setSelected(true);
        }*/
        if (customerEntity.getApplicantDOB() != null)
            et_DOB.setText(customerEntity.getApplicantDOB());
        if (customerEntity.getApplicantIncome() != null)
            etMonthlyInc.setText("" + customerEntity.getApplicantIncome());


    }

    private void setListener() {
        sbTenure.setOnSeekBarChangeListener(this);
        btnGetQuote.setOnClickListener(this);
        et_DOB.setOnClickListener(datePickerDialogApplicant);

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnGetQuote) {
            //region Validation
            String NameOfApplicant = etNameOfApplicant.getText().toString();
            String DOB = et_DOB.getText().toString();
            String MonthlyInc = etMonthlyInc.getText().toString();
            String Pan_no = etPAN.getText().toString();
            String CostOfProp = etCostOfProp.getText().toString();

            if (TextUtils.isEmpty(NameOfApplicant)) {

                etNameOfApplicant.setError("Please Enter Name Of Applicant.");
                etNameOfApplicant.requestFocus();
                return;

            }
            if (TextUtils.isEmpty(DOB)) {

                et_DOB.setError("Please Enter DOB.");
                et_DOB.requestFocus();
                return;

            }
            if (TextUtils.isEmpty(MonthlyInc)) {

                etMonthlyInc.setError("Please Enter Monthly Income.");
                etMonthlyInc.requestFocus();
                return;

            }

            if (TextUtils.isEmpty(Pan_no)) {
                etPAN.setError("Please Enter PAN Number");
                etPAN.requestFocus();
                return;
            }
            if (!isValidPan(Pan_no)) {
                etPAN.setError("Enter Valid PAN Number");
                etPAN.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(CostOfProp)) {

                etCostOfProp.setError("Please Enter Cost Of Property.");
                etCostOfProp.requestFocus();
                return;

            }


            // endregion
            setApplicantDetails();
            showDialog();
            new PersonalLoanController(getActivity()).getPersonalLoan(personalLoanRequest, this);

        }

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId()) {
            case R.id.sbTenure:
                int MIN = 1;
                if (progress >= MIN) {
                    if (fromUser) {
                        // progress = ((int) Math.round(progress / seekBarTenureProgress)) * seekBarTenureProgress;
                        txtTenureInYear.setText(String.valueOf(progress));
                    }
                } else {
                    sbTenure.setProgress(MIN);
                    txtTenureInYear.setText(String.valueOf(MIN));
                }
                break;


        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    //endegion

    @Override
    public void OnSuccess(APIResponse response, String message) {

        cancelDialog();
        if (response instanceof GetPersonalLoanResponse) {
            if (response.getStatus_Id() == 0) {

                getPersonalLoanResponse = ((GetPersonalLoanResponse) response);

//                Bundle bundle = new Bundle();
//                bundle.putParcelable(Constants.PERSONAL_LOAN_QUOTES, getPersonalLoanResponse);
//                bundle.putParcelable(Constants.PL_REQUEST, personalLoanRequest);
//                ((PLMainActivity) getActivity()).getQuoteParameterBundle(bundle);
////
                setFmPeronalLoanRequest(getPersonalLoanResponse.getQuote_id());

            } else {
                Toast.makeText(getActivity(), response.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setFmPeronalLoanRequest(int QuoteID)
    {

        showDialog();
      //  personalLoanRequest = new PersonalLoanRequest();
        personalLoanRequest.setQuote_id(QuoteID);

        fmPersonalLoanRequest = new FmPersonalLoanRequest();
        fmPersonalLoanRequest.setLoan_requestID(fmPersonalLoanRequest.getLoan_requestID());
        fmPersonalLoanRequest.setFBA_id(loginEntity.getFBAId());
        fmPersonalLoanRequest.setPersonalLoanRequest(personalLoanRequest);



        new MainLoanController(getActivity()).savePLQuoteData(fmPersonalLoanRequest, this);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }



    @Override
    public void OnSuccessFM(APIResponseFM response, String message) {

        cancelDialog();
        if (response instanceof FmSaveQuotePersonalLoanResponse) {
            if (response.getStatusNo() == 0) {
                Toast.makeText(getActivity(), "Fm Saved", Toast.LENGTH_SHORT).show();

                Bundle bundle = new Bundle();
                bundle.putParcelable(Constants.PERSONAL_LOAN_QUOTES, getPersonalLoanResponse);
                bundle.putParcelable(Constants.PL_REQUEST, personalLoanRequest);
                ((PLMainActivity) getActivity()).getQuoteParameterBundle(bundle);
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        // startActivity(new Intent(HomeLoanActivity.this, QuoteActivity.class).putParcelableArrayListExtra(Constants.QUOTES, (ArrayList<QuoteEntity>) quoteEntities));
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

    }


}
