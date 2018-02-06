package com.datacomp.magicfinmart.motor.twowheeler.quoteapplication.addquote;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.addquote.fragment.InputFragment;
import com.datacomp.magicfinmart.motor.privatecar.addquote.fragment.QuoteFragment;
import com.datacomp.magicfinmart.motor.privatecar.quote.MotorQuoteFragment;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;

public class BikeAddQuoteActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_bike_add_quote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        bottomNavigationView.setSelectedItemId(R.id.navigation_input);

        if (getIntent().getParcelableExtra(MotorQuoteFragment.FROM_QUOTE) != null) {
            QuoteListEntity entity = getIntent().getParcelableExtra(MotorQuoteFragment.FROM_QUOTE);
            if (entity.getMotorRequestEntity().getIsTwentyfour() == 0) {

                //1. update srn in preference
                Utility.getSharedPreferenceEditor(this).
                        putString(Utility.CARQUOTE_UNIQUEID, entity.getSRN()).commit();

                //2. create bundle
                Bundle bundle = new Bundle();
                bundle.putParcelable("CAR_REQUEST", entity.getMotorRequestEntity());
                quoteBundle = bundle;

                bottomNavigationView.setSelectedItemId(R.id.navigation_quote);
            } else {
                //send to Input
                //modify
                bottomNavigationView.setSelectedItemId(R.id.navigation_input);
            }
        } else {
            //first input fragment load
            bottomNavigationView.setSelectedItemId(R.id.navigation_input);
        }

        quoteBundle = null;
    }

    private void loadFragment(Fragment fragment, String TAG) {
        transactionSim = getSupportFragmentManager().beginTransaction();
        transactionSim.replace(R.id.frame_layout, fragment, TAG);
        transactionSim.addToBackStack(TAG);
        transactionSim.show(fragment);
        transactionSim.commit();
        //transactionSim.commitAllowingStateLoss();
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
                        loadFragment(new InputFragment(), INPUT_FRAGMENT);
                    }

                    return true;
                case R.id.navigation_quote:

                    tabFragment = getSupportFragmentManager().findFragmentByTag(QUOTE_FRAGMENT);
                    if (tabFragment != null) {
                        loadFragment(tabFragment, QUOTE_FRAGMENT);

                    } else {
                        if (quoteBundle != null) {
                            QuoteFragment quoteFragment = new QuoteFragment();
                            quoteFragment.setArguments(quoteBundle);
                            loadFragment(quoteFragment, QUOTE_FRAGMENT);
                        } else {

                            Toast.makeText(BikeAddQuoteActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
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
        BikeAddQuoteActivity.this.finish();
    }

    public void getQuoteParameterBundle(Bundle bundle) {

        quoteBundle = bundle;
        if (bundle == null)
            Toast.makeText(BikeAddQuoteActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
        else
            bottomNavigationView.setSelectedItemId(R.id.navigation_quote);

    }
}
