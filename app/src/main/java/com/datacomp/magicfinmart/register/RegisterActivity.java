package com.datacomp.magicfinmart.register;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.GenericTextWatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register.RegisterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.GenerateOtpResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PincodeResponse;

public class RegisterActivity extends BaseActivity implements View.OnClickListener, GenericTextWatcher.iVehicle, IResponseSubcriber {

    LinearLayout llPersonalInfo, llProfessionalInfo;
    ImageView ivProfessionalInfo, ivPersonalInfo;
    RelativeLayout rlPersonalInfo, rlProfessionalInfo;
    EditText etFirstName, etLastName, etDob, etMobile1, etMobile2, etEmail, etConfirmEmail,
            etPincode, etCity, etState, etOtp;
    ImageView ivMale, ivFemale;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initWidgets();
        setListener();
        initLayouts();

    }


    @Override
    protected void onResume() {
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("otp"));
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    //region Broadcast Receiver
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("otp")) {
                String message = intent.getStringExtra("message");
                String otp = extractDigitFromMessage(message);
                if (!otp.equals("")) {
                    //etOtp.setText(otp);
                }
            }
        }
    };
    //endregion

    private void initLayouts() {
        llPersonalInfo.setVisibility(View.GONE);
        llProfessionalInfo.setVisibility(View.GONE);
        hideAllLayouts(llPersonalInfo, ivPersonalInfo);
    }

    private void setListener() {
        ivProfessionalInfo.setOnClickListener(this);
        ivPersonalInfo.setOnClickListener(this);
        rlPersonalInfo.setOnClickListener(this);
        rlProfessionalInfo.setOnClickListener(this);
        etMobile1.addTextChangedListener(new GenericTextWatcher(etMobile1, this));
        etPincode.addTextChangedListener(new GenericTextWatcher(etPincode, this));
    }

    private void initWidgets() {
        ivProfessionalInfo = (ImageView) findViewById(R.id.ivProfessionalInfo);
        ivPersonalInfo = (ImageView) findViewById(R.id.ivPersonalInfo);
        llPersonalInfo = (LinearLayout) findViewById(R.id.llPersonalInfo);
        llProfessionalInfo = (LinearLayout) findViewById(R.id.llProfessionalInfo);
        rlPersonalInfo = (RelativeLayout) findViewById(R.id.rlPersonalInfo);
        rlProfessionalInfo = (RelativeLayout) findViewById(R.id.rlProfessionalInfo);


        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etDob = (EditText) findViewById(R.id.etDob);
        etMobile1 = (EditText) findViewById(R.id.etMobile1);
        etMobile2 = (EditText) findViewById(R.id.etMobile2);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etConfirmEmail = (EditText) findViewById(R.id.etConfirmEmail);
        etPincode = (EditText) findViewById(R.id.etPincode);
        etCity = (EditText) findViewById(R.id.etCity);
        etState = (EditText) findViewById(R.id.etState);
        ivMale = (ImageView) findViewById(R.id.ivMale);
        ivFemale = (ImageView) findViewById(R.id.ivFemale);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivPersonalInfo:
            case R.id.rlPersonalInfo:
                hideAllLayouts(llPersonalInfo, ivPersonalInfo);
                break;
            case R.id.ivProfessionalInfo:
            case R.id.rlProfessionalInfo:
                hideAllLayouts(llProfessionalInfo, ivProfessionalInfo);
                break;
        }
    }

    private void hideAllLayouts(LinearLayout linearLayout, ImageView imageView) {

        if (linearLayout.getVisibility() == View.GONE) {

            //region hideall layout
            ivPersonalInfo.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));
            llPersonalInfo.setVisibility(View.GONE);

            ivProfessionalInfo.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));
            llProfessionalInfo.setVisibility(View.GONE);
            //endregion

            linearLayout.setVisibility(View.VISIBLE);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.up_arrow));

        } else {
            linearLayout.setVisibility(View.GONE);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.down_arrow));
        }
    }

    @Override
    public void getVehicleNumber(View view, String vehicleNo) {
        switch (view.getId()) {
            case R.id.etPincode:
                showDialog("Fetching City...");
                new RegisterController(this).getCityState(etPincode.getText().toString(), this);
                break;
            case R.id.etMobile1:
                showDialog("Sending otp...");
                new RegisterController(this).generateOtp(etMobile1.getText().toString(), this);
                break;
        }
    }

    @Override
    public void cancelVehicleNumber(View view) {

    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        if (response instanceof GenerateOtpResponse) {
            cancelDialog();
            Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (response instanceof PincodeResponse) {
            cancelDialog();
            if (response.getStatusNo() == 0) {

            }
            Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private String extractDigitFromMessage(String message) {
        //---This will match any 6 digit number in the message, can use "|" to lookup more possible combinations
        Pattern p = Pattern.compile("(|^)\\d{6}");
        try {
            if (message != null) {
                Matcher m = p.matcher(message);
                if (m.find()) {
                    return m.group(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private void showOtpAlert() {

        try {

            dialog = new Dialog(RegisterActivity.this);
            dialog.setContentView(R.layout.otp_dialog);
            TextView text = (TextView) dialog.findViewById(R.id.tvOk);
            TextView resend = (TextView) dialog.findViewById(R.id.tvResend);
            etOtp = (EditText) dialog.findViewById(R.id.etOtp);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);

            Window dialogWindow = dialog.getWindow();
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = lp.WRAP_CONTENT;
            ; // Width
            lp.height = lp.WRAP_CONTENT; // Height
            dialogWindow.setAttributes(lp);

            dialog.show();
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    if (etOtp.getText().toString().equals("0000")) {
                        Toast.makeText(RegisterActivity.this, "Otp Verified Success", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    } else {
                        showDialog("Verifying OTP...");
                        new RegisterController(RegisterActivity.this).validateOtp(etMobile1.getText().toString(), etOtp.getText().toString(), RegisterActivity.this);
                    }

                }
            });

            resend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    etOtp.setText("");
                    showDialog("Re-sending otp...");
                    new RegisterController(RegisterActivity.this).generateOtp(etMobile1.getText().toString(), RegisterActivity.this);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}