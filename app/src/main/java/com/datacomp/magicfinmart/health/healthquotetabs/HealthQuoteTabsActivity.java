package com.datacomp.magicfinmart.health.healthquotetabs;

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
import com.datacomp.magicfinmart.health.fragment.HealthInputFragment;
import com.datacomp.magicfinmart.health.fragment.HealthQuoteFragment;

public class HealthQuoteTabsActivity extends BaseActivity {

    private static String INPUT_FRAGMENT = "input";
    private static String QUOTE_FRAGMENT = "quote";
    private static String BUY_FRAGMENT = "buy";

    public static String MOTOR_INPUT_REQUEST = "input_request_entity";
    public static String MOTOR_QUOTE_REQUEST = "quote_request_entity";

    BottomNavigationView bottomNavigationView;
    Bundle quoteBundle;
    Fragment tabFragment = null;
    FragmentTransaction transactionSim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_quote_bottm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        bottomNavigationView.setSelectedItemId(R.id.navigation_input);
    }

    private void loadFragment(Fragment fragment, String TAG) {
        transactionSim = getSupportFragmentManager().beginTransaction();
        transactionSim.replace(R.id.frame_layout, fragment, TAG);
        transactionSim.addToBackStack(TAG);
        transactionSim.show(fragment);
        transactionSim.commit();
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
                        HealthInputFragment inputFragment = new HealthInputFragment();
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
                            HealthQuoteFragment quoteFragment = new HealthQuoteFragment();
                            quoteFragment.setArguments(quoteBundle);
                            loadFragment(quoteFragment, QUOTE_FRAGMENT);
                        } else {

                            Toast.makeText(HealthQuoteTabsActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
                        }
                    }

                    return true;
                case R.id.navigation_buy:

//                    tabFragment = getSupportFragmentManager().findFragmentByTag("BUY");
//                    if (tabFragment != null) {
//                        loadFragment(tabFragment, INPUT_FRAGMENT);
//
//                    } else {
//                        loadFragment(new BuyFragment(), INPUT_FRAGMENT);
//                    }

                    return true;
            }

            return false;
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        HealthQuoteTabsActivity.this.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
