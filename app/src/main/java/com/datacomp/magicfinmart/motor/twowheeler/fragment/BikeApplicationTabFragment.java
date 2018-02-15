package com.datacomp.magicfinmart.motor.twowheeler.fragment;

import android.os.Bundle;
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

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.adapter.ActivityTabsPagerAdapter;
import com.datacomp.magicfinmart.motor.twowheeler.adapter.BikeApplicationTabAdapter;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ApplicationListEntity;

/**
 * Created by Rajeev Ranjan on 02/02/2018.
 */

public class BikeApplicationTabFragment extends BaseFragment implements View.OnClickListener {
    RecyclerView rvApplicationList;
    BikeApplicationTabAdapter bikeApplicationTabAdapter;
    List<ApplicationListEntity> mApplicationList;
    ImageView ivSearch, ivAdd;
    TextView tvAdd, tvSearch;
    EditText etSearch;

    public BikeApplicationTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.bike_fragment_app_tab, container, false);
        initView(view);
        setListener();
        setTextWatcher();
        mApplicationList = new ArrayList<>();

        if (getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.APPLICATION_LIST) != null) {
            mApplicationList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.APPLICATION_LIST);
        }
        rvApplicationList.setAdapter(null);
        bikeApplicationTabAdapter = new BikeApplicationTabAdapter(BikeApplicationTabFragment.this, mApplicationList);
        rvApplicationList.setAdapter(bikeApplicationTabAdapter);
        return view;
    }

    private void initView(View view) {

        ivSearch = (ImageView) view.findViewById(R.id.ivSearch);
        ivAdd = (ImageView) view.findViewById(R.id.ivAdd);
        tvAdd = (TextView) view.findViewById(R.id.tvAdd);
        tvSearch = (TextView) view.findViewById(R.id.tvSearch);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);

        rvApplicationList = (RecyclerView) view.findViewById(R.id.rvApplicationList);
        rvApplicationList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvApplicationList.setLayoutManager(layoutManager);
    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
    }

    private void setTextWatcher() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bikeApplicationTabAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSearch:
            case R.id.ivSearch:
                if (etSearch.getVisibility() == View.INVISIBLE) {
                    etSearch.setVisibility(View.VISIBLE);
                    etSearch.requestFocus();
                }
                break;
        }
    }
}
