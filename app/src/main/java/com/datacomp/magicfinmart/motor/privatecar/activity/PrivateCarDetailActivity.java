package com.datacomp.magicfinmart.motor.privatecar.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.adapter.ActivityTabsPagerAdapter;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quoteapplication.QuoteApplicationController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.QuoteApplicationResponse;

public class PrivateCarDetailActivity extends BaseActivity implements IResponseSubcriber {
    Toolbar toolbar;
    ViewPager viewPager;
    ActivityTabsPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_car_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        tabLayout.addTab(tabLayout.newTab().setText("QUOTES"));
        tabLayout.addTab(tabLayout.newTab().setText("APPLICATION"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


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
        viewPager.setAdapter(null);
        fetchQuoteApplication();

    }

    private void fetchQuoteApplication() {

        showDialog("Fetching.., Please wait.!");
        new QuoteApplicationController(this).getQuoteAppList("", "",
                new DBPersistanceController(this).getUserData().getFBAId(),
                0,
                "",
                this);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof QuoteApplicationResponse) {
            if (((QuoteApplicationResponse) response).getMasterData() != null) {

                mAdapter = new ActivityTabsPagerAdapter(getSupportFragmentManager(),
                        ((QuoteApplicationResponse) response).getMasterData());
                viewPager.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }
        }

    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
        mAdapter = new ActivityTabsPagerAdapter(getSupportFragmentManager(), null);
        viewPager.setAdapter(mAdapter);

    }
}
