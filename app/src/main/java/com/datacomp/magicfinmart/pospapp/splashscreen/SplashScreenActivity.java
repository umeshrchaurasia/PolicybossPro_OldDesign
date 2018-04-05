package com.datacomp.magicfinmart.pospapp.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.login.LoginActivity;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.LoginFacade;

public class SplashScreenActivity extends BaseActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;
    LoginFacade loginFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.content_splash_screen_posp);
        loginFacade = new LoginFacade(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));


                /*AlertDialog.Builder builder = new AlertDialog.Builder(SplashScreenActivity.this);
                builder.setTitle("Study Time Finished!!!");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setMessage(" For Final Assessment – Click Yes\n\n Need more time to Study ?– Click No \n(After complete your study go back to Home page and Click on START EVALUATION)")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(SplashScreenActivity.this, StartExamActivity.class));
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();*/


                /*if (loginFacade.getUser() != null && !loginFacade.getUser().equals("")) {
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                }*/
            }
        }, SPLASH_DISPLAY_LENGTH);


    }
}
