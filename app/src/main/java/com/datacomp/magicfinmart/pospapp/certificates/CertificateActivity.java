package com.datacomp.magicfinmart.pospapp.certificates;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;
import com.datacomp.magicfinmart.pospapp.webviews.MyBrowser;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.login.LoginController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.CertificateResponse;

public class CertificateActivity extends BaseActivity implements IResponseSubcriber {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    WebView webView;
    String url;
    CardView cvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        webView = (WebView) findViewById(R.id.webView);
        sharedPreferences = getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        cvMsg = (CardView) findViewById(R.id.cvMsg);
        // url = sharedPreferences.getString(Constants.CERTIFICATE_URL, "");
       /* if (!url.isEmpty())
            settingWebview(url);
        else {
            webView.setVisibility(View.GONE);
            cvMsg.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Certificate Not Available", Toast.LENGTH_SHORT).show();
        }*/
        showProgressDialog();
        new LoginController(this).getCertificate(this);
    }

    private void settingWebview(String url) {
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

        MyBrowser webViewClient = new MyBrowser();
        webView.setWebViewClient(webViewClient);
        webView.getSettings().setBuiltInZoomControls(true);

        Log.d("EDUCATION_URL", url);


        // String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
        webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + url);

        //webView.loadUrl(url);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) throws InterruptedException {
        dismissDialog();
        if (response instanceof CertificateResponse) {
            if (response.getStatusNo() == 0) {
                url = ((CertificateResponse) response).getPdfPath();
                if (!url.isEmpty())
                    settingWebview(url);
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        dismissDialog();
        webView.setVisibility(View.GONE);
        cvMsg.setVisibility(View.VISIBLE);
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
