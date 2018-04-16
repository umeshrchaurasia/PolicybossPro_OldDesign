package com.datacomp.magicfinmart.term.compareterm;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
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
import android.widget.Spinner;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.term.quoteapp.TermQuoteListFragment;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermRequestEntity;

public class TermInputFragment extends BaseFragment implements View.OnClickListener, BaseFragment.PopUpListener {

    Button btnGetQuote;
    EditText etFirstName, etLastName, etMobile;
    RadioButton rbMale, rbfemale, rbNoSmoker, rbYesSmoker;
    EditText etDOB;

    EditText etPincode, etSumAssured;
    List<String> policyYear;
    DBPersistanceController dbPersistanceController;
    Spinner spPolicyTerm, spPremTerm;
    ArrayAdapter<String> PolicyTermAdapter, PremTermAdapter;
    TermRequestEntity termRequestEntity;
    TermFinmartRequest termFinmartRequest;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    LinearLayout llCompareAll;
    View lllayoutICICI;


    //region icici form
    Spinner spICICIOptions, spICICIPremiumTerm, spICICIPremiumFrequency;
    TextView txtICICILumpSum, txtICICIRegularIncome, txtICICIIncreasingIncome;
    EditText etSumICICIAssured, etICICIPolicyTerm, etICICIPremiumTerm, etICICICriticalIllness, etICICIAccidentalBenefits;
    Button minusICICISum, plusICICISum, minusICICIPTerm, plusICICIPTerm,
            minusICICIPreTerm, plusICICIPreTerm, minusICICICritical, plusICICICritical, minusICICIAcc, plusICICIAcc;


    ArrayAdapter<String> policyOptionsAdapter, policyTermAdapter, premiumFrequencyAdapter;


    LinearLayout llICICIAccidental, llICICICritical;
    //endregion

