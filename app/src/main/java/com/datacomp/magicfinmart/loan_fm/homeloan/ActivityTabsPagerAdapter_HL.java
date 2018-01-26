package com.datacomp.magicfinmart.loan_fm.homeloan;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.datacomp.magicfinmart.loan_fm.homeloan.application.HL_ApplicationFragment;
import com.datacomp.magicfinmart.loan_fm.homeloan.quote.HL_QuoteFragment;


/**
 * Created by IN-RB on 19-01-2018.
 */

public class ActivityTabsPagerAdapter_HL extends FragmentPagerAdapter {
    public ActivityTabsPagerAdapter_HL(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Salary fragment activity
                return new HL_QuoteFragment();
            case 1:
                // ABN fragment activity
                return new HL_ApplicationFragment();
        }

        return null;
    }
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }
}
