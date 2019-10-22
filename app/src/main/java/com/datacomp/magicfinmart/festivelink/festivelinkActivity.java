package com.datacomp.magicfinmart.festivelink;

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
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.salesmaterial.SalesMaterialController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.FestivalCompaignEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.FestivalCampaignResponse;


public class festivelinkActivity extends BaseActivity implements IResponseSubcriber {

    RecyclerView recyclerShareMessage;
    festivelinkAdapter mAdapter;
    List<FestivalCompaignEntity> listShareMessag;
    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginResponseEntity;
    FestivalCampaignResponse getfestivelinkResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festivelink);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init_widgets();


        dbPersistanceController = new DBPersistanceController(festivelinkActivity.this);
        loginResponseEntity = dbPersistanceController.getUserData();
        showDialog();
        new SalesMaterialController(festivelinkActivity.this).getfestivelink(String.valueOf(loginResponseEntity.getFBAId()), String.valueOf(loginResponseEntity.getLoanId()), "Finmart", festivelinkActivity.this);


    }

    private void init_widgets() {

        recyclerShareMessage = (RecyclerView) findViewById(R.id.recyclerShareMSG);
        recyclerShareMessage.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerShareMessage.setLayoutManager(mLayoutManager);


    }


    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof FestivalCampaignResponse) {

            getfestivelinkResponse = ((FestivalCampaignResponse) response);
            if (getfestivelinkResponse != null) {
                if (getfestivelinkResponse.getMasterData().size() > 0) {
                    mAdapter = new festivelinkAdapter(festivelinkActivity.this, getfestivelinkResponse.getMasterData());
                    recyclerShareMessage.setAdapter(mAdapter);


                } else {
                    Toast.makeText(this, "Data Not Found", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, getfestivelinkResponse.getMessage(), Toast.LENGTH_LONG).show();
            }


        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, getfestivelinkResponse.getMessage(), Toast.LENGTH_LONG).show();

    }
}
