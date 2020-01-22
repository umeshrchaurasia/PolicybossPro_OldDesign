package com.datacomp.magicfinmart.ultralaksha.ultralakshya.fragment.quote;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.ultralaksha.ultralakshya.fragment.quote.content.UltraLakshayScenarioOfBenefitsDeath;
import com.datacomp.magicfinmart.ultralaksha.ultralakshya.UltraLakshyaTermBottmActivity;
import com.datacomp.magicfinmart.ultralaksha.ultralakshya.fragment.quote.content.UltraLakshayUnmatchedBenefit;
import com.datacomp.magicfinmart.ultralaksha.ultralakshya.fragment.quote.content.UltraLakshayBenefitStandAlone;
import com.datacomp.magicfinmart.ultralaksha.ultralakshya.fragment.quote.content.UltraLakshayDeathBenefitToNominee;
import com.datacomp.magicfinmart.ultralaksha.ultralakshya.fragment.quote.content.UltraLakshayBenefitILLustration;
import com.datacomp.magicfinmart.ultralaksha.ultralakshya.fragment.quote.content.UltraLakshayProductCombo;
import com.datacomp.magicfinmart.ultralaksha.ultralakshya.fragment.quote.content.coverPage1Fragment;
import com.datacomp.magicfinmart.ultralaksha.ultralakshya.fragment.quote.content.coverPage2Fragment;
import com.datacomp.magicfinmart.ultralaksha.ultralakshya.fragment.quote.content.coverPage3Fragment;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class UltraLakshayQuoteFragment extends BaseFragment {


    private ViewPager viewPager;
    CircleIndicator indicator;
    String strUserName = "";

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

//             ((UltraLakshyaTermBottmActivity)getActivity()).getSupportActionBar().hide();
//        ((UltraLakshyaTermBottmActivity)getActivity()).manageHeader(false);


        if( getArguments().getString(UltraLakshyaTermBottmActivity.INPUT_DATA,"") != null)
        {
            strUserName =   getArguments().getString(UltraLakshyaTermBottmActivity.INPUT_DATA,"");

        }


        initialize(view);
    }

    private void initialize(View view) {

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        setupViewPager();

    }

    private void setupViewPager() {
        LakshayQuotePagerAdapter adapter = new LakshayQuotePagerAdapter(getActivity().getSupportFragmentManager(),strUserName);



        adapter.addFrag(new coverPage1Fragment());
        adapter.addFrag(new coverPage2Fragment());
        adapter.addFrag(new coverPage3Fragment());

        adapter.addFrag(new UltraLakshayUnmatchedBenefit());
        adapter.addFrag(new UltraLakshayBenefitStandAlone());
        adapter.addFrag(new UltraLakshayScenarioOfBenefitsDeath());

        adapter.addFrag(new UltraLakshayBenefitILLustration());
        adapter.addFrag(new UltraLakshayDeathBenefitToNominee());
        adapter.addFrag(new UltraLakshayProductCombo());

        viewPager.setAdapter(adapter);

        indicator.setViewPager(viewPager);   //set the indicator

    }

}
