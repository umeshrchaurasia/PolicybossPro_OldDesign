package com.datacomp.magicfinmart.knowledgeguru;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;

public class KnowledgeGuruActivity extends BaseActivity implements View.OnClickListener {

    CardView loan, insurance, other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_guru);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init_views();
        setListener();
    }

    private void setListener() {
        loan.setOnClickListener(this);
        insurance.setOnClickListener(this);
        other.setOnClickListener(this);

    }

    private void init_views() {
        loan = (CardView) findViewById(R.id.loan);
        insurance = (CardView) findViewById(R.id.insurance);
        other = (CardView) findViewById(R.id.other);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loan:
                startActivity(new Intent(this, KnowledgeGuruWebviewActivity.class)
                        .putExtra("URL", "http://erp.rupeeboss.com/loansrepository/Loans-repository.html")
                        .putExtra("NAME", "LOAN REPOSITORY")
                        .putExtra("TITLE", "LOAN REPOSITORY"));
                break;
            case R.id.insurance:
                startActivity(new Intent(this, KnowledgeGuruWebviewActivity.class)
                        .putExtra("URL", "http://www.policyboss.com/repository/page.html")
                        .putExtra("NAME", "INSURANCE REPOSITORY")
                        .putExtra("TITLE", "INSURANCE REPOSITORY"));
                break;
            case R.id.other:
                startActivity(new Intent(this, KnowledgeGuruWebviewActivity.class)
                        .putExtra("URL", "http://www.myfinpeace.com/hostedpages/finmart/KnowledgeGuru.html")
                        .putExtra("NAME", "OTHER PRODUCTS")
                        .putExtra("TITLE", "OTHER PRODUCTS"));
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
                intent.putExtra("MarkTYPE", "FROM_HOME");
                startActivity(intent);

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
