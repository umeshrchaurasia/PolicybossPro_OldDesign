package com.datacomp.magicfinmart.health.compare;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.health.fragment.HealthQuoteFragment;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BenefitsEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;

public class HealthCompareActivity extends BaseActivity {

    RecyclerView rvBenefits;
    List<HealthQuoteEntity> listHealthQuote;
    HealthCompareViewAdapter mAdapter;
    Spinner spBenefits;
    ArrayList<String> listBenefits;
    ArrayAdapter<String> benefitsAdapter;

    List<HealthQuoteEntity> displayHealthQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_compare);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        listBenefits = new ArrayList<>();
        listHealthQuote = new ArrayList<>();
        displayHealthQuote = new ArrayList<>();
        if (getIntent().getParcelableArrayListExtra(HealthQuoteFragment.HEALTH_COMPARE) != null) {
            listHealthQuote = getIntent().getParcelableArrayListExtra(HealthQuoteFragment.HEALTH_COMPARE);
            fillBenefits();
            bindBenefits();
        }

        spBenefits.setSelection(0);
    }


    private void bindBenefits() {

        mAdapter = new HealthCompareViewAdapter(this, listHealthQuote);
        rvBenefits.setAdapter(mAdapter);

        benefitsAdapter = new
                ArrayAdapter(this, android.R.layout.simple_list_item_1, listBenefits);
        spBenefits.setAdapter(benefitsAdapter);

        spBenefits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                updateBenefits(spBenefits.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void updateBenefits(String benefits) {

        for (int i = 0; i < listHealthQuote.size(); i++) {
            HealthQuoteEntity entity = listHealthQuote.get(i);

            for (int j = 0; j < entity.getLstbenfitsFive().size(); j++) {
                BenefitsEntity benefitsEntity = entity.getLstbenfitsFive().get(j);
                if (benefitsEntity.getBeneDesc().equals(benefits)) {
                    benefitsEntity.setSelected(true);
                    break;
                }
            }
        }

        mAdapter.refreshSelection(listHealthQuote);

    }

    private void init() {

        spBenefits = (Spinner) findViewById(R.id.spBenefits);
        rvBenefits = (RecyclerView) findViewById(R.id.rvBenefits);
        rvBenefits.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fillBenefits() {

        if (listHealthQuote.get(0) != null) {
            for (int i = 0; i < listHealthQuote.get(0).getLstbenfitsFive().size(); i++) {
                listBenefits.add(listHealthQuote.get(0).getLstbenfitsFive().get(i).getBeneDesc());
            }
        }
    }

}
