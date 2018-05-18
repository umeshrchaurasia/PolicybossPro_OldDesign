package com.datacomp.magicfinmart.term.hdfc;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.term.icici.IciciTermActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TermCompareQuoteResponse;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

/**
 * Created by Rajeev Ranjan on 17/05/2018.
 */

public class HdfcInputFragment extends BaseFragment implements View.OnClickListener {

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
    View layoutCompare;

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
        hideShowLayout(true);
        return view;
    }

    private void init_view(View view) {

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

    }

    private void setListener() {

        ivEdit.setOnClickListener(this);
        ivBuy.setOnClickListener(this);
//        filter.setOnClickListener(this);

        btnGetQuote.setOnClickListener(this);
        etDOB.setOnClickListener(datePickerDialog);

       /* txtICICILumpSum.setOnClickListener(this);
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
        spICICIPremiumFrequency.setOnItemSelectedListener(optionSelected);*/
    }

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
}
