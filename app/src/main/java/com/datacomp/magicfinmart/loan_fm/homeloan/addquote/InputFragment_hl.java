package com.datacomp.magicfinmart.loan_fm.homeloan.addquote;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.homeloan.HomeLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.mainloan.MainLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CustomerApplicationEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CustomerEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.HomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmHomelLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmPersonalLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmSaveQuoteHomeLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment_hl extends BaseFragment implements View.OnClickListener, IResponseSubcriber, IResponseSubcriberFM, SeekBar.OnSeekBarChangeListener, TextWatcher {


    DBPersistanceController databaseController;   //DB declare
    LoginResponseEntity loginEntity;
    GetQuoteResponse getQuoteResponse;
    CustomerEntity customerEntity;
    CustomerApplicationEntity customerApplicationEntity;

    ScrollView scroll;
    TextView txtPropertyInfo, txtCoApplicantDetail, txtApplicantDetail;
    LinearLayout llPropertyInfo, llApplicantDetail, llCoApplicantDetail;
    Toolbar toolbar;
    HomeLoanRequest homeLoanRequest;
    FmHomeLoanRequest fmHomeLoanRequest;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    boolean isPropertyInfoVisible = false;
    boolean isApplicantVisible = true;
    boolean isCoApplicantVisible = true;

    Button btnGetQuote;
    // region Applicant Details
    EditText etNameOfApplicant, et_DOB, etMonthlyInc, etEMI, etTurnOver, etProfitAtTax, etDepreciation, etDirecPartRemuntion;
    Spinner sbSalary;
    ArrayAdapter<String> salaryTypeAdapter;
    LinearLayout llSalaried, llSelfEmployeed, lyParent_CoAppDetail;
    SeekBar sbMonthlyInc, sbTurnOver, sbProfitAfTax, sbDepreciation, sbDirecPartRemuntion;
    CheckBox chkCoApplicant;
    RadioGroup rgGender;
    RadioButton rbimgMale, rbimgFemale;
    String propTyp = "1";
    String CoApplicantSource = "1";
    String ApplicantSource = "1";
    //endregion

    //region PropertyIndo
    EditText etCostOfProp, txtMaxLoanAmntAllow;
    TextView txtDispalayMinCostProp, txtDispalayMaxCostProp, txtDispalayMinTenureYear, txtDispalayMaxTenureYear;
    TextView textCoApplicant, txtCoSalaried, txtCoSelfEMp, txtSalaried, txtSelfEMp;
    Spinner spNewLoan;
    ArrayList<String> arrayNewLoan, arrayPreferedCity;
    ArrayAdapter<String> newLoanAdapter;
    ArrayAdapter<String> preferedCityAdapter;
    SeekBar sbCostOfProp, sbTenure;

    TextView etTenureInYear;


    int seekBarTenureProgress = 1;
//    int seekBarCostPropProgress = 5;
//    int seekBarApplTurnOverProgress = 1;
//    int seekBarApplProfitProgress = 1;
//    int seekBarApplDepricProgress = 1;
//    int seekBarApplIncomeProgress = 25;

    //endregion

    //region Co-Applicant Details
    EditText coApp_etNameOfApplicant, coApp_et_DOB, coApp_etMonthlyInc, coApp_etEMI, coApp_etTurnOver, coApp_etProfitAtTax, coApp_etDepreciation, coApp_etDirecPartRemuntion;
    Spinner coApp_sbSalary, coApp_sbRelation;
    ArrayAdapter<String> coApp_salaryTypeAdapter, coApp_relationTypeAdapter;
    LinearLayout coApp_llSalaried, coApp_llSelfEmployeed;
    SeekBar coApp_sbMonthlyInc, coApp_sbTurnOver, coApp_sbProfitAfTax, coApp_sbDepreciation, coApp_sbDirecPartRemuntion;
    RadioGroup coApp_rgGender;
    RadioButton coApp_rbimgMale, coApp_rbimgFemale, rbReady, rbUnder, rbSearching, rbResale, rbForcons, rbOther;
    private RadioGroup rgProperty1;
    private RadioGroup rgProperty2;
    AutoCompleteTextView acCity;
    boolean isCitySelected;
    DBPersistanceController mReal;
    List<String> cityList;
    //endregion
    Context mContext;

    public InputFragment_hl() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_home_loan, container, false);
        mReal = new DBPersistanceController(getActivity());

        databaseController = new DBPersistanceController(getActivity());
        loginEntity = databaseController.getUserData();
        cityList = databaseController.getHealthCity();

        homeLoanRequest = new HomeLoanRequest();
        init_widgets(view);

        setListener();

