package com.datacomp.magicfinmart.term.ultralakshya.fragment.quote;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayBenefit;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayBenefitStandAlone;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayDeathNominee;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayProductCombo;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.UltraLakshayVsJeevan;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.coverPage1Fragment;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.coverPage2Fragment;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.coverPage3Fragment;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class UltraLakshayQuoteFragment extends BaseFragment {


    private ViewPager viewPager;
    CircleIndicator indicator;

    public UltraLakshayQuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lakshay_quote_view_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
    }

    private void initialize(View view) {

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        setupViewPager();

    }

    private void setupViewPager() {
        LakshayQuotePagerAdapter adapter = new LakshayQuotePagerAdapter(getActivity().getSupportFragmentManager());

        adapter.addFrag(new coverPage1Fragment());
        adapter.addFrag(new coverPage2Fragment());
        adapter.addFrag(new coverPage3Fragment());

        adapter.addFrag(new UltraLakshayBenefit());
        adapter.addFrag(new UltraLakshayBenefitStandAlone());
        adapter.addFrag(new UltraLakshayDeathNominee());

        adapter.addFrag(new UltraLakshayProductCombo());

        viewPager.setAdapter(adapter);

        indicator.setViewPager(viewPager);   //set the indicator

    }

}
