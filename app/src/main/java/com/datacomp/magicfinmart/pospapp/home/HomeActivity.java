package com.datacomp.magicfinmart.pospapp.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.exam.StartExamActivity;
import com.datacomp.magicfinmart.pospapp.studymaterial.StudyMaterialAvailable;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.login.LoginController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.LoginFacade;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.LoginEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.CertificateResponse;


public class HomeActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    TextView tvStartExam, tvStudyMaterial, tvMsg, tvCongrats;
    LoginEntity loginEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_posp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initialize();
        setListener();
        showProgressDialog();
        new LoginController(this).getCertificate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginEntity = new LoginFacade(this).getUser();
        if (loginEntity.isIsEligible()) {
            tvCongrats.setVisibility(View.VISIBLE);
            tvMsg.setText("You are now eligible for giving the evaluation");
            tvStartExam.setVisibility(View.VISIBLE);
        } else {
            tvMsg.setText("You are not eligible to give the evaluation now. You need to go through  the modules before attempting the evaluation. ");
            tvStartExam.setVisibility(View.GONE);
        }
    }

    private void initialize() {
        tvStartExam = (TextView) findViewById(R.id.tvStartExam);
        tvStudyMaterial = (TextView) findViewById(R.id.tvStudyMaterial);
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        tvCongrats = (TextView) findViewById(R.id.tvCongrats);
        sharedPreferences = getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    private void setListener() {
        tvStartExam.setOnClickListener(this);
        tvStudyMaterial.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvStartExam:
                startActivity(new Intent(HomeActivity.this, StartExamActivity.class));
                break;
            case R.id.tvStudyMaterial:
                startActivity(new Intent(HomeActivity.this, StudyMaterialAvailable.class));
                break;
        }

    }

    @Override
    public void OnSuccess(APIResponse response, String message) throws InterruptedException {
        dismissDialog();
        if (response instanceof CertificateResponse) {
            if (response.getStatusNo() == 0) {
                tvMsg.setText("You have already pass the Evaluation. You can view your certificate by tapping cerrtificate in navigation Menu.");
                tvStartExam.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        dismissDialog();

    }
}
