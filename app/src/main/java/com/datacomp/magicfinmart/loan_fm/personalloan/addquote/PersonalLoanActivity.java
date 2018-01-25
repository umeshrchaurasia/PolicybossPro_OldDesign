package com.datacomp.magicfinmart.loan_fm.personalloan.addquote;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.addquote.AddQuoteActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.personalloan.PersonalLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CustomerApplicationEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CustomerEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetPersonalLoanResponse;

public class PersonalLoanActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber, SeekBar.OnSeekBarChangeListener, TextWatcher {

    PersonalLoanRequest personalLoanRequest;
    CustomerEntity customerEntity;
    CustomerApplicationEntity customerApplicationEntity;

    Toolbar toolbar;
    GetPersonalLoanResponse getPersonalLoanResponse;
    LinearLayout llApplicantDetail, ll_chkCoApplicant;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    boolean isApplicantVisible = true;
    Button btnGetQuote;

    EditText etNameOfApplicant, et_DOB, etMonthlyInc, etEMI, etTurnOver, etProfitAtTax, etDepreciation, etDirecPartRemuntion;
    Spinner sbSalary;
    ArrayAdapter<String> salaryTypeAdapter;
    LinearLayout llSalaried, llSelfEmployeed;
    SeekBar sbMonthlyInc, sbTurnOver;
    CheckBox chkCoApplicant;
    RadioGroup rgGender;
    RadioButton rbimgMale, rbimgFemale;

    //region PropertyIndo
    EditText etCostOfProp, etTenureInYear;
    TextView  txtDispalayMinTenureYear, txtDispalayMaxTenureYear;
    SeekBar  sbTenure;

