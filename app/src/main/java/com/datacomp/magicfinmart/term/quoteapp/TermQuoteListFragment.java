package com.datacomp.magicfinmart.term.quoteapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.term.TermActivityTabsPagerAdapter;
import com.datacomp.magicfinmart.term.TermQuoteApplicationActivity;
import com.datacomp.magicfinmart.term.compareterm.CompareTermActivity;

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

    TextView tvAdd, tvSearch;
    EditText etSearch;
    ImageView ivSearch;

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
        setTextWatcher();
        listQuote = new ArrayList<>();
        if (getArguments().getParcelableArrayList(TermActivityTabsPagerAdapter.TERM_QUOTE_LIST) != null) {
            listQuote = getArguments().getParcelableArrayList(TermActivityTabsPagerAdapter.TERM_QUOTE_LIST);
        }

        mAdapter = new TermQuoteAdapter(this, listQuote);
        rvTermQuote.setAdapter(mAdapter);
        return view;
    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
        fbAddQuote.setOnClickListener(this);
    }

    private void init(View view) {
        ivSearch = (ImageView) view.findViewById(R.id.ivSearch);
        tvAdd = (TextView) view.findViewById(R.id.tvAdd);
        tvSearch = (TextView) view.findViewById(R.id.tvSearch);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);
        rvTermQuote = (RecyclerView) view.findViewById(R.id.rvTermQuote);
        rvTermQuote.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvTermQuote.setLayoutManager(layoutManager);
        fbAddQuote = (FloatingActionButton) view.findViewById(R.id.fbAddQuote);
    }


    private void setTextWatcher() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        compId = ((TermQuoteApplicationActivity) getActivity()).getCompId();
        if (v.getId() == R.id.fbAddQuote
                || v.getId() == R.id.tvAdd) {
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
        } else if (v.getId() == R.id.tvSearch
                || v.getId() == R.id.ivSearch) {
            if (etSearch.getVisibility() == View.INVISIBLE) {
                etSearch.setVisibility(View.VISIBLE);
                etSearch.requestFocus();
            }
        }

    }

    public void callInputTerm(int whichTerm, TermFinmartRequest termFinmartRequest) {
        Intent intent = new Intent(getActivity(), CompareTermActivity.class);
        intent.putExtra(TERM_FOR_INPUT_FRAGMENT, whichTerm);
        intent.putExtra(TERM_INPUT_FRAGMENT, termFinmartRequest);
        startActivity(intent);
    }

    public void removeQuote(TermFinmartRequest entity) {
        Toast.makeText(getContext(), "Remove called..", Toast.LENGTH_SHORT).show();
    }

}
