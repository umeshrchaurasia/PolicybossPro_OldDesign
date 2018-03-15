package com.datacomp.magicfinmart.health.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.webviews.ShareQuoteACtivity;
import com.google.gson.Gson;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;

public class HealthQuoteDetailsDialogActivity extends BaseActivity implements View.OnClickListener, BaseActivity.PopUpListener {

    HealthQuoteEntity healthQuoteEntity;
    ImageView imgInsurer;
    TextView txtPlanName, txtSumAssured, txtDeductible, txtFinalPremium;
    RecyclerView rvBenefits;
    HealthSingleBenefitsAdapter mAdapter;
    ImageView imgShare;
    String name, responseJson;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_detail_activity);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFinishOnTouchOutside(false);
        init();
        healthQuoteEntity = new HealthQuoteEntity();
        registerPopUp(this);
        if (getIntent().getParcelableExtra("DETAIL") != null) {
            healthQuoteEntity = getIntent().getParcelableExtra("DETAIL");
            bindData();
        }
        if (getIntent().hasExtra("NAME")) {
            name = getIntent().getStringExtra("NAME");
        }
        new AsyncShareJson().execute();
    }

    private void init() {
        txtSumAssured = (TextView) findViewById(R.id.txtSumAssured);
        txtDeductible = (TextView) findViewById(R.id.txtDeductible);
        txtPlanName = (TextView) findViewById(R.id.txtPlanName);
        txtFinalPremium = (TextView) findViewById(R.id.txtFinalPremium);
        imgInsurer = (ImageView) findViewById(R.id.imgInsurer);
        imgShare = (ImageView) findViewById(R.id.imgShare);
        imgShare.setOnClickListener(this);
        rvBenefits = (RecyclerView) findViewById(R.id.rvBenefits);
        rvBenefits.setLayoutManager(new LinearLayoutManager(this));
        rvBenefits.setHasFixedSize(true);
    }

    private void bindData() {
        txtSumAssured.setText("" + Math.round(healthQuoteEntity.getSumInsured()));
        txtDeductible.setText("" + healthQuoteEntity.getDeductible_Amount());
        txtPlanName.setText("" + healthQuoteEntity.getPlanName());
        txtFinalPremium.setText("\u20B9 " + Math.round(healthQuoteEntity.getNetPremium()) + "/Year");

        if (healthQuoteEntity.getInsurerLogoName().equals("")) {
            imgInsurer.setImageResource(new DBPersistanceController(this)
                    .getInsurerImage(healthQuoteEntity.getInsurerId()));
        } else {
            String imgURL = "http://www.policyboss.com/Images/insurer_logo/" + healthQuoteEntity.getInsurerLogoName();
            Glide.with(this).load(imgURL)
                    .into(imgInsurer);
        }

        mAdapter = new HealthSingleBenefitsAdapter(this, healthQuoteEntity.getLstbenfitsFive());
        rvBenefits.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.imgShare) {
            if (Utility.checkShareStatus() == 1) {
                if (responseJson != null) {
                    Intent intent = new Intent(this, ShareQuoteACtivity.class);
                    intent.putExtra(Constants.SHARE_ACTIVITY_NAME, "HEALTH_SINGLE_QUOTE");
                    intent.putExtra("RESPONSE", responseJson);
                    intent.putExtra("NAME", name);
                    startActivity(intent);
                }
            } else {
                openPopUp(imgShare, "Message", "Your POSP status is INACTIVE", "OK", true);
            }
        }
    }

    class AsyncShareJson extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {

            responseJson = gson.toJson(healthQuoteEntity);
            return responseJson;
        }

        @Override
        protected void onPostExecute(String s) {
            responseJson = s;
        }
    }

    @Override
    public void onPositiveButtonClick(Dialog dialog, View view) {
        if (view.getId() == R.id.imgShare) {
            dialog.cancel();
        }
    }

    @Override
    public void onCancelButtonClick(Dialog dialog, View view) {
        if (view.getId() == R.id.imgShare) {
            dialog.cancel();
        }
    }
}
