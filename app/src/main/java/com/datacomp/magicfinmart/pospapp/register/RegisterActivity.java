package com.datacomp.magicfinmart.pospapp.register;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.register.RegisterController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.RegisterRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.RegisterResponse;


public class RegisterActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {
    Spinner spUserType;
    Button btnRegister;
    TextInputEditText tieRePassword, tiePassword, tieMobile, tieEmail, tieName, tiePan, tieAdhar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_posp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initialize();
        setListeners();


    }

    private void initialize() {
        btnRegister = (Button) findViewById(R.id.btnRegister);
        spUserType = (Spinner) findViewById(R.id.spUserType);
        tieRePassword = (TextInputEditText) findViewById(R.id.tieRePassword);
        tiePassword = (TextInputEditText) findViewById(R.id.tiePassword);
        tieMobile = (TextInputEditText) findViewById(R.id.tieMobile);
        tieEmail = (TextInputEditText) findViewById(R.id.tieEmail);
        tieName = (TextInputEditText) findViewById(R.id.tieName);
        tiePan = (TextInputEditText) findViewById(R.id.tiePan);
        tieAdhar = (TextInputEditText) findViewById(R.id.tieAdhar);
    }

    private void setListeners() {
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:

                if (!validateEmailAddress(tieEmail)) {
                    tieEmail.setError("ENTER VALID EMAIL");
                    tieEmail.requestFocus();
                    return;
                }
                if (tieName.getText().toString().matches("")) {
                    tieName.setError("ENTER  NAME");
                    tieName.requestFocus();
                    return;
                }
                if (tieMobile.getText().toString().matches("") && tieMobile.getText().toString().trim().length() < 10) {
                    tieMobile.setError("ENTER VALID MOBILE");
                    tieMobile.requestFocus();
                    return;
                }
                if (!validatePassword(tiePassword)) {
                    tiePassword.setError("MINIMUM 6 CHARACTER REQUIRED");
                    tiePassword.requestFocus();
                    return;
                }
                if (!tieRePassword.getText().toString().matches(tiePassword.getText().toString())) {
                    tieRePassword.setError("PASWWORD NOT MATCHED");
                    tieRePassword.requestFocus();
                    return;
                }
                RegisterRequestEntity registerRequestEntity = new RegisterRequestEntity();
                registerRequestEntity.setFullName(tieName.getText().toString().trim());
                //registerRequestEntity.setPassword(tiePassword.getText().toString().trim());
                registerRequestEntity.setMobileNumber(Long.parseLong(tieMobile.getText().toString().trim()));
                registerRequestEntity.setEmail(tieEmail.getText().toString().trim());
                registerRequestEntity.setCategoryId(spUserType.getSelectedItemPosition() + 1);
                //registerRequestEntity.setDeviceToken("DEVICE_TOKEN");
                //registerRequestEntity.setDeviceId(new ReadDeviceID(RegisterActivity.this).getAndroidID());
                //registerRequestEntity.setReferanceId(0);
                //registerRequestEntity.setReferanceType("RB");
                registerRequestEntity.setADHAR(tieAdhar.getText().toString().trim());
                registerRequestEntity.setPAN(tiePan.getText().toString().trim());
                //registerRequestEntity.setRO("Mumbai");

                showProgressDialog();
                new RegisterController(RegisterActivity.this).register(registerRequestEntity, this);

                break;
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) throws InterruptedException {
        dismissDialog();

        if (response instanceof RegisterResponse) {

            if (response.getStatusNo() == 0) {
                Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        dismissDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
