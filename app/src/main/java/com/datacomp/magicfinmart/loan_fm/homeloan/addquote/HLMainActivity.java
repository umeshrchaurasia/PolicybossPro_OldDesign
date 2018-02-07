package com.datacomp.magicfinmart.loan_fm.homeloan.addquote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.homeloan.application.HomeLoanApplyWebView;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.QuoteEntity;

public class HLMainActivity extends BaseActivity {

    private static String INPUT_FRAGMENT = "input";
    private static String QUOTE_FRAGMENT = "quote";
    private static String BUY_FRAGMENT = "buy";
    BottomNavigationView bottomNavigationView;

    Bundle quoteBundle;
    Fragment tabFragment = null;
    FragmentTransaction transactionSim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hlmain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bottomNavigationView.setSelectedItemId(R.id.navigation_input);


    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_input:

                    tabFragment = getSupportFragmentManager().findFragmentByTag(INPUT_FRAGMENT);
                        if (tabFragment != null) {
                            loadFragment(tabFragment, INPUT_FRAGMENT);

                        } else {
                            loadFragment(new InputFragment_hl(), INPUT_FRAGMENT);
                        }


                    return true;
                case R.id.navigation_quote:

                    tabFragment = getSupportFragmentManager().findFragmentByTag(QUOTE_FRAGMENT);
                    if (tabFragment != null) {
                        loadFragment(tabFragment, QUOTE_FRAGMENT);

                    } else {
                        if (quoteBundle != null) {
                            QuoteFragment_hl quoteFragment = new QuoteFragment_hl();
                            quoteFragment.setArguments(quoteBundle);
                            loadFragment(quoteFragment, QUOTE_FRAGMENT);
                        } else {

                            Toast.makeText(HLMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
                        }
                    }
                    return true;

                case R.id.navigation_buy:


                    return true;
            }

            return false;
        }
    };



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        HLMainActivity.this.finish();
    }

    private void loadFragment(Fragment fragment, String TAG) {
        transactionSim = getSupportFragmentManager().beginTransaction();
        transactionSim.replace(R.id.frame_layout, fragment, TAG);
        transactionSim.addToBackStack(TAG);
        transactionSim.show(fragment);
        transactionSim.commit();

    }

    private void CheckAllBottomMenu() {
        int size = bottomNavigationView.getMenu().size();
        for (int i = 0; i < size; i++) {
            bottomNavigationView.getMenu().getItem(i).setCheckable(true);
        }
    }

    public void getQuoteParameterBundle(Bundle bundle) {

        quoteBundle = bundle;
        if (bundle == null)
            Toast.makeText(HLMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
        else
            bottomNavigationView.setSelectedItemId(R.id.navigation_quote);

    }



    public void redirectToApplyLoan(QuoteEntity entity, String url, int id) {
        startActivity(new Intent(HLMainActivity.this, HomeLoanApplyWebView.class)
                .putExtra("QUOTE_ENTITY", entity)
                .putExtra("URL", url)
                .putExtra("QUOTE_ID", id));
    }
    // Implementation the Interface for Communication of Fragment Input and Quote

}
