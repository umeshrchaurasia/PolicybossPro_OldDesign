package com.datacomp.magicfinmart.term;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.utility.Constants;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.term.TermInsuranceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TermQuoteApplicationResponse;

public class TermQuoteApplicationActivity extends BaseActivity implements IResponseSubcriber {
    ViewPager viewPager;
    Toolbar toolbar;
    TermActivityTabsPagerAdapter mAdapter;
    int compId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.termquoteapplication_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getIntent().hasExtra(Constants.LIFE_INS)) {
            compId = getIntent().getIntExtra(Constants.LIFE_INS, 0);
            if(compId==39){
                getSupportActionBar().setTitle("ICICI PRUDENTIAL");
            }
        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager, true);

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
        //viewPager.setAdapter(null);
        fetchQuoteApplication(compId);

    }

    public int getCompId() {
        return compId;
    }

    private void fetchQuoteApplication(int compId) {

        showDialog("Fetching.., Please wait.!");
        new TermInsuranceController(this).getTermQuoteApplicationList(compId, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_home:

                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof TermQuoteApplicationResponse) {
            if (((TermQuoteApplicationResponse) response).getMasterData() != null) {

                mAdapter = new TermActivityTabsPagerAdapter(getSupportFragmentManager(),
                        ((TermQuoteApplicationResponse) response));
                viewPager.setAdapter(mAdapter);
            }

        }

    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
        mAdapter = new TermActivityTabsPagerAdapter(getSupportFragmentManager(), null);
        viewPager.setAdapter(mAdapter);
    }
}
