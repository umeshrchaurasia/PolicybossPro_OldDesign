package com.datacomp.magicfinmart.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import java.util.List;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.database.RealmDatabaseController;
import magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity;

public class SplashScreenActivity extends BaseActivity {

    private static final String TAG = "Splashscreen";
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    RealmDatabaseController realmDatabaseController;

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
        realmDatabaseController = new RealmDatabaseController(this);
        realmDatabaseController.setDashboardEntities(realmDatabaseController.makeDashboardTables());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<DashboardEntity> dashboardEntities = realmDatabaseController.getDashBoardList();
                Log.d("track", "test");
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
