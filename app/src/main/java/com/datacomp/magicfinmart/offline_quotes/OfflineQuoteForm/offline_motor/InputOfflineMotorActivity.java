package com.datacomp.magicfinmart.offline_quotes.OfflineQuoteForm.offline_motor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity;

public class InputOfflineMotorActivity extends BaseActivity {

    DBPersistanceController dbController;
    List<InsuranceSubtypeEntity> insuranceSubtypeEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_offline_motor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbController = new DBPersistanceController(this);

        insuranceSubtypeEntities = dbController.getInsuranceSubTypeList(1, "renew");

    }

}
