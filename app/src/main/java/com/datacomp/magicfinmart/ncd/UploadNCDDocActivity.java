package com.datacomp.magicfinmart.ncd;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model.NDCMasterEntity;

public class UploadNCDDocActivity extends BaseActivity {
    NDCMasterEntity mNCDEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_ncddoc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().getParcelableExtra("UPLOAD_NCD") != null) {
            mNCDEntity = getIntent().getParcelableExtra("UPLOAD_NCD");
        }
    }

}
