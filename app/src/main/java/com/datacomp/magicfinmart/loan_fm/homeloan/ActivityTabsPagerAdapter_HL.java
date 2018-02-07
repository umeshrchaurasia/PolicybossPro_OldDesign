package com.datacomp.magicfinmart.loan_fm.homeloan;



import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.datacomp.magicfinmart.loan_fm.homeloan.application.HL_ApplicationFragment;
import com.datacomp.magicfinmart.loan_fm.homeloan.quote.HL_QuoteFragment;

import java.util.ArrayList;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteApplicationEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.HLQuoteApplicationEntity;


/**
 * Created by IN-RB on 19-01-2018.
 */

public class ActivityTabsPagerAdapter_HL extends FragmentPagerAdapter {

    public final static String QUOTE_LIST = "LIST_QUOTE";
    public final static String APPLICATION_LIST = "LIST_APPLICATION";
    HLQuoteApplicationEntity mMasterData;
    public ActivityTabsPagerAdapter_HL(FragmentManager fm, HLQuoteApplicationEntity masterData) {
        super(fm);
        mMasterData = masterData;
    }


    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Salary fragment activity

                HL_QuoteFragment Qfragment = new HL_QuoteFragment();
                Bundle bundle = new Bundle();

                if (mMasterData == null) {
                    bundle.putParcelableArrayList(QUOTE_LIST, null);

                }else{
                    bundle.putParcelableArrayList(QUOTE_LIST, (ArrayList<? extends Parcelable>) mMasterData.getQuote());
                }
                Qfragment.setArguments(bundle);
                return Qfragment;


            case 1:
                // ABN fragment activity
                HL_ApplicationFragment Afragment = new HL_ApplicationFragment();

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