    int seekBarTenureProgress = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plquote);
        init_widgets();
        setListener();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        loadSpinner();

        if (getIntent().getBooleanExtra("IS_EDIT", false)) {
            customerEntity = getIntent().getParcelableExtra("CUST_DETAILS");
            fillCustomerDetails(customerEntity);
        }
        if (getIntent().getBooleanExtra("IS_APP_EDIT", false)) {
            customerApplicationEntity = getIntent().getParcelableExtra("CUST_APP_DETAILS");
            fillCustomerApplicationDetails(customerApplicationEntity);
        }

    }

    private void fillCustomerApplicationDetails(CustomerApplicationEntity customerEntity) {
        if (customerEntity.getLoanRequired() != null)
            etCostOfProp.setText(customerEntity.getLoanRequired());
        if (customerEntity.getLoanTenure() != null)
            etTenureInYear.setText(customerEntity.getLoanTenure());
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
            etTenureInYear.setText(customerEntity.getLoanTenure());
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

    private void init_widgets() {

        //region Main Initialize
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        llApplicantDetail = (LinearLayout) findViewById(R.id.llApplicantDetail);

        btnGetQuote = (Button) findViewById(R.id.btnGetQuote);
        //endregion
        //region Property Initialize
        etCostOfProp = (EditText) findViewById(R.id.etCostOfProp);
        txtDispalayMinTenureYear = (TextView) findViewById(R.id.txtDispalayMinTenureYear);
        txtDispalayMaxTenureYear = (TextView) findViewById(R.id.txtDispalayMaxTenureYear);
        etTenureInYear = (EditText) findViewById(R.id.etTenureInYear);

        sbTenure = (SeekBar) findViewById(R.id.sbTenure);
        //txtMaxLoanAmntAllow.setText(String.format("%.2f", getPercent(500000)));
        sbTenure.setMax(5);
        sbTenure.setProgress(1);
        etTenureInYear.setText("1");

        //region Applicant Initialize
        llSelfEmployeed = (LinearLayout) findViewById(R.id.llSelfEmployeed);
        llSalaried = (LinearLayout) findViewById(R.id.llSalaried);
        etNameOfApplicant = (EditText) findViewById(R.id.etNameOfApplicant);
        etTurnOver = (EditText) findViewById(R.id.etTurnOver);

        et_DOB = (EditText) findViewById(R.id.et_DOB);
        sbSalary = (Spinner) findViewById(R.id.sbSalary);
        sbMonthlyInc = (SeekBar) findViewById(R.id.sbMonthlyInc);
        sbTurnOver = (SeekBar) findViewById(R.id.sbTurnOver);

        etMonthlyInc = (EditText) findViewById(R.id.etMonthlyInc);
        etEMI = (EditText) findViewById(R.id.etEMI);

        rgGender = (RadioGroup) findViewById(R.id.rgGender);
        rbimgMale = (RadioButton) findViewById(R.id.rbimgMale);
        rbimgFemale = (RadioButton) findViewById(R.id.rbimgFemale);

        sbTurnOver.setMax(1000);    // 100 cr
        sbTurnOver.setProgress(10);  // 10 lac
        etTurnOver.setText("1000000");


        sbMonthlyInc.setMax(2500);
        sbMonthlyInc.setProgress(1);



        //endregion
    }

    //region datePickerDialog Applicant
    protected View.OnClickListener datePickerDialogApplicant = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Constants.hideKeyBoard(view, getApplicationContext());
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


    private void altervisibleApplicant() {
//        if (isApplicantVisible) {
//            txtApplicantDetail.setText(" Application Details");
//            txtApplicantDetail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_arrow_bas_screen, 0);
//            llApplicantDetail.setVisibility(View.GONE);
//            isApplicantVisible = false;
//        } else {
//            txtApplicantDetail.setText(" Application Details");
//            txtApplicantDetail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_arrow_bas_screen, 0);
//            llApplicantDetail.setVisibility(View.VISIBLE);
//            isApplicantVisible = true;
//        }
    }

    private void setListener() {
        sbTenure.setOnSeekBarChangeListener(this);
        sbTurnOver.setOnSeekBarChangeListener(this);


        sbMonthlyInc.setOnSeekBarChangeListener(this);



        btnGetQuote.setOnClickListener(this);
        et_DOB.setOnClickListener(datePickerDialogApplicant);


        //region CheckBox  Co-Applicant  Listener


        etCostOfProp.addTextChangedListener(this);
        etTenureInYear.addTextChangedListener(this);
        etMonthlyInc.addTextChangedListener(this);
        etTurnOver.addTextChangedListener(this);


    }

//    private void visibleApplicant() {
//
//        txtApplicantDetail.setText(" Application Details");
//        txtApplicantDetail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_arrow_bas_screen, 0);
//        // llApplicantDetail.setVisibility(visibility);
//        //isApplicantVisible = true;
//
//    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
         if (etTenureInYear.getText().hashCode() == s.hashCode()) {

            if (!etTenureInYear.getText().toString().equals("") && !etTenureInYear.getText().toString().equals(null)) {
                int tenureInYear = Integer.parseInt(etTenureInYear.getText().toString());
                sbTenure.setProgress(tenureInYear);

            }

        } else if (etTurnOver.getText().hashCode() == s.hashCode()) {

            if (!etTurnOver.getText().toString().equals("") && !etTurnOver.getText().toString().equals(null)) {
                int turnOver = Integer.parseInt(etTurnOver.getText().toString());
                sbTurnOver.setProgress(turnOver / 1000000);
            }
        } else if (etMonthlyInc.getText().hashCode() == s.hashCode()) {

            if (!etMonthlyInc.getText().toString().equals("") && !etMonthlyInc.getText().toString().equals(null)) {
                int monthlyInc = Integer.parseInt(etMonthlyInc.getText().toString());

                if (monthlyInc > 25000) {
                    sbMonthlyInc.setProgress(monthlyInc / 1000);
                } else {
                    sbMonthlyInc.setProgress(1);
                    etMonthlyInc.setSelection(etMonthlyInc.getText().length());
                }


            }

        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGetQuote) {
            //region Validation
            //region Property Validation
            String CostOfProp = etCostOfProp.getText().toString();
            String TenureInYear = etTenureInYear.getText().toString();
            if (TextUtils.isEmpty(CostOfProp)) {

                etCostOfProp.setError("Please Enter Cost Of Property.");
                etCostOfProp.requestFocus();
                return;

            }
            if (TextUtils.isEmpty(TenureInYear)) {

                etTenureInYear.setError("Please Enter Tenure.");
                etTenureInYear.requestFocus();
                return;

            }
            //endregion
            //region Applicant Validation
            String NameOfApplicant = etNameOfApplicant.getText().toString();
            String DOB = et_DOB.getText().toString();
            String MonthlyInc = etMonthlyInc.getText().toString();
            String TurnOver = etTurnOver.getText().toString();


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
            if (sbSalary.getSelectedItem().equals("Salaried")) {
                if (TextUtils.isEmpty(MonthlyInc)) {

                    etMonthlyInc.setError("Please Enter Monthly Income.");
                    etMonthlyInc.requestFocus();
                    return;

                }
            } else {
                if (TextUtils.isEmpty(TurnOver)) {

                    etTurnOver.setError("Please Enter Turnover.");
                    etTurnOver.requestFocus();
                    return;
                }
                // End Applicant
            }/////
            //endregion
            // endregion
            setApplicantDetails();
            showDialog();
            new PersonalLoanController(PersonalLoanActivity.this).getPersonalLoan(personalLoanRequest, this);

        }
    }

    private void loadSpinner() {


        salaryTypeAdapter = new   ArrayAdapter<String>(PersonalLoanActivity.this, R.layout.sp_item_textview, R.id.txtspinneritem, getResources().getStringArray(R.array.IncomeSource));

        sbSalary.setAdapter(salaryTypeAdapter);
        sbSalary.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Salaried")) {
                    // do your stuff
                    llSalaried.setVisibility(View.VISIBLE);
                    llSelfEmployeed.setVisibility(View.GONE);
                } else if (selectedItem.equals("Self-Employed")) {
                    llSalaried.setVisibility(View.GONE);
                    llSelfEmployeed.setVisibility(View.VISIBLE);
                }
            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //endregion


    }

    private void setApplicantDetails() {
        // region  HomeLoanRequest Binding

        personalLoanRequest = new PersonalLoanRequest();
        personalLoanRequest.setLoanRequired(etCostOfProp.getText().toString());
        personalLoanRequest.setLoanTenure(etTenureInYear.getText().toString());
        personalLoanRequest.setApplicantNme(etNameOfApplicant.getText().toString());

//        if (sbSalary.getSelectedItem().toString().contains("Salaried")) {
//            personalLoanRequest.setApplicantSource("1");
//        } else if (sbSalary.getSelectedItem().toString().contains("Self-Employed")) {
//            personalLoanRequest.setApplicantSource("2");
//        }

        // region Default Salaried
        personalLoanRequest.setApplicantSource("1");
        //endregion
        if (personalLoanRequest.getApplicantSource() == "1") {
            personalLoanRequest.setApplicantIncome(etMonthlyInc.getText().toString());
        } else if (personalLoanRequest.getApplicantSource() == "2") {
            personalLoanRequest.setApplicantIncome(etTurnOver.getText().toString());
            //same in personal loan

        }

        if (rbimgMale.isChecked()) {
            personalLoanRequest.setApplicantGender("M");
        } else {
            personalLoanRequest.setApplicantGender("F");
        }

        personalLoanRequest.setApplicantObligations(etEMI.getText().toString());
        personalLoanRequest.setApplicantDOB(et_DOB.getText().toString());

        personalLoanRequest.setBrokerId("RBAAPP");

        personalLoanRequest.setBrokerId("" + "0");
        personalLoanRequest.setempcode("" + "Rb40000428");
        personalLoanRequest.setApi_source("Finmart");
      //  personalLoanRequest.setBrokerId("" + new LoginFacade(PersonalLoanActivity.this).getUser().getBrokerId());
     //   personalLoanRequest.setempcode("" + new LoginFacade(PersonalLoanActivity.this).getUser().getEmpCode());



        //endregion
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.sbTenure:
                if (progress >= seekBarTenureProgress) {
                    if (fromUser) {
                        // progress = ((int) Math.round(progress / seekBarTenureProgress)) * seekBarTenureProgress;
                        etTenureInYear.setText(String.valueOf(progress));
                    }
                } else {
                    etTenureInYear.setText(String.valueOf((long) seekBarTenureProgress));
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

    @Override
    public void OnSuccess(APIResponse response, String message){
        cancelDialog();
        if (response instanceof GetPersonalLoanResponse) {
            if (response.getStatus_Id() == 0) {


                getPersonalLoanResponse = ((GetPersonalLoanResponse) response);
                startActivity(new Intent(PersonalLoanActivity.this, PersonalLoanQuoteActivity.class)
                        .putExtra(Constants.PERSONAL_LOAN_QUOTES, getPersonalLoanResponse)
                        .putExtra(Constants.PL_REQUEST, personalLoanRequest));

            } else {
                Toast.makeText(PersonalLoanActivity.this, response.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        // startActivity(new Intent(HomeLoanActivity.this, QuoteActivity.class).putParcelableArrayListExtra(Constants.QUOTES, (ArrayList<QuoteEntity>) quoteEntities));
        Toast.makeText(PersonalLoanActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }
    private BigDecimal getMaxLoanAmount(String value) {
        double loanAmount = Double.parseDouble(value);
        return BigDecimal.valueOf(Math.ceil(loanAmount * .8)).setScale(0, BigDecimal.ROUND_HALF_UP);
    }

}
