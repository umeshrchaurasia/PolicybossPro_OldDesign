package com.datacomp.magicfinmart.lifeinsurance.CompareInsurance.addquote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.personalloan.addquote.InputFragment_pl;
import com.datacomp.magicfinmart.loan_fm.personalloan.addquote.QuoteFragment_pl;
import com.datacomp.magicfinmart.loan_fm.personalloan.quote.PL_QuoteFragment;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;

public class CompareInsMainActivity extends AppCompatActivity {

    private static String INPUT_FRAGMENT_COMP = "inputComp";
    private static String QUOTE_FRAGMENT_COMP = "quoteComp";
    private static String BUY_FRAGMENT_COMP = "buyComp";

    public static String PL_INPUT_REQUEST = "input_request_entityCompare";
    public static String PL_QUOTE_REQUEST = "quote_request_entityCompare";

    BottomNavigationView bottomNavigationView;
    Bundle quoteBundle;
    Fragment tabFragment = null;
    FragmentTransaction transactionSim;

    FmPersonalLoanRequest fmPersonalLoanRequest;

    boolean isQuoteVisible = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_ins_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (getIntent().getParcelableExtra(PL_QuoteFragment.FROM_QUOTEPL) != null) {
            fmPersonalLoanRequest = getIntent().getParcelableExtra(PL_QuoteFragment.FROM_QUOTEPL);
            Bundle bundle = new Bundle();
            bundle.putParcelable(PL_QUOTE_REQUEST, fmPersonalLoanRequest);
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

                    tabFragment = getSupportFragmentManager().findFragmentByTag(INPUT_FRAGMENT_COMP);

                    if (fmPersonalLoanRequest != null) {
                        quoteBundle = new Bundle();
                        quoteBundle.putParcelable(CompareInsMainActivity.PL_INPUT_REQUEST, fmPersonalLoanRequest);

                    }
                    if (tabFragment != null) {
                        tabFragment.setArguments(quoteBundle);
                        loadFragment(tabFragment, INPUT_FRAGMENT_COMP);

                    } else {
                        InputFragment_CompareIns inputFragment = new InputFragment_CompareIns();
                        inputFragment.setArguments(quoteBundle);
                        loadFragment(inputFragment, INPUT_FRAGMENT_COMP);
                    }

                    return true;

                case R.id.navigation_quote:

                    tabFragment = getSupportFragmentManager().findFragmentByTag(QUOTE_FRAGMENT_COMP);
                    if (tabFragment != null) {
                        loadFragment(tabFragment, QUOTE_FRAGMENT_COMP);

                    } else {
                        if (quoteBundle != null) {
                            QuoteFragment_pl quoteFragment = new QuoteFragment_pl();
                            quoteFragment.setArguments(quoteBundle);
                            loadFragment(quoteFragment, QUOTE_FRAGMENT_COMP);
                        } else {

                            Toast.makeText(CompareInsMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
                        }
                    }
                    return true;
//
                case R.id.navigation_buy:


                    return false;
            }

            return false;
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        CompareInsMainActivity.this.finish();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void redirectInput(FmPersonalLoanRequest entity) {
        if (isQuoteVisible) {
            fmPersonalLoanRequest = entity;
            quoteBundle = new Bundle();
            quoteBundle.putParcelable(CompareInsMainActivity.PL_INPUT_REQUEST, fmPersonalLoanRequest);

            if (fmPersonalLoanRequest == null)
                Toast.makeText(CompareInsMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
            else
                bottomNavigationView.setSelectedItemId(R.id.navigation_input);
        } else {
            Toast.makeText(CompareInsMainActivity.this, "Fetching all quotes", Toast.LENGTH_SHORT).show();
        }

    }



    public void getQuoteParameterBundle(FmPersonalLoanRequest entity) {

        fmPersonalLoanRequest = entity;
        quoteBundle = new Bundle();
        quoteBundle.putParcelable(CompareInsMainActivity.PL_QUOTE_REQUEST, fmPersonalLoanRequest);

        if (fmPersonalLoanRequest == null)
            Toast.makeText(CompareInsMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
        else
            bottomNavigationView.setSelectedItemId(R.id.navigation_quote);

    }

    public void updateRequest(FmPersonalLoanRequest entity, boolean isQuoteVisible) {
        fmPersonalLoanRequest = entity;
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
                    Toast.makeText(CompareInsMainActivity.this, "Please wait.., Fetching all quotes", Toast.LENGTH_SHORT).show();
                    return false;
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Implementation the Interface for Communication of Fragment Input and Quote



}
