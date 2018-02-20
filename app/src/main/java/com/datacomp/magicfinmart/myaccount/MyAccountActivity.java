package com.datacomp.magicfinmart.myaccount;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.register.RegisterActivity;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register.RegisterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.RegisterRequestEntity;



/**
 * Created by daniyalshaikh on 10/01/18.
 */

public class MyAccountActivity extends BaseActivity implements View.OnClickListener ,IResponseSubcriber {


    LinearLayout llMyProfile, llAddress,llBankDetail,llDocumentUpload;
    ImageView ivMyProfile, ivAddress,ivBankDetail,ivDocumentUpload;
    RelativeLayout rlMyProfile, rlAddress,rlBankDetail,rlDocumentUpload;

    EditText etSubHeading , etMobileNo , etEmailId , etAddress1 , etAddress2 , etAddress3, etPincode ,
            etCity , etState , etAccountHolderName,etAadhaar, etPAN, etBankAcNo, etIfscCode ,
            etMicrCode , etBankName, etBankBranch , etBankCity;
    TextView txtSaving , txtCurrent;

    Button btnSave;
    RegisterRequestEntity registerRequestEntity;
    DBPersistanceController dbPersistanceController;
    private String ACCOUNT_TYPE = "SAVING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaccount);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbPersistanceController = new DBPersistanceController(this);
        registerRequestEntity = new RegisterRequestEntity();
        initWidgets();
        setListener();
        initLayouts();

    }

    private void initLayouts() {
        llMyProfile.setVisibility(View.GONE);
        llAddress.setVisibility(View.GONE);
        llBankDetail.setVisibility(View.GONE);
        llDocumentUpload.setVisibility(View.GONE);
        hideAllLayouts(llMyProfile, ivMyProfile);
    }

    private void setListener() {
        ivAddress.setOnClickListener(this);
        ivMyProfile.setOnClickListener(this);
        rlMyProfile.setOnClickListener(this);
        rlAddress.setOnClickListener(this);

        rlBankDetail.setOnClickListener(this);
        ivBankDetail.setOnClickListener(this);

        rlDocumentUpload.setOnClickListener(this);
        ivDocumentUpload.setOnClickListener(this);

        btnSave.setOnClickListener(this);
        txtSaving.setOnClickListener(this);
        txtCurrent.setOnClickListener(this);
        etPincode.addTextChangedListener(pincodeTextWatcher);

    }

    private void initWidgets() {
        ivAddress = (ImageView) findViewById(R.id.ivAddress);
        ivMyProfile = (ImageView) findViewById(R.id.ivMyProfile);
        llMyProfile = (LinearLayout) findViewById(R.id.llMyProfile);
        llAddress = (LinearLayout) findViewById(R.id.llAddress);
        llDocumentUpload = (LinearLayout) findViewById(R.id.llDocumentUpload);
        llBankDetail = (LinearLayout) findViewById(R.id.llBankDetail);
        rlMyProfile = (RelativeLayout) findViewById(R.id.rlMyProfile);
        rlAddress = (RelativeLayout) findViewById(R.id.rlAddress);

        rlBankDetail = (RelativeLayout) findViewById(R.id.rlBankDetail);
        ivBankDetail =  (ImageView) findViewById(R.id.ivBankDetail);
        rlDocumentUpload = (RelativeLayout) findViewById(R.id.rlDocumentUpload);
        ivDocumentUpload =  (ImageView) findViewById(R.id.ivDocumentUpload);

        etSubHeading = (EditText) findViewById(R.id.etSubHeading);
        etMobileNo = (EditText) findViewById(R.id.etMobileNo);
        etEmailId = (EditText) findViewById(R.id.etEmailId);
        etAddress1 = (EditText) findViewById(R.id.etAddress1);
        etAddress2 = (EditText) findViewById(R.id.etAddress2);

        etAddress3 = (EditText) findViewById(R.id.etAddress3);
        etPincode  = (EditText) findViewById(R.id.etPincode);
        etCity = (EditText) findViewById(R.id.etCity);
        etState = (EditText) findViewById(R.id.etState );
        etAccountHolderName = (EditText) findViewById(R.id.etAccountHolderName);

        etAadhaar = (EditText) findViewById(R.id.etAadhaar);
        etPAN = (EditText) findViewById(R.id.etPAN);
        etBankAcNo = (EditText) findViewById(R.id.etBankAcNo);
        etIfscCode = (EditText) findViewById(R.id.etIfscCode);

        etMicrCode = (EditText) findViewById(R.id.etMicrCode);
        etBankName = (EditText) findViewById(R.id.etBankName);
        etBankBranch = (EditText) findViewById(R.id.etBankBranch);
        etBankCity = (EditText) findViewById(R.id.etBankCity);

        txtSaving = (TextView) findViewById(R.id.txtSaving);
        txtCurrent = (TextView) findViewById(R.id.txtCurrent);

        btnSave = (Button) findViewById(R.id.btnSave);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivMyProfile:
            case R.id.rlMyProfile:
                manageMainLayouts(llMyProfile,llAddress,llBankDetail,llDocumentUpload);
                manageImages(llMyProfile,ivMyProfile,ivAddress,ivBankDetail,ivDocumentUpload);
                break;
            case R.id.ivAddress:
            case R.id.rlAddress:
                manageMainLayouts(llAddress,llMyProfile,llBankDetail,llDocumentUpload);
                manageImages(llAddress,ivAddress,ivMyProfile,ivBankDetail,ivDocumentUpload);
                break;
            case R.id.ivBankDetail:
            case R.id.rlBankDetail:
                manageMainLayouts(llBankDetail,llMyProfile,llAddress,llDocumentUpload);
                manageImages(llBankDetail,ivBankDetail,ivAddress,ivMyProfile,ivDocumentUpload);
                break;
            case R.id.ivDocumentUpload:
            case R.id.rlDocumentUpload:
                manageMainLayouts(llDocumentUpload,llBankDetail,llMyProfile,llAddress);
                manageImages(llDocumentUpload,ivDocumentUpload,ivBankDetail,ivAddress,ivMyProfile);

                break;

            case R.id.txtSaving:
                setSaving();
                break;
            case R.id.txtCurrent:
                setCurrent();
                break;

            case R.id.btnSave:

                break;
        }
    }


    //region textwatcher
    TextWatcher pincodeTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (start == 5) {
                etCity.setText("");
                etState.setText("");
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() == 6) {
                showDialog("Fetching City...");
                new RegisterController(MyAccountActivity.this).getCityState(etPincode.getText().toString(), MyAccountActivity.this);

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    TextWatcher mobileTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (start == 9) {
               // isMobileValid = false;
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    //endregion

    private void setAccountRequest() {
//        registerRequestEntity.setFirstName("" + etFirstName.getText().toString());
//        registerRequestEntity.setLastName("" + etLastName.getText().toString());
//        registerRequestEntity.setDOB("" + etDob.getText().toString());
//        registerRequestEntity.setMobile_1("" + etMobile1.getText().toString());
//        registerRequestEntity.setMobile_2("" + etMobile2.getText().toString());
//        registerRequestEntity.setEmailId("" + etEmail.getText().toString());
//        registerRequestEntity.setPinCode("" + etPincode.getText().toString());
//        if (isMale) {
//            registerRequestEntity.setGender("M");
//        } else {
//            registerRequestEntity.setGender("F");
//        }
//        registerRequestEntity.setPassword(pass);

    }


    private void setSaving() {
        ACCOUNT_TYPE = "SAVING";
        txtSaving.setBackgroundResource(R.drawable.customeborder_blue);
        txtSaving.setTextColor(ContextCompat.getColor(MyAccountActivity.this, R.color.colorPrimary));

        txtCurrent.setBackgroundResource(R.drawable.customeborder);
        txtCurrent.setTextColor(ContextCompat.getColor(MyAccountActivity.this, R.color.description_text));


    }

    private void setCurrent() {
        ACCOUNT_TYPE = "CURRENT";
        txtCurrent.setBackgroundResource(R.drawable.customeborder_blue);
        txtCurrent.setTextColor(ContextCompat.getColor(MyAccountActivity.this, R.color.colorPrimary));

        txtSaving.setBackgroundResource(R.drawable.customeborder);
        txtSaving.setTextColor(ContextCompat.getColor(MyAccountActivity.this, R.color.description_text));


    }
    private void manageMainLayouts(LinearLayout visibleLayout, LinearLayout hideLayout1, LinearLayout hideLayout2, LinearLayout hideLayout3) {

        if (visibleLayout.getVisibility() == View.GONE) {
            visibleLayout.setVisibility(View.VISIBLE);
            hideLayout1.setVisibility(View.GONE);
            hideLayout2.setVisibility(View.GONE);
            hideLayout3.setVisibility(View.GONE);
        }
        else{
            visibleLayout.setVisibility(View.GONE);
        }
    }

    private void manageImages(LinearLayout clickedLayout ,ImageView downImage,ImageView upImage1,ImageView upImage2,ImageView upImage3) {

        if (clickedLayout.getVisibility() == View.GONE) {
            downImage.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));
            upImage1.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));
            upImage2.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));
            upImage3.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));
        }
        else{
            downImage.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));
            upImage1.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));
            upImage2.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));
            upImage3.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));
        }

    }

    private void hideAllLayouts(LinearLayout linearLayout, ImageView imageView) {

        if (linearLayout.getVisibility() == View.GONE) {

            //region hideall layout
            ivMyProfile.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));
            llMyProfile.setVisibility(View.GONE);

            ivAddress.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));
            llAddress.setVisibility(View.GONE);
            //endregion

            linearLayout.setVisibility(View.GONE);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));

        } else {
            linearLayout.setVisibility(View.GONE);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));
        }
    }


    @Override
    public void OnSuccess(APIResponse response, String message) {

    }

    @Override
    public void OnFailure(Throwable t) {

    }
}
