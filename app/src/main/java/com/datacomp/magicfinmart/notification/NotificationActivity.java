package com.datacomp.magicfinmart.notification;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.homeloan.HomeLoanDetailActivity;
import com.datacomp.magicfinmart.loan_fm.personalloan.PersonalLoanDetailActivity;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.NotificationEntity;

public class NotificationActivity extends AppCompatActivity {

    RecyclerView rvNotify;
    List<NotificationEntity>  NotificationLst;
    NotificationAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initialize();
    }

    private void initialize() {


        //clearNotifyCounter();

        rvNotify = (RecyclerView) findViewById(R.id.rvNotify);
        rvNotify.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NotificationActivity.this);
        rvNotify.setLayoutManager(layoutManager);

        NotificationLst = getNotifyLst();

       // Log.d("NOTIFYLST",NotificationLst.toString());

        if(NotificationLst.size() >0)
        {
            mAdapter = new NotificationAdapter(NotificationActivity.this, NotificationLst);
            rvNotify.setAdapter(mAdapter);
        }
        else{
            rvNotify.setAdapter(null);
            Snackbar.make(rvNotify, "No Data Available", Snackbar.LENGTH_SHORT).show();
        }

    }

    private   List<NotificationEntity>  getNotifyLst()
    {
        List<NotificationEntity>  NotificationLst ;
        NotificationLst = new ArrayList<NotificationEntity>();

        NotificationEntity notifyEntity1 = new NotificationEntity();
        notifyEntity1.setTitle("Finmart Offer 500" );
        notifyEntity1.setBody("Description  Data about partcicular prd " );
        notifyEntity1.setImg_url("http://i.stack.imgur.com/CE5lz.png");
        notifyEntity1.setDate("12-Feb-2018");
        notifyEntity1.setAction("PL");
        notifyEntity1.setIs_read(1);
        NotificationLst.add(notifyEntity1);

        for(int i=0; i <= 10 ; i++)
        {
            NotificationEntity notifyEntity = new NotificationEntity();
            notifyEntity.setTitle("Finmart Offer 500" + i);
            notifyEntity.setBody("Description  Data about partcicular prd ");
            notifyEntity.setImg_url("http://i.stack.imgur.com/CE5lz.png");
            notifyEntity.setDate("12-Feb-2018");
            notifyEntity.setAction("HL");
            notifyEntity.setIs_read(0);
            NotificationLst.add(notifyEntity);
        }

        return NotificationLst;
    }

    public void redirectToApplyLoan(NotificationEntity notifyEntity) {

        if(notifyEntity.getAction().equals("HL")) {

            startActivity(new Intent(this, HomeLoanDetailActivity.class));
            finish();
        }
        else if(notifyEntity.getAction().equals("PL")) {

            startActivity(new Intent(this, PersonalLoanDetailActivity.class));
            finish();
        }
    }



}
