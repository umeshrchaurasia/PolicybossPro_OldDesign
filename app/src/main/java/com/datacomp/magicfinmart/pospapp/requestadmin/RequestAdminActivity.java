package com.datacomp.magicfinmart.pospapp.requestadmin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.home.MainActivity;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;
import com.datacomp.magicfinmart.pospapp.utility.ReadDeviceID;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.login.LoginController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.LoginRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.LoginResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.SendAdminResponse;


public class RequestAdminActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {

    TextInputEditText tieName, tieEmail;
    Button btnSubmit;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        email = getIntent().getStringExtra("EMAIL");
        initialize();
        setListeners();
    }

    private void initialize() {
        tieEmail = (TextInputEditText) findViewById(R.id.tieEmail);
        tieEmail.setText(email);
        tieName = (TextInputEditText) findViewById(R.id.tieName);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
    }

    private void setListeners() {
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) throws InterruptedException {
        if (response instanceof SendAdminResponse) {
            if (response.getStatusNo() == 0) {
                LoginRequestEntity loginRequestEntity = new LoginRequestEntity();
                loginRequestEntity.setEmail(tieEmail.getText().toString().trim());
                loginRequestEntity.setPassword("");
                loginRequestEntity.setDeviceId(new ReadDeviceID(RequestAdminActivity.this).getAndroidID());
                loginRequestEntity.setDeviceToken("DEVICE_TOKEN");
                loginRequestEntity.setIP("");
                loginRequestEntity.setFBAId(new DBPersistanceController(this).getUserData().getFBAId());
                new LoginController(RequestAdminActivity.this).loginByFBAId(loginRequestEntity, this);
            }
            Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
        } else if (response instanceof LoginResponse) {
            if (response.getStatusNo() == 0) {

                finish();
                startActivity(new Intent(this, MainActivity.class));
            } /*else if (response.getStatusNo() == 3) {
                if (response.getMessage().contains("already")) {
                    tvRqstAdmin.setVisibility(View.VISIBLE);
                }
                txtMessage.setVisibility(View.VISIBLE);
                txtMessage.setText(response.getMessage());
                //Snackbar.make(txtForgotPass, "" + response.getMessage(), Snackbar.LENGTH_LONG).show();
            }*/ else if (response.getStatusNo() == 1) {
                showAlert(response.getMessage());
            }
        }
    }

    private void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(RequestAdminActivity.this);
        builder.setTitle("Please Contact FSM");
        builder.setMessage(message);
        builder.setCancelable(false);

        builder.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder.create();
        alert11.show();
    }

    @Override
    public void OnFailure(Throwable t) {
        dismissDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                if (tieEmail.getText().toString().equals("")) {
                    tieEmail.setError("ENTER VALID USER NAME");
                    tieEmail.requestFocus();
                    return;
                }
                showProgressDialog();
                new LoginController(this).requestAdmin(tieEmail.getText().toString(), this);
                break;

        }
    }
}
