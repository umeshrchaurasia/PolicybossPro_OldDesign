package com.datacomp.magicfinmart.salesmaterial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.salesmaterial.SalesMaterialController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CompanyEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.SalesMaterialProductResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.SalesPromotionResponse;

public class SalesMaterialActivity extends BaseActivity implements IResponseSubcriber {

    RecyclerView rvSalesMaterial;
    SalesMaterialAdapter mAdapter;
    List<SalesProductEntity> mlistSalesProduct;
    DBPersistanceController dbPersistanceController;
    List<CompanyEntity> companyLst;

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
        companyLst = new ArrayList<CompanyEntity>();
        rvSalesMaterial = (RecyclerView) findViewById(R.id.rvSalesMaterial);
        rvSalesMaterial.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvSalesMaterial.setLayoutManager(layoutManager);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        boolean isUpdate = false;
        if (response instanceof SalesMaterialProductResponse) {
             mlistSalesProduct = ((SalesMaterialProductResponse) response).getMasterData();
            //mlistSalesProduct = getProducttList();

            List<SalesProductEntity> compLst = dbPersistanceController.getCompanyList();
            if (compLst != null) {
                if (compLst.size() > 0) {
                    for (int i = 0; i < mlistSalesProduct.size(); i++) {
                        for (SalesProductEntity oldComEntiy : compLst) {
                            if (mlistSalesProduct.get(i).getProduct_Id() == oldComEntiy.getProduct_Id()) {

                                if (oldComEntiy.getOldCount() > mlistSalesProduct.get(i).getCount()) {
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

            if (compLst.size() != mlistSalesProduct.size() || isUpdate) {
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
        } else if (response instanceof SalesPromotionResponse) {
            companyLst = ((SalesPromotionResponse) response).getMasterData().getCompany();

        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public void redirectToApplyMain(SalesProductEntity entity, int pos) {

        if (entity.getCount() > entity.getOldCount()) {
            alertCount(entity, pos);
        } else {

            Intent intent = new Intent(SalesMaterialActivity.this, SalesDetailActivity.class);
            intent.putExtra(Constants.PRODUCT_ID, entity);
            startActivity(intent);

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


    public List<SalesProductEntity> getProducttList() {
        List<SalesProductEntity> EmploymentEntityList = new ArrayList<SalesProductEntity>();

        EmploymentEntityList.add(new SalesProductEntity(1, "Health Insurance", "http://bo.mgfm.in/uploads/sales_material/440Your-Search.jpg", 5));
        EmploymentEntityList.add(new SalesProductEntity(2, "Motor Insurance", "http://qa.mgfm.in/uploads/salesmaterial/motor.png", 5));
        EmploymentEntityList.add(new SalesProductEntity(3, "Health Assure", "http://qa.mgfm.in/uploads/salesmaterial/healthassure.png", 2));
        EmploymentEntityList.add(new SalesProductEntity(4, "Loans", "http://qa.mgfm.in/uploads/salesmaterial/loans.png", 2));
        EmploymentEntityList.add(new SalesProductEntity(5, "Health Insurance", "http://qa.mgfm.in/uploads/salesmaterial/finpeace.png", 4));

        return EmploymentEntityList;
    }


    private void alertCount(final SalesProductEntity salesProductEntity, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        int count = (salesProductEntity.getCount() - salesProductEntity.getOldCount());
        ImageView ivCross;
        Button btnLater, btnDownload;
        TextView txtMessage;

        LayoutInflater inflater = this.getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.layout_material_count_popup, null);

        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        // set the custom dialog components - text, image and button
        txtMessage = (TextView) dialogView.findViewById(R.id.txtMessage);
        btnLater = (Button) dialogView.findViewById(R.id.btnLater);
        btnDownload = (Button) dialogView.findViewById(R.id.btnDownload);
        ivCross = (ImageView) dialogView.findViewById(R.id.ivCross);

        txtMessage.setText(count + " " + getString(R.string.materail_count));


        ivCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });


        btnLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });


        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                mAdapter.updateList(salesProductEntity, position);

                Intent intent = new Intent(SalesMaterialActivity.this, SalesDetailActivity.class);
                intent.putExtra(Constants.PRODUCT_ID, salesProductEntity);
                startActivity(intent);

            }
        });


        alertDialog.setCancelable(false);
        alertDialog.show();
    }


    public class createBitmapFromURL extends AsyncTask<Void, Void, Bitmap> {
        URL NotifyPhotoUrl;
        String imgURL;

        public createBitmapFromURL(String imgURL) {
            this.imgURL = imgURL;
        }


        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            Bitmap networkBitmap = null;

            try {
                NotifyPhotoUrl = new URL(imgURL);
                networkBitmap = BitmapFactory.decodeStream(
                        NotifyPhotoUrl.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("TAG", "Could not load Bitmap from: " + NotifyPhotoUrl);
            }

            return networkBitmap;
        }

        protected void onPostExecute(Bitmap result) {

            // bitmap_image = result;
        }
    }
}
