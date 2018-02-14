package com.datacomp.magicfinmart.health.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Sortbyroll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MemberListEntity;

public class HealthMemberDetailsDialogActivity extends BaseActivity implements View.OnClickListener {
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
        this.setFinishOnTouchOutside(true);
        init_widgets();
        listMemberList = new ArrayList<>();

        if (getIntent().getParcelableExtra(HealthInputFragment.MEMBER_LIST) != null) {
            healthQuote = getIntent().getParcelableExtra(HealthInputFragment.MEMBER_LIST);
            popupMemberDetail();
        }


        //  visibleCoverFor();
    }

    private void popupMemberDetail() {
        adapter = new HealthMemberDetailsViewAdapter(this, healthQuote.getHealthRequest().getMemberList());
        rvMemberDetail.setAdapter(adapter);
    }

    private void init_widgets() {
//        llSelf = (LinearLayout) findViewById(R.id.llSelf);
        btnContinue = (Button) findViewById(R.id.btnContinue);
//        swUnMarried = (Switch) findViewById(R.id.swUnMarried);
//        rbSelfMale = (RadioButton) findViewById(R.id.rbSelfMale);
//        rbSelfFemale = (RadioButton) findViewById(R.id.rbSelfFemale);
//
        rvMemberDetail = (RecyclerView) findViewById(R.id.rvMemberDetail);
        rvMemberDetail.setLayoutManager(new LinearLayoutManager(this));
        btnContinue.setOnClickListener(this);
    }

    private void visibleCoverFor() {
        if (healthQuote.getHealthRequest().getPolicyFor().equals("Self")) {
            //  llSelf.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnContinue) {

//            if (healthQuote.getHealthRequest().getPolicyFor().equals("Self")) {
//                MemberListEntity entity = healthQuote.getHealthRequest().getMemberList().get(0);
//                if (rbSelfMale.isChecked())
//                    entity.setMemberGender("M");
//                else
//                    entity.setMemberGender("F");
//
//                entity.setMemberNumber("1");
//
//                if (entity.getAge() > 18)
//                    entity.setMemberType("Adult");
//                else
//                    entity.setMemberType("Child");
//
//                entity.setMemberTypeID("1");
//
//                listMemberList.add(entity);
//                healthQuote.getHealthRequest().setMemberList(listMemberList);
//                Intent intent = new Intent();
//                intent.putExtra(HealthInputFragment.MEMBER_LIST, healthQuote);
//                setResult(HealthInputFragment.REQUEST_MEMBER, intent);
//                finish();
//            }
        }
    }


}
