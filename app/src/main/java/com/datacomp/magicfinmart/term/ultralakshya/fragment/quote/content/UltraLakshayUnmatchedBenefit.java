package com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.adapter.UltraLakshyaDeathNomineeAdapter;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.UltraLakshaFacade;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PageoneUnmatchedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UltraLakshayUnmatchedBenefit extends Fragment {


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
        View view = inflater.inflate(R.layout.fragment_ultra_lakshay_unmatched_benefit, container, false);
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
        if(ultraLakshaFacade.getPageoneUnmatchedList() != null)
        {

            PageoneUnmatchedList objUnmatched = ultraLakshaFacade.getPageoneUnmatchedList().get(0);

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