//        visibleApplicant(View.GONE);
//        visibleCoApplicant(View.GONE);
//        visiblePropertyInfo(View.GONE);
//        txtCoApplicantDetail.setVisibility(View.GONE);


        loadSpinner();
        setSalaried();
        setCoAppSalaried();
        if (getActivity().getIntent().getBooleanExtra("IS_EDIT", false)) {

            customerEntity = getActivity().getIntent().getParcelableExtra("CUST_DETAILS");
            fillCustomerDetails(customerEntity);
            isCitySelected = true;
            visiblePropertyInfo(View.VISIBLE);
        }
        if (getActivity().getIntent().getBooleanExtra("IS_APP_EDIT", false)) {

            customerApplicationEntity = getActivity().getIntent().getParcelableExtra("CUST_APP_DETAILS");
            fillCustomerApplicationDetails(customerApplicationEntity);
            isCitySelected = true;
            visiblePropertyInfo(View.VISIBLE);
        }
        if (getArguments() != null) {
            if (getArguments().getParcelable(HLMainActivity.HL_INPUT_REQUEST) != null) {
                homeLoanRequest = getArguments().getParcelable(HLMainActivity.HL_INPUT_REQUEST);
                bindInputsQuotes();//bind value
            }
        }

        return view;
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        realm.close();
//    }


    private void fillCustomerDetails(CustomerEntity customerEntity) {
        Log.d("DETAILS", customerEntity.toString());

        if (customerEntity.getPropertyID() != null)
            spNewLoan.setSelection(newLoanAdapter.getPosition(customerEntity.getPropertyID()));
        if (customerEntity.getLoanRequired() != null)
            etCostOfProp.setText(customerEntity.getLoanRequired());
        if (customerEntity.getLoanTenure() != null)
            etTenureInYear.setText(customerEntity.getLoanTenure());
        if (customerEntity.getCity() != null)
            acCity.setText(customerEntity.getCity());

        if (customerEntity.getApplicantNme() != null)
            etNameOfApplicant.setText(customerEntity.getApplicantNme());

        if (customerEntity.getApplicantGender().matches("male")) {
            rbimgMale.setSelected(true);
        } else {
            rbimgFemale.setSelected(true);
        }
        if (customerEntity.getApplicantDOB() != null)
            et_DOB.setText(customerEntity.getApplicantDOB());

        if (customerEntity.getApplicantSource() != null) {
            sbSalary.setSelection(Integer.parseInt(customerEntity.getApplicantSource()) - 1);
        }
        if (customerEntity.getApplicantIncome() != null)
            etMonthlyInc.setText(customerEntity.getApplicantIncome());

        if (customerEntity.getApplicantObligations() != null)
            etEMI.setText(customerEntity.getApplicantObligations());

        if (customerEntity.getTurnover() != null)
            etTurnOver.setText(customerEntity.getTurnover());

        if (customerEntity.getProfitAfterTax() != null)
            etProfitAtTax.setText(customerEntity.getProfitAfterTax());

        if (customerEntity.getDepreciation() != null)
            etDepreciation.setText(customerEntity.getDepreciation());

        if (customerEntity.getDirectorRemuneration() != null)
            etDirecPartRemuntion.setText(customerEntity.getDirectorRemuneration());

        if (customerEntity.getCoApplicantYes() != null) {
            if (customerEntity.getCoApplicantYes().matches("Y")) {

                if (customerEntity.getCoApplicantDOB() != null)
                    coApp_et_DOB.setText(customerEntity.getCoApplicantDOB());

                if (customerEntity.getCoApplicantSource() != null)
                    coApp_sbSalary.setSelection(Integer.parseInt(customerEntity.getCoApplicantSource()) - 1);

                if (customerEntity.getCoApplicantObligations() != null)
                    coApp_etEMI.setText(customerEntity.getCoApplicantObligations());

                if (customerEntity.getCoApplicantTurnover() != null)
                    coApp_etTurnOver.setText(customerEntity.getCoApplicantTurnover());

                if (customerEntity.getCoApplicantProfitAfterTax() != null)
                    coApp_etProfitAtTax.setText(customerEntity.getCoApplicantProfitAfterTax());

                if (customerEntity.getCoApplicantDepreciation() != null)
                    coApp_etDepreciation.setText(customerEntity.getCoApplicantDepreciation());

                if (customerEntity.getCoApplicantDirectorRemuneration() != null)
                    coApp_etDirecPartRemuntion.setText(customerEntity.getCoApplicantDirectorRemuneration());

            }
        }


    }

    private void fillCustomerApplicationDetails(CustomerApplicationEntity customerEntity) {
        Log.d("DETAILS", customerApplicationEntity.toString());

        /*if (customerEntity.getPropertyID() != null)
            spNewLoan.setSelection(newLoanAdapter.getPosition(customerEntity.getPropertyID()));*/
        if (customerEntity.getLoanRequired() != null)
            etCostOfProp.setText(customerEntity.getLoanRequired());
        if (customerEntity.getLoanTenure() != null)
            etTenureInYear.setText(customerEntity.getLoanTenure());
        if (customerEntity.getCity() != null)
            acCity.setText(customerEntity.getCity());

        if (customerEntity.getApplicantNme() != null)
            etNameOfApplicant.setText(customerEntity.getApplicantNme());

        if (customerEntity.getApplicantGender().matches("male")) {
            rbimgMale.setSelected(true);
        } else {
            rbimgFemale.setSelected(true);
        }
        if (customerEntity.getApplicantDOB() != null)
            et_DOB.setText(customerEntity.getApplicantDOB());

       /* if (customerEntity.getApplicantSource() != null) {
            sbSalary.setSelection(Integer.parseInt(customerEntity.getApplicantSource()) - 1);
        }*/
        if (customerEntity.getApplicantIncome() != null)
            etMonthlyInc.setText(customerEntity.getApplicantIncome());

        if (customerEntity.getApplicantObligations() != null)
            etEMI.setText(customerEntity.getApplicantObligations());

        if (customerEntity.getTurnover() != null)
            etTurnOver.setText(customerEntity.getTurnover());

        if (customerEntity.getProfitAfterTax() != null)
            etProfitAtTax.setText(customerEntity.getProfitAfterTax());

        if (customerEntity.getDepreciation() != null)
            etDepreciation.setText(customerEntity.getDepreciation());

        if (customerEntity.getDirectorRemuneration() != null)
            etDirecPartRemuntion.setText(customerEntity.getDirectorRemuneration());

        if (customerEntity.getCoApplicantYes() != null) {
            if (customerEntity.getCoApplicantYes().matches("Y")) {
                chkCoApplicant.setSelected(true);
            }
        }
        if (customerEntity.getCoApplicantDOB() != null)
            coApp_et_DOB.setText(customerEntity.getCoApplicantDOB());

        if (customerEntity.getCoApplicantSource() != null)
            coApp_sbSalary.setSelection(Integer.parseInt(customerEntity.getCoApplicantSource()) - 1);

        if (customerEntity.getCoApplicantObligations() != null)
            coApp_etEMI.setText(customerEntity.getCoApplicantObligations());

        if (customerEntity.getCoApplicantTurnover() != null)
            coApp_etTurnOver.setText(customerEntity.getCoApplicantTurnover());

        if (customerEntity.getCoApplicantProfitAfterTax() != null)
            coApp_etProfitAtTax.setText(customerEntity.getCoApplicantProfitAfterTax());

        if (customerEntity.getCoApplicantDepreciation() != null)
            coApp_etDepreciation.setText(customerEntity.getCoApplicantDepreciation());

        if (customerEntity.getCoApplicantDirectorRemuneration() != null)
            coApp_etDirecPartRemuntion.setText(customerEntity.getCoApplicantDirectorRemuneration());
    }

    private void init_widgets(View view) {

        //region Main Initialize
        scroll = (ScrollView) view.findViewById(R.id.scroll);
        txtPropertyInfo = (TextView) view.findViewById(R.id.txtPropertyInfo);
        txtCoApplicantDetail = (TextView) view.findViewById(R.id.txtCoApplicantDetail);
        txtApplicantDetail = (TextView) view.findViewById(R.id.txtApplicantDetail);
        llPropertyInfo = (LinearLayout) view.findViewById(R.id.llPropertyInfo);
        llApplicantDetail = (LinearLayout) view.findViewById(R.id.llApplicantDetail);
        llCoApplicantDetail = (LinearLayout) view.findViewById(R.id.llCoApplicantDetail);
        btnGetQuote = (Button) view.findViewById(R.id.btnGetQuote);

        rgProperty1 = (RadioGroup) view.findViewById(R.id.rgProperty1);
        rgProperty2 = (RadioGroup) view.findViewById(R.id.rgProperty2);

        RadioButton rbReady = (RadioButton) rgProperty1.findViewById(R.id.rbReady);
        RadioButton rbUnder = (RadioButton) rgProperty1.findViewById(R.id.rbUnder);
        RadioButton rbSearching = (RadioButton) rgProperty1.findViewById(R.id.rbSearching);

        RadioButton rbResale = (RadioButton) rgProperty2.findViewById(R.id.rbResale);
        RadioButton rbForcons = (RadioButton) rgProperty2.findViewById(R.id.rbForcons);
        RadioButton rbOther = (RadioButton) rgProperty2.findViewById(R.id.rbOther);

        rgProperty1.clearCheck(); // this is so we can start fresh, with no selection on both RadioGroups
        rgProperty1.clearCheck();
        rbReady.setChecked(true);
        rgProperty2.setOnCheckedChangeListener(rgProp1Listener);
        rgProperty2.setOnCheckedChangeListener(rgProp2Listener);


        //endregion

        //region Property Initialize

        spNewLoan = (Spinner) view.findViewById(R.id.spNewLoan);
        etCostOfProp = (EditText) view.findViewById(R.id.etCostOfProp);


        txtMaxLoanAmntAllow = (EditText) view.findViewById(R.id.txtMaxLoanAmntAllow);
        txtDispalayMinCostProp = (TextView) view.findViewById(R.id.txtDispalayMinCostProp);
        txtDispalayMaxCostProp = (TextView) view.findViewById(R.id.txtDispalayMaxCostProp);
        txtDispalayMinTenureYear = (TextView) view.findViewById(R.id.txtDispalayMinTenureYear);
        txtDispalayMaxTenureYear = (TextView) view.findViewById(R.id.txtDispalayMaxTenureYear);
        etTenureInYear = (TextView) view.findViewById(R.id.etTenureInYear);
        sbCostOfProp = (SeekBar) view.findViewById(R.id.sbCostOfProp);
        sbTenure = (SeekBar) view.findViewById(R.id.sbTenure);

//        sbCostOfProp.setMax(5000);    // 50 cr
//        sbCostOfProp.setProgress(5);  // 5 lac
//        etCostOfProp.setText("500000");
        //txtMaxLoanAmntAllow.setText(String.format("%.2f", getPercent(500000)));
        sbTenure.setMax(30);

        sbTenure.setProgress(5);
        etTenureInYear.setText("5");
        acCity = (AutoCompleteTextView) view.findViewById(R.id.acCity);

        //endregion

        //region Applicant Initialize
        llSelfEmployeed = (LinearLayout) view.findViewById(R.id.llSelfEmployeed);
        llSalaried = (LinearLayout) view.findViewById(R.id.llSalaried);
        lyParent_CoAppDetail = (LinearLayout) view.findViewById(R.id.lyParent_CoAppDetail);
        etNameOfApplicant = (EditText) view.findViewById(R.id.etNameOfApplicant);
        etTurnOver = (EditText) view.findViewById(R.id.etTurnOver);
        etProfitAtTax = (EditText) view.findViewById(R.id.etProfitAtTax);
        etDepreciation = (EditText) view.findViewById(R.id.etDepreciation);
        etDirecPartRemuntion = (EditText) view.findViewById(R.id.etDirecPartRemuntion);
        et_DOB = (EditText) view.findViewById(R.id.et_DOB);
        sbSalary = (Spinner) view.findViewById(R.id.sbSalary);
        sbMonthlyInc = (SeekBar) view.findViewById(R.id.sbMonthlyInc);
        sbTurnOver = (SeekBar) view.findViewById(R.id.sbTurnOver);
        sbProfitAfTax = (SeekBar) view.findViewById(R.id.sbProfitAfTax);
        sbDepreciation = (SeekBar) view.findViewById(R.id.sbDepreciation);
        sbDirecPartRemuntion = (SeekBar) view.findViewById(R.id.sbDirecPartRemuntion);
        etMonthlyInc = (EditText) view.findViewById(R.id.etMonthlyInc);
        etEMI = (EditText) view.findViewById(R.id.etEMI);
        chkCoApplicant = (CheckBox) view.findViewById(R.id.chkCoApplicant);
        rgGender = (RadioGroup) view.findViewById(R.id.rgGender);
        rbimgMale = (RadioButton) view.findViewById(R.id.rbimgMale);
        rbimgFemale = (RadioButton) view.findViewById(R.id.rbimgFemale);

//        sbTurnOver.setMax(1000);    // 100 cr
//        sbTurnOver.setProgress(10);  // 10 lac
//        etTurnOver.setText("1000000");
//
//        sbProfitAfTax.setMax(100);
//        sbProfitAfTax.setProgress(10);
//        etProfitAtTax.setText("1000000");
//
//        sbDepreciation.setMax(100);
//        sbDepreciation.setProgress(1);
//        etDepreciation.setText("100000");
//
//        sbMonthlyInc.setMax(2500);    //2500
//        sbMonthlyInc.setProgress(1);
//        etMonthlyInc.setText("25000");
//
//
//        sbDirecPartRemuntion.setMax(100);
//        sbDirecPartRemuntion.setProgress(1);
//        etDirecPartRemuntion.setText("100000");


        //endregion

        //region Co-Applicant Initialize
        coApp_llSelfEmployeed = (LinearLayout) view.findViewById(R.id.coApp_llSelfEmployeed);
        coApp_llSalaried = (LinearLayout) view.findViewById(R.id.coApp_llSalaried);

        txtSalaried = (TextView) view.findViewById(R.id.txtSalaried);
        txtSelfEMp = (TextView) view.findViewById(R.id.txtSelfEMp);

        textCoApplicant = (TextView) view.findViewById(R.id.textCoApplicant);
        txtCoSalaried = (TextView) view.findViewById(R.id.txtCoSalaried);
        txtCoSelfEMp = (TextView) view.findViewById(R.id.txtCoSelfEMp);

        coApp_etNameOfApplicant = (EditText) view.findViewById(R.id.coApp_etNameOfApplicant);
        coApp_etTurnOver = (EditText) view.findViewById(R.id.coApp_etTurnOver);
        coApp_etProfitAtTax = (EditText) view.findViewById(R.id.coApp_etProfitAtTax);
        coApp_etDepreciation = (EditText) view.findViewById(R.id.coApp_etDepreciation);
        coApp_etDirecPartRemuntion = (EditText) view.findViewById(R.id.coApp_etDirecPartRemuntion);
        coApp_et_DOB = (EditText) view.findViewById(R.id.coApp_et_DOB);
        coApp_sbSalary = (Spinner) view.findViewById(R.id.coApp_sbSalary);
        coApp_sbRelation = (Spinner) view.findViewById(R.id.coApp_sbRelation);
        coApp_sbMonthlyInc = (SeekBar) view.findViewById(R.id.coApp_sbMonthlyInc);
        coApp_sbTurnOver = (SeekBar) view.findViewById(R.id.coApp_sbTurnOver);
        coApp_sbProfitAfTax = (SeekBar) view.findViewById(R.id.coApp_sbProfitAfTax);
        coApp_sbDepreciation = (SeekBar) view.findViewById(R.id.coApp_sbDepreciation);
        coApp_sbDirecPartRemuntion = (SeekBar) view.findViewById(R.id.coApp_sbDirecPartRemuntion);
        coApp_etMonthlyInc = (EditText) view.findViewById(R.id.coApp_etMonthlyInc);
        coApp_etEMI = (EditText) view.findViewById(R.id.coApp_etEMI);
        coApp_rgGender = (RadioGroup) view.findViewById(R.id.coApp_rgGender);
        coApp_rbimgMale = (RadioButton) view.findViewById(R.id.coApp_rbimgMale);
        coApp_rbimgFemale = (RadioButton) view.findViewById(R.id.coApp_rbimgFemale);


        //co-appdetail
//        coApp_sbMonthlyInc.setMax(2500);
//        coApp_sbMonthlyInc.setProgress(1);
//        coApp_etMonthlyInc.setText("2500");
//
//        coApp_sbTurnOver.setMax(1000);    // 100 cr
//        coApp_sbTurnOver.setProgress(10);  // 10 lac
//        coApp_etTurnOver.setText("1000000");
//
//        coApp_sbProfitAfTax.setMax(100);
//        coApp_sbProfitAfTax.setProgress(10);
//        coApp_etProfitAtTax.setText("1000000");
//
//        coApp_sbDepreciation.setMax(100);
//        coApp_sbDepreciation.setProgress(1);
//        coApp_etDepreciation.setText("100000");
//
//        coApp_sbDirecPartRemuntion.setMax(100);
//        coApp_sbDirecPartRemuntion.setProgress(1);
//        coApp_etDirecPartRemuntion.setText("100000");


        //endregion

    }

    private void bindInputsQuotes() {

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

    //region datePickerDialog CoApplicant
    protected View.OnClickListener datePickerDialogCoApplicant = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Constants.hideKeyBoard(view, getActivity());
            DateTimePicker.showDataPickerDialogBeforeTwentyOne(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(year, monthOfYear, dayOfMonth);
                    String currentDay = simpleDateFormat.format(calendar.getTime());
                    coApp_et_DOB.setText(currentDay);
                    //etDate.setTag(R.id.et_date, calendar.getTime());
                }
            });
        }
    };
    //endregion

    private void setListener() {
        // region auto complete city listener
        acCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                isCitySelected = true;
            }
        });
        acCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isCitySelected = false;
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        // endregion
        sbTenure.setOnSeekBarChangeListener(this);

