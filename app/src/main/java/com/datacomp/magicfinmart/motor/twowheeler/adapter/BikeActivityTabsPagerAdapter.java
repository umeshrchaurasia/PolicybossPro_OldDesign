package com.datacomp.magicfinmart.motor.twowheeler.adapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.datacomp.magicfinmart.motor.twowheeler.fragment.BikeApplicationTabFragment;
import com.datacomp.magicfinmart.motor.twowheeler.fragment.BikeQuoteTabFragment;

import java.util.ArrayList;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteApplicationEntity;


public class BikeActivityTabsPagerAdapter extends FragmentPagerAdapter {

    public final static String QUOTE_LIST = "LIST_QUOTE";
    public final static String APPLICATION_LIST = "LIST_APPLICATION";
    QuoteApplicationEntity mMasterData;

    public BikeActivityTabsPagerAdapter(FragmentManager fm, QuoteApplicationEntity masterData) {
        super(fm);
        mMasterData = masterData;
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Salary fragment activity
                BikeQuoteTabFragment Qfragment = new BikeQuoteTabFragment();
                Bundle bundle = new Bundle();
                if (mMasterData == null) {
                    bundle.putParcelableArrayList(QUOTE_LIST, null);
                } else {
                    bundle.putParcelableArrayList(QUOTE_LIST, (ArrayList<? extends Parcelable>) mMasterData.getQuote());
                }
                Qfragment.setArguments(bundle);
                return Qfragment;
            case 1:
                // ABN fragment activity
                BikeApplicationTabFragment Afragment = new BikeApplicationTabFragment();
                Bundle Abundle = new Bundle();
                if (mMasterData == null) {
                    Abundle.putParcelableArrayList(APPLICATION_LIST, null);
                } else {
                    Abundle.putParcelableArrayList(APPLICATION_LIST, (ArrayList<? extends Parcelable>) mMasterData.getApplication());
                }
                Afragment.setArguments(Abundle);
                return Afragment;
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }

}