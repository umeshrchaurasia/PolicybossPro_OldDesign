package com.datacomp.magicfinmart.loan_fm.laploan;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.datacomp.magicfinmart.loan_fm.laploan.application.LAP_ApplicationFragment;
import com.datacomp.magicfinmart.loan_fm.laploan.quote.LAP_QuoteFragment;

/**
 * Created by IN-RB on 22-01-2018.
 */

public class ActivityTabsPagerAdapter_LAP extends FragmentPagerAdapter {
    public ActivityTabsPagerAdapter_LAP(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Salary fragment activity
                return new LAP_QuoteFragment();
            case 1:
                // ABN fragment activity
                return new LAP_ApplicationFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }
}
