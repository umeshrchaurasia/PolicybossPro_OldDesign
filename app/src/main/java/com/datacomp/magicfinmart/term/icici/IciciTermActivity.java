package com.datacomp.magicfinmart.term.icici;

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
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.term.quoteapp.TermQuoteListFragment;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;

public class IciciTermActivity extends BaseActivity {

    private static String INPUT_FRAGMENT = "input_term_icici";
    private static String QUOTE_FRAGMENT = "quote_term";


    public static String INPUT_DATA = "input_term_data";
    public static String QUOTE_DATA = "quote_term_data";

    private static String BUY_FRAGMENT = "buy";

    BottomNavigationView bottomNavigationView;
    Bundle quoteBundle;
    Fragment tabFragment = null;
    FragmentTransaction transactionSim;
    TermFinmartRequest termFinmartRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icici_term);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //1. which insurer for enable input
        //2, check request
        quoteBundle = new Bundle();
        if (getIntent().getIntExtra(TermQuoteListFragment.TERM_FOR_INPUT_FRAGMENT, 0) != 0) {
            int insurerID = getIntent().getIntExtra(TermQuoteListFragment.TERM_FOR_INPUT_FRAGMENT, 0);
            quoteBundle.putInt(TermQuoteListFragment.TERM_FOR_INPUT_FRAGMENT, insurerID);
        }

        if (getIntent().getParcelableExtra(TermQuoteListFragment.TERM_INPUT_FRAGMENT) != null) {
            termFinmartRequest = getIntent().getParcelableExtra(TermQuoteListFragment.TERM_INPUT_FRAGMENT);
            quoteBundle.putParcelable(INPUT_DATA, termFinmartRequest);
            bottomNavigationView.setSelectedItemId(R.id.navigation_input);
        } else {
            bottomNavigationView.setSelectedItemId(R.id.navigation_input);
        }
    }

    //region navigation click

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_input:
                    tabFragment = getSupportFragmentManager().findFragmentByTag(INPUT_FRAGMENT);
                    if (termFinmartRequest != null) {
                        quoteBundle.putParcelable(INPUT_DATA, termFinmartRequest);
                    }

                    IciciTermInputFragment inputFragment = new IciciTermInputFragment();
                    inputFragment.setArguments(quoteBundle);
                    loadFragment(inputFragment, INPUT_FRAGMENT);

                    return true;
                case R.id.navigation_quote:

                    tabFragment = getSupportFragmentManager().findFragmentByTag(QUOTE_FRAGMENT);

                    if (termFinmartRequest != null) {
                        quoteBundle.putParcelable(QUOTE_DATA, termFinmartRequest);
                    }

                    if (tabFragment != null) {
                        tabFragment.setArguments(quoteBundle);
                        loadFragment(tabFragment, QUOTE_FRAGMENT);

                    } else {
                        if (quoteBundle != null) {
                            if (quoteBundle.getParcelable(QUOTE_DATA) != null) {
                                IciciTermQuoteFragment quoteFragment = new IciciTermQuoteFragment();
                                quoteFragment.setArguments(quoteBundle);
                                loadFragment(quoteFragment, QUOTE_FRAGMENT);
                            } else {

                                Toast.makeText(IciciTermActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            Toast.makeText(IciciTermActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
                        }
                    }

                    return true;
                case R.id.navigation_buy:
                    return true;
            }

            return false;
        }
    };
    //endregion

    private void loadFragment(Fragment fragment, String TAG) {
        transactionSim = getSupportFragmentManager().beginTransaction();
        transactionSim.replace(R.id.frame_layout, fragment, TAG);
        transactionSim.addToBackStack(TAG);
        transactionSim.show(fragment);
        transactionSim.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        IciciTermActivity.this.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void redirectToQuote(TermFinmartRequest termFinmartRequest) {
        this.termFinmartRequest = termFinmartRequest;
        quoteBundle = new Bundle();
        quoteBundle.putParcelable(QUOTE_DATA, termFinmartRequest);
        bottomNavigationView.setSelectedItemId(R.id.navigation_quote);
    }

    public void redirectToInput(TermFinmartRequest termFinmartRequest) {
        this.termFinmartRequest = termFinmartRequest;
        quoteBundle = new Bundle();
        quoteBundle.putParcelable(INPUT_DATA, termFinmartRequest);
        bottomNavigationView.setSelectedItemId(R.id.navigation_input);
    }

    public void updateRequestID(int termrequestyID) {
        this.termFinmartRequest.setTermRequestId(termrequestyID);
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
