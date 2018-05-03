package com.datacomp.magicfinmart.webviews;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;
import com.google.gson.Gson;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.tracking.TrackingController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TrackingData;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TrackingRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetBLDispalyResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetPersonalLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.motor.response.BikePremiumResponse;

import static magicfinmart.datacomp.com.finmartserviceapi.Utility.createShareDirIfNotExists;

public class ShareQuoteActivity extends BaseActivity {
    WebView webView;
    String url;
    String name;
    String title;
    Bitmap bmp;
    int count = 0;
    BikePremiumResponse bikePremiumResponse;
    BikeMasterEntity bikeMasterEntity;
    CarMasterEntity carMasterEntity;
    LoginResponseEntity loginResponseEntity;
    AccountDtlEntity accountDtlEntity;
    String respone;
    String userReponse;
    String otherData = "";
    Gson gson = new Gson();
    String pospPhotoUrl, pospNAme, pospDesg = "LandMark POSP", pospEmail, PospMobNo, makeModel, cc;
    String from;
    DBPersistanceController dbPersistanceController;
    GetQuoteResponse getQuoteResponse;
    GetBLDispalyResponse getblDispalyResponse;
    GetPersonalLoanResponse getPersonalLoanResponse;
    JSONObject userJson = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            WebView.enableSlowWholeDocumentDraw();
        }
        setContentView(R.layout.activity_share_quote_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        webView = (WebView) findViewById(R.id.webView);

        dbPersistanceController = new DBPersistanceController(this);
        loginResponseEntity = dbPersistanceController.getUserData();
        accountDtlEntity = dbPersistanceController.getAccountData();

        //region from which class
        if (getIntent().hasExtra(Constants.SHARE_ACTIVITY_NAME)) {
            from = getIntent().getExtras().getString(Constants.SHARE_ACTIVITY_NAME);
            switch (from) {
                case "CAR_ALL_QUOTE":
                    CarAllQuote();
                    createJson();
                    setPospDetails();
                    new TrackingController(this).sendData(new TrackingRequestEntity(new TrackingData(from + " Share Clicked"), Constants.PRIVATE_CAR), null);
                    break;
                case "CAR_SINGLE_QUOTE":
                    carSingleQuote();
                    createJson();
                    setPospDetails();
                    new TrackingController(this).sendData(new TrackingRequestEntity(new TrackingData(from + " Share Clicked"), Constants.PRIVATE_CAR), null);
                    break;
                case "BIKE_ALL_QUOTE":
                    BikeAllQuote();
                    createJson();
                    setPospDetails();
                    new TrackingController(this).sendData(new TrackingRequestEntity(new TrackingData(from + " Share Clicked"), Constants.TWO_WHEELER), null);
                    break;
                case "BIKE_SINGLE_QUOTE":
                    BikeSingleQuote();
                    createJson();
                    setPospDetails();
                    new TrackingController(this).sendData(new TrackingRequestEntity(new TrackingData(from + " Share Clicked"), Constants.TWO_WHEELER), null);
                    break;

                case "HEALTH_ALL_QUOTE":
                    HealthAllQuote();
                    createJson();
                    setPospDetails();
                    new TrackingController(this).sendData(new TrackingRequestEntity(new TrackingData(from + " Share Clicked"), Constants.HEALTH_INS), null);
                    break;
                case "HEALTH_SINGLE_QUOTE":
                    HealthSingleQuote();
                    createJson();
                    setPospDetails();
                    new TrackingController(this).sendData(new TrackingRequestEntity(new TrackingData(from + " Share Clicked"), Constants.HEALTH_INS), null);
                    break;
                case "HL_ALL_QUOTE":
                    HlAllQuote();
                    setOtherDetails();
                    new TrackingController(this).sendData(new TrackingRequestEntity(new TrackingData(from + " Share Clicked"), Constants.HOME_LOAN), null);
                    break;
                case "BL_ALL_QUOTE":
                    BlAllQuote();
                    setOtherDetails();
                    new TrackingController(this).sendData(new TrackingRequestEntity(new TrackingData(from + " Share Clicked"), Constants.BALANCE_TRANSFER), null);
                    break;
                case "PL_ALL_QUOTE":
                    PlAllQuote();
                    setOtherDetails();
                    new TrackingController(this).sendData(new TrackingRequestEntity(new TrackingData(from + " Share Clicked"), Constants.PERSONA_LOAN), null);
                    break;
                case "LAP_ALL_QUOTE":
                    LapAllQuote();
                    setOtherDetails();
                    new TrackingController(this).sendData(new TrackingRequestEntity(new TrackingData(from + " Share Clicked"), Constants.LAP), null);
                    break;


            }
        }
        //endregion

        //region user  details

        userReponse = userJson.toString();
        //endregion

        //region floatingbutton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                //downloadPdf(url, name);
                bmp = getBitmapFromWebView(webView);
                new shareQuote(webView).execute();


            }
        });
        //endregion

        settingWebview();
    }

    private void setPospDetails() {
        if (accountDtlEntity != null) {

            if (loginResponseEntity != null) {
                if (loginResponseEntity.getPOSPName() != null && !loginResponseEntity.getPOSPName().equals("")) {
                    pospNAme = loginResponseEntity.getPOSPName();
                } else {
                    pospNAme = "POSP Name";
                }
                if (loginResponseEntity.getPOSPProfileUrl() != null && !loginResponseEntity.getPOSPProfileUrl().equals("")) {
                    pospPhotoUrl = loginResponseEntity.getPOSPProfileUrl();
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

        try {
            userJson.put("pospPhotoUrl", pospPhotoUrl);
            userJson.put("pospDesg", pospDesg);
            userJson.put("pospNAme", pospNAme);
            userJson.put("pospEmail", pospEmail);
            userJson.put("PospMobNo", PospMobNo);
        } catch (JSONException e) {
            e.printStackTrace();
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
                if (loginResponseEntity.getFBAProfileUrl() != null && !loginResponseEntity.getFBAProfileUrl().equals("")) {
                    pospPhotoUrl = loginResponseEntity.getFBAProfileUrl();
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


        try {
            userJson.put("pospPhotoUrl", pospPhotoUrl);
            userJson.put("pospDesg", pospDesg);
            userJson.put("pospNAme", pospNAme);
            userJson.put("pospEmail", pospEmail);
            userJson.put("PospMobNo", PospMobNo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void createJson() {

        try {
            userJson.put("CC", cc);
            userJson.put("CAR_NAME", makeModel);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void HlAllQuote() {
        if (getIntent().hasExtra("RESPONSE")) {
            //bike
            getQuoteResponse = getIntent().getParcelableExtra("RESPONSE");
            respone = gson.toJson(getQuoteResponse);
        }
        if (getIntent().hasExtra("NAME")) {
            //bike
            otherData = getIntent().getStringExtra("NAME");
        }
        url = "file:///android_asset/HomeLoan.html";
        title = "HOME LOAN QUOTE";
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);
    }

    private void PlAllQuote() {
        if (getIntent().hasExtra("RESPONSE")) {
            //bike
            getPersonalLoanResponse = getIntent().getParcelableExtra("RESPONSE");
            respone = gson.toJson(getPersonalLoanResponse);
        }
        if (getIntent().hasExtra("NAME")) {
            //bike
            otherData = getIntent().getStringExtra("NAME");
        }
        url = "file:///android_asset/PersonalLoan.html";
        title = "HOME LOAN QUOTE";
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);
    }

    private void BlAllQuote() {
        int productId = 0;
        if (getIntent().hasExtra("RESPONSE")) {
            //bike
            getblDispalyResponse = getIntent().getParcelableExtra("RESPONSE");
            respone = gson.toJson(getblDispalyResponse);
        }
        if (getIntent().hasExtra("NAME")) {
            //bike
            name = getIntent().getStringExtra("NAME");
        }
        if (getIntent().hasExtra("LOAN_REQUIRED")) {
            //bike
            otherData = getIntent().getStringExtra("LOAN_REQUIRED");
        }
        if (getIntent().hasExtra("PRODUCT_ID")) {
            productId = getIntent().getIntExtra("PRODUCT_ID", 0);
        }
        url = "file:///android_asset/BT.html";
        title = "BALANCE TRANSFER QUOTE";
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("NAME", name);
            jsonObject.put("LOAN_REQUIRED", otherData);
            jsonObject.put("PRODUCT_ID", productId);
            otherData = jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LapAllQuote() {
        if (getIntent().hasExtra("RESPONSE")) {
            //bike
            getQuoteResponse = getIntent().getParcelableExtra("RESPONSE");
            respone = gson.toJson(getQuoteResponse);
        }
        if (getIntent().hasExtra("NAME")) {
            //bike
            otherData = getIntent().getStringExtra("NAME");
        }
        url = "file:///android_asset/LoanAgainstProperty.html";
        title = "LAP QUOTE";
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);
    }

    private void HealthSingleQuote() {

        //region url ,name,title

        if (getIntent().hasExtra("RESPONSE")) {
            //bike
            respone = getIntent().getStringExtra("RESPONSE");
        }
        if (getIntent().hasExtra("NAME")) {
            //bike
            otherData = getIntent().getStringExtra("NAME");
        }

        //region url ,name,title
        url = getIntent().getStringExtra("URL");
        url = "file:///android_asset/health_insurance_quotation.html";
        title = "Health Quote";
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        //endregion
    }

    private void HealthAllQuote() {
        if (getIntent().hasExtra("RESPONSE")) {
            //bike
            respone = getIntent().getStringExtra("RESPONSE");
        }
        //region url ,name,title

        url = "file:///android_asset/health_insurance.html";
        name = getIntent().getStringExtra("NAME");
        title = "HEALTH QUOTE";
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("NAME", name);
            otherData = jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //endregion
    }

    private void BikeSingleQuote() {

        if (getIntent().hasExtra("RESPONSE")) {
            //bike
            respone = getIntent().getStringExtra("RESPONSE");
        }
        if (getIntent().hasExtra("OTHER")) {
            //bike
            otherData = getIntent().getStringExtra("OTHER");
        }
        //region url ,name,title
        url = getIntent().getStringExtra("URL");
        url = "file:///android_asset/vechile_single_quote.html";
        title = "Two Wheeler Quote";
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        //endregion
    }

    private void BikeAllQuote() {
        if (getIntent().hasExtra("RESPONSE")) {
            //bike
            bikePremiumResponse = getIntent().getParcelableExtra("RESPONSE");
            respone = gson.toJson(bikePremiumResponse);
        }
        if (getIntent().hasExtra("BIKENAME")) {
            //bike
            bikeMasterEntity = getIntent().getParcelableExtra("BIKENAME");
            if (!bikePremiumResponse.getSummary().getRequest_Core().getRegistration_no().endsWith("-AA-1234"))
                makeModel = bikeMasterEntity.getMake_Name() + " ," + bikeMasterEntity.getModel_Name() + " -  " + bikePremiumResponse.getSummary().getRequest_Core().getRegistration_no();
            else
                makeModel = bikeMasterEntity.getMake_Name() + " ," + bikeMasterEntity.getModel_Name();
            cc = "CRN : " + bikePremiumResponse.getSummary().getPB_CRN() + " , " + bikeMasterEntity.getCubic_Capacity() + "CC";
        }
        //region url ,name,title

        url = "file:///android_asset/VechicleInsurance.html";
        name = bikePremiumResponse.getSummary().getRequest_Core().getFirst_name().toUpperCase() + " - " + bikePremiumResponse.getSummary().getRequest_Core().getRegistration_no();
        title = "TWO WHEELER QUOTE";
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        //endregion
    }

    private void carSingleQuote() {
        if (getIntent().hasExtra("RESPONSE")) {
            //bike
            respone = getIntent().getStringExtra("RESPONSE");
        }
        if (getIntent().hasExtra("OTHER")) {
            //bike
            otherData = getIntent().getStringExtra("OTHER");
        }

        //region url ,name,title
        url = getIntent().getStringExtra("URL");
        url = "file:///android_asset/vechile_single_quote.html";
        title = "Motor Quote";
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        //endregion
    }

    private void CarAllQuote() {
        if (getIntent().hasExtra("RESPONSE")) {
            //bike
            bikePremiumResponse = getIntent().getParcelableExtra("RESPONSE");
            respone = gson.toJson(bikePremiumResponse);
        }
        if (getIntent().hasExtra("CARNAME")) {
            //car
            carMasterEntity = getIntent().getParcelableExtra("CARNAME");
            if (!bikePremiumResponse.getSummary().getRequest_Core().getRegistration_no().endsWith("-AA-1234"))
                makeModel = carMasterEntity.getMake_Name() + " ," + carMasterEntity.getModel_Name() + " -  " + bikePremiumResponse.getSummary().getRequest_Core().getRegistration_no();
            else
                makeModel = carMasterEntity.getMake_Name() + " ," + carMasterEntity.getModel_Name();
            cc = "CRN : " + bikePremiumResponse.getSummary().getPB_CRN() + " , " + carMasterEntity.getCubic_Capacity() + "CC";
        }
        //region url ,name,title
        url = "file:///android_asset/VechicleInsurance.html";
        String fullName = bikePremiumResponse.getSummary().getRequest_Core().getFirst_name().toUpperCase();

        name = fullName + " - " + bikePremiumResponse.getSummary().getRequest_Core().getRegistration_no();

        title = "MOTOR QUOTE";
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        //endregion
    }


    private void shareQuote() {

        bmp = getBitmapFromWebView(webView);

        try {
            SimplePDFTable(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void downloadPdf(String url, String name) {
        Toast.makeText(this, "Downlaod started..", Toast.LENGTH_LONG).show();
        DownloadManager.Request r = new DownloadManager.Request(Uri.parse(url));
        r.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name + ".pdf");
        r.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        r.setMimeType(MimeTypeMap.getFileExtensionFromUrl(url));
        DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        dm.enqueue(r);
    }

    private void createWebPrintJob(WebView webView) {

        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        PrintDocumentAdapter printAdapter = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            printAdapter = webView.createPrintDocumentAdapter();
        }

        String jobName = getString(R.string.app_name) + " Print Test";

        if (printManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                printManager.print(jobName, printAdapter,
                        new PrintAttributes.Builder().build());
            }
        }
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


        final MyWebViewClient webViewClient = new MyWebViewClient(this);
        webView.setWebViewClient(webViewClient);
        webView.setWebViewClient(new WebViewClient() {
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
                webView.loadUrl("javascript:init('" + respone + "','" + userReponse + "','" + otherData + "')");
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        webView.getSettings().setBuiltInZoomControls(false);
        webView.addJavascriptInterface(new MyJavaScriptInterface(ShareQuoteActivity.this), "Android");
        Log.d("URL", url);
        //webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + url);
        //webView.loadUrl("file:///android_asset/VechicleInsurance.html");
        webView.loadUrl(url);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    public Bitmap getBitmapFromWebView(WebView webView) {
        Bitmap bmp;
        webView.measure(View.MeasureSpec.makeMeasureSpec(
                View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        webView.layout(0, 0, webView.getMeasuredWidth(),
                webView.getMeasuredHeight());
        webView.setDrawingCacheEnabled(true);
        webView.buildDrawingCache();
        bmp = Bitmap.createBitmap(webView.getMeasuredWidth(),
                webView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas bigcanvas = new Canvas(bmp);
        Paint paint = new Paint();
        int iHeight = bmp.getHeight();
        bigcanvas.drawBitmap(bmp, 0, iHeight, paint);
        webView.draw(bigcanvas);
        return bmp;
    }

    public void SimplePDFTable(Bitmap bmp) throws Exception {
        String fileName;
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        fileName = df.format(c.getTime());

        //File direct = new File(Environment.getExternalStorageDirectory(), "/FINMART/QUOTES");
        File direct = createShareDirIfNotExists();
        /*if (!direct.exists()) {
            if (direct.mkdir()) {
            }
        }*/
        String test = direct.getAbsolutePath();

        Rectangle pagesize = new Rectangle(bmp.getWidth() + 36, bmp.getHeight() + 36);

        Document document = new Document(pagesize, 36f, 36f, 36f, 36f);

        PdfWriter.getInstance(document, new FileOutputStream(test
                + "/" + fileName + ".pdf"));

        document.open();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        Image image = Image.getInstance(byteArray);


        //image.scaleToFit(PageSize.A4.getHeight(), PageSize.A4.getWidth());
        image.scaleToFit(pagesize);
        //image.scaleToFit(rectangle);
        document.add(image);

        document.close();
        sharePdfTowhatsApp(fileName);
    }

    public class MyJavaScriptInterface {
        Context mContext;
        String data;

        MyJavaScriptInterface(Context ctx) {
            this.mContext = ctx;
        }


        @JavascriptInterface
        public void processComplete() {
            //Get the string value to process
            //shareQuote();
        }
    }


    public class shareQuote extends AsyncTask<Void, Void, Void> {
        WebView webView;

        public shareQuote(WebView web) {
            webView = web;
        }

        @Override
        protected void onPreExecute() {
            showDialog("Generating pdf...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {


            try {
                //bmp = getBitmapFromWebView(webView);
                // SimplePDFTable(bmp, bikePremiumResponse.getSummary().getRequest_Core().getFirst_name().toUpperCase() + " - " + bikePremiumResponse.getSummary().getRequest_Core().getRegistration_no());
                SimplePDFTable(bmp);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            cancelDialog();
            super.onPostExecute(aVoid);
        }
    }
}
