package com.datacomp.magicfinmart.loan_fm.personalloan.addquote;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.tracking.TrackingController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TrackingData;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TrackingRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetPersonalLoanResponse;


/**
 * Created by Rahul on 24/01/2018.
 */

public class InputFragment_pl extends BaseFragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    DBPersistanceController databaseController;

    LoginResponseEntity loginEntity;
    GetPersonalLoanResponse getPersonalLoanResponse;
    PersonalLoanRequest personalLoanRequest;
    FmPersonalLoanRequest fmPersonalLoanRequest;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Button btnGetQuote;
    EditText etNameOfApplicant, et_DOB, etMonthlyInc, etEMI, etPAN, etCostOfProp,etcontact;

    LinearLayout llSalaried, llSelfEmployeed;

    TextView etTenureInYear,txtrbimgMale,txtrbimgFemale;
    TextView txtDispalayMinTenureYear, txtDispalayMaxTenureYear;
    SeekBar sbTenure;
    Context mContext;
    String GenderApplicantSource = "M";


    public InputFragment_pl() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_add_plquote, container, false);
        init_widgets(view);
        databaseController = new DBPersistanceController(getActivity());
        loginEntity = databaseController.getUserData();
        setListener();
        setApp_Male_gender();

        if (getArguments() != null) {
            if (getArguments().getParcelable(PLMainActivity.PL_INPUT_REQUEST) != null) {
                fmPersonalLoanRequest = getArguments().getParcelable(PLMainActivity.PL_INPUT_REQUEST);
                personalLoanRequest = fmPersonalLoanRequest.getPersonalLoanRequest();
                fillCustomerDetails();


            }
        } else {
            fmPersonalLoanRequest = new FmPersonalLoanRequest();
            fmPersonalLoanRequest.setFBA_id(new DBPersistanceController(getContext()).getUserData().getFBAId());
            fmPersonalLoanRequest.setLoan_requestID(0);
            personalLoanRequest = new PersonalLoanRequest();
            fmPersonalLoanRequest.setPersonalLoanRequest(personalLoanRequest);
        }
        return view;
    }

    private void init_widgets(View view) {

        btnGetQuote = (Button) view.findViewById(R.id.btnGetQuote);

        //region Property Initialize
        etCostOfProp = (EditText) view.findViewById(R.id.etCostOfProp);
        etPAN = (EditText) view.findViewById(R.id.etPAN);
        txtDispalayMinTenureYear = (TextView) view.findViewById(R.id.txtDispalayMinTenureYear);
        txtDispalayMaxTenureYear = (TextView) view.findViewById(R.id.txtDispalayMaxTenureYear);
        etTenureInYear = (TextView) view.findViewById(R.id.etTenureInYear);
        etcontact= (EditText) view.findViewById(R.id.etcontact);

        sbTenure = (SeekBar) view.findViewById(R.id.sbTenure);
        sbTenure.setMax(4);
        sbTenure.setProgress(4);
        etTenureInYear.setText("5");

        //endregion

        //region Applicant Initialize
        llSelfEmployeed = (LinearLayout) view.findViewById(R.id.llSelfEmployeed);
        llSalaried = (LinearLayout) view.findViewById(R.id.llSalaried);
        etNameOfApplicant = (EditText) view.findViewById(R.id.etNameOfApplicant);
        et_DOB = (EditText) view.findViewById(R.id.et_DOB);
        etMonthlyInc = (EditText) view.findViewById(R.id.etMonthlyInc);
        etEMI = (EditText) view.findViewById(R.id.etEMI);

        txtrbimgMale = (TextView) view.findViewById(R.id.txtrbimgMale);
        txtrbimgFemale = (TextView) view.findViewById(R.id.txtrbimgFemale);


        et_DOB.setText("01-01-1980");
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
        // region  PersonaalLoanRequest Binding

        personalLoanRequest = fmPersonalLoanRequest.getPersonalLoanRequest();
        personalLoanRequest.setLoanRequired(etCostOfProp.getText().toString());
        personalLoanRequest.setLoanTenure(etTenureInYear.getText().toString());
        personalLoanRequest.setApplicantNme(etNameOfApplicant.getText().toString());

        personalLoanRequest.setContact(etcontact.getText().toString());
        // region Default Salaried
        personalLoanRequest.setApplicantSource("1");
        personalLoanRequest.setApplicantIncome(etMonthlyInc.getText().toString());

        //endregion
        personalLoanRequest.setApplicantGender(GenderApplicantSource);
        if (personalLoanRequest.getApplicantGender()=="M") {
            personalLoanRequest.setApplicantGender("M");
        } else  if (personalLoanRequest.getApplicantGender()=="F") {
            personalLoanRequest.setApplicantGender("F");
        }

        if (etEMI.getText().equals("")) {
            personalLoanRequest.setApplicantObligations("0");
        }else
        {
            personalLoanRequest.setApplicantObligations(etEMI.getText().toString());
        }

       // personalLoanRequest.setEmi(etEMI.getText().toString());

        personalLoanRequest.setApplicantDOB(getYYYYMMDDPattern(et_DOB.getText().toString()));

    //    personalLoanRequest.setApplicantDOB(et_DOB.getText().toString());
        personalLoanRequest.setBrokerId("" + loginEntity.getLoanId());
       // personalLoanRequest.setLoaniD(Integer.parseInt(loginEntity.getLoanId()));
        personalLoanRequest.setpanno(etPAN.getText().toString());

        personalLoanRequest.setEmpcode("");
        personalLoanRequest.setType("PSL");
        personalLoanRequest.setApi_source("Finmart");

        personalLoanRequest.setQuote_id(fmPersonalLoanRequest.getPersonalLoanRequest().getQuote_id());

    }



    private void fillCustomerDetails() {

        Log.d("DETAILS", personalLoanRequest.toString());

        try {


        if (personalLoanRequest.getLoanRequired() != null)
            etCostOfProp.setText(personalLoanRequest.getLoanRequired());
        if (personalLoanRequest.getLoanTenure() != null)
            etTenureInYear.setText(personalLoanRequest.getLoanTenure());

        if(personalLoanRequest.getApplicantObligations() != null){
            etEMI.setText(personalLoanRequest.getApplicantObligations());
        }
        if (personalLoanRequest.getApplicantNme() != null)
            etNameOfApplicant.setText(personalLoanRequest.getApplicantNme());

            int tenureInYear = Integer.parseInt(personalLoanRequest.getLoanTenure());
            sbTenure.setProgress(tenureInYear-1);

            if (personalLoanRequest.getApplicantGender().matches("M")) {
                setApp_Male_gender();
            } else {
                setApp_FeMale_gender();
            }

        if (personalLoanRequest.getApplicantDOB() != null)
        {
            et_DOB.setText(getDDMMYYYPattern(personalLoanRequest.getApplicantDOB(), "yyyy-MM-dd"));

        }
          //  et_DOB.setText(personalLoanRequest.getApplicantDOB());

        if (personalLoanRequest.getApplicantIncome() != null)
            etMonthlyInc.setText("" + personalLoanRequest.getApplicantIncome());

            if (personalLoanRequest.getContact() != null)
            etcontact.setText("" + personalLoanRequest.getContact());

            if (personalLoanRequest.getpanno() != null)
                etPAN.setText("" + personalLoanRequest.getpanno());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setListener() {
        sbTenure.setOnSeekBarChangeListener(this);
        btnGetQuote.setOnClickListener(this);
        et_DOB.setOnClickListener(datePickerDialogApplicant);

        txtrbimgMale.setOnClickListener(this);
        txtrbimgFemale.setOnClickListener(this);
        etPAN.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.txtrbimgMale) {

            setApp_Male_gender();
        }
        else if (v.getId() == R.id.txtrbimgFemale) {

            setApp_FeMale_gender();
        }
        else if (v.getId() == R.id.btnGetQuote) {
            new TrackingController(getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Get quote PL : Get quote button for PL"), Constants.PERSONA_LOAN), null);
            //region Validation
            String NameOfApplicant = etNameOfApplicant.getText().toString();
            String DOB = getYYYYMMDDPattern(et_DOB.getText().toString());
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

                etCostOfProp.setError("Please Enter Required Loan Amount.");
                etCostOfProp.requestFocus();
                return;

            }

            // endregion
            setApplicantDetails();

          //  new PersonalLoanController(getActivity()).getPersonalLoan(personalLoanRequest, this);
            ((PLMainActivity) getActivity()).getQuoteParameterBundle(fmPersonalLoanRequest);

        }

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId()) {
            case R.id.sbTenure:
                int MIN = 0;
                if (progress >= MIN) {
                    if (fromUser) {
                        // progress = ((int) Math.round(progress / seekBarTenureProgress)) * seekBarTenureProgress;
                        etTenureInYear.setText(String.valueOf(progress+1));
                    }
                } else {
                    sbTenure.setProgress(MIN);
                    etTenureInYear.setText(String.valueOf(MIN));
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


    private void setApp_Male_gender() {
        GenderApplicantSource = "M";
        txtrbimgMale.setBackgroundResource(R.drawable.customeborder_blue);
        txtrbimgMale.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

        txtrbimgFemale.setBackgroundResource(R.drawable.customeborder);
        txtrbimgFemale.setTextColor(ContextCompat.getColor(getActivity(), R.color.description_text));


    }

    private void setApp_FeMale_gender() {
        GenderApplicantSource = "F";
        txtrbimgFemale.setBackgroundResource(R.drawable.customeborder_blue);
        txtrbimgFemale.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

        txtrbimgMale.setBackgroundResource(R.drawable.customeborder);
        txtrbimgMale.setTextColor(ContextCompat.getColor(getActivity(), R.color.description_text));


    }

    //endegion


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }



}
