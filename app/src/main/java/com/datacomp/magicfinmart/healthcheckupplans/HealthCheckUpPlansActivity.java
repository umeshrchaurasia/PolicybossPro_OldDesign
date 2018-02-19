package com.datacomp.magicfinmart.healthcheckupplans;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean;

public class HealthCheckUpPlansActivity extends BaseActivity {

    DBPersistanceController dbPersistanceController;
    HealthPackDEntity healthPackDEntity;
    HealthPackDetailsDBean healthPackDetailsDBean;
    HealthCheckUPAdapter healthCheckUPAdapter;
    RecyclerView rvHealthCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_check_up_plans);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbPersistanceController = new DBPersistanceController(this);
        healthPackDEntity = dbPersistanceController.getHealthCheckUPPlans();
        init_widgets();

        if (healthPackDEntity != null) {
            healthCheckUPAdapter = new HealthCheckUPAdapter(this, healthPackDEntity.getLstPackageDetails());
            rvHealthCheck.setAdapter(healthCheckUPAdapter);
        }

    }

    private void init_widgets() {
        rvHealthCheck = (RecyclerView) findViewById(R.id.rvHealthCheck);
        rvHealthCheck.setHasFixedSize(true);
        rvHealthCheck.setLayoutManager(new LinearLayoutManager(this));
    }

}
