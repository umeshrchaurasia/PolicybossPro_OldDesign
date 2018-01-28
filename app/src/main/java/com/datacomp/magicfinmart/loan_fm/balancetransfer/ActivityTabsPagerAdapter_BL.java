package com.datacomp.magicfinmart.loan_fm.balancetransfer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.datacomp.magicfinmart.loan_fm.balancetransfer.application.BL_ApplicationFragment;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.quote.BL_QuoteFragment;

/**
 * Created by IN-RB on 26-01-2018.
 */

public class ActivityTabsPagerAdapter_BL extends FragmentPagerAdapter {

    public ActivityTabsPagerAdapter_BL(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Salary fragment activity
                return new BL_QuoteFragment();
            case 1:
                // ABN fragment activity
                return new BL_ApplicationFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }
}
