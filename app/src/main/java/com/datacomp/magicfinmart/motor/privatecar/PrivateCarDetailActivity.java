package com.datacomp.magicfinmart.motor.motorquote.privatecar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

public class PrivateCarDetailActivity extends BaseActivity {
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


        tabLayout.addTab(tabLayout.newTab().setText("QUOTES"));
        tabLayout.addTab(tabLayout.newTab().setText("APPLICATION"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mAdapter = new ActivityTabsPagerAdapter(getSupportFragmentManager());
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
