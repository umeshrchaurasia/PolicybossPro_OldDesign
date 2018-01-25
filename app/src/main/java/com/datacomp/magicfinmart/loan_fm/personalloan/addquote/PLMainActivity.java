package com.datacomp.magicfinmart.loan_fm.personalloan.addquote;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.datacomp.magicfinmart.R;

public class PLMainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    int totCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plmain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
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
                    InputFragment inputFragment = new InputFragment();
                    FragmentTransaction transaction_imm = getSupportFragmentManager().beginTransaction();
                    transaction_imm.replace(R.id.frame_layout, inputFragment, "INPUT");
                    transaction_imm.addToBackStack("other");
                    transaction_imm.commitAllowingStateLoss();
                    item.setCheckable(true);
                    bottomNavigationView.getMenu().getItem(1).setCheckable(false);
                    bottomNavigationView.getMenu().getItem(2).setCheckable(false);
                    return true;
                case R.id.navigation_quote:
                    QuoteFragment quoteFragment = new QuoteFragment();
                    FragmentTransaction transaction_quote = getSupportFragmentManager().beginTransaction();
                    transaction_quote.replace(R.id.frame_layout, quoteFragment, "QUOTE");
                    transaction_quote.addToBackStack("other");
                    transaction_quote.commitAllowingStateLoss();
                    item.setCheckable(true);
                    bottomNavigationView.getMenu().getItem(0).setCheckable(false);
                    bottomNavigationView.getMenu().getItem(2).setCheckable(false);
                    return true;
                case R.id.navigation_buy:
                    BuyFragment buyFragment = new BuyFragment();
                    FragmentTransaction transaction_buy = getSupportFragmentManager().beginTransaction();
                    transaction_buy.replace(R.id.frame_layout, buyFragment, "BUY");
                    transaction_buy.addToBackStack("other");
                    transaction_buy.commitAllowingStateLoss();
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

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {

            getSupportFragmentManager().popBackStack("INPUT", FragmentManager.POP_BACK_STACK_INCLUSIVE);
//            int count = getSupportFragmentManager().getBackStackEntryCount();
//            while(count > 0){
//                getSupportFragmentManager().popBackStack();
//                count--;
//            }
        } else {
            super.onBackPressed();

        }
    }
    /*private void unCheckAllBottomMenu() {
        int size = bottomNavigationView.getMenu().size();
        for (int i = 0; i < size; i++) {
            bottomNavigationView.getMenu().getItem(i).setCheckable(false);
        }
    }

    @Override
    public void onBackPressed() {

        unCheckAllBottomMenu();
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {

            getSupportFragmentManager().popBackStack("other", FragmentManager.POP_BACK_STACK_INCLUSIVE);

//            int count = getSupportFragmentManager().getBackStackEntryCount();
//            while(count > 0){
//                getSupportFragmentManager().popBackStack();
//                count--;
//            }
        } else {
            super.onBackPressed();

        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                int count = getSupportFragmentManager().getBackStackEntryCount();

                if (count > 0) {
                    IncomeSimulatorFragment incomeSimulatorFragment = new IncomeSimulatorFragment();
                    FragmentTransaction transactionSim = getSupportFragmentManager().beginTransaction();
                    transactionSim.replace(R.id.frame_layout, incomeSimulatorFragment, "Home");
                    transactionSim.commit();
                    getSupportFragmentManager().popBackStack("other", FragmentManager.POP_BACK_STACK_INCLUSIVE);

                    unCheckAllBottomMenu();
                } else if (count == 0) {
                    startActivity(new Intent(IncomeSimulatorActivity.this, MainActivity.class));
                    finish();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);

        // Note : Home frag Not added to addToBackStack , hence counting consider only for other fragment
        // ie why case may be count 1  Frame having both home and 1 other frag
    }*/
}
