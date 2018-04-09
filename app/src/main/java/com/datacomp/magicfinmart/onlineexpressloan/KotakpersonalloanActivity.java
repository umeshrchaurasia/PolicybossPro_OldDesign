package com.datacomp.magicfinmart.onlineexpressloan;

import android.app.DatePickerDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CreditCardEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.CCICICIRequestEntity;

public class KotakpersonalloanActivity extends BaseActivity implements View.OnClickListener,IResponseSubcriber {


    CardView ccPersonal, ccCompantDetail, ccCurrentAddress, ccContactDetail;
    CheckBox chkTermsCondition, chkSameAsAbove;
    Button btnICICINext;

    TextInputLayout tlCreditLimit, tlMemberSince, tlBank;

    //personal detail
    EditText etFirstName, etLastName, etDOB, etMotherName, etCardName;
    Spinner spNoOfDependents, spSupplementaryCard, spMailingAddress;
    RadioButton rbmale, rbSingle, rbIndian, rbSalaried;

    //Company detail
    EditText etCompany, etDesignation, etWorkEmail, etIncome, etAreaCode, etPhoneNumber, etTotalExp;
    Spinner spQualification, spICICIRelationShip, spTypeCompany;
    RadioButton rbSavingAccYes;
    EditText etICICINumber;

    //current address
    EditText etFlatNo, etBuildingName, etArea, etPincode;
    AutoCompleteTextView acCity, acState;
    Spinner spResidenceType;

    //permanent address
    EditText etPerFlatNo, etPerBuildingName, etPerArea, etPerPincode;
    AutoCompleteTextView acPerCity, acPerState;
    Spinner spPerResidenceType;

    //contact detail
    EditText etStdCode, etTelephoneNo, etMobileNo, etBankName;
    EditText etMemberSince, etCreditLimit, etPancard;
    Spinner spSalaryAccountType;
    RadioButton rbHaveCC;


    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


    //spinner Adapters
    ArrayAdapter<String> noOfDependentsAdapter, supplemetryCardAdapter, mailingAddressAdapter;

    ArrayAdapter<String> qualificationAdapter, iciciRelationshipAdapter, typeCompanyAdapter;
    ArrayAdapter<String> residenceTypeAdapter, perResidenceTypeAdapter, salaryAccountTypeAdapter;


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
        setContentView(R.layout.activity_kotakpersonalloan);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        creditCardEntity = new CreditCardEntity();

