package com.datacomp.magicfinmart.salesmaterial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.salesmaterial.SalesMaterialController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.SalesMaterialProductResponse;

public class SalesMaterialActivity extends BaseActivity implements IResponseSubcriber {

    RecyclerView rvSalesMaterial;
    SalesMaterialAdapter mAdapter;
    List<SalesProductEntity> mlistSalesProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_material);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
        fetchProducts();

    }

    private void fetchProducts() {
        showDialog();
        new SalesMaterialController(this).getSalesProducts(this);
    }

    private void init() {
        rvSalesMaterial = (RecyclerView) findViewById(R.id.rvSalesMaterial);
        rvSalesMaterial.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvSalesMaterial.setLayoutManager(layoutManager);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof SalesMaterialProductResponse) {
            mlistSalesProduct = ((SalesMaterialProductResponse) response).getMasterData();
            mAdapter = new SalesMaterialAdapter(this, mlistSalesProduct);
            rvSalesMaterial.setAdapter(mAdapter);
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public void redirectToApplyMain(SalesProductEntity prdID) {
        Intent intent = new Intent(this, SalesDetailActivity.class);
        intent.putExtra(Constants.PRODUCT_ID, prdID);
        startActivity(intent);
    }
}
