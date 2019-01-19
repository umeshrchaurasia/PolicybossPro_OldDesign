package com.datacomp.magicfinmart.certificate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

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

public class POSP_certicate_appointment extends BaseActivity implements IResponseSubcriber {
    String type;
    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginEntity;
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
        dbPersistanceController = new DBPersistanceController(this);
        loginEntity = dbPersistanceController.getUserData();

        CertificateEntity requestEntity = new CertificateEntity();
        requestEntity.setSS_ID(Integer.valueOf(loginEntity.getPOSPNo()));
        requestEntity.setType(Integer.valueOf(type));

        showDialog("Please Wait...");
        new DynamicController(this).GetPospAppointmentLetter(requestEntity ,POSP_certicate_appointment.this);

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
}
