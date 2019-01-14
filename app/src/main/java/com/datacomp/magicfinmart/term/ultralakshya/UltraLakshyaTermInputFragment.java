package com.datacomp.magicfinmart.term.ultralakshya;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.MyApplication;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.term.compareterm.CompareTermActivity;
import com.datacomp.magicfinmart.term.hdfc.HdfcIProtectAdapter;

import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;
import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;
 import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class UltraLakshyaTermInputFragment extends BaseFragment implements View.OnClickListener, View.OnFocusChangeListener, BaseFragment.PopUpListener, IResponseSubcriber {


    private PopupWindow mPopupWindow, mPopupWindowSelection;
    View customView, customViewSelection;
    RecyclerView rvIprotectSmart;
    HdfcIProtectAdapter adapter;

    // quote
    TextView tvSum, tvGender, tvSmoker, tvAge, tvPolicyTerm, tvCrn, filter;
    ImageView ivEdit;
    TermCompareResponseEntity termCompareResponseEntity;
    CardView cvInputDetails, cvQuoteDetails;
    View layoutCompare;

    TextView txtPlanNAme, txtCover, txtFinalPremium, txtPolicyTerm, txtAge, txtCustomise, txtRiders;
    ImageView imgInsurerLogo, ivBuy, ivPdf;
    LinearLayout llAddon;
    RecyclerView rvAddOn;

    Button btnGetQuote;
    EditText etFirstName, etMobile, etDOB;
    TextView tvMale, tvFemale, tvYes, tvNo;
    boolean isMale, isSmoker;
    LinearLayout llGender, llSmoker;



    List<String> policyYear;
    DBPersistanceController dbPersistanceController;
    Spinner spPolicyTerm;

    TermRequestEntity termRequestEntity;
    TermFinmartRequest termFinmartRequest;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    LinearLayout llCompareAll;
    ScrollView mainScroll;

    //region icici form
    Spinner   spICICIPremiumFrequency;
    ArrayAdapter<String>  ICICIPremiumTermAdapter, ICICIPremiumFrequencyAdapter;
    List<String> premiumTermList, frequenctList;

    EditText etSumICICIAssured;

    Button minusICICISum, plusICICISum;


    TextInputLayout tilPremiumPayment;
    //endregion

    boolean isEdit = false, canChangePremiumTerm = true, canChangePolicyTerm = true;
    int termRequestId = 0, insurerID, age = 0;
    String crn = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ultra_lakshya_term_input, container, false);
        init(view);
        setListener();
        setPopUpInfo();
        // set initial values
        dbPersistanceController = new DBPersistanceController(getActivity());
        policyYear = dbPersistanceController.getPremYearList();
        termRequestEntity = new TermRequestEntity(getActivity());
        termFinmartRequest = new TermFinmartRequest();
        init_adapters();

        adapter_listener();
        setDefaultsIcici();

        if (getArguments() != null) {
            if (getArguments().getParcelable(UltraLakshyaTermActivity.QUOTE_DATA) != null) {
                termFinmartRequest = getArguments().getParcelable(UltraLakshyaTermActivity.QUOTE_DATA);
                termRequestEntity = termFinmartRequest.getTermRequestEntity();
                termRequestId = termFinmartRequest.getTermRequestId();
                int fba_id = new DBPersistanceController(getActivity()).getUserData().getFBAId();
                termFinmartRequest.setFba_id(fba_id);
                showDialog("Please Wait..");
                fetchWithDelay();
            } else if (getArguments().getParcelable(UltraLakshyaTermActivity.INPUT_DATA) != null) {
                termFinmartRequest = getArguments().getParcelable(UltraLakshyaTermActivity.INPUT_DATA);
                termRequestEntity = termFinmartRequest.getTermRequestEntity();
                termRequestId = termFinmartRequest.getTermRequestId();
                changeInputQuote(true);
            } else if (getArguments().getParcelable(CompareTermActivity.OTHER_QUOTE_DATA) != null) {
                termCompareResponseEntity = getArguments().getParcelable(CompareTermActivity.OTHER_QUOTE_DATA_RESPONSE);
                termFinmartRequest = getArguments().getParcelable(CompareTermActivity.OTHER_QUOTE_DATA);
                termRequestEntity = termFinmartRequest.getTermRequestEntity();
                termRequestId = termFinmartRequest.getTermRequestId();
                bindHeaders();
                bindQuotes();
                bindInputFromOther(termFinmartRequest);
                fromCompare();
            } else {
                changeInputQuote(true);
                tvNo.performClick();
                tvMale.performClick();
              //  txtICICILumpSum.performClick();
            }
            //bindICICI();
            if (termFinmartRequest != null && termFinmartRequest.getTermRequestEntity() != null && getArguments().getParcelable(CompareTermActivity.OTHER_QUOTE_DATA) == null)
                bindInput(termFinmartRequest);
        }


        return view;
    }

    private void fetchWithDelay() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                btnGetQuote.performClick();
            }
        }, 2000);
    }

    private void setDefaultsIcici() {
        etSumICICIAssured.setText("200000");

        //by default Regular pay selected.
        //spICICIPremiumTerm.setSelection(0);

    }




    private void bindHeaders() {
        if (termRequestEntity != null && getActivity() != null) {

            tvSum.setText("");
            tvSum.append("SUM  ");
            SpannableString SUM = new SpannableString(termRequestEntity.getSumAssured());
            SUM.setSpan(new StyleSpan(Typeface.BOLD), 0, termRequestEntity.getSumAssured().length(), 0);
            SUM.setSpan(new ForegroundColorSpan(getActivity().getResources().getColor(R.color.header_dark_text)), 0, termRequestEntity.getSumAssured().length(), 0);
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
                AGE.setSpan(new ForegroundColorSpan(getActivity().getResources().getColor(R.color.header_dark_text)), 0, age.length(), 0);
                tvAge.append(AGE);
            } catch (ParseException e) {
                e.printStackTrace();
            }


            tvPolicyTerm.setText("");
            tvPolicyTerm.append("TERM  ");
            SpannableString TERM = new SpannableString(termRequestEntity.getPolicyTerm() + " Years");
            TERM.setSpan(new StyleSpan(Typeface.BOLD), 0, TERM.length(), 0);
            TERM.setSpan(new ForegroundColorSpan(getActivity().getResources().getColor(R.color.header_dark_text)), 0, TERM.length(), 0);
            tvPolicyTerm.append(TERM);

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
            String crn = "" + termCompareResponseEntity.getCustomerReferenceID();
            SpannableString CRN = new SpannableString(crn);
            CRN.setSpan(new StyleSpan(Typeface.BOLD), 0, crn.length(), 0);
            CRN.setSpan(new ForegroundColorSpan(getActivity().getResources().getColor(R.color.header_dark_text)), 0, crn.length(), 0);
            tvCrn.append(CRN);
            termRequestEntity.setExisting_ProductInsuranceMapping_Id(crn);
            termFinmartRequest.setTermRequestEntity(termRequestEntity);

            // tvAge.setText("" + termRequestEntity.getInsuredDOB());
            //tvPolicyTerm.setText("" + termRequestEntity.getPolicyTerm() + " YEARS");
            //tvCrn.setText("---");
        }
    }

    private void bindQuotes() {
        final TermCompareResponseEntity responseEntity = termCompareResponseEntity;
        txtPlanNAme.setText("" + responseEntity.getProductPlanName());
        txtCover.setText("\u20B9 " + responseEntity.getSumAssured());
        txtPolicyTerm.setText(responseEntity.getPolicyTermYear() + " Yrs.");
        txtFinalPremium.setText("\u20B9 " + responseEntity.getNetPremium());
        int uptoAge = Integer.parseInt(termRequestEntity.getPPT()) + caluclateAge(etDOB.getText().toString());
        txtAge.setText("" + uptoAge + " Yrs.");
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

    private void changeInputQuote(boolean isInput) {
        if (isInput) {

            btnGetQuote.setText("GET QUOTE");

            layoutCompare.setVisibility(View.VISIBLE);
            cvInputDetails.setVisibility(View.GONE);
            cvQuoteDetails.setVisibility(View.GONE);
        } else {
            if (getArguments().getParcelable(CompareTermActivity.OTHER_QUOTE_DATA) != null)
                ((CompareTermActivity) getActivity()).redirectToQuote(termFinmartRequest);
            else
                ((UltraLakshyaTermActivity) getActivity()).redirectToQuote(termFinmartRequest);
            btnGetQuote.setText("UPDATE QUOTE");

            layoutCompare.setVisibility(View.GONE);
            cvInputDetails.setVisibility(View.VISIBLE);
            cvQuoteDetails.setVisibility(View.VISIBLE);
        }
    }

    private void fromCompare() {
        btnGetQuote.setText("UPDATE QUOTE");

        layoutCompare.setVisibility(View.GONE);
        cvInputDetails.setVisibility(View.VISIBLE);
        cvQuoteDetails.setVisibility(View.VISIBLE);
    }

    private void bindInput(TermFinmartRequest termFinmartRequest) {
        try {
            TermRequestEntity termRequestEntity = termFinmartRequest.getTermRequestEntity();
            if (termRequestEntity != null) {

                //spICICIPremiumTerm.setOnItemSelectedListener(null);
                //spICICIPremiumFrequency.setOnItemSelectedListener(null);
                //spICICIOptions.setOnItemSelectedListener(null);
                isEdit = true;

                age = caluclateAge("" + termRequestEntity.getInsuredDOB());
             //   bindPremiumPayment(getPremiumPaymentId(termRequestEntity.getPPT(), age));

                String[] listOption = getActivity().getResources().getStringArray(R.array.icici_options);
                final List<String> optionsList = new ArrayList<>(Arrays.asList(listOption));
                ArrayAdapter<String> spAdapterOptions = new ArrayAdapter<String>(getActivity()
                        , android.R.layout.simple_spinner_item
                        , optionsList);



                if (termRequestEntity.getFrequency().equals("yearly")) {
                    spICICIPremiumFrequency.setSelection(0);
                } else if (termRequestEntity.getFrequency().equals("Half Yearly")) {
                    spICICIPremiumFrequency.setSelection(1);
                } else if (termRequestEntity.getFrequency().equals("Monthly")) {
                    spICICIPremiumFrequency.setSelection(2);
                }


                String[] splitStr = termRequestEntity.getContactName().split("\\s+");
                String firstName = "", lastName = "";
                for (int i = 0; i < splitStr.length; i++) {
                    if (i == ((splitStr.length) - 1)) {
                        lastName = lastName + splitStr[i];
                    } else {
                        firstName = firstName + " " + splitStr[i];
                    }
                }
                etFirstName.setText("" + firstName);

                etMobile.setText("" + termRequestEntity.getContactMobile());
                etDOB.setText("" + termRequestEntity.getInsuredDOB());


                if (termRequestEntity.getIs_TabaccoUser().equals("true")) {
                    isSmoker = true;
                    tvYes.setBackgroundResource(R.drawable.customeborder_blue);
                    tvNo.setBackgroundResource(R.drawable.customeborder);
                } else {
                    isSmoker = false;
                    tvNo.setBackgroundResource(R.drawable.customeborder_blue);
                    tvYes.setBackgroundResource(R.drawable.customeborder);
                }

                if (termRequestEntity.getInsuredGender().equals("M")) {
                    isMale = true;
                    tvMale.setBackgroundResource(R.drawable.customeborder_blue);
                    tvFemale.setBackgroundResource(R.drawable.customeborder);
                } else {
                    isMale = false;
                    tvFemale.setBackgroundResource(R.drawable.customeborder_blue);
                    tvMale.setBackgroundResource(R.drawable.customeborder);
                }



                etSumICICIAssured.setText("" + termRequestEntity.getSumAssured());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    private void bindInputFromOther(TermFinmartRequest termFinmartRequest) {
        try {
            TermRequestEntity termRequestEntity = termFinmartRequest.getTermRequestEntity();
            if (termRequestEntity != null) {

                isEdit = true;


                spICICIPremiumFrequency.setSelection(0);

                String[] splitStr = termRequestEntity.getContactName().split("\\s+");
                etFirstName.setText("" + splitStr[0]);

                etMobile.setText("" + termRequestEntity.getContactMobile());
                etDOB.setText("" + termRequestEntity.getInsuredDOB());
                age = caluclateAge("" + termRequestEntity.getInsuredDOB());


                if (termRequestEntity.getIs_TabaccoUser().equals("true")) {
                    isSmoker = true;
                    tvYes.setBackgroundResource(R.drawable.customeborder_blue);
                    tvNo.setBackgroundResource(R.drawable.customeborder);
                } else {
                    isSmoker = false;
                    tvNo.setBackgroundResource(R.drawable.customeborder_blue);
                    tvYes.setBackgroundResource(R.drawable.customeborder);
                }

                if (termRequestEntity.getInsuredGender().equals("M")) {
                    isMale = true;
                    tvMale.setBackgroundResource(R.drawable.customeborder_blue);
                    tvFemale.setBackgroundResource(R.drawable.customeborder);
                } else {
                    isMale = false;
                    tvFemale.setBackgroundResource(R.drawable.customeborder_blue);
                    tvMale.setBackgroundResource(R.drawable.customeborder);
                }

                etSumICICIAssured.setText("" + termRequestEntity.getSumAssured());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setListener() {

        ivEdit.setOnClickListener(this);

        tvMale.setOnClickListener(this);
        tvFemale.setOnClickListener(this);
        tvYes.setOnClickListener(this);
        tvNo.setOnClickListener(this);
//        filter.setOnClickListener(this);

        btnGetQuote.setOnClickListener(this);
        etDOB.setOnClickListener(datePickerDialog);

        minusICICISum.setOnClickListener(this);
        plusICICISum.setOnClickListener(this);

        etSumICICIAssured.setOnFocusChangeListener(this);

    }

    private void init_adapters() {



        String[] listPremiumTerm = getActivity().getResources().getStringArray(R.array.icici_payment_term);
        premiumTermList = new ArrayList<>(Arrays.asList(listPremiumTerm));




        String[] listPremiumFreq = getActivity().getResources().getStringArray(R.array.icici_premium_frequency);
        frequenctList = new ArrayList<>(Arrays.asList(listPremiumFreq));

        ICICIPremiumFrequencyAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, frequenctList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                view.setPadding(0, view.getPaddingTop(), 0, view.getPaddingBottom());
                return view;
            }
        };
        spICICIPremiumFrequency.setAdapter(ICICIPremiumFrequencyAdapter);


    }

    private void adapter_listener() {



        //region Premium Frequency
        spICICIPremiumFrequency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                manipulateFrequency();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //endregion


    }

    public void bindPremiumPayment(int selection) {
       /*
        String[] listPremiumPayWhole = getActivity().getResources().getStringArray(R.array.icici_premium_payment_whole_life);
        String[] listPremiumPayLimited = getActivity().getResources().getStringArray(R.array.icici_premium_payment_limited_pay);

        if (spICICIPremiumTerm.getSelectedItemPosition() == 2) {

            premiumPaymentList = new ArrayList<>(Arrays.asList(listPremiumPayLimited));

        } else if (spICICIPremiumTerm.getSelectedItemPosition() == 3) {
            premiumPaymentList = new ArrayList<>(Arrays.asList(listPremiumPayWhole));
        }

        ICICIPremiumPaymentAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, premiumPaymentList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                view.setPadding(0, view.getPaddingTop(), 0, view.getPaddingBottom());
                return view;
            }
        };
        spICICIPremiumPayment.setAdapter(ICICIPremiumPaymentAdapter);
        spICICIPremiumPayment.setSelection(selection);
        */
    }



    private void manipulatePremiumTerm() {


        String[] listOption = getActivity().getResources().getStringArray(R.array.icici_options);
        String[] listPremiumFrequency = getActivity().getResources()
                .getStringArray(R.array.icici_premium_frequency);

        final List<String> optionsList = new ArrayList<>(Arrays.asList(listOption));
        final List<String> premiumFreqList = new ArrayList<>(Arrays.asList(listPremiumFrequency));

        //String[] listPremiumPayWhole = getActivity().getResources().getStringArray(R.array.icici_premium_payment_whole_life);
        //String[] listPremiumPayLimited = getActivity().getResources().getStringArray(R.array.icici_premium_payment_limited_pay);



        if (!isEdit) {


            ArrayAdapter<String> spAdapterPremiumFreq = new ArrayAdapter<String>(getActivity()
                    , android.R.layout.simple_spinner_item
                    , premiumFreqList);

            spAdapterPremiumFreq.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spICICIPremiumFrequency.setAdapter(spAdapterPremiumFreq);


            bindPremiumPayment(0);
        } else {
            isEdit = false;
        }


    }

    private void manipulateFrequency() {
        switch (spICICIPremiumFrequency.getSelectedItemPosition()) {
            case 0:
                termRequestEntity.setFrequency("yearly");
                break;
            case 1:
                termRequestEntity.setFrequency("Half Yearly");
                break;
            case 2:
                termRequestEntity.setFrequency("Quarterly");
                break;
            case 3:
                termRequestEntity.setFrequency("Monthly");
                break;
        }
    }



    //region adapter listener
    AdapterView.OnItemSelectedListener optionSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (parent.getId() == R.id.spICICIPremiumFrequency) {
                switch (spICICIPremiumFrequency.getSelectedItemPosition()) {
                    case 0:
                        termRequestEntity.setFrequency("yearly");
                        break;
                    case 1:
                        termRequestEntity.setFrequency("Half Yearly");
                        break;
                    case 2:
                        termRequestEntity.setFrequency("Quarterly");
                        break;
                    case 3:
                        termRequestEntity.setFrequency("Monthly");
                        break;
                }

            } else if (parent.getId() == R.id.spICICIPremiumTerm) {

                String[] listOption = getActivity().getResources().getStringArray(R.array.icici_options);
                String[] listPremiumFrequency = getActivity().getResources()
                        .getStringArray(R.array.icici_premium_frequency);

                final List<String> optionsList = new ArrayList<>(Arrays.asList(listOption));
                final List<String> premiumFreqList = new ArrayList<>(Arrays.asList(listPremiumFrequency));


                /*if (!isEdit) {*/

                ArrayAdapter<String> spAdapterPremiumFreq = new ArrayAdapter<String>(getActivity()
                        , android.R.layout.simple_spinner_item
                        , premiumFreqList);

                spAdapterPremiumFreq.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spICICIPremiumFrequency.setAdapter(spAdapterPremiumFreq);
                    /*isEdit = false;
                }*/

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    //endregion


    private void init(View view) {


        //quote page
        cvInputDetails = (CardView) view.findViewById(R.id.cvInputDetails);
        cvQuoteDetails = (CardView) view.findViewById(R.id.cvQuoteDetails);
        layoutCompare = (View) view.findViewById(R.id.layoutCompare);

        tvSum = (TextView) view.findViewById(R.id.tvSum);
        tvGender = (TextView) view.findViewById(R.id.tvGender);
        tvSmoker = (TextView) view.findViewById(R.id.tvSmoker);
        tvAge = (TextView) view.findViewById(R.id.tvAge);
        tvPolicyTerm = (TextView) view.findViewById(R.id.tvPolicyTerm);
        tvCrn = (TextView) view.findViewById(R.id.tvCrn);
        ivEdit = (ImageView) view.findViewById(R.id.ivEdit);

        txtAge = (TextView) view.findViewById(R.id.txtAge);



        btnGetQuote = (Button) view.findViewById(R.id.btnGetQuote);
        etFirstName = (EditText) view.findViewById(R.id.etFirstName);

        etMobile = (EditText) view.findViewById(R.id.etMobile);
        etDOB = (EditText) view.findViewById(R.id.etDateofBirth);
        tvMale = (TextView) view.findViewById(R.id.tvMale);
        tvFemale = (TextView) view.findViewById(R.id.tvFemale);
        tvYes = (TextView) view.findViewById(R.id.tvYes);
        tvNo = (TextView) view.findViewById(R.id.tvNo);
        llGender = (LinearLayout) view.findViewById(R.id.llGender);
        llSmoker = (LinearLayout) view.findViewById(R.id.llSmoker);


        etSumICICIAssured = (EditText) view.findViewById(R.id.etICICISumAssured);
        spPolicyTerm = (Spinner) view.findViewById(R.id.spPolicyTerm);
        spICICIPremiumFrequency = (Spinner) view.findViewById(R.id.spICICIPremiumFrequency);


        mainScroll = (ScrollView) view.findViewById(R.id.mainScroll);
        //lllayoutICICI = (View) view.findViewById(R.id.layoutICICI);


      //  spICICIPremiumTerm = (Spinner) view.findViewById(R.id.spICICIPremiumTerm);
     //   spICICIPremiumFrequency = (Spinner) view.findViewById(R.id.spICICIPremiumFrequency);




        minusICICISum = (Button) view.findViewById(R.id.minusICICISum);
        plusICICISum = (Button) view.findViewById(R.id.plusICICISum);


        //end region
    }

    @Override
    public void onClick(View view) {
        Constants.hideKeyBoard(view, getActivity());
        btnGetQuote.requestFocus();
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

            case R.id.ivBuy:
                MyApplication.getInstance().trackEvent(Constants.LIFE_INS, "ICICI BUY TERM INSURANCE", "ICICI BUY TERM INSURANCE");
                new TermInsuranceController(getActivity()).convertQuoteToApp("" + termFinmartRequest.getTermRequestId(), "39", "" + dbPersistanceController.getUserData().getFBAId(), "" + termCompareResponseEntity.getNetPremium(), this);
                startActivity(new Intent(getActivity(), CommonWebViewActivity.class)
                        .putExtra("URL", termCompareResponseEntity.getProposerPageUrl())
                        .putExtra("NAME", "ICICI PRUDENTIAL")
                        .putExtra("TITLE", "ICICI PRUDENTIAL"));
                new TrackingController(getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Life Ins Buy"), Constants.LIFE_INS), null);

                break;
            case R.id.ivPdf:
                MyApplication.getInstance().trackEvent(Constants.LIFE_INS, "ICICI PDF  TERM INSURANCE", "ICICI PDF TERM INSURANCE");
                if (termCompareResponseEntity != null && termCompareResponseEntity.getPdfUrl().equals("")) {
                    Toast.makeText(getActivity(), "Pdf Not Available", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(getActivity(), CommonWebViewActivity.class)
                            .putExtra("URL", termCompareResponseEntity.getPdfUrl())
                            .putExtra("NAME", "ICICI PRUDENTIAL DOWNLOAD")
                            .putExtra("TITLE", "ICICI PRUDENTIAL"));

                }

            case R.id.btnGetQuote:
                MyApplication.getInstance().trackEvent(Constants.LIFE_INS, "ICICI GET QUOTE  TERM INSURANCE", "ICICI GET QUOTE TERM INSURANCE");
                if (isValidInput()) {
                    setTermRequest();

                    fetchQuotes();
                }
                break;

            case R.id.ivEdit:
                if (getArguments().getParcelable(CompareTermActivity.OTHER_QUOTE_DATA) != null)
                    ((CompareTermActivity) getActivity()).redirectToInput(termFinmartRequest);
                else
                    ((UltraLakshyaTermActivity) getActivity()).redirectToInput(termFinmartRequest);
                changeInputQuote(true);
                break;
            case R.id.ivInfo:

                OpenPoupWnidow(termCompareResponseEntity.getKeyFeatures().split("\\|"));
                break;
            case R.id.txtICICILumpSum:
            case R.id.txtICICIRegularIncome:

            case R.id.txtICICILumpSumRegular:

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


        }
    }

    private void fetchQuotes() {
        showDialog("Please Wait..");
        new TermInsuranceController(getActivity()).getTermInsurer(termFinmartRequest, this);
    }

    private void updateCrnToServer() {
        if (termFinmartRequest.getTermRequestEntity().getExisting_ProductInsuranceMapping_Id() != null && !termFinmartRequest.getTermRequestEntity().getExisting_ProductInsuranceMapping_Id().equals(""))
            new TermInsuranceController(getActivity()).updateCRN(termFinmartRequest.getTermRequestId(), Integer.parseInt(termFinmartRequest.getTermRequestEntity().getExisting_ProductInsuranceMapping_Id()), this);
    }







    private void changePolicyTerm(boolean b) {
/*
        if (canChangePolicyTerm) {
            int policyTerm = 0;
            if (!etICICIPolicyTerm.getText().toString().equals(""))
                policyTerm = Integer.parseInt(etICICIPolicyTerm.getText().toString());
            int ppt = 0;
            if (!etICICIPremiumTerm.getText().toString().equals(""))
                ppt = Integer.parseInt(etICICIPremiumTerm.getText().toString());
            if (b) {
                if (policyTerm < (85 - age))
                    policyTerm = policyTerm + 1;
            } else {
                if (policyTerm > 5) {
                    if (ppt >= policyTerm)
                        ppt = policyTerm - 1;
                    policyTerm = policyTerm - 1;

                }

            }

            setPolicyTerm(policyTerm);
            etICICIPremiumTerm.setText("" + ppt);
        }  */


    }

    private void setPolicyTerm(int policyTerm) {
        /*
        switch (spICICIPremiumTerm.getSelectedItemPosition()) {
            case 0:
                if (policyTerm > (85 - age))
                    etICICIPolicyTerm.setText("" + (85 - age));
                else
                    etICICIPolicyTerm.setText("" + policyTerm);
                break;
            case 1://single pay can't be grater than 20
                if (policyTerm > 20)
                    etICICIPolicyTerm.setText("20");
                else
                    etICICIPolicyTerm.setText("" + policyTerm);
                break;
            case 2://limited pay can't be grater than 40
                if (policyTerm > (85 - age))
                    etICICIPolicyTerm.setText("" + (85 - age));
                else
                    etICICIPolicyTerm.setText("" + policyTerm);
                break;
            case 3:
                etICICIPolicyTerm.setText("" + policyTerm);
                break;


        }  */
    }



    private void changeSumAssured(boolean b) {

        long sumAssured = 0;
        if (!etSumICICIAssured.getText().toString().equals(""))
            sumAssured = Long.parseLong(etSumICICIAssured.getText().toString().replaceAll("\\,", ""));
        if (b) {
            if (sumAssured >= 100000 && sumAssured < 1000000)
                sumAssured = sumAssured + 100000;
            else
                sumAssured = sumAssured + 100000;


        } else {
            if (sumAssured > 1000000)
                sumAssured = sumAssured - 100000;
            else if (sumAssured > 100000 && sumAssured <= 1000000)
                sumAssured = sumAssured - 100000;




        }
        // (sumAssured);
        etSumICICIAssured.setText("" + (sumAssured));
    }



    private void setTermRequest() {
        //termRequestEntity.setLumpsumPercentage("0");
        //termRequestEntity.setPolicyTerm("" + dbPersistanceController.getPremYearID(spPolicyTerm.getSelectedItem().toString()));

        if (isMale)
            termRequestEntity.setInsuredGender("M");
        else
            termRequestEntity.setInsuredGender("F");

        if (isSmoker)
            termRequestEntity.setIs_TabaccoUser("true");
        else
            termRequestEntity.setIs_TabaccoUser("false");


        termRequestEntity.setSumAssured(etSumICICIAssured.getText().toString().replaceAll("\\,", ""));
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
        termRequestEntity.setContactName(etFirstName.getText().toString());
        termRequestEntity.setContactEmail("finmarttest@gmail.com");
        termRequestEntity.setContactMobile(etMobile.getText().toString());
        //termRequestEntity.setSupportsAgentID("1682");



        //icici specific
        termRequestEntity.setMaritalStatus("");
        //termRequestEntity.setPremiumPaymentOption(""); //set in optionSelected
        termRequestEntity.setServiceTaxNotApplicable("");// not known






        //termRequestEntity.setPolicyTerm("" + etICICIPolicyTerm.getText().toString());
        termRequestEntity.setInsurerId(39);

     //   termRequestEntity.setPPT("" + etICICIPremiumTerm.getText().toString());

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

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();

        if (response instanceof TermCompareQuoteResponse) {
            processResponse((TermCompareQuoteResponse) response);

        }

    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
        changeInputQuote(true);
    }

    private void processResponse(TermCompareQuoteResponse termCompareQuoteResponse) {

        if (termCompareQuoteResponse.getMasterData() != null && termCompareQuoteResponse.getMasterData().getResponse() != null) {
            if (termCompareQuoteResponse.getMasterData().getResponse().size() != 0) {
                this.termCompareResponseEntity = termCompareQuoteResponse.getMasterData().getResponse().get(0);
                crn = "" + termCompareQuoteResponse.getMasterData().getResponse().get(0).getCustomerReferenceID();
                termRequestEntity.setExisting_ProductInsuranceMapping_Id(crn);
                termFinmartRequest.setTermRequestEntity(termRequestEntity);
                if (termCompareQuoteResponse.getMasterData().getLifeTermRequestID() != 0)
                    termRequestId = termCompareQuoteResponse.getMasterData().getLifeTermRequestID();
                termFinmartRequest.setTermRequestId(termRequestId);
                updateCrnToServer();
                if (termCompareResponseEntity.getQuoteStatus().equals("Success")) {
                    bindHeaders();
                    changeInputQuote(false);
                    bindQuotes();
                } else {
                    changeInputQuote(true);
                    Toast.makeText(getActivity(), "" + termCompareResponseEntity.getQuoteStatus(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "No Quotes Found.", Toast.LENGTH_SHORT).show();
            }
        }

        mainScroll.scrollTo(0, 0);
        //mainScroll.fullScroll(ScrollView.FOCUS_UP);
    }

    private void setPopUpInfo() {

        // region set Default popUp
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);

        // Inflate the custom layout/view
        customView = inflater.inflate(R.layout.layout_benefit_iprotect, null);

        // Initialize a new instance of popup window

        mPopupWindow = new PopupWindow(
                customView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                700
        );


        if (Build.VERSION.SDK_INT >= 21) {
            mPopupWindow.setElevation(5.0f);
        }


        //endregion

        // region set Selection popUp
        LayoutInflater inflaterSelection = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);

        // Inflate the custom layout/view
        customViewSelection = inflaterSelection.inflate(R.layout.layout_age_popup_selected, null);

        // Initialize a new instance of popup window
        mPopupWindowSelection = new PopupWindow(
                customViewSelection,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        //endregion

    }

    private void OpenPoupWnidow(String[] strings) {


        // Get a reference for the custom view close button
        ImageButton closeButton = (ImageButton) customView.findViewById(R.id.imgClose);
        TextView tvTitle = (TextView) customView.findViewById(R.id.tvTitle);
        tvTitle.setText("BENEFIT OF " + termCompareResponseEntity.getProductPlanName());
        rvIprotectSmart = (RecyclerView) customView.findViewById(R.id.rvIprotectSmart);
        rvIprotectSmart.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvIprotectSmart.setLayoutManager(layoutManager);

        adapter = new HdfcIProtectAdapter(getActivity(), strings);
        rvIprotectSmart.setAdapter(adapter);

        // Set a click listener for the popup window close button
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dismiss the popup window
                if (mPopupWindow.isShowing()) {
                    mPopupWindow.dismiss();
                    mPopupWindowSelection.dismiss();


                }
            }
        });


     //   mPopupWindowSelection.showAsDropDown(ivInfo, 0, 0);
        mPopupWindowSelection.setTouchable(true);
        mPopupWindowSelection.setFocusable(true);


        // mPopupWindow.setAnimationStyle(R.style.Animation);
    //    mPopupWindow.showAsDropDown(ivInfo, -40, 40);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setFocusable(true);

    }

    //region dob
    protected View.OnClickListener datePickerDialog = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            Constants.hideKeyBoard(view, getActivity());


            DateTimePicker.showHealthAgeDatePicker(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                    if (view1.isShown()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        String currentDay = simpleDateFormat.format(calendar.getTime());
                        etDOB.setText(currentDay);
                        age = caluclateAge(calendar);


                        //region remove pay till 60 if age > 55
                        /*String[] listPremiumPayLimited = getActivity().getResources().getStringArray(R.array.icici_premium_payment_limited_pay);
                        premiumPaymentList = new ArrayList<>(Arrays.asList(listPremiumPayLimited));
                        if (age > 55) {
                            premiumPaymentList.remove(0);
                        }
                        ICICIPremiumPaymentAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, premiumPaymentList) {
                            @NonNull
                            @Override
                            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                                View view = super.getView(position, convertView, parent);
                                view.setPadding(0, view.getPaddingTop(), 0, view.getPaddingBottom());
                                return view;
                            }
                        };
                        spICICIPremiumPayment.setAdapter(ICICIPremiumPaymentAdapter);*/

                        //endregion


                    }
                }
            });


        }
    };

//endregion

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {

            case R.id.etICICISumAssured:
                if (!b) {

                }
                break;

        }
    }




    private void calculatePremiumTerm() {
        /*
        int maxPremiumTerm = 100;
        int minPremiumTerm = 1;
        long policyTerm = 0;
        long premiumTerm = 0;
        if (!etICICIPremiumTerm.getText().toString().equals(""))
            premiumTerm = Long.parseLong(etICICIPremiumTerm.getText().toString().replaceAll("\\,", ""));

        if (!etICICIPolicyTerm.getText().toString().equals(""))
            policyTerm = Long.parseLong(etICICIPolicyTerm.getText().toString().replaceAll("\\,", ""));


        if (policyTerm >= maxPremiumTerm) {
            etICICIPremiumTerm.setText("" + (maxPremiumTerm));
        } else {
            if (premiumTerm >= policyTerm)
                etICICIPremiumTerm.setText("" + (policyTerm));
        }

        if (premiumTerm <= minPremiumTerm) {
            etICICIPremiumTerm.setText("" + minPremiumTerm);
        }*/
    }

}
