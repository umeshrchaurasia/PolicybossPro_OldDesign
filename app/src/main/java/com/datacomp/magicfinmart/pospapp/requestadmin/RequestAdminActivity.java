package com.datacomp.magicfinmart.pospapp.requestadmin;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.login.LoginController;
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
        dismissDialog();
        if (response instanceof SendAdminResponse) {
            if (response.getStatusNo() == 0) {
                finish();
            }
            Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
        }
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
