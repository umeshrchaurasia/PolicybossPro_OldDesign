package com.datacomp.magicfinmart.register;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.register.adapters.MultiSelectionSpinner;
import com.datacomp.magicfinmart.utility.GenericTextWatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register.RegisterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.GenerateOtpResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PincodeResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.VerifyOtpResponse;

public class RegisterActivity extends BaseActivity implements View.OnClickListener, GenericTextWatcher.iVehicle, IResponseSubcriber, MultiSelectionSpinner.OnMultipleItemsSelectedListener, CompoundButton.OnCheckedChangeListener {

    LinearLayout llPersonalInfo, llProfessionalInfo;
    ImageView ivProfessionalInfo, ivPersonalInfo;
    RelativeLayout rlPersonalInfo, rlProfessionalInfo;
    EditText etFirstName, etLastName, etDob, etMobile1, etMobile2, etEmail, etConfirmEmail,
            etPincode, etCity, etState, etOtp;
    ImageView ivMale, ivFemale;
    Dialog dialog;
    ArrayList<String> healthList, generalList, lifeList;
    DBPersistanceController dbPersistanceController;
    MultiSelectionSpinner spLifeIns, spGenIns, spHealthIns;
    CheckBox chbxLife, chbxGen, chbxHealth, chbxMutual, chbxStocks, chbxPostal, chbxBonds;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbPersistanceController = new DBPersistanceController(this);
        initWidgets();
        setListener();
        initLayouts();
        healthList = dbPersistanceController.getHealthListNames();
        generalList = dbPersistanceController.getGeneralListNames();
        lifeList = dbPersistanceController.getLifeListNames();
        initMultiSelect();

    }

    private void initMultiSelect() {


        spLifeIns.setItems(lifeList);
        //spLifeIns.setSelection(new int[]{2, 6});
        spLifeIns.setListener(this);


        spGenIns.setItems(generalList);
        //spLifeIns.setSelection(new int[]{2, 6});
        spGenIns.setListener(this);


        spHealthIns.setItems(healthList);
        //spLifeIns.setSelection(new int[]{2, 6});
        spHealthIns.setListener(this);


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
                    etOtp.setText(otp);
                }
            }
        }
    };
    //endregion

    private void initLayouts() {
        llPersonalInfo.setVisibility(View.VISIBLE);
        llProfessionalInfo.setVisibility(View.GONE);
        hideAllLayouts(llPersonalInfo, ivPersonalInfo);
        spLifeIns.setEnabled(false);
        spGenIns.setEnabled(false);
        spHealthIns.setEnabled(false);

    }

    private void setListener() {
        ivProfessionalInfo.setOnClickListener(this);
        ivPersonalInfo.setOnClickListener(this);
        rlPersonalInfo.setOnClickListener(this);
        rlProfessionalInfo.setOnClickListener(this);
        etMobile1.addTextChangedListener(new GenericTextWatcher(etMobile1, this));
        etPincode.addTextChangedListener(new GenericTextWatcher(etPincode, this));
        chbxGen.setOnCheckedChangeListener(this);
        chbxHealth.setOnCheckedChangeListener(this);
        chbxLife.setOnCheckedChangeListener(this);
    }

    private void initWidgets() {
        spLifeIns = (MultiSelectionSpinner) findViewById(R.id.spLifeIns);
        spGenIns = (MultiSelectionSpinner) findViewById(R.id.spGenIns);
        spHealthIns = (MultiSelectionSpinner) findViewById(R.id.spHealthIns);

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


        chbxLife = (CheckBox) findViewById(R.id.chbxLife);
        chbxGen = (CheckBox) findViewById(R.id.chbxGen);
        chbxHealth = (CheckBox) findViewById(R.id.chbxHealth);
        chbxMutual = (CheckBox) findViewById(R.id.chbxMutual);
        chbxStocks = (CheckBox) findViewById(R.id.chbxStocks);
        chbxPostal = (CheckBox) findViewById(R.id.chbxPostal);
        chbxBonds = (CheckBox) findViewById(R.id.chbxBonds);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
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
            if (response.getStatusNo() == 0) {
                showOtpAlert();
            } else {
                Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        if (response instanceof PincodeResponse) {

            if (response.getStatusNo() == 0) {

            }
            Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (response instanceof VerifyOtpResponse) {
            cancelDialog();
            if (response.getStatusNo() == 0) {
                if (dialog != null)
                    dialog.dismiss();
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
            TextView tvTitle = (TextView) dialog.findViewById(R.id.tvTitle);
            tvTitle.setText("Enter OTP sent on : " + etMobile1.getText().toString());
            TextView resend = (TextView) dialog.findViewById(R.id.tvResend);
            etOtp = (EditText) dialog.findViewById(R.id.etOtp);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);

            Window dialogWindow = dialog.getWindow();
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = lp.MATCH_PARENT;
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

    @Override
    public void selectedIndices(List<Integer> indices) {

    }

    @Override
    public void selectedStrings(List<String> strings) {
        //Toast.makeText(this, strings.toString(), Toast.LENGTH_LONG).show();
        int[] temp = dbPersistanceController.getLifeListId(strings);
        Log.d("RegisterActivity","test");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.chbxGen:
                if (b) {
                    spGenIns.setEnabled(true);
                } else {
                    spGenIns.setEnabled(false);
                }
                break;
            case R.id.chbxHealth:
                if (b) {
                    spHealthIns.setEnabled(true);
                } else {
                    spHealthIns.setEnabled(false);
                }
                break;
            case R.id.chbxLife:
                if (b) {
                    spLifeIns.setEnabled(true);
                } else {
                    spLifeIns.setEnabled(false);
                }
                break;
        }
    }
}