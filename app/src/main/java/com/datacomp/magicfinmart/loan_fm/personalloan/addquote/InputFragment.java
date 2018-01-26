package com.datacomp.magicfinmart.loan_fm.personalloan.addquote;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import java.util.Calendar;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.personalloan.PersonalLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CustomerApplicationEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CustomerEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetPersonalLoanResponse;

/**
 * Created by Rajeev Ranjan on 24/01/2018.
 */

public class InputFragment extends BaseFragment implements View.OnClickListener, IResponseSubcriber, SeekBar.OnSeekBarChangeListener, TextWatcher {

    PersonalLoanRequest personalLoanRequest;
    CustomerEntity customerEntity;
    CustomerApplicationEntity customerApplicationEntity;
    GetPersonalLoanResponse getPersonalLoanResponse;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Button btnGetQuote;
    EditText etNameOfApplicant, et_DOB, etMonthlyInc, etEMI, etTurnOver;
    Spinner sbSalary;
    ArrayAdapter<String> salaryTypeAdapter;
    LinearLayout llSalaried, llSelfEmployeed;
    SeekBar sbMonthlyInc, sbTurnOver;

    RadioGroup rgGender;
    RadioButton rbimgMale, rbimgFemale;

    //region PropertyIndo
    EditText etCostOfProp, etTenureInYear;
    TextView  txtDispalayMinTenureYear, txtDispalayMaxTenureYear;
    SeekBar  sbTenure;
    Context mContext;



    int seekBarTenureProgress = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_add_plquote, container, false);
        initilize(view);
        setListener();
        loadSpinner();

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
        //endregion
        //region Property Initialize
        etCostOfProp = (EditText) view.findViewById(R.id.etCostOfProp);
        txtDispalayMinTenureYear = (TextView) view.findViewById(R.id.txtDispalayMinTenureYear);
        txtDispalayMaxTenureYear = (TextView) view.findViewById(R.id.txtDispalayMaxTenureYear);
        etTenureInYear = (EditText) view.findViewById(R.id.etTenureInYear);

        sbTenure = (SeekBar) view.findViewById(R.id.sbTenure);
        //txtMaxLoanAmntAllow.setText(String.format("%.2f", getPercent(500000)));
        sbTenure.setMax(5);
        sbTenure.setProgress(1);
        etTenureInYear.setText("1");

        //region Applicant Initialize
        llSelfEmployeed = (LinearLayout) view.findViewById(R.id.llSelfEmployeed);
        llSalaried = (LinearLayout) view.findViewById(R.id.llSalaried);
        etNameOfApplicant = (EditText) view.findViewById(R.id.etNameOfApplicant);
        etTurnOver = (EditText) view.findViewById(R.id.etTurnOver);

        et_DOB = (EditText) view.findViewById(R.id.et_DOB);
        sbSalary = (Spinner) view.findViewById(R.id.sbSalary);
        sbMonthlyInc = (SeekBar) view.findViewById(R.id.sbMonthlyInc);
        sbTurnOver = (SeekBar) view.findViewById(R.id.sbTurnOver);

        etMonthlyInc = (EditText) view.findViewById(R.id.etMonthlyInc);
        etEMI = (EditText) view.findViewById(R.id.etEMI);

        rgGender = (RadioGroup) view.findViewById(R.id.rgGender);
        rbimgMale = (RadioButton) view.findViewById(R.id.rbimgMale);
        rbimgFemale = (RadioButton) view.findViewById(R.id.rbimgFemale);

        sbTurnOver.setMax(1000);    // 100 cr
        sbTurnOver.setProgress(10);  // 10 lac
        etTurnOver.setText("1000000");


        sbMonthlyInc.setMax(2500);
        sbMonthlyInc.setProgress(1);


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

    private void loadSpinner() {


        salaryTypeAdapter = new   ArrayAdapter<String>(getActivity(), R.layout.sp_item_textview, R.id.txtspinneritem, getResources().getStringArray(R.array.IncomeSource));

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
        //  personalLoanRequest.setBrokerId("" + new LoginFacade(PersonalLoanActivity.this).getUser().getBrokerId());
        //   personalLoanRequest.setempcode("" + new LoginFacade(PersonalLoanActivity.this).getUser().getEmpCode());



        //endregion
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
            new PersonalLoanController(getActivity()).getPersonalLoan(personalLoanRequest, this);

        }

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

    //endegion

    @Override
    public void OnSuccess(APIResponse response, String message) {

        cancelDialog();
        if (response instanceof GetPersonalLoanResponse) {
            if (response.getStatus_Id() == 0) {

                ((PLMainActivity)mContext).setQuoteCheck();

                getPersonalLoanResponse = ((GetPersonalLoanResponse) response);

                Bundle bundle = new Bundle();
                bundle.putParcelable(Constants.PERSONAL_LOAN_QUOTES, getPersonalLoanResponse);
                bundle.putParcelable(Constants.PL_REQUEST, personalLoanRequest);
                QuoteFragment quoteFragment = new QuoteFragment();
                quoteFragment.setArguments(bundle);
                FragmentTransaction transaction_quote = getActivity().getSupportFragmentManager().beginTransaction();
                transaction_quote.replace(R.id.frame_layout, quoteFragment, "QUOTE");
                transaction_quote.addToBackStack("QUOTE");
                transaction_quote.show(quoteFragment);
                //  transaction_quote.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction_quote.commit();




            } else {
                Toast.makeText(getActivity(), response.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        // startActivity(new Intent(HomeLoanActivity.this, QuoteActivity.class).putParcelableArrayListExtra(Constants.QUOTES, (ArrayList<QuoteEntity>) quoteEntities));
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

    }


}
