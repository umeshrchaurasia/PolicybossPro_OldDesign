package com.datacomp.magicfinmart.term.compareterm;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.term.hdfc.HdfcInputFragment;
import com.datacomp.magicfinmart.term.icici.IciciTermInputFragment;
import com.datacomp.magicfinmart.term.quoteapp.TermQuoteListFragment;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TermCompareResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;

public class CompareTermActivity extends BaseActivity {
    private static String INPUT_FRAGMENT = "input_term_compare";
    private static String QUOTE_FRAGMENT = "quote_term_compare";


    public static String INPUT_DATA = "input_term_data_compare";
    public static String QUOTE_DATA = "quote_term_data_compare";
    public static String OTHER_QUOTE_DATA = "quote_term_data_other";
    public static String OTHER_QUOTE_DATA_RESPONSE = "quote_term_data_other_response";


    private static String BUY_FRAGMENT = "buy";

    BottomNavigationView bottomNavigationView;
    Bundle quoteBundle;
    Fragment tabFragment = null;
    FragmentTransaction transactionSim;
    TermFinmartRequest termFinmartRequest;
    ImageView ivHdrInput, ivHdrQuote;
    boolean fromOtherQuote = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_quote_bottm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        ivHdrInput = (ImageView) findViewById(R.id.ivHdrInput);
        ivHdrQuote = (ImageView) findViewById(R.id.ivHdrQuote);
        //1. which insurer for enable input
        //2, check request
        quoteBundle = new Bundle();
        if (getIntent().getIntExtra(TermQuoteListFragment.TERM_FOR_INPUT_FRAGMENT, 0) != 0) {
            int insurerID = getIntent().getIntExtra(TermQuoteListFragment.TERM_FOR_INPUT_FRAGMENT, 0);
            quoteBundle.putInt(TermQuoteListFragment.TERM_FOR_INPUT_FRAGMENT, insurerID);
        }

