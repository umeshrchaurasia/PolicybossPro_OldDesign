package com.datacomp.magicfinmart.health.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Sortbyroll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.health.HealthController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MemberListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthQuoteResponse;

public class HealthMemberDetailsDialogActivity extends BaseActivity implements View.OnClickListener {

    public static final String UPDATE_MEMBER_QUOTE = "healthquote_update";

    HealthQuote healthQuote;
    //    LinearLayout llSelf;
    Button btnContinue;
    //    Switch swUnMarried;
//    RadioButton rbSelfMale, rbSelfFemale;
    List<MemberListEntity> listMemberList;
    RecyclerView rvMemberDetail;
    HealthMemberDetailsViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_member_details_dialog);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFinishOnTouchOutside(false);
        init_widgets();
        listMemberList = new ArrayList<>();

        if (getIntent().getParcelableExtra(HealthInputFragment.MEMBER_LIST) != null) {
            healthQuote = getIntent().getParcelableExtra(HealthInputFragment.MEMBER_LIST);
            popupMemberDetail();
        }

    }

    private void popupMemberDetail() {
        adapter = new HealthMemberDetailsViewAdapter(this, healthQuote.getHealthRequest().getMemberList());
        rvMemberDetail.setAdapter(adapter);
    }

    private void init_widgets() {

        btnContinue = (Button) findViewById(R.id.btnContinue);
        rvMemberDetail = (RecyclerView) findViewById(R.id.rvMemberDetail);
        rvMemberDetail.setLayoutManager(new LinearLayoutManager(this));
        btnContinue.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnContinue) {

            Intent intent = new Intent();
            intent.putExtra(UPDATE_MEMBER_QUOTE, healthQuote);
            setResult(HealthInputFragment.REQUEST_MEMBER, intent);
            finish();

        }
    }


    public void updateMemberList(MemberListEntity entity, int maritialStatus, int position) {

        if (maritialStatus != 0) {
            healthQuote.getHealthRequest().setMaritalStatusID(maritialStatus);
        }

        MemberListEntity member = healthQuote.getHealthRequest().getMemberList().get(position);
        member = entity;
        healthQuote.getHealthRequest().getMemberList().set(position, member);

    }


}
