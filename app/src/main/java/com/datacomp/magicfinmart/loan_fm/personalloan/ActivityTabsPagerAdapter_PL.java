package com.datacomp.magicfinmart.loan_fm.personalloan;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.datacomp.magicfinmart.loan_fm.personalloan.quote.PL_QuoteFragment;
import com.datacomp.magicfinmart.motor.privatecar.application.MotorApplicationFragment;
import com.datacomp.magicfinmart.motor.privatecar.quote.MotorQuoteFragment;

/**
 * Created by IN-RB on 12-01-2018.
 */

public class ActivityTabsPagerAdapter_PL extends FragmentPagerAdapter {
    public ActivityTabsPagerAdapter_PL(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Salary fragment activity
                return new PL_QuoteFragment();
            case 1:
                // ABN fragment activity
                return new MotorApplicationFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }
}
