package com.datacomp.magicfinmart.onlineexpressloan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;


import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.express_loan.controller.ExpressLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.ExpressLoanEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.ExpressLoanListResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.FilterEntity;


public class BanklistActivity extends BaseActivity implements IResponseSubcriber {

    public static final String SELECTED_CREDIT_CARD = "credit_card_detail";

    List<String> strFilterList;
    List<FilterEntity> listFilterEntity;
    List<ExpressLoanEntity> listCreditCardEntity;

   // Spinner spIncome;
    ArrayAdapter<String> incomeAdapter;
    RecyclerView rvbanklist;
    BanklistAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banklist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listFilterEntity = new ArrayList<>();
        listCreditCardEntity = new ArrayList<>();
        strFilterList = new ArrayList<>();

        init();

        fetchCreditCards();
    }

    private void init() {
     //   spIncome = (Spinner) findViewById(R.id.spIncome);
        rvbanklist = (RecyclerView) findViewById(R.id.rvbanklist);
        rvbanklist.setLayoutManager(new LinearLayoutManager(this));

    }


    private int getIncomeAmountID(String amountValue) {
        for (int i = 0; i < listFilterEntity.size(); i++) {
            if (amountValue.equals(listFilterEntity.get(i).getAmount())) {
                return listFilterEntity.get(i).getCreditCardAmountFilterId();
            }
        }
        return 0;
    }

    private void fetchCreditCards() {
        showDialog("Please wait.., Fetching credit cards");
        new ExpressLoanController(this).getExpressLoanList(this);
    }

    private void incomeFilterData() {
        strFilterList.clear();
        for (int i = 0; i < listFilterEntity.size(); i++) {
            strFilterList.add(listFilterEntity.get(i).getAmount());
        }

        strFilterList.add(0, "Select net annual income");
       // bindSpinner();
    }

    private List<ExpressLoanEntity> filterCreditCardsbtIncome(int incomeType) {
        List<ExpressLoanEntity> list = new ArrayList<>();

        if (incomeType == 0) {
            return listCreditCardEntity;
        }
        for (int i = 0; i < listCreditCardEntity.size(); i++) {
//            if (incomeType == listCreditCardEntity.get(i).getCreditCardAmountFilterId()) {
//                list.add(listCreditCardEntity.get(i));
//            }
        }

        return list;
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

        cancelDialog();
        if (response instanceof ExpressLoanListResponse) {
            if (response.getStatusNo() == 0) {
               // listFilterEntity = ((ExpressLoanListResponse) response).getMasterData().getFilter();
               // listCreditCardEntity = ((ExpressLoanListResponse) response).getMasterData().getFilterdata();
              //  incomeFilterData();

            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
