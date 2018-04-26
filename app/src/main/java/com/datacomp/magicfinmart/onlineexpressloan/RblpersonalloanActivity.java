package com.datacomp.magicfinmart.onlineexpressloan;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.creditcard.ICICICreditApplyActivity;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CreditCardEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.CCICICIRequestEntity;

public class RblpersonalloanActivity extends AppCompatActivity {
    CardView ccPersonal, ccCompantDetail, ccQuoteDetail;

    Button btnSubmit;

    TextInputLayout tlFirstName, tlMiddleName, tlLastName;

    //personal detail
    EditText etFirstName, etMiddleName, etLastName, etDOB, etMonthlyIncome, etMobile, etEmailPers, etEMI, etLivingSince, etPincode;

    Spinner spResType, spSalaried, spTenure, spOrgCategory, spQualification;
    RadioButton rbmale, rbfemale, rbOther;

    //Quote detail

    //Company detail
    EditText etEmployerName, etLoanAmount, etLoanReq, etRateType, etBestRate, etQuteEMI, etProcessingFees,
            etJoin, etTotWorkExp, etOffAddress1, etOffAddress2, etOffPincode, etOffphoneNo, etOffPancard;
    Spinner spICICIRelationShip, spTypeCompany;
    RadioButton rbSavingAccYes;
    EditText etICICINumber;


    AutoCompleteTextView acOffCity, accCity;


    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


    //spinner Adapters
    ArrayAdapter<String> residenceAdapter, salariedAdapter, tenureAdapter;
    ArrayAdapter<String> OrgCategoryAdapter, QualificationAdapter;


    String[] stateList = {"ANDAMAN-NICOBAR", "ANDHRA PRADESH", "ARUNACHAL PRADESH", "ASSAM", "BIHAR", "CHANDIGARH", "CHHATTISGARH", "DADRA & NAGAR HAVELI", "DAMAN & DIU", "DELHI", "GOA", "GUJARAT", "HARYANA",
            "HIMACHAL PRADESH", "JAMMU KASHMIR", "JHARKHAND", "KARNATAKA", "KERALA", "LAKSHADWEEP", "MADHYA PRADESH", "MAHARASHTRA", "MANIPUR", "MEGHALAYA", "MIZORAM", "NAGALAND", "ORISSA",
            "PONDICHERRY", "PUNJAB", "RAJASTHAN", "SIKKIM", "TAMILNADU", "TRIPURA", "UTTAR PRADESH", "UTTARAKHAND", "WEST BENGAL"};

    ArrayAdapter<String> cityAdapter;
    List<String> cityList;
    ArrayAdapter<String> stateAdapter;

