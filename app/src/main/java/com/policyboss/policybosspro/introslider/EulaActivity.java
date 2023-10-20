package com.policyboss.policybosspro.introslider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.policyboss.policybosspro.BaseActivity;
import com.policyboss.policybosspro.R;
import com.policyboss.policybosspro.analytics.WebEngageAnalytics;
import com.policyboss.policybosspro.login.LoginActivity;
import com.policyboss.policybosspro.login.LoginNewActivity;
import com.policyboss.policybosspro.webviews.MyWebViewClient;
import com.webengage.sdk.android.Analytics;
import com.webengage.sdk.android.WebEngage;

import java.util.HashMap;
import java.util.Map;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.creditcard.CreditCardController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters.MasterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.BikeMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CarMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CityMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.InsuranceMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.RblCityMasterResponse;

public class EulaActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {
    Button btnAgree, btnDisAgree;
    PrefManager prefManager;
    WebView webView;

    @Override
    protected void onStart() {
        super.onStart();
        Analytics weAnalytics = WebEngage.get().analytics();
        weAnalytics.screenNavigated("Eula Screen");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eula);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initWidgets();
        setListener();
        prefManager = new PrefManager(this);

        settingWebview();
    }

    private void initWidgets() {
        webView = (WebView) findViewById(R.id.webView);
        btnAgree = (Button) findViewById(R.id.btnAgree);
        btnDisAgree = (Button) findViewById(R.id.btnDisAgree);
    }

    private void setListener() {
        btnAgree.setOnClickListener(this);
        btnDisAgree.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAgree:


                prefManager.setFirstTimeLaunch(false);
                startActivity(new Intent(this, LoginNewActivity.class));
                trackEvent("I Agree");
                break;
            case R.id.btnDisAgree:
                trackEvent("I Disagree");
                finish();

                break;
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
      //  Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }



    private void settingWebview() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportMultipleWindows(false);

        settings.setLoadsImagesAutomatically(true);
        settings.setLightTouchEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);


        MyWebViewClient webViewClient = new MyWebViewClient(this);
        webView.setWebViewClient(webViewClient);
       /* webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // TODO show you progress image
                showDialog();
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // TODO hide your progress image
                cancelDialog();
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });*/
        webView.getSettings().setBuiltInZoomControls(true);
       /* Log.d("URL", url);
        //webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + url);
        webView.loadUrl(url);*/
        webView.loadUrl("file:///android_asset/eula.html");
    }

    private void trackEvent(String status) {
        // Create event attributes
        Map<String, Object> eventAttributes = new HashMap<>();
        eventAttributes.put("Status",status); // Add any relevant attributes

        // Track the login event using WebEngageHelper
        WebEngageAnalytics.getInstance().trackEvent("Agreement Acknowledgement", eventAttributes);
    }

}