//        sbCostOfProp.setOnSeekBarChangeListener(this);
//        sbTurnOver.setOnSeekBarChangeListener(this);
//        sbProfitAfTax.setOnSeekBarChangeListener(this);
//        sbDepreciation.setOnSeekBarChangeListener(this);
//        sbMonthlyInc.setOnSeekBarChangeListener(this);
//        sbDirecPartRemuntion.setOnSeekBarChangeListener(this);
//
//        coApp_sbMonthlyInc.setOnSeekBarChangeListener(this);
//        coApp_sbTurnOver.setOnSeekBarChangeListener(this);
//        coApp_sbProfitAfTax.setOnSeekBarChangeListener(this);
//        coApp_sbDepreciation.setOnSeekBarChangeListener(this);
//        coApp_sbDirecPartRemuntion.setOnSeekBarChangeListener(this);


//        txtPropertyInfo.setOnClickListener(this);
//        txtApplicantDetail.setOnClickListener(this);
//        txtCoApplicantDetail.setOnClickListener(this);

        txtSalaried.setOnClickListener(this);
        txtSelfEMp.setOnClickListener(this);
        txtCoSalaried.setOnClickListener(this);
        txtCoSelfEMp.setOnClickListener(this);


        btnGetQuote.setOnClickListener(this);
        et_DOB.setOnClickListener(datePickerDialogApplicant);
        coApp_et_DOB.setOnClickListener(datePickerDialogCoApplicant);

        //region CheckBox  Co-Applicant  Listener

        chkCoApplicant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    lyParent_CoAppDetail.setVisibility(View.VISIBLE);
                    textCoApplicant.setBackgroundResource(R.color.button_color);

                    //  coApp_etEMI.requestFocus();
                    Constants.hideKeyBoard(buttonView, getActivity());


                    scroll.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            scroll.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    }, 1000);

                } else {

                    lyParent_CoAppDetail.setVisibility(View.GONE);
                    textCoApplicant.setBackgroundResource(R.color.secondary_text_color);

                }
            }
        });

        etCostOfProp.addTextChangedListener(this);
