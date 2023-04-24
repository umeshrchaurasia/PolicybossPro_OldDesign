package com.policyboss.policybosspro.offline_quotes.OfflineQuoteForm.offline_motor;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.policyboss.policybosspro.BaseActivity;
import com.policyboss.policybosspro.R;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.offline_quotes.OfflineQuotesController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.OfflineMotorListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineMotorListResponse;

public class OfflineMotorListActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {

    public final static String OFFLINE_MOTOR = "offline_motor_edit";

    FloatingActionButton fbOfflineMotor;
    RecyclerView rvOfflineMotor;
    OfflineMotorListItemAdapter mAdapter;
    boolean isHit = false;

    List<OfflineMotorListEntity> listMotorListEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_motor_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listMotorListEntity = new ArrayList<OfflineMotorListEntity>();
        init_widgets();
        setListeners();

    }

    @Override
    protected void onResume() {
        super.onResume();
        listMotorListEntity = new ArrayList<OfflineMotorListEntity>();
        fetchMoreQuotes(0);
    }

    private void fetchMoreQuotes(int count) {
        //TODO: Fetch offline quote
        showDialog("Loading offline list");
        // product_id= 1;//for motor
        new OfflineQuotesController(this).getOfflineMotorList("" + count, "1", this);

    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();

        if (response instanceof OfflineMotorListResponse) {

            List<OfflineMotorListEntity> list = ((OfflineMotorListResponse) response).getMasterData();
            if (list.size() > 0) {

                isHit = false;

                for (OfflineMotorListEntity entity : list) {

                    if (!listMotorListEntity.contains(entity))
                        listMotorListEntity.add(entity);

                }
            }

            mAdapter = new OfflineMotorListItemAdapter(this, listMotorListEntity);
            rvOfflineMotor.setAdapter(mAdapter);

        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
    }

    //region initialisation widgets

    private void init_widgets() {
        fbOfflineMotor = (FloatingActionButton) findViewById(R.id.fbOfflineMotor);
        rvOfflineMotor = (RecyclerView) findViewById(R.id.rbOfflineMotor);
        rvOfflineMotor.setHasFixedSize(true);
        rvOfflineMotor.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setListeners() {
        fbOfflineMotor.setOnClickListener(this);

        rvOfflineMotor.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastCompletelyVisibleItemPosition = 0;

                lastCompletelyVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                        .findLastVisibleItemPosition();


                if (lastCompletelyVisibleItemPosition == listMotorListEntity.size() - 2 && listMotorListEntity.size() > 6) {
                    if (!isHit) {
                        isHit = true;
                        fetchMoreQuotes(listMotorListEntity.size());

                    }
                }
            }
        });
    }

    //endregion

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fbOfflineMotor) {
            startActivity(new Intent(this, InputOfflineMotorActivity.class));
        }
    }

    public void editOfflineMotor(OfflineMotorListEntity entity) {

        Intent intent = new Intent(this, InputOfflineMotorActivity.class);
        intent.putExtra(OFFLINE_MOTOR, entity);
        startActivity(intent);

    }
}
