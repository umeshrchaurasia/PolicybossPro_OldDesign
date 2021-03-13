package com.policyboss.magicfinmart.loan_fm.MyBusinessLoan;


import androidx.appcompat.widget.Toolbar;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.policyboss.magicfinmart.BaseActivity;
import com.policyboss.magicfinmart.R;
import com.policyboss.magicfinmart.utility.Constants;
import com.google.android.material.snackbar.Snackbar;

import java.math.BigDecimal;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.homeloan.HomeLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.EmiCalculatorResponse;


public class EmiCalcActivity extends BaseActivity implements View.OnClickListener , IResponseSubcriber {
    Toolbar toolbar;
    EditText et_LoanAmount, et_rateofinterest, et_loantensure;
    Button btnSubmit;
    TextView textViewloanemi,tvtotalpayint,tvtotalpayment,textView12;
    LinearLayout layoutresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_calc);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        initialize();
    }
    private void initialize() {
        et_LoanAmount = (EditText) findViewById(R.id.et_LoanAmount);
        et_rateofinterest = (EditText) findViewById(R.id.et_rateofinterest);
        et_loantensure = (EditText) findViewById(R.id.et_loantensure);
        textViewloanemi = (TextView) findViewById(R.id.textViewloanemi);
        tvtotalpayint = (TextView) findViewById(R.id.tvtotalpayint);
        tvtotalpayment = (TextView) findViewById(R.id.tvtotalpayment);
        layoutresult  = (LinearLayout)findViewById(R.id.layoutresult);
        textView12= (TextView) findViewById(R.id.textView12);
        textView12.setPaintFlags(textView12.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_submit) {
          //  Utility.hideKeyBoard(view, EmiCalcActivity.this);
            Constants.hideKeyBoard(et_LoanAmount,EmiCalcActivity.this);
            if (et_LoanAmount.getText().toString().matches("")) {
                Snackbar.make(et_LoanAmount, "Enter Loan Amount", Snackbar.LENGTH_LONG).show();
                return;
            }
            if (et_rateofinterest.getText().toString().matches("")) {
                Snackbar.make(et_rateofinterest, "Enter Rate of Interest", Snackbar.LENGTH_LONG).show();
                return;
            }
            if (et_loantensure.getText().toString().matches("")) {
                Snackbar.make(et_loantensure, "Enter Loan Tenure", Snackbar.LENGTH_LONG).show();
                return;
            }
            showDialog();
            new HomeLoanController(this).getEmicalculatordata(et_LoanAmount.getText().toString(), et_rateofinterest.getText().toString(), et_loantensure.getText().toString(), EmiCalcActivity.this);


        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof EmiCalculatorResponse) {
            if (response.getStatus_Id() == 0) {
                layoutresult.setVisibility(View.VISIBLE);



                textViewloanemi.setText("" + "\u20B9" + BigDecimal.valueOf(((EmiCalculatorResponse)response).getData().getAmount()).toPlainString());
                tvtotalpayint.setText("" + "\u20B9"+ BigDecimal.valueOf(((EmiCalculatorResponse)response).getData().getTotal()).toPlainString());
                tvtotalpayment.setText("" + "\u20B9" + BigDecimal.valueOf(((EmiCalculatorResponse)response).getData().getTtl_payment()).toPlainString());

                //   Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
                //   finish();
            }
            //  Snackbar.make(et_LoanAmount, response.getMessage(), Snackbar.LENGTH_SHORT).show();

        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Snackbar.make(et_LoanAmount, t.getMessage(), Snackbar.LENGTH_SHORT).show();
    }
}
