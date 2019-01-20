package com.datacomp.magicfinmart.certificate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.homeloan.loan_apply.HomeLoanApplyActivity;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.DynamicController;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity.CertificateEntity;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response.CertificateResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;

public class POSP_certicate_appointment extends BaseActivity implements View.OnClickListener, IResponseSubcriber  {
    String type;
    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginEntity;
    Button btnsendemail,btnview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posp_certicate_appointment);
        type = getIntent().getStringExtra("TYPE");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(type.equals("1")) {
            getSupportActionBar().setTitle("POSP Appointment Letter");
        }else {
            getSupportActionBar().setTitle("POSP Certificate");
        }
        btnsendemail = (Button) findViewById(R.id.btnsendemail);
        btnview = (Button) findViewById(R.id.btnview);

        dbPersistanceController = new DBPersistanceController(this);
        loginEntity = dbPersistanceController.getUserData();


        btnsendemail.setOnClickListener(this);
        btnview.setOnClickListener(this);

    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();

        if (response instanceof CertificateResponse) {
            if (response.getStatusNo() == 0) {
              String  URL = "" + ((CertificateResponse) response).getMasterData();
                Utility.loadWebViewUrlInBrowser(this,URL);

            }
        }

    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
    }

    @Override
    public void onClick(View view) {

            switch (view.getId()) {
            case R.id.btnsendemail:
                //startActivity(new Intent(this, OfflineMotorListActivity.class));
                break;
            case R.id.btnview:

                CertificateEntity requestEntity = new CertificateEntity();
                requestEntity.setSS_ID(Integer.valueOf(loginEntity.getPOSPNo()));
                //  requestEntity.setSS_ID(10325);
                requestEntity.setType(Integer.valueOf(type));

                showDialog("Please Wait...");
                new DynamicController(this).GetPospAppointmentLetter(requestEntity ,POSP_certicate_appointment.this);

                break;
        }

    }
}
