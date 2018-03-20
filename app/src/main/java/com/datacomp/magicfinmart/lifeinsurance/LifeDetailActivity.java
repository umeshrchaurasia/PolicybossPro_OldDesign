package com.datacomp.magicfinmart.lifeinsurance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.lifeinsurance.CompareInsurance.CompareInsDetailActivity;
import com.datacomp.magicfinmart.lifeinsurance.CompareInsurance.addquote.CompareInsMainActivity;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;

public class LifeDetailActivity extends BaseActivity implements View.OnClickListener {

    LinearLayout lyEdelweiss,lyTata,lyIcici,lyHdfc,lyCompare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initialize();
        setListner();


    }

    private void initialize()
    {
        lyEdelweiss = (LinearLayout)findViewById(R.id.lyEdelweiss);
        lyTata = (LinearLayout)findViewById(R.id.lyTata);
        lyIcici = (LinearLayout)findViewById(R.id.lyIcici);

        lyHdfc = (LinearLayout)findViewById(R.id.lyHdfc);
        lyCompare = (LinearLayout)findViewById(R.id.lyCompare);

    }

    private void setListner()
    {
        lyEdelweiss.setOnClickListener(this);
        lyTata.setOnClickListener(this);
        lyIcici.setOnClickListener(this);
        lyHdfc.setOnClickListener(this);
        lyCompare.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.lyCompare)
        {
          //  startActivity( new Intent(LifeDetailActivity.this, CompareInsDetailActivity.class));

            startActivity( new Intent(LifeDetailActivity.this, CompareInsMainActivity.class));

            //

        }

    }
}
