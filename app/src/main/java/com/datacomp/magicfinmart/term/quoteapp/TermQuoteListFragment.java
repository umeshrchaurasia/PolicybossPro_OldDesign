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
import com.datacomp.magicfinmart.term.icici.TermICICIActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class TermQuoteListFragment extends BaseFragment implements View.OnClickListener {

    FloatingActionButton fbAddHealthQuote;

    public TermQuoteListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_health_quote, container, false);
        init(view);
        setListener();
        return view;
    }

    private void setListener() {
        fbAddHealthQuote.setOnClickListener(this);
    }

    private void init(View view) {
        fbAddHealthQuote = (FloatingActionButton) view.findViewById(R.id.fbAddHealthQuote);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fbAddHealthQuote) {
            startActivity(new Intent(getActivity(), TermICICIActivity.class));
        }
    }
}
