package com.datacomp.magicfinmart.pendingcases;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.pendingcases.PendingController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PendingCasesEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PendingCasesResponse;

public class PendingCasesActivity extends BaseActivity implements IResponseSubcriber {

    RecyclerView rvPendingCasesList;
    PendingCasesAdapter mAdapter;
    PendingCasesEntity removePendingCasesEntity;
    List<PendingCasesEntity> mPendingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_cases);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        fetchPendingCases();
    }

    private void fetchPendingCases() {
        showDialog("Please wait.., loading cases");
        new PendingController(this).getPendingCases(
                String.valueOf(new DBPersistanceController(this).getUserData().getFBAId()), this);
    }

    private void init() {
        rvPendingCasesList = (RecyclerView) findViewById(R.id.rvPendingCasesList);
        rvPendingCasesList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvPendingCasesList.setLayoutManager(layoutManager);

    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof PendingCasesResponse) {
            mPendingList = ((PendingCasesResponse) response).getMasterData();
            mAdapter = new PendingCasesAdapter(this, mPendingList);
            rvPendingCasesList.setAdapter(mAdapter);
        }
//        else if () {
//            mPendingList.remove(removePendingCasesEntity);
//            mAdapter.refreshAdapter(mPendingList);
//            mAdapter.notifyDataSetChanged();
//        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public void deletePendingcases(PendingCasesEntity entity) {
        removePendingCasesEntity = entity;
        showDialog("Please wait,Removing case..");
        new PendingController(this).deletePending(entity.getQatype(), entity.getId(), this);
    }
}
