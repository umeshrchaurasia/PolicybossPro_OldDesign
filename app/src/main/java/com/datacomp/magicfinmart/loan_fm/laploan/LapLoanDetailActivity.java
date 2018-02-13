package com.datacomp.magicfinmart.loan_fm.laploan;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.mainloan.MainLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.HomeLoanRequestMainEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmHomelLoanResponse;


public class LapLoanDetailActivity extends BaseActivity implements IResponseSubcriberFM {

    Toolbar toolbar;
    ViewPager viewPager;
    ActivityTabsPagerAdapter_LAP mAdapter;
    LoginResponseEntity loginEntity ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap_loan_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tabLayout.addTab(tabLayout.newTab().setText("QUOTES"));
        tabLayout.addTab(tabLayout.newTab().setText("APPLICATION"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        loginEntity =  new DBPersistanceController(this).getUserData();

//        mAdapter = new ActivityTabsPagerAdapter_LAP(getSupportFragmentManager());
//        viewPager.setAdapter(mAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchQuoteApplication();
    }

    private void fetchQuoteApplication() {

        showDialog("Fetching.., Please wait.!");


        new MainLoanController(this).getHLQuoteApplicationData(String.valueOf(loginEntity.getFBAId()),
                "LAP", LapLoanDetailActivity.this);


    }
    @Override
    public void OnSuccessFM(APIResponseFM response, String message) {
        cancelDialog();
        if (response instanceof FmHomelLoanResponse) {
            if (((FmHomelLoanResponse) response).getMasterData() != null) {

                HomeLoanRequestMainEntity hlQuoteApplicationEntity =((FmHomelLoanResponse)response).getMasterData();

                mAdapter = new ActivityTabsPagerAdapter_LAP(getSupportFragmentManager(),hlQuoteApplicationEntity);
                viewPager.setAdapter(mAdapter);
            }

        }
    }

    @Override
    public void OnFailure(Throwable t) {

        cancelDialog();
        Toast.makeText(this,t.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
