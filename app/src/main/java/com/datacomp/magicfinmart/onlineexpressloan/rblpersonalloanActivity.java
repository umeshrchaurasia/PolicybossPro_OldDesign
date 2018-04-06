package com.datacomp.magicfinmart.onlineexpressloan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.datacomp.magicfinmart.R;

import java.text.SimpleDateFormat;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CreditCardEntity;

public class rblpersonalloanActivity extends AppCompatActivity {

    CreditCardEntity mCreditCardEntity;
    EditText etFirstName, etLastName, etFatherName, etDob, etEmail;
    RadioButton rbmale, rbHadLoan, rbSalaried;
    EditText etCCApplied, etProcessingFees, etMobile, etpancard;
    EditText etAddress1, etAddress2, etLandMark, etPincode, etMonthlyIncome;
    AutoCompleteTextView acCity;
    Button btnSubmit;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    ArrayAdapter<String> cityAdapter;
    List<String> cityList;

    Spinner spTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rblpersonalloan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    private void init() {
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etFatherName = (EditText) findViewById(R.id.etFatherName);
        etDob = (EditText) findViewById(R.id.etDob);
        //etDob.setOnClickListener(datePickerDialog);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etCCApplied = (EditText) findViewById(R.id.etCCApplied);
        etProcessingFees = (EditText) findViewById(R.id.etProcessingFees);
        etMobile = (EditText) findViewById(R.id.etMobile);
        etpancard = (EditText) findViewById(R.id.etpancard);
        etpancard.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        etAddress1 = (EditText) findViewById(R.id.etAddress1);
        etAddress2 = (EditText) findViewById(R.id.etAddress2);
        etLandMark = (EditText) findViewById(R.id.etLandMark);
        etPincode = (EditText) findViewById(R.id.etPincode);
        etMonthlyIncome = (EditText) findViewById(R.id.etMonthlyIncome);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        acCity = (AutoCompleteTextView) findViewById(R.id.acCity);

        rbmale = (RadioButton) findViewById(R.id.rbmale);
        rbHadLoan = (RadioButton) findViewById(R.id.rbHadLoan);
        rbSalaried = (RadioButton) findViewById(R.id.rbSalaried);

        spTitle = (Spinner) findViewById(R.id.spTitle);

     //   btnSubmit.setOnClickListener(this);


    }
}
