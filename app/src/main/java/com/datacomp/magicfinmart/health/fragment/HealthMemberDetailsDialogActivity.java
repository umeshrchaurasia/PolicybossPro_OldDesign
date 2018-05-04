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

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MemberListEntity;

public class HealthMemberDetailsDialogActivity extends BaseActivity implements View.OnClickListener {

    public static final String UPDATE_MEMBER_QUOTE = "healthquote_update";

    HealthQuote healthQuote;
    Button btnContinue;
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

        adapter = new HealthMemberDetailsViewAdapter(this, healthQuote.getHealthRequest().getMemberList(), healthQuote.getHealthRequest().getPolicyFor());
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
            List<MemberListEntity> updateMember = new ArrayList<>();
            List<MemberListEntity> listMember = healthQuote.getHealthRequest().getMemberList();

            // region  Duplication Check for :self
            int isRelRepeat = 0;
            for (int i = 0; i < listMember.size(); i++) {
                MemberListEntity entity = listMember.get(i);
                if (entity.getMemberRelationShip().toLowerCase().equals("self")) {
                    isRelRepeat++;
                }
            }
            if (isRelRepeat > 1) {
                showAlert("Same Self selected multiple time");
                return;
            } else {
                isRelRepeat = 0;
            }
            //endregion

            // region  Duplication Check for :Spouce

            for (int i = 0; i < listMember.size(); i++) {
                MemberListEntity entity = listMember.get(i);
                if (entity.getMemberRelationShip().toLowerCase().equals("spouse")) {
                    isRelRepeat++;
                }
            }
            if (isRelRepeat > 1) {
                showAlert("Same Spouce selected multiple time");
                return;
            } else {
                isRelRepeat = 0;
            }
            //endregion

            // region  Duplication Check for :Father

            for (int i = 0; i < listMember.size(); i++) {
                MemberListEntity entity = listMember.get(i);
                if (entity.getMemberRelationShip().toLowerCase().equals("father")) {
                    isRelRepeat++;
                }
            }
            if (isRelRepeat > 1) {
                showAlert("Same Father selected multiple time");
                return;
            } else {
                isRelRepeat = 0;
            }
            //endregion

            // region  Duplication Check for :Mother

            for (int i = 0; i < listMember.size(); i++) {
                MemberListEntity entity = listMember.get(i);
                if (entity.getMemberRelationShip().toLowerCase().equals("mother")) {
                    isRelRepeat++;
                }
            }
            if (isRelRepeat > 1) {
                showAlert("Same Mother selected multiple time");
                return;
            } else {
                isRelRepeat = 0;
            }
            //endregion

            int isChildRepeat = 0;
            for (int i = 0; i < listMember.size(); i++) {
                MemberListEntity entity = listMember.get(i);
                if (entity.getMemberRelationShip().toLowerCase().equals("child1")) {
                    isChildRepeat++;
                }
            }
            if (isChildRepeat > 1) {
                showAlert("Same Child selected multiple time");
                return;
            } else {
                isChildRepeat = 0;
            }

            for (int i = 0; i < listMember.size(); i++) {
                MemberListEntity entity = listMember.get(i);
                if (entity.getMemberRelationShip().toLowerCase().equals("child2")) {
                    isChildRepeat++;
                }
            }
            if (isChildRepeat > 1) {
                showAlert("Same Child selected multiple time");
                return;
            } else {
                isChildRepeat = 0;
            }

            for (int i = 0; i < listMember.size(); i++) {
                MemberListEntity entity = listMember.get(i);
                if (entity.getMemberRelationShip().toLowerCase().equals("child3")) {
                    isChildRepeat++;
                }
            }
            if (isChildRepeat > 1) {
                showAlert("Same Child selected multiple time");
                return;
            } else {
                isChildRepeat = 0;
            }


            for (int i = 0; i < listMember.size(); i++) {
                MemberListEntity entity = listMember.get(i);
                if (entity.getMemberRelationShip().toLowerCase().equals("child4")) {
                    isChildRepeat++;
                }
            }

            if (isChildRepeat > 1) {
                Toast.makeText(this, "Same Child selected multiple time", Toast.LENGTH_SHORT).show();
                return;
            } else {
                isChildRepeat = 0;
            }


            for (int i = 0; i < listMember.size(); i++) {
                MemberListEntity entity = listMember.get(i);
                if (entity.getMemberRelationShip().toLowerCase().equals("self")) {
                    entity.setMemberNumber("1");
                    entity.setMemberTypeID("1");
                } else if (entity.getMemberRelationShip().toLowerCase().equals("spouse")) {
                    entity.setMemberNumber("2");
                    entity.setMemberTypeID("2");
                } else if (entity.getMemberRelationShip().toLowerCase().equals("father")) {
                    entity.setMemberNumber("3");
                    entity.setMemberTypeID("5");
                } else if (entity.getMemberRelationShip().toLowerCase().equals("mother")) {
                    entity.setMemberNumber("4");
                    entity.setMemberTypeID("4");
                } else if (entity.getMemberRelationShip().toLowerCase().equals("child1")) {
                    entity.setMemberNumber("5");
                    entity.setMemberTypeID("3");
                } else if (entity.getMemberRelationShip().toLowerCase().equals("child2")) {
                    entity.setMemberNumber("6");
                    entity.setMemberTypeID("3");
                } else if (entity.getMemberRelationShip().toLowerCase().equals("child3")) {
                    entity.setMemberNumber("7");
                    entity.setMemberTypeID("3");
                } else if (entity.getMemberRelationShip().toLowerCase().equals("child4")) {
                    entity.setMemberNumber("8");
                    entity.setMemberTypeID("3");
                }

                updateMember.add(entity);
            }


            healthQuote.getHealthRequest().setMemberList(updateMember);

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
