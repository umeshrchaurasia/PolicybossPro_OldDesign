package com.datacomp.magicfinmart.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.introslider.PrefManager;
import com.datacomp.magicfinmart.introslider.WelcomeActivity;
import com.datacomp.magicfinmart.login.LoginActivity;

public class SplashScreenActivity extends BaseActivity {

    private static final String TAG = "Splashscreen";
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        prefManager = new PrefManager(this);
        if (prefManager.isFirstTimeLaunch()) {
            prefManager.setFirstTimeLaunch(false);
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
}
