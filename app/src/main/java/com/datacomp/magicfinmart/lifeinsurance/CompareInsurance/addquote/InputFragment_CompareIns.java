package com.datacomp.magicfinmart.lifeinsurance.CompareInsurance.addquote;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.personalloan.loan_apply.PersonalLoanApplyActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment_CompareIns extends BaseFragment implements View.OnClickListener {

    DBPersistanceController databaseController;

    LoginResponseEntity loginEntity;

    Button btnSubmit;
    EditText etReqLoanAmnt,etMobile ,et_DOB , etPincode,etSumAssured;
    TextView txtMale,txtFemale , txtYesSmoker,txtNoSmoker;
    Spinner spPolicyTerm,spPremTerm;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    String Gender = "Male";
    String Smoker = "No";
    public InputFragment_CompareIns() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_add_compareins_quote, container, false);
        init_widgets(view);
        setListener();
        return view;
    }

    private void init_widgets(View view) {
        etReqLoanAmnt = (EditText) view.findViewById(R.id.etReqLoanAmnt);
        etMobile = (EditText) view.findViewById(R.id.etMobile);
        et_DOB = (EditText) view.findViewById(R.id.et_DOB);
        etPincode = (EditText) view.findViewById(R.id.etPincode);
        etSumAssured = (EditText) view.findViewById(R.id.etSumAssured);

        txtMale = (TextView) view.findViewById(R.id.txtMale);
        txtFemale = (TextView) view.findViewById(R.id.txtFemale);
        txtYesSmoker = (TextView) view.findViewById(R.id.txtYesSmoker);
        txtNoSmoker = (TextView) view.findViewById(R.id.txtNoSmoker);

        spPolicyTerm = (Spinner) view.findViewById(R.id.spPolicyTerm);
        spPremTerm = (Spinner) view.findViewById(R.id.spPremTerm);
        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);

    }

    private void setListener() {
        btnSubmit.setOnClickListener(this);
        txtMale.setOnClickListener(this);
        txtFemale.setOnClickListener(this);
        txtYesSmoker.setOnClickListener(this);
        txtNoSmoker.setOnClickListener(this);
    }

    //region datePickerDialog DOB
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

    @Override
    public void onClick(View view) {
        Constants.hideKeyBoard(view, getActivity());
        switch (view.getId()) {
            case R.id.txtMale:
                seGender("Male", txtMale, txtFemale);
                break;

            case R.id.txtFemale:
                seGender("Female", txtFemale,txtMale);
                break;

            case R.id.txtYesSmoker:
                seSmoker("Yes", txtYesSmoker, txtNoSmoker);
                break;

            case R.id.txtNoSmoker:
                seSmoker("No", txtNoSmoker,txtYesSmoker);
                break;

        }

    }

    private void seGender(String Type, TextView clickedText, TextView textView1) {
        Gender = Type;

        clickedText.setBackgroundResource(R.drawable.customeborder_blue);
        clickedText.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

        textView1.setBackgroundResource(R.drawable.customeborder);
        textView1.setTextColor(ContextCompat.getColor(getActivity(), R.color.description_text));

    }

    private void seSmoker(String Type, TextView clickedText, TextView textView1) {
        Smoker = Type;

        clickedText.setBackgroundResource(R.drawable.customeborder_blue);
        clickedText.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

        textView1.setBackgroundResource(R.drawable.customeborder);
        textView1.setTextColor(ContextCompat.getColor(getActivity(), R.color.description_text));

    }
}
