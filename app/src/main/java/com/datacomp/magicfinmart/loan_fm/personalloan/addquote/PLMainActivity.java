package com.datacomp.magicfinmart.loan_fm.personalloan.addquote;

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
import com.datacomp.magicfinmart.loan_fm.personalloan.loan_apply.PersonalLoanApplyWebView;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.PersonalQuoteEntity;

public class PLMainActivity extends BaseActivity  {

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
        setContentView(R.layout.activity_plmain);
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
                    tabFragment = getSupportFragmentManager().findFragmentByTag("INPUT");
                    if (tabFragment != null) {
                        loadFragment(tabFragment, INPUT_FRAGMENT);

                    } else {
                        loadFragment(new PL_InputFragment(), INPUT_FRAGMENT);
                    }
                    return true;

//                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                        transaction.replace(R.id.frame_layout, tabFragment, "INPUT");
//                        transaction.addToBackStack("INPUT");
//                        transaction.show(tabFragment);
//                        //   transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                        transaction.commit();



//
//                    } else {
//                        PL_InputFragment PLInputFragment = new PL_InputFragment();
//                        FragmentTransaction transaction_imm = getSupportFragmentManager().beginTransaction();
//                        transaction_imm.replace(R.id.frame_layout, PLInputFragment, "INPUT");
//                        transaction_imm.addToBackStack("INPUT");
//                        transaction_imm.show(PLInputFragment);
//                        //   transaction_imm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                        transaction_imm.commit();
//
//                    }
//                    item.setCheckable(true);
//                    bottomNavigationView.getMenu().getItem(1).setCheckable(false);
//                    bottomNavigationView.getMenu().getItem(2).setCheckable(false);
//                    return true;
                case R.id.navigation_quote:

                    tabFragment = getSupportFragmentManager().findFragmentByTag("QUOTE");
                    if (tabFragment != null) {
                        loadFragment(tabFragment, QUOTE_FRAGMENT);

                    } else {
                        if (quoteBundle != null) {
                            PL_QuoteFragment quoteFragment = new PL_QuoteFragment();
                            quoteFragment.setArguments(quoteBundle);
                            loadFragment(quoteFragment, QUOTE_FRAGMENT);
                        } else {

                            Toast.makeText(PLMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
                        }
                    }

                    return true;
//                    if (tabFragment != null) {
//
//                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                        transaction.replace(R.id.frame_layout, tabFragment, "QUOTE");
//                        transaction.addToBackStack("QUOTE");
//                        transaction.show(tabFragment);
//                        // transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                        transaction.commitAllowingStateLoss();
//
//                    } else {
//                        PL_QuoteFragment quoteFragment = new PL_QuoteFragment();
//                        FragmentTransaction transaction_quote = getSupportFragmentManager().beginTransaction();
//                        transaction_quote.replace(R.id.frame_layout, quoteFragment, "QUOTE");
//                        transaction_quote.addToBackStack("QUOTE");
//                        transaction_quote.show(quoteFragment);
//                        //  transaction_quote.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                        transaction_quote.commitAllowingStateLoss();
//
//
//                    }
//                    item.setCheckable(true);
//                    bottomNavigationView.getMenu().getItem(0).setCheckable(false);
//                    bottomNavigationView.getMenu().getItem(2).setCheckable(false);
//                    return true;
                case R.id.navigation_buy:

                    //region comment
//                    tabFragment = getSupportFragmentManager().findFragmentByTag("BUY");
//                    if (tabFragment != null) {
//
//                        FragmentTransaction transaction = getSupportFragmentManager()
//                                .beginTransaction();
//                        transaction.show(tabFragment);
//                        //  transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                        transaction.addToBackStack("BUY");
//                        transaction.commitAllowingStateLoss();
//
//                    } else {
//                        BuyFragment buyFragment = new BuyFragment();
//                        FragmentTransaction transaction_buy = getSupportFragmentManager().beginTransaction();
//                        transaction_buy.replace(R.id.frame_layout, buyFragment, "BUY");
//                        transaction_buy.addToBackStack("BUY");
//                        transaction_buy.show(buyFragment);
//                        //   transaction_buy.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                        transaction_buy.commitAllowingStateLoss();
//
//
//                    }
//                    item.setCheckable(true);
//                    bottomNavigationView.getMenu().getItem(0).setCheckable(false);
//                    bottomNavigationView.getMenu().getItem(1).setCheckable(false);
                    //endregion

                    return false;
            }

            return false;
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        PLMainActivity.this.finish();
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

    public void setQuoteCheck()
    {
        bottomNavigationView.getMenu().getItem(0).setCheckable(false);
        bottomNavigationView.getMenu().getItem(1).setCheckable(true);
        bottomNavigationView.getMenu().getItem(2).setCheckable(false);
    }
    public void getQuoteParameterBundle(Bundle bundle) {

        quoteBundle = bundle;
        if (bundle == null)
            Toast.makeText(PLMainActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
        else
            bottomNavigationView.setSelectedItemId(R.id.navigation_quote);

    }


    public void redirectToApplyLoan(PersonalQuoteEntity entity,String url, int id) {
        startActivity(new Intent(PLMainActivity.this, PersonalLoanApplyWebView.class)
                .putExtra("PL", entity)
                .putExtra("PL_URL", url)
                .putExtra("PL_QUOTE_ID", id));
    }




    // Implementation the Interface for Communication of Fragment Input and Quote


}
