package com.policyboss.magicfinmart.onlineexpressloan.BankLoanList.BankLoanListActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.policyboss.magicfinmart.BaseActivity;
import com.policyboss.magicfinmart.R;
import com.policyboss.magicfinmart.home.HomeActivity;
import com.policyboss.magicfinmart.onlineexpressloan.BankLoanList.BankLoanListAdapter.ExpressBankRowAdapter;

import magicfinmart.datacomp.com.finmartserviceapi.express_loan.controller.ExpressLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.ExpressLoanEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.ExpressLoanListResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;

public class BankLoanListActivity extends BaseActivity  implements IResponseSubcriber  {

    ExpressLoanEntity expressLoanEntity;
    RecyclerView rvbanklist;
    ExpressBankRowAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_loan_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialize();
        fetchCreditCards();
    }

    private void initialize()
    {
        rvbanklist = (RecyclerView) findViewById(R.id.rvbanklist);
        rvbanklist.setLayoutManager(new LinearLayoutManager(this));
    }
    private void fetchCreditCards() {
        showDialog("Please wait.., Fetching express loan list");
        new ExpressLoanController(this).getExpressLoanList(this);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof ExpressLoanListResponse) {
            if (response.getStatusNo() == 0) {

                expressLoanEntity = ((ExpressLoanListResponse) response).getMasterData();

                mAdapter = new ExpressBankRowAdapter(this,expressLoanEntity);
                this.rvbanklist.setAdapter(mAdapter);
            }

        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
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
