package com.datacomp.magicfinmart.generatelead;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.share_data.ShareDataFragment;
import com.datacomp.magicfinmart.vehicle_details.VehicleDetailFragment;

public class GenerateLeadActivity extends BaseActivity implements View.OnClickListener {

    Fragment fragment = null;
    LinearLayout llShareData, llVehicleDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_lead);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init_widgets();

        getSupportActionBar().setTitle("VEHICLE DETAIL");
        fragment = new VehicleDetailFragment();
        loadFragment(fragment);
    }

    private void init_widgets() {
        llShareData = findViewById(R.id.llShareData);
        llVehicleDetails = findViewById(R.id.llVehicleDetails);
        llShareData.setOnClickListener(this);
        llVehicleDetails.setOnClickListener(this);

    }

    public boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment);
            fragmentTransaction.commit();

            return true;
        }
        return false;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llVehicleDetails:
                getSupportActionBar().setTitle("VEHICLE DETAIL");
                fragment = new VehicleDetailFragment();
                loadFragment(fragment);
                break;
            case R.id.llShareData:
                fragment = new ShareDataFragment();
                getSupportActionBar().setTitle("SHARE DATA");
                loadFragment(fragment);
                break;
        }
    }
}
