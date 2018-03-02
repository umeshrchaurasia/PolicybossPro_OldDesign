package com.datacomp.magicfinmart.helpfeedback;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.helpfeedback.aboutus.AboutUsActivity;
import com.datacomp.magicfinmart.helpfeedback.contactus.ContactUsActivity;
import com.datacomp.magicfinmart.helpfeedback.raiseticket.RaiseTicketActivity;
import com.datacomp.magicfinmart.underconstruction.UnderConstructionActivity;

public class HelpFeedBackActivity extends BaseActivity implements View.OnClickListener {

    CardView cvContactUs, cvRaiseTicket, cvAboutUs, cvDisclosure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_feed_back);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initWidgets();
        setListener();
    }

    private void setListener() {
        cvContactUs.setOnClickListener(this);
        cvRaiseTicket.setOnClickListener(this);
        cvAboutUs.setOnClickListener(this);
        cvDisclosure.setOnClickListener(this);
    }

    private void initWidgets() {
        cvContactUs = (CardView) findViewById(R.id.cvContactUs);
        cvRaiseTicket = (CardView) findViewById(R.id.cvRaiseTicket);
        cvAboutUs = (CardView) findViewById(R.id.cvAboutUs);
        cvDisclosure = (CardView) findViewById(R.id.cvDisclosure);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cvContactUs:
                startActivity(new Intent(this, ContactUsActivity.class));
                break;
            case R.id.cvRaiseTicket:
                startActivity(new Intent(this, RaiseTicketActivity.class));
                break;
            case R.id.cvAboutUs:
                startActivity(new Intent(this, AboutUsActivity.class));
                break;
            case R.id.cvDisclosure:
                startActivity(new Intent(this, UnderConstructionActivity.class));
                break;
        }
    }
}
