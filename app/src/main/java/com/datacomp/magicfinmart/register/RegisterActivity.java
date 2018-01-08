package com.datacomp.magicfinmart.register;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    LinearLayout llPersonalInfo, llProfessionalInfo;
    ImageView ivProfessionalInfo, ivPersonalInfo;
    RelativeLayout rlPersonalInfo, rlProfessionalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initWidgets();
        setListener();
        initLayouts();

    }

    private void initLayouts() {
        llPersonalInfo.setVisibility(View.GONE);
        llProfessionalInfo.setVisibility(View.GONE);
        hideAllLayouts(llPersonalInfo, ivPersonalInfo);
    }

    private void setListener() {
        ivProfessionalInfo.setOnClickListener(this);
        ivPersonalInfo.setOnClickListener(this);
        rlPersonalInfo.setOnClickListener(this);
        rlProfessionalInfo.setOnClickListener(this);
    }

    private void initWidgets() {
        ivProfessionalInfo = (ImageView) findViewById(R.id.ivProfessionalInfo);
        ivPersonalInfo = (ImageView) findViewById(R.id.ivPersonalInfo);
        llPersonalInfo = (LinearLayout) findViewById(R.id.llPersonalInfo);
        llProfessionalInfo = (LinearLayout) findViewById(R.id.llProfessionalInfo);
        rlPersonalInfo = (RelativeLayout) findViewById(R.id.rlPersonalInfo);
        rlProfessionalInfo = (RelativeLayout) findViewById(R.id.rlProfessionalInfo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivPersonalInfo:
            case R.id.rlPersonalInfo:
                hideAllLayouts(llPersonalInfo, ivPersonalInfo);
                break;
            case R.id.ivProfessionalInfo:
            case R.id.rlProfessionalInfo:
                hideAllLayouts(llProfessionalInfo, ivProfessionalInfo);
                break;
        }
    }

    private void hideAllLayouts(LinearLayout linearLayout, ImageView imageView) {

        if (linearLayout.getVisibility() == View.GONE) {

            //region hideall layout
            ivPersonalInfo.setImageDrawable(getResources().getDrawable(R.drawable.ic_add));
            llPersonalInfo.setVisibility(View.GONE);

            ivProfessionalInfo.setImageDrawable(getResources().getDrawable(R.drawable.ic_add));
            llProfessionalInfo.setVisibility(View.GONE);
            //endregion

            linearLayout.setVisibility(View.VISIBLE);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_remove));

        } else {
            linearLayout.setVisibility(View.GONE);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_add));
        }
    }
}