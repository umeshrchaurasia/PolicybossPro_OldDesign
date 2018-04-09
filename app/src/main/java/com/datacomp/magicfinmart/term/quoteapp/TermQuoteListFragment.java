package com.datacomp.magicfinmart.term.quoteapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.term.TermQuoteApplicationActivity;
import com.datacomp.magicfinmart.term.compareterm.CompareTiACtivity;
import com.datacomp.magicfinmart.term.icici.TermICICIActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class TermQuoteListFragment extends BaseFragment implements View.OnClickListener {
    public static final String TERM_INPUT_FRAGMENT = "input_term_fragment_bottom";
    FloatingActionButton fbAddQuote;
    int compId = 0;

    public TermQuoteListFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_term_quote_tab, container, false);
        init(view);
        setListener();
        return view;
    }

    private void setListener() {
        fbAddQuote.setOnClickListener(this);
    }

    private void init(View view) {
        fbAddQuote = (FloatingActionButton) view.findViewById(R.id.fbAddQuote);
    }

    @Override
    public void onClick(View v) {
        compId = ((TermQuoteApplicationActivity) getActivity()).getCompId();
        if (v.getId() == R.id.fbAddQuote) {
            switch (compId) {
                case 0://compare term
                    startActivity(new Intent(getActivity(), CompareTiACtivity.class));
                    break;
                case 43://edelwise
                    startActivity(new Intent(getActivity(), TermICICIActivity.class));
                    break;
                case 28://hdfc
                    startActivity(new Intent(getActivity(), TermICICIActivity.class));
                    break;
                case 39://icici
                    startActivity(new Intent(getActivity(), TermICICIActivity.class));
                case 1://tata aig
                    startActivity(new Intent(getActivity(), TermICICIActivity.class));
                    break;
            }
        }

    }
}
