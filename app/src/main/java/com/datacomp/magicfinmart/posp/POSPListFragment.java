package com.datacomp.magicfinmart.posp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class POSPListFragment extends BaseFragment {

    RecyclerView rvPOSPList;
    FloatingActionButton fbAddPosp;

    public POSPListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_posplist, container, false);
        init(view);
        fbAddPosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddPOSPUserActivity.class));
            }
        });
        return view;
    }

    private void init(View view) {
        rvPOSPList = view.findViewById(R.id.rvPOSPList);
        fbAddPosp = view.findViewById(R.id.fbAddPosp);
    }

}
