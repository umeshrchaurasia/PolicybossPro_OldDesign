package com.datacomp.magicfinmart.splashscreen;

import android.os.Bundle;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

public class SplashScreenActivity extends BaseActivity {

    private static final String TAG = "Splashscreen";
    private final int SPLASH_DISPLAY_LENGTH = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
            }
        }, SPLASH_DISPLAY_LENGTH);*/


    }
}
