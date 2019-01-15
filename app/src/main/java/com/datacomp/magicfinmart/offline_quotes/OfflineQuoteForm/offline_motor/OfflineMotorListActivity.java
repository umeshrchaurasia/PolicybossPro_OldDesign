package com.datacomp.magicfinmart.offline_quotes.OfflineQuoteForm.offline_motor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

public class OfflineMotorListActivity extends BaseActivity implements View.OnClickListener {

    FloatingActionButton fbOfflineMotor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_motor_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init_widgets();
        setListeners();

    }

    @Override
    protected void onResume() {
        super.onResume();
        showDialog("Loading offline");
    }

    //region initialisation widgets

    private void init_widgets() {
        fbOfflineMotor = (FloatingActionButton) findViewById(R.id.fbOfflineMotor);
    }

    private void setListeners() {
        fbOfflineMotor.setOnClickListener(this);
    }

    //endregion

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.fbOfflineMotor) {

        }
    }
}
