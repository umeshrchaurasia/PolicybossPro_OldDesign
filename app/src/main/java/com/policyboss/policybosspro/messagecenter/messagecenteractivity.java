package com.policyboss.policybosspro.messagecenter;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.policyboss.policybosspro.BaseActivity;
import com.policyboss.policybosspro.R;
import com.policyboss.policybosspro.webviews.CommonWebViewActivity;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity;

public class messagecenteractivity  extends BaseActivity {

    DBPersistanceController databaseController;
    UserConstantEntity userConstantEntity;

    String empCode;
    String POSPNO="";
    String msgurl="";
    String fullmsgurl="";
    TextView txtMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagecenteractivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
       getSupportActionBar().setTitle("Message Center");

        init_widgets();
        txtMessage.setVisibility(View.VISIBLE);
        // incl_nav.setVisibility(View.GONE);
        txtMessage.setText("This Utility  is only available to Registered POSP");

     //   MessageCenter();

    }

    private void MessageCenter() {
        databaseController = new DBPersistanceController(messagecenteractivity.this);
        //  loginEntity = databaseController.getUserData();
        userConstantEntity = databaseController.getUserConstantsData();
        //  empCode= ""+loginEntity.getFBAId();

        POSPNO=""+userConstantEntity.getPospsendid();
        msgurl=""+userConstantEntity.getMessagesender();
        //   empCode="232";
        if(POSPNO.equals("5"))
        {
            txtMessage.setVisibility(View.VISIBLE);
           // incl_nav.setVisibility(View.GONE);
            txtMessage.setText("This Utility  is only available to Registered POSP");
        }else {
            txtMessage.setVisibility(View.GONE);
            txtMessage.setText("");

            String ipaddress = "0.0.0.0";
            try {
                ipaddress = "";
            } catch (Exception io) {
                ipaddress = "0.0.0.0";
            }

            String append = "&ip_address=" + ipaddress
                    + "&app_version=policyboss-" + Utility.getVersionName(this)
                    + "&device_id=" + Utility.getDeviceId(this);
            fullmsgurl = msgurl + append;
              startActivity(new Intent(this, CommonWebViewActivity.class)
                        .putExtra("URL", fullmsgurl)
                        .putExtra("NAME", "Message Center")
                        .putExtra("TITLE", "Message Center"));
              finish();
         //   incl_nav.setVisibility(View.VISIBLE);
          //  new PendingController(this).gettransactionhistory(empCode, "1", this);
        }
    }


    private void init_widgets() {

        txtMessage=(TextView)findViewById(R.id.txtMessage);


    }
}
