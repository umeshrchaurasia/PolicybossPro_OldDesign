package com.datacomp.magicfinmart.term;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.datacomp.magicfinmart.health.quoappfragment.HealthApplicationFragment;
import com.datacomp.magicfinmart.health.quoappfragment.HealthQuoteListFragment;
import com.datacomp.magicfinmart.term.quoteapp.TermApplicationListFragment;
import com.datacomp.magicfinmart.term.quoteapp.TermQuoteListFragment;

import java.util.ArrayList;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthQuoteAppResponse;


public class TermActivityTabsPagerAdapter extends FragmentStatePagerAdapter {

    public final static String TERM_QUOTE_LIST = "TERM_LIST_QUOTE";
    public final static String TERM_APPLICATION_LIST = "TERM_LIST_APPLICATION";
    HealthQuoteAppResponse mMasterData;
    private String[] pageTitle = new String[]{"QUOTES", "APPLICATION"};

    public TermActivityTabsPagerAdapter(FragmentManager fm, HealthQuoteAppResponse masterData) {
        super(fm);
        mMasterData = masterData;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle[position];
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:

                return new TermQuoteListFragment();
            case 1:

                return new TermApplicationListFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }
//
//    @Override
//    public int getItemPosition(Object object) {
//        return POSITION_NONE;
//    }
}