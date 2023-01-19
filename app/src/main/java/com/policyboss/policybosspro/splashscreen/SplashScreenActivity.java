package com.policyboss.policybosspro.splashscreen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.policyboss.policybosspro.BaseActivity;
import com.policyboss.policybosspro.R;
import com.policyboss.policybosspro.home.HomeActivity;
import com.policyboss.policybosspro.introslider.WelcomeActivity;
import com.policyboss.policybosspro.login.LoginActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.policyboss.policybosspro.utility.NetworkUtils;
import com.policyboss.policybosspro.webviews.CommonWebViewActivity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.database.LoanCityFacade;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.creditcard.CreditCardController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters.MasterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.BikeMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CarMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CityMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.InsuranceMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.response.HealthPackDetailsResponse;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.response.HealthPackResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.erploan.ErpLoanController;

public class SplashScreenActivity extends BaseActivity implements IResponseSubcriber,
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.IResponseSubcriber {

    private static final String TAG = "TOKEN";
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    PrefManager prefManager;
    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginResponseEntity;

    String deeplinkurl="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        prefManager = new PrefManager(this);
        dbPersistanceController = new DBPersistanceController(this);
        loginResponseEntity = dbPersistanceController.getUserData();


        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {

                        if (task.isSuccessful()) {
                            prefManager.setToken(task.getResult().getToken());
                            Log.d(TAG, "Refreshed token: " + task.getResult().getToken());
                        }
                    }


                });


//        new MasterController(this).getInsurerList();
//
//        if (new LoanCityFacade(this) != null) {
//            if (new LoanCityFacade(this).getLoanCity() == null) {
//                new ErpLoanController(this).getcityloan(null);
//            }
//        }

        if (NetworkUtils.isNetworkAvailable(SplashScreenActivity.this)) {

            if (loginResponseEntity != null) {
                //reset user behaviour flag to send data on every app launch
                prefManager.saveUserbehaviourState(false);
                new MasterController(this).geUserConstant(0, this);
                new MasterController(this).getConstants(this);
                new MasterController(this).getMenuMaster(this);


            }
        }
        // for user constant

       /* if (userConstantEntity != null) {
            new MasterController(this).geUserConstant(0, this);
        }*/



        if (prefManager.isFirstTimeLaunch()) {

            startActivity(new Intent(this, WelcomeActivity.class));
        } else {

            //user behaviour data collection in Async


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                        if (loginResponseEntity != null) {
                            startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class)
                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK  | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                        } else {
                            startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                        }

                }
            }, SPLASH_DISPLAY_LENGTH);
        }


        getDynamicLinkfromFireBase();

    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
//        if (response instanceof BikeMasterResponse) {
//            if (checkAllMastersIsUpdate()) {
//                //startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
//            }
//        } else if (response instanceof CarMasterResponse) {
//            if (checkAllMastersIsUpdate()) {
//                //startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
//            }
//        } else if (response instanceof CityMasterResponse) {
//            if (checkAllMastersIsUpdate()) {
//                //startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
//            }
//        } else if (response instanceof InsuranceMasterResponse) {
//            if (checkAllMastersIsUpdate()) {
//                //startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
//            }
//        }
    }

    @Override
    public void OnSuccess(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.APIResponse response, String message) {
        if (response instanceof HealthPackResponse) {
            Log.d("Test", "success");
        }
        if (response instanceof HealthPackDetailsResponse) {
            Log.d("Test", "success");
        }

    }


    @Override
    public void OnFailure(Throwable t) {
      //  Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public boolean checkAllMastersIsUpdate() {
        if (prefManager.IsBikeMasterUpdate())
            return false;
        else if (prefManager.IsCarMasterUpdate())
            return false;
        else if (prefManager.IsRtoMasterUpdate())
            return false;
        else if (prefManager.IsInsuranceMasterUpdate())
            return false;

        return true;
    }

    private void getDynamicLinkfromFireBase() {

        FirebaseDynamicLinks.getInstance()
                .getDynamicLink(getIntent())
                .addOnSuccessListener(this, new OnSuccessListener<PendingDynamicLinkData>() {
                    @Override
                    public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                        // Get deep link from result (may be null if no link is found)
                          Log.i("Sync","We have link");
                        Uri deepLink = null;
                        if (pendingDynamicLinkData != null) {
                            deepLink = pendingDynamicLinkData.getLink();
                        }
                        //check by firebase
                        if(deepLink !=null){

                            deeplinkurl = deepLink.toString(); //+"?ss_id=119225&fba_id=89433&v=20200609&sub_fba_id=0&ip_address=&mac_address=&app_version=policyboss-0.1.1&device_id=e73cb6c8dd4be83c&product_id=1&login_ssid=";
                            Log.i("dynamic url",deeplinkurl);

                           // List<String> parameters = pendingDynamicLinkData.getLink().getPathSegments();
                          //  String param = parameters.get(parameters.size() - 1);

                            prefManager.setDeeplink(deeplinkurl.toString());

//                          String prd=  pendingDynamicLinkData.getLink().getQueryParameter("product_id");
//
//                          if(pendingDynamicLinkData.getLink().getQueryParameter("product_id")!=null)
//                          {
//                              String prd1=  pendingDynamicLinkData.getLink().getQueryParameter("product_id");
//                          }
//                          else
//                          {
//                              String prd2=  pendingDynamicLinkData.getLink().getQueryParameter("product_id");
//                          }
                           // webView.loadUrl(url);
                           // webView.getSettings().setJavaScriptEnabled(true);
                           // webView.setWebViewClient(new WebViewClient());

//                            startActivity(new Intent(SplashScreenActivity.this, CommonWebViewActivity.class)
//                                    .putExtra("URL", url)
//                                    .putExtra("NAME", "Health Insurance")
//                                    .putExtra("TITLE", "Health Insurance"));

                        }
                        else
                        {
                            //normal intent
                            Uri uri;
                            uri = getIntent().getData();

                                if (uri != null) {

                                    // the path segments and storing it in list.
                                 //   List<String> parameters = uri.getPathSegments();
                                 //   String param = parameters.get(parameters.size() - 1);
                                    //  messageTV.setText(uri.toString());
                                    deeplinkurl =  uri.toString();
                                    Log.d("", uri.toString());
                                    prefManager.setDeeplink(uri.toString());
//                                    startActivity(new Intent(SplashScreenActivity.this, CommonWebViewActivity.class)
//                                            .putExtra("URL", uri.toString())
//                                            .putExtra("NAME", "")
//                                            .putExtra("TITLE", ""));
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            startActivity(new Intent(SplashScreenActivity.this, CommonWebViewActivity.class).putExtra("URL", uri.toString()).putExtra("NAME", "").putExtra("TITLE", "")
                                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK  | Intent.FLAG_ACTIVITY_CLEAR_TASK));


                                        }
                                    }, 1000);


//                                    String prd=  uri.getQueryParameter("product_id");
//
//                                    if(prd!=null)
//                                    {
//                                        String prd1= uri.getQueryParameter("product_id");
//                                    }
//                                    else
//                                    {
//                                        String prd2=  uri.getQueryParameter("product_id");
//                                    }
                                }


                        }


                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "getDynamicLink:onFailure", e);
                    }
                });
    }
}
