package com.datacomp.magicfinmart.loan_fm.personalloan.quote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.personalloan.PesonalLoan_QuoteAdapter;
import com.datacomp.magicfinmart.loan_fm.personalloan.addquote.PersonalLoanActivity;

import java.text.SimpleDateFormat;

/**
 * Created by IN-RB on 12-01-2018.
 */

public class PL_QuoteFragment  extends BaseFragment  implements View.OnClickListener{

    Button btnAddQuote;
    EditText etSearch;
    RecyclerView rvQuoteList;
    PesonalLoan_QuoteAdapter pesonalLoan_QuoteAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public PL_QuoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pl_quote, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        btnAddQuote = (Button) view.findViewById(R.id.btnAddQuote);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        rvQuoteList = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        rvQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvQuoteList.setLayoutManager(layoutManager);

        pesonalLoan_QuoteAdapter = new PesonalLoan_QuoteAdapter(getActivity());
        rvQuoteList.setAdapter(pesonalLoan_QuoteAdapter);
        btnAddQuote.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddQuote:
                startActivity(new Intent(getActivity(), PersonalLoanActivity.class));
                break;
        }
    }
}
