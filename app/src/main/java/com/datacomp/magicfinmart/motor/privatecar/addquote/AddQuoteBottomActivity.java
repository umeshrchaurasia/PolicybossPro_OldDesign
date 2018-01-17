package com.datacomp.magicfinmart.motor.privatecar.addquote;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.IInputUpdateListener;

import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.MotorRequestEntity;

public class AddQuoteBottomActivity extends BaseActivity implements IInputUpdateListener {
    public static MotorRequestEntity motorRequestEntity;
    private TextView mTextMessage;
    private Handler mHandler;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quote_bottom);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mHandler = new Handler();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_input:
                    replaceFragment(0, "INPUT");
                    return true;
                case R.id.navigation_quote:
                    replaceFragment(1, "QUOTE");
                    return true;
                case R.id.navigation_buy:
                    replaceFragment(2, "BUY");
                    return true;
            }
            return false;
        }
    };

    private void replaceFragment(final int id, final String tag) {
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                android.support.v4.app.Fragment fragment = getHomeFragment(id);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, tag);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
    }

    private android.support.v4.app.Fragment getHomeFragment(int id) {
        android.support.v4.app.Fragment fragment = null;
        switch (id) {
            case 0:
                fragment = new InputFragment();
                return fragment;
            case 1:
                fragment = new QuoteFragment();
                return fragment;
            case 2:
                fragment = new BuyFragment();
                return fragment;

            default:
                fragment = new InputFragment();
                return fragment;
        }
    }

    @Override
    public void updateInput(MotorRequestEntity motorRequestEntity) {
        this.motorRequestEntity = motorRequestEntity;
        QuoteFragment quoteFragment = new QuoteFragment();
        quoteFragment.updateInputQuotefragment(motorRequestEntity);
        replaceFragment(1, "QUOTE");
    }
}
