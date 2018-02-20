package com.datacomp.magicfinmart.posp;

import android.app.DatePickerDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register.RegisterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PincodeResponse;

/**
 * Created by daniyalshaikh on 11/01/18.
 */

public class PospEnrollment extends BaseActivity implements View.OnClickListener, IResponseSubcriber {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    LinearLayout llMyProfile, llAddress, llBankDetail, llDocumentUpload;
    ImageView ivMyProfile, ivAddress, ivBankDetail, ivDocumentUpload;
    RelativeLayout rlMyProfile, rlAddress, rlBankDetail, rlDocumentUpload;

    boolean isPospInfo, isAddress, isBankDetails, isDocumentsUpload, isMale;

    //region inputs
    EditText etFirstName, etLastName, etDob, etMobileNo1, etMobileNo2,
            etEmailId, etPan, etAadhar, etGST, etChannelPartner;
    TextView tvMale, tvFemale;

    //region address
    EditText etAddress1, etAddress2, etAddress3, etPincode, etCity, etState;

    //region bank details
    EditText etBankAcNo, etAccountType, etIfscCode, erMicrCode, etBankBranch, etBankCity;
    Spinner spBankName;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posp_enrollment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

        tvFemale.setOnClickListener(this);
        tvMale.setOnClickListener(this);
        btnSave.setOnClickListener(this);
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

        //region POSP INFORMATION
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etDob = (EditText) findViewById(R.id.etDob);
        etMobileNo1 = (EditText) findViewById(R.id.etMobileNo1);
        etMobileNo2 = (EditText) findViewById(R.id.etMobileNo2);
        etEmailId = (EditText) findViewById(R.id.etEmailId);
        etPan = (EditText) findViewById(R.id.etPan);
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

                isPospInfo = true;
                if (isPospInfo) {
                    manageMainLayouts(llAddress, llMyProfile, llBankDetail, llDocumentUpload);
                    manageImages(llAddress, ivAddress, ivMyProfile, ivBankDetail, ivDocumentUpload);

                }

                break;
            case R.id.ivBankDetail:
            case R.id.rlBankDetail:
                manageMainLayouts(llBankDetail, llMyProfile, llAddress, llDocumentUpload);
                manageImages(llBankDetail, ivBankDetail, ivAddress, ivMyProfile, ivDocumentUpload);
                break;
            case R.id.ivDocumentUpload:
            case R.id.rlDocumentUpload:
                manageMainLayouts(llDocumentUpload, llBankDetail, llMyProfile, llAddress);
                manageImages(llDocumentUpload, ivDocumentUpload, ivBankDetail, ivAddress, ivMyProfile);

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
            case R.id.btnSave:
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
}
