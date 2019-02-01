package com.datacomp.magicfinmart.term.ultralakshya.fragment.quote;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayBenefit;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayBenefitStandAlone;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayDeathNominee;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayProductCombo;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayVsJeevan;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.coverPage1Fragment;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.coverPage2Fragment;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.coverPage3Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajeev Ranjan on 31/01/2019.
 */

public class LakshayQuotePagerAdapter extends FragmentStatePagerAdapter {


    private final List<Fragment> mFragmentList = new ArrayList<>();

    public LakshayQuotePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                coverPage1Fragment objFrag1 = new coverPage1Fragment();
                return objFrag1;

            case 1:

                coverPage2Fragment objFrag2 = new coverPage2Fragment();
                return objFrag2;

            case 2:

                coverPage3Fragment objFrag3 = new coverPage3Fragment();
                return objFrag3;

            case 3:

                UltraLakshayBenefit objFrag4 = new UltraLakshayBenefit();
                return objFrag4;

            case 4:


                UltraLakshayBenefitStandAlone objFrag5 = new UltraLakshayBenefitStandAlone();
                return objFrag5;

            case 5:

                UltraLakshayVsJeevan objFrag6 = new UltraLakshayVsJeevan();
                return objFrag6;

            case 6:

                UltraLakshayDeathNominee objFrag7 = new UltraLakshayDeathNominee();
                return objFrag7;

            case 7:

                UltraLakshayProductCombo objFrag8 = new UltraLakshayProductCombo();
                return objFrag8;
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFrag(Fragment fragment) {
        mFragmentList.add(fragment);

    }
}
