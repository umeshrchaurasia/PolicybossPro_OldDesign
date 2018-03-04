package com.datacomp.magicfinmart.loan_fm.homeloan.loan_apply;

import android.app.DatePickerDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;

public class HomeLoanApplyActivity extends BaseActivity implements View.OnClickListener, View.OnFocusChangeListener, IResponseSubcriber {

    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginEntity;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    Spinner spTitle, spNatureOfOrg, spNatureOfBus, spResidence;
    RelativeLayout rlPLInfo, rlAddress, rlEmployment, rlFinancial;

    LinearLayout llPlInfo, llAddress, llEmployment, llFinancial;

    ImageView ivMale, ivFemale, ivPLInfo, ivAddress, ivEmploy, ivFinancial,
            ivFinancialPending, ivFinancialDone, ivEmployDone, ivEmployPending, ivAddressDone, ivAddressPending, ivPLInfoDone, ivPLInfoPending;
    ;

    CheckBox chkPresent;
    Button btnSubmit;

    EditText etFirstName, etLastName, etDob, etFatherName, etPan, etNationality, etUniversity, etMoMaidenName, etSpouceName, etNoOfDepen,
    // Address
    etEmailPersContInfo, etEmailOffContInfo, etMobNo1ContInfo, etMobNo2ContInfo,
            etAddress1ContInfoRAP, etAddress2ContInfoRAP, etAddress3ContInfoRAP,
            etLandmakContInfoRAP, etPincodeContInfoRAP, etCityContInfoRAP,
            etStateContInfoRAP, etCountryPlRAP, etAddress1ContInfoPA, etAddress2ContInfoPA, etAddress3ContInfoPA, etLandmakContInfoPA,
            etPincodeContInfoPA, etCityContInfo, etStateContInfoPA, etCountryPA,
            etLandlineNoContInfoPA, etNoOfYrsAtOffContInfoPA,

    // Employment
    etDesig, etCurrJob, etTotalExp, etNameOfOrg, etTurnOver, etDeprec, etDirRem, etProfAftTax,
            etAddress1ED, etAddress2, etAddress3, etLandmak, etPincodeED, etCityED, etStateED, etCountryPl, etLandlineNoPl,

    // Finacial
    etGrossIncome, etNetIncome, etOtherIncome, etTotalIncome;


    TextView txtMarried, txtSingle, txtIdType, txtRES, txtNRI, txtPIO, txtOCR, txtFOR,
            txtGEN, txtSC, txtST, txtOBC, txtOTH,
            txtPORT, txtVOTER, txtDRV,
            txtMATR, txtUGRAD, txtGRAD, txtPGRAD, txteducatOTH;

