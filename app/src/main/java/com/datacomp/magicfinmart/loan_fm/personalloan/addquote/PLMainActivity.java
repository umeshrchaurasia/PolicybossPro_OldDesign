package com.datacomp.magicfinmart.loan_fm.personalloan.addquote;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.datacomp.magicfinmart.R;

public class PLMainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    int totCount = 0;
    Fragment tabFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plmain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
//        if(bottomNavigationView != null)
//        {
//            // Select first menu item by default and show Fragment accordingly.
//            Menu menu = bottomNavigationView.getMenu();
//        }
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        InputFragment inputFragment = new InputFragment();
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
                        InputFragment inputFragment = new InputFragment();
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
                        QuoteFragment quoteFragment = new QuoteFragment();
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

                    tabFragment = getSupportFragmentManager().findFragmentByTag("BUY");
                    if (tabFragment != null) {

                        FragmentTransaction transaction = getSupportFragmentManager()
                                .beginTransaction();
                        transaction.show(tabFragment);
                      //  transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction.addToBackStack("BUY");
                        transaction.commitAllowingStateLoss();

                    } else {
                        BuyFragment buyFragment = new BuyFragment();
                        FragmentTransaction transaction_buy = getSupportFragmentManager().beginTransaction();
                        transaction_buy.replace(R.id.frame_layout, buyFragment, "BUY");
                        transaction_buy.addToBackStack("BUY");
                        transaction_buy.show(buyFragment);
                     //   transaction_buy.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction_buy.commitAllowingStateLoss();


                    }
                    item.setCheckable(true);
                    bottomNavigationView.getMenu().getItem(0).setCheckable(false);
                    bottomNavigationView.getMenu().getItem(1).setCheckable(false);

                    return true;
            }

            return false;
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        PLMainActivity.this.finish();
    }

    private void unCheckAllBottomMenu() {
        int size = bottomNavigationView.getMenu().size();
        for (int i = 0; i < size; i++) {
            bottomNavigationView.getMenu().getItem(i).setCheckable(false);
        }
    }


}
