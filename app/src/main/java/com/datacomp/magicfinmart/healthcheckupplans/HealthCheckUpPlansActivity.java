package com.datacomp.magicfinmart.healthcheckupplans;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.controller.healthcheckup.HealthCheckUPController;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.requestmodels.HealthPacksDetailsRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.requestmodels.HealthPacksRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.requestmodels.PackDetailsEntity;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.requestmodels.PackParamEntity;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.response.HealthPackDetailsResponse;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.response.HealthPackResponse;

public class HealthCheckUpPlansActivity extends BaseActivity implements IResponseSubcriber {

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

        //region fetch  data of health checkup plans
        HealthPacksRequestEntity healthPacksRequestEntity = new HealthPacksRequestEntity();
        PackDetailsEntity packDetailsEntity = new PackDetailsEntity();
        healthPacksRequestEntity.setPack_details(packDetailsEntity);
        showDialog();
        new HealthCheckUPController(this).getHealthPacks(healthPacksRequestEntity, this);
        //endregion


    }

    private void init_widgets() {
        rvHealthCheck = (RecyclerView) findViewById(R.id.rvHealthCheck);
        rvHealthCheck.setHasFixedSize(true);
        rvHealthCheck.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void OnSuccess(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.APIResponse response, String message) {
        if (response instanceof HealthPackResponse) {
            cancelDialog();
            if (((HealthPackResponse) response).getD() != null) {
                healthPackDEntity = ((HealthPackResponse) response).getD();
                if (healthPackDEntity != null) {
                    healthCheckUPAdapter = new HealthCheckUPAdapter(this, healthPackDEntity.getLstPackageDetails());
                    rvHealthCheck.setAdapter(healthCheckUPAdapter);
                }
            }
        }
        if (response instanceof HealthPackDetailsResponse) {
            Log.d("Test", "success");
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private class HealthCheckUpRunnable implements Runnable {

        @Override
        public void run() {
            HealthPackDEntity lstPackageDetailsEntities = dbPersistanceController.getHealthCheckUPPlans();
            if (lstPackageDetailsEntities != null) {
                for (int i = 0; i < lstPackageDetailsEntities.getLstPackageDetails().size(); i++) {
                    HealthPacksDetailsRequestEntity healthPacksDetailsRequestEntity = new HealthPacksDetailsRequestEntity();
                    PackParamEntity packParamEntity = new PackParamEntity();
                    if (!lstPackageDetailsEntities.getLstPackageDetails().get(i).getPackCode().equals(""))
                        packParamEntity.setPackcode(Integer.parseInt(lstPackageDetailsEntities.getLstPackageDetails().get(i).getPackCode()));
                    healthPacksDetailsRequestEntity.setPack_param(packParamEntity);
                    new HealthCheckUPController(HealthCheckUpPlansActivity.this).getHealthPacksDetails(healthPacksDetailsRequestEntity, HealthCheckUpPlansActivity.this);
                }
            }
        }

    }
}