    String Gender = "M";
    String PL_STATUS = "RES", PL_CATEGORY = "GEN", PL_IDTYPE = "", PL_EDUCATION = "GRAD";
    int StatusType = 1, CategoryType = 2, IdType = 3, EducationType = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_loan_apply);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbPersistanceController = new DBPersistanceController(this);
        loginEntity = dbPersistanceController.getUserData();
        initialize();
        setListener();
        initLayouts();
        setDefaultCheckList();
    }

    private void initialize() {

        // region MasterLayout
        ivPLInfo = (ImageView) findViewById(R.id.ivPLInfo);
        ivAddress = (ImageView) findViewById(R.id.ivAddress);
        ivEmploy = (ImageView) findViewById(R.id.ivEmploy);
        ivFinancial = (ImageView) findViewById(R.id.ivFinancial);

        rlPLInfo = (RelativeLayout) findViewById(R.id.rlPLInfo);
        rlAddress = (RelativeLayout) findViewById(R.id.rlAddress);
        rlEmployment = (RelativeLayout) findViewById(R.id.rlEmployment);
        rlFinancial = (RelativeLayout) findViewById(R.id.rlFinancial);

        llPlInfo = (LinearLayout) findViewById(R.id.llPlInfo);
        llAddress = (LinearLayout) findViewById(R.id.llAddress);
        llEmployment = (LinearLayout) findViewById(R.id.llEmployment);
        llFinancial = (LinearLayout) findViewById(R.id.llFinancial);
        // endregion

        // region Persoal Info
        txtMarried = (TextView) findViewById(R.id.txtMarried);
        txtSingle = (TextView) findViewById(R.id.txtSingle);
        txtIdType = (TextView) findViewById(R.id.txtIdType);

        txtRES = (TextView) findViewById(R.id.txtRES);
        txtNRI = (TextView) findViewById(R.id.txtNRI);
        txtPIO = (TextView) findViewById(R.id.txtPIO);
        txtOCR = (TextView) findViewById(R.id.txtOCR);
        txtFOR = (TextView) findViewById(R.id.txtFOR);

        txtGEN = (TextView) findViewById(R.id.txtGEN);
        txtSC = (TextView) findViewById(R.id.txtSC);
        txtST = (TextView) findViewById(R.id.txtST);
        txtOBC = (TextView) findViewById(R.id.txtOBC);
        txtOTH = (TextView) findViewById(R.id.txtOTH);

        txtPORT = (TextView) findViewById(R.id.txtPORT);
        txtVOTER = (TextView) findViewById(R.id.txtVOTER);
        txtDRV = (TextView) findViewById(R.id.txtDRV);

        txtMATR = (TextView) findViewById(R.id.txtMATR);
        txtUGRAD = (TextView) findViewById(R.id.txtUGRAD);
        txtGRAD = (TextView) findViewById(R.id.txtGRAD);
        txtPGRAD = (TextView) findViewById(R.id.txtPGRAD);
        txteducatOTH = (TextView) findViewById(R.id.txteducatOTH);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etDob = (EditText) findViewById(R.id.etDob);
        etPan = (EditText) findViewById(R.id.etPan);
        etFatherName = (EditText) findViewById(R.id.etFatherName);

        etNationality = (EditText) findViewById(R.id.etNationality);
        etUniversity = (EditText) findViewById(R.id.etUniversity);
        etMoMaidenName = (EditText) findViewById(R.id.etMoMaidenName);
        etSpouceName = (EditText) findViewById(R.id.etSpouceName);
        etNoOfDepen = (EditText) findViewById(R.id.etNoOfDepen);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        // endregion

        // region Address
        chkPresent = (CheckBox) findViewById(R.id.chkPresent);

        etEmailPersContInfo = (EditText) findViewById(R.id.etEmailPersContInfo);
        etEmailOffContInfo = (EditText) findViewById(R.id.etEmailOffContInfo);
        etMobNo1ContInfo = (EditText) findViewById(R.id.etMobNo1ContInfo);
        etMobNo2ContInfo = (EditText) findViewById(R.id.etMobNo2ContInfo);

        etAddress1ContInfoRAP = (EditText) findViewById(R.id.etAddress1ContInfoRAP);
        etAddress2ContInfoRAP = (EditText) findViewById(R.id.etAddress2ContInfoRAP);
        etAddress3ContInfoRAP = (EditText) findViewById(R.id.etAddress3ContInfoRAP);
        etLandmakContInfoRAP = (EditText) findViewById(R.id.etLandmakContInfoRAP);

        etPincodeContInfoRAP = (EditText) findViewById(R.id.etPincodeContInfoRAP);
        etCityContInfoRAP = (EditText) findViewById(R.id.etCityContInfoRAP);
        etStateContInfoRAP = (EditText) findViewById(R.id.etStateContInfoRAP);
        etCountryPlRAP = (EditText) findViewById(R.id.etCountryPlRAP);

        etAddress1ContInfoPA = (EditText) findViewById(R.id.etAddress1ContInfoPA);
        etAddress2ContInfoPA = (EditText) findViewById(R.id.etAddress2ContInfoPA);
        etAddress3ContInfoPA = (EditText) findViewById(R.id.etAddress3ContInfoPA);
        etLandmakContInfoPA = (EditText) findViewById(R.id.etLandmakContInfoPA);

        etPincodeContInfoPA = (EditText) findViewById(R.id.etPincodeContInfoPA);
        etCityContInfo = (EditText) findViewById(R.id.etCityContInfo);
        etStateContInfoPA = (EditText) findViewById(R.id.etStateContInfoPA);
        etCountryPA = (EditText) findViewById(R.id.etCountryPA);

        etLandlineNoContInfoPA = (EditText) findViewById(R.id.etLandlineNoContInfoPA);
        etNoOfYrsAtOffContInfoPA = (EditText) findViewById(R.id.etNoOfYrsAtOffContInfoPA);

        txtMarried = (TextView) findViewById(R.id.txtMarried);
        txtSingle = (TextView) findViewById(R.id.txtSingle);
        txtRES = (TextView) findViewById(R.id.txtRES);
        txtNRI = (TextView) findViewById(R.id.txtNRI);
        txtPIO = (TextView) findViewById(R.id.txtPIO);
        txtOCR = (TextView) findViewById(R.id.txtOCR);
        txtFOR = (TextView) findViewById(R.id.txtFOR);

        txtGEN = (TextView) findViewById(R.id.txtGEN);
        txtSC = (TextView) findViewById(R.id.txtSC);
        txtST = (TextView) findViewById(R.id.txtST);
        txtOBC = (TextView) findViewById(R.id.txtOBC);
        txtOTH = (TextView) findViewById(R.id.txtOTH);

        txtPORT = (TextView) findViewById(R.id.txtPORT);
        txtVOTER = (TextView) findViewById(R.id.txtVOTER);
        txtDRV = (TextView) findViewById(R.id.txtDRV);

        txtMATR = (TextView) findViewById(R.id.txtMATR);
        txtUGRAD = (TextView) findViewById(R.id.txtUGRAD);
        txtGRAD = (TextView) findViewById(R.id.txtGRAD);
        txtPGRAD = (TextView) findViewById(R.id.txtPGRAD);
        txteducatOTH = (TextView) findViewById(R.id.txteducatOTH);


        ivMale = (ImageView) findViewById(R.id.ivMale);
        ivFemale = (ImageView) findViewById(R.id.ivFemale);

        ivFinancialPending = (ImageView) findViewById(R.id.ivFinancialPending);
        ivFinancialDone = (ImageView) findViewById(R.id.ivFinancialDone);
        ivEmployDone = (ImageView) findViewById(R.id.ivEmployDone);
        ivEmployPending = (ImageView) findViewById(R.id.ivEmployPending);

        ivAddressDone = (ImageView) findViewById(R.id.ivAddressDone);
        ivAddressPending = (ImageView) findViewById(R.id.ivAddressPending);
        ivPLInfoDone = (ImageView) findViewById(R.id.ivPLInfoDone);
        ivPLInfoPending = (ImageView) findViewById(R.id.ivPLInfoPending);

        //endregion

        // region Employment Dtl
        etDesig = (EditText) findViewById(R.id.etDesig);
        etCurrJob = (EditText) findViewById(R.id.etCurrJob);
        etTotalExp = (EditText) findViewById(R.id.etTotalExp);
        etNameOfOrg = (EditText) findViewById(R.id.etNameOfOrg);

        etTurnOver = (EditText) findViewById(R.id.etTurnOver);
        etDeprec = (EditText) findViewById(R.id.etDeprec);
        etDirRem = (EditText) findViewById(R.id.etDirRem);
        etProfAftTax = (EditText) findViewById(R.id.etProfAftTax);

        etAddress1ED = (EditText) findViewById(R.id.etAddress1ED);
        etAddress2 = (EditText) findViewById(R.id.etAddress2);
        etAddress3 = (EditText) findViewById(R.id.etAddress3);
        etLandmak = (EditText) findViewById(R.id.etLandmak);

        etPincodeED = (EditText) findViewById(R.id.etPincodeED);
        etCityED = (EditText) findViewById(R.id.etCityED);
        etStateED = (EditText) findViewById(R.id.etStateED);
        etCountryPl = (EditText) findViewById(R.id.etCountryPl);
        etLandlineNoPl = (EditText) findViewById(R.id.etLandlineNoPl);
        //endregion

        // region Financial Info
        etGrossIncome = (EditText) findViewById(R.id.etGrossIncome);
        etNetIncome = (EditText) findViewById(R.id.etNetIncome);
        etOtherIncome = (EditText) findViewById(R.id.etOtherIncome);
        etTotalIncome = (EditText) findViewById(R.id.etTotalIncome);

        //endregion

    }


    private void setListener() {

        etDob.setOnClickListener(datePickerDialogApplicant);
        btnSubmit.setOnClickListener(this);
        ivMale.setOnClickListener(this);
        ivFemale.setOnClickListener(this);

        ivPLInfo.setOnClickListener(this);
        ivAddress.setOnClickListener(this);
        ivEmploy.setOnClickListener(this);
        ivFinancial.setOnClickListener(this);

        rlPLInfo.setOnClickListener(this);
        rlAddress.setOnClickListener(this);
        rlEmployment.setOnClickListener(this);
        rlFinancial.setOnClickListener(this);

        txtMarried.setOnClickListener(this);
        txtSingle.setOnClickListener(this);

        txtRES.setOnClickListener(this);
        txtNRI.setOnClickListener(this);
        txtPIO.setOnClickListener(this);
        txtOCR.setOnClickListener(this);
        txtFOR.setOnClickListener(this);

        txtGEN.setOnClickListener(this);
        txtSC.setOnClickListener(this);
        txtST.setOnClickListener(this);
        txtOBC.setOnClickListener(this);
        txtOTH.setOnClickListener(this);

        txtPORT.setOnClickListener(this);
        txtVOTER.setOnClickListener(this);
        txtDRV.setOnClickListener(this);

        txtMATR.setOnClickListener(this);
        txtUGRAD.setOnClickListener(this);
        txtGRAD.setOnClickListener(this);
        txtPGRAD.setOnClickListener(this);
        txteducatOTH.setOnClickListener(this);


    }

    private void initLayouts() {
        llPlInfo.setVisibility(View.GONE);
        llAddress.setVisibility(View.GONE);
        llEmployment.setVisibility(View.GONE);
        llFinancial.setVisibility(View.GONE);

    }

    private void setDefaultCheckList() {
        ivFinancialPending.setVisibility(View.VISIBLE);
        ivEmployPending.setVisibility(View.VISIBLE);
        ivAddressPending.setVisibility(View.VISIBLE);
        ivPLInfoPending.setVisibility(View.VISIBLE);

        ivFinancialDone.setVisibility(View.INVISIBLE);
        ivEmployDone.setVisibility(View.INVISIBLE);
        ivAddressDone.setVisibility(View.INVISIBLE);
        ivPLInfoDone.setVisibility(View.INVISIBLE);

        setMale_gender();
    }

    private void setMale_gender() {
        Gender = "M";
        ivMale.setImageResource(R.drawable.male_selected);
        ivFemale.setImageResource(R.drawable.female);

    }

    private void setFeMale_gender() {
        Gender = "F";
        ivFemale.setImageResource(R.drawable.female_selected);
        ivMale.setImageResource(R.drawable.male);


    }


    private void managePL_Common(int Type, String Value, TextView clickedText, TextView textView1, TextView textView2, TextView textView3, TextView textView4) {


        if (Type == 1) {
            PL_STATUS = Value;
        } else if (Type == 2) {
            PL_CATEGORY = Value;
        }
        if (Type == 3) {
            PL_IDTYPE = Value;
        }
        if (Type == 4) {
            PL_EDUCATION = Value;
        }
        clickedText.setBackgroundResource(R.drawable.customeborder_blue);
        clickedText.setTextColor(ContextCompat.getColor(HomeLoanApplyActivity.this, R.color.colorPrimary));

        textView1.setBackgroundResource(R.drawable.customeborder);
        textView1.setTextColor(ContextCompat.getColor(HomeLoanApplyActivity.this, R.color.description_text));

        textView2.setBackgroundResource(R.drawable.customeborder);
        textView2.setTextColor(ContextCompat.getColor(HomeLoanApplyActivity.this, R.color.description_text));

        textView3.setBackgroundResource(R.drawable.customeborder);
        textView3.setTextColor(ContextCompat.getColor(HomeLoanApplyActivity.this, R.color.description_text));

        textView4.setBackgroundResource(R.drawable.customeborder);
        textView4.setTextColor(ContextCompat.getColor(HomeLoanApplyActivity.this, R.color.description_text));


    }

    private void managePL_IDTYPE(String Value, TextView clickedText, TextView textView1, TextView textView2) {

        PL_IDTYPE = Value;
        txtIdType.setVisibility(View.GONE);
        clickedText.setBackgroundResource(R.drawable.customeborder_blue);
        clickedText.setTextColor(ContextCompat.getColor(HomeLoanApplyActivity.this, R.color.colorPrimary));

        textView1.setBackgroundResource(R.drawable.customeborder);
        textView1.setTextColor(ContextCompat.getColor(HomeLoanApplyActivity.this, R.color.description_text));

        textView2.setBackgroundResource(R.drawable.customeborder);
        textView2.setTextColor(ContextCompat.getColor(HomeLoanApplyActivity.this, R.color.description_text));

    }

    //region datePickerDialog Applicant
    protected View.OnClickListener datePickerDialogApplicant = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Constants.hideKeyBoard(view, HomeLoanApplyActivity.this);
            DateTimePicker.showDataPickerDialogBeforeTwentyOne(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(year, monthOfYear, dayOfMonth);
                    String currentDay = simpleDateFormat.format(calendar.getTime());
                    etDob.setText(currentDay);
                    //etDate.setTag(R.id.et_date, calendar.getTime());
                }
            });
        }
    };
    //endregion


    @Override
    public void onClick(View view) {
        Constants.hideKeyBoard(view, this);
        switch (view.getId()) {
            case R.id.ivPLInfo:
            case R.id.rlPLInfo:
                manageMainLayouts(llPlInfo, llAddress, llEmployment, llFinancial);
                manageImages(llPlInfo, ivPLInfo, ivEmploy, ivAddress, ivFinancial);//
                break;

            case R.id.ivAddress:
            case R.id.rlAddress:
                manageMainLayouts(llAddress, llPlInfo, llEmployment, llFinancial);
                manageImages(llAddress, ivAddress, ivEmploy, ivPLInfo, ivFinancial);

                break;

            case R.id.ivEmploy:
            case R.id.rlEmployment:
                manageMainLayouts(llEmployment, llPlInfo, llAddress, llFinancial);
                manageImages(llEmployment, ivEmploy, ivPLInfo, ivAddress, ivFinancial);
                break;

            case R.id.ivFinancial:
            case R.id.rlFinancial:
                manageMainLayouts(llFinancial, llPlInfo, llAddress, llEmployment);
                manageImages(llFinancial, ivFinancial, ivPLInfo, ivAddress, ivEmploy);
                break;

            case R.id.ivMale:
                setMale_gender();
                break;

            case R.id.ivFemale:
                setFeMale_gender();
                break;

            //region PL INFO Status
            case R.id.txtRES:
                managePL_Common(StatusType, "RES", txtRES, txtNRI, txtPIO, txtOCR, txtFOR);
                break;
            case R.id.txtNRI:
                managePL_Common(StatusType, "NRI", txtNRI, txtRES, txtPIO, txtOCR, txtFOR);
                break;
            case R.id.txtPIO:
                managePL_Common(StatusType,"PIO", txtPIO, txtRES, txtNRI, txtOCR, txtFOR);
                break;
            case R.id.txtOCR:
                managePL_Common(StatusType,"OCR", txtOCR, txtRES, txtNRI, txtPIO, txtFOR);
                break;
            case R.id.txtFOR:
                managePL_Common(StatusType,"FOR", txtFOR, txtRES, txtNRI, txtPIO, txtOCR);
                break;
            //endregion

            //region PL INFO Category
            case R.id.txtGEN:
                managePL_Common(CategoryType,"GEN", txtGEN, txtSC, txtST, txtOBC, txtOTH);
                break;
            case R.id.txtSC:
                managePL_Common(CategoryType,"SC", txtSC, txtGEN, txtST, txtOBC, txtOTH);
                break;
            case R.id.txtST:
                managePL_Common(CategoryType,"ST", txtST, txtGEN, txtSC, txtOBC, txtOTH);
                break;
            case R.id.txtOBC:
                managePL_Common(CategoryType,"OBC", txtOBC, txtGEN, txtSC, txtST, txtOTH);
                break;
            case R.id.txtOTH:
                managePL_Common(CategoryType,"OTH", txtOTH, txtGEN, txtSC, txtST, txtOBC);
                //endregion

                // region PL INFO IDType
            case R.id.txtPORT:
                managePL_IDTYPE("PORT", txtPORT, txtVOTER, txtDRV);
                break;
            case R.id.txtVOTER:
                managePL_IDTYPE("VOTER", txtVOTER, txtPORT, txtDRV);
                break;
            case R.id.txtDRV:
                managePL_IDTYPE("DRV", txtDRV, txtPORT, txtVOTER);
                break;
            //endregion

            // region PL INFO Education
            case R.id.txtMATR:
                managePL_Common( EducationType,"MATR", txtMATR, txtUGRAD, txtGRAD, txtPGRAD, txteducatOTH);
                break;
            case R.id.txtUGRAD:
                managePL_Common(EducationType,"UGRAD", txtUGRAD, txtMATR, txtGRAD, txtPGRAD, txteducatOTH);
                break;
            case R.id.txtGRAD:
                managePL_Common(EducationType,"GRAD", txtGRAD, txtMATR, txtUGRAD, txtPGRAD, txteducatOTH);
                break;
            case R.id.txtPGRAD:
                managePL_Common(EducationType,"PGRAD", txtPGRAD, txtMATR, txtUGRAD, txtGRAD, txteducatOTH);
                break;
            case R.id.txteducatOTH:
                managePL_Common(EducationType,"PGRAD", txteducatOTH, txtPGRAD, txtMATR, txtUGRAD, txtGRAD);

                //endregion


            case R.id.btnSubmit:

                if (validatePL_Info() == false) {
                    if (llPlInfo.getVisibility() == View.GONE) {

                        manageMainLayouts(llPlInfo, llAddress, llEmployment, llFinancial);
                        manageImages(llPlInfo, ivPLInfo, ivEmploy, ivAddress, ivFinancial);//
                    }
                }
                validatePL_Info();
                break;
        }
    }


    private boolean validatePL_Info() {

        if (!isEmpty(etFirstName)) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etFirstName.requestFocus();
                etFirstName.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                etFirstName.setError("Enter First Name");
                return false;
            } else {
                etFirstName.requestFocus();
                etFirstName.setError("Enter First Name");
                return false;
            }
        }

        if (!isEmpty(etLastName)) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etLastName.requestFocus();
                etLastName.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                etLastName.setError("Enter Last Name");
                return false;
            } else {
                etLastName.requestFocus();
                etLastName.setError("Enter Last Name");
                return false;
            }
        }


        if (!isEmpty(etSpouceName)) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etSpouceName.requestFocus();
                etSpouceName.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                etSpouceName.setError("Enter Last Name");
                return false;
            } else {
                etSpouceName.requestFocus();
                etSpouceName.setError("Enter Spouce Name");
                return false;
            }
        }

        if (!isEmpty(etPan)) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etPan.requestFocus();
                etPan.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                etPan.setError("Enter PAN");
                return false;
            } else {
                etPan.requestFocus();
                etPan.setError("Enter PAN");
                return false;
            }
        }

        if (!isValidPan(etPan)) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etPan.requestFocus();
                etPan.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                etPan.setError("Enter Valid PAN");
                return false;
            } else {
                etPan.requestFocus();
                etPan.setError("Enter Valid PAN");
                return false;
            }
        }

        if (PL_IDTYPE.equals("")) {
            txtIdType.setVisibility(View.VISIBLE);
            return false;
        }

        if (!isEmpty(etMoMaidenName)) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                etMoMaidenName.requestFocus();
                etMoMaidenName.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                etMoMaidenName.setError("Enter Mother's Maiden Name");
                return false;
            } else {
                etMoMaidenName.requestFocus();
                etMoMaidenName.setError("Enter Mother's Maiden Name");
                return false;
            }
        }
        return true;
    }

    private void manageMainLayouts(LinearLayout visibleLayout, LinearLayout hideLayout1, LinearLayout hideLayout2, LinearLayout hideLayout3) {

        if (visibleLayout.getVisibility() == View.GONE) {
            visibleLayout.setVisibility(View.VISIBLE);
            hideLayout1.setVisibility(View.GONE);
            hideLayout2.setVisibility(View.GONE);
            hideLayout3.setVisibility(View.GONE);

        } else {
            visibleLayout.setVisibility(View.GONE);
        }
    }

    private void manageImages(LinearLayout clickedLayout, ImageView downImage, ImageView upImage1, ImageView upImage2, ImageView upImage3) {

        if (clickedLayout.getVisibility() == View.GONE) {
            downImage.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));  //up_arrow
            upImage1.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));
            upImage2.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));
            upImage3.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));

        } else {
            downImage.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));  //down_arrow
            upImage1.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));
            upImage2.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));
            upImage3.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));

        }

    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {

    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

    }

    @Override
    public void OnFailure(Throwable t) {

    }
}
