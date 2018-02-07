package com.datacomp.magicfinmart.health.quoappfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.adapter.ActivityTabsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ApplicationListEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthApplicationFragment extends BaseFragment {
    RecyclerView rvHealthApplicationList;
    HealthApplicationAdapter healthApplicationAdapter;
    List<ApplicationListEntity> mApplicationList;

    public HealthApplicationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_health_application, container, false);
        initView(view);

        mApplicationList = new ArrayList<>();

        if (getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.APPLICATION_LIST) != null) {
            mApplicationList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.APPLICATION_LIST);
        }
        healthApplicationAdapter = new HealthApplicationAdapter(HealthApplicationFragment.this, mApplicationList);
        rvHealthApplicationList.setAdapter(healthApplicationAdapter);
        return view;
    }

    private void initView(View view) {
        rvHealthApplicationList = (RecyclerView) view.findViewById(R.id.rvHealthApplicationList);
        rvHealthApplicationList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvHealthApplicationList.setLayoutManager(layoutManager);
    }


}
