package com.datacomp.magicfinmart.insert_contact;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.myaccount.MyAccountActivity;
import com.datacomp.magicfinmart.utility.Constants;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity;

public class InsertContactActivity extends BaseActivity implements View.OnClickListener, BaseActivity.PopUpListener {

    String[] perms = {
            "android.permission.READ_CONTACTS",
            "android.permission.WRITE_CONTACTS"

    };

    int isContactFirstCall;
    UserConstantEntity userConstantEntity;
    LoginResponseEntity loginResponseEntity;
    DBPersistanceController dbPersistanceController;
    PrefManager prefManager;

    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        registerPopUp(this);
        dbPersistanceController = new DBPersistanceController(this);
        loginResponseEntity = dbPersistanceController.getUserData();
        userConstantEntity = dbPersistanceController.getUserConstantsData();
        prefManager = new PrefManager(this);


        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnSubmit) {
            if (userConstantEntity != null) {
                if (!checkPermission()) {
                    if (checkRationalePermission()) {
                        //Show Information about why you need the permission
                        requestPermission();
                    }else {

                        openPopUp(btnSubmit, "Need  Permission", "Required Contact Permission", "GRANT", true);

                    }

                } else {
                    addFinmartContact();

                }
            }
        }
    }

    private void addFinmartContact() {
        if (userConstantEntity.getFinmartwhatsappno() != null) {
            isContactFirstCall = Integer.parseInt(prefManager.getContactMsgFirst());

                Utility.WritePhoneContact(getResources().getString(R.string.Finmart), userConstantEntity.getFinmartwhatsappno(), InsertContactActivity.this);

                prefManager.updateContactMsgFirst("" + 1);


        }

    }

    public void ConfirmInsertContactAlert(String Title, String strBody, final String strMobile) {


        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomDialog);


        Button btnAllow, btnReject;
        TextView txtTile, txtBody, txtMob;
        ImageView ivCross;

        LayoutInflater inflater = this.getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.layout_insert_contact_popup, null);

        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        // set the custom dialog components - text, image and button
        txtTile = (TextView) dialogView.findViewById(R.id.txtTile);
        txtBody = (TextView) dialogView.findViewById(R.id.txtMessage);
        txtMob = (TextView) dialogView.findViewById(R.id.txtOther);
        ivCross = (ImageView) dialogView.findViewById(R.id.ivCross);

        btnAllow = (Button) dialogView.findViewById(R.id.btnAllow);
        btnReject = (Button) dialogView.findViewById(R.id.btnReject);
        txtTile.setText(Title);
        txtBody.setText(strBody);
        txtMob.setText(strMobile);

        btnAllow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Utility.WritePhoneContact(getResources().getString(R.string.Finmart), userConstantEntity.getFinmartwhatsappno(), InsertContactActivity.this);
                prefManager.updateContactMsgFirst("" + 1);
                Toast.makeText(InsertContactActivity.this, "Contact Saved Successfully..", Toast.LENGTH_SHORT).show();
            }
        });

        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                prefManager.updateContactMsgFirst("" + 1);
            }
        });

        ivCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });
        alertDialog.setCancelable(false);
        alertDialog.show();

    }


    //region permission

    private boolean checkPermission() {

        int readContact = ContextCompat.checkSelfPermission(getApplicationContext(), perms[0]);
        int writeContact = ContextCompat.checkSelfPermission(getApplicationContext(), perms[1]);

        return readContact == PackageManager.PERMISSION_GRANTED
                && writeContact == PackageManager.PERMISSION_GRANTED;

    }

    private boolean checkRationalePermission() {

        boolean readContact = ActivityCompat.shouldShowRequestPermissionRationale(InsertContactActivity.this, perms[0]);

        boolean writeContact = ActivityCompat.shouldShowRequestPermissionRationale(InsertContactActivity.this, perms[1]);


        return readContact || writeContact ;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, perms, Constants.REQUEST_CODE_ASK_PERMISSIONS);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {


            case Constants.REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults.length > 0) {

                    //boolean writeExternal = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean readContact = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean writeContact = grantResults[1] == PackageManager.PERMISSION_GRANTED;


                    if (readContact && writeContact) {

                        addFinmartContact();
                    }
                }
                break;

        }
    }

    @Override
    public void onPositiveButtonClick(Dialog dialog, View view) {

        dialog.cancel();
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, Constants.REQUEST_PERMISSION_SETTING);

    }

    @Override
    public void onCancelButtonClick(Dialog dialog, View view) {

        dialog.cancel();
    }
    //endregion
}
