package com.datacomp.magicfinmart.register;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    LinearLayout llPersonalInfo, llProfessionalInfo;
    ImageView ivProfessionalInfo, ivPersonalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initWidgets();
        setListener();
    }

    private void setListener() {
        ivProfessionalInfo.setOnClickListener(this);
        ivPersonalInfo.setOnClickListener(this);
    }

    private void initWidgets() {
        ivProfessionalInfo = (ImageView) findViewById(R.id.ivProfessionalInfo);
        ivPersonalInfo = (ImageView) findViewById(R.id.ivPersonalInfo);
        llPersonalInfo = (LinearLayout) findViewById(R.id.llPersonalInfo);
        llProfessionalInfo = (LinearLayout) findViewById(R.id.llProfessionalInfo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivPersonalInfo:
                hideAllLayouts(llPersonalInfo, ivPersonalInfo);
                break;
            case R.id.ivProfessionalInfo:
                hideAllLayouts(llProfessionalInfo, ivProfessionalInfo);
                break;
        }
    }

    private void hideAllLayouts(LinearLayout linearLayout, ImageView imageView) {

        if (llPersonalInfo.getVisibility() == View.GONE) {

            linearLayout.setVisibility(View.VISIBLE);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_remove));

            ivPersonalInfo.setImageDrawable(getResources().getDrawable(R.drawable.ic_add));
            llPersonalInfo.setVisibility(View.GONE);

            ivProfessionalInfo.setImageDrawable(getResources().getDrawable(R.drawable.ic_add));
            llProfessionalInfo.setVisibility(View.GONE);
        } else {
            linearLayout.setVisibility(View.GONE);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_add));
        }
    }
}