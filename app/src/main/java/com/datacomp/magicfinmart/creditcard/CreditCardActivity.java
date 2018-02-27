package com.datacomp.magicfinmart.creditcard;

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
import com.datacomp.magicfinmart.utility.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.creditcard.CreditCardController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CreditCardEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.FilterEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CreditCardMasterResponse;

public class CreditCardActivity extends BaseActivity implements IResponseSubcriber {

    public static final String SELECTED_CREDIT_CARD = "credit_card_detail";

    List<String> strFilterList;
    List<FilterEntity> listFilterEntity;
    List<CreditCardEntity> listCreditCardEntity;

    Spinner spIncome;
    ArrayAdapter<String> incomeAdapter;
    RecyclerView rvCreditCards;
    CreditCardsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);
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
        spIncome = (Spinner) findViewById(R.id.spIncome);
        rvCreditCards = (RecyclerView) findViewById(R.id.rvCreditCards);
        rvCreditCards.setLayoutManager(new LinearLayoutManager(this));

    }


    private void bindSpinner() {

        incomeAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, strFilterList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        // incomeAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, strFilterList);
        spIncome.setAdapter(incomeAdapter);


        spIncome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //1. income selection filer credit cards
                int amountID = getIncomeAmountID(spIncome.getSelectedItem().toString());
                //2. display credit cards
                mAdapter.refreshCreditCards(filterCreditCardsbtIncome(amountID));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        mAdapter = new CreditCardsAdapter(this, listCreditCardEntity);
        rvCreditCards.setAdapter(mAdapter);
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
        new CreditCardController(this).getAllCreditCards(this);
    }

    private void incomeFilterData() {
        strFilterList.clear();
        for (int i = 0; i < listFilterEntity.size(); i++) {
            strFilterList.add(listFilterEntity.get(i).getAmount());
        }

        strFilterList.add(0, "Select net annual income");
        bindSpinner();
    }

    private List<CreditCardEntity> filterCreditCardsbtIncome(int incomeType) {
        List<CreditCardEntity> list = new ArrayList<>();

        if (incomeType == 0) {
            return listCreditCardEntity;
        }
        for (int i = 0; i < listCreditCardEntity.size(); i++) {
            if (incomeType == listCreditCardEntity.get(i).getCreditCardAmountFilterId()) {
                list.add(listCreditCardEntity.get(i));
            }
        }

        return list;
    }

    public void redirectToApply(CreditCardEntity entity) {
        if (spIncome.getSelectedItemPosition() != 0) {
            // redirect to apply
            // 1- RBL, 2- ICICI
            if (entity.getCreditCardId() == 1) {
                Intent intent = new Intent(this, RBLCreditApplyActivity.class);
                intent.putExtra(SELECTED_CREDIT_CARD, entity);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Select net annual income", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

        cancelDialog();
        if (response instanceof CreditCardMasterResponse) {
            if (response.getStatusNo() == 0) {
                listFilterEntity = ((CreditCardMasterResponse) response).getMasterData().getFilter();
                listCreditCardEntity = ((CreditCardMasterResponse) response).getMasterData().getFilterdata();
                incomeFilterData();

            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
