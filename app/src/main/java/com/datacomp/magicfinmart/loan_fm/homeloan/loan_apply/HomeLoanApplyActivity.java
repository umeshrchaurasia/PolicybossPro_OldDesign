package com.datacomp.magicfinmart.loan_fm.homeloan.loan_apply;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

    Spinner spTitle;

    RelativeLayout rlPLInfo, rlAddress, rlEmployment, rlFinancial;

    LinearLayout llPlInfo, llAddress, llEmployment, llFinancial;

    ImageView ivMale, ivFemale, ivPLInfo, ivAddress, ivEmploy, ivFinancial;

    TextView txtMarried, txtSingle, txtRES, txtNRI, txtPIO, txtOCR, txtFOR;
    TextView txtGEN, txtSC, txtST, txtOBC, txtOTH;
    TextView txtPORT, txtVOTER, txtDRV;
    TextView txtMATR, txtUGRAD, txtGRAD, txtPGRAD, txteducatOTH;

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
                manageImages(llPlInfo,ivPLInfo, ivEmploy,  ivAddress, ivFinancial);//
                break;

            case R.id.ivAddress:
            case R.id.rlAddress:
                manageMainLayouts(llAddress,llPlInfo,  llEmployment, llFinancial);
                manageImages(llAddress, ivAddress, ivEmploy, ivPLInfo,ivFinancial);

                break;

            case R.id.ivEmploy:
            case R.id.rlEmployment:
                manageMainLayouts(llEmployment,llPlInfo, llAddress,  llFinancial);
                manageImages(llEmployment, ivEmploy, ivPLInfo, ivAddress, ivFinancial);
                break;

            case R.id.ivFinancial:
            case R.id.rlFinancial:
                manageMainLayouts(llFinancial,llPlInfo, llAddress, llEmployment);
                manageImages(llFinancial , ivFinancial , ivPLInfo, ivAddress, ivEmploy);
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
