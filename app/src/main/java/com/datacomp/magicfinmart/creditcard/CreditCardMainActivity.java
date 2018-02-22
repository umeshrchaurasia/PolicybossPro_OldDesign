package com.datacomp.magicfinmart.creditcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;

public class CreditCardMainActivity extends BaseActivity implements View.OnClickListener {
    CardView cvRbl, cvIcici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cvRbl = (CardView) findViewById(R.id.cvRbl);
        cvIcici = (CardView) findViewById(R.id.cvIcici);
        cvRbl.setOnClickListener(this);
        cvIcici.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cvRbl:
                startActivity(new Intent(this, CommonWebViewActivity.class)
                        .putExtra("URL", "http://www.rupeeboss.com/rbl-dc")
                        .putExtra("NAME", "MAGIC FIN-MART")
                        .putExtra("TITLE", "MAGIC FIN-MART"));
                break;
            case R.id.cvIcici:
                startActivity(new Intent(this, CommonWebViewActivity.class)
                        .putExtra("URL", "http://www.rupeeboss.com/icici-dc")
                        .putExtra("NAME", "MAGIC FIN-MART")
                        .putExtra("TITLE", "MAGIC FIN-MART"));
                break;
        }
    }
}
