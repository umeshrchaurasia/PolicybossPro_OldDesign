package com.datacomp.magicfinmart.motor.privatecar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.adapter.MotorApplicationAdapter;
import com.datacomp.magicfinmart.motor.privatecar.adapter.ActivityTabsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ApplicationListEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MotorApplicationFragment extends BaseFragment {
    RecyclerView rvApplicationList;
    MotorApplicationAdapter motorApplicationAdapter;
    List<ApplicationListEntity> mApplicationList;

    public MotorApplicationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_motor_application, container, false);
        initView(view);

        mApplicationList = new ArrayList<>();

        if (getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.APPLICATION_LIST) != null) {
            mApplicationList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.APPLICATION_LIST);
        }
        motorApplicationAdapter = new MotorApplicationAdapter(MotorApplicationFragment.this, mApplicationList);
        rvApplicationList.setAdapter(motorApplicationAdapter);
        return view;
    }

    private void initView(View view) {
        rvApplicationList = (RecyclerView) view.findViewById(R.id.rvApplicationList);
        rvApplicationList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvApplicationList.setLayoutManager(layoutManager);
    }


}
