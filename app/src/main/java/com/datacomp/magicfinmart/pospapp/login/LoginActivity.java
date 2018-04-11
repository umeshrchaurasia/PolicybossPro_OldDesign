package com.datacomp.magicfinmart.pospapp.login;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.forgotpassword.ForgotPasswordActivity;
import com.datacomp.magicfinmart.pospapp.home.MainActivity;
import com.datacomp.magicfinmart.pospapp.register.RegisterActivity;
import com.datacomp.magicfinmart.pospapp.requestadmin.RequestAdminActivity;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;
import com.datacomp.magicfinmart.pospapp.utility.MyAdminReceiver;
import com.datacomp.magicfinmart.pospapp.utility.ReadDeviceID;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.login.LoginController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.LoginFacade;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.LoginRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.LoginResponse;


public class LoginActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {

    TextView txtForgotPass, txtRegister, txtMessage, tvRqstAdmin;
    TextInputEditText tieEmail, tiePassword;
    Button btnLogin;

    private static final int ADMIN_INTENT = 15;
    private static final String description = "Some Description About Your Admin";
    private DevicePolicyManager mDevicePolicyManager;
    private ComponentName mComponentName;
    boolean isAdmin;
    LoginFacade loginFacade;


    String[] perms = {"android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.CAMERA",
    };
    final private int REQUEST_CODE_ASK_PERMISSIONS = 1112;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_posp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loginFacade = new LoginFacade(this);

        initialize_widgets();
        initializeLockScreen();
        setListeners();
        if (!checkPermission()) {
            requestPermission();
        } else {
            btnLogin.performClick();
        }
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
    protected void onResume() {
        super.onResume();

    }

    private void setListeners() {
        txtForgotPass.setOnClickListener(this);
        txtRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        tvRqstAdmin.setOnClickListener(this);
    }


    private void initialize_widgets() {
        tvRqstAdmin = (TextView) findViewById(R.id.tvRqstAdmin);
        txtForgotPass = (TextView) findViewById(R.id.txtForgotPass);
        txtRegister = (TextView) findViewById(R.id.txtRegister);
        tieEmail = (TextInputEditText) findViewById(R.id.tieEmail);
        tiePassword = (TextInputEditText) findViewById(R.id.tiePassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtMessage = (TextView) findViewById(R.id.txtMessage);

        /*if (loginFacade.getUser() != null && !loginFacade.getUser().equals("")) {
            tieEmail.setText(loginFacade.getUser().getEmail());
        }*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:

                /*if (tieEmail.getText().toString().equals("")) {
                    tieEmail.setError("ENTER USER NAME");
                    tieEmail.requestFocus();
                    return;
                }
                if (tiePassword.getText().toString().equals("")) {
                    tiePassword.setError("ENTER CORRECT PASSWORD");
                    tiePassword.requestFocus();
                    return;
                }*/

                LoginRequestEntity loginRequestEntity = new LoginRequestEntity();
                loginRequestEntity.setEmail("");
                loginRequestEntity.setPassword("");
                loginRequestEntity.setDeviceId(new ReadDeviceID(LoginActivity.this).getAndroidID());
                loginRequestEntity.setDeviceToken("DEVICE_TOKEN");
                loginRequestEntity.setIP("");
                loginRequestEntity.setFBAId(new DBPersistanceController(this).getUserData().getFBAId());
                txtMessage.setVisibility(View.GONE);
                tvRqstAdmin.setVisibility(View.GONE);
                showProgressDialog();
                new LoginController(LoginActivity.this).loginByFBAId(loginRequestEntity, this);

                break;
            case R.id.txtForgotPass:
                startActivity(new Intent(this, ForgotPasswordActivity.class));

                break;
            case R.id.txtRegister:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.tvRqstAdmin:
                startActivity(new Intent(LoginActivity.this, RequestAdminActivity.class).putExtra("EMAIL", tieEmail.getText().toString()));
                break;
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) throws InterruptedException {
        dismissDialog();
        if (response instanceof LoginResponse) {
            if (response.getStatusNo() == 0) {

                finish();
                startActivity(new Intent(this, MainActivity.class));
            } else if (response.getStatusNo() == 3) {
                if (response.getMessage().contains("already")) {
                    tvRqstAdmin.setVisibility(View.VISIBLE);
                }
                txtMessage.setVisibility(View.VISIBLE);
                txtMessage.setText(response.getMessage());
                //Snackbar.make(txtForgotPass, "" + response.getMessage(), Snackbar.LENGTH_LONG).show();
            } else if (response.getStatusNo() == 1) {
                showAlert(response.getMessage());
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        dismissDialog();
        //showAlert(t.getMessage());
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }


    private boolean checkPermission() {

        int writeLogResult = ContextCompat.checkSelfPermission(getApplicationContext(), perms[0]);
        int camera = ContextCompat.checkSelfPermission(getApplicationContext(), perms[1]);

        return writeLogResult == PackageManager.PERMISSION_GRANTED
                && camera == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, perms, REQUEST_CODE_ASK_PERMISSIONS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults.length > 0) {
                    boolean writeExternal = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean camera = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                }
                break;
        }
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


    private void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Please Contact FSM");
        builder.setMessage(message);
        builder.setCancelable(false);

        builder.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder.create();
        alert11.show();
    }
}
