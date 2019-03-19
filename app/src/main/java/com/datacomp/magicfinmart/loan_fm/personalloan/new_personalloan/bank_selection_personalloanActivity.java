

package com.datacomp.magicfinmart.loan_fm.personalloan.new_personalloan;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
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
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.DynamicController;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model.Personal_bankdetailEntity;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model.personal_bank_list_Response;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.PersonalQuoteEntity;


public class bank_selection_personalloanActivity extends BaseActivity   implements View.OnClickListener, IResponseSubcriber {
    RecyclerView rvQuotes;
    bank_display_personalloan_Adapter  mAdapter;

    personal_bank_list_Response getpersonal_bank_list_response;
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

                startActivity(new Intent(bank_selection_personalloanActivity.this, city_selecton_personalloan_Activity.class));

            }
        });
        rvQuotes = (RecyclerView)findViewById(R.id.rvQuotes);
        rvQuotes.setLayoutManager(new LinearLayoutManager(bank_selection_personalloanActivity.this));
//getBankdetail_personalloan
        Cityid= getIntent().getStringExtra("city_id");
        dbPersistanceController = new DBPersistanceController(bank_selection_personalloanActivity.this);
        loginResponseEntity = dbPersistanceController.getUserData();
        showDialog();
       new DynamicController(bank_selection_personalloanActivity.this).getBankdetail_personalloan(Cityid,bank_selection_personalloanActivity.this);
    }

    @Override
    public void onClick(View v) {

    }


    public void redirectToApplyBank(Personal_bankdetailEntity entity) {
        String url="";
        String Bankname="";

        if(entity.getBank_Id().equals("33")){
            Bankname="KOTAK MAHINDRA BANK";
            url="https://www.rupeeboss.com/kotakmahindra-pl?BrokerId=" + loginResponseEntity.getLoanId()+"&FBAId=" + loginResponseEntity.getFBAId() + "&client_source=finmart&lead_id=";

        }else  if(entity.getBank_Id().equals("43")){
            Bankname="RBL BANK";
            url="https://www.rupeeboss.com/rbl-pl?BrokerId=" + loginResponseEntity.getLoanId()+"&FBAId=" + loginResponseEntity.getFBAId() + "&client_source=finmart&lead_id=";

        }else  if(entity.getBank_Id().equals("51")){
            Bankname="TATA CAPITAL";
            url="https://www.rupeeboss.com/tatacapital-pl?BrokerId=" + loginResponseEntity.getLoanId()+"&FBAId=" + loginResponseEntity.getFBAId() + "&client_source=finmart&lead_id=";

        }else  if(entity.getBank_Id().equals("53")){
            Bankname="YES BANK";
            String url1 = "https://yesbankbot.buildquickbots.com/chat/rupeeboss/staff/?userid=" + loginResponseEntity.getFBAId()+ "&usertype=finmart&vkey=b34f02e9-8f1c";

            Utility.loadWebViewUrlInBrowser(bank_selection_personalloanActivity.this,url1);
        }else  if(entity.getBank_Id().equals("20")){
            Bankname="HDFC BANK";
            url="https://www.rupeeboss.com/hdfc-pl?BrokerId=" + loginResponseEntity.getLoanId()+"&FBAId=" + loginResponseEntity.getFBAId() + "&client_source=finmart&lead_id=";
        }else  if(entity.getBank_Id().equals("2152")){
            Bankname="CASHE";
            url="https://www.rupeeboss.com/cashe-new?BrokerId=" + loginResponseEntity.getLoanId()+"&FBAId=" + loginResponseEntity.getFBAId() + "&client_source=finmart&lead_id=";
        }

        if(!entity.getBank_Id().equals("53")) {
            startActivity(new Intent(this, CommonWebViewActivity.class)
                    .putExtra("URL", url)
                    .putExtra("NAME", "" + Bankname)
                    .putExtra("TITLE", "" + Bankname));
        }
        //  setFmBankRequest(entity);
    }
    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof personal_bank_list_Response) {

            getpersonal_bank_list_response = ((personal_bank_list_Response) response);
            if (getpersonal_bank_list_response != null) {
                if(getpersonal_bank_list_response.getData().size() > 0) {
                    llmessage.setVisibility(View.GONE);
                    mAdapter = new bank_display_personalloan_Adapter(bank_selection_personalloanActivity.this, getpersonal_bank_list_response.getData());
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
