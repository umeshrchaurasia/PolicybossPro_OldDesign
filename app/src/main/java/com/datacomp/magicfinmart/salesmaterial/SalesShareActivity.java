package com.datacomp.magicfinmart.salesmaterial;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.utility.Constants;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity;

public class SalesShareActivity extends BaseActivity implements BaseActivity.PopUpListener {

    DocsEntity docsEntity;
    ImageView ivProduct;
    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginResponseEntity;
    Bitmap salesPhoto;
    Bitmap pospPhoto;
    Bitmap pospDetails;
    Bitmap combinedImage;
    String pospNAme, pospDesg = "LandMark POSP", pospEmail, PospMobNo;
    SalesProductEntity salesProductEntity;
    AccountDtlEntity accountDtlEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_share);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbPersistanceController = new DBPersistanceController(this);
        loginResponseEntity = dbPersistanceController.getUserData();
        accountDtlEntity = dbPersistanceController.getAccountData();

//        Toast.makeText(this, accountDtlEntity.getDesignation() + "\n" +
//                accountDtlEntity.getEditMobiNumb() + "\n" +
//                accountDtlEntity.getEditEmailId() + "\n" +
//                accountDtlEntity.getDisplayDesignation() + "\n" +
//                accountDtlEntity.getDisplayPhoneNo() + "\n" +
//                accountDtlEntity.getDisplayEmail(), Toast.LENGTH_LONG).show();

        if (getIntent().hasExtra(Constants.PRODUCT_ID)) {
            salesProductEntity = getIntent().getExtras().getParcelable(Constants.PRODUCT_ID);
            //The key argument here must match that used in the other activity
            switch (salesProductEntity.getProduct_Id()) {
                case 1:
                case 2:
                    setPospDetails();
                    break;

                case 3:
                case 4:
                case 5:
                    setOtherDetails();
                    break;
            }
        }


        initialize();

        /*BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        salesPhoto = BitmapFactory.decodeFile(docsEntity.getImage_path(), options);*/
        //salesPhoto = ((BitmapDrawable) ivProduct.getDrawable()).getBitmap();

        new createBitmapFromURL().execute();
    }

    private void initialize() {
        ivProduct = (ImageView) findViewById(R.id.ivProduct);

        if (getIntent().hasExtra(Constants.DOC_DATA)) {
            docsEntity = getIntent().getExtras().getParcelable(Constants.DOC_DATA);
            Glide.with(this)
                    .load(docsEntity.getImage_path())
                    .into(ivProduct);

        }
    }

    private void setPospDetails() {
        if (accountDtlEntity != null) {

            if (loginResponseEntity != null) {
                if (loginResponseEntity.getPOSPName() != null && !loginResponseEntity.getPOSPName().equals("")) {
                    pospNAme = loginResponseEntity.getPOSPName();
                } else {
                    pospNAme = "POSP Name";
                }
            } else {
                pospNAme = "POSP Name";
            }

            if (accountDtlEntity.getDisplayEmail() != null && !accountDtlEntity.getDisplayEmail().equals("")) {
                pospEmail = accountDtlEntity.getDisplayEmail();
            } else {
                pospEmail = "XXXXXX@finmart.com";
            }

            if (accountDtlEntity.getDisplayDesignation() != null && !accountDtlEntity.getDisplayDesignation().equals("")) {
                pospDesg = accountDtlEntity.getDisplayDesignation();
            } else {
                pospDesg = "LandMark POSP";
            }

            if (accountDtlEntity.getDisplayPhoneNo() != null && !accountDtlEntity.getDisplayPhoneNo().equals("")) {
                PospMobNo = accountDtlEntity.getDisplayPhoneNo();
            } else {
                PospMobNo = "98XXXXXXXX";
            }
        } else {
            pospNAme = "POSP Name";
            pospEmail = "XXXXXX@finmart.com";
            pospDesg = "LandMark POSP";
            PospMobNo = "98XXXXXXXX";
        }

    }

    private void setOtherDetails() {

        if (accountDtlEntity != null) {

            if (loginResponseEntity != null) {
                if (loginResponseEntity.getFullName() != null && !loginResponseEntity.getFullName().equals("")) {
                    pospNAme = loginResponseEntity.getFullName();
                } else {
                    pospNAme = "FBA Name";
                }
            } else {
                pospNAme = "FBA Name";
            }

            if (accountDtlEntity.getEditEmailId() != null && !accountDtlEntity.getEditEmailId().equals("")) {
                pospEmail = accountDtlEntity.getEditEmailId();
            } else {
                pospEmail = "XXXXXX@finmart.com";
            }

            if (accountDtlEntity.getDesignation() != null && !accountDtlEntity.getDesignation().equals("")) {
                pospDesg = accountDtlEntity.getDesignation();
            } else {
                pospDesg = "FBA SUPPORT ASSISTANT";
            }

            if (accountDtlEntity.getEditMobiNumb() != null && !accountDtlEntity.getEditMobiNumb().equals("")) {
                PospMobNo = accountDtlEntity.getEditMobiNumb();
            } else {
                PospMobNo = "98XXXXXXXX";
            }
        } else {
            pospNAme = "FBA Name";
            pospEmail = "XXXXXX@finmart.com";
            pospDesg = "FBA SUPPORT ASSISTANT";
            PospMobNo = "98XXXXXXXX";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_share:
                if (salesProductEntity.getProduct_Id() == 1 || salesProductEntity.getProduct_Id() == 2) {
                    if (Utility.checkShareStatus() == 1) {
                        showShareProduct();
                    } else {
                        openPopUp(ivProduct, "Message", "Your POSP status is INACTIVE", "OK", true);
                    }
                } else {
                    showShareProduct();
                }


                break;

            case R.id.action_home:

                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showShareProduct() {
        if (combinedImage != null)
            datashareList(SalesShareActivity.this, combinedImage, "Finmart", "");
//        //new shareImageNormal(docsEntity.getImage_path(), "Finmart", "Look what I found on Finmart!").execute();


    }

    @Override
    public void onPositiveButtonClick(Dialog dialog, View view) {
        switch (view.getId()) {
            case R.id.ivProduct:
                dialog.cancel();
                break;
        }
    }

    @Override
    public void onCancelButtonClick(Dialog dialog, View view) {
        switch (view.getId()) {
            case R.id.ivProduct:
                dialog.cancel();
                break;
        }
    }

    public class createBitmapFromURL extends AsyncTask<Void, Void, Bitmap> {
        URL pospPhotoUrl;


        @Override
        protected void onPreExecute() {
            showDialog();
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            Bitmap networkBitmap = null;

            //  URL networkUrl = urls[0]; //Load the first element
            try {
                //pospPhotoUrl = new URL(loginResponseEntity.getPOSPProfileUrl());
                pospPhotoUrl = new URL("http://edu.policyboss.com/eduappservice/Uploaded/1.JPEG");
                networkBitmap = BitmapFactory.decodeStream(
                        pospPhotoUrl.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("TAG", "Could not load Bitmap from: " + pospPhotoUrl);
            }

            return networkBitmap;
        }

        protected void onPostExecute(Bitmap result) {

            pospPhoto = result;

            try {
                if (pospPhoto != null) {
                    salesPhoto = ((GlideBitmapDrawable) ivProduct.getDrawable()).getBitmap();
                    //datashareList(BaseActivity.this, result);
                    pospDetails = createBitmap(pospPhoto, pospNAme, pospDesg, PospMobNo, pospEmail);
                    combinedImage = combineImages(salesPhoto, pospDetails);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    combinedImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    Glide.with(SalesShareActivity.this)
                            .load(stream.toByteArray())
                            .asBitmap()
                            .into(ivProduct);
                    cancelDialog();
                }
            } catch (Exception e) {
                cancelDialog();
                e.printStackTrace();
                Log.e("TAG", "Could not load Bitmap from: " + e.getMessage());

            }
        }
    }

}
