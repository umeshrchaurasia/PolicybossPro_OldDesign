package com.datacomp.magicfinmart.posp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;
import com.datacomp.magicfinmart.webviews.MyWebViewClient;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register.RegisterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.IfscEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.RegisterRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.IfscCodeResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PincodeResponse;

/**
 * Created by daniyalshaikh on 11/01/18.
 */

public class PospEnrollment extends BaseActivity implements View.OnClickListener, IResponseSubcriber, View.OnFocusChangeListener {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    LinearLayout llMyProfile, llAddress, llBankDetail, llDocumentUpload;
    ImageView ivMyProfile, ivAddress, ivBankDetail, ivDocumentUpload;
    RelativeLayout rlMyProfile, rlAddress, rlBankDetail, rlDocumentUpload;
    Dialog dialog;
    boolean isPospInfo, isAddress, isBankDetails, isDocumentsUpload, isMale;

    //region inputs
    EditText etFirstName, etLastName, etDob, etMobileNo1, etMobileNo2,
            etEmailId, etPan, etAadhar, etGST, etChannelPartner;
    TextView tvMale, tvFemale;

    //region address
    EditText etAddress1, etAddress2, etAddress3, etPincode, etCity, etState;

    //region bank details
    EditText etBankAcNo, etAccountType, etIfscCode, erMicrCode, etBankBranch, etBankCity, etBankName;
    TextView txtSaving, txtCurrent;
    public String ACCOUNT_TYPE = "SAVING";
    RegisterRequestEntity registerRequestEntity;
    Button btnSave;
    WebView webView;
    String URL = "http://www.irdaonline.org/PublicAccess/LookUpPAN.aspx";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posp_enrollment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        registerRequestEntity = new RegisterRequestEntity();
        initWidgets();
        setListener();
        initLayouts();
        setTextWatcher();
    }

    private void setTextWatcher() {
        etDob.setOnClickListener(datePickerDialog);
        etPincode.addTextChangedListener(pincodeTextWatcher);
    }

    //region pincode textwatcher
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
                new RegisterController(PospEnrollment.this).getCityState(etPincode.getText().toString(), PospEnrollment.this);

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    //endregion

    private void initLayouts() {
        llMyProfile.setVisibility(View.GONE);
        llAddress.setVisibility(View.GONE);
        llBankDetail.setVisibility(View.GONE);
        llDocumentUpload.setVisibility(View.GONE);
        hideAllLayouts(llMyProfile, ivMyProfile);
        setSavingAcc();
    }

    private void setListener() {
        txtSaving.setOnClickListener(this);
        txtCurrent.setOnClickListener(this);

        ivAddress.setOnClickListener(this);
        ivMyProfile.setOnClickListener(this);
        rlMyProfile.setOnClickListener(this);
        rlAddress.setOnClickListener(this);

        rlBankDetail.setOnClickListener(this);
        ivBankDetail.setOnClickListener(this);

        rlDocumentUpload.setOnClickListener(this);
        ivDocumentUpload.setOnClickListener(this);

        tvFemale.setOnClickListener(this);
        tvMale.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        etIfscCode.setOnFocusChangeListener(this);
        etPan.setOnFocusChangeListener(this);
    }

    private void initWidgets() {

        //region address
        etAddress1 = (EditText) findViewById(R.id.etAddress1);
        etAddress2 = (EditText) findViewById(R.id.etAddress2);
        etAddress3 = (EditText) findViewById(R.id.etAddress3);
        etPincode = (EditText) findViewById(R.id.etPincode);
        etCity = (EditText) findViewById(R.id.etCity);
        etState = (EditText) findViewById(R.id.etState);

        //region bank details

        etBankAcNo = (EditText) findViewById(R.id.etBankAcNo);
        etAccountType = (EditText) findViewById(R.id.etAccountType);
        etIfscCode = (EditText) findViewById(R.id.etIfscCode);
        erMicrCode = (EditText) findViewById(R.id.erMicrCode);
        etBankBranch = (EditText) findViewById(R.id.etBankBranch);
        etBankCity = (EditText) findViewById(R.id.etBankCity);
        etBankName = (EditText) findViewById(R.id.etBankName);
        txtSaving = (TextView) findViewById(R.id.txtSaving);
        txtCurrent = (TextView) findViewById(R.id.txtCurrent);
        //region POSP INFORMATION
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etDob = (EditText) findViewById(R.id.etDob);
        etMobileNo1 = (EditText) findViewById(R.id.etMobileNo1);
        etMobileNo2 = (EditText) findViewById(R.id.etMobileNo2);
        etEmailId = (EditText) findViewById(R.id.etEmailId);
        etPan = (EditText) findViewById(R.id.etPan);
        etPan.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(10)});
        etAadhar = (EditText) findViewById(R.id.etAadhar);
        etGST = (EditText) findViewById(R.id.etGST);
        etChannelPartner = (EditText) findViewById(R.id.etChannelPartner);

        tvMale = (TextView) findViewById(R.id.tvMale);
        tvFemale = (TextView) findViewById(R.id.tvFemale);

        ivAddress = (ImageView) findViewById(R.id.ivAddress);
        ivMyProfile = (ImageView) findViewById(R.id.ivMyProfile);
        llMyProfile = (LinearLayout) findViewById(R.id.llMyProfile);
        llAddress = (LinearLayout) findViewById(R.id.llAddress);
        llDocumentUpload = (LinearLayout) findViewById(R.id.llDocumentUpload);
        llBankDetail = (LinearLayout) findViewById(R.id.llBankDetail);
        rlMyProfile = (RelativeLayout) findViewById(R.id.rlMyProfile);
        rlAddress = (RelativeLayout) findViewById(R.id.rlAddress);

        rlBankDetail = (RelativeLayout) findViewById(R.id.rlBankDetail);
        ivBankDetail = (ImageView) findViewById(R.id.ivBankDetail);
        rlDocumentUpload = (RelativeLayout) findViewById(R.id.rlDocumentUpload);
        ivDocumentUpload = (ImageView) findViewById(R.id.ivDocumentUpload);

        btnSave = (Button) findViewById(R.id.btnSave);
        webView = (WebView) findViewById(R.id.webView);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivMyProfile:
            case R.id.rlMyProfile:
                manageMainLayouts(llMyProfile, llAddress, llBankDetail, llDocumentUpload);
                manageImages(llMyProfile, ivMyProfile, ivAddress, ivBankDetail, ivDocumentUpload);
                break;
            case R.id.ivAddress:
            case R.id.rlAddress:

                //region posp Info validation
                if (etFirstName.getText().toString().isEmpty()) {
                    if (llMyProfile.getVisibility() == View.GONE) {
                        manageMainLayouts(llMyProfile, llAddress, llBankDetail, llDocumentUpload);
                        manageImages(llMyProfile, ivMyProfile, ivAddress, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etFirstName.requestFocus();
                        etFirstName.setError("Enter First Name");
                        etFirstName.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etFirstName.requestFocus();
                        etFirstName.setError("Enter First Name");
                        return;
                    }
                }

                if (etLastName.getText().toString().isEmpty()) {
                    if (llMyProfile.getVisibility() == View.GONE) {
                        manageMainLayouts(llMyProfile, llAddress, llBankDetail, llDocumentUpload);
                        manageImages(llMyProfile, ivMyProfile, ivAddress, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etLastName.requestFocus();
                        etLastName.setError("Enter Last Name");
                        etLastName.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etLastName.requestFocus();
                        etLastName.setError("Enter Last Name");
                        return;
                    }
                }
                if (etDob.getText().toString().isEmpty()) {
                    if (llMyProfile.getVisibility() == View.GONE) {
                        manageMainLayouts(llMyProfile, llAddress, llBankDetail, llDocumentUpload);
                        manageImages(llMyProfile, ivMyProfile, ivAddress, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etDob.requestFocus();
                        etDob.setError("Enter Dob");
                        etDob.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etDob.requestFocus();
                        etDob.setError("Enter Dob");
                        return;
                    }
                }
                if (!isValidePhoneNumber(etMobileNo1)) {
                    if (llMyProfile.getVisibility() == View.GONE) {
                        manageMainLayouts(llMyProfile, llAddress, llBankDetail, llDocumentUpload);
                        manageImages(llMyProfile, ivMyProfile, ivAddress, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etMobileNo1.requestFocus();
                        etMobileNo1.setError("Enter Mobile1");
                        etMobileNo1.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etMobileNo1.requestFocus();
                        etMobileNo1.setError("Enter Mobile1");
                        return;
                    }
                }

                /*if (etMobileNo2.getText().toString().isEmpty()) {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etMobileNo2.requestFocus();
                        etMobileNo2.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etMobileNo2.requestFocus();
                        etMobileNo2.setError("Enter First Name");
                        return;
                    }
                }*/

                if (!isValideEmailID(etEmailId)) {
                    if (llMyProfile.getVisibility() == View.GONE) {
                        manageMainLayouts(llMyProfile, llAddress, llBankDetail, llDocumentUpload);
                        manageImages(llMyProfile, ivMyProfile, ivAddress, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etEmailId.requestFocus();
                        etEmailId.setError("Enter Email");
                        etEmailId.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etEmailId.requestFocus();
                        etEmailId.setError("Enter Email");
                        return;
                    }
                }
                if (etPan.getText().toString().isEmpty()) {
                    if (llMyProfile.getVisibility() == View.GONE) {
                        manageMainLayouts(llMyProfile, llAddress, llBankDetail, llDocumentUpload);
                        manageImages(llMyProfile, ivMyProfile, ivAddress, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etPan.requestFocus();
                        etPan.setError("Enter Pan No.");
                        etPan.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etPan.requestFocus();
                        etPan.setError("Enter Pan No.");
                        return;
                    }
                }
                if (etAadhar.getText().toString().isEmpty()) {
                    if (llMyProfile.getVisibility() == View.GONE) {
                        manageMainLayouts(llMyProfile, llAddress, llBankDetail, llDocumentUpload);
                        manageImages(llMyProfile, ivMyProfile, ivAddress, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etAadhar.requestFocus();
                        etAadhar.setError("Enter Aadhar");
                        etAadhar.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etPan.requestFocus();
                        etAadhar.setError("Enter Aadhar");
                        return;
                    }
                }

                //endregion

                setProfileDetails();

                isPospInfo = true;
                if (isPospInfo) {
                    manageMainLayouts(llAddress, llMyProfile, llBankDetail, llDocumentUpload);
                    manageImages(llAddress, ivAddress, ivMyProfile, ivBankDetail, ivDocumentUpload);
                }

                break;
            case R.id.ivBankDetail:
            case R.id.rlBankDetail:

                //region address validation
                if (etAddress1.getText().toString().isEmpty()) {
                    if (llAddress.getVisibility() == View.GONE) {
                        manageMainLayouts(llAddress, llMyProfile, llBankDetail, llDocumentUpload);
                        manageImages(llAddress, ivAddress, ivMyProfile, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etAddress1.requestFocus();
                        etAddress1.setError("Enter Address 1");
                        etAddress1.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etAddress1.requestFocus();
                        etAddress1.setError("Enter Address 1");
                        return;
                    }
                }

                if (etAddress2.getText().toString().isEmpty()) {
                    if (llAddress.getVisibility() == View.GONE) {
                        manageMainLayouts(llAddress, llMyProfile, llBankDetail, llDocumentUpload);
                        manageImages(llAddress, ivAddress, ivMyProfile, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etAddress2.requestFocus();
                        etAddress2.setError("Enter Address 1");
                        etAddress2.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etAddress2.requestFocus();
                        etAddress2.setError("Enter Address 1");
                        return;
                    }
                }
                if (etPincode.getText().toString().isEmpty()) {
                    if (llAddress.getVisibility() == View.GONE) {
                        manageMainLayouts(llAddress, llMyProfile, llBankDetail, llDocumentUpload);
                        manageImages(llAddress, ivAddress, ivMyProfile, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etPincode.requestFocus();
                        etPincode.setError("Enter Pincode");
                        etPincode.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etPincode.requestFocus();
                        etPincode.setError("Enter Pincode");
                        return;
                    }

                }
                if (!etPincode.getText().toString().isEmpty()) {
                    if (etPincode.getText().toString().length() != 6) {
                        if (llAddress.getVisibility() == View.GONE) {
                            manageMainLayouts(llAddress, llMyProfile, llBankDetail, llDocumentUpload);
                            manageImages(llAddress, ivAddress, ivMyProfile, ivBankDetail, ivDocumentUpload);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            etPincode.requestFocus();
                            etPincode.setError("Enter Pincode");
                            etPincode.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                            return;
                        } else {
                            etPincode.requestFocus();
                            etPincode.setError("Enter Pincode");
                            return;
                        }
                    }

                }
                if (etCity.getText().toString().isEmpty()) {
                    if (llAddress.getVisibility() == View.GONE) {
                        manageMainLayouts(llAddress, llMyProfile, llBankDetail, llDocumentUpload);
                        manageImages(llAddress, ivAddress, ivMyProfile, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etCity.requestFocus();
                        etCity.setError("Enter City");
                        etCity.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etCity.requestFocus();
                        etCity.setError("Enter City");
                        return;
                    }
                }
                if (etState.getText().toString().isEmpty()) {
                    if (llAddress.getVisibility() == View.GONE) {
                        manageMainLayouts(llAddress, llMyProfile, llBankDetail, llDocumentUpload);
                        manageImages(llAddress, ivAddress, ivMyProfile, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etState.requestFocus();
                        etState.setError("Enter State");
                        etState.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etState.requestFocus();
                        etState.setError("Enter State");
                        return;
                    }
                }
                //endregion

                setAddressDetails();

                isAddress = true;
                if (isPospInfo && isAddress) {
                    manageMainLayouts(llBankDetail, llMyProfile, llAddress, llDocumentUpload);
                    manageImages(llBankDetail, ivBankDetail, ivAddress, ivMyProfile, ivDocumentUpload);
                }
                break;
            case R.id.ivDocumentUpload:
            case R.id.rlDocumentUpload:

                //region bank validation
                if (etAddress1.getText().toString().isEmpty()) {
                    if (llAddress.getVisibility() == View.GONE) {
                        manageMainLayouts(llAddress, llMyProfile, llBankDetail, llDocumentUpload);
                        manageImages(llAddress, ivAddress, ivMyProfile, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etAddress1.requestFocus();
                        etAddress1.setError("Enter Address 1");
                        etAddress1.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etAddress1.requestFocus();
                        etAddress1.setError("Enter Address 1");
                        return;
                    }
                }

                if (etAddress2.getText().toString().isEmpty()) {
                    if (llAddress.getVisibility() == View.GONE) {
                        manageMainLayouts(llAddress, llMyProfile, llBankDetail, llDocumentUpload);
                        manageImages(llAddress, ivAddress, ivMyProfile, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etAddress2.requestFocus();
                        etAddress2.setError("Enter Address 1");
                        etAddress2.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etAddress2.requestFocus();
                        etAddress2.setError("Enter Address 1");
                        return;
                    }
                }
                if (etPincode.getText().toString().isEmpty()) {
                    if (llAddress.getVisibility() == View.GONE) {
                        manageMainLayouts(llAddress, llMyProfile, llBankDetail, llDocumentUpload);
                        manageImages(llAddress, ivAddress, ivMyProfile, ivBankDetail, ivDocumentUpload);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        etPincode.requestFocus();
                        etPincode.setError("Enter Pincode");
                        etPincode.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        return;
                    } else {
                        etPincode.requestFocus();
                        etPincode.setError("Enter Pincode");
                        return;
                    }

                }
                if (!etPincode.getText().toString().isEmpty()) {
                    if (etPincode.getText().toString().length() != 6) {
                        if (llAddress.getVisibility() == View.GONE) {
                            manageMainLayouts(llAddress, llMyProfile, llBankDetail, llDocumentUpload);
                            manageImages(llAddress, ivAddress, ivMyProfile, ivBankDetail, ivDocumentUpload);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            etPincode.requestFocus();
                            etPincode.setError("Enter Pincode");
                            etPincode.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                            return;
                        } else {
                            etPincode.requestFocus();
                            etPincode.setError("Enter Pincode");
                            return;
                        }
                    }

                }
                //endregion
                isBankDetails = true;
                if (isPospInfo && isAddress && isBankDetails) {
                    manageMainLayouts(llDocumentUpload, llBankDetail, llMyProfile, llAddress);
                    manageImages(llDocumentUpload, ivDocumentUpload, ivBankDetail, ivAddress, ivMyProfile);
                }
                break;

            case R.id.tvMale:
                isMale = true;
                tvMale.setBackgroundResource(R.drawable.customeborder_blue);
                tvFemale.setBackgroundResource(R.drawable.customeborder);
                break;
            case R.id.tvFemale:
                isMale = false;
                tvMale.setBackgroundResource(R.drawable.customeborder);
                tvFemale.setBackgroundResource(R.drawable.customeborder_blue);
                break;
            case R.id.txtSaving:
                setSavingAcc();
                break;
            case R.id.txtCurrent:
                setCurrentAcc();
                break;
            case R.id.btnSave:
                break;
        }
    }

    private void setAddressDetails() {
    }

    private void setProfileDetails() {
    }

    private void setSavingAcc() {
        ACCOUNT_TYPE = "SAVING";
        txtSaving.setBackgroundResource(R.drawable.customeborder_blue);
        txtSaving.setTextColor(ContextCompat.getColor(PospEnrollment.this, R.color.colorPrimary));

        txtCurrent.setBackgroundResource(R.drawable.customeborder);
        txtCurrent.setTextColor(ContextCompat.getColor(PospEnrollment.this, R.color.description_text));


    }

    private void setCurrentAcc() {
        ACCOUNT_TYPE = "CURRENT";
        txtCurrent.setBackgroundResource(R.drawable.customeborder_blue);
        txtCurrent.setTextColor(ContextCompat.getColor(PospEnrollment.this, R.color.colorPrimary));

        txtSaving.setBackgroundResource(R.drawable.customeborder);
        txtSaving.setTextColor(ContextCompat.getColor(PospEnrollment.this, R.color.description_text));


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
            downImage.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));
            upImage1.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));
            upImage2.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));
            upImage3.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));
        } else {
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

            linearLayout.setVisibility(View.VISIBLE);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));

        } else {
            linearLayout.setVisibility(View.GONE);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        if (response instanceof PincodeResponse) {
            cancelDialog();
            if (response.getStatusNo() == 0) {
                Constants.hideKeyBoard(etPincode, this);
                etState.setText("" + ((PincodeResponse) response).getMasterData().getState_name());
                etCity.setText("" + ((PincodeResponse) response).getMasterData().getCityname());

                /*registerRequestEntity.setCity("" + ((PincodeResponse) response).getMasterData().getCityname());
                registerRequestEntity.setState("" + ((PincodeResponse) response).getMasterData().getState_name());
                registerRequestEntity.setStateID("" + ((PincodeResponse) response).getMasterData().getStateid());*/

            }
        } else if (response instanceof IfscCodeResponse) {
            cancelDialog();
            if (response.getStatusNo() == 0) {
                Constants.hideKeyBoard(etPincode, this);

                IfscEntity ifscEntity = ((IfscCodeResponse) response).getMasterData().get(0);

                etIfscCode.setText("" + ifscEntity.getIFSCCode());
                erMicrCode.setText("" + ifscEntity.getMICRCode());
                etBankName.setText("" + ifscEntity.getBankName());
                etBankBranch.setText("" + ifscEntity.getBankName());
                etBankCity.setText("" + ifscEntity.getCityName());

                erMicrCode.setSelection(erMicrCode.getText().length());


                registerRequestEntity.setLoan_BankName("" + ifscEntity.getBankName());
                registerRequestEntity.setLoan_BankBranch("" + ifscEntity.getBankBran());
                registerRequestEntity.setLoan_IFSC("" + ifscEntity.getIFSCCode());
                registerRequestEntity.setLoan_IFSC("" + ifscEntity.getIFSCCode());

            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {

    }


    //region datepicker
    protected View.OnClickListener datePickerDialog = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            Constants.hideKeyBoard(view, PospEnrollment.this);

            //region manufacture date
            if (view.getId() == R.id.etDob) {
                DateTimePicker.showHealthAgeDatePicker(view.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                                if (view1.isShown()) {
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.set(year, monthOfYear, dayOfMonth);
                                    String currentDay = simpleDateFormat.format(calendar.getTime());
                                    etDob.setText(currentDay);
                                }
                            }
                        });
            }
            //endregion

        }
    };
    //endregion

    private void settingWebview() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportMultipleWindows(false);

        settings.setLoadsImagesAutomatically(true);
        settings.setLightTouchEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);


        MyWebViewClient webViewClient = new MyWebViewClient(this);
        webView.setWebViewClient(webViewClient);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // TODO show you progress image
                showDialog();
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // TODO hide your progress image
                cancelDialog();
                if (count == 0) {
                    count++;
                    view.loadUrl("javascript: (function() {document.getElementById('ctl00_ContentPlaceHolder1_tbPAN').value= '" + etPan.getText().toString().toUpperCase() + "';}) ();");

                    view.loadUrl("javascript: (function() {document.getElementById('ctl00_ContentPlaceHolder1_btnView').click();}) ();");

                } else {
                    //view.LoadUrl("javascript: (function() {window.JsHtmlOut.processHTML(document.getElementById('ctl00_ContentPlaceHolder1_lblError').innerHTML);}) ();");
                    view.loadUrl("javascript:window.JsHtmlOut.ProcessHTML(document.getElementById('ctl00_ContentPlaceHolder1_lblError').innerHTML);");
                    count = 0;
                }
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        webView.getSettings().setBuiltInZoomControls(true);
        webView.addJavascriptInterface(new MyJavaScriptInterface(), "JsHtmlOut");

        Log.d("URL", URL);
        webView.loadUrl(URL);
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {

        switch (view.getId()) {
            case R.id.etIfscCode:
                if (!hasFocus) {
                    if (etIfscCode.getText().length() > 3) {
                        showDialog("Fetching Bank Details...");
                        new RegisterController(PospEnrollment.this).getIFSC(etIfscCode.getText().toString(), PospEnrollment.this);
                    }
                }
                break;
            case R.id.etPan:
                if (!hasFocus) {
                    if (etPan.getText().length() > 3) {
                        settingWebview();
                    }
                }
                break;
        }
    }

    class MyJavaScriptInterface {
        @JavascriptInterface
        @SuppressWarnings("unused")
        public void ProcessHTML(String html) {
            Log.d("HTML", html);
            if (html.toLowerCase().contains("not")) {

            } else {
                showPopUp("ERROR MESSAGE", "Pan No. Already Registered in IRDA", "OK", true);
                //Toast.makeText(PospEnrollment.this, "Pan Card Already Registered in IRDA", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showPopUp(String title, String message, String buttonName, boolean isCancelable) {

        try {
            final Dialog dialog;
            dialog = new Dialog(PospEnrollment.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.layout_pancard_popup);

            TextView tvTitle = (TextView) dialog.findViewById(R.id.tvTitle);
            tvTitle.setText(title);
            TextView tvOk = (TextView) dialog.findViewById(R.id.tvOk);
            tvOk.setText(buttonName);
            TextView txtMessage = (TextView) dialog.findViewById(R.id.txtMessage);
            txtMessage.setText(message);


            dialog.setCancelable(isCancelable);
            dialog.setCanceledOnTouchOutside(isCancelable);

            Window dialogWindow = dialog.getWindow();
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = lp.MATCH_PARENT;
            ; // Width
            lp.height = lp.WRAP_CONTENT; // Height
            dialogWindow.setAttributes(lp);

            dialog.show();
            tvOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    dialog.cancel();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
