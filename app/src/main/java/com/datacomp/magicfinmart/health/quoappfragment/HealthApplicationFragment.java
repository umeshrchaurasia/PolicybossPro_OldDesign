package com.datacomp.magicfinmart.health.quoappfragment;


import android.os.Bundle;
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
import com.datacomp.magicfinmart.health.HealthActivityTabsPagerAdapter;
import com.datacomp.magicfinmart.motor.privatecar.adapter.ActivityTabsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ApplicationListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthApplication;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthApplicationFragment extends BaseFragment implements View.OnClickListener {
    RecyclerView rvHealthApplicationList;
    HealthApplicationAdapter healthApplicationAdapter;
    List<HealthApplication> mApplicationList;

    ImageView ivSearch, ivAdd;
    TextView tvAdd, tvSearch;
    EditText etSearch;

    public HealthApplicationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_health_application, container, false);
        initView(view);
        setListener();
        setTextWatcher();

        mApplicationList = new ArrayList<>();

        if (getArguments().getParcelableArrayList(HealthActivityTabsPagerAdapter.HEALTH_APPLICATION_LIST) != null) {
            mApplicationList = getArguments().getParcelableArrayList(HealthActivityTabsPagerAdapter.HEALTH_APPLICATION_LIST);
        }
        healthApplicationAdapter = new HealthApplicationAdapter(HealthApplicationFragment.this, mApplicationList);
        rvHealthApplicationList.setAdapter(healthApplicationAdapter);
        return view;
    }

    private void initView(View view) {

        ivSearch = (ImageView) view.findViewById(R.id.ivSearch);
        ivAdd = (ImageView) view.findViewById(R.id.ivAdd);
        tvAdd = (TextView) view.findViewById(R.id.tvAdd);
        tvSearch = (TextView) view.findViewById(R.id.tvSearch);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);

        rvHealthApplicationList = (RecyclerView) view.findViewById(R.id.rvHealthApplicationList);
        rvHealthApplicationList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvHealthApplicationList.setLayoutManager(layoutManager);
    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
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

    private void setTextWatcher() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                healthApplicationAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void redirectToQuote(HealthApplication application) {
        Toast.makeText(getContext(), "Application", Toast.LENGTH_SHORT).show();
    }

}
