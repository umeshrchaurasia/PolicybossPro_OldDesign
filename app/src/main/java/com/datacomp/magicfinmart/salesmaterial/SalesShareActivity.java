package com.datacomp.magicfinmart.salesmaterial;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;

import java.io.IOException;
import java.net.URL;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity;

public class SalesShareActivity extends BaseActivity {

    DocsEntity docsEntity;
    ImageView ivProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_share);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialize();

    }

    private void initialize()
    {
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
        getMenuInflater().inflate(R.menu.share_menu , menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_share:

                showShareProduct();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showShareProduct() {

      new  shareImageNormal(docsEntity.getImage_path(),"Finmart","Look what I found on Finmart!").execute();



    }
}