    CCICICIRequestEntity requestEntity;
    CreditCardEntity creditCardEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rblpersonalloan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        init();
        setListner();
        bindAllSpinner();

    }

    private void init() {


        ccPersonal = (CardView) findViewById(R.id.ccPersonal);
        ccCompantDetail = (CardView) findViewById(R.id.ccCompantDetail);
        ccQuoteDetail = (CardView) findViewById(R.id.ccQuoteDetail);

        //accCity = (AutoCompleteTextView) findViewById(R.id.accCity);
        accCity = (AutoCompleteTextView) findViewById(R.id.acOffCity);
        acOffCity = (AutoCompleteTextView) findViewById(R.id.acOffCity);

        //region personal detail
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etMiddleName = (EditText) findViewById(R.id.etMiddleName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etDOB = (EditText) findViewById(R.id.etDOB);

        etMonthlyIncome = (EditText) findViewById(R.id.etMonthlyIncome);
        etMobile = (EditText) findViewById(R.id.etMobile);
        etEmailPers = (EditText) findViewById(R.id.etEmailPers);
        etEMI = (EditText) findViewById(R.id.etEMI);
        etLivingSince = (EditText) findViewById(R.id.etLivingSince);
        etPincode = (EditText) findViewById(R.id.etPincode);


        spResType = (Spinner) findViewById(R.id.spResType);
        spSalaried = (Spinner) findViewById(R.id.spSalaried);
        spTenure = (Spinner) findViewById(R.id.spTenure);


        rbmale = (RadioButton) findViewById(R.id.rbmale);
        rbfemale = (RadioButton) findViewById(R.id.rbfemale);
        rbOther = (RadioButton) findViewById(R.id.rbOther);
        //endregion

        //region company detail
        etEmployerName = (EditText) findViewById(R.id.etEmployerName);
        etLoanAmount = (EditText) findViewById(R.id.etLoanAmount);
        etLoanReq = (EditText) findViewById(R.id.etLoanReq);
        etRateType = (EditText) findViewById(R.id.etRateType);

        etBestRate = (EditText) findViewById(R.id.etBestRate);
        etQuteEMI = (EditText) findViewById(R.id.etQuteEMI);
        etProcessingFees = (EditText) findViewById(R.id.etProcessingFees);

        etJoin = (EditText) findViewById(R.id.etJoin);
        etTotWorkExp = (EditText) findViewById(R.id.etTotWorkExp);
        etOffAddress1 = (EditText) findViewById(R.id.etOffAddress1);
        etOffAddress2 = (EditText) findViewById(R.id.etOffAddress2);

        etOffPincode = (EditText) findViewById(R.id.etOffPincode);
        etOffphoneNo = (EditText) findViewById(R.id.etOffphoneNo);
        etOffPancard = (EditText) findViewById(R.id.etOffPancard);

        spOrgCategory = (Spinner) findViewById(R.id.spOrgCategory);
        spQualification = (Spinner) findViewById(R.id.spQualification);


        //endregion

        btnSubmit = (Button) findViewById(R.id.rbOther);


    }

    private void bindAllSpinner() {

        //region RESIDENCE
        residenceAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.exp_residence_type)) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(RblpersonalloanActivity.this);
                    convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
                }
                // android.R.id.text1 is default text view in resource of the android.
                // android.R.layout.simple_spinner_item is default layout in resources of android.

                TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
                String[] items = getResources().getStringArray(R.array.exp_residence_type);
                tv.setText(items[position]);
                tv.setTextColor(Color.BLACK);
                tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                return convertView;
            }

            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }

        };
        spResType.setAdapter(residenceAdapter);


        //endregion

        //region SALARIED
        salariedAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.exp_employment_salaried)) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(RblpersonalloanActivity.this);
                    convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
                }
                // android.R.id.text1 is default text view in resource of the android.
                // android.R.layout.simple_spinner_item is default layout in resources of android.

                TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
                String[] items = getResources().getStringArray(R.array.exp_employment_salaried);
                tv.setText(items[position]);
                tv.setTextColor(Color.BLACK);
                tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                return convertView;
            }

            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }

        };
        spSalaried.setAdapter(salariedAdapter);


        //endregion

        //region Tenure
        tenureAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.exp_tenure)) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(RblpersonalloanActivity.this);
                    convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
                }
                // android.R.id.text1 is default text view in resource of the android.
                // android.R.layout.simple_spinner_item is default layout in resources of android.

                TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
                String[] items = getResources().getStringArray(R.array.exp_tenure);
                tv.setText(items[position]);
                tv.setTextColor(Color.BLACK);
                tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                return convertView;
            }

            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }

        };
        spTenure.setAdapter(tenureAdapter);


        //endregion

        //region Org Category
        OrgCategoryAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.exp_organization)) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(RblpersonalloanActivity.this);
                    convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
                }
                // android.R.id.text1 is default text view in resource of the android.
                // android.R.layout.simple_spinner_item is default layout in resources of android.

                TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
                String[] items = getResources().getStringArray(R.array.exp_organization);
                tv.setText(items[position]);
                tv.setTextColor(Color.BLACK);
                tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                return convertView;
            }

            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }

        };
        spOrgCategory.setAdapter(OrgCategoryAdapter);


        //endregion

        //region Tenure
        QualificationAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.exp_organization)) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(RblpersonalloanActivity.this);
                    convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
                }
                // android.R.id.text1 is default text view in resource of the android.
                // android.R.layout.simple_spinner_item is default layout in resources of android.

                TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
                String[] items = getResources().getStringArray(R.array.exp_organization);
                tv.setText(items[position]);
                tv.setTextColor(Color.BLACK);
                tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                return convertView;
            }

            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }

        };
        spQualification.setAdapter(QualificationAdapter);


        //endregion


    }

    private void setListner() {
        etDOB.setOnClickListener(datePickerDialog);
        etJoin.setOnClickListener(datePickerDialog);
    }

    //region datepicker

    protected View.OnClickListener datePickerDialog = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (view.getId() == R.id.etDOB) {
                DateTimePicker.showHealthAgeDatePicker(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                        if (view1.isShown()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(year, monthOfYear, dayOfMonth);
                            String currentDay = simpleDateFormat.format(calendar.getTime());
                            etDOB.setText(currentDay);
                        }
                    }
                });
            } else if (view.getId() == R.id.etJoin) {
                DateTimePicker.showDatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                        if (view1.isShown()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(year, monthOfYear, dayOfMonth);
                            String currentDay = simpleDateFormat.format(calendar.getTime());
                            etJoin.setText(currentDay);
                        }
                    }
                });
            }

        }
    };

    //endregion
}
