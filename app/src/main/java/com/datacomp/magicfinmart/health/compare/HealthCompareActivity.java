package com.datacomp.magicfinmart.health.compare;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.health.fragment.HealthQuoteFragment;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;

public class HealthCompareActivity extends BaseActivity {

    RecyclerView rvBenefits;
    List<HealthQuoteEntity> listHealthQuote;
    HealthCompareViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_compare);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        listHealthQuote = new ArrayList<>();
        if (getIntent().getParcelableArrayListExtra(HealthQuoteFragment.HEALTH_COMPARE) != null) {
            listHealthQuote = getIntent().getParcelableArrayListExtra(HealthQuoteFragment.HEALTH_COMPARE);
            bindBenefits();
        }
    }

    private void bindBenefits() {

        mAdapter = new HealthCompareViewAdapter(this);
        rvBenefits.setAdapter(mAdapter);
    }

    private void init() {
        rvBenefits = (RecyclerView) findViewById(R.id.rvBenefits);
        int numberOfColumns = 4;
        rvBenefits.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
    }

}
