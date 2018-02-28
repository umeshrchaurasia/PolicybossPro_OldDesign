package com.datacomp.magicfinmart.helpfeedback.aboutus;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;

public class AboutUsActivity extends BaseActivity implements IResponseSubcriber {

    TextView tvAppVersion, tvNAme, tvFbaCode, tvPospNo, tvLoginId, tvPospStatus, tvManagerMobile,
            tvManagerEmail, tvSupportNo, tvSupportEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init_widgets();
    }

    private void init_widgets() {
        tvAppVersion = (TextView) findViewById(R.id.tvAppVersion);
        tvNAme = (TextView) findViewById(R.id.tvNAme);
        tvFbaCode = (TextView) findViewById(R.id.tvFbaCode);
        tvPospNo = (TextView) findViewById(R.id.tvPospNo);
        tvLoginId = (TextView) findViewById(R.id.tvLoginId);
        tvPospStatus = (TextView) findViewById(R.id.tvPospStatus);
        tvManagerMobile = (TextView) findViewById(R.id.tvManagerMobile);
        tvManagerEmail = (TextView) findViewById(R.id.tvManagerEmail);
        tvSupportNo = (TextView) findViewById(R.id.tvSupportNo);
        tvSupportEmail = (TextView) findViewById(R.id.tvSupportEmail);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

    }

    @Override
    public void OnFailure(Throwable t) {

    }
}
