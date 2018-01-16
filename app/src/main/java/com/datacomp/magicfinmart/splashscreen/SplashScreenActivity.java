package com.datacomp.magicfinmart.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.introslider.PrefManager;
import com.datacomp.magicfinmart.introslider.WelcomeActivity;
import com.datacomp.magicfinmart.login.LoginActivity;

import magicfinmart.datacomp.com.finmartserviceapi.master.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.master.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.master.controller.MasterController;
import magicfinmart.datacomp.com.finmartserviceapi.master.response.AllCityMasterResponse;

public class SplashScreenActivity extends BaseActivity implements IResponseSubcriber {

    private static final String TAG = "Splashscreen";
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        prefManager = new PrefManager(this);
        if (prefManager.isFirstTimeLaunch()) {

            showDialog();
            new MasterController(this).getBikeMaster(this);
            new MasterController(this).getCarMaster(this);
            new MasterController(this).getRTOMaster(this);
            startActivity(new Intent(this, WelcomeActivity.class));

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                }
            }, SPLASH_DISPLAY_LENGTH);
        }


    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof AllCityMasterResponse) {
            prefManager.setFirstTimeLaunch(false);

        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
