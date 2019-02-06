package com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.database.UltraLakshaFacade;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PageTwoStandAloneList;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PageoneUnmatchedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UltraLakshayBenefitStandAlone extends BaseFragment {


    TextView txtAnnualPrem1yearAmnt ,txtAnnualPrem2to7Amnt, txtAnnualPrem2to7Text,
            txtMaturityAfterYearText,txtMaturityAfterYearAmnt,
            txtLumpsumAmnt ,txtAnnualEndOfTermAmnt,
            txtMonthlyforYearText ,txtMonthlyforYearAmnt,
            txtOnMaturityDateAmnt;

    UltraLakshaFacade ultraLakshaFacade;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_ultra_lakshay_benefit_stand_alone, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
        ultraLakshaFacade = new UltraLakshaFacade(getActivity());

        setUnmatchedUI();
    }

    private void initialize(View view)
    {
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
        if(ultraLakshaFacade.getPageTwoStandAloneList() != null)
        {

            PageTwoStandAloneList objStandAlone = ultraLakshaFacade.getPageTwoStandAloneList().get(0);

            txtAnnualPrem1yearAmnt.setText(""+objStandAlone.getAnnualPremiumFirstYr());
            txtAnnualPrem2to7Amnt.setText(""+objStandAlone.getAnnualPremiumOtherYrs());
            txtAnnualPrem2to7Text.setText(""+objStandAlone.getOtherYrs());

            txtMaturityAfterYearText.setText(""+objStandAlone.getMaturityYear());
            txtMaturityAfterYearAmnt.setText(""+objStandAlone.getMaturityDateValue());

            txtLumpsumAmnt.setText(""+objStandAlone.getLumpsumpDeath());
            txtAnnualEndOfTermAmnt.setText(""+objStandAlone.getAnnualTillEOT());

            txtMonthlyforYearText.setText(""+objStandAlone.getMonthlyterm());
            txtMonthlyforYearAmnt.setText(""+objStandAlone.getMonthlytermValue());

            txtOnMaturityDateAmnt.setText(""+objStandAlone.getMaturityDateValue());

        }

//        else{
//
//            txtAnnualPrem1yearAmnt.setText("Rs. 71750");
//            txtAnnualPrem2to7Amnt.setText("Rs. 70280");
//            txtAnnualPrem2to7Text.setText("2 to 17 years");
//
//            txtMaturityAfterYearText.setText("Maturity after 20 years");
//            txtMaturityAfterYearAmnt.setText("Rs. 1970000");
//
//            txtLumpsumAmnt.setText("NIL");
//            txtAnnualEndOfTermAmnt.setText("Rs. 100000");
//
//            txtMonthlyforYearText.setText("Monthly for 20 years");
//            txtMonthlyforYearAmnt.setText("NIL");
//
//            txtOnMaturityDateAmnt.setText("Rs. 1970000");
//
//        }
    }


}
