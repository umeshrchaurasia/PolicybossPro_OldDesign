
package com.datacomp.magicfinmart.loan_fm.businessloan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseERP;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberERP;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.erploan.ErpLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.LstCitywiseBankLoanEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.citywisebankloanResponse;


public class bank_selection_businessloanActivity extends BaseActivity   implements View.OnClickListener, IResponseSubcriberERP {
    RecyclerView rvQuotes;
    bank_display_businessloan_Adapter  mAdapter;

    citywisebankloanResponse getpersonal_bank_list_response;
    Toolbar toolbar;
    String Cityid="";
    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginResponseEntity;
    LinearLayout llmessage;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_selection_personalloan);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        llmessage = (LinearLayout)findViewById(R.id.llmessage) ;
        llmessage.setVisibility(View.GONE);

        btnBack= (Button) findViewById(R.id.btnBack) ;
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(bank_selection_businessloanActivity.this, city_selecton_businessloan_Activity.class));

            }
        });
        rvQuotes = (RecyclerView)findViewById(R.id.rvQuotes);
        rvQuotes.setLayoutManager(new LinearLayoutManager(bank_selection_businessloanActivity.this));
    //getBankdetail_personalloan
        Cityid= getIntent().getStringExtra("city_id");
        dbPersistanceController = new DBPersistanceController(bank_selection_businessloanActivity.this);
        loginResponseEntity = dbPersistanceController.getUserData();
        showDialog();
       new ErpLoanController(bank_selection_businessloanActivity.this).getCitywiseBankListloan(Cityid,"13", bank_selection_businessloanActivity.this);
    }

    @Override
    public void onClick(View v) {

    }


    public void redirectToApplyBankBL(LstCitywiseBankLoanEntity entity) {
        String url="";
        String Bankname="";

        if(entity.getBank_Id().equals("33")){
            Bankname="KOTAK MAHINDRA BANK";
         //   url="https://www.rupeeboss.com/kotakmahindra-pl?BrokerId=" + loginResponseEntity.getLoanId()+"&FBAId=" + loginResponseEntity.getFBAId() + "&client_source=finmart&lead_id=";

        }else  if(entity.getBank_Id().equals("43")){
            Bankname="RBL BANK";
          //  url="https://www.rupeeboss.com/rbl-pl?BrokerId=" + loginResponseEntity.getLoanId()+"&FBAId=" + loginResponseEntity.getFBAId() + "&client_source=finmart&lead_id=";

        }else  if(entity.getBank_Id().equals("51")){
            Bankname="TATA CAPITAL";
           // url="https://www.rupeeboss.com/tatacapital-pl?BrokerId=" + loginResponseEntity.getLoanId()+"&FBAId=" + loginResponseEntity.getFBAId() + "&client_source=finmart&lead_id=";

        }else  if(entity.getBank_Id().equals("53")){
            Bankname="YES BANK";
          //  String url1 = "https://yesbankbot.buildquickbots.com/chat/rupeeboss/staff/?userid=" + loginResponseEntity.getFBAId()+ "&usertype=finmart&vkey=b34f02e9-8f1c";

           // Utility.loadWebViewUrlInBrowser(bank_selection_businessloanActivity.this,url1);
        }else  if(entity.getBank_Id().equals("20")){
            Bankname="HDFC BANK";
            url="https://www.rupeeboss.com/hdfc-bl?BrokerId=" + loginResponseEntity.getLoanId()+"&FBAId=" + loginResponseEntity.getFBAId() + "&client_source=finmart&lead_id=";
        }else  if(entity.getBank_Id().equals("2152")){
            Bankname="CASHE";
         //   url="https://www.rupeeboss.com/cashe-new?BrokerId=" + loginResponseEntity.getLoanId()+"&FBAId=" + loginResponseEntity.getFBAId() + "&client_source=finmart&lead_id=";
        }


            startActivity(new Intent(this, CommonWebViewActivity.class)
                    .putExtra("URL", url)
                    .putExtra("NAME", "" + Bankname)
                    .putExtra("TITLE", "" + Bankname));

        //  setFmBankRequest(entity);
    }

    @Override
    public void OnSuccessERP(APIResponseERP response, String message) {
        cancelDialog();
        if (response instanceof citywisebankloanResponse) {

            getpersonal_bank_list_response = ((citywisebankloanResponse) response);
            if (getpersonal_bank_list_response != null) {
                if(getpersonal_bank_list_response.getResult().size() > 0) {
                    llmessage.setVisibility(View.GONE);
                    mAdapter = new bank_display_businessloan_Adapter(bank_selection_businessloanActivity.this, getpersonal_bank_list_response.getResult());
                    rvQuotes.setAdapter(mAdapter);
                }else {
                    //  Toast.makeText(this, "Data Not Found", Toast.LENGTH_LONG).show();
                    llmessage.setVisibility(View.VISIBLE);
                }
            }else
            {
                Toast.makeText(this, getpersonal_bank_list_response.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, getpersonal_bank_list_response.getMessage(), Toast.LENGTH_LONG).show();
    }
}
