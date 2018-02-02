package com.datacomp.magicfinmart.loan_fm.personalloan;

import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quoteapplication.QuoteApplicationController;

public class PersonalLoanDetailActivity extends BaseActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    ActivityTabsPagerAdapter_PL mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_loan_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("QUOTES"));
        tabLayout.addTab(tabLayout.newTab().setText("APPLICATION"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

//        showDialog("Fetching.., Please wait.!");
//        new QuoteApplicationController(this).getQuoteAppList("", "",
//                new DBPersistanceController(this).getUserData().getFBAId(),
//                0,
//                "",
//                PersonalLoanDetailActivity.this);

        mAdapter = new ActivityTabsPagerAdapter_PL(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);

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

}
