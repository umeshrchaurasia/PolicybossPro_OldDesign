package com.datacomp.magicfinmart.health.healthquotetabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.health.fragment.HealthInputFragment;
import com.datacomp.magicfinmart.health.fragment.HealthQuoteFragment;
import com.datacomp.magicfinmart.health.quoappfragment.HealthQuoteListFragment;
import com.datacomp.magicfinmart.home.HomeActivity;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;

public class HealthQuoteBottomTabsActivity extends BaseActivity {

    private static String INPUT_FRAGMENT = "input_health";
    private static String QUOTE_FRAGMENT = "quote_health";


    public static String INPUT_DATA = "input_health_data";
    public static String QUOTE_DATA = "quote_health_data";

    private static String BUY_FRAGMENT = "buy";

    BottomNavigationView bottomNavigationView;
    Bundle quoteBundle;
    Fragment tabFragment = null;
    FragmentTransaction transactionSim;
    HealthQuote healthQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_quote_bottm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("HEALTH INSURANCE");

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (getIntent().getParcelableExtra(HealthQuoteListFragment.HEALTH_INPUT_FRAGMENT) != null) {
            healthQuote = getIntent().getParcelableExtra(HealthQuoteListFragment.HEALTH_INPUT_FRAGMENT);
            quoteBundle = new Bundle();
            quoteBundle.putParcelable(INPUT_DATA, healthQuote);
        }

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

                    if (healthQuote != null) {
                        quoteBundle = new Bundle();
                        quoteBundle.putParcelable(INPUT_DATA, healthQuote);
                    }

//                    if (tabFragment != null) {
//                        tabFragment.setArguments(quoteBundle);
//                        loadFragment(tabFragment, INPUT_FRAGMENT);
//                    } else {
//                        HealthInputFragment inputFragment = new HealthInputFragment();
//                        inputFragment.setArguments(quoteBundle);
//                        loadFragment(inputFragment, INPUT_FRAGMENT);
//                    }

                    HealthInputFragment inputFragment = new HealthInputFragment();
                    inputFragment.setArguments(quoteBundle);
                    loadFragment(inputFragment, INPUT_FRAGMENT);

                    return true;
                case R.id.navigation_quote:

                    tabFragment = getSupportFragmentManager().findFragmentByTag(QUOTE_FRAGMENT);

                    if (healthQuote != null) {
                        quoteBundle = new Bundle();
                        quoteBundle.putParcelable(QUOTE_DATA, healthQuote);
                    }

                    if (tabFragment != null) {
                        tabFragment.setArguments(quoteBundle);
                        loadFragment(tabFragment, QUOTE_FRAGMENT);

                    } else {
                        if (quoteBundle != null) {
                            if (quoteBundle.getParcelable(QUOTE_DATA) != null) {
                                HealthQuoteFragment quoteFragment = new HealthQuoteFragment();
                                quoteFragment.setArguments(quoteBundle);
                                loadFragment(quoteFragment, QUOTE_FRAGMENT);
                            } else {

                                Toast.makeText(HealthQuoteBottomTabsActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            Toast.makeText(HealthQuoteBottomTabsActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
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
        HealthQuoteBottomTabsActivity.this.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void redirectToQuote(HealthQuote healthQuote) {
        this.healthQuote = healthQuote;
        quoteBundle = new Bundle();
        quoteBundle.putParcelable(QUOTE_DATA, healthQuote);
        bottomNavigationView.setSelectedItemId(R.id.navigation_quote);
    }

    public void redirectToInput() {
        quoteBundle = new Bundle();
        quoteBundle.putParcelable(INPUT_DATA, healthQuote);
        bottomNavigationView.setSelectedItemId(R.id.navigation_input);
    }

    public void updateRequestID(int healthRequestID) {
        healthQuote.setHealthRequestId(healthRequestID);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_home:

                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
