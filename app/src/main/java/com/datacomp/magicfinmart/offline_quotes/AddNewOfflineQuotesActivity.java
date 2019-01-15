package com.datacomp.magicfinmart.offline_quotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.offline_quotes.OfflineQuoteForm.Term_OfflineQuote;
import com.datacomp.magicfinmart.offline_quotes.OfflineQuoteForm.offline_motor.OfflineMotorListActivity;

public class AddNewOfflineQuotesActivity extends BaseActivity implements View.OnClickListener {
    CardView MotorPrivate, MotorGoods, MotorPassenger, Health, life;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_offline_quotes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init_views();
        setListener();
    }

    private void setListener() {
        MotorPrivate.setOnClickListener(this);
        MotorGoods.setOnClickListener(this);
        MotorPassenger.setOnClickListener(this);
        Health.setOnClickListener(this);
        life.setOnClickListener(this);
    }

    private void init_views() {
        MotorPrivate = (CardView) findViewById(R.id.MotorPrivate);
        MotorGoods = (CardView) findViewById(R.id.MotorGoods);
        MotorPassenger = (CardView) findViewById(R.id.MotorPassenger);
        Health = (CardView) findViewById(R.id.Health);
        life = (CardView) findViewById(R.id.life);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.MotorPrivate:
                startActivity(new Intent(this, OfflineMotorListActivity.class));
                break;
            case R.id.MotorGoods:
                startActivity(new Intent(this, AddNewOfflineQuotesActivity.class));
                break;
            case R.id.MotorPassenger:
                startActivity(new Intent(this, AddNewOfflineQuotesActivity.class));
                break;
            case R.id.Health:
                startActivity(new Intent(this, AddNewOfflineQuotesActivity.class));
                break;
            case R.id.life:
                startActivity(new Intent(this, Term_OfflineQuote.class));

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
                onBackPressed();
//                Intent intent = new Intent(this, HomeActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                intent.putExtra("MarkTYPE", "FROM_HOME");
//                startActivity(intent);
//
//                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
//    @Override
//    public void onBackPressed() {
//
//        supportFinishAfterTransition();
//        super.onBackPressed();
//    }

}
