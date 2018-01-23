package com.datacomp.magicfinmart.loan_fm.laploan.quote;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.loan_fm.laploan.LapLoan_QuoteAdapter;

import java.text.SimpleDateFormat;

/**
 * Created by IN-RB on 22-01-2018.
 */

public class LAP_QuoteFragment  extends BaseFragment implements View.OnClickListener{
    FloatingActionButton hlAddQuote;

    RecyclerView rvQuoteList;
    LapLoan_QuoteAdapter homeLoan_QuoteAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public LAP_QuoteFragment() {

    }

    @Override
    public void onClick(View v) {

    }
}
