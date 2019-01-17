package com.datacomp.magicfinmart.offline_quotes.OfflineQuoteForm.health;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.offline_quotes.OfflineQuoteForm.offline_motor.InputOfflineMotorActivity;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;

public class OfflineHealthListActivityActivity extends BaseActivity implements View.OnClickListener ,IResponseSubcriber {

    FloatingActionButton fbOfflineHealth;
    RecyclerView rbOfflineHealth;
    boolean isHit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_health_list_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init_widgets();
        setListeners();

    }

    private void init_widgets() {
        fbOfflineHealth = (FloatingActionButton) findViewById(R.id.fbOfflineHealth);
        rbOfflineHealth = (RecyclerView) findViewById(R.id.rbOfflineHealth);
        rbOfflineHealth.setHasFixedSize(true);
        rbOfflineHealth.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setListeners() {
        fbOfflineHealth.setOnClickListener(this);

        rbOfflineHealth.addOnScrollListener(new RecyclerView.OnScrollListener() {
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

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.fbOfflineHealth) {

            startActivity(new Intent(this, InputOfflineHealthActivity.class));
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

    }

    @Override
    public void OnFailure(Throwable t) {

    }
}
