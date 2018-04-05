package com.datacomp.magicfinmart.pospapp.studymaterial;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.home.HomeActivity;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;
import com.datacomp.magicfinmart.pospapp.webviews.studymaterial.StudyMaterialActivity;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.StudyMaterialEntity;


public class ModuleResultActivity extends BaseActivity implements View.OnClickListener {

    TextView tvTotalMarks, tvMarksObtained, tvName, tvMessage, tvModuleNo, tvViewAns;
    int marksObtained, totalNoOfQuest, module;
    String name;
    Button btnNextModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intilize();
        setListener();
        bindData();
        if (module == 5) {
            btnNextModule.setText("Home");
            tvMessage.setText("");
        }

    }

    private void setListener() {
        btnNextModule.setOnClickListener(this);
        tvViewAns.setOnClickListener(this);
    }

    private void bindData() {
        marksObtained = getIntent().getIntExtra("marksObtained", 0);
        totalNoOfQuest = getIntent().getIntExtra("totalNoOfQuest", 0);
        name = getIntent().getStringExtra("NAME");
        module = getIntent().getIntExtra("MODULE", 0);
        tvMarksObtained.setText("" + marksObtained);
        tvTotalMarks.setText("" + totalNoOfQuest);
        tvName.setText("" + name);
        tvModuleNo.setText("" + module);
    }

    private void intilize() {
        tvTotalMarks = (TextView) findViewById(R.id.tvTotalMarks);
        tvMarksObtained = (TextView) findViewById(R.id.tvMarksObtained);
        tvName = (TextView) findViewById(R.id.tvName);
        btnNextModule = (Button) findViewById(R.id.btnNextModule);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        tvModuleNo = (TextView) findViewById(R.id.tvModuleNo);
        tvViewAns = (TextView) findViewById(R.id.tvViewAns);
        tvViewAns.setPaintFlags(tvViewAns.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNextModule:
                if (!btnNextModule.getText().equals("Home")) {
                    StudyMaterialEntity studyMaterialEntity = StudyMaterialAvailable.studyMaterialEntityList.get(module);
                    startActivity(new Intent(ModuleResultActivity.this, StudyMaterialActivity.class)
                            .putExtra("STUDY_MATERIAL", studyMaterialEntity));
                    finish();
                } else {
                    finish();
                    Intent intent = new Intent(ModuleResultActivity.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                break;
            case R.id.tvViewAns:
                startActivity(new Intent(ModuleResultActivity.this, ViewAnswerActivity.class));
                break;
        }
    }
}
