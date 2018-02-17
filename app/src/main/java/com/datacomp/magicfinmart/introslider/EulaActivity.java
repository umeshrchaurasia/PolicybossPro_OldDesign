package com.datacomp.magicfinmart.introslider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.login.LoginActivity;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters.MasterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.BikeMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CarMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CityMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.InsuranceMasterResponse;

public class EulaActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {
    Button btnAgree, btnDisAgree;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eula);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initWidgets();
        setListener();
        prefManager = new PrefManager(this);
        if (prefManager.IsBikeMasterUpdate())
            new MasterController(this).getBikeMaster(this);
        if (prefManager.IsCarMasterUpdate())
            new MasterController(this).getCarMaster(this);
        if (prefManager.IsRtoMasterUpdate())
            new MasterController(this).getRTOMaster(this);
        if (prefManager.IsInsuranceMasterUpdate())
            new MasterController(this).getInsuranceMaster(this);
    }

    private void initWidgets() {
        btnAgree = (Button) findViewById(R.id.btnAgree);
        btnDisAgree = (Button) findViewById(R.id.btnDisAgree);
    }

    private void setListener() {
        btnAgree.setOnClickListener(this);
        btnDisAgree.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAgree:
                if (checkAllMastersIsUpdate()) {
                    startActivity(new Intent(this, LoginActivity.class));
                }else{
                    Toast.makeText(this, "Server Down Try After some time", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnDisAgree:
                break;
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        if (response instanceof BikeMasterResponse) {
            if (checkAllMastersIsUpdate()) {
                startActivity(new Intent(EulaActivity.this, LoginActivity.class));
            }
        } else if (response instanceof CarMasterResponse) {
            if (checkAllMastersIsUpdate()) {
                startActivity(new Intent(EulaActivity.this, LoginActivity.class));
            }
        } else if (response instanceof CityMasterResponse) {
            if (checkAllMastersIsUpdate()) {
                startActivity(new Intent(EulaActivity.this, LoginActivity.class));
            }
        } else if (response instanceof InsuranceMasterResponse) {
            if (checkAllMastersIsUpdate()) {
                startActivity(new Intent(EulaActivity.this, LoginActivity.class));
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public boolean checkAllMastersIsUpdate() {
        if (prefManager.IsBikeMasterUpdate())
            return false;
        else if (prefManager.IsCarMasterUpdate())
            return false;
        else if (prefManager.IsRtoMasterUpdate())
            return false;
        else if (prefManager.IsInsuranceMasterUpdate())
            return false;

        return true;
    }
}
