package com.datacomp.magicfinmart.term.compareterm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

/**
 * Created by Rajeev Ranjan on 06/04/2018.
 */

public class CompareQuoteFragment extends BaseFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_term_compare_quote, container, false);
        /*registerPopUp(this);
        initView(view);
        setListener();
        listCompare = new ArrayList<>();
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<Integer, List<HealthQuoteEntity>>();
        txtCompareCount.setVisibility(View.GONE);

        if (getArguments() != null) {
            if (getArguments().getParcelable(HealthQuoteBottomTabsActivity.QUOTE_DATA) != null) {
                healthQuote = new HealthQuote();
                healthQuote = getArguments().getParcelable(HealthQuoteBottomTabsActivity.QUOTE_DATA);
                bindHeaders();
                fetchQuotes();
            }
        }*/

        return view;
    }
}
