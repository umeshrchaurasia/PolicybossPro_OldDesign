package com.datacomp.magicfinmart.dashboard;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pendingcases.PendingCasesActivity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;

import com.datacomp.magicfinmart.knowledgeguru.KnowledgeGuruActivity;
import com.datacomp.magicfinmart.salesmaterial.SalesMaterialActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends BaseFragment {

    RecyclerView rvHome;
    DashboardRowAdapter mAdapter;
    BottomNavigationView navigation;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initialise(view);

        mAdapter = new DashboardRowAdapter(DashboardFragment.this);
        this.rvHome.setAdapter(mAdapter);
        return view;
    }

    private void initialise(View view) {
        rvHome = (RecyclerView) view.findViewById(R.id.rvHome);
        rvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        navigation = (BottomNavigationView) view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_sales:
                    //redirect to sales
                    startActivity(new Intent(getContext(), SalesMaterialActivity.class));
                    return true;
                case R.id.nav_pending:
                    //redirect to pending status
                    startActivity(new Intent(getContext(), PendingCasesActivity.class));
                    return true;
                case R.id.nav_knowledge:
                    //redirect to knowledge guru
                    startActivity(new Intent(getActivity(), KnowledgeGuruActivity.class));
                    return true;
            }
            return false;
        }
    };
}
