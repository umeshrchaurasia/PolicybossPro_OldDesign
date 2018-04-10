package com.datacomp.magicfinmart.term.quoteapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.term.TermActivityTabsPagerAdapter;
import com.datacomp.magicfinmart.term.TermQuoteApplicationActivity;
import com.datacomp.magicfinmart.term.compareterm.CompareTermActivity;
import com.datacomp.magicfinmart.term.icici.TermICICIActivity;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;

/**
 * A simple {@link Fragment} subclass.
 */
public class TermQuoteListFragment extends BaseFragment implements View.OnClickListener {
    public static final String TERM_INPUT_FRAGMENT = "input_term_fragment_bottom";
    public static final String TERM_FOR_INPUT_FRAGMENT = "for_term_input";
    FloatingActionButton fbAddQuote;
    int compId = 0;

    List<TermFinmartRequest> listQuote;
    TermQuoteAdapter mAdapter;
    RecyclerView rvTermQuote;

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
        listQuote = new ArrayList<>();
        if (getArguments().getParcelableArrayList(TermActivityTabsPagerAdapter.TERM_QUOTE_LIST) != null) {
            listQuote = getArguments().getParcelableArrayList(TermActivityTabsPagerAdapter.TERM_QUOTE_LIST);
        }

        mAdapter = new TermQuoteAdapter(this, listQuote);
        rvTermQuote.setAdapter(mAdapter);
        return view;
    }

    private void setListener() {
        fbAddQuote.setOnClickListener(this);
    }

    private void init(View view) {
        rvTermQuote = (RecyclerView) view.findViewById(R.id.rvTermQuote);
        rvTermQuote.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvTermQuote.setLayoutManager(layoutManager);
        fbAddQuote = (FloatingActionButton) view.findViewById(R.id.fbAddQuote);
    }

    @Override
    public void onClick(View v) {
        compId = ((TermQuoteApplicationActivity) getActivity()).getCompId();
        if (v.getId() == R.id.fbAddQuote) {
            switch (compId) {
                case 1001://compare term
                case 43://edelwise
                case 28://hdfc
                case 39://icici
                case 1://tata aig
                    callInputTerm(compId, null);
                    break;
                default:
                    callInputTerm(0, null); //compare term
                    break;
            }
        }

    }

    public void callInputTerm(int whichTerm, TermFinmartRequest termFinmartRequest) {
        Intent intent = new Intent(getActivity(), CompareTermActivity.class);
        intent.putExtra(TERM_FOR_INPUT_FRAGMENT, whichTerm);
        intent.putExtra(TERM_INPUT_FRAGMENT, termFinmartRequest);
        startActivity(intent);
    }


}
