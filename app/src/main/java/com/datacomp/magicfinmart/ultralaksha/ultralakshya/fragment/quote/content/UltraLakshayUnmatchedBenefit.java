package com.datacomp.magicfinmart.ultralaksha.ultralakshya.fragment.quote.content;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.database.UltraLakshaFacade;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakshaIllustrationResponseNew;

/**
 * A simple {@link Fragment} subclass.
 */
public class UltraLakshayUnmatchedBenefit extends Fragment {


     TextView  txtHdr,txtAnnualPrem1yearAmnt ,txtAnnualPrem2to7Amnt, txtAnnualPrem2to7Text,
     txtMaturityAfterYearText,txtMaturityAfterYearAmnt,
     txtLumpsumAmnt ,txtAnnualEndOfTermAmnt,
     txtMonthlyforYearText ,txtMonthlyforYearAmnt,
      txtOnMaturityDateAmnt;

    UltraLakshaFacade ultraLakshaFacade;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ultra_lakshay_unmatched_benefit, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
        ultraLakshaFacade = new UltraLakshaFacade(getActivity());

        setUnmatchedUI();

     //   Spannable wordtoSpan = new SpannableString(getResources().getString(R.string.UltraLakshyaHdr));

//        wordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 15, 30, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        txtHdr.setText(wordtoSpan);

        String text = getActivity().getResources().getString(R.string.UltraLakshyaHdr);
        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(text);
        ssBuilder.setSpan(
                new ForegroundColorSpan(getActivity().getResources().getColor(R.color.yellow)),
                text.indexOf("Ultra Lakshya"),
                text.indexOf("Ultra Lakshya") + String.valueOf("Ultra Lakshya").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        ssBuilder.setSpan(
                new ForegroundColorSpan(getActivity().getResources().getColor(R.color.yellow)),
                text.indexOf("LIC's Jeevan Lakshya"),
                text.indexOf("LIC's Jeevan Lakshya") + String.valueOf("LIC's Jeevan Lakshya").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        ssBuilder.setSpan(
                new ForegroundColorSpan(getActivity().getResources().getColor(R.color.yellow)),
                text.indexOf("HDFC Life's Click2Protect 3D"),
                text.indexOf("HDFC Life's Click2Protect 3D") + String.valueOf("HDFC Life's Click2Protect 3D").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

    }

    private void initialize(View view)
    {
        txtHdr = view.findViewById(R.id.txtHdr);
        txtAnnualPrem1yearAmnt = view.findViewById(R.id.txtAnnualPrem1yearAmnt);
        txtAnnualPrem2to7Amnt = view.findViewById(R.id.txtAnnualPrem2to7Amnt);
        txtAnnualPrem2to7Text = view.findViewById(R.id.txtAnnualPrem2to7Text);

        txtMaturityAfterYearText = view.findViewById(R.id.txtMaturityAfterYearText);
        txtMaturityAfterYearAmnt = view.findViewById(R.id.txtMaturityAfterYearAmnt);

        txtLumpsumAmnt = view.findViewById(R.id.txtLumpsumAmnt);
        txtAnnualEndOfTermAmnt = view.findViewById(R.id.txtAnnualEndOfTermAmnt);

        txtMonthlyforYearText = view.findViewById(R.id.txtMonthlyforYearText);
        txtMonthlyforYearAmnt = view.findViewById(R.id.txtMonthlyforYearAmnt);

        txtOnMaturityDateAmnt = view.findViewById(R.id.txtOnMaturityDateAmnt);

    }


    private void setUnmatchedUI()
    {
        if(ultraLakshaFacade.getPageoneUnmatchedList() != null)
        {

            UltraLakshaIllustrationResponseNew.MasterDataBean.PageoneUnmatchedBean objUnmatched = ultraLakshaFacade.getPageoneUnmatchedList().get(0);

            txtAnnualPrem1yearAmnt.setText(""+objUnmatched.getAnnualPremiumFirstYr());
            txtAnnualPrem2to7Amnt.setText(""+objUnmatched.getAnnualPremiumOtherYrs());
            txtAnnualPrem2to7Text.setText(""+objUnmatched.getOtherYrs());

            txtMaturityAfterYearText.setText(""+objUnmatched.getMaturityYear());
            txtMaturityAfterYearAmnt.setText(""+objUnmatched.getMaturityDateValue());

            txtLumpsumAmnt.setText(""+objUnmatched.getLumpsumpDeath());
            txtAnnualEndOfTermAmnt.setText(""+objUnmatched.getAnnualTillEOT());

            txtMonthlyforYearText.setText(""+objUnmatched.getMonthlyterm());
            txtMonthlyforYearAmnt.setText(""+objUnmatched.getMonthlytermValue());

            txtOnMaturityDateAmnt.setText(""+objUnmatched.getMaturityDateValue());

        }

    }


}
