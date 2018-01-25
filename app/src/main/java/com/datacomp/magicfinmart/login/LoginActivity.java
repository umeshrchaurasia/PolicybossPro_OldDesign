package com.datacomp.magicfinmart.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.register.RegisterActivity;
import com.datacomp.magicfinmart.utility.ReadDeviceID;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.login.LoginController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.LoginRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginResponse;

public class LoginActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {
    EditText etEmail, etPassword;
    LoginRequestEntity loginRequestEntity;
    TextView tvSignUp;
    Button btnSignIn;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 1111;
    String[] perms = {
            "android.permission.CAMERA",
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.SEND_SMS",
            "android.permission.READ_SMS",
            "android.permission.RECEIVE_SMS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loginRequestEntity = new LoginRequestEntity();
        initWidgets();
        setListener();
        realm = Realm.getDefaultInstance();

        if (!checkPermission()) {
            requestPermission();
        }
    }


    //region permission

    private boolean checkPermission() {

        int camera = ContextCompat.checkSelfPermission(getApplicationContext(), perms[0]);
        int fineLocation = ContextCompat.checkSelfPermission(getApplicationContext(), perms[1]);
        int sendSms = ContextCompat.checkSelfPermission(getApplicationContext(), perms[2]);
        int readSms = ContextCompat.checkSelfPermission(getApplicationContext(), perms[3]);
        int receiveSms = ContextCompat.checkSelfPermission(getApplicationContext(), perms[4]);
        return camera == PackageManager.PERMISSION_GRANTED
                && fineLocation == PackageManager.PERMISSION_GRANTED
                && sendSms == PackageManager.PERMISSION_GRANTED
                && readSms == PackageManager.PERMISSION_GRANTED
                && receiveSms == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, perms, REQUEST_CODE_ASK_PERMISSIONS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults.length > 0) {

                    //boolean writeExternal = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean camera = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean fineLocation = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean sendSms = grantResults[2] == PackageManager.PERMISSION_GRANTED;
                    boolean readSms = grantResults[3] == PackageManager.PERMISSION_GRANTED;
                    boolean receiveSms = grantResults[4] == PackageManager.PERMISSION_GRANTED;


                    if (camera && fineLocation && sendSms && readSms && receiveSms) {
                        // you can do all necessary steps
                        // new Dialer().getObject().getLeadData(String.valueOf(Utility.EmpCode), this, this);
                        Toast.makeText(this, "All permission granted", Toast.LENGTH_SHORT).show();
                    } else {

                        //Permission Denied, You cannot access location data and camera
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                            showMessageOKCancel("Required permissions to proceed Magic-finmart..!",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            // finish();
                                            requestPermission();
                                        }
                                    });
                        }
                    }
                }
                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(LoginActivity.this)
                .setTitle("Retry")
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                //.setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    //endregion

    private void setListener() {
        tvSignUp.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    private void initWidgets() {
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSignUp:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.btnSignIn:
                if (!isValideEmailID(etEmail)) {
                    etEmail.requestFocus();
                    etEmail.setError("Enter Valid Email");
                    return;
                }
                if (!isEmpty(etPassword)) {
                    etPassword.requestFocus();
                    etPassword.setError("Enter Password");
                    return;
                }
                loginRequestEntity.setUserName(etEmail.getText().toString());
                loginRequestEntity.setPassword(etPassword.getText().toString());
                loginRequestEntity.setDeviceId("" + new ReadDeviceID(this).getAndroidID());
                showDialog();
                new LoginController(this).login(loginRequestEntity, this);
                break;
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof LoginResponse) {
            if (response.getStatusNo() == 0) {
                startActivity(new Intent(this, HomeActivity.class));
            } else {
                Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
