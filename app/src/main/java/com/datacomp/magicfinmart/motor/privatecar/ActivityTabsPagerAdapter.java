package com.datacomp.magicfinmart.motor.motorquote.privatecar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.datacomp.magicfinmart.motor.motorquote.privatecar.application.MotorApplicationFragment;
import com.datacomp.magicfinmart.motor.motorquote.privatecar.quote.MotorQuoteFragment;

public class ActivityTabsPagerAdapter extends FragmentPagerAdapter {

    public ActivityTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Salary fragment activity
                return new MotorQuoteFragment();
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