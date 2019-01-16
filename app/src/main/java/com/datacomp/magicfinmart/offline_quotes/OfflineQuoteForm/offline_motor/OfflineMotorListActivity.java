package com.datacomp.magicfinmart.offline_quotes.OfflineQuoteForm.offline_motor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

public class OfflineMotorListActivity extends BaseActivity implements View.OnClickListener {

    FloatingActionButton fbOfflineMotor;
    RecyclerView rbOfflineMotor;
    boolean isHit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_motor_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init_widgets();
        setListeners();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //TODO: Fetch offline quote
        // showDialog("Loading offline");
    }

    //region initialisation widgets

    private void init_widgets() {
        fbOfflineMotor = (FloatingActionButton) findViewById(R.id.fbOfflineMotor);
        rbOfflineMotor = (RecyclerView) findViewById(R.id.rbOfflineMotor);
        rbOfflineMotor.setHasFixedSize(true);
        rbOfflineMotor.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setListeners() {
        fbOfflineMotor.setOnClickListener(this);

        rbOfflineMotor.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastCompletelyVisibleItemPosition = 0;

                lastCompletelyVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                        .findLastVisibleItemPosition();


               /* if (lastCompletelyVisibleItemPosition == mQuoteList.size() - 1) {
                    if (!isHit) {
                        isHit = true;
                        fetchMoreQuotes(mQuoteList.size());

                    }
                }*/
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
}
