package com.datacomp.magicfinmart.pendingcases;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PendingCasesResponse;

public class PendingCasesActivity extends BaseActivity implements IResponseSubcriber {

    RecyclerView rvPendingCasesList;
    PendingCasesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_cases);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }

    private void init() {
        rvPendingCasesList = (RecyclerView) findViewById(R.id.rvPendingCasesList);
        rvPendingCasesList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvPendingCasesList.setLayoutManager(layoutManager);
        mAdapter = new PendingCasesAdapter(this, null);
        rvPendingCasesList.setAdapter(mAdapter);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof PendingCasesResponse) {
            mAdapter = new PendingCasesAdapter(this, ((PendingCasesResponse) response).getMasterData());
            rvPendingCasesList.setAdapter(mAdapter);
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
