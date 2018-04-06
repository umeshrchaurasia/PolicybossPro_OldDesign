package com.datacomp.magicfinmart.term.compareterm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;

/**
 * Created by Rajeev Ranjan on 06/04/2018.
 */

public class CompareInputFragment extends BaseFragment {
    List<String> policyYear;
    DBPersistanceController dbPersistanceController;
    Spinner spPolicyTerm, spPremTerm;
    ArrayAdapter<String> PolicyTermAdapter, PremTermAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_term_compare_input, container, false);
        init(view);

        // set initial values
        dbPersistanceController = new DBPersistanceController(getActivity());
        policyYear = dbPersistanceController.getPremYearList();

        init_adapters();

        adapter_listener();
        /*if (getArguments() != null) {
            healthQuote = getArguments().getParcelable(HealthQuoteBottomTabsActivity.INPUT_DATA);
            healthRequestEntity = healthQuote.getHealthRequest();
            processMemberForAge();
            bindInput();
        } else {
            healthQuote.setAgent_source("App");
            healthQuote.setFba_id(new DBPersistanceController(getContext()).getUserData().getFBAId());
            //default self selected
            btnSelf.performClick();
        }
*/

        return view;
    }

    private void adapter_listener() {
        spPolicyTerm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spPremTerm.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void init_adapters() {
        PolicyTermAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, policyYear);
        spPolicyTerm.setAdapter(PolicyTermAdapter);

        PremTermAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, policyYear);
        spPremTerm.setAdapter(PremTermAdapter);
    }

    private void init(View view) {
        spPolicyTerm = (Spinner) view.findViewById(R.id.spPolicyTerm);
        spPremTerm = (Spinner) view.findViewById(R.id.spPremTerm);
    }
}
