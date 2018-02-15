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
import com.datacomp.magicfinmart.loan_fm.homeloan.quote.HL_QuoteFragment;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.QuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.HomeLoanRequest;

public class HLMainActivity extends BaseActivity {

    private static String INPUT_FRAGMENT = "inputhl";
    private static String QUOTE_FRAGMENT = "quotehl";
    private static String BUY_FRAGMENT = "buy";

    public static String HL_INPUT_REQUEST = "input_request_entityhl";
    public static String HL_QUOTE_REQUEST = "quote_request_entityhl";

    BottomNavigationView bottomNavigationView;

    Bundle quoteBundle;
    Fragment tabFragment = null;
    FragmentTransaction transactionSim;

    HomeLoanRequest homeLoanRequestEntity;
    boolean isQuoteVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hlmain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (getIntent().getParcelableExtra(HL_QuoteFragment.FROM_QUOTE) != null) {
            FmHomeLoanRequest entity = getIntent().getParcelableExtra(HL_QuoteFragment.FROM_QUOTE);
            homeLoanRequestEntity = entity.getHomeLoanRequest();
            Bundle bundle = new Bundle();
            bundle.putParcelable(HL_QUOTE_REQUEST, homeLoanRequestEntity);
            quoteBundle = bundle;

            bottomNavigationView.setSelectedItemId(R.id.navigation_quote);

        } else {
            //first input fragment load
            bottomNavigationView.setSelectedItemId(R.id.navigation_input);
        }

        quoteBundle = null;


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_input:

                    tabFragment = getSupportFragmentManager().findFragmentByTag(INPUT_FRAGMENT);

                    if (homeLoanRequestEntity != null) {
                        quoteBundle = new Bundle();
                        quoteBundle.putParcelable(HLMainActivity.HL_INPUT_REQUEST, homeLoanRequestEntity);

                    }
                    if (tabFragment != null) {
                        tabFragment.setArguments(quoteBundle);
                        loadFragment(tabFragment, INPUT_FRAGMENT);

                    } else {
                        InputFragment_hl inputFragment = new InputFragment_hl();
                        inputFragment.setArguments(quoteBundle);
                        loadFragment(inputFragment, INPUT_FRAGMENT);
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
//        super.onBackPressed();
//        HLMainActivity.this.finish();
        if (isQuoteVisible) {
            finish();
        } else {
            Toast.makeText(HLMainActivity.this, "Please wait.., Fetching all quotes", Toast.LENGTH_SHORT).show();
        }
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


    // Implementation the Interface for Communication of Fragment Input and Quote

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void modifyQuote(HomeLoanRequest entity) {
        homeLoanRequestEntity = entity;
        /*startActivityForResult(new Intent(this, ModifyQuoteActivity.class)
                .putExtra("CAR_REQUEST", motorRequestEntity), 1000);*/

    }

    public void redirectInput(HomeLoanRequest entity) {
        if (isQuoteVisible) {
            homeLoanRequestEntity = entity;
            quoteBundle = new Bundle();
            quoteBundle.putParcelable(HLMainActivity.HL_INPUT_REQUEST, homeLoanRequestEntity);

            if (homeLoanRequestEntity == null)
                Toast.makeText(HLMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
            else
                bottomNavigationView.setSelectedItemId(R.id.navigation_input);
        } else {
            Toast.makeText(HLMainActivity.this, "Fetching all quotes", Toast.LENGTH_SHORT).show();
        }

    }


    public void getQuoteParameterBundle(HomeLoanRequest entity) {

        homeLoanRequestEntity = entity;
        quoteBundle = new Bundle();
        quoteBundle.putParcelable(HLMainActivity.HL_INPUT_REQUEST, homeLoanRequestEntity);

        if (homeLoanRequestEntity == null)
            Toast.makeText(HLMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
        else
            bottomNavigationView.setSelectedItemId(R.id.navigation_quote);

    }

    public void updateRequest(HomeLoanRequest entity, boolean isQuoteVisible) {
        homeLoanRequestEntity = entity;
        this.isQuoteVisible = isQuoteVisible;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (isQuoteVisible) {
                    finish();
                    return true;
                } else {
                    Toast.makeText(HLMainActivity.this, "Please wait.., Fetching all quotes", Toast.LENGTH_SHORT).show();
                    return false;
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
