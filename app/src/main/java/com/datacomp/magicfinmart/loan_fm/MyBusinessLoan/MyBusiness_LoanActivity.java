package com.datacomp.magicfinmart.loan_fm.MyBusinessLoan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.businessloan.bank_selection_businessloanActivity;
import com.google.android.material.snackbar.Snackbar;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseERP;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberERP;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.erploan.ErpLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.MyBusinessLoanResponse;

public class MyBusiness_LoanActivity extends BaseActivity implements View.OnClickListener,IResponseSubcriberERP {
    LinearLayout listoflogin, UnsecuredisbursedAmount, ListFilesSanctioned, SecuredDisbursedAmount;
    MyBusinessLoanResponse myBusinessResponse;
    String strTitle = "";
    String strType = "";
    Toolbar toolbar;
    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginResponseEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_business__loan);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dbPersistanceController = new DBPersistanceController(MyBusiness_LoanActivity.this);
        loginResponseEntity = dbPersistanceController.getUserData();
        initalize();
    }

    private void initalize() {
        listoflogin = (LinearLayout) findViewById(R.id.listoflogin);
        UnsecuredisbursedAmount = (LinearLayout) findViewById(R.id.UnsecuredisbursedAmount);
        ListFilesSanctioned = (LinearLayout) findViewById(R.id.ListFilesSanctioned);

        SecuredDisbursedAmount = (LinearLayout) findViewById(R.id.SecuredDisbursedAmount);

        listoflogin.setOnClickListener(this);
        UnsecuredisbursedAmount.setOnClickListener(this);
        ListFilesSanctioned.setOnClickListener(this);

        SecuredDisbursedAmount.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.listoflogin) {
            getData("1" ,"No. Of Files Login");
        } else if (view.getId() == R.id.ListFilesSanctioned) {
            getData("2","No. Of Files Sanctioned");
        }
//        else if (view.getId() == R.id.personalLoan) {
//            getData("3",getResources().getString(R.string.no_files_dis));
//        }
        else if (view.getId() == R.id.UnsecuredisbursedAmount) {
            getData("4","Unsecured Disbursed Amount");
        } else if (view.getId() == R.id.SecuredDisbursedAmount) {
            getData("5","Secured Disbursed Amount");
        }
//        else if (view.getId() == R.id.businessLoan) {
//            getData("6",getResources().getString(R.string.tot_amnt_pay));
//        }
    }
    private void getData(String type, String title) {
        showDialog();
        strTitle = title;
        strType = type;
        new ErpLoanController(this).myBuisnessLoan( "", type, loginResponseEntity.getLoanId(), MyBusiness_LoanActivity.this);
    }

    @Override
    public void OnSuccessERP(APIResponseERP response, String message) {
        cancelDialog();
        if (response instanceof MyBusinessLoanResponse) {
            if (response.getStatusId() == 0) {
              myBusinessResponse = (MyBusinessLoanResponse) response;
                Intent intent = new Intent(MyBusiness_LoanActivity.this, BusinessPopUpActivity.class);
                intent.putExtra(Utility.MY_BUSISNESS, myBusinessResponse.getResult());
                intent.putExtra(Utility.MY_BUSISNESS_HDR,strTitle);
                intent.putExtra(Utility.MY_BUSISNESS_type,strType);
                startActivity(intent);
            } else {
                Snackbar.make(listoflogin, response.getMessage(), Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Snackbar.make(listoflogin, t.getMessage(), Snackbar.LENGTH_SHORT).show();
    }

}