        if (getIntent().getParcelableExtra(TermQuoteListFragment.TERM_INPUT_FRAGMENT) != null) {
            termFinmartRequest = getIntent().getParcelableExtra(TermQuoteListFragment.TERM_INPUT_FRAGMENT);
            quoteBundle.putParcelable(INPUT_DATA, null);
            quoteBundle.putParcelable(QUOTE_DATA, termFinmartRequest);
            bottomNavigationView.setSelectedItemId(R.id.navigation_quote);
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
                    Log.d("CompareTermActivity", "navigation_input selected");
                    highlighInput();
                    tabFragment = getSupportFragmentManager().findFragmentByTag(INPUT_FRAGMENT);
                    if (termFinmartRequest != null) {
                        quoteBundle.putParcelable(QUOTE_DATA, null);
                        quoteBundle.putParcelable(INPUT_DATA, termFinmartRequest);
                    }

                    TermInputFragment inputFragment = new TermInputFragment();
                    inputFragment.setArguments(quoteBundle);
                    loadFragment(inputFragment, INPUT_FRAGMENT);

                    return true;
                case R.id.navigation_quote:
                    Log.d("CompareTermActivity", "navigation_quote selected");
                    tabFragment = getSupportFragmentManager().findFragmentByTag(INPUT_FRAGMENT);

                    if (termFinmartRequest != null) {
                        quoteBundle.putParcelable(INPUT_DATA, null);
                        quoteBundle.putParcelable(QUOTE_DATA, termFinmartRequest);
                        TermInputFragment quoteFragment = new TermInputFragment();
                        quoteFragment.setArguments(quoteBundle);
                        loadFragment(quoteFragment, INPUT_FRAGMENT);
                        highlighQuote();
                    } else {
                        Toast.makeText(CompareTermActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
                    }
                    /*if (termFinmartRequest != null) {
                        quoteBundle.putParcelable(QUOTE_DATA, termFinmartRequest);

                    }

                    if (tabFragment != null) {
                        tabFragment.setArguments(quoteBundle);
                        loadFragment(tabFragment, QUOTE_FRAGMENT);
                        highlighQuote();
                    } else {
                        if (quoteBundle != null) {
                            if (quoteBundle.getParcelable(QUOTE_DATA) != null) {
                                TermQuoteFragment quoteFragment = new TermQuoteFragment();
                                quoteFragment.setArguments(quoteBundle);
                                loadFragment(quoteFragment, QUOTE_FRAGMENT);
                                highlighQuote();
                            } else {

                                Toast.makeText(CompareTermActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            Toast.makeText(CompareTermActivity.this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
                        }
                    }*/

                    return true;
                case R.id.navigation_buy:
                    return true;
            }

            return false;
        }
    };
    //endregion

    private void loadFragment(Fragment fragment, String TAG) {
        String backStateName = fragment.getClass().getName();
        Log.d("Fragment - ", backStateName + "    TAG - " + TAG);
        transactionSim = getSupportFragmentManager().beginTransaction();
        transactionSim.replace(R.id.frame_layout, fragment, TAG);
        transactionSim.addToBackStack(TAG);
        transactionSim.show(fragment);
        transactionSim.commit();
    }

    private void loadFragmentWithBack(Fragment fragment, String TAG) {
        String backStateName = fragment.getClass().getName();
        Log.d("Fragment - ", backStateName + "    TAG - " + TAG);
        transactionSim = getSupportFragmentManager().beginTransaction();
        transactionSim.add(R.id.frame_layout, fragment, TAG);
        transactionSim.addToBackStack("other");
        transactionSim.show(fragment);
        transactionSim.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            //getSupportFragmentManager().popBackStack();
           getSupportFragmentManager().popBackStack("other", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } else {
            if (ivHdrQuote.getVisibility()==View.VISIBLE) {
                bottomNavigationView.setSelectedItemId(R.id.navigation_input);
            } else {
                CompareTermActivity.this.finish();
            }
        }

        /*if (fromOtherQuote) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_quote);
            fromOtherQuote = false;
        } else {
            if (R.id.navigation_quote == bottomNavigationView.getSelectedItemId()) {
                bottomNavigationView.setSelectedItemId(R.id.navigation_input);
            } else {
                CompareTermActivity.this.finish();
            }
        }*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void redirectToQuote(TermFinmartRequest termFinmartRequest) {
        this.termFinmartRequest = termFinmartRequest;
       /* quoteBundle = new Bundle();
        quoteBundle.putParcelable(QUOTE_DATA, termFinmartRequest);
        bottomNavigationView.setSelectedItemId(R.id.navigation_quote);*/
        highlighQuote();
    }

    public void redirectToInput(TermFinmartRequest termFinmartRequest) {
        this.termFinmartRequest = termFinmartRequest;
        quoteBundle = new Bundle();
        quoteBundle.putParcelable(QUOTE_DATA, null);
        quoteBundle.putParcelable(INPUT_DATA, termFinmartRequest);
        bottomNavigationView.setSelectedItemId(R.id.navigation_input);
    }

    public void updateRequest(TermFinmartRequest termFinmartRequest) {
        this.termFinmartRequest = termFinmartRequest;
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

    public void highlighInput() {
        ivHdrInput.setVisibility(View.VISIBLE);
        ivHdrQuote.setVisibility(View.GONE);
    }

    public void highlighQuote() {
        ivHdrQuote.setVisibility(View.VISIBLE);
        ivHdrInput.setVisibility(View.GONE);

    }

    public void redirectToHdfcQuote(TermCompareResponseEntity termCompareResponseEntity) {
        quoteBundle.putParcelable(OTHER_QUOTE_DATA, termFinmartRequest);
        quoteBundle.putParcelable(OTHER_QUOTE_DATA_RESPONSE, termCompareResponseEntity);
        quoteBundle.putParcelable(INPUT_DATA, null);
        quoteBundle.putParcelable(QUOTE_DATA, null);
        HdfcInputFragment quoteFragment = new HdfcInputFragment();
        quoteFragment.setArguments(quoteBundle);
        loadFragmentWithBack(quoteFragment, INPUT_FRAGMENT);
        highlighQuote();
        fromOtherQuote = true;
    }

    public void redirectToIciciQuote(TermCompareResponseEntity termCompareResponseEntity) {
        quoteBundle.putParcelable(OTHER_QUOTE_DATA, termFinmartRequest);
        quoteBundle.putParcelable(OTHER_QUOTE_DATA_RESPONSE, termCompareResponseEntity);
        quoteBundle.putParcelable(INPUT_DATA, null);
        quoteBundle.putParcelable(QUOTE_DATA, null);
        IciciTermInputFragment quoteFragment = new IciciTermInputFragment();
        quoteFragment.setArguments(quoteBundle);
        loadFragmentWithBack(quoteFragment, INPUT_FRAGMENT);
        highlighQuote();
        fromOtherQuote = true;
    }
}
