package com.datacomp.magicfinmart.dashboard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.controller.TempController;
import magicfinmart.datacomp.com.finmartserviceapi.database.RealmDatabaseController;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends BaseFragment {

    RecyclerView rvHome;
    DashboardRowAdapter mAdapter;

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

    }

}
