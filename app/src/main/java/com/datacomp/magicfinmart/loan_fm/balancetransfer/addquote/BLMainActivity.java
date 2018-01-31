package com.datacomp.magicfinmart.loan_fm.balancetransfer.addquote;

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

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.loan_apply.BTLoanApplyWebView;
import com.datacomp.magicfinmart.loan_fm.personalloan.addquote.InputFragment;
import com.datacomp.magicfinmart.loan_fm.personalloan.addquote.PLMainActivity;
import com.datacomp.magicfinmart.loan_fm.personalloan.addquote.QuoteFragment;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BLEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BLLoanRequest;

public class BLMainActivity extends BaseActivity {

    BottomNavigationView bottomNavigationView;

    int totCount = 0;
    Fragment tabFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blmain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        BLInputFragment inputFragment = new BLInputFragment();
        FragmentTransaction transactionSim = getSupportFragmentManager().beginTransaction();
        transactionSim.replace(R.id.frame_layout, inputFragment, "INPUT");
        transactionSim.addToBackStack("INPUT");
        transactionSim.commitAllowingStateLoss();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_input:
                    tabFragment = getSupportFragmentManager().findFragmentByTag("INPUT");
                    if (tabFragment != null) {

                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, tabFragment, "INPUT");
                        transaction.addToBackStack("INPUT");
                        transaction.show(tabFragment);
                        //   transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction.commit();


                    } else {
                        BLInputFragment inputFragment = new BLInputFragment();
                        FragmentTransaction transaction_imm = getSupportFragmentManager().beginTransaction();
                        transaction_imm.replace(R.id.frame_layout, inputFragment, "INPUT");
                        transaction_imm.addToBackStack("INPUT");
                        transaction_imm.show(inputFragment);
                        //   transaction_imm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction_imm.commit();

                    }
                    item.setCheckable(true);
                    bottomNavigationView.getMenu().getItem(1).setCheckable(false);
                    bottomNavigationView.getMenu().getItem(2).setCheckable(false);
                    return true;
                case R.id.navigation_quote:

                    tabFragment = getSupportFragmentManager().findFragmentByTag("QUOTE");
                    if (tabFragment != null) {

                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, tabFragment, "QUOTE");
                        transaction.addToBackStack("QUOTE");
                        transaction.show(tabFragment);
                        // transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction.commitAllowingStateLoss();

                    } else {
                        BLQuoteFragment quoteFragment = new BLQuoteFragment();
                        FragmentTransaction transaction_quote = getSupportFragmentManager().beginTransaction();
                        transaction_quote.replace(R.id.frame_layout, quoteFragment, "QUOTE");
                        transaction_quote.addToBackStack("QUOTE");
                        transaction_quote.show(quoteFragment);
                        //  transaction_quote.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction_quote.commitAllowingStateLoss();


                    }
                    item.setCheckable(true);
                    bottomNavigationView.getMenu().getItem(0).setCheckable(false);
                    bottomNavigationView.getMenu().getItem(2).setCheckable(false);
                    return true;
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

                    return true;
            }

            return false;
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        BLMainActivity.this.finish();
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


    public void redirectToApplyLoan(BLEntity entity, BLLoanRequest blLoanRequest, int id) {
        startActivity(new Intent(BLMainActivity.this, BTLoanApplyWebView.class)
                .putExtra("BL", entity)
                .putExtra("BL_Req", blLoanRequest)
                .putExtra("BL_QUOTE_ID", id));
    }

    // Implementation the Interface for Communication of Fragment Input and Quote

}
