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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.modulepractice.ModulePracticeControllar;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.LoginFacade;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.LoginEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.PracticeModuleEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.ModulePracticeResponse;

public class ModulePracticeActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {
    int module;
    Button btnModuleSubmit;
    RecyclerView rvModule;
    LoginEntity loginEntity;
    ModulePracticeAdapter modulePracticeAdapter;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ModulePracticeResponse modulePracticeResponse;
    TextView tvModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_practice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        module = getIntent().getIntExtra("MODULE", -1);
        init();
        showProgressDialog();
        new ModulePracticeControllar(this).getModuleQuestion(module, loginEntity.getCategoryId(), loginEntity.getUserId(), this);
    }

    private void init() {
        sharedPreferences = getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        loginEntity = new LoginFacade(this).getUser();
        btnModuleSubmit = (Button) findViewById(R.id.btnModuleSubmit);
        btnModuleSubmit.setOnClickListener(this);
        rvModule = (RecyclerView) findViewById(R.id.rvModule);
        rvModule.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvModule.setLayoutManager(mLayoutManager);
        tvModule = (TextView) findViewById(R.id.tvModule);
        tvModule.setText("Practice Question Module : " + module);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnModuleSubmit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ModulePracticeActivity.this);
            builder.setTitle(R.string.app_name);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setMessage("Do you want to submit ? ")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            int marksObtained = calculateResult(modulePracticeResponse.getQuestionSet());
                            int totalNoOfQuest = modulePracticeResponse.getQuestionSet().size();
                            finish();
                            startActivity(new Intent(ModulePracticeActivity.this, ModuleResultActivity.class)
                                    .putExtra("marksObtained", marksObtained)
                                    .putExtra("totalNoOfQuest", totalNoOfQuest)
                                    .putExtra("NAME", loginEntity.getFullName())
                                    .putExtra("MODULE", modulePracticeResponse.getModuleNo()));

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
    }

    private int calculateResult(List<PracticeModuleEntity> practiceModuleEntities) {
        int marks = 0;
        for (PracticeModuleEntity practiceModuleEntity : practiceModuleEntities) {
            if (practiceModuleEntity.getCorrectAnswer().trim().equals(practiceModuleEntity.getUserInput()) && !practiceModuleEntity.getUserInput().isEmpty()) {
                //marks = marks + practiceModuleEntity.getMarks();
                marks++;
            }

        }
        return marks;
    }

    @Override
    public void OnSuccess(APIResponse response, String message) throws InterruptedException {
        dismissDialog();
        if (response instanceof ModulePracticeResponse) {
            if (response.getStatusNo() == 0) {
                modulePracticeResponse = (ModulePracticeResponse) response;
                modulePracticeAdapter = new ModulePracticeAdapter(this, modulePracticeResponse.getQuestionSet());
                rvModule.setAdapter(modulePracticeAdapter);
            } else {
                btnModuleSubmit.setVisibility(View.GONE);
                Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        dismissDialog();
        btnModuleSubmit.setVisibility(View.GONE);
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
