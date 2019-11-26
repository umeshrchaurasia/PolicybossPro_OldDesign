package com.datacomp.magicfinmart.switchuser;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.login.LoginActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.ReadDeviceID;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.login.LoginController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.tracking.TrackingController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TrackingData;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.LoginRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TrackingRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginResponse;

public class SwitchUserActivity extends BaseActivity  implements IResponseSubcriber {
    Button btnswitchuser;
    PrefManager prefManager;
    LoginRequestEntity loginRequestEntity;
    final String mapKey = "map";
    LoginResponseEntity loginResponseEntity;
    DBPersistanceController db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_user);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loginRequestEntity = new LoginRequestEntity();
        btnswitchuser = (Button) findViewById(R.id.btnswitchuser);

        btnswitchuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db = new DBPersistanceController(SwitchUserActivity.this);
                loginResponseEntity = db.getUserData();

                Map<String, String> inputMap = new HashMap<String, String>();
                inputMap.put("Parent_email", loginResponseEntity.getEmailID());
                inputMap.put("Parent_name", loginResponseEntity.getUserName());
                inputMap.put("Parent_UID", "");
                inputMap.put("Parent_Fbaid", String.valueOf(loginResponseEntity.getFBAId()));

                inputMap.put("Child_email", "finmart2016@gmail.com");
                inputMap.put("Child_name", "val2");
                inputMap.put("Child_UID", "val1");
                inputMap.put("Child_Fbaid", "val2");
                saveMap(inputMap);


                new PrefManager(SwitchUserActivity.this).clearAll();
                new DBPersistanceController(SwitchUserActivity.this).logout();

                loginRequestEntity.setUserName("finmart2016@gmail.com");
                loginRequestEntity.setPassword("12345");
                loginRequestEntity.setDeviceId("" + new ReadDeviceID(SwitchUserActivity.this).getAndroidID());
                loginRequestEntity.setTokenId("");


                Map<String, String> outputMap = loadMap();
                if (outputMap.containsKey("Parent_email")) {
                    String s1 = outputMap.get("Parent_email").toString();
                }
                if (outputMap.containsKey("Parent_name"))
                {  String s2 = outputMap.get("Parent_name").toString();}
                if (outputMap.containsKey("Parent_UID")) {
                    String s3 = outputMap.get("Parent_UID").toString();
                }
                if (outputMap.containsKey("Parent_Fbaid")) {
                    String s4 = outputMap.get("Parent_Fbaid").toString();
                }

                new LoginController(SwitchUserActivity.this).login(loginRequestEntity, SwitchUserActivity.this
                );


            }
        });
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        if (response instanceof LoginResponse) {
            if (response.getStatusNo() == 0) {

                // prefManager.setIsUserLogin(true);


                    Intent intent = new Intent(SwitchUserActivity.this, HomeActivity.class);
                   // intent.putExtra(Utility.PUSH_LOGIN_PAGE, "555");
                    startActivity(intent);

                finish();
            } else {
                Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void saveMap(Map<String, String> inputMap) {
        SharedPreferences pSharedPref = getApplicationContext().getSharedPreferences("MyVariables",
                Context.MODE_PRIVATE);
        if (pSharedPref != null) {
            JSONObject jsonObject = new JSONObject(inputMap);
            String jsonString = jsonObject.toString();
            SharedPreferences.Editor editor = pSharedPref.edit();
            editor.remove(mapKey).apply();
            editor.putString(mapKey, jsonString);
            editor.commit();
        }
    }

    private Map<String, String> loadMap() {
        Map<String, String> outputMap = new HashMap<>();
        SharedPreferences pSharedPref = getApplicationContext().getSharedPreferences("MyVariables",
                Context.MODE_PRIVATE);
        try {
            if (pSharedPref != null) {
                String jsonString = pSharedPref.getString(mapKey, (new JSONObject()).toString());
                JSONObject jsonObject = new JSONObject(jsonString);
                Iterator<String> keysItr = jsonObject.keys();
                while (keysItr.hasNext()) {
                    String key = keysItr.next();
                    outputMap.put(key, jsonObject.get(key).toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputMap;
    }
}