    int insurerID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_term_compare_input, container, false);
        init(view);
        setListener();
        // set initial values
        dbPersistanceController = new DBPersistanceController(getActivity());
        policyYear = dbPersistanceController.getPremYearList();
        termRequestEntity = new TermRequestEntity();
        termFinmartRequest = new TermFinmartRequest();
        init_adapters();

        adapter_listener();
        if (getArguments() != null) {
            termFinmartRequest = getArguments().getParcelable(CompareTermActivity.INPUT_DATA);
            insurerID = getArguments().getInt(TermQuoteListFragment.TERM_FOR_INPUT_FRAGMENT);
            enableCompareInputs(insurerID);
            bindInput(termFinmartRequest);
        }
        return view;
    }

    private void enableCompareInputs(int insID) {
        switch (insID) {
            case 1001://compare term
                llCompareAll.setVisibility(View.VISIBLE);
                lllayoutICICI.setVisibility(View.GONE);
                break;
            case 43://edelwise
                break;
            case 28://hdfc
                break;
            case 39://icici
                llCompareAll.setVisibility(View.GONE);
                lllayoutICICI.setVisibility(View.VISIBLE);
                bindICICI();
                break;
            case 1://tata aig
                break;
            default:
                break;
        }

    }

    private void bindICICI() {
        etSumICICIAssured.setText("10000000");
        etICICICriticalIllness.setText("10000000");
        etICICIPolicyTerm.setText("20");
        etICICIPremiumTerm.setText("20");

        //by default Regular pay selected.
        spICICIPremiumTerm.setSelection(0);
    }

    AdapterView.OnItemSelectedListener optionSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (parent.getId() == R.id.spICICIOptions) {
                manipulateInputs(spICICIOptions.getSelectedItem().toString());

            } else if (parent.getId() == R.id.spICICIPremiumTerm) {

                String[] listOption = getActivity().getResources().getStringArray(R.array.icici_options);
                String[] listPremiumFrequency = getActivity().getResources()
                        .getStringArray(R.array.icici_premium_frequency);

                final List<String> optionsList = new ArrayList<>(Arrays.asList(listOption));
                final List<String> premiumFreqList = new ArrayList<>(Arrays.asList(listPremiumFrequency));

                switch (spICICIPremiumTerm.getSelectedItemPosition()) {
                    case 0:
                    case 2://show all
                        break;
                    case 1:
                        optionsList.remove("Life and health");
                        optionsList.remove("All in one");

                        premiumFreqList.remove("Half Yearly");
                        premiumFreqList.remove("Monthly");

                        break;

                }

                ArrayAdapter<String> spAdapterOptions = new ArrayAdapter<String>(getActivity()
                        , android.R.layout.simple_spinner_item
                        , optionsList);

                spAdapterOptions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spICICIOptions.setAdapter(spAdapterOptions);

                ArrayAdapter<String> spAdapterPremiumFreq = new ArrayAdapter<String>(getActivity()
                        , android.R.layout.simple_spinner_item
                        , premiumFreqList);

                spAdapterPremiumFreq.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spICICIPremiumFrequency.setAdapter(spAdapterPremiumFreq);


            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private void manipulateInputs(String s) {
        switch (s.toLowerCase()) {
            case "life":
                llICICICritical.setVisibility(View.GONE);
                llICICIAccidental.setVisibility(View.GONE);
                break;
            case "life plus":
                llICICICritical.setVisibility(View.GONE);
                llICICIAccidental.setVisibility(View.VISIBLE);
                break;
            case "life and health":
                llICICICritical.setVisibility(View.VISIBLE);
                llICICIAccidental.setVisibility(View.GONE);
                setDefaultValues("life and health");
                break;
            case "all in one":
                llICICICritical.setVisibility(View.VISIBLE);
                llICICIAccidental.setVisibility(View.VISIBLE);
                break;


        }
    }

    private void setDefaultValues(String strOptions) {
        if (strOptions.equals("life and health")) {
            etICICICriticalIllness.setText("100000");
        } else if (strOptions.equals("life plus")) {

        } else if (strOptions.equals("all in one")) {

        }
    }

    private void bindInput(TermFinmartRequest termFinmartRequest) {
        try {
            TermRequestEntity termRequestEntity = termFinmartRequest.getTermRequestEntity();
            if (termRequestEntity != null) {
                etDOB.setText("" + termRequestEntity.getInsuredDOB());
                etSumAssured.setText("" + termRequestEntity.getSumAssured());
                String[] splitStr = termRequestEntity.getContactName().split("\\s+");
                etFirstName.setText("" + splitStr[0]);
                etLastName.setText("" + splitStr[1]);
                etMobile.setText("" + termRequestEntity.getContactMobile());
                spPolicyTerm.setSelection((Integer.parseInt(termRequestEntity.getPolicyTerm()) - 5));
                spPolicyTerm.setSelection((Integer.parseInt(termRequestEntity.getPPT()) - 5));
                etPincode.setText("" + termRequestEntity.getPincode());
                if (termRequestEntity.getIs_TabaccoUser().equals("true"))
                    rbYesSmoker.setChecked(true);
                else
                    rbNoSmoker.setChecked(true);

                if (termRequestEntity.getInsuredGender().equals("M"))
                    rbMale.setChecked(true);
                else
                    rbfemale.setChecked(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setListener() {
        btnGetQuote.setOnClickListener(this);
        etDOB.setOnClickListener(datePickerDialog);

        txtICICILumpSum.setOnClickListener(this);
        txtICICIRegularIncome.setOnClickListener(this);
        txtICICIIncreasingIncome.setOnClickListener(this);

        minusICICISum.setOnClickListener(this);
        plusICICISum.setOnClickListener(this);
        minusICICIPTerm.setOnClickListener(this);
        plusICICIPTerm.setOnClickListener(this);
        minusICICIPreTerm.setOnClickListener(this);
        plusICICIPreTerm.setOnClickListener(this);
        minusICICICritical.setOnClickListener(this);
        plusICICICritical.setOnClickListener(this);
        minusICICIAcc.setOnClickListener(this);
        plusICICIAcc.setOnClickListener(this);
        spICICIOptions.setOnItemSelectedListener(optionSelected);
        spICICIPremiumTerm.setOnItemSelectedListener(optionSelected);
    }

    private void adapter_listener() {
        spPolicyTerm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spPremTerm.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void init_adapters() {
        PolicyTermAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, policyYear);
        spPolicyTerm.setAdapter(PolicyTermAdapter);
        spPolicyTerm.setSelection(15);

        PremTermAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, policyYear);
        spPremTerm.setAdapter(PremTermAdapter);
        spPremTerm.setSelection(15);
    }

    private void init(View view) {

        btnGetQuote = (Button) view.findViewById(R.id.btnGetQuote);
        etFirstName = (EditText) view.findViewById(R.id.etFirstName);
        etLastName = (EditText) view.findViewById(R.id.etLastName);
        etMobile = (EditText) view.findViewById(R.id.etMobile);
        etDOB = (EditText) view.findViewById(R.id.etDateofBirth);
        rbMale = (RadioButton) view.findViewById(R.id.rbmale);
        rbfemale = (RadioButton) view.findViewById(R.id.rbfemale);
        rbYesSmoker = (RadioButton) view.findViewById(R.id.rbYesSmoker);
        rbNoSmoker = (RadioButton) view.findViewById(R.id.rbNoSmoker);

        etPincode = (EditText) view.findViewById(R.id.etPincode);
        etSumAssured = (EditText) view.findViewById(R.id.etSumAssured);
        spPolicyTerm = (Spinner) view.findViewById(R.id.spPolicyTerm);
        spPremTerm = (Spinner) view.findViewById(R.id.spPremTerm);


        //Compare All
        llCompareAll = (LinearLayout) view.findViewById(R.id.llCompareAll);
        lllayoutICICI = (View) view.findViewById(R.id.layoutICICI);

        //region icici id
        llICICIAccidental = (LinearLayout) view.findViewById(R.id.llAccidental);
        llICICICritical = (LinearLayout) view.findViewById(R.id.llCritical);
        spICICIOptions = (Spinner) view.findViewById(R.id.spICICIOptions);
        spICICIPremiumTerm = (Spinner) view.findViewById(R.id.spICICIPremiumTerm);
        spICICIPremiumFrequency = (Spinner) view.findViewById(R.id.spICICIPremiumFrequency);

        txtICICILumpSum = (TextView) view.findViewById(R.id.txtICICILumpSum);
        txtICICIRegularIncome = (TextView) view.findViewById(R.id.txtICICIRegularIncome);
        txtICICIIncreasingIncome = (TextView) view.findViewById(R.id.txtICICIIncreasingIncome);
        etSumICICIAssured = (EditText) view.findViewById(R.id.etICICISumAssured);
        etICICIPolicyTerm = (EditText) view.findViewById(R.id.etICICIPolicyTerm);
        etICICIPremiumTerm = (EditText) view.findViewById(R.id.etICICIPremiumTerm);
        etICICICriticalIllness = (EditText) view.findViewById(R.id.etICICICriticalIllness);
        etICICIAccidentalBenefits = (EditText) view.findViewById(R.id.etICICIAccidentalBenefits);
        minusICICISum = (Button) view.findViewById(R.id.minusICICISum);
        plusICICISum = (Button) view.findViewById(R.id.plusICICISum);
        minusICICIPTerm = (Button) view.findViewById(R.id.minusICICIPTerm);
        plusICICIPTerm = (Button) view.findViewById(R.id.plusICICIPTerm);
        minusICICIPreTerm = (Button) view.findViewById(R.id.minusICICIPreTerm);
        plusICICIPreTerm = (Button) view.findViewById(R.id.plusICICIPreTerm);
        minusICICICritical = (Button) view.findViewById(R.id.minusICICICritical);
        plusICICICritical = (Button) view.findViewById(R.id.plusICICICritical);
        minusICICIAcc = (Button) view.findViewById(R.id.minusICICIAcc);
        plusICICIAcc = (Button) view.findViewById(R.id.plusICICIAcc);
        //end region
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGetQuote:

                if (isValidInput()) {
                    setTermRequest();
                    ((CompareTermActivity) getActivity()).redirectToQuote(termFinmartRequest);
                }
                break;
            case R.id.txtICICILumpSum:
            case R.id.txtICICIRegularIncome:
            case R.id.txtICICIIncreasingIncome:
                incomeSelection(((TextView) view).getText().toString());
                break;
            case R.id.plusICICISum:
                changeSumAssured(true);
                break;
            case R.id.minusICICISum:
                changeSumAssured(false);
                break;
            case R.id.plusICICIPTerm:
                changePolicyTerm(true);
                break;
            case R.id.minusICICIPTerm:
                changePolicyTerm(false);
                break;
            case R.id.plusICICIPreTerm:
                changePremiumTerm(true);
                break;
            case R.id.minusICICIPreTerm:
                changePremiumTerm(false);
                break;

            case R.id.plusICICICritical:
                changeCriticalIllness(true);
                break;
            case R.id.minusICICICritical:
                changeCriticalIllness(false);
                break;
        }
    }

    private void changeCriticalIllness(boolean b) {
        long ccIllness = Integer.parseInt(etICICICriticalIllness.getText().toString());

        if (b) {
            ccIllness = ccIllness + 100000;
            if (ccIllness >= 10000000) {
                if (ccIllness >= Integer.parseInt(etSumICICIAssured.getText().toString())) {
                    ccIllness = Integer.parseInt(etSumICICIAssured.getText().toString());
                }
            }
        } else {

        }

        etICICICriticalIllness.setText("" + ccIllness);
    }

    private void changePolicyTerm(boolean b) {
        int policyTerm = Integer.parseInt(etICICIPolicyTerm.getText().toString());
        if (b) {
            policyTerm = policyTerm + 1;
        } else {
            if (policyTerm > 1)
                policyTerm = policyTerm - 1;
            else
                policyTerm = 1;
        }

        etICICIPolicyTerm.setText("" + policyTerm);
    }

    private void changePremiumTerm(boolean b) {
        int premiumTerm = Integer.parseInt(etICICIPremiumTerm.getText().toString());
        if (b) {
            premiumTerm = premiumTerm + 1;
        } else {
            if (premiumTerm > 1)
                premiumTerm = premiumTerm - 1;
            else
                premiumTerm = 1;
        }

        etICICIPremiumTerm.setText("" + premiumTerm);
    }

    private void changeSumAssured(boolean b) {
        int sumAssured = Integer.parseInt(etSumICICIAssured.getText().toString());
        if (b) {
            sumAssured = sumAssured + 500000;
        } else {
            if (sumAssured > 2500000)
                sumAssured = sumAssured - 500000;
            else
                sumAssured = 2500000;
        }

        etSumICICIAssured.setText("" + sumAssured);
    }

    private void incomeSelection(String s) {
        switch (s) {
            case "LUMP SUM":
                txtICICILumpSum.setBackgroundResource(R.drawable.customeborder_blue);
                txtICICIIncreasingIncome.setBackgroundResource(R.drawable.customeborder);
                txtICICIRegularIncome.setBackgroundResource(R.drawable.customeborder);
                break;
            case "REGULAR INCOME":
                txtICICILumpSum.setBackgroundResource(R.drawable.customeborder);
                txtICICIIncreasingIncome.setBackgroundResource(R.drawable.customeborder);
                txtICICIRegularIncome.setBackgroundResource(R.drawable.customeborder_blue);
                break;
            case "INCREASING INCOME":
                txtICICILumpSum.setBackgroundResource(R.drawable.customeborder);
                txtICICIIncreasingIncome.setBackgroundResource(R.drawable.customeborder_blue);
                txtICICIRegularIncome.setBackgroundResource(R.drawable.customeborder);
                break;


        }
    }

    private void setTermRequest() {
        termRequestEntity.setPolicyTerm("" + dbPersistanceController.getPremYearID(spPolicyTerm.getSelectedItem().toString()));

        if (rbMale.isChecked())
            termRequestEntity.setInsuredGender("M");
        else
            termRequestEntity.setInsuredGender("F");

        if (rbNoSmoker.isChecked())
            termRequestEntity.setIs_TabaccoUser("false");
        else
            termRequestEntity.setIs_TabaccoUser("true");

        termRequestEntity.setSumAssured(etSumAssured.getText().toString());
        termRequestEntity.setInsuredDOB(etDOB.getText().toString());
        termRequestEntity.setPaymentModeValue("1");
        termRequestEntity.setPolicyCommencementDate(etDOB.getText().toString());
        termRequestEntity.setCityName("Mumbai");
        termRequestEntity.setState("Maharashtra");
        termRequestEntity.setPlanTaken("Life");
        termRequestEntity.setFrequency("Annual");
        termRequestEntity.setDeathBenefitOption("Lump-Sum");
        termRequestEntity.setPPT("" + dbPersistanceController.getPremYearID(spPremTerm.getSelectedItem().toString()));
        termRequestEntity.setIncomeTerm("" + dbPersistanceController.getPremYearID(spPremTerm.getSelectedItem().toString()));

        termRequestEntity.setInsurerId(0);
        termRequestEntity.setSessionID("");
        termRequestEntity.setExisting_ProductInsuranceMapping_Id("");
        termRequestEntity.setContactName(etFirstName.getText().toString() + " " + etLastName.getText().toString());
        termRequestEntity.setContactEmail("finmarttest@gmail.com");
        termRequestEntity.setContactMobile(etMobile.getText().toString());
        termRequestEntity.setSupportsAgentID("1682");
        termRequestEntity.setPincode(etPincode.getText().toString());

        termFinmartRequest.setTermRequestId(0);
        termFinmartRequest.setTermRequestEntity(termRequestEntity);
    }

    @Override
    public void onPositiveButtonClick(Dialog dialog, View view) {

    }

    @Override
    public void onCancelButtonClick(Dialog dialog, View view) {

    }

    public boolean isValidInput() {
        if (etFirstName.getText().toString().isEmpty()) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etFirstName.requestFocus();
                etFirstName.setError("Enter First Name");
                etFirstName.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                return false;
            } else {
                etFirstName.requestFocus();
                etFirstName.setError("Enter First Name");
                return false;
            }
        }

        if (etLastName.getText().toString().isEmpty()) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etLastName.requestFocus();
                etLastName.setError("Enter Last Name");
                etLastName.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                return false;
            } else {
                etLastName.requestFocus();
                etLastName.setError("Enter Last Name");
                return false;
            }
        }
        if (etDOB.getText().toString().isEmpty()) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etDOB.requestFocus();
                etDOB.setError("Enter Dob");
                etDOB.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                return false;
            } else {
                etDOB.requestFocus();
                etDOB.setError("Enter Dob");
                return false;
            }
        }
        if (!isValidePhoneNumber(etMobile)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etMobile.requestFocus();
                etMobile.setError("Enter Mobile");
                etMobile.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                return false;
            } else {
                etMobile.requestFocus();
                etMobile.setError("Enter Mobile");
                return false;
            }
        }
        if (etPincode.getText().toString().isEmpty()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etPincode.requestFocus();
                etPincode.setError("Enter Pincode");
                etPincode.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                return false;
            } else {
                etPincode.requestFocus();
                etPincode.setError("Enter Pincode");
                return false;
            }

        }
        if (!etPincode.getText().toString().isEmpty()) {
            if (etPincode.getText().toString().length() != 6) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    etPincode.requestFocus();
                    etPincode.setError("Enter Valid Pincode");
                    etPincode.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    return false;
                } else {
                    etPincode.requestFocus();
                    etPincode.setError("Enter Valid Pincode");
                    return false;
                }
            }

        }

        if (etSumAssured.getText().toString().isEmpty()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etSumAssured.requestFocus();
                etSumAssured.setError("Enter Sum Assured");
                etSumAssured.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                return false;
            } else {
                etSumAssured.requestFocus();
                etSumAssured.setError("Enter Sum Assured");
                return false;
            }

        }
        return true;
    }

    //region date picker

    protected View.OnClickListener datePickerDialog = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            Constants.hideKeyBoard(view, getActivity());

            //region dob

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

            //endregion
        }
    };
    //endregion

}
