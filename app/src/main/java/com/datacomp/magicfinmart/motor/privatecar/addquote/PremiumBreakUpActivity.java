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

import magicfinmart.datacomp.com.finmartserviceapi.motor.model.AppliedAddonsPremiumBreakup;
import magicfinmart.datacomp.com.finmartserviceapi.motor.model.LiabilityEntity;
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

        rvOwnDamage.setLayoutManager(new LinearLayoutManager(this));
        damageAdapter = new PremiumBreakUpAdapter(this, getDamageList());
        rvOwnDamage.setAdapter(damageAdapter);

        rvLiability.setLayoutManager(new LinearLayoutManager(this));
        liabilityAdapter = new PremiumBreakUpAdapter(this, getLiabilityList());
        rvLiability.setAdapter(liabilityAdapter);


        rvAddonPremium.setLayoutManager(new LinearLayoutManager(this));
        addonAdapter = new PremiumBreakUpAdapter(this, getAddonList());
        rvAddonPremium.setAdapter(addonAdapter);

    }


    public List<PremiumBreakUpAdapterEntity> getDamageList() {
        List<PremiumBreakUpAdapterEntity> damageList = new ArrayList<PremiumBreakUpAdapterEntity>();
        OwnDamageEntity ownDamageEntity = responseEntity.getPremium_Breakup().getOwn_damage();
        if (!ownDamageEntity.getOd_basic().equals("0")) {
            damageList.add(new PremiumBreakUpAdapterEntity("Basic OD", ownDamageEntity.getOd_basic()));
        }
        if (!ownDamageEntity.getOd_disc().equals("0")) {
            damageList.add(new PremiumBreakUpAdapterEntity("OD Discount", ownDamageEntity.getOd_disc()));
        }
        if (!ownDamageEntity.getOd_non_elect_access().equals("0")) {
            damageList.add(new PremiumBreakUpAdapterEntity("NEA Premium", ownDamageEntity.getOd_non_elect_access()));
        }
        if (!ownDamageEntity.getOd_elect_access().equals("0")) {
            damageList.add(new PremiumBreakUpAdapterEntity("EA Premium", ownDamageEntity.getOd_elect_access()));
        }
        if (!ownDamageEntity.getOd_cng_lpg().equals("0")) {
            damageList.add(new PremiumBreakUpAdapterEntity("Bi Fuel Kit", ownDamageEntity.getOd_cng_lpg()));
        }
        if (!ownDamageEntity.getOd_disc_anti_theft().equals("0")) {
            damageList.add(new PremiumBreakUpAdapterEntity("Anti Theft Disc.", ownDamageEntity.getOd_disc_anti_theft()));
        }
        if (!ownDamageEntity.getOd_disc_vol_deduct().equals("0")) {
            damageList.add(new PremiumBreakUpAdapterEntity("Voluntary Disc.", ownDamageEntity.getOd_disc_vol_deduct()));
        }
        if (!ownDamageEntity.getOd_disc_aai().equals("0")) {
            damageList.add(new PremiumBreakUpAdapterEntity("AAI Discount", ownDamageEntity.getOd_disc_aai()));
        }
        if (!ownDamageEntity.getOd_disc_ncb().equals("0")) {
            damageList.add(new PremiumBreakUpAdapterEntity("NCB", ownDamageEntity.getOd_disc_ncb()));
        }
        if (!ownDamageEntity.getOd_loading().equals("0")) {
            damageList.add(new PremiumBreakUpAdapterEntity("Underwriter Loading", ownDamageEntity.getOd_loading()));
        }
        if (!ownDamageEntity.getOd_final_premium().equals("0")) {
            damageList.add(new PremiumBreakUpAdapterEntity("Total OD Premium", ownDamageEntity.getOd_final_premium()));
        }

        return damageList;
    }

    public List<PremiumBreakUpAdapterEntity> getLiabilityList() {
        List<PremiumBreakUpAdapterEntity> liabilityList = new ArrayList<PremiumBreakUpAdapterEntity>();
        LiabilityEntity liabilityEntity = responseEntity.getPremium_Breakup().getLiability();

        if (!liabilityEntity.getTp_basic().equals("0")) {
            liabilityList.add(new PremiumBreakUpAdapterEntity("Basic 3rd Party Premium", liabilityEntity.getTp_basic()));
        }
        if (!liabilityEntity.getTp_cover_owner_driver_pa().equals("0")) {
            liabilityList.add(new PremiumBreakUpAdapterEntity("PA Cover for Owner Driver", liabilityEntity.getTp_cover_owner_driver_pa()));
        }
        if (!liabilityEntity.getTp_cover_unnamed_passenger_pa().equals("0")) {
            liabilityList.add(new PremiumBreakUpAdapterEntity("Unnamed PA Cover for Passenger", liabilityEntity.getTp_cover_unnamed_passenger_pa()));
        }
        if (!liabilityEntity.getTp_cover_named_passenger_pa().equals("0")) {
            liabilityList.add(new PremiumBreakUpAdapterEntity("Named PA Cover for Passenger", liabilityEntity.getTp_cover_named_passenger_pa()));
        }
        if (!liabilityEntity.getTp_cover_paid_driver_pa().equals("0")) {
            liabilityList.add(new PremiumBreakUpAdapterEntity("PA Cover for Paid Driver", liabilityEntity.getTp_cover_paid_driver_pa()));
        }
        if (!liabilityEntity.getTp_cover_paid_driver_ll().equals("0")) {
            liabilityList.add(new PremiumBreakUpAdapterEntity("Legal Liability to Paid Driver", liabilityEntity.getTp_cover_paid_driver_ll()));
        }
        if (!liabilityEntity.getTp_cng_lpg().equals("0")) {
            liabilityList.add(new PremiumBreakUpAdapterEntity("Bi Fuel Kit Liability", liabilityEntity.getTp_cng_lpg()));
        }
        if (!liabilityEntity.getTp_final_premium().equals("0")) {
            liabilityList.add(new PremiumBreakUpAdapterEntity("Total Liability Premium", liabilityEntity.getTp_final_premium()));
        }
        return liabilityList;
    }

    public List<PremiumBreakUpAdapterEntity> getAddonList() {
        List<PremiumBreakUpAdapterEntity> addonList = new ArrayList<PremiumBreakUpAdapterEntity>();
        List<AppliedAddonsPremiumBreakup> appliedAddonsPremiumBreakups = responseEntity.getListAppliedAddons();
        for (AppliedAddonsPremiumBreakup appliedAddonsPremiumBreakup : appliedAddonsPremiumBreakups) {
            addonList.add(new PremiumBreakUpAdapterEntity(appliedAddonsPremiumBreakup.getAddonName(), "" + appliedAddonsPremiumBreakup.getPriceAddon()));
        }
        return addonList;
    }
}
