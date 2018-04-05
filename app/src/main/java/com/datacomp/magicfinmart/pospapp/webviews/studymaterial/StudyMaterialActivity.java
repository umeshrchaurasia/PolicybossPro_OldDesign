package com.datacomp.magicfinmart.pospapp.webviews.studymaterial;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.exam.StartExamActivity;
import com.datacomp.magicfinmart.pospapp.login.LoginActivity;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;
import com.datacomp.magicfinmart.pospapp.utility.MyAdminReceiver;
import com.datacomp.magicfinmart.pospapp.webviews.MyBrowser;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.login.LoginController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.modulepractice.ModulePracticeControllar;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.LoginFacade;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.LoginEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.StudyMaterialEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.SyncRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.LogoutResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.SyncTimeResponse;

public class StudyMaterialActivity extends BaseActivity implements IResponseSubcriber {

    Timer timer;
    WebView webView;
    TextView txtTimer;
    StudyMaterialEntity studyMaterialEntity;
    CountDownTimer countDownTimer, countdownSessionTimer, countdownDialogTimer;
    long currentTime;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    LoginEntity loginEntity;
    int module;
    private static final int ADMIN_INTENT = 15;
    private static final String description = "Some Description About Your Admin";
    private DevicePolicyManager mDevicePolicyManager;
    private ComponentName mComponentName;
    boolean isAdmin;


    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_material);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        studyMaterialEntity = getIntent().getParcelableExtra("STUDY_MATERIAL");
        module = getIntent().getIntExtra("MODULE", -1);
        loginEntity = new LoginFacade(this).getUser();
        initializeLockScreen();
      /*  if (!isAdmin) {
            registerAdmin();
        }*/
        intialize();
        settingWebview();


    }

    private void startSyncTimer() {
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            synchronized public void run() {
                SyncRequestEntity syncRequestEntity = new SyncRequestEntity();
                syncRequestEntity.setFBAId(loginEntity.getFBAId());
                syncRequestEntity.setModuleNo(module);
                syncRequestEntity.setUserId(loginEntity.getUserId());
                syncRequestEntity.setCurrentStudyTime(0);
                syncRequestEntity.setCheckstatus("Yes");
                new ModulePracticeControllar(StudyMaterialActivity.this).getSyncTime(syncRequestEntity, StudyMaterialActivity.this);
                Log.d("SyncTimer", "Service Hit");
            }

        }, TimeUnit.MINUTES.toMillis(Constants.SYNC_TIMER), TimeUnit.MINUTES.toMillis(Constants.SYNC_TIMER));
    }

    private void cancelSyncTimer() {
        if (timer != null)
            timer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startSessionTimer(TimeUnit.SECONDS.toMillis(Constants.SESSION_TIMEOUT_TIME));
        startSyncTimer();


        if (!loginEntity.isIsEligible()) {
            long currTime = loginEntity.getCurrentStudyTime();
            long totalTime = loginEntity.getTotalStudyTime();
            startTimer(totalTime - currTime);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        cancelSyncTimer();
        if (countDownTimer != null)
            countDownTimer.cancel();
        if (countdownSessionTimer != null)
            cancelSessionTimer();
        /*if (sharedPreferences.getLong(Constants.GLOBAL_TIMER, -1) != 0) {
            editor.putLong(Constants.GLOBAL_TIMER, currentTime);
            editor.commit();
        }*/

    }

    private void settingWebview() {

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        //settings.setBuiltInZoomControls(true);
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
        // webView.getSettings().setBuiltInZoomControls(true);

        Log.d("EDUCATION_URL", studyMaterialEntity.getLink());
        webView.loadUrl(studyMaterialEntity.getLink());

        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    cancelSessionTimer();
                    startSessionTimer(TimeUnit.SECONDS.toMillis(Constants.SESSION_TIMEOUT_TIME));
                    //Toast.makeText(StudyMaterialActivity.this, "1", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    private void intialize() {
        sharedPreferences = getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        webView = (WebView) findViewById(R.id.webView);
        txtTimer = (TextView) findViewById(R.id.txtTimer);
    }

    private void startTimer(long millis) {
        countDownTimer = new CountDownTimer(millis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                currentTime = millisUntilFinished;
                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                txtTimer.setText(hms);
            }

            @Override
            public void onFinish() {
                txtTimer.setText("00:00:00");
                AlertDialog.Builder builder = new AlertDialog.Builder(StudyMaterialActivity.this);
                builder.setTitle("STUDY TIME FINISHED!!!");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setMessage(" For Final Assessment – Click Yes\n\n Need more time to Study ?– Click No \n(After completing your study go back to Home page and Click on START EVALUATION)")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(StudyMaterialActivity.this, StartExamActivity.class));
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        };
        countDownTimer.start();
    }

    private void startSessionTimer(long millis) {
        countdownSessionTimer = new CountDownTimer(millis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("SESSION Time : ", "" + millisUntilFinished);
            }

            @Override
            public void onFinish() {
                //lockScreen();
                logoutUser();
            }
        };
        countdownSessionTimer.start();
    }

    private void logoutUser() {


        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("You will be logged out");
        alertDialogBuilder.setTitle(R.string.app_name);
        alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert);
        alertDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                countdownDialogTimer.cancel();
                dialog.cancel();
                cancelSessionTimer();
                startSessionTimer(TimeUnit.SECONDS.toMillis(Constants.SESSION_TIMEOUT_TIME));
                //or alertdialog.dismiss();
            }
        });

        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        countdownDialogTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                alertDialog.setTitle("POSP TRAINING  " + "      00:0" + (millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                alertDialog.cancel();
                showProgressDialog();
                new LoginController(StudyMaterialActivity.this).logout(loginEntity.getUserId(), loginEntity.getFBAId(), StudyMaterialActivity.this);
            }
        }.start();

    }


    private void cancelSessionTimer() {
        if (countdownSessionTimer != null)
            countdownSessionTimer.cancel();
    }

    void registerAdmin() {
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mComponentName);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, description);
        startActivityForResult(intent, ADMIN_INTENT);
    }

    void removeAdmin() {
        mDevicePolicyManager.removeActiveAdmin(mComponentName);
        Toast.makeText(getApplicationContext(), "Admin registration removed", Toast.LENGTH_SHORT).show();
    }

    void lockScreen() {
        if (isAdmin) {
            mDevicePolicyManager.lockNow();
        } else {
            Toast.makeText(getApplicationContext(), "Not Registered as admin", Toast.LENGTH_SHORT).show();
        }
    }

    void initializeLockScreen() {
        mDevicePolicyManager = (DevicePolicyManager) getSystemService(
                Context.DEVICE_POLICY_SERVICE);
        mComponentName = new ComponentName(this, MyAdminReceiver.class);
        isAdmin = mDevicePolicyManager.isAdminActive(mComponentName);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADMIN_INTENT) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "Registered As Admin", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Failed to register as Admin", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) throws InterruptedException {
        if (response instanceof SyncTimeResponse) {
            if (response.getStatusNo() == 0) {
                if (((SyncTimeResponse) response).isIsLogin()) {
                    loginEntity.setCurrentStudyTime(((SyncTimeResponse) response).getCurrentStudyTime());
                    loginEntity.setIsEligible(((SyncTimeResponse) response).isIsEligible());
                    new LoginFacade(StudyMaterialActivity.this).storeUser(loginEntity);
                    Log.d("Time", "" + ((SyncTimeResponse) response).getTotalStudyTime() + " - " + ((SyncTimeResponse) response).getCurrentStudyTime());
                } else {
                    Toast.makeText(this, "You are already logged in some device .. ", Toast.LENGTH_SHORT).show();
                    new LoginController(StudyMaterialActivity.this).logout(loginEntity.getUserId(), loginEntity.getFBAId(), StudyMaterialActivity.this);
                }
            }
        }
        if (response instanceof LogoutResponse) {
            if (response.getStatusNo() == 0) {
                editor.clear();
                editor.commit();
                new LoginFacade(this).clearLoginCache();
                Intent intent = new Intent(this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            } else {
                Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {

    }
}