//        etTenureInYear.addTextChangedListener(this);
//        etMonthlyInc.addTextChangedListener(this);
//        etTurnOver.addTextChangedListener(this);
//        etProfitAtTax.addTextChangedListener(this);
//        etDepreciation.addTextChangedListener(this);
//        etDirecPartRemuntion.addTextChangedListener(this);
//        coApp_etMonthlyInc.addTextChangedListener(this);
//        coApp_etTurnOver.addTextChangedListener(this);
//        coApp_etProfitAtTax.addTextChangedListener(this);
//        coApp_etDepreciation.addTextChangedListener(this);
//        coApp_etDirecPartRemuntion.addTextChangedListener(this);


    }


    private void visiblePropertyInfo(int visibility) {
        if (visibility == View.VISIBLE) {
            isPropertyInfoVisible = true;
        } else {
            isPropertyInfoVisible = false;
        }
        if (visibility == View.GONE) {
            txtPropertyInfo.setText(" Property Information");
            txtPropertyInfo.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_arrow_bas_screen, 0);
            txtPropertyInfo.setBackgroundResource(R.color.lightGrey);//umesh
            llPropertyInfo.setVisibility(visibility);
            //isPropertyInfoVisible = false;
        } else {
            txtPropertyInfo.setText(" Property Information");
            txtPropertyInfo.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_arrow_bas_screen, 0);
            txtPropertyInfo.setBackgroundResource(R.color.lightGrey);//umesh
            llPropertyInfo.setVisibility(visibility);
            //isPropertyInfoVisible = true;
        }
    }

    private void visibleApplicant(int visibility) {
        if (visibility == View.VISIBLE) {
            isApplicantVisible = true;
        } else {
            isApplicantVisible = false;
        }
        if (visibility == View.GONE) {
            txtApplicantDetail.setText(" Application Details");
            txtApplicantDetail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_arrow_bas_screen, 0);
            txtApplicantDetail.setBackgroundResource(R.color.lightGrey);//umesh
            llApplicantDetail.setVisibility(visibility);
            //isApplicantVisible = false;
        } else {
            txtApplicantDetail.setText(" Application Details");
            txtApplicantDetail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_arrow_bas_screen, 0);
            txtPropertyInfo.setBackgroundResource(R.color.lightGrey);//umesh
            llApplicantDetail.setVisibility(visibility);
            //isApplicantVisible = true;
        }
    }

    private void visibleCoApplicant(int visibility) {
        if (visibility == View.VISIBLE) {
            isCoApplicantVisible = true;
        } else {
            isCoApplicantVisible = false;
        }
        if (visibility == View.GONE) {
            txtCoApplicantDetail.setText(" Co-Application Details");
            txtCoApplicantDetail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_arrow_bas_screen, 0);
            txtCoApplicantDetail.setBackgroundResource(R.color.lightGrey);//umesh
            llCoApplicantDetail.setVisibility(visibility);
            //isCoApplicantVisible = false;
        } else {
            txtCoApplicantDetail.setText(" Co-Application Details");
            txtCoApplicantDetail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_arrow_bas_screen, 0);
            txtPropertyInfo.setBackgroundResource(R.color.lightGrey);//umesh
            llCoApplicantDetail.setVisibility(visibility);
            //isCoApplicantVisible = true;
        }
    }

    private void altervisiblePropertyInfo() {
        if (isPropertyInfoVisible) {
            txtPropertyInfo.setText(" Property Information");
            txtPropertyInfo.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_arrow_bas_screen, 0);
            txtPropertyInfo.setBackgroundResource(R.color.lightGrey);//umesh
            llPropertyInfo.setVisibility(View.GONE);
            isPropertyInfoVisible = false;
        } else {
            txtPropertyInfo.setText(" Property Information");
            txtPropertyInfo.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_arrow_bas_screen, 0);
            txtPropertyInfo.setBackgroundResource(R.color.lightGrey);//umesh
            llPropertyInfo.setVisibility(View.VISIBLE);
            isPropertyInfoVisible = true;
        }
    }

    private void altervisibleApplicant() {
        if (isApplicantVisible) {
            txtApplicantDetail.setText(" Application Details");
            txtApplicantDetail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_arrow_bas_screen, 0);
            txtApplicantDetail.setBackgroundResource(R.color.lightGrey);//umesh
            llApplicantDetail.setVisibility(View.GONE);
            isApplicantVisible = false;
        } else {
            txtApplicantDetail.setText(" Application Details");
            txtApplicantDetail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.right_arrow_bas_screen, 0);
            txtPropertyInfo.setBackgroundResource(R.color.lightGrey);//umesh
            llApplicantDetail.setVisibility(View.VISIBLE);
            isApplicantVisible = true;
        }
    }

    private void setSalaried() {
        ApplicantSource = "1";
        txtSalaried.setBackgroundResource(R.drawable.customeborder_blue);
        txtSalaried.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

        txtSelfEMp.setBackgroundResource(R.drawable.customeborder);
        txtSelfEMp.setTextColor(ContextCompat.getColor(getActivity(), R.color.description_text));

        llSelfEmployeed.setVisibility(View.GONE);
    }

    private void setSelfEmplyoee() {
        ApplicantSource = "2";
        txtSelfEMp.setBackgroundResource(R.drawable.customeborder_blue);
        txtSelfEMp.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

        txtSalaried.setBackgroundResource(R.drawable.customeborder);
        txtSalaried.setTextColor(ContextCompat.getColor(getActivity(), R.color.description_text));

        llSelfEmployeed.setVisibility(View.VISIBLE);

    }


    private void setCoAppSalaried() {
        CoApplicantSource = "1";
        txtCoSalaried.setBackgroundResource(R.drawable.customeborder_blue);
        txtCoSalaried.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

        txtCoSelfEMp.setBackgroundResource(R.drawable.customeborder);
        txtCoSelfEMp.setTextColor(ContextCompat.getColor(getActivity(), R.color.description_text));

        coApp_llSelfEmployeed.setVisibility(View.GONE);

    }

    private void setCoAppSelfEmplyoee() {
        CoApplicantSource = "2";
        txtCoSelfEMp.setBackgroundResource(R.drawable.customeborder_blue);
        txtCoSelfEMp.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

        txtCoSalaried.setBackgroundResource(R.drawable.customeborder);
        txtCoSalaried.setTextColor(ContextCompat.getColor(getActivity(), R.color.description_text));

        coApp_llSelfEmployeed.setVisibility(View.VISIBLE);
    }


    @Override
    public void onClick(View v) {

//        if (v.getId() == R.id.txtPropertyInfo) {
//            visibleApplicant(View.GONE);
//            visibleCoApplicant(View.GONE);
//            altervisiblePropertyInfo();
//
//            // setPropertyDetails();
//
//        } else if (v.getId() == R.id.txtApplicantDetail) {
//            visiblePropertyInfo(View.GONE);
//            visibleCoApplicant(View.GONE);
//            altervisibleApplicant();
//        } else if (v.getId() == R.id.txtCoApplicantDetail) {
//            visiblePropertyInfo(View.GONE);
//            visibleApplicant(View.GONE);
//            altervisibleCoApplicant();
//        }
        if (v.getId() == R.id.txtSalaried) {

            setSalaried();


        } else if (v.getId() == R.id.txtSelfEMp) {

            setSelfEmplyoee();
        }
        /////////////// Co- Applicant//////////////////
        else if (v.getId() == R.id.txtCoSalaried) {

            setCoAppSalaried();

        } else if (v.getId() == R.id.txtCoSelfEMp) {

            setCoAppSelfEmplyoee();

        } else if (v.getId() == R.id.btnGetQuote) {
            //region Validation

            //region Property Validation
            String CostOfProp = etCostOfProp.getText().toString();
            String TenureInYear = etTenureInYear.getText().toString();

            if (!isCitySelected) {
                acCity.setError("Please Enter city.");
                acCity.requestFocus();
                return;
            }
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
            String ProfitAtTax = etProfitAtTax.getText().toString();
            String Depreciation = etDepreciation.getText().toString();
            String DirecPartRemuntion = etDirecPartRemuntion.getText().toString();


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

                if (TextUtils.isEmpty(ProfitAtTax)) {

                    etProfitAtTax.setError("Please Enter Profit After Tax.");
                    etProfitAtTax.requestFocus();
                    return;

                }

                if (TextUtils.isEmpty(Depreciation)) {

                    etDepreciation.setError("Please Enter Depreciation.");
                    etDepreciation.requestFocus();
                    return;

                }

                if (TextUtils.isEmpty(DirecPartRemuntion)) {

                    etDirecPartRemuntion.setError("Please Enter Director/Partner Remuneration.");
                    etDirecPartRemuntion.requestFocus();
                    return;

                }

                // End Applicant


            }


            //endregion

            //region Co-Applicant Validation

            if (chkCoApplicant.isChecked()) {
                String coAppNameOfApplicant = coApp_etNameOfApplicant.getText().toString();
                String coAppDOB = coApp_et_DOB.getText().toString();
                String coAppMonthlyInc = coApp_etMonthlyInc.getText().toString();
                String coAppTurnOver = coApp_etTurnOver.getText().toString();
                String coAppProfitAtTax = coApp_etProfitAtTax.getText().toString();
                String coAppDepreciation = coApp_etDepreciation.getText().toString();
                String coAppDirecPartRemuntion = coApp_etDirecPartRemuntion.getText().toString();

                if (TextUtils.isEmpty(coAppNameOfApplicant)) {

                    coApp_etNameOfApplicant.setError("Enter Name Of Co-Applicant.");
                    coApp_etNameOfApplicant.requestFocus();
                    return;

                }
                if (TextUtils.isEmpty(coAppDOB)) {

                    coApp_et_DOB.setError("Enter DOB.");
                    coApp_et_DOB.requestFocus();
                    return;

                }

                if (coApp_sbSalary.getSelectedItem().equals("Salaried")) {
                    if (TextUtils.isEmpty(coAppMonthlyInc)) {

                        coApp_etMonthlyInc.setError("Enter Monthly Income.");
                        coApp_etMonthlyInc.requestFocus();
                        return;

                    }
                } else {
                    if (TextUtils.isEmpty(coAppTurnOver)) {

                        coApp_etTurnOver.setError("Enter Turnover.");
                        coApp_etTurnOver.requestFocus();
                        return;

                    }

                    if (TextUtils.isEmpty(coAppProfitAtTax)) {

                        coApp_etProfitAtTax.setError("Enter Profit After Tax.");
                        coApp_etProfitAtTax.requestFocus();
                        return;

                    }

                    if (TextUtils.isEmpty(coAppDepreciation)) {

                        coApp_etDepreciation.setError("Enter Depreciation.");
                        coApp_etDepreciation.requestFocus();
                        return;

                    }

                    if (TextUtils.isEmpty(coAppDirecPartRemuntion)) {

                        coApp_etDirecPartRemuntion.setError("Enter Director/Partner Remuneration.");
                        coApp_etDirecPartRemuntion.requestFocus();
                        return;

                    }
                }
                // End Co-Applicant
            }

            //endregion

            // endregion
            setApplicantDetails();
//            showDialog();
//            new HomeLoanController(getActivity()).getHomeLoan(homeLoanRequest, this);

            ((HLMainActivity) getActivity()).getQuoteParameterBundle(homeLoanRequest);

        }


    }

    private void loadSpinner() {

        //region Applicant Income Source Adapter

        salaryTypeAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.IncomeSource));
        salaryTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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

        //region Relation Type Adapter
        coApp_relationTypeAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.RelationType));
        coApp_relationTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coApp_sbRelation.setAdapter(coApp_relationTypeAdapter);
        //endregion

        //region Co-Applicant Income Source Adapter
        coApp_salaryTypeAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.IncomeSource));
        coApp_salaryTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coApp_sbSalary.setAdapter(coApp_salaryTypeAdapter);
        coApp_sbSalary.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Salaried")) {
                    // do your stuff
                    coApp_llSalaried.setVisibility(View.VISIBLE);
                    coApp_llSelfEmployeed.setVisibility(View.GONE);
                } else if (selectedItem.equals("Self-Employed")) {
                    coApp_llSalaried.setVisibility(View.GONE);
                    coApp_llSelfEmployeed.setVisibility(View.VISIBLE);
                }
            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region Loan Type Adapter
        arrayNewLoan = new ArrayList<String>();
        newLoanAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, getNewLoanList());
        newLoanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNewLoan.setAdapter(newLoanAdapter);
        //endregion

        //region Preferred City Adapter
        arrayPreferedCity = new ArrayList<String>();
        preferedCityAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, cityList);

