package com.datacomp.magicfinmart.term.icici;

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
import com.datacomp.magicfinmart.term.compareterm.CompareTermActivity;
import com.datacomp.magicfinmart.term.quoteapp.TermQuoteListFragment;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermRequestEntity;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class IciciTermInputFragment extends BaseFragment implements View.OnClickListener, BaseFragment.PopUpListener {

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

    //region icici form
    Spinner spICICIOptions, spICICIPremiumTerm, spICICIPremiumFrequency;
    TextView txtICICILumpSum, txtICICIRegularIncome, txtICICIIncreasingIncome, txtICICILumpSumRegular;
    EditText etSumICICIAssured, etICICIPolicyTerm, etICICIPremiumTerm,
            etICICICriticalIllness, etICICIAccidentalBenefits, etICICILumpSumpPerc;
    Button minusICICISum, plusICICISum, minusICICIPTerm, plusICICIPTerm,
            minusICICIPreTerm, plusICICIPreTerm, minusICICICritical, plusICICICritical,
            minusICICIAcc, plusICICIAcc, minusICICILumpSumpPerc, plusICICILumpSumpPerc;


    ArrayAdapter<String> policyOptionsAdapter, policyTermAdapter, premiumFrequencyAdapter;


    LinearLayout llICICIAccidental, llICICICritical, llICICILumpSumpPerc;
    //endregion

    int insurerID;
    boolean canChangePremiumTerm = true;
    int age = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_icici_term_input, container, false);
        init(view);
        setListener();
        // set initial values
        dbPersistanceController = new DBPersistanceController(getActivity());
        policyYear = dbPersistanceController.getPremYearList();
        termRequestEntity = new TermRequestEntity();
        termFinmartRequest = new TermFinmartRequest();
        //init_adapters();

        //adapter_listener();
        if (getArguments() != null) {
            if (getArguments().getParcelable(CompareTermActivity.INPUT_DATA) != null)
                termFinmartRequest = getArguments().getParcelable(CompareTermActivity.INPUT_DATA);
            insurerID = getArguments().getInt(TermQuoteListFragment.TERM_FOR_INPUT_FRAGMENT);
            bindICICI();
            bindInput(termFinmartRequest);
        }
        return view;
    }

    private void bindICICI() {
        etSumICICIAssured.setText("10,000,000");
        etICICICriticalIllness.setText("1,000,000");
        etICICIAccidentalBenefits.setText("1,000,000");
        etICICIPolicyTerm.setText("20");
        etICICIPremiumTerm.setText("20");
        etICICILumpSumpPerc.setText("50");

        //by default Regular pay selected.
        spICICIPremiumTerm.setSelection(0);
    }

    AdapterView.OnItemSelectedListener optionSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (parent.getId() == R.id.spICICIOptions) {
                manipulateInputs(spICICIOptions.getSelectedItem().toString());

            } else if (parent.getId() == R.id.spICICIPremiumFrequency) {
                switch (spICICIPremiumFrequency.getSelectedItemPosition()) {
                    case 0:
                        termRequestEntity.setFrequency("Annual");
                        break;
                    case 1:
                        termRequestEntity.setFrequency("Half Yearly");
                        break;
                    case 2:
                        termRequestEntity.setFrequency("Monthly");
                        break;
                }

            } else if (parent.getId() == R.id.spICICIPremiumTerm) {

                String[] listOption = getActivity().getResources().getStringArray(R.array.icici_options);
                String[] listPremiumFrequency = getActivity().getResources()
                        .getStringArray(R.array.icici_premium_frequency);

                final List<String> optionsList = new ArrayList<>(Arrays.asList(listOption));
                final List<String> premiumFreqList = new ArrayList<>(Arrays.asList(listPremiumFrequency));

                switch (spICICIPremiumTerm.getSelectedItemPosition()) {
                    case 0://regular pay
                        canChangePremiumTerm = true;
                        termRequestEntity.setPremiumPaymentOption("Regular Pay");
                        break;
                    case 1:// single pay
                        termRequestEntity.setPremiumPaymentOption("Single Pay");
                        optionsList.remove("LIFE AND HEALTH");
                        optionsList.remove("ALL IN ONE");

                        premiumFreqList.remove("HALF YEARLY");
                        premiumFreqList.remove("MONTHLY");
                        canChangePremiumTerm = false;
                        etICICIPremiumTerm.setText("1");
                        etICICIPremiumTerm.setEnabled(false);
                        setPolicyTerm((75 - age));
                        break;
                    case 2://limited pay
                        termRequestEntity.setPremiumPaymentOption("Limited Pay");
                        canChangePremiumTerm = true;
                        setPolicyTerm((75 - age));
                        if ((75 - age) > 30) {
                            optionsList.remove("LIFE AND HEALTH");
                            optionsList.remove("ALL IN ONE");
                        }
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
        switch (s) {
            case "LIFE":
                termRequestEntity.setPlanTaken("Life");
                llICICICritical.setVisibility(View.GONE);
                llICICIAccidental.setVisibility(View.GONE);
                break;
            case "LIFE PLUS":
                termRequestEntity.setPlanTaken("Life Plus");
                llICICICritical.setVisibility(View.GONE);
                llICICIAccidental.setVisibility(View.VISIBLE);
                break;
            case "LIFE AND HEALTH":
                termRequestEntity.setPlanTaken("Life and Health");
                llICICICritical.setVisibility(View.VISIBLE);
                llICICIAccidental.setVisibility(View.GONE);
                setDefaultValues("LIFE AND HEALTH");
                break;
            case "ALL IN ONE":
                termRequestEntity.setPlanTaken("All in One");
                llICICICritical.setVisibility(View.VISIBLE);
                llICICIAccidental.setVisibility(View.VISIBLE);
                break;


        }
    }

    private void setDefaultValues(String strOptions) {
        if (strOptions.equals("LIFE AND HEALTH")) {
            etICICICriticalIllness.setText("1,000,000");
        } else if (strOptions.equals("LIFE PLUS")) {

        } else if (strOptions.equals("ALL IN ONE")) {

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
        txtICICILumpSumRegular.setOnClickListener(this);
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
        minusICICILumpSumpPerc.setOnClickListener(this);
        plusICICILumpSumpPerc.setOnClickListener(this);
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
        etSumAssured = (EditText) view.findViewById(R.id.etICICISumAssured);
        spPolicyTerm = (Spinner) view.findViewById(R.id.spPolicyTerm);
        spPremTerm = (Spinner) view.findViewById(R.id.spPremTerm);


        //Compare All
        llCompareAll = (LinearLayout) view.findViewById(R.id.llCompareAll);
        //lllayoutICICI = (View) view.findViewById(R.id.layoutICICI);

        //region icici id
        llICICIAccidental = (LinearLayout) view.findViewById(R.id.llAccidental);
        llICICICritical = (LinearLayout) view.findViewById(R.id.llCritical);
        llICICILumpSumpPerc = (LinearLayout) view.findViewById(R.id.llICICILumpSumpPerc);
        spICICIOptions = (Spinner) view.findViewById(R.id.spICICIOptions);
        spICICIPremiumTerm = (Spinner) view.findViewById(R.id.spICICIPremiumTerm);
        spICICIPremiumFrequency = (Spinner) view.findViewById(R.id.spICICIPremiumFrequency);

        txtICICILumpSum = (TextView) view.findViewById(R.id.txtICICILumpSum);
        txtICICIRegularIncome = (TextView) view.findViewById(R.id.txtICICIRegularIncome);
        txtICICIIncreasingIncome = (TextView) view.findViewById(R.id.txtICICIIncreasingIncome);
        txtICICILumpSumRegular = (TextView) view.findViewById(R.id.txtICICILumpSumRegular);
        etSumICICIAssured = (EditText) view.findViewById(R.id.etICICISumAssured);
        etICICIPolicyTerm = (EditText) view.findViewById(R.id.etICICIPolicyTerm);
        etICICIPremiumTerm = (EditText) view.findViewById(R.id.etICICIPremiumTerm);
        etICICICriticalIllness = (EditText) view.findViewById(R.id.etICICICriticalIllness);
        etICICIAccidentalBenefits = (EditText) view.findViewById(R.id.etICICIAccidentalBenefits);
        etICICILumpSumpPerc = (EditText) view.findViewById(R.id.etICICILumpSumpPerc);
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
        minusICICILumpSumpPerc = (Button) view.findViewById(R.id.minusICICILumpSumpPerc);
        plusICICILumpSumpPerc = (Button) view.findViewById(R.id.plusICICILumpSumpPerc);
        //end region
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGetQuote:

                if (isValidInput()) {
                    setTermRequest();
                    ((IciciTermActivity) getActivity()).redirectToQuote(termFinmartRequest);
                }
                break;
            case R.id.txtICICILumpSum:
            case R.id.txtICICIRegularIncome:
            case R.id.txtICICIIncreasingIncome:
            case R.id.txtICICILumpSumRegular:
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

            case R.id.plusICICIAcc:
                changeAccidentalDeath(true);
                break;
            case R.id.minusICICIAcc:
                changeAccidentalDeath(false);
                break;

            case R.id.plusICICILumpSumpPerc:
                changeLumpsumPercent(true);
                break;
            case R.id.minusICICILumpSumpPerc:
                changeLumpsumPercent(false);
                break;
        }
    }

    private void changeLumpsumPercent(boolean b) {
        int maxLumpsumPercent = 95;
        int minLumpsumPercent = 5;
        int step = 5;
        int LumpsumPercent = Integer.parseInt(etICICILumpSumpPerc.getText().toString());

        if (b) {
            if (LumpsumPercent < maxLumpsumPercent) {
                LumpsumPercent += step;
            }
        } else {
            if (LumpsumPercent > minLumpsumPercent) {
                LumpsumPercent -= step;
            }
        }
        etICICILumpSumpPerc.setText("" + LumpsumPercent);
    }

    private void changeCriticalIllness(boolean b) {
        int maxCriticalIllness = 10000000;
        int minCriticalIllness = 100000;
        int sumInsured = 10000000;
        int step = 500000;
        int Smallstep = 100000;
        int ccIllness = Integer.parseInt(etICICICriticalIllness.getText().toString().replaceAll("\\,", ""));

        if (!etSumICICIAssured.getText().toString().equals(""))
            sumInsured = Integer.parseInt(etSumICICIAssured.getText().toString().replaceAll("\\,", ""));


        if (b) {
            if (ccIllness < maxCriticalIllness && ccIllness < sumInsured) {
                if (ccIllness < step)
                    ccIllness += Smallstep;
                else
                    ccIllness += step;
            }
        } else {
            if (ccIllness > minCriticalIllness) {
                if (ccIllness <= step)
                    ccIllness -= Smallstep;
                else
                    ccIllness -= step;
            }
        }
        etICICICriticalIllness.setText("" + NumberFormat.getNumberInstance(Locale.US).format(ccIllness));
    }

    private void changeAccidentalDeath(boolean b) {
        int maxAccidentalDeath = 20000000;
        int minAccidentalDeath = 100000;
        int sumInsured = 10000000;
        int step = 500000;
        int Smallstep = 100000;
        int AccidentalDeath = Integer.parseInt(etICICIAccidentalBenefits.getText().toString().replaceAll("\\,", ""));

        if (!etSumICICIAssured.getText().toString().equals(""))
            sumInsured = Integer.parseInt(etSumICICIAssured.getText().toString().replaceAll("\\,", ""));


        if (b) {
            if (AccidentalDeath < maxAccidentalDeath && AccidentalDeath < sumInsured) {
                if (AccidentalDeath < step)
                    AccidentalDeath += Smallstep;
                else
                    AccidentalDeath += step;
            }
        } else {
            if (AccidentalDeath > minAccidentalDeath) {
                if (AccidentalDeath <= step)
                    AccidentalDeath -= Smallstep;
                else
                    AccidentalDeath -= step;
            }
        }
        etICICIAccidentalBenefits.setText("" + NumberFormat.getNumberInstance(Locale.US).format(AccidentalDeath));
    }

    private void changePolicyTerm(boolean b) {
        int policyTerm = Integer.parseInt(etICICIPolicyTerm.getText().toString());
        if (b) {
            if (policyTerm < (75 - age))
                policyTerm = policyTerm + 1;
        } else {
            if (policyTerm > 5)
                policyTerm = policyTerm - 1;

        }

        setPolicyTerm(policyTerm);

        // remove life and health ,all in one
        //region hide
        String[] listOption = getActivity().getResources().getStringArray(R.array.icici_options);
        final List<String> optionsList = new ArrayList<>(Arrays.asList(listOption));
        if (spICICIPremiumTerm.getSelectedItemPosition() == 2 && policyTerm > 30) {
            optionsList.remove("LIFE AND HEALTH");
            optionsList.remove("ALL IN ONE");

            ArrayAdapter<String> spAdapterOptions = new ArrayAdapter<String>(getActivity()
                    , android.R.layout.simple_spinner_item
                    , optionsList);

            spAdapterOptions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spICICIOptions.setAdapter(spAdapterOptions);
        } else {
            ArrayAdapter<String> spAdapterOptions = new ArrayAdapter<String>(getActivity()
                    , android.R.layout.simple_spinner_item
                    , optionsList);

            spAdapterOptions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spICICIOptions.setAdapter(spAdapterOptions);
        }
        //endregion
    }

    private void setPolicyTerm(int policyTerm) {
        switch (spICICIPremiumTerm.getSelectedItemPosition()) {
            case 0:
                etICICIPolicyTerm.setText("" + policyTerm);
                break;
            case 1://single pay can't be grater than 20
                if (policyTerm > 20)
                    etICICIPolicyTerm.setText("20");
                else
                    etICICIPolicyTerm.setText("" + policyTerm);
                break;
            case 2://limited pay can't be grater than 40
                if (policyTerm > 40)
                    etICICIPolicyTerm.setText("40");
                else
                    etICICIPolicyTerm.setText("" + policyTerm);
                break;
        }
    }

    private void changePremiumTerm(boolean b) {
        if (canChangePremiumTerm) {
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

    }

    private void changeSumAssured(boolean b) {
        int sumAssured = Integer.parseInt(etSumICICIAssured.getText().toString().replaceAll("\\,", ""));
        if (b) {
            if (sumAssured >= 100000 && sumAssured < 1000000)
                sumAssured = sumAssured + 50000;
            else
                sumAssured = sumAssured + 500000;


        } else {
            if (sumAssured > 1000000)
                sumAssured = sumAssured - 500000;
            else if (sumAssured > 100000 && sumAssured <= 1000000)
                sumAssured = sumAssured - 50000;

        }
        //NumberFormat.getNumberInstance(Locale.US).format(sumAssured);
        etSumICICIAssured.setText("" + NumberFormat.getNumberInstance(Locale.US).format(sumAssured));
    }

    private void incomeSelection(String s) {
        switch (s) {
            case "LUMP SUM":
                txtICICILumpSum.setBackgroundResource(R.drawable.customeborder_blue);
                txtICICIIncreasingIncome.setBackgroundResource(R.drawable.customeborder);
                txtICICIRegularIncome.setBackgroundResource(R.drawable.customeborder);
                txtICICILumpSumRegular.setBackgroundResource(R.drawable.customeborder);
                llICICILumpSumpPerc.setVisibility(View.GONE);
                termRequestEntity.setDeathBenefitOption("Lump-Sum");
                break;
            case "REGULAR INCOME":
                txtICICILumpSum.setBackgroundResource(R.drawable.customeborder);
                txtICICIIncreasingIncome.setBackgroundResource(R.drawable.customeborder);
                txtICICIRegularIncome.setBackgroundResource(R.drawable.customeborder_blue);
                txtICICILumpSumRegular.setBackgroundResource(R.drawable.customeborder);
                llICICILumpSumpPerc.setVisibility(View.GONE);
                termRequestEntity.setDeathBenefitOption("income");
                break;
            case "INCREASING INCOME":
                txtICICILumpSum.setBackgroundResource(R.drawable.customeborder);
                txtICICIIncreasingIncome.setBackgroundResource(R.drawable.customeborder_blue);
                txtICICIRegularIncome.setBackgroundResource(R.drawable.customeborder);
                txtICICILumpSumRegular.setBackgroundResource(R.drawable.customeborder);
                llICICILumpSumpPerc.setVisibility(View.GONE);
                termRequestEntity.setDeathBenefitOption("increasing income");
                break;
            case "LUMP SUM + REGULAR INCOME":
                txtICICILumpSum.setBackgroundResource(R.drawable.customeborder);
                txtICICIIncreasingIncome.setBackgroundResource(R.drawable.customeborder);
                txtICICIRegularIncome.setBackgroundResource(R.drawable.customeborder);
                txtICICILumpSumRegular.setBackgroundResource(R.drawable.customeborder_blue);
                llICICILumpSumpPerc.setVisibility(View.VISIBLE);
                termRequestEntity.setDeathBenefitOption("lump-sum-income");
                break;


        }
    }

    private void setTermRequest() {
        //termRequestEntity.setPolicyTerm("" + dbPersistanceController.getPremYearID(spPolicyTerm.getSelectedItem().toString()));

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
        //termRequestEntity.setPlanTaken("Life");
        // termRequestEntity.setFrequency("Annual");
        //termRequestEntity.setDeathBenefitOption("Lump-Sum");
        //termRequestEntity.setPPT("" + dbPersistanceController.getPremYearID(spPremTerm.getSelectedItem().toString()));
        //termRequestEntity.setIncomeTerm("" + dbPersistanceController.getPremYearID(spPremTerm.getSelectedItem().toString()));

        //termRequestEntity.setInsurerId(0);
        termRequestEntity.setSessionID("");
        termRequestEntity.setExisting_ProductInsuranceMapping_Id("");
        termRequestEntity.setContactName(etFirstName.getText().toString() + " " + etLastName.getText().toString());
        termRequestEntity.setContactEmail("finmarttest@gmail.com");
        termRequestEntity.setContactMobile(etMobile.getText().toString());
        termRequestEntity.setSupportsAgentID("1682");
        termRequestEntity.setPincode(etPincode.getText().toString());


        //icici specific
        termRequestEntity.setMaritalStatus("");
        //termRequestEntity.setPremiumPaymentOption(""); //set in optionSelected
        termRequestEntity.setServiceTaxNotApplicable("");// not known

        if (llICICICritical.getVisibility() == View.VISIBLE)
            termRequestEntity.setCIBenefit("" + etICICICriticalIllness.getText().toString().replaceAll("\\,", ""));

        if (llICICIAccidental.getVisibility() == View.VISIBLE)
            termRequestEntity.setADHB("" + etICICIAccidentalBenefits.getText().toString().replaceAll("\\,", ""));

        if (llICICILumpSumpPerc.getVisibility() == View.VISIBLE)
            termRequestEntity.setLumpsumPercentage("" + etICICILumpSumpPerc.getText().toString());


        termRequestEntity.setPolicyTerm("" + etICICIPolicyTerm.getText().toString());
        termRequestEntity.setInsurerId(39);
        //termRequestEntity.setPlanTaken("Life");// set in manipulateInputs()
        //termRequestEntity.setFrequency("Annual"); //set in optionSelected
        //termRequestEntity.setDeathBenefitOption("Lump-Sum"); //set in incomeSelection()
        termRequestEntity.setPPT("" + etICICIPremiumTerm.getText().toString());


        termFinmartRequest.setTermRequestId(0);
        termFinmartRequest.setTermRequestEntity(termRequestEntity);
    }

    @Override
    public void onPositiveButtonClick(Dialog dialog, View view) {
        dialog.cancel();
    }

    @Override
    public void onCancelButtonClick(Dialog dialog, View view) {
        dialog.cancel();
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
                        age = caluclateAge(calendar);
                        setPolicyTerm((75 - age));
                    }
                }
            });

            //endregion
        }
    };
    //endregion

    public int caluclateAge(Calendar dob) {
        Calendar current = Calendar.getInstance();
        int diff = current.get(YEAR) - dob.get(YEAR);
        if (dob.get(MONTH) > current.get(MONTH) ||
                (dob.get(MONTH) == current.get(MONTH) && dob.get(DATE) > current.get(DATE))) {
            diff--;
        }
        return diff;
    }

}
