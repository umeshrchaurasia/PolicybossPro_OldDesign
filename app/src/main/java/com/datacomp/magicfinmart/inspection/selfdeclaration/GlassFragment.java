package com.datacomp.magicfinmart.inspection.selfdeclaration;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.R;
import magicfinmart.datacomp.com.finmartserviceapi.inspection.facade.FrontRearFacade;
import magicfinmart.datacomp.com.finmartserviceapi.inspection.entity.FrontRearEntity;
import com.datacomp.magicfinmart.inspection.selfdeclaration.adapters.GlassAdapter;
import com.datacomp.magicfinmart.inspection.utility.BaseFragment;
import com.datacomp.magicfinmart.inspection.utility.SimpleDividerItemDecoration;

import java.util.List;



/**
 * Created by Rajeev Ranjan on 11/12/2017.
 */

public class GlassFragment extends BaseFragment {
    RecyclerView frontRecycler;
    GlassAdapter mAdapter;
    List<FrontRearEntity> frontRearEntities;
    FrontRearFacade frontRearFacade;
    public GlassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_glass, container, false);
        intit_View(view);
        frontRearFacade = new FrontRearFacade(getActivity());
        frontRearEntities = frontRearFacade.getGlassList();
        mAdapter = new GlassAdapter(this, frontRearEntities);
        frontRecycler.setAdapter(mAdapter);
        return view;
    }

    private void intit_View(View view) {
        frontRecycler = (RecyclerView) view.findViewById(R.id.rvFront);
        frontRecycler.setHasFixedSize(true);
        frontRecycler.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        frontRecycler.setLayoutManager(mLayoutManager);
    }
}
