package com.datacomp.magicfinmart.switchuser;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.myaccount.MyAccountActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.login.LoginController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PospAgentEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.LoginRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PospAgentResponse;

public class SwitchUserActivity extends BaseActivity implements IResponseSubcriber {
    Button btnswitchuser;
    PrefManager prefManager;
    LoginRequestEntity loginRequestEntity;
    final String mapKey = "map";
    LoginResponseEntity loginResponseEntity;
    DBPersistanceController db;
    RecyclerView rvSwitchUser;
    SwitchUserAdapter mAdapter;
    List<PospAgentEntity> switchUserLst;
    EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_user);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        loginRequestEntity = new LoginRequestEntity();
        db = new DBPersistanceController(SwitchUserActivity.this);
        loginResponseEntity = db.getUserData();


        initialize();
        setTextWatcher();
        showDialog();

        new LoginController(SwitchUserActivity.this).getPospAgentData("0", "", SwitchUserActivity.this);

        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etSearch.setCursorVisible(true);
            }
        });
    }

    private void initialize() {

        etSearch = (EditText) findViewById(R.id.etSearch);
        btnswitchuser = (Button) findViewById(R.id.btnswitchuser);

        rvSwitchUser = (RecyclerView) findViewById(R.id.rvSwitchUser);
        rvSwitchUser.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SwitchUserActivity.this);
        rvSwitchUser.setLayoutManager(layoutManager);


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


    @Override
    public void OnSuccess(APIResponse response, String message) {

        cancelDialog();
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
        } else if (response instanceof PospAgentResponse) {
            if (response.getStatusNo() == 0) {

                switchUserLst = ((PospAgentResponse) response).getMasterData();
                mAdapter = new SwitchUserAdapter(this, switchUserLst);
                rvSwitchUser.setAdapter(mAdapter);


            } else {
                rvSwitchUser.setAdapter(null);
                Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }


    private void setTextWatcher() {

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() > 2) {
                    mAdapter.getFilter().filter(s);
                } else {
                    mAdapter.findAll(switchUserLst);
                    etSearch.setCursorVisible(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void getUserSwitchData(PospAgentEntity pospAgentEntity)
    {
        //        Map<String, String> inputMap = new HashMap<String, String>();
//        inputMap.put("Parent_email", loginResponseEntity.getEmailID());
//        inputMap.put("Parent_name", loginResponseEntity.getUserName());
//        inputMap.put("Parent_UID", "");
//        inputMap.put("Parent_Fbaid", String.valueOf(loginResponseEntity.getFBAId()));
//
//        inputMap.put("Child_email", "finmart2016@gmail.com");
//        inputMap.put("Child_name", "val2");
//        inputMap.put("Child_UID", "val1");
//        inputMap.put("Child_Fbaid", "val2");
//        saveMap(inputMap);
//
//
//        new PrefManager(SwitchUserActivity.this).clearAll();
//        new DBPersistanceController(SwitchUserActivity.this).logout();
//
//        loginRequestEntity.setUserName("finmart2016@gmail.com");
//        loginRequestEntity.setPassword("12345");
//        loginRequestEntity.setDeviceId("" + new ReadDeviceID(SwitchUserActivity.this).getAndroidID());
//        loginRequestEntity.setTokenId("");
//
//
//        Map<String, String> outputMap = loadMap();
//        if (outputMap.containsKey("Parent_email")) {
//            String s1 = outputMap.get("Parent_email").toString();
//        }
//        if (outputMap.containsKey("Parent_name")) {
//            String s2 = outputMap.get("Parent_name").toString();
//        }
//        if (outputMap.containsKey("Parent_UID")) {
//            String s3 = outputMap.get("Parent_UID").toString();
//        }
//        if (outputMap.containsKey("Parent_Fbaid")) {
//            String s4 = outputMap.get("Parent_Fbaid").toString();
//        }
//
//        new LoginController(SwitchUserActivity.this).login(loginRequestEntity, SwitchUserActivity.this);

    }

    public void redirectToSwitchUser(PospAgentEntity pospAgentEntity) {



        ConfirmSwitchUser(pospAgentEntity);



    }



    public void ConfirmSwitchUser(PospAgentEntity pospAgentEntity) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(SwitchUserActivity.this);
            builder.setTitle("Switch User");

            builder.setMessage("Do you want to swith your account on: " +pospAgentEntity.getName());
            String positiveText = "Submit";
            String NegativeText = "Cancel";
            builder.setPositiveButton(positiveText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            getUserSwitchData(pospAgentEntity);
                            Intent intent = new Intent();
                            intent.putExtra("POSP_USER", "Data");
                            setResult(10, intent);
                            finish();
                            Toast.makeText(SwitchUserActivity.this, "User Switched Successfully...", Toast.LENGTH_SHORT).show();
                        }
                    });

            builder.setNegativeButton(NegativeText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            final android.support.v7.app.AlertDialog dialog = builder.create();
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } catch (Exception ex) {
            Toast.makeText(this, "Please try again..", Toast.LENGTH_SHORT).show();
        }
    }
}
