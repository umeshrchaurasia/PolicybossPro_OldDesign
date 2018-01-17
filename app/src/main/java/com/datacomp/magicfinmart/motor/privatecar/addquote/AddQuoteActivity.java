package com.datacomp.magicfinmart.motor.privatecar.addquote;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.IInputUpdateListener;

import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.MotorRequestEntity;

public class AddQuoteActivity extends BaseActivity implements IInputUpdateListener {

    Toolbar toolbar;
    ViewPager viewPager;
    JourneyQuoteTabsPagerAdapter mAdapter;
    TabLayout tabLayout;
    MotorRequestEntity motorRequestEntity;
    QuoteFragment quoteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quote);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);
        viewPager.setOffscreenPageLimit(0);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        /*tabLayout.addTab(tabLayout.newTab().setText("INPUT"));
        tabLayout.addTab(tabLayout.newTab().setText("QUOTE"));
        tabLayout.addTab(tabLayout.newTab().setText("BUY"));

        mAdapter = new JourneyQuoteTabsPagerAdapter(getSupportFragmentManager());
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
        });*/


    }

    private void setupViewPager(ViewPager viewPager) {
        JourneyQuoteTabsPagerAdapter adapter = new JourneyQuoteTabsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new InputFragment(), "INPUT");
        adapter.addFragment(new QuoteFragment(), "QUOTE");
        adapter.addFragment(new BuyFragment(), "BUY");
        adapter.addFragment(new BuyFragment(), "BUY2");
        viewPager.setAdapter(adapter);
    }

    public void setTabSelection(int index) {
        TabLayout.Tab tab = tabLayout.getTabAt(index);
        tab.select();
    }

    public MotorRequestEntity getMotorRequestEntity() {
        return motorRequestEntity;
    }

    public void setMotorRequestEntity(MotorRequestEntity motorRequestEntity) {
        this.motorRequestEntity = motorRequestEntity;
    }

    @Override
    public void updateInput(MotorRequestEntity motorRequestEntity) {
        this.motorRequestEntity = motorRequestEntity;
        /*quoteFragment = (QuoteFragment) mAdapter.getItem(2);
        quoteFragment.fetchQuotes(motorRequestEntity, AddQuoteActivity.this);*/
    }


}
