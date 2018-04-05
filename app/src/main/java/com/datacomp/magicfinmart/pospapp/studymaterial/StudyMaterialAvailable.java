package com.datacomp.magicfinmart.pospapp.studymaterial;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.login.LoginActivity;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.login.LoginController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.sendemail.SendEmailController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.LoginFacade;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.LoginEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.StudyMaterialEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.LogoutResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.SendEmailResponse;


public class StudyMaterialAvailable extends BaseActivity implements IResponseSubcriber {

    RecyclerView rvStudyMaterial;
    StudyMaterialAdapter mAdapter;
    static List<StudyMaterialEntity> studyMaterialEntityList;
    TextView tvWeb;
    LoginEntity loginEntity;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_material_available);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPreferences = getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        studyMaterialEntityList = new ArrayList<StudyMaterialEntity>();
        //studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI_Module 1", "https://drive.google.com/open?id=0BwKIYpAWxdc0U1JkMlRLRGRJbzQ", 5, 10, 0));
        //studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI_Module 2", "https://drive.google.com/open?id=0BwKIYpAWxdc0UmRWZDlCa2RDSlE", 12, 20, 0));
        //studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI_Module 3", "https://drive.google.com/open?id=0BwKIYpAWxdc0LW1OMXk1TjFkbmc", 10, 30, 0));
        //studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI_Module 4", "https://drive.google.com/open?id=0BwKIYpAWxdc0QnQ3eTlXNVNnUEE", 3, 10, 0));
        //studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI_Module 5", "https://drive.google.com/open?id=0BwKIYpAWxdc0ZmE5ajNqUjY5bFk", 3, 10, 0));

        //studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI-Module 1", "http://rupeeboss.org/HTMLPAGES/Training-Module-1.html", 5, 10, 0));
        //studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI-Module 2", "http://rupeeboss.org/HTMLPAGES/Training-Module-2.html", 12, 20, 0));
        //studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI-Module 3", "http://rupeeboss.org/HTMLPAGES/Training-Module-3.html", 10, 30, 0));
        //studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI-Module 4", "http://rupeeboss.org/HTMLPAGES/Training-Module-4.html", 3, 10, 0));
        //studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI-Module 5", "http://rupeeboss.org/HTMLPAGES/Training-Module-5.html", 3, 10, 0));

        studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI-Module 1", "http://edu.policyboss.com/eduappservice/HTMLPAGES/Training-Module-1.html", 5, 10, 0));
        studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI-Module 2", "http://edu.policyboss.com/eduappservice/HTMLPAGES/Training-Module-2.html", 12, 20, 0));
        studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI-Module 3", "http://edu.policyboss.com/eduappservice/HTMLPAGES/Training-Module-3.html", 10, 30, 0));
        studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI-Module 4", "http://edu.policyboss.com/eduappservice/HTMLPAGES/Training-Module-4.html", 3, 10, 0));
        studyMaterialEntityList.add(new StudyMaterialEntity("Regulatory Training GI-Module 5", "http://edu.policyboss.com/eduappservice/HTMLPAGES/Training-Module-5.html", 3, 10, 0));


        mAdapter = new StudyMaterialAdapter(this, studyMaterialEntityList);
        rvStudyMaterial = (RecyclerView) findViewById(R.id.rvStudyMaterial);
        rvStudyMaterial.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvStudyMaterial.setLayoutManager(mLayoutManager);
        rvStudyMaterial.setAdapter(mAdapter);
        tvWeb = (TextView) findViewById(R.id.tvWeb);
        tvWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(StudyMaterialAvailable.this);
                builder.setTitle(R.string.app_name);
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setMessage("Web Link will be sent to your registered email ID. You will be logged off from this device to access the link. ")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                showProgressDialog();
                                loginEntity = new LoginFacade(StudyMaterialAvailable.this).getUser();
                                new SendEmailController(StudyMaterialAvailable.this).sendEmail(loginEntity.getEmail(), loginEntity.getFullName(), StudyMaterialAvailable.this);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();


            }
        });
    }

    @Override
    public void OnSuccess(APIResponse response, String message) throws InterruptedException {
        dismissDialog();
        if (response instanceof SendEmailResponse) {
            if (response.getStatusNo() == 0) {
                // Toast.makeText(this, "Link has been sent to your  Emailid -  " + loginEntity.getEmail(), Toast.LENGTH_SHORT).show();
                new LoginController(StudyMaterialAvailable.this).logout(loginEntity.getUserId(), loginEntity.getFBAId(), this);
            }
        } else if (response instanceof LogoutResponse) {
            if (response.getStatusNo() == 0) {
                editor.clear();
                editor.commit();
                new LoginFacade(this).clearLoginCache();
                Intent intent = new Intent(this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            } else {
                Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        dismissDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
