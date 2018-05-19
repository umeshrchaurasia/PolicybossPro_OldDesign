package com.datacomp.magicfinmart.term.hdfc;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TermCompareQuoteResponse;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

/**
 * Created by Rajeev Ranjan on 17/05/2018.
 */

public class HdfcInputFragment extends BaseFragment implements View.OnClickListener,View.OnFocusChangeListener {

    //region header views
    LinearLayout llGender, llSmoker;
    EditText etFirstName, etLastName, etMobile, etDOB;
    TextView tvMale, tvFemale, tvYes, tvNo;
    boolean isMale, isSmoker;
    //endregion

    //region headers
    TextView tvSum, tvGender, tvSmoker, tvAge, tvPolicyTerm, tvCrn;
    ImageView ivEdit;
    TermCompareQuoteResponse termCompareQuoteResponse;
    CardView cvInputDetails, cvQuoteDetails;
    LinearLayout layoutCompare;

    TextView txtPlanNAme, txtCover, txtFinalPremium, txtPolicyTerm, txtAge;
    ImageView imgInsurerLogo, ivBuy;
    LinearLayout llAddon;
    RecyclerView rvAddOn;

    Button btnGetQuote;
    TextInputLayout tilPincode;
    EditText etPincode, etSumAssured;
    TermRequestEntity termRequestEntity;
    TermFinmartRequest termFinmartRequest;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    //endregion

    //region hdfc specific
    LinearLayout llHDFCSAInc, llIncDeath, llIncPeriod, llINCREASING, llAdb;
    Button minusICICISum, plusICICISum, minusICICIPTerm, plusICICIPTerm,
            minusICICIPreTerm, plusICICIPreTerm, minusHDFCSAInc, plusHDFCSAInc,
            minusIncDeath, plusIncDeath, minusIncPeriod, plusIncPeriod,
            minusINCREASING, plusINCREASING, minusAdb, plusAdb;
    EditText etICICISumAssured, etICICIPolicyTerm, etICICIPremiumTerm, etHDFCSAInc,
            etIncDeath, etIncPeriod, etINCREASING, etAdb;

    int minSumAssured, maxSumAssured, minPolicyTerm, maxPolicyTerm, minPremiumTerm, maxPremiumTerm,
            minHDFCSAInc, maxHDFCSAInc, minIncDeath, maxIncDeath, minIncPeriod, maxIncPeriod,
            minINCREASING, maxINCREASING, minAdb, maxAdb;
    long hfLumsumPayOutOnDeath, hfLumsumAmt;
    //endregion

