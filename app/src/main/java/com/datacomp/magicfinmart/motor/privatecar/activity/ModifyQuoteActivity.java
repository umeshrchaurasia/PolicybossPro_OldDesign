package com.datacomp.magicfinmart.motor.privatecar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.motor.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.motor.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.motor.controller.MotorController;
import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.MotorRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.motor.response.BikeUniqueResponse;

public class ModifyQuoteActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {
    MotorRequestEntity motorRequestEntity;
    ImageView ivCross;
    Button applyNow;
    EditText etElecAcc, etNonElecAcc, etExpIdv;
    Spinner spUnNamedPa, spNamedPa, spVolExcessAmt;
    Switch swlldriver, swAnti, swMemAto, swPaidPa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_quote);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFinishOnTouchOutside(false);
        if (getIntent().hasExtra("CAR_REQUEST")) {
            motorRequestEntity = getIntent().getParcelableExtra("CAR_REQUEST");
        }
        initWidgets();
        setListener();
    }

    private void setListener() {
        applyNow.setOnClickListener(this);
        ivCross.setOnClickListener(this);
    }

    private void initWidgets() {
        ivCross = (ImageView) findViewById(R.id.ivCross);
        applyNow = (Button) findViewById(R.id.applyNow);

        etElecAcc = (EditText) findViewById(R.id.etElecAcc);
        etNonElecAcc = (EditText) findViewById(R.id.etNonElecAcc);
        etExpIdv = (EditText) findViewById(R.id.etExpIdv);

        spUnNamedPa = (Spinner) findViewById(R.id.spUnNamedPa);
        spNamedPa = (Spinner) findViewById(R.id.spNamedPa);
        spVolExcessAmt = (Spinner) findViewById(R.id.spVolExcessAmt);

        swlldriver = (Switch) findViewById(R.id.swlldriver);
        swAnti = (Switch) findViewById(R.id.swAnti);
        swMemAto = (Switch) findViewById(R.id.swMemAto);
        swPaidPa = (Switch) findViewById(R.id.swPaidPa);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCross:
                finish();
                break;
            case R.id.applyNow:
                addparameters();
                showDialog();
                new MotorController(this).getMotorPremiumInitiate(motorRequestEntity, this);
                break;

        }
    }

    private void addparameters() {

        if (swlldriver.isChecked()) {
            motorRequestEntity.setIs_llpd("yes");
        } else {
            motorRequestEntity.setIs_llpd("no");
        }

        if (swAnti.isChecked()) {
            motorRequestEntity.setIs_antitheft_fit("yes");
        } else {
            motorRequestEntity.setIs_antitheft_fit("no");
        }

        if (swMemAto.isChecked()) {
            motorRequestEntity.setIs_aai_member("yes");
        } else {
            motorRequestEntity.setIs_aai_member("no");
        }

        if (swPaidPa.isChecked()) {
            motorRequestEntity.setPa_paid_driver_si("yes");
        } else {
            motorRequestEntity.setPa_paid_driver_si("no");
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof BikeUniqueResponse) {
            startActivity(new Intent(this, QuoteActivity.class).putExtra("CAR_REQUEST", motorRequestEntity));
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
