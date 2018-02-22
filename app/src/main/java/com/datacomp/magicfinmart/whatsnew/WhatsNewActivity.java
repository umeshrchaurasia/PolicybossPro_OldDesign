package com.datacomp.magicfinmart.whatsnew;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.datacomp.magicfinmart.R;

import java.util.ArrayList;
import java.util.List;

public class WhatsNewActivity extends AppCompatActivity {
    RecyclerView rvWhatsNew;
    WhatsNewAdapter mAdapter;
    List<WhatsNewEntity> whatsNewEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_new);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        whatsNewEntities = new ArrayList<>();
        whatsNewEntities.add(new WhatsNewEntity("Improved UI", "This new version includes improved and streamlined UI with new icons."));
        whatsNewEntities.add(new WhatsNewEntity("Improved UI", "This new version includes improved and streamlined UI with new icons."));
        whatsNewEntities.add(new WhatsNewEntity("Improved UI", "This new version includes improved and streamlined UI with new icons."));
        whatsNewEntities.add(new WhatsNewEntity("Improved UI", "This new version includes improved and streamlined UI with new icons."));
        whatsNewEntities.add(new WhatsNewEntity("Improved UI", "This new version includes improved and streamlined UI with new icons."));
        rvWhatsNew = (RecyclerView) findViewById(R.id.rvWhatsNew);
        rvWhatsNew.setHasFixedSize(true);
        rvWhatsNew.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new WhatsNewAdapter(this, whatsNewEntities);
        rvWhatsNew.setAdapter(mAdapter);
    }

}
