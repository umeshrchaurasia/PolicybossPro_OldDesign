package com.datacomp.magicfinmart.term.ultralakshya.fragment.quote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayBenefitILLustration;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayBenefitStandAlone;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayDeathBenefitToNominee;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayProductCombo;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayScenarioOfBenefitsDeath;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayUnmatchedBenefit;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.coverPage1Fragment;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.coverPage2Fragment;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.coverPage3Fragment;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;

/**
 * Created by Rajeev Ranjan on 31/01/2019.
 */

public class LakshayQuotePagerAdapter extends FragmentStatePagerAdapter {

    String strUserName;
    private final List<Fragment> mFragmentList = new ArrayList<>();

    public LakshayQuotePagerAdapter(FragmentManager fm, String strName) {
        super(fm);
        this.strUserName = strName;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                coverPage1Fragment objFrag = new coverPage1Fragment();
                Bundle bundle = new Bundle();           // use bundle for paasing the data
                bundle.putString(Utility.ULTRA_LAKSHYA_HDR_NAME, strUserName);
                objFrag.setArguments(bundle);
                return objFrag;

            case 1:
                return new coverPage2Fragment();

            case 2:
                return new coverPage3Fragment();

            case 3:
                return new UltraLakshayUnmatchedBenefit();

            case 4:

                return new UltraLakshayBenefitStandAlone();

            case 5:
                return new UltraLakshayBenefitILLustration();

            case 6:

                return new UltraLakshayScenarioOfBenefitsDeath();


            case 7:
                return new UltraLakshayDeathBenefitToNominee();


            case 8:
                return new UltraLakshayProductCombo();


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
