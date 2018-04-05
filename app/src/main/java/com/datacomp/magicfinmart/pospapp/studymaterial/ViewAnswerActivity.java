package com.datacomp.magicfinmart.pospapp.studymaterial;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.datacomp.magicfinmart.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.PracticeModuleEntity;

public class ViewAnswerActivity extends AppCompatActivity {
    ViewAnswerAdapter viewAnswerAdapter;
    RecyclerView rvModule;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    List<PracticeModuleEntity> practiceModuleEntityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        bindAdapter();
    }

    private void bindAdapter() {
        viewAnswerAdapter = new ViewAnswerAdapter(this,practiceModuleEntityList);
        rvModule.setAdapter(viewAnswerAdapter);
    }

    private void init() {
        sharedPreferences = getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String practiceModelSet = sharedPreferences.getString(Constants.MODEL_PRACTICE, "");
        Type listType = new TypeToken<ArrayList<PracticeModuleEntity>>() {
        }.getType();
        practiceModuleEntityList = new Gson().fromJson(practiceModelSet, listType);
        rvModule = (RecyclerView) findViewById(R.id.rvModule);
        rvModule.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvModule.setLayoutManager(mLayoutManager);
    }

}
