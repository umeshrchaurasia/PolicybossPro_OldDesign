package com.policyboss.policybosspro.loan_fm.MyBusinessLoan;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.policyboss.policybosspro.BaseActivity;
import com.policyboss.policybosspro.R;

import java.math.BigDecimal;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.ResultDataMyBuisness;

public class BusinessPopUpActivity extends BaseActivity implements View.OnClickListener {
    ResultDataMyBuisness myBuisness;
    RecyclerView buisnessRecycler;
    BusinessPopUpAdapter mAdapter;
    Button btnClose;
    TextView txtTotCount, txtHdr,txtTotLoanAmnt;
    LinearLayout layout_tot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_pop_up);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFinishOnTouchOutside(false);
        initialize();
        if (getIntent().hasExtra(Utility.MY_BUSISNESS)) {
            myBuisness = getIntent().getParcelableExtra(Utility.MY_BUSISNESS);
            String strHdr = getIntent().getStringExtra(Utility.MY_BUSISNESS_HDR);
            String strType = getIntent().getStringExtra(Utility.MY_BUSISNESS_type);
            mAdapter = new BusinessPopUpAdapter(BusinessPopUpActivity.this, myBuisness.getLstRpt());
            buisnessRecycler.setAdapter(mAdapter);

            txtTotCount.setText("Total Count : " + myBuisness.getTotalCount());
            txtTotLoanAmnt.setText("Total Loan Amount : " + BigDecimal.valueOf(myBuisness.getTotalLoanAmnt()).toPlainString());
            txtHdr.setText(strHdr);

            if(strType.equals("6"))
            {
                layout_tot.setVisibility(View.VISIBLE);
                txtTotLoanAmnt.setText("Total Payout Amount : " + BigDecimal.valueOf(myBuisness.getTotalLoanAmnt()).toPlainString());
            }
        }

    }
    private void initialize() {
        buisnessRecycler = (RecyclerView) findViewById(R.id.BuisnessRecycler);
        buisnessRecycler.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        buisnessRecycler.setLayoutManager(mLayoutManager);

        txtHdr = (TextView) findViewById(R.id.txtHdr);
        txtTotCount = (TextView) findViewById(R.id.txtTotCount);
        txtTotLoanAmnt = (TextView) findViewById(R.id.txtTotLoanAmnt);
        layout_tot = (LinearLayout)findViewById(R.id.layout_tot);
        btnClose = (Button) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnClose) {
            this.finish();
        }

    }
}
