package com.datacomp.magicfinmart.salesmaterial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.salesmaterial.SalesMaterialController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.SalesMaterialProductResponse;

public class SalesMaterialActivity extends BaseActivity implements IResponseSubcriber {

    RecyclerView rvSalesMaterial;
    SalesMaterialAdapter mAdapter;
    List<SalesProductEntity> mlistSalesProduct;
    DBPersistanceController dbPersistanceController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_material);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbPersistanceController = new DBPersistanceController(SalesMaterialActivity.this);
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
        boolean isUpdate =false;
        if (response instanceof SalesMaterialProductResponse) {
           // mlistSalesProduct = ((SalesMaterialProductResponse) response).getMasterData();

            mlistSalesProduct =  getProducttList();

            List<SalesProductEntity> compLst = dbPersistanceController.getCompanyList();
            if (compLst != null) {
                if (compLst.size() > 0) {
                    for (int i = 0; i < mlistSalesProduct.size(); i++) {
                        for (SalesProductEntity oldComEntiy : compLst) {
                            if (mlistSalesProduct.get(i).getProduct_Id() == oldComEntiy.getProduct_Id()) {

                                if(oldComEntiy.getOldCount() >  mlistSalesProduct.get(i).getCount() )
                                {
                                    isUpdate = true;
                                    break;
                                }

                                mlistSalesProduct.get(i).setOldCount(oldComEntiy.getOldCount());

                            }
                        }
                    }
                }


            }


            // case 1 : for first time when db data is empty OR Server list size is change ie product is increased / decreased
            // case 2 : if sever product count is lesss than db product count than db should update

            if (compLst.size() != mlistSalesProduct.size()  || isUpdate) {
                for (int i = 0; i < mlistSalesProduct.size(); i++) {

                    mlistSalesProduct.get(i).setOldCount(0);
                }

                dbPersistanceController.storeCompanyList(mlistSalesProduct);
            }

            // region comment
//            Gson gson = new Gson();
//
//            String listString = gson.toJson(
//                    mlistSalesProduct,
//                    new TypeToken<ArrayList<SalesProductEntity>>() {}.getType());
//
//            try {
//                JSONArray jsonArray = new JSONArray(listString);
//            }catch (Exception ex){
//
//            }

           // endregion

            mAdapter = new SalesMaterialAdapter(this, mlistSalesProduct);
            rvSalesMaterial.setAdapter(mAdapter);
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public void redirectToApplyMain(SalesProductEntity salesProductEntity) {

        Intent intent = new Intent(this, SalesDetailActivity.class);
        intent.putExtra(Constants.PRODUCT_ID, salesProductEntity);
        startActivity(intent);
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



        public List<SalesProductEntity> getProducttList() {
            List<SalesProductEntity> EmploymentEntityList = new ArrayList<SalesProductEntity>();

            EmploymentEntityList.add(new SalesProductEntity(1, "Health Insurance","http://qa.mgfm.in/uploads/salesmaterial/health.png",0));
            EmploymentEntityList.add(new SalesProductEntity(2, "Motor Insurance","http://qa.mgfm.in/uploads/salesmaterial/motor.png",2));
            EmploymentEntityList.add(new SalesProductEntity(3, "Health Assure","http://qa.mgfm.in/uploads/salesmaterial/healthassure.png",1));
            EmploymentEntityList.add(new SalesProductEntity(4, "Loans","http://qa.mgfm.in/uploads/salesmaterial/loans.png",1));
            EmploymentEntityList.add(new SalesProductEntity(5, "Health Insurance","http://qa.mgfm.in/uploads/salesmaterial/finpeace.png",0));

            return EmploymentEntityList;
        }



}
