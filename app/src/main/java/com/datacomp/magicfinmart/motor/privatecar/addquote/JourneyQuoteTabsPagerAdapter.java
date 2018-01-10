package com.datacomp.magicfinmart.motor.privatecar.addquote;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

import com.datacomp.magicfinmart.motor.privatecar.application.MotorApplicationFragment;
import com.datacomp.magicfinmart.motor.privatecar.quote.MotorQuoteFragment;

public class JourneyQuoteTabsPagerAdapter extends FragmentPagerAdapter {

    private static int TOTAL_FRAGMENTS = 3;


    public JourneyQuoteTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // input fragment activity
                return new InputFragment();
            case 1:
                // quote fragment activity
                return new QuoteFragment();

            case 2:
                // buy fragment activity
                return new BuyFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return TOTAL_FRAGMENTS;
    }

}