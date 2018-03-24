package com.datacomp.magicfinmart.dashboard;


import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
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
import com.datacomp.magicfinmart.knowledgeguru.KnowledgeGuruActivity;
import com.datacomp.magicfinmart.pendingcases.PendingCasesActivity;
import com.datacomp.magicfinmart.salesmaterial.SalesMaterialActivity;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters.MasterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.ConstantsResponse;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends BaseFragment implements IResponseSubcriber, BaseFragment.PopUpListener {

    RecyclerView rvHome;
    DashboardRowAdapter mAdapter;
    BottomNavigationView navigation;
    PackageInfo pinfo;
    View view;
    ConstantEntity constantEntity;
    PrefManager prefManager;
    int forceUpdate;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initialise(view);
        registerPopUp(this);
        prefManager = new PrefManager(getActivity());
        try {
            pinfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        mAdapter = new DashboardRowAdapter(DashboardFragment.this);
        this.rvHome.setAdapter(mAdapter);
        new MasterController(getActivity()).getConstants(this);
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

    @Override
    public void OnSuccess(APIResponse response, String message) {
        if (response instanceof ConstantsResponse) {
            constantEntity = ((ConstantsResponse) response).getMasterData();
            if (response.getStatusNo() == 0) {
                int serverVersionCode = Integer.parseInt(((ConstantsResponse) response).getMasterData().getVersionCode());
                if (pinfo != null && pinfo.versionCode < serverVersionCode) {
                    forceUpdate = Integer.parseInt(((ConstantsResponse) response).getMasterData().getIsForceUpdate());
                    if (forceUpdate == 1) {
                        // forced update app
                        openPopUp(view, "UPDATE", "New version available on play store!!!! Please update.", "OK", false);
                    } else {
                        // aap with less version but not forced update
                        if (prefManager.getUpdateShown()) {
                            prefManager.setIsUpdateShown(false);
                            openPopUp(view, "UPDATE", "New version available on play store!!!! Please update.", "OK", true);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
    }

    @Override
    public void onPositiveButtonClick(Dialog dialog, View view) {
        dialog.cancel();
        openAppMarketPlace();
    }

    @Override
    public void onCancelButtonClick(Dialog dialog, View view) {

        if (forceUpdate == 1) {

        } else {
            dialog.cancel();
        }
    }

    private void openAppMarketPlace() {
        final String appPackageName = getActivity().getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }

    }
}
