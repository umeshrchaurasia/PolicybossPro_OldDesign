package com.policyboss.policybosspro.notification;

import android.content.Intent;
import android.os.Bundle;

import com.policyboss.policybosspro.BuildConfig;
import com.policyboss.policybosspro.term.termselection.TermSelectionActivity;
import com.policyboss.policybosspro.webviews.CommonWebViewActivity;
import com.google.android.material.snackbar.Snackbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.policyboss.policybosspro.BaseActivity;
import com.policyboss.policybosspro.R;
import com.policyboss.policybosspro.utility.Constants;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register.RegisterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.NotificationEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.NotificationResponse;

public class NotificationActivity extends BaseActivity implements IResponseSubcriber {

    RecyclerView rvNotify;
    List<NotificationEntity>  NotificationLst;
    NotificationAdapter mAdapter;
    DBPersistanceController dbPersistanceController;
    UserConstantEntity userConstantEntity;
    LoginResponseEntity loginEntity;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dbPersistanceController = new DBPersistanceController(this);
        loginEntity = dbPersistanceController.getUserData();

        userConstantEntity = dbPersistanceController.getUserConstantsData();

        initialize();

       // getNotificationData
        showDialog("Fetching Data...");
        new RegisterController(NotificationActivity.this).getNotificationData(String.valueOf(loginEntity.getFBAId()), NotificationActivity.this);


    }

    private void initialize() {

        prefManager = new PrefManager(NotificationActivity.this);
        NotificationLst = new ArrayList<NotificationEntity>();

        prefManager.setNotificationCounter(0);

        rvNotify = (RecyclerView) findViewById(R.id.rvNotify);
        rvNotify.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NotificationActivity.this);
        rvNotify.setLayoutManager(layoutManager);



    }


    public void redirectToApplyLoan(NotificationEntity notifyEntity) {

        if(notifyEntity.getNotifyFlag() != null && notifyEntity.getWeb_url() != null){

            navigateViaNotification(notifyEntity.getNotifyFlag(),notifyEntity.getWeb_url(),notifyEntity.getWeb_title());
        }

    }


    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof NotificationResponse) {

            if (response.getStatusNo() == 0) {
                if ( ((NotificationResponse) response).getMasterData() != null) {

                    NotificationLst = ((NotificationResponse) response).getMasterData();

                    mAdapter = new NotificationAdapter(NotificationActivity.this, NotificationLst);
                    rvNotify.setAdapter(mAdapter);
                } else {
                    rvNotify.setAdapter(null);
                    Snackbar.make(rvNotify, "No Notification  Data Available", Snackbar.LENGTH_SHORT).show();
                }
            }else {
                rvNotify.setAdapter(null);
                Snackbar.make(rvNotify, "No Notification  Data Available", Snackbar.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();

       // intent.putExtra("COUNTER", "0");
        setResult(Constants.REQUEST_CODE, intent);
        finish();
        super.onBackPressed();
    }

    private void navigateViaNotification(String prdID, String WebURL, String Title) {

        if (prdID.equals("18")) {

            startActivity(new Intent(NotificationActivity.this, TermSelectionActivity.class));
            this.finish();

        } else {

            if( WebURL.trim().equals("") || Title.trim().equals("") )
            {

                return;
            }
            String ipaddress = "0.0.0.0";
            try {
                ipaddress = "";
            } catch (Exception io) {
                ipaddress = "0.0.0.0";
            }


            //&ip_address=10.0.3.64&mac_address=10.0.3.64&app_version=2.2.0&product_id=1
            String append = "&ss_id=" + userConstantEntity.getPOSPNo() + "&fba_id=" + userConstantEntity.getFBAId() + "&sub_fba_id=" +
                    "&ip_address=" + ipaddress + "&mac_address=" + ipaddress
                    + "&app_version=policyboss-" + BuildConfig.VERSION_NAME
                    + "&device_id=" + Utility.getDeviceId(NotificationActivity.this)
                    + "&product_id=" + prdID
                    + "&login_ssid=";
            WebURL = WebURL + append;

            this.finish();
            startActivity(new Intent(NotificationActivity.this, CommonWebViewActivity.class)
                    .putExtra("URL", WebURL)
                    .putExtra("NAME", Title.toUpperCase())
                    .putExtra("TITLE",Title.toUpperCase()));


        }

    }



}