        requestEntity = new CCICICIRequestEntity();
        init();
        setListener();
    }

    private void init() {

        tlCreditLimit = (TextInputLayout) findViewById(R.id.tlCreditLimit);
        tlMemberSince = (TextInputLayout) findViewById(R.id.tlMemberSince);
        tlBank = (TextInputLayout) findViewById(R.id.tlBank);

        ccPersonal = (CardView) findViewById(R.id.ccPersonal);
        ccCompantDetail = (CardView) findViewById(R.id.ccCompantDetail);
        ccCurrentAddress = (CardView) findViewById(R.id.ccCurrentAddress);
        ccContactDetail = (CardView) findViewById(R.id.ccContactDetail);
        chkTermsCondition = (CheckBox) findViewById(R.id.chkTermsCondition);
        chkSameAsAbove = (CheckBox) findViewById(R.id.chkSameAsAbove);
        btnICICINext = (Button) findViewById(R.id.btnICICINext);
        btnICICINext.setOnClickListener(this);

        //region personal detail
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etDOB = (EditText) findViewById(R.id.etDOB);
        etMotherName = (EditText) findViewById(R.id.etMotherName);
        etCardName = (EditText) findViewById(R.id.etCardName);


        spNoOfDependents = (Spinner) findViewById(R.id.spNoOfDependents);
        spSupplementaryCard = (Spinner) findViewById(R.id.spSupplementaryCard);
        spMailingAddress = (Spinner) findViewById(R.id.spMailingAddress);

        rbmale = (RadioButton) findViewById(R.id.rbmale);
        rbSingle = (RadioButton) findViewById(R.id.rbSingle);
        rbIndian = (RadioButton) findViewById(R.id.rbIndian);
        rbSalaried = (RadioButton) findViewById(R.id.rbSalaried);
        //endregion

        //region company detail
        etCompany = (EditText) findViewById(R.id.etCompany);
        etDesignation = (EditText) findViewById(R.id.etDesignation);
        etWorkEmail = (EditText) findViewById(R.id.etWorkEmail);
        etIncome = (EditText) findViewById(R.id.etIncome);
        etAreaCode = (EditText) findViewById(R.id.etAreaCode);
        etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);
        etTotalExp = (EditText) findViewById(R.id.etTotalExp);
        etICICINumber = (EditText) findViewById(R.id.etICICINumber);
        etICICINumber.setVisibility(View.GONE);
        spQualification = (Spinner) findViewById(R.id.spQualification);
        spICICIRelationShip = (Spinner) findViewById(R.id.spICICIRelationShip);
        spTypeCompany = (Spinner) findViewById(R.id.spTypeCompany);

        rbSavingAccYes = (RadioButton) findViewById(R.id.rbSavingAccYes);
        //endregion

        //region current address

        etFlatNo = (EditText) findViewById(R.id.etFlatNo);
        etBuildingName = (EditText) findViewById(R.id.etBuildingName);
        etArea = (EditText) findViewById(R.id.etArea);
        etPincode = (EditText) findViewById(R.id.etPincode);

        acCity = (AutoCompleteTextView) findViewById(R.id.acCity);
        acState = (AutoCompleteTextView) findViewById(R.id.acState);
        spResidenceType = (Spinner) findViewById(R.id.spResidenceType);
        //endregion

        //region permanent address

        etPerFlatNo = (EditText) findViewById(R.id.etPerFlatNo);
        etPerBuildingName = (EditText) findViewById(R.id.etPerBuildingName);
        etPerArea = (EditText) findViewById(R.id.etPerArea);
        etPerPincode = (EditText) findViewById(R.id.etPerPincode);

        acPerCity = (AutoCompleteTextView) findViewById(R.id.acPerCity);
        acPerState = (AutoCompleteTextView) findViewById(R.id.acPerState);
        spPerResidenceType = (Spinner) findViewById(R.id.spPerResidenceType);

        //endregion

        //region contact detail

        etStdCode = (EditText) findViewById(R.id.etStdCode);
        etTelephoneNo = (EditText) findViewById(R.id.etTelephoneNo);
        etMobileNo = (EditText) findViewById(R.id.etMobileNo);
        etBankName = (EditText) findViewById(R.id.etBankName);
        etMemberSince = (EditText) findViewById(R.id.etMemberSince);
        etCreditLimit = (EditText) findViewById(R.id.etCreditLimit);
        etPancard = (EditText) findViewById(R.id.etPancard);
        etPancard.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        etBankName.setVisibility(View.GONE);
        etMemberSince.setVisibility(View.GONE);
        etCreditLimit.setVisibility(View.GONE);

        spSalaryAccountType = (Spinner) findViewById(R.id.spSalaryAccountType);

        rbHaveCC = (RadioButton) findViewById(R.id.rbHaveCC);
        //endregion
    }

    private void setListener() {
        etDOB.setOnClickListener(datePickerDialog);
        btnICICINext.setOnClickListener(this);
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
            } else if (view.getId() == R.id.etMemberSince) {
                DateTimePicker.showDatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                        if (view1.isShown()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(year, monthOfYear, dayOfMonth);
                            String currentDay = simpleDateFormat.format(calendar.getTime());
                            etMemberSince.setText(currentDay);
                        }
                    }
                });
            }

        }
    };

    //endregion
    @Override
    public void onClick(View v) {

    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

    }

    @Override
    public void OnFailure(Throwable t) {

    }
}
