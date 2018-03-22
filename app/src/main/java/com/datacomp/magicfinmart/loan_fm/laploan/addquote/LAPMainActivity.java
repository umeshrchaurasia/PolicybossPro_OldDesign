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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.loan_fm.laploan.application.LAPApplyWebView;
import com.datacomp.magicfinmart.loan_fm.laploan.quote.LAP_QuoteFragment;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.QuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;

public class LAPMainActivity extends BaseActivity {

    private static String INPUT_FRAGMENT = "inputhl";
    private static String QUOTE_FRAGMENT = "quotehl";
    private static String BUY_FRAGMENT = "buy";

    public static String HL_INPUT_REQUEST = "input_request_entityhl";
    public static String HL_QUOTE_REQUEST = "quote_request_entityhl";

    BottomNavigationView bottomNavigationView;

    Bundle quoteBundle;
    Fragment tabFragment = null;
    FragmentTransaction transactionSim;

    FmHomeLoanRequest fmHomeLoanRequest;
    //HomeLoanRequest homeLoanRequestEntity;
    boolean isQuoteVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lapmain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (getIntent().getParcelableExtra(LAP_QuoteFragment.FROM_QUOTE) != null) {
            fmHomeLoanRequest = getIntent().getParcelableExtra(LAP_QuoteFragment.FROM_QUOTE);
            Bundle bundle = new Bundle();
            bundle.putParcelable(HL_QUOTE_REQUEST, fmHomeLoanRequest);
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

                    if (fmHomeLoanRequest != null) {
                        quoteBundle = new Bundle();
                        quoteBundle.putParcelable(LAPMainActivity.HL_INPUT_REQUEST, fmHomeLoanRequest);

                    }
                    if (tabFragment != null) {
                        tabFragment.setArguments(quoteBundle);
                        loadFragment(tabFragment, INPUT_FRAGMENT);

                    } else {
                        InputFragment_LAP inputFragment = new InputFragment_LAP();
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


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void redirectInput(FmHomeLoanRequest entity) {
        if (isQuoteVisible) {
            fmHomeLoanRequest = entity;
            quoteBundle = new Bundle();
            quoteBundle.putParcelable(LAPMainActivity.HL_INPUT_REQUEST, fmHomeLoanRequest);

            if (fmHomeLoanRequest == null)
                Toast.makeText(LAPMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
            else
                bottomNavigationView.setSelectedItemId(R.id.navigation_input);
        } else {
            Toast.makeText(LAPMainActivity.this, "Fetching all quotes", Toast.LENGTH_SHORT).show();
        }

    }

    public void getQuoteParameterBundle(FmHomeLoanRequest entity) {

        fmHomeLoanRequest = entity;
        quoteBundle = new Bundle();
        quoteBundle.putParcelable(LAPMainActivity.HL_QUOTE_REQUEST, fmHomeLoanRequest);

        if (fmHomeLoanRequest == null)
            Toast.makeText(LAPMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
        else
            bottomNavigationView.setSelectedItemId(R.id.navigation_quote);

    }

    public void updateRequest(FmHomeLoanRequest entity, boolean isQuoteVisible) {
        fmHomeLoanRequest = entity;
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
                    Toast.makeText(LAPMainActivity.this, "Please wait.., Fetching all quotes", Toast.LENGTH_SHORT).show();
                    return false;
                }

            case R.id.action_home:

                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

}
