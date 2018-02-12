package com.datacomp.magicfinmart.motor.privatecar.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
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
    EditText etElecAcc, etNonElecAcc;
    Spinner spPaCover, spVolExcessAmt;
    Switch swlldriver, swAnti, swMemAto, swPaidPa;
    TextView tvLiabYes, tvLiabNo, tvAntiYes, tvAntiNo;
    boolean isLiability = false, isAntiTheft = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_quote);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFinishOnTouchOutside(true);
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

        spVolExcessAmt = (Spinner) findViewById(R.id.spVolExcessAmt);
        tvLiabYes = (TextView) findViewById(R.id.tvLiabYes);
        tvLiabNo = (TextView) findViewById(R.id.tvLiabNo);
        tvAntiYes = (TextView) findViewById(R.id.tvAntiYes);
        tvAntiNo = (TextView) findViewById(R.id.tvAntiNo);

        spPaCover = (Spinner) findViewById(R.id.spPaCover);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tvAntiNo:
                isAntiTheft = false;
                tvAntiNo.setBackgroundResource(R.drawable.customeborder_blue);
                tvAntiYes.setBackgroundResource(R.drawable.customeborder);
                break;
            case R.id.tvAntiYes:
                isAntiTheft = true;
                tvAntiNo.setBackgroundResource(R.drawable.customeborder);
                tvAntiYes.setBackgroundResource(R.drawable.customeborder_blue);
                break;

            case R.id.tvLiabNo:
                isLiability = false;
                tvLiabNo.setBackgroundResource(R.drawable.customeborder_blue);
                tvLiabYes.setBackgroundResource(R.drawable.customeborder);
                break;
            case R.id.tvLiabYes:
                isLiability = true;
                tvLiabNo.setBackgroundResource(R.drawable.customeborder);
                tvLiabYes.setBackgroundResource(R.drawable.customeborder_blue);
                break;

            case R.id.ivCross:
                finish();
                break;
            case R.id.applyNow:
                if (!etElecAcc.getText().toString().isEmpty()) {
                    int elec = Integer.parseInt(etElecAcc.getText().toString());
                    if (elec < 10000 || elec > 50000) {
                        etElecAcc.requestFocus();
                        etElecAcc.setError("Enter Amount between 10000 & 50000");
                        return;
                    }
                }
                if (!etNonElecAcc.getText().toString().isEmpty()) {
                    int nonElec = Integer.parseInt(etNonElecAcc.getText().toString());
                    if (nonElec < 10000 || nonElec > 50000) {
                        etNonElecAcc.requestFocus();
                        etNonElecAcc.setError("Enter Amount between 10000 & 50000");
                        return;
                    }
                }

                addparameters();
                showDialog("Modifying quotes...");
                new MotorController(this).getMotorPremiumInitiate(motorRequestEntity, this);
                break;

        }
    }

    private void addparameters() {

        if (isLiability) {
            motorRequestEntity.setIs_llpd("yes");
        } else {
            motorRequestEntity.setIs_llpd("no");
        }

        if (isAntiTheft) {
            motorRequestEntity.setIs_antitheft_fit("yes");
        } else {
            motorRequestEntity.setIs_antitheft_fit("no");
        }

        if (!etElecAcc.getText().toString().isEmpty())
            motorRequestEntity.setElectrical_accessory(etElecAcc.getText().toString());
        if (!etNonElecAcc.getText().toString().isEmpty())
            motorRequestEntity.setNon_electrical_accessory(etNonElecAcc.getText().toString());
        if (spVolExcessAmt.getSelectedItemPosition() != 0) {
            motorRequestEntity.setVoluntary_deductible(Integer.parseInt(spVolExcessAmt.getSelectedItem().toString()));
        }


        /*if (swMemAto.isChecked()) {
            motorRequestEntity.setIs_aai_member("yes");
        } else {
            motorRequestEntity.setIs_aai_member("no");
        }

        if (swPaidPa.isChecked()) {
            motorRequestEntity.setPa_paid_driver_si("yes");
        } else {
            motorRequestEntity.setPa_paid_driver_si("no");
        }*/
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof BikeUniqueResponse) {
            //startActivity(new Intent(this, QuoteActivity.class).putExtra("CAR_REQUEST", motorRequestEntity));

            Intent resultIntent = new Intent();
            resultIntent.putExtra("MODIFY", motorRequestEntity);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        }
    }


    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
