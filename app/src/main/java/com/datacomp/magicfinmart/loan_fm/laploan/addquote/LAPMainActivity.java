package com.datacomp.magicfinmart.loan_fm.laploan.addquote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.homeloan.addquote.HLMainActivity;
import com.datacomp.magicfinmart.loan_fm.laploan.application.LAPApplyWebView;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.QuoteEntity;

public class LAPMainActivity extends BaseActivity {

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
            setContentView(R.layout.activity_lapmain);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

            bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            bottomNavigationView.setSelectedItemId(R.id.navigation_input);

//            InputFragment_LAP inputFragment = new InputFragment_LAP();
//            FragmentTransaction transactionSim = getSupportFragmentManager().beginTransaction();
//            transactionSim.replace(R.id.frame_layout, inputFragment, "INPUT");
//            transactionSim.addToBackStack("INPUT");
//            transactionSim.commitAllowingStateLoss();
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
                        loadFragment(new InputFragment_LAP(), INPUT_FRAGMENT);
                    }


                    return true;
                case R.id.navigation_quote:

                    tabFragment = getSupportFragmentManager().findFragmentByTag(QUOTE_FRAGMENT);
                    if (tabFragment != null) {
                        loadFragment(tabFragment, QUOTE_FRAGMENT);

                    } else {
                        if (quoteBundle != null) {
                            QuoteFragment_LAP quoteFragment = new QuoteFragment_LAP();
                            quoteFragment.setArguments(quoteBundle);
                            loadFragment(quoteFragment, QUOTE_FRAGMENT);
                        } else {

                            Toast.makeText(LAPMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
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
            LAPMainActivity.this.finish();
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
            Toast.makeText(LAPMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
        else
            bottomNavigationView.setSelectedItemId(R.id.navigation_quote);

    }

    public void setQuoteCheck()
        {
            bottomNavigationView.getMenu().getItem(0).setCheckable(false);
            bottomNavigationView.getMenu().getItem(1).setCheckable(true);
            bottomNavigationView.getMenu().getItem(2).setCheckable(false);
        }


        public void redirectToApplyLoan(QuoteEntity entity, String url, int id) {
            startActivity(new Intent(LAPMainActivity.this, LAPApplyWebView.class)
                    .putExtra("QUOTE_ENTITY", entity)
                    .putExtra("URL", url)
                    .putExtra("QUOTE_ID", id));
        }
        // Implementation the Interface for Communication of Fragment Input and Quote

    }
