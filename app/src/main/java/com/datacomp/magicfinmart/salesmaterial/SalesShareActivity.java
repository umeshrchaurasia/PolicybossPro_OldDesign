package com.datacomp.magicfinmart.salesmaterial;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;

public class SalesShareActivity extends BaseActivity {

    DocsEntity docsEntity;
    ImageView ivProduct;
    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginResponseEntity;
    Bitmap salesPhoto;
    Bitmap pospPhoto;
    Bitmap pospDetails;
    Bitmap combinedImage;
    String pospNAme, pospDesg = "LandMark POSP", pospEmail, PospMobNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_share);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbPersistanceController = new DBPersistanceController(this);
        loginResponseEntity = dbPersistanceController.getUserData();

        if (loginResponseEntity.getPOSPName() != null && loginResponseEntity.getPOSPName().equals("")) {
            pospNAme = loginResponseEntity.getPOSPName();
        } else {
            pospNAme = "POSP Name";
        }
        if (loginResponseEntity.getPOSEmail() != null && loginResponseEntity.getPOSEmail().equals("")) {
            pospNAme = loginResponseEntity.getPOSEmail();
        } else {
            pospEmail = "landmarkposp@finmart.com";
        }
        if (loginResponseEntity.getPOSPMobile() != null && loginResponseEntity.getPOSPMobile().equals("")) {
            pospNAme = loginResponseEntity.getPOSPMobile();
        } else {
            PospMobNo = "98XXXXXXXX";
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

                showShareProduct();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showShareProduct() {
        if (combinedImage != null)
            datashareList(SalesShareActivity.this, combinedImage, "Finmart", "Look what I found on Finmart!");
        //new shareImageNormal(docsEntity.getImage_path(), "Finmart", "Look what I found on Finmart!").execute();


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
