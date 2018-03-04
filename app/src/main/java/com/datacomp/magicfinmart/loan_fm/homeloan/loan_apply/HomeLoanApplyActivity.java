package com.datacomp.magicfinmart.loan_fm.homeloan.loan_apply;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;

public class HomeLoanApplyActivity extends BaseActivity implements View.OnClickListener, View.OnFocusChangeListener, IResponseSubcriber {

    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginEntity;

    Spinner spTitle, spNatureOfOrg, spNatureOfBus, spResidence;


    RelativeLayout rlPLInfo, rlAddress, rlEmployment, rlFinancial;

    LinearLayout llPlInfo, llAddress, llEmployment, llFinancial;

    ImageView ivMale, ivFemale, ivPLInfo, ivAddress, ivEmploy, ivFinancial;

    CheckBox chkPresent;

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


    TextView txtMarried, txtSingle, txtRES, txtNRI, txtPIO, txtOCR, txtFOR,
            txtGEN, txtSC, txtST, txtOBC, txtOTH,
            txtPORT, txtVOTER, txtDRV,
            txtMATR, txtUGRAD, txtGRAD, txtPGRAD, txteducatOTH;

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

        ivPLInfo.setOnClickListener(this);
        ivAddress.setOnClickListener(this);
        ivEmploy.setOnClickListener(this);
        ivFinancial.setOnClickListener(this);

        rlPLInfo.setOnClickListener(this);
        rlAddress.setOnClickListener(this);
        rlEmployment.setOnClickListener(this);
        rlFinancial.setOnClickListener(this);

    }

    private void initLayouts() {
        llPlInfo.setVisibility(View.GONE);
        llAddress.setVisibility(View.GONE);
        llEmployment.setVisibility(View.GONE);
        llFinancial.setVisibility(View.GONE);

    }

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
        }
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
