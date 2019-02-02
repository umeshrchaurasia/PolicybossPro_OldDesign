package com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.notification.NotificationActivity;
import com.datacomp.magicfinmart.notification.NotificationAdapter;
import com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content.adapter.UltraLakshyaDeathNomineeAdapter;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DeathBenefitEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.NotificationEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class UltraLakshayDeathNominee extends BaseFragment {


    RecyclerView rvDeathBenefit;
    List<DeathBenefitEntity> DeathBenefitLst;
    UltraLakshyaDeathNomineeAdapter mAdapter;
    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginEntity;
    PrefManager prefManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ultra_lakshay_death_nominee, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);


        mAdapter = new UltraLakshyaDeathNomineeAdapter(UltraLakshayDeathNominee.this, getDeathNomineeLst());
        rvDeathBenefit.setAdapter(mAdapter);
    }

    private void initialize(View view) {

        prefManager = new PrefManager(getActivity());
        DeathBenefitLst = new ArrayList<DeathBenefitEntity>();

        prefManager.setNotificationCounter(0);

        rvDeathBenefit = (RecyclerView) view.findViewById(R.id.rvDeathBenefit);
        rvDeathBenefit.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvDeathBenefit.setLayoutManager(layoutManager);


    }

    private  List<DeathBenefitEntity>  getDeathNomineeLst()
    {
        DeathBenefitLst.clear();
        for(int i =1; i <20 ; i++) {
            DeathBenefitEntity obj = new DeathBenefitEntity();
            obj.setYear(""+i);
            obj.setJeevanBenefitsPayable("" +500 +i);
            obj.setJeevanPremiumPaid(""+700 +i);
            obj.setLakshyaBenefitsPayable(""+178900 +i);
            obj.setLakshyaPremiumPaid(""+3347900 +i);
            DeathBenefitLst.add(obj);
        }

        return DeathBenefitLst;
    }


}
