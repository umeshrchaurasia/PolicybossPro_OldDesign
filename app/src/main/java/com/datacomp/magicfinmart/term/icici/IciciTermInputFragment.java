package com.datacomp.magicfinmart.term.icici;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.term.compareterm.CompareTermActivity;
import com.datacomp.magicfinmart.term.quoteapp.TermQuoteListFragment;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;
import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.term.TermInsuranceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.tracking.TrackingController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TermCompareResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TrackingData;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TrackingRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TermCompareQuoteResponse;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class IciciTermInputFragment extends BaseFragment implements View.OnClickListener, BaseFragment.PopUpListener, IResponseSubcriber {


    // quote
    TextView tvSum, tvGender, tvSmoker, tvAge, tvPolicyTerm, tvCrn, filter;
    ImageView ivEdit;
    TermCompareQuoteResponse termCompareQuoteResponse;
    CardView cvInputDetails, cvQuoteDetails;
    View layoutCompare;

    TextView txtPlanNAme, txtCover, txtFinalPremium, txtPolicyTerm, txtAge, txtCustomise, txtRiders;
    ImageView imgInsurerLogo, ivBuy;
    LinearLayout llAddon;
    RecyclerView rvAddOn;

    Button btnGetQuote;
    EditText etFirstName, etLastName, etMobile;
    RadioButton rbMale, rbfemale, rbNoSmoker, rbYesSmoker;
    EditText etDOB;

    EditText etPincode, etSumAssured;
    TextInputLayout tilPincode;
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
    boolean isEdit = false;
    int termRequestId = 0;
    AdapterView.OnItemSelectedListener optionSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (parent.getId() == R.id.spICICIOptions) {
                manipulateInputs(spICICIOptions.getSelectedItem().toString());

            } else if (parent.getId() == R.id.spICICIPremiumFrequency) {
                switch (spICICIPremiumFrequency.getSelectedItemPosition()) {
                    case 0:
                        termRequestEntity.setFrequency("yearly");
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
                if (!isEdit) {
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
                    isEdit = false;
                }

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

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
            if (getArguments().getParcelable(CompareTermActivity.INPUT_DATA) != null) {
                termFinmartRequest = getArguments().getParcelable(CompareTermActivity.INPUT_DATA);
                termRequestId = termFinmartRequest.getTermRequestId();
                isEdit = true;
            }

            insurerID = getArguments().getInt(TermQuoteListFragment.TERM_FOR_INPUT_FRAGMENT);
            bindICICI();
            bindInput(termFinmartRequest);
        }
        hideShowLayout(true);
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
                if (etICICIAccidentalBenefits.getText().toString().equals(""))
                    etICICIAccidentalBenefits.setText("1,000,000");
                break;
            case "LIFE AND HEALTH":
                termRequestEntity.setPlanTaken("Life and Health");
                llICICICritical.setVisibility(View.VISIBLE);
                llICICIAccidental.setVisibility(View.GONE);
                if (etICICICriticalIllness.getText().toString().equals(""))
                    etICICIAccidentalBenefits.setText("1,000,000");
                setDefaultValues("LIFE AND HEALTH");
                break;
            case "ALL IN ONE":
                termRequestEntity.setPlanTaken("All in One");
                llICICICritical.setVisibility(View.VISIBLE);
                llICICIAccidental.setVisibility(View.VISIBLE);
                if (etICICIAccidentalBenefits.getText().toString().equals(""))
                    etICICIAccidentalBenefits.setText("1,000,000");
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

    private void bindHeaders() {
        if (termRequestEntity != null) {

            tvSum.setText("");
            tvSum.append("SUM  ");
            SpannableString SUM = new SpannableString(termRequestEntity.getSumAssured());
            SUM.setSpan(new StyleSpan(Typeface.BOLD), 0, termRequestEntity.getSumAssured().length(), 0);
            tvSum.append(SUM);


            try {
                tvAge.setText("");
                tvAge.append("AGE  ");
                Date ag = simpleDateFormat.parse(termRequestEntity.getInsuredDOB());
                Calendar ageCalender = Calendar.getInstance();
                ageCalender.setTime(ag);
                String age = "" + caluclateAge(ageCalender);
                SpannableString AGE = new SpannableString(age);
                AGE.setSpan(new StyleSpan(Typeface.BOLD), 0, age.length(), 0);
                tvAge.append(AGE);
            } catch (ParseException e) {
                e.printStackTrace();
            }


            tvPolicyTerm.setText("");
            tvPolicyTerm.append("TERM  ");
            SpannableString TERM = new SpannableString(termRequestEntity.getPolicyTerm());
            TERM.setSpan(new StyleSpan(Typeface.BOLD), 0, termRequestEntity.getPolicyTerm().length(), 0);
            tvPolicyTerm.append(TERM);
            tvPolicyTerm.append(" YRS");

            if (termRequestEntity.getInsuredGender().equals("M"))
                tvGender.setText("MALE");
            else
                tvGender.setText("FEMALE");
            if (termRequestEntity.getIs_TabaccoUser().equals("true"))
                tvSmoker.setText("SMOKER");
            else
                tvSmoker.setText("NON-SMOKER");


            tvCrn.setText("");
            tvCrn.append("CRN  ");
            String crn = "" + termCompareQuoteResponse.getMasterData().getResponse().get(0).getCustomerReferenceID();
            SpannableString CRN = new SpannableString(crn);
            CRN.setSpan(new StyleSpan(Typeface.BOLD), 0, crn.length(), 0);
            tvCrn.append(CRN);
            termRequestEntity.setCrn(crn);
            termFinmartRequest.setTermRequestEntity(termRequestEntity);

            // tvAge.setText("" + termRequestEntity.getInsuredDOB());
            //tvPolicyTerm.setText("" + termRequestEntity.getPolicyTerm() + " YEARS");
            //tvCrn.setText("---");
        }
    }

    private void bindQuotes() {
        final TermCompareResponseEntity responseEntity = termCompareQuoteResponse.getMasterData().getResponse().get(0);
        txtPlanNAme.setText("" + responseEntity.getProductPlanName());
        txtCover.setText("" + responseEntity.getSumAssured());
        txtPolicyTerm.setText(responseEntity.getPolicyTermYear() + "Yrs.");
        txtFinalPremium.setText("\u20B9 " + responseEntity.getNetPremium() + "/Year");
        //  txtFinalPremium.setText("\u20B9 " + Math.round(Double.parseDouble(responseEntity.getFinal_premium_with_addon())));

       /* Glide.with(getActivity())
                .load("http://www.policyboss.com/Images/insurer_logo/" + responseEntity.getInsurerLogoName())
                .into(imgInsurerLogo);*/

        txtFinalPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ((TermInputFragment) getActivity()).redirectToBuy(responseEntity);
            }
        });

        /*if (responseEntity.getKeyFeatures() != null) {
            llAddon.setVisibility(View.VISIBLE);
            rvAddOn.setHasFixedSize(true);
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext.getActivity(), 2);
            rvAddOn.setLayoutManager(mLayoutManager);
            GridTermAdapter adapter = new GridTermAdapter(mContext.getActivity(), responseEntity.getKeyFeatures().split("\\|"));
            rvAddOn.setAdapter(adapter);

        } else {
            llAddon.setVisibility(View.GONE);
        }*/
    }

    private void hideShowLayout(boolean isInput) {
        if (isInput) {
            //((IciciTermActivity) getActivity()).redirectToInput(termFinmartRequest);
            btnGetQuote.setText("GET QUOTE");
            tilPincode.setVisibility(View.VISIBLE);
            layoutCompare.setVisibility(View.VISIBLE);
            cvInputDetails.setVisibility(View.GONE);
            cvQuoteDetails.setVisibility(View.GONE);
        } else {
            ((IciciTermActivity) getActivity()).redirectToQuote(termFinmartRequest);
            btnGetQuote.setText("UPDATE QUOTE");
            tilPincode.setVisibility(View.INVISIBLE);
            layoutCompare.setVisibility(View.GONE);
            cvInputDetails.setVisibility(View.VISIBLE);
            cvQuoteDetails.setVisibility(View.VISIBLE);
        }
    }

    private void bindInput(TermFinmartRequest termFinmartRequest) {
        try {
            TermRequestEntity termRequestEntity = termFinmartRequest.getTermRequestEntity();
            if (termRequestEntity != null) {

                if (termRequestEntity.getPremiumPaymentOption().equals("Regular Pay")) {
                    spICICIPremiumTerm.setSelection(0);
                } else if (termRequestEntity.getPremiumPaymentOption().equals("Single Pay")) {
                    spICICIPremiumTerm.setSelection(1);
                } else if (termRequestEntity.getPremiumPaymentOption().equals("Limited Pay")) {
                    spICICIPremiumTerm.setSelection(2);
                }
                String[] listOption = getActivity().getResources().getStringArray(R.array.icici_options);
                final List<String> optionsList = new ArrayList<>(Arrays.asList(listOption));
                ArrayAdapter<String> spAdapterOptions = new ArrayAdapter<String>(getActivity()
                        , android.R.layout.simple_spinner_item
                        , optionsList);

                spAdapterOptions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spICICIOptions.setAdapter(spAdapterOptions);
                if (termRequestEntity.getPlanTaken().equals("Life")) {
                    spICICIOptions.setSelection(0);
                } else if (termRequestEntity.getPlanTaken().equals("Life Plus")) {
                    spICICIOptions.setSelection(1);
                } else if (termRequestEntity.getPlanTaken().equals("Life and Health")) {
                    spICICIOptions.setSelection(2);
                } else if (termRequestEntity.getPlanTaken().equals("All in One")) {
                    spICICIOptions.setSelection(3);
                }

                if (termRequestEntity.getFrequency().equals("yearly")) {
                    spICICIPremiumFrequency.setSelection(0);
                } else if (termRequestEntity.getFrequency().equals("Half Yearly")) {
                    spICICIPremiumFrequency.setSelection(1);
                } else if (termRequestEntity.getFrequency().equals("yearly")) {
                    spICICIPremiumFrequency.setSelection(2);
                }


                String[] splitStr = termRequestEntity.getContactName().split("\\s+");
                etFirstName.setText("" + splitStr[0]);
                etLastName.setText("" + splitStr[1]);
                etMobile.setText("" + termRequestEntity.getContactMobile());
                etDOB.setText("" + termRequestEntity.getInsuredDOB());
                etPincode.setText("" + termRequestEntity.getPincode());

                if (termRequestEntity.getIs_TabaccoUser().equals("true"))
                    rbYesSmoker.setChecked(true);
                else
                    rbNoSmoker.setChecked(true);

                if (termRequestEntity.getInsuredGender().equals("M"))
                    rbMale.setChecked(true);
                else
                    rbfemale.setChecked(true);


                if (termRequestEntity.getDeathBenefitOption().equals("lump-sum")) {
                    incomeSelection("LUMP SUM");
                } else if (termRequestEntity.getDeathBenefitOption().equals("income")) {
                    incomeSelection("REGULAR INCOME");
                } else if (termRequestEntity.getDeathBenefitOption().equals("increasing income")) {
                    incomeSelection("INCREASING INCOME");
                } else if (termRequestEntity.getDeathBenefitOption().equals("lump-sum-income")) {
                    incomeSelection("LUMP SUM + REGULAR INCOME");
                }

                if (termRequestEntity.getCIBenefit() != null)
                    etICICICriticalIllness.setText("" + termRequestEntity.getCIBenefit());

                if (termRequestEntity.getADHB() != null)
                    etICICIAccidentalBenefits.setText("" + termRequestEntity.getADHB());

                if (termRequestEntity.getLumpsumPercentage() != null)
                    etICICILumpSumpPerc.setText("" + termRequestEntity.getLumpsumPercentage());

                etSumAssured.setText("" + termRequestEntity.getSumAssured());
                etICICIPolicyTerm.setText("" + termRequestEntity.getPolicyTerm());
                etICICIPremiumTerm.setText("" + termRequestEntity.getPPT());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setListener() {

        ivEdit.setOnClickListener(this);
        ivBuy.setOnClickListener(this);
//        filter.setOnClickListener(this);

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
        spICICIPremiumFrequency.setOnItemSelectedListener(optionSelected);
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


        //quote page
        cvInputDetails = (CardView) view.findViewById(R.id.cvInputDetails);
        cvQuoteDetails = (CardView) view.findViewById(R.id.cvQuoteDetails);
        layoutCompare = (View) view.findViewById(R.id.layoutCompare);
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
            case R.id.ivBuy:
                new TermInsuranceController(getActivity()).convertQuoteToApp("" + termFinmartRequest.getTermRequestId(), "39", "" + dbPersistanceController.getUserData().getFBAId(), "" + termCompareQuoteResponse.getMasterData().getResponse().get(0).getNetPremium(), this);
                startActivity(new Intent(getActivity(), CommonWebViewActivity.class)
                        .putExtra("URL", termCompareQuoteResponse.getMasterData().getResponse().get(0).getProposerPageUrl())
                        .putExtra("NAME", "ICICI PRUDENTIAL")
                        .putExtra("TITLE", "ICICI PRUDENTIAL"));
                new TrackingController(getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Life Ins Buy"), Constants.LIFE_INS), null);

                break;
            case R.id.btnGetQuote:

                if (isValidInput()) {
                    setTermRequest();
                    //((IciciTermActivity) getActivity()).redirectToQuote(termFinmartRequest);
                    fetchQuotes();
                }
                break;

            case R.id.ivEdit:
                //((IciciTermActivity) getActivity()).redirectToInput(termFinmartRequest);
                hideShowLayout(true);
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

    private void fetchQuotes() {
        showDialog();
        new TermInsuranceController(getActivity()).getTermInsurer(termFinmartRequest, this);
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
                termRequestEntity.setDeathBenefitOption("lump-sum");
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

        termRequestEntity.setSumAssured(etSumAssured.getText().toString().replaceAll("\\,", ""));
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
        else
            termRequestEntity.setCIBenefit("");

        if (llICICIAccidental.getVisibility() == View.VISIBLE)
            termRequestEntity.setADHB("" + etICICIAccidentalBenefits.getText().toString().replaceAll("\\,", ""));
        else
            termRequestEntity.setADHB("");

        if (llICICILumpSumpPerc.getVisibility() == View.VISIBLE)
            termRequestEntity.setLumpsumPercentage(etICICILumpSumpPerc.getText().toString());
        else
            termRequestEntity.setLumpsumPercentage("0");


        termRequestEntity.setPolicyTerm("" + etICICIPolicyTerm.getText().toString());
        termRequestEntity.setInsurerId(39);
        //termRequestEntity.setPlanTaken("Life");// set in manipulateInputs()
        //termRequestEntity.setFrequency("Annual"); //set in optionSelected
        //termRequestEntity.setDeathBenefitOption("Lump-Sum"); //set in incomeSelection()
        termRequestEntity.setPPT("" + etICICIPremiumTerm.getText().toString());

       /* if (termCompareQuoteResponse != null && termCompareQuoteResponse.getMasterData() != null && termCompareQuoteResponse.getMasterData().getLifeTermRequestID() != 0)
            termFinmartRequest.setTermRequestId(termCompareQuoteResponse.getMasterData().getLifeTermRequestID());
        else
            termFinmartRequest.setTermRequestId(0);*/
        termFinmartRequest.setFba_id(new DBPersistanceController(getActivity()).getUserData().getFBAId());
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

    //region date picker

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


        if (etSumICICIAssured.getText().toString().isEmpty()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etSumICICIAssured.requestFocus();
                etSumICICIAssured.setError("Enter Sum Assured");
                etSumICICIAssured.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                return false;
            } else {
                etSumICICIAssured.requestFocus();
                etSumICICIAssured.setError("Enter Sum Assured");
                return false;
            }

        }


        if (etICICILumpSumpPerc.getText().toString().isEmpty()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etICICILumpSumpPerc.requestFocus();
                etICICILumpSumpPerc.setError("Enter Lump Sump (%)");
                etICICILumpSumpPerc.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                return false;
            } else {
                etICICILumpSumpPerc.requestFocus();
                etICICILumpSumpPerc.setError("Enter Lump Sump (%)");
                return false;
            }

        } else {
            int lumpsump = Integer.parseInt(etICICILumpSumpPerc.getText().toString().replaceAll("\\,", ""));
            if (lumpsump < 5 && lumpsump > 95) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    etICICILumpSumpPerc.requestFocus();
                    etICICILumpSumpPerc.setError("Enter valid Lump Sump (%)");
                    etICICILumpSumpPerc.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    return false;
                } else {
                    etICICILumpSumpPerc.requestFocus();
                    etICICILumpSumpPerc.setError("Enter valid Lump Sump (%)");
                    return false;
                }

            }
        }

        if (etICICIPolicyTerm.getText().toString().isEmpty()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etICICIPolicyTerm.requestFocus();
                etICICIPolicyTerm.setError("Enter Policy Term ");
                etICICIPolicyTerm.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                return false;
            } else {
                etICICIPolicyTerm.requestFocus();
                etICICIPolicyTerm.setError("Enter Policy Term ");
                return false;
            }

        } else {
            int lumpsump = Integer.parseInt(etICICIPolicyTerm.getText().toString().replaceAll("\\,", ""));
            if (lumpsump < 5 || lumpsump > 75) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    etICICIPolicyTerm.requestFocus();
                    etICICIPolicyTerm.setError("Enter valid Policy Term ");
                    etICICIPolicyTerm.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    return false;
                } else {
                    etICICIPolicyTerm.requestFocus();
                    etICICIPolicyTerm.setError("Enter valid  Policy Term ");
                    return false;
                }

            }
        }

        if (etICICIPremiumTerm.getText().toString().isEmpty()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etICICIPremiumTerm.requestFocus();
                etICICIPremiumTerm.setError("Enter Premium Term ");
                etICICIPremiumTerm.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                return false;
            } else {
                etICICIPremiumTerm.requestFocus();
                etICICIPremiumTerm.setError("Enter Premium Term ");
                return false;
            }

        } else {
            int lumpsump = Integer.parseInt(etICICIPremiumTerm.getText().toString().replaceAll("\\,", ""));
            if (lumpsump < 0 || lumpsump > 75) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    etICICIPremiumTerm.requestFocus();
                    etICICIPremiumTerm.setError("Enter valid Premium Term ");
                    etICICIPremiumTerm.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    return false;
                } else {
                    etICICIPremiumTerm.requestFocus();
                    etICICIPremiumTerm.setError("Enter valid  Premium Term ");
                    return false;
                }

            }
        }
        if (llICICIAccidental.getVisibility() == View.VISIBLE) {
            if (etICICIAccidentalBenefits.getText().toString().isEmpty()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    etICICIAccidentalBenefits.requestFocus();
                    etICICIAccidentalBenefits.setError("Enter Accidental Benefits");
                    etICICIAccidentalBenefits.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    return false;
                } else {
                    etICICIAccidentalBenefits.requestFocus();
                    etICICIAccidentalBenefits.setError("Enter Accidental Benefits");
                    return false;
                }

            } else {
                int lumpsump = Integer.parseInt(etICICIAccidentalBenefits.getText().toString().replaceAll("\\,", ""));
                int sumInsured = Integer.parseInt(etSumICICIAssured.getText().toString().replaceAll("\\,", ""));
                if (lumpsump < 100000 || lumpsump > sumInsured) {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etICICIAccidentalBenefits.requestFocus();
                        etICICIAccidentalBenefits.setError("Enter valid Accidental Benefits");
                        etICICIAccidentalBenefits.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return false;
                    } else {
                        etICICIAccidentalBenefits.requestFocus();
                        etICICIAccidentalBenefits.setError("Enter valid  Accidental Benefits");
                        return false;
                    }

                }
            }
        }
        if (llICICICritical.getVisibility() == View.VISIBLE) {
            if (etICICICriticalIllness.getText().toString().isEmpty()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    etICICICriticalIllness.requestFocus();
                    etICICICriticalIllness.setError("Enter Critical illness");
                    etICICICriticalIllness.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    return false;
                } else {
                    etICICICriticalIllness.requestFocus();
                    etICICICriticalIllness.setError("Enter Critical illness");
                    return false;
                }

            } else {
                int lumpsump = Integer.parseInt(etICICICriticalIllness.getText().toString().replaceAll("\\,", ""));
                int sumInsured = Integer.parseInt(etSumICICIAssured.getText().toString().replaceAll("\\,", ""));
                if (lumpsump < 100000 || lumpsump > sumInsured) {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etICICICriticalIllness.requestFocus();
                        etICICICriticalIllness.setError("Enter valid Critical illness");
                        etICICICriticalIllness.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return false;
                    } else {
                        etICICICriticalIllness.requestFocus();
                        etICICICriticalIllness.setError("Enter valid  Critical illness");
                        return false;
                    }

                }
            }
        }

        return true;
    }
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

    @Override
    public void OnSuccess(APIResponse response, String message) {
        if (response instanceof TermCompareQuoteResponse) {
            cancelDialog();
            this.termCompareQuoteResponse = (TermCompareQuoteResponse) response;
            this.cvInputDetails.requestFocus();
            //mAdapter = new TermQuoteAdapter(IciciTermQuoteFragment.this, termCompareQuoteResponse);
            //rvTerm.setAdapter(mAdapter);
            String crn = "" + termCompareQuoteResponse.getMasterData().getResponse().get(0).getCustomerReferenceID();
            termRequestEntity.setCrn(crn);
            termFinmartRequest.setTermRequestEntity(termRequestEntity);
            if (((TermCompareQuoteResponse) response).getMasterData().getLifeTermRequestID() != 0)
                termRequestId = ((TermCompareQuoteResponse) response).getMasterData().getLifeTermRequestID();
            termFinmartRequest.setTermRequestId(termRequestId);
            bindHeaders();
            bindQuotes();
            hideShowLayout(false);
        }

    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}