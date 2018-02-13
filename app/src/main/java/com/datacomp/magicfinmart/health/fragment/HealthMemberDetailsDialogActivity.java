package com.datacomp.magicfinmart.health.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MemberListEntity;

public class HealthMemberDetailsDialogActivity extends BaseActivity implements View.OnClickListener {
    HealthQuote healthQuote;
    LinearLayout llSelf;
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_member_details_dialog);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Member details");
        init_widgets();

        if (getIntent().getParcelableExtra(HealthInputFragment.MEMBER_LIST) != null) {
            healthQuote = getIntent().getParcelableExtra(HealthInputFragment.MEMBER_LIST);
        }

        visibleCoverFor();
    }

    private void init_widgets() {
        llSelf = (LinearLayout) findViewById(R.id.llSelf);
        btnContinue = (Button) findViewById(R.id.btnContinue);
    }

    private void visibleCoverFor() {
        if (healthQuote.getHealthRequest().getPolicyFor().equals("Self")) {
            llSelf.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnContinue) {

        }
    }
}
