package com.datacomp.magicfinmart.healthcheckupplans;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.health.HealthController;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.controller.healthcheckup.HealthCheckUPController;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.requestmodels.HealthPacksRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.requestmodels.PackDetailsEntity;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.response.HealthPackDetailsResponse;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.response.HealthPackResponse;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.response.HealthShortLinkResponse;

public class HealthCheckUpPlansActivity extends BaseActivity implements IResponseSubcriber, View.OnClickListener {

    DBPersistanceController dbPersistanceController;
    HealthPackDEntity healthPackDEntity;
    HealthPackDetailsDBean healthPackDetailsDBean;
    HealthCheckUPAdapter healthCheckUPAdapter;
    RecyclerView rvHealthCheck;
    ImageView imgShare;
    String strName = "";
    HealthShortLinkResponse linkResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_check_up_plans);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbPersistanceController = new DBPersistanceController(this);
        healthPackDEntity = dbPersistanceController.getHealthCheckUPPlans();
        init_widgets();

        //region fetch  data of health checkup plans
        HealthPacksRequestEntity healthPacksRequestEntity = new HealthPacksRequestEntity();
        PackDetailsEntity packDetailsEntity = new PackDetailsEntity();
        healthPacksRequestEntity.setPack_details(packDetailsEntity);
        showDialog();
        new HealthCheckUPController(this).getHealthPacks(healthPacksRequestEntity, this);
        //endregion


    }

    private void init_widgets() {
        imgShare = (ImageView) findViewById(R.id.imgShare);
        imgShare.setOnClickListener(this);
        rvHealthCheck = (RecyclerView) findViewById(R.id.rvHealthCheck);
        rvHealthCheck.setHasFixedSize(true);
        rvHealthCheck.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void OnSuccess(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.APIResponse response, String message) {
        if (response instanceof HealthPackResponse) {
            cancelDialog();
            if (((HealthPackResponse) response).getD() != null) {
                healthPackDEntity = ((HealthPackResponse) response).getD();
                if (healthPackDEntity != null) {
                    healthCheckUPAdapter = new HealthCheckUPAdapter(this, healthPackDEntity.getLstPackageDetails());
                    rvHealthCheck.setAdapter(healthCheckUPAdapter);
                }
            }
        } else if (response instanceof HealthPackDetailsResponse) {
            Log.d("Test", "success");
        } else if (response instanceof HealthShortLinkResponse) {

            linkResponse = (HealthShortLinkResponse) response;
            shareWhatsApp();
            //ShareWhatsApp("", "Test", );
        }
    }

    public void shareWhatsApp() {
        if (linkResponse != null && linkResponse.getMasterData() != null) {
            Constants.shareToWhatsApp(this, "Dear " + strName + "\n" +
                    " Hi. I am pleased to bring to you a Health Checkup package best suited for you, at discounted price from the best labs in India. What’s more the sample can be collected from your home and an accurate report delivered on your e-mail. You also get a doctor consultation FREE with every health checkup done Click on the below link to book your test and make payment online \n" +
                    linkResponse.getMasterData().get(0).getShortURL());
        } else {
            openDialog();
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imgShare) {
            if (strName.length() == 0)
                openDialog();
            else
                shareWhatsApp();

        }
    }

    private void openDialog() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        final EditText input;
        TextView btnShare;
        LayoutInflater inflater = this.getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.layout_healthassured_share, null);
        alertDialog.setView(dialogView);
        final AlertDialog dialog = alertDialog.create();

        input = (EditText) dialogView.findViewById(R.id.input);
        btnShare = (TextView) dialogView.findViewById(R.id.txtShare);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strName = input.getText().toString();
                dialog.dismiss();
                fetchShortLink(input);
            }
        });

        dialog.show();

    }

    private void fetchShortLink(EditText input) {
        //showDialog();
        new HealthController(HealthCheckUpPlansActivity.this).getShortLink(input.getText().toString(),
                HealthCheckUpPlansActivity.this);
    }


    private void ShareWhatsApp(String Title, String Bodymsg, String link) {


        String Deeplink;
        //"Look! This can make you look gorgeous from Nykaa";
        Deeplink = Bodymsg + "\n" + link;
        String prdSubject = "Magic Finmart";

        String prdDetail = Deeplink;


        try {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, prdDetail);

            shareIntent.setType("text/plain");

            PackageManager pm = getPackageManager();


            List<ResolveInfo> resInfo = pm.queryIntentActivities(shareIntent, 0);
            List<LabeledIntent> intentList = new ArrayList<LabeledIntent>();
            ///////////
            for (int i = 0; i < resInfo.size(); i++) {
                // Extract the label, append it, and repackage it in a LabeledIntent
                ResolveInfo ri = resInfo.get(i);
                String packageName = ri.activityInfo.packageName;
                String processName = ri.activityInfo.processName;
                String AppName = ri.activityInfo.name;

                if ((packageName.contains("whatsapp"))) {
                    shareIntent.setComponent(new ComponentName(packageName, ri.activityInfo.name));


                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, prdDetail);
                    shareIntent.setPackage(packageName);
                    intentList.add(new LabeledIntent(shareIntent, packageName, ri.loadLabel(pm), ri.icon));

                }
            }


            if (intentList.size() > 1) {
                intentList.remove(intentList.size() - 1);
            }

            Intent openInChooser = Intent.createChooser(shareIntent, "Share Via");

            // convert intentList to array
            //LabeledIntent[] extraIntents = intentList.toArray(new LabeledIntent[intentList.size()]);
            //openInChooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, extraIntents);

            startActivity(openInChooser);
        } catch (
                Exception e)

        {
            e.printStackTrace();
        }


    }


}
