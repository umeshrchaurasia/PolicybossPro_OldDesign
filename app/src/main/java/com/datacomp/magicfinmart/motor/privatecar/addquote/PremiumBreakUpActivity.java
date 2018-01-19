package com.datacomp.magicfinmart.motor.privatecar.addquote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.addquote.adapters.PremiumBreakUpAdapter;
import com.datacomp.magicfinmart.motor.privatecar.addquote.adapters.PremiumBreakUpAdapterEntity;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.motor.model.OwnDamageEntity;
import magicfinmart.datacomp.com.finmartserviceapi.motor.model.ResponseEntity;

public class PremiumBreakUpActivity extends AppCompatActivity {
    ResponseEntity responseEntity;
    RecyclerView rvOwnDamage, rvLiability, rvAddonPremium;
    PremiumBreakUpAdapter damageAdapter, liabilityAdapter, addonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_premium_break_up);
        //getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFinishOnTouchOutside(false);

        if (getIntent().hasExtra("RESPONSE")) {
            responseEntity = getIntent().getParcelableExtra("RESPONSE");
        }
        initViews();
    }

    private void initViews() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvOwnDamage = (RecyclerView) findViewById(R.id.rvOwnDamage);
        rvLiability = (RecyclerView) findViewById(R.id.rvLiability);
        rvAddonPremium = (RecyclerView) findViewById(R.id.rvAddonPremium);

        rvOwnDamage.setHasFixedSize(true);
        rvLiability.setHasFixedSize(true);
        rvAddonPremium.setHasFixedSize(true);

        rvOwnDamage.setLayoutManager(mLayoutManager);
        rvLiability.setLayoutManager(mLayoutManager);
        rvAddonPremium.setLayoutManager(mLayoutManager);

        /*damageAdapter = new PremiumBreakUpAdapter(this, getDamageList());
        bikeQuoteRecycler.setAdapter(mAdapter);*/
    }


    public List<PremiumBreakUpAdapterEntity> getDamageList() {
        List<PremiumBreakUpAdapterEntity> damageList = new ArrayList<PremiumBreakUpAdapterEntity>();
        OwnDamageEntity ownDamageEntity = responseEntity.getPremium_Breakup().getOwn_damage();
        return damageList;
    }
}