//        preferedCityAdapter = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1, getCityList());

        acCity.setAdapter(preferedCityAdapter);
        acCity.setThreshold(1);
        //endregion

    }

    // delete below method ... Not in Used
    private ArrayList<String> getNewLoanList() {
        List<PropertyInfoEntity> listLoan = mReal.getLoanPropertyInfoList();
        if (listLoan != null) {
            for (int i = 0; i <= listLoan.size() - 1; i++) {
                arrayNewLoan.add(listLoan.get(i).getProperty_Type());
            }
        }

        return arrayNewLoan;
    }


    private ArrayList<String> getCityList() {
//        if (new loCityFacade(getActivity()).getCityList() != null) {
//            for (CityEntity entity : new CityFacade(getActivity()).getCityList()) {
//                arrayPreferedCity.add(entity.getCity_Name());
//            }
//        }
        //  arrayPreferedCity.add("Mumbai");
        return arrayPreferedCity;
    }

    private void setApplicantDetails() {
        // region  HomeLoanRequest Binding

        homeLoanRequest = new HomeLoanRequest();

        //  homeLoanRequest.setPropertyID("" + new PropertyFacade(getActivity()).getPropertyId(spNewLoan.getSelectedItem().toString()));

        homeLoanRequest.setPropertyID("" + propTyp);
        homeLoanRequest.setPropertyCost(etCostOfProp.getText().toString());
        homeLoanRequest.setLoanTenure(etTenureInYear.getText().toString());
        homeLoanRequest.setLoanRequired(txtMaxLoanAmntAllow.getText().toString());
        homeLoanRequest.setCity("" + acCity.getText().toString());
        homeLoanRequest.setApplicantNme(etNameOfApplicant.getText().toString());
        if (rbimgFemale.isChecked()) {
            homeLoanRequest.setApplicantGender("F");
        } else if (rbimgMale.isChecked()) {
            homeLoanRequest.setApplicantGender("M");
        }

//        if (sbSalary.getSelectedItem().toString().contains("Salaried")) {
//
//            homeLoanRequest.setApplicantSource("1");
//        } else if (sbSalary.getSelectedItem().toString().contains("Self-Employed")) {
//            homeLoanRequest.setApplicantSource("2");
//        }
        homeLoanRequest.setApplicantSource(ApplicantSource);

        if (homeLoanRequest.getApplicantSource() == "1") {
            homeLoanRequest.setApplicantIncome(etMonthlyInc.getText().toString());
        } else if (homeLoanRequest.getApplicantSource() == "2") {
            homeLoanRequest.setTurnover(etTurnOver.getText().toString());
            homeLoanRequest.setProfitAfterTax(etProfitAtTax.getText().toString());
            homeLoanRequest.setDepreciation(etDepreciation.getText().toString());
            homeLoanRequest.setDirectorRemuneration(etDirecPartRemuntion.getText().toString());
        }

        homeLoanRequest.setApplicantObligations(etEMI.getText().toString());
        homeLoanRequest.setApplicantDOB(et_DOB.getText().toString());
        if (chkCoApplicant.isChecked()) {
            homeLoanRequest.setCoApplicantYes("Y");
            if (coApp_rbimgFemale.isChecked()) {
                homeLoanRequest.setCoApplicantGender("F");
            } else if (coApp_rbimgMale.isChecked()) {
                homeLoanRequest.setCoApplicantGender("M");
            }

            homeLoanRequest.setCoApplicantSource(CoApplicantSource);
//            if (coApp_sbSalary.getSelectedItem().toString().contains("Salaried")) {
//                homeLoanRequest.setCoApplicantSource("1");
//            } else if (sbSalary.getSelectedItem().toString().contains("Self-Employed")) {
//                homeLoanRequest.setCoApplicantSource("2");
//            }
            if (homeLoanRequest.getCoApplicantSource() == "1") {
                homeLoanRequest.setCoApplicantIncome(coApp_etMonthlyInc.getText().toString());
            } else if (homeLoanRequest.getCoApplicantSource() == "2") {
                homeLoanRequest.setCoApplicantTurnover(coApp_etTurnOver.getText().toString());
                homeLoanRequest.setCoApplicantProfitAfterTax(coApp_etProfitAtTax.getText().toString());
                homeLoanRequest.setCoApplicantDepreciation(coApp_etDepreciation.getText().toString());
                homeLoanRequest.setCoApplicantDirectorRemuneration(coApp_etDirecPartRemuntion.getText().toString());
            }
            homeLoanRequest.setCoApplicantObligations(coApp_etEMI.getText().toString());
            homeLoanRequest.setCoApplicantDOB(coApp_et_DOB.getText().toString());


        } else {
            homeLoanRequest.setCoApplicantYes("N");
        }

        homeLoanRequest.setBrokerId("" + loginEntity.getLoanId());
        homeLoanRequest.setEmpcode("");
        homeLoanRequest.setProductId("12");//HomeLoan
        homeLoanRequest.setApi_source("Finmart");
        // Below two For Node JS Maintainance
        homeLoanRequest.setType("HML");
        //   homeLoanRequest.setLoaniD(Integer.valueOf(loginEntity.getLoanId()));


        //endregion
    }


    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof GetQuoteResponse) {
            if (response.getStatus_Id() == 0) {

                getQuoteResponse = ((GetQuoteResponse) response);

                setFmHomeLoanRequest(getQuoteResponse.getQuote_id());

            } else {
                Toast.makeText(getActivity(), response.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void setFmHomeLoanRequest(int QuoteID) {

        showDialog();
        fmHomeLoanRequest = new FmHomeLoanRequest();
        fmHomeLoanRequest.setLoan_requestID(fmHomeLoanRequest.getLoan_requestID());
        fmHomeLoanRequest.setFba_id(loginEntity.getFBAId());
        homeLoanRequest.setQuote_id(QuoteID);
        fmHomeLoanRequest.setHomeLoanRequest(homeLoanRequest);
        new MainLoanController(getActivity()).saveHLQuoteData(fmHomeLoanRequest, this);

    }


    @Override
    public void OnSuccessFM(APIResponseFM response, String message) {

        cancelDialog();
        if (response instanceof FmSaveQuoteHomeLoanResponse) {
            if (response.getStatusNo() == 0) {
                Toast.makeText(getActivity(), "Fm Saved", Toast.LENGTH_SHORT).show();

                Bundle bundle = new Bundle();
                bundle.putParcelable(Constants.HOME_LOAN_QUOTES, getQuoteResponse);
                bundle.putParcelable(Constants.HL_REQUEST, homeLoanRequest);
                ((HLMainActivity) getActivity()).getQuoteParameterBundle(homeLoanRequest);

            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        // startActivity(new Intent(getActivity(), QuoteActivity.class).putParcelableArrayListExtra(Constants.QUOTES, (ArrayList<QuoteEntity>) quoteEntities));
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    //region SeekBar ChangeListener
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {

//            case R.id.sbTenure:
//                if (progress >= seekBarTenureProgress) {
//                    if (fromUser) {
//                        // progress = ((int) Math.round(progress / seekBarTenureProgress)) * seekBarTenureProgress;
//                        etTenureInYear.setText(String.valueOf(progress));
//                    }
//                } else {
//                    etTenureInYear.setText(String.valueOf((long) seekBarTenureProgress));
//                }
//                break;

            case R.id.sbTenure:
                int MIN = 5;

                if (progress >= MIN) {
                    if (fromUser) {
                        // progress = ((int) Math.round(progress / seekBarTenureProgress)) * seekBarTenureProgress;
                        etTenureInYear.setText(String.valueOf(progress));
                    }
                } else {
                    sbTenure.setProgress(MIN);
                    etTenureInYear.setText(String.valueOf(MIN));
                }
                break;

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //  Log.d("progressSeek", "onStart 1");

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }


    private BigDecimal getMaxLoanAmount(String value) {
        double loanAmount = Double.parseDouble(value);
        return BigDecimal.valueOf(Math.ceil(loanAmount * .8)).setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (etCostOfProp.getText().hashCode() == s.hashCode()) {

            if (!etCostOfProp.getText().toString().equals("") && !etCostOfProp.getText().toString().equals(null)) {

                int costOfProperty = Integer.parseInt(etCostOfProp.getText().toString());
                int sactionAmount = getMaxLoanAmount("" + costOfProperty).intValueExact();
                txtMaxLoanAmntAllow.setText("" + sactionAmount);
            } else {
                txtMaxLoanAmntAllow.setText("");
            }

        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
    // endregion


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }


    private RadioGroup.OnCheckedChangeListener rgProp1Listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rgProperty2.setOnCheckedChangeListener(null); // remove the listener before clearing
                rgProperty2.clearCheck(); // clear the second RadioGroup!
                rgProperty2.setOnCheckedChangeListener(rgProp2Listener); //reset the listener

                if (checkedId == R.id.rbReady) {
                    propTyp = "1";
                } else if (checkedId == R.id.rbUnder) {
                    propTyp = "2";
                } else if (checkedId == R.id.rbSearching) {
                    propTyp = "3";
                }
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener rgProp2Listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rgProperty1.setOnCheckedChangeListener(null);
                rgProperty1.clearCheck();
                rgProperty1.setOnCheckedChangeListener(rgProp1Listener);
                if (checkedId == R.id.rbResale) {
                    propTyp = "4";
                } else if (checkedId == R.id.rbForcons) {
                    propTyp = "5";
                } else if (checkedId == R.id.rbOther) {
                    propTyp = "6";
                }
            }
        }
    };


}
