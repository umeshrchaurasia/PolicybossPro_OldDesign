package com.datacomp.magicfinmart.healthcheckupplans;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.motor.privatecar.activity.InputQuoteBottmActivity;

public class HealthCheckUpListActivity extends BaseActivity implements View.OnClickListener {

    RecyclerView rvHealthCheckUpList;
    ImageView ivSearch;
    TextView tvAdd, tvSearch;
    EditText etSearch;
    FloatingActionButton fbAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_check_up_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initView();
        setListener();
        setTextWatcher();

    }

    private void initView() {
        fbAdd = (FloatingActionButton) findViewById(R.id.fbAdd);
        ivSearch = (ImageView) findViewById(R.id.ivSearch);

        tvAdd = (TextView) findViewById(R.id.tvAdd);
        tvSearch = (TextView) findViewById(R.id.tvSearch);
        etSearch = (EditText) findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);

        rvHealthCheckUpList = (RecyclerView) findViewById(R.id.rvHealthCheckUpList);
        rvHealthCheckUpList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvHealthCheckUpList.setLayoutManager(layoutManager);
    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
        fbAdd.setOnClickListener(this);
    }

    private void setTextWatcher() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //motorApplicationAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tvAdd:
            case R.id.fbAdd:
                startActivity(new Intent(this, HealthCheckUpPlansActivity.class));
                break;
            case R.id.tvSearch:
            case R.id.ivSearch:
                if (etSearch.getVisibility() == View.INVISIBLE) {
                    etSearch.setVisibility(View.VISIBLE);
                    etSearch.requestFocus();
                }

                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_home:

                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
