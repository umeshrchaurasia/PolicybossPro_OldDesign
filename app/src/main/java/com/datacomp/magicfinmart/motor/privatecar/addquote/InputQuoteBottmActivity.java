package com.datacomp.magicfinmart.motor.privatecar.addquote;

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
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.addquote.fragment.BuyFragment;
import com.datacomp.magicfinmart.motor.privatecar.addquote.fragment.InputFragment;
import com.datacomp.magicfinmart.motor.privatecar.addquote.fragment.QuoteFragment;
import com.datacomp.magicfinmart.motor.privatecar.quote.MotorQuoteFragment;
import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quoteapplication.QuoteApplicationController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.motor.model.ResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.motor.model.SummaryEntity;
import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.MotorRequestEntity;

public class InputQuoteBottmActivity extends BaseActivity {

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
        setContentView(R.layout.activity_input_quote_bottm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        bottomNavigationView.setSelectedItemId(R.id.navigation_input);

//        if (getIntent().getParcelableExtra(MotorQuoteFragment.FROM_QUOTE) != null) {
//            QuoteListEntity entity = getIntent().getParcelableExtra(MotorQuoteFragment.FROM_QUOTE);
//            if (entity.getMotorRequestEntity().getIsTwentyfour() == 0) {
//                //send to Quote
//
//                bottomNavigationView.setSelectedItemId(R.id.navigation_quote);
//            } else {
//                //send to Input
//                bottomNavigationView.setSelectedItemId(R.id.navigation_input);
//            }
//        } else {
//            //first input fragment load
//            bottomNavigationView.setSelectedItemId(R.id.navigation_input);
//        }

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

                            Toast.makeText(InputQuoteBottmActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
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
        InputQuoteBottmActivity.this.finish();
    }

    public void getQuoteParameterBundle(Bundle bundle) {

        quoteBundle = bundle;
        if (bundle == null)
            Toast.makeText(InputQuoteBottmActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
        else
            bottomNavigationView.setSelectedItemId(R.id.navigation_quote);

    }

    //region unUsed code

    public interface ActivityCallback            // Interface creation
    {
        void onMethodCallback(String strTyp);
    }

    private void unCheckAllBottomMenu() {
        int size = bottomNavigationView.getMenu().size();
        for (int i = 0; i < size; i++) {
            bottomNavigationView.getMenu().getItem(i).setCheckable(false);
        }
    }


    public void redirectToBuy(ResponseEntity entity) {

        int fbaID = new DBPersistanceController(this).getUserData().getFBAId();
        String url = "http://qa.policyboss.com/";
        //String url = "http://policyboss.com/";
        String title = "";
        String name = "";
        url = url + "buynowprivatecar/4/" + entity.getService_Log_Unique_Id() + "/nonposp/" + fbaID;
        title = "Car Insurance";

        //new QuoteApplicationController(this).convertQuoteToApp(entity.);

        startActivity(new Intent(this, CommonWebViewActivity.class)
                .putExtra("URL", url)
                .putExtra("NAME", name)
                .putExtra("TITLE", title));
    }

    public void redirectToPopUpPremium(ResponseEntity entity, SummaryEntity summaryEntity, String IDV) {
        startActivity(new Intent(this, PremiumBreakUpActivity.class)
                .putExtra("RESPONSE", entity));


    }

    //endregion

}