    Spinner spHDFCOptions, spHdfcPremFrq;
    int termRequestId = 0;
    int age = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hdfc_input, container, false);
        init_view(view);
        setListener();
        // set initial values
        termRequestEntity = new TermRequestEntity();
        termFinmartRequest = new TermFinmartRequest();
        setDefaultValues();
        //init_adapters();

        //adapter_listener();
        if (getArguments() != null) {
            if (getArguments().getParcelable(HdfcTermActivity.INPUT_DATA) != null) {
                termFinmartRequest = getArguments().getParcelable(HdfcTermActivity.INPUT_DATA);
                termRequestId = termFinmartRequest.getTermRequestId();
            }
            //bindICICI();
            //bindInput(termFinmartRequest);
        }
        changeInputQuote(true);
        return view;
    }

    private void setDefaultValues() {
        etICICISumAssured.setText("10,000,000");
        etICICIPolicyTerm.setText("20");
        etICICIPremiumTerm.setText("20");
        etHDFCSAInc.setText("10");
        etIncDeath.setText("25,000");
        etIncPeriod.setText("20");
        etINCREASING.setText("5");
        etAdb.setText("100");
    }

    private void changeSumAssured(boolean b) {
        long SumInsu = 0;

        if (!etICICISumAssured.getText().toString().equals(""))
            SumInsu = Long.parseLong(etICICISumAssured.getText().toString().replaceAll("\\,", ""));

        if (b) {


            if (SumInsu != 0) {
                if (SumInsu < 100000) {
                    SumInsu = SumInsu + 10000;
                } else if ((SumInsu) >= 100000 && (SumInsu) < 1000000) {
                    SumInsu = (SumInsu) + 100000;
                } else if ((SumInsu) >= 1000000 && (SumInsu) < 10000000) {
                    SumInsu = (SumInsu) + 500000;
                } else if ((SumInsu) >= 10000000) {
                    SumInsu = (SumInsu) + 500000;
                }

                if (SumInsu > 500000000) {
                    etHDFCSAInc.setText("0");
                    etHDFCSAInc.setEnabled(false);

                } else {
                    //etHDFCSAInc.setText("10");
                    etHDFCSAInc.setEnabled(true);
                }
            } else {
                SumInsu = 50000;
            }

            if (!spHDFCOptions.getSelectedItem().toString().equals("INCOME REPLACEMENT")) {
                hfLumsumPayOutOnDeath = SumInsu;
            }


        } else {

            if (SumInsu != 0) {
                if (SumInsu <= 2500000) {
                    SumInsu = 2500000;
                } else if (SumInsu > 2500000 && SumInsu <= 10000000) {
                    SumInsu = SumInsu - 500000;
                } else if (SumInsu > 10000000) {
                    SumInsu = SumInsu - 500000;
                }

                if (SumInsu > 500000000) {
                    etHDFCSAInc.setText("0");
                    etHDFCSAInc.setEnabled(false);

                } else {
                    //etHDFCSAInc.setText("10");
                    etHDFCSAInc.setEnabled(true);
                }
            } else {
                SumInsu = 2500000;
            }

            if (!spHDFCOptions.getSelectedItem().toString().equals("INCOME REPLACEMENT")) {
                hfLumsumPayOutOnDeath = SumInsu;
            }


        }

        //NumberFormat.getNumberInstance(Locale.US).format(sumAssured);
        etICICISumAssured.setText("" + NumberFormat.getNumberInstance(Locale.US).format(SumInsu));
    }


    private void init_view(View view) {

        cvInputDetails = (CardView) view.findViewById(R.id.cvInputDetails);
        cvQuoteDetails = (CardView) view.findViewById(R.id.cvQuoteDetails);
        layoutCompare = (LinearLayout) view.findViewById(R.id.layoutCompare);
        tilPincode = (TextInputLayout) view.findViewById(R.id.tilPincode);
        tvSum = (TextView) view.findViewById(R.id.tvSum);
        tvGender = (TextView) view.findViewById(R.id.tvGender);
        tvSmoker = (TextView) view.findViewById(R.id.tvSmoker);
        tvAge = (TextView) view.findViewById(R.id.tvAge);
        tvPolicyTerm = (TextView) view.findViewById(R.id.tvPolicyTerm);
        tvCrn = (TextView) view.findViewById(R.id.tvCrn);
        ivEdit = (ImageView) view.findViewById(R.id.ivEdit);

        llAddon = (LinearLayout) view.findViewById(R.id.llAddon);
        rvAddOn = (RecyclerView) view.findViewById(R.id.rvAddOn);
        txtAge = (TextView) view.findViewById(R.id.txtAge);
        txtPlanNAme = (TextView) view.findViewById(R.id.txtPlanNAme);
        txtCover = (TextView) view.findViewById(R.id.txtCover);
        txtFinalPremium = (TextView) view.findViewById(R.id.txtFinalPremium);
        imgInsurerLogo = (ImageView) view.findViewById(R.id.imgInsurerLogo);
        ivBuy = (ImageView) view.findViewById(R.id.ivBuy);
        txtPolicyTerm = (TextView) view.findViewById(R.id.txtPolicyTerm);

        btnGetQuote = (Button) view.findViewById(R.id.btnGetQuote);
        etPincode = (EditText) view.findViewById(R.id.etPincode);
        etSumAssured = (EditText) view.findViewById(R.id.etICICISumAssured);

        // common input
        tvMale = (TextView) view.findViewById(R.id.tvMale);
        tvFemale = (TextView) view.findViewById(R.id.tvFemale);
        tvYes = (TextView) view.findViewById(R.id.tvYes);
        tvNo = (TextView) view.findViewById(R.id.tvNo);
        etFirstName = (EditText) view.findViewById(R.id.etFirstName);
        etLastName = (EditText) view.findViewById(R.id.etLastName);
        etMobile = (EditText) view.findViewById(R.id.etMobile);
        etDOB = (EditText) view.findViewById(R.id.etDateofBirth);
        llGender = (LinearLayout) view.findViewById(R.id.llGender);
        llSmoker = (LinearLayout) view.findViewById(R.id.llSmoker);

        spHDFCOptions = (Spinner) view.findViewById(R.id.spHDFCOptions);
        spHdfcPremFrq = (Spinner) view.findViewById(R.id.spHdfcPremFrq);

        //region hdfc specifc

        minusICICISum = (Button) view.findViewById(R.id.minusICICISum);
        plusICICISum = (Button) view.findViewById(R.id.plusICICISum);
        etICICISumAssured = (EditText) view.findViewById(R.id.etICICISumAssured);

        minusICICIPTerm = (Button) view.findViewById(R.id.minusICICIPTerm);
        plusICICIPTerm = (Button) view.findViewById(R.id.plusICICIPTerm);
        etICICIPolicyTerm = (EditText) view.findViewById(R.id.etICICIPolicyTerm);

        minusICICIPreTerm = (Button) view.findViewById(R.id.minusICICIPreTerm);
        plusICICIPreTerm = (Button) view.findViewById(R.id.plusICICIPreTerm);
        etICICIPremiumTerm = (EditText) view.findViewById(R.id.etICICIPremiumTerm);

        llHDFCSAInc = (LinearLayout) view.findViewById(R.id.llHDFCSAInc);
        minusHDFCSAInc = (Button) view.findViewById(R.id.minusHDFCSAInc);
        plusHDFCSAInc = (Button) view.findViewById(R.id.plusHDFCSAInc);
        etHDFCSAInc = (EditText) view.findViewById(R.id.etHDFCSAInc);

        llIncDeath = (LinearLayout) view.findViewById(R.id.llIncDeath);
        minusIncDeath = (Button) view.findViewById(R.id.minusIncDeath);
        plusIncDeath = (Button) view.findViewById(R.id.plusIncDeath);
        etIncDeath = (EditText) view.findViewById(R.id.etIncDeath);

        llIncPeriod = (LinearLayout) view.findViewById(R.id.llIncPeriod);
        minusIncPeriod = (Button) view.findViewById(R.id.minusIncPeriod);
        plusIncPeriod = (Button) view.findViewById(R.id.plusIncPeriod);
        etIncPeriod = (EditText) view.findViewById(R.id.etIncPeriod);

        llINCREASING = (LinearLayout) view.findViewById(R.id.llINCREASING);
        minusINCREASING = (Button) view.findViewById(R.id.minusINCREASING);
        plusINCREASING = (Button) view.findViewById(R.id.plusINCREASING);
        etINCREASING = (EditText) view.findViewById(R.id.etINCREASING);

        llAdb = (LinearLayout) view.findViewById(R.id.llAdb);
        minusAdb = (Button) view.findViewById(R.id.minusAdb);
        plusAdb = (Button) view.findViewById(R.id.plusAdb);
        etAdb = (EditText) view.findViewById(R.id.etAdb);

        //endregion

    }

    private void setListener() {

        ivEdit.setOnClickListener(this);
        ivBuy.setOnClickListener(this);
//        filter.setOnClickListener(this);

        btnGetQuote.setOnClickListener(this);
        minusICICISum.setOnClickListener(this);
        plusICICISum.setOnClickListener(this);
        minusICICIPTerm.setOnClickListener(this);
        plusICICIPTerm.setOnClickListener(this);
        minusICICIPreTerm.setOnClickListener(this);
        plusICICIPreTerm.setOnClickListener(this);
        minusHDFCSAInc.setOnClickListener(this);
        plusHDFCSAInc.setOnClickListener(this);
        minusIncDeath.setOnClickListener(this);
        plusIncDeath.setOnClickListener(this);
        minusIncPeriod.setOnClickListener(this);
        plusIncPeriod.setOnClickListener(this);
        minusINCREASING.setOnClickListener(this);
        plusINCREASING.setOnClickListener(this);
        minusAdb.setOnClickListener(this);
        plusAdb.setOnClickListener(this);


        etDOB.setOnClickListener(datePickerDialog);

        spHDFCOptions.setOnItemSelectedListener(optionSelected);
        spHdfcPremFrq.setOnItemSelectedListener(optionSelected);
    }

    AdapterView.OnItemSelectedListener optionSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (parent.getId() == R.id.spHDFCOptions) {
                manipulateInputs(spHDFCOptions.getSelectedItem().toString());

            } else if (parent.getId() == R.id.spHdfcPremFrq) {


                switch (spHdfcPremFrq.getSelectedItemPosition()) {

                    case 0:
                        termRequestEntity.setFrequency("YEARLY");
                        etICICIPremiumTerm.setEnabled(true);
                        etHDFCSAInc.setEnabled(true);
                        etICICIPremiumTerm.setText("" + etICICIPolicyTerm.getText().toString());
                        break;
                    case 1:
                        termRequestEntity.setFrequency("HALF YEARLY");
                        etICICIPremiumTerm.setEnabled(true);
                        etHDFCSAInc.setEnabled(true);
                        etICICIPremiumTerm.setText("" + etICICIPolicyTerm.getText().toString());
                        break;
                    case 2:
                        termRequestEntity.setFrequency("QUARTERLY");
                        etICICIPremiumTerm.setEnabled(true);
                        etHDFCSAInc.setEnabled(true);
                        etICICIPremiumTerm.setText("" + etICICIPolicyTerm.getText().toString());
                        break;
                    case 3:
                        termRequestEntity.setFrequency("MONTHLY");
                        etICICIPremiumTerm.setEnabled(true);
                        etHDFCSAInc.setEnabled(true);
                        etICICIPremiumTerm.setText("" + etICICIPolicyTerm.getText().toString());
                        break;
                    case 4:
                        termRequestEntity.setFrequency("SINGLE");
                        if (!spHDFCOptions.getSelectedItem().toString().equals("LIFE LONG PROTECTION") &&
                                !spHDFCOptions.getSelectedItem().toString().equals("3D LIFE LONG PROTECTION")) {

                            etHDFCSAInc.setText("0");
                            etICICIPremiumTerm.setText("1");
                            etICICIPremiumTerm.setEnabled(false);
                            etHDFCSAInc.setEnabled(false);
                        }
                        break;
                }

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvMale:
                isMale = true;
                tvFemale.setBackgroundResource(R.drawable.customeborder);
                tvMale.setBackgroundResource(R.drawable.customeborder_blue);
                break;
            case R.id.tvFemale:
                isMale = false;
                tvMale.setBackgroundResource(R.drawable.customeborder);
                tvFemale.setBackgroundResource(R.drawable.customeborder_blue);
                break;
            case R.id.tvYes:
                isSmoker = true;
                tvNo.setBackgroundResource(R.drawable.customeborder);
                tvYes.setBackgroundResource(R.drawable.customeborder_blue);
                break;
            case R.id.tvNo:
                isSmoker = false;
                tvYes.setBackgroundResource(R.drawable.customeborder);
                tvNo.setBackgroundResource(R.drawable.customeborder_blue);
                break;
            case R.id.minusICICISum:
                changeSumAssured(false);
                break;
            case R.id.plusICICISum:
                changeSumAssured(true);
                break;
        }
    }

    //region datepicker
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
                        String options = spHDFCOptions.getSelectedItem().toString();
                        if (options.equals("LIFE LONG PROTECTION") || options.equals("3D LIFE LONG PROTECTION")) {
                            CalculatePolicyAndPremTerm();
                        }
                        //setPolicyTerm((75 - age));
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

    public int caluclateAge(String dateofbirth) {
        Date date = new Date();
        try {

            date = simpleDateFormat.parse(dateofbirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar dob = Calendar.getInstance();
        dob.setTime(date);
        Calendar current = Calendar.getInstance();
        int diff = current.get(YEAR) - dob.get(YEAR);
        if (dob.get(MONTH) > current.get(MONTH) ||
                (dob.get(MONTH) == current.get(MONTH) && dob.get(DATE) > current.get(DATE))) {
            diff--;
        }
        return diff;
    }

    private void changeInputQuote(boolean isInput) {
        if (isInput) {
            //((IciciTermActivity) getActivity()).redirectToInput(termFinmartRequest);
            btnGetQuote.setText("GET QUOTE");
            tilPincode.setVisibility(View.VISIBLE);
            layoutCompare.setVisibility(View.VISIBLE);
            cvInputDetails.setVisibility(View.GONE);
            cvQuoteDetails.setVisibility(View.GONE);
        } else {
            ((HdfcTermActivity) getActivity()).redirectToQuote(termFinmartRequest);
            btnGetQuote.setText("UPDATE QUOTE");
            tilPincode.setVisibility(View.INVISIBLE);
            layoutCompare.setVisibility(View.GONE);
            cvInputDetails.setVisibility(View.VISIBLE);
            cvQuoteDetails.setVisibility(View.VISIBLE);
        }
    }

    private void manipulateInputs(String s) {
        switch (s) {
            case "LIFE":
                termRequestEntity.setPlanTaken("LIFE");
                hideAllLayout();
                clearValues();
                etHDFCSAInc.setText("10");
                SetLumsumPayOutOnDeath();
                if (spHdfcPremFrq.getSelectedItemPosition() != 4) {// not single
                    etICICIPremiumTerm.setText("20");
                    etICICIPolicyTerm.setText("20");
                    etICICIPremiumTerm.setEnabled(true);
                    etHDFCSAInc.setEnabled(true);
                } else {
                    etHDFCSAInc.setText("0");
                    etICICIPremiumTerm.setText("1");
                    etICICIPremiumTerm.setEnabled(false);
                    etHDFCSAInc.setEnabled(false);
                    etICICIPolicyTerm.setText("20");
                }

                break;
            case "3D LIFE":
                termRequestEntity.setPlanTaken("3D LIFE");
                hideAllLayout();
                clearValues();

                etHDFCSAInc.setText("10");
                SetLumsumPayOutOnDeath();
                if (spHdfcPremFrq.getSelectedItemPosition() != 4) {// not single
                    etICICIPremiumTerm.setText("20");
                    etICICIPolicyTerm.setText("20");
                    etICICIPremiumTerm.setEnabled(true);
                    etHDFCSAInc.setEnabled(true);
                } else {
                    etHDFCSAInc.setText("0");
                    etICICIPremiumTerm.setText("1");
                    etICICIPremiumTerm.setEnabled(false);
                    etHDFCSAInc.setEnabled(false);
                    etICICIPolicyTerm.setText("20");
                }

                break;
            case "LIFE LONG PROTECTION":
                termRequestEntity.setPlanTaken("LIFE LONG PROTECTION");
                hideAllLayout();
                clearValues();
                etHDFCSAInc.setText("10");
                SetLumsumPayOutOnDeath();
                CalculatePolicyAndPremTerm();

                break;
            case "3D LIFE LONG PROTECTION":
                termRequestEntity.setPlanTaken("3D LIFE LONG PROTECTION");
                hideAllLayout();
                clearValues();
                etHDFCSAInc.setText("10");
                SetLumsumPayOutOnDeath();
                CalculatePolicyAndPremTerm();

                break;
            case "EXTRA LIFE":
                termRequestEntity.setPlanTaken("EXTRA LIFE");
                hideAllLayout();
                clearValues();
                llAdb.setVisibility(View.VISIBLE);

                etAdb.setText("100");
                etHDFCSAInc.setText("10");

                CalculateLumsumAmt();

                if (spHdfcPremFrq.getSelectedItemPosition() != 4) {// not single
                    etICICIPremiumTerm.setText("20");
                    etICICIPolicyTerm.setText("20");
                    //etICICIPremiumTerm.setEnabled(true);
                    //etHDFCSAInc.setEnabled(true);
                } else {
                    //etHDFCSAInc.setText("0");
                    etICICIPremiumTerm.setText("1");
                    //etICICIPremiumTerm.setEnabled(false);
                    //etHDFCSAInc.setEnabled(false);
                    etICICIPolicyTerm.setText("20");
                }
                break;
            case "EXTRA LIFE INCOME":
                termRequestEntity.setPlanTaken("EXTRA LIFE INCOME");
                hideAllLayout();
                llIncDeath.setVisibility(View.VISIBLE);
                llIncPeriod.setVisibility(View.VISIBLE);
                llINCREASING.setVisibility(View.VISIBLE);
                llAdb.setVisibility(View.VISIBLE);
                clearValues();

                etHDFCSAInc.setText("10");
                etIncDeath.setText("25000");
                etIncPeriod.setText("20");
                etIncPeriod.setEnabled(true);
                etINCREASING.setText("5");
                etINCREASING.setEnabled(true);
                etAdb.setText("100");

                CalculateLumsumAmt();

                if (spHdfcPremFrq.getSelectedItemPosition() != 4) {// not single
                    etICICIPremiumTerm.setText("20");
                    etICICIPolicyTerm.setText("20");
                    //etICICIPremiumTerm.setEnabled(true);
                    //etHDFCSAInc.setEnabled(true);
                } else {
                    //etHDFCSAInc.setText("0");
                    etICICIPremiumTerm.setText("1");
                    //etICICIPremiumTerm.setEnabled(false);
                    //etHDFCSAInc.setEnabled(false);
                    etICICIPolicyTerm.setText("20");
                }

                break;
            case "INCOME OPTION":
                termRequestEntity.setPlanTaken("INCOME OPTION");
                hideAllLayout();
                llIncDeath.setVisibility(View.VISIBLE);
                llIncPeriod.setVisibility(View.VISIBLE);
                llINCREASING.setVisibility(View.VISIBLE);

                clearValues();

                etHDFCSAInc.setText("10");
                etIncDeath.setText("25000");

                etIncPeriod.setText("20");
                etIncPeriod.setEnabled(true);
                etINCREASING.setEnabled(true);
                etINCREASING.setText("5");

                SetLumsumPayOutOnDeath();

                if (spHdfcPremFrq.getSelectedItemPosition() != 4) {// not single
                    etICICIPremiumTerm.setText("20");
                    etICICIPolicyTerm.setText("20");
                    //etICICIPremiumTerm.setEnabled(true);
                    //etHDFCSAInc.setEnabled(true);
                } else {
                    //etHDFCSAInc.setText("0");
                    etICICIPremiumTerm.setText("1");
                    //etICICIPremiumTerm.setEnabled(false);
                    //etHDFCSAInc.setEnabled(false);
                    etICICIPolicyTerm.setText("20");
                }

                break;
            case "INCOME REPLACEMENT":
                termRequestEntity.setPlanTaken("INCOME REPLACEMENT");
                hideAllLayout();
                llIncDeath.setVisibility(View.VISIBLE);
                llINCREASING.setVisibility(View.VISIBLE);
                clearValues();

                etHDFCSAInc.setText("10");
                etIncDeath.setText("25000");
                etINCREASING.setText("10");

                if (!etIncDeath.getText().toString().equals("")) {
                    long txtMntlyIncomOnDeath = Long.parseLong(etIncDeath.getText().toString());
                    long Lumsum = txtMntlyIncomOnDeath * 12;
                    hfLumsumPayOutOnDeath = Lumsum;
                }

                if (spHdfcPremFrq.getSelectedItemPosition() != 4) {// not single
                    etICICIPremiumTerm.setText("20");
                    etICICIPolicyTerm.setText("20");
                    //etICICIPremiumTerm.setEnabled(true);
                    //etHDFCSAInc.setEnabled(true);
                } else {
                    //etHDFCSAInc.setText("0");
                    etICICIPremiumTerm.setText("1");
                    //etICICIPremiumTerm.setEnabled(false);
                    //etHDFCSAInc.setEnabled(false);
                    etICICIPolicyTerm.setText("20");
                }

                break;
            case "RETURN OF PREMIUM":
                termRequestEntity.setPlanTaken("RETURN OF PREMIUM");
                hideAllLayout();
                clearValues();

                etHDFCSAInc.setText("10");

                SetLumsumPayOutOnDeath();

                if (spHdfcPremFrq.getSelectedItemPosition() != 4) {// not single
                    etICICIPremiumTerm.setText("20");
                    etICICIPolicyTerm.setText("20");
                    //etICICIPremiumTerm.setEnabled(true);
                    //etHDFCSAInc.setEnabled(true);
                } else {
                    //etHDFCSAInc.setText("0");
                    etICICIPremiumTerm.setText("1");
                    //etICICIPremiumTerm.setEnabled(false);
                    //etHDFCSAInc.setEnabled(false);
                    etICICIPolicyTerm.setText("20");
                }

                break;
        }
    }

    private void hideAllLayout() {
        //llHDFCSAInc.setVisibility(View.GONE);
        llIncDeath.setVisibility(View.GONE);
        llIncPeriod.setVisibility(View.GONE);
        llINCREASING.setVisibility(View.GONE);
        llAdb.setVisibility(View.GONE);
    }

    public void clearValues() {
        etIncDeath.setText("");
        etINCREASING.setText("");
        etIncPeriod.setText("");
        etAdb.setText("");
        etHDFCSAInc.setText("");
    }

    public void CalculatePolicyAndPremTerm() {
        int age = caluclateAge(etDOB.getText().toString());
        int policyTerm = 99 - age;
        int ppt = 65 - age;
        etICICIPolicyTerm.setText("" + policyTerm);
        etICICIPremiumTerm.setText("" + ppt);
    }

    public void CalculateLumsumAmt() {
        int txtSumAssu = 0;
        double AdbPercentage = 0;

        long txtMntlyIncomOnDeath = 0;

        if (!etIncDeath.getText().toString().equals("")) {
            txtMntlyIncomOnDeath = Long.parseLong(etIncDeath.getText().toString().replaceAll("\\,", ""));
        }
        if (!etICICISumAssured.getText().toString().equals("")) {
            txtSumAssu = Integer.parseInt(etICICISumAssured.getText().toString().replaceAll("\\,", ""));
            hfLumsumPayOutOnDeath = txtSumAssu;
        }


        if (!etAdb.getText().toString().equals("")) {
            AdbPercentage = Double.parseDouble(etAdb.getText().toString());
            if (AdbPercentage > 100) {
                AdbPercentage = 100;
                etAdb.setText("100");
            }
        }

        if (!etICICISumAssured.getText().toString().equals("") && !etAdb.getText().toString().equals("")) {
            double Adb = AdbPercentage / 100;
            double LumsumAmt = txtSumAssu * Adb;
            hfLumsumAmt = Math.round(LumsumAmt);
        }

        /*if (!etIncDeath.getText().toString().equals("") && !etAdb.getText().toString().equals("")) {
            //double Adb = AdbPercentage / 100;
            //double MlyIncome = txtMntlyIncomOnDeath * Adb;

            //$('#hfLumsumAmt').val(Math.round(LumsumAmt));
        }*/
    }

    public void SetLumsumPayOutOnDeath() {
        int SumInsu = 0;
        if (!etICICISumAssured.getText().toString().equals("")) {
            SumInsu = Integer.parseInt(etICICISumAssured.getText().toString().replaceAll("\\,", ""));
            hfLumsumPayOutOnDeath = SumInsu;
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }
}

