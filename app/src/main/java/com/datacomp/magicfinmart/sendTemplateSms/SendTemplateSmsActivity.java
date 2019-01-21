package com.datacomp.magicfinmart.sendTemplateSms;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.notification.NotificationActivity;
import com.datacomp.magicfinmart.notification.NotificationAdapter;
import com.datacomp.magicfinmart.utility.Constants;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register.RegisterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.NotificationEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SmsTemplateEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.NotificationResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.SmsTemplateResponse;

public class SendTemplateSmsActivity extends BaseActivity implements IResponseSubcriber {

    RecyclerView rvSendSms;
    List<SmsTemplateEntity> smsTemplateEntityList;
    SendTemplateAdapter mAdapter;
    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginEntity;
    PrefManager prefManager;

    Button btnAddContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dbPersistanceController = new DBPersistanceController(this);
        loginEntity = dbPersistanceController.getUserData();

        initialize();

        // getNotificationData
        showDialog("Fetching Data...");
        new RegisterController(SendTemplateSmsActivity.this).getSmsTemplate( SendTemplateSmsActivity.this);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                try {
//                ArrayList<ContentProviderOperation> ops =
//                        new ArrayList<ContentProviderOperation>();
//
//                ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
//                        .withValue(ContactsContract.Data.RAW_CONTACT_ID, 22000)
//                        .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
//                        .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, "9990009920")
//                        .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_CUSTOM)
//                        .withValue(ContactsContract.CommonDataKinds.Phone.LABEL, "Finmart Contact")
//                        .build());
//
//                    getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
//
//                    Toast.makeText(SendTemplateSmsActivity.this,"Contact Saved Successfully...",Toast.LENGTH_SHORT).show();
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                } catch (OperationApplicationException e) {
//                    e.printStackTrace();
//                }


                WritePhoneContact("Finmart Contact","9999911111",SendTemplateSmsActivity.this);

            }
        });

    }

    public void WritePhoneContact(String displayName, String number, Context cntx /*App or Activity Ctx*/) {
        Context contetx = cntx; //Application's context or Activity's context
        String strDisplayName = displayName; // Name of the Person to add
        String strNumber = number; //number of the person to add with the Contact
        System.out.println("NAME> " + strDisplayName + "    NUMBER ====>  " + strNumber);
        ArrayList<ContentProviderOperation> cntProOper = new ArrayList<ContentProviderOperation>();
        int contactIndex = cntProOper.size();//ContactSize

        //Newly Inserted contact
        // A raw contact will be inserted ContactsContract.RawContacts table in contacts database.
        cntProOper.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)//Step1
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null).build());

        //Display name will be inserted in ContactsContract.Data table
        cntProOper.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)//Step2
                .withValueBackReference(ContactsContract.RawContacts.Data.RAW_CONTACT_ID, contactIndex)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, strDisplayName) // Name of the contact
                .build());
        //Mobile number will be inserted in ContactsContract.Data table
        cntProOper.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)//Step 3
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, contactIndex)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, strNumber) // Number to be added
                .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE).build()); //Type like HOME, MOBILE etc
        try {
            // We will do batch operation to insert all above data
            //Contains the output of the app of a ContentProviderOperation.
            //It is sure to have exactly one of uri or count set
            ContentProviderResult[] contentProresult = null;
            contentProresult = contetx.getContentResolver().applyBatch(ContactsContract.AUTHORITY, cntProOper); //apply above data insertion into contacts list

            Toast.makeText(SendTemplateSmsActivity.this,"Contact Saved Successfully...",Toast.LENGTH_SHORT).show();

        } catch (RemoteException exp) {
            //logs;
        } catch (OperationApplicationException exp) {
            //logs
        }
    }

    private void initialize() {

        prefManager = new PrefManager(SendTemplateSmsActivity.this);
        smsTemplateEntityList = new ArrayList<SmsTemplateEntity>();

        prefManager.setNotificationCounter(0);

        rvSendSms = (RecyclerView) findViewById(R.id.rvSendSms);
        rvSendSms.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SendTemplateSmsActivity.this);
        rvSendSms.setLayoutManager(layoutManager);

        btnAddContact =  findViewById(R.id.btnAddContact);

    }

    public void redirectToTempate(SmsTemplateEntity smsTemplateEntity) {

        try {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "", null));
            intent.putExtra("sms_body", ""+smsTemplateEntity.getTemplete().toString());
            startActivity(intent);
            //    startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", mobNumber, null)));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Invalid Number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

        cancelDialog();
        if (response instanceof SmsTemplateResponse) {

            if (response.getStatusNo() == 0) {
                if ( ((SmsTemplateResponse) response).getMasterData() != null) {

                    smsTemplateEntityList = ((SmsTemplateResponse) response).getMasterData();

                    mAdapter = new SendTemplateAdapter(SendTemplateSmsActivity.this, smsTemplateEntityList);
                    rvSendSms.setAdapter(mAdapter);
                } else {
                    rvSendSms.setAdapter(null);
                    Snackbar.make(rvSendSms, "No Data Available", Snackbar.LENGTH_SHORT).show();
                }
            }else {
                rvSendSms.setAdapter(null);
                Snackbar.make(rvSendSms, "No Data Available", Snackbar.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void OnFailure(Throwable t) {

        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();

        // intent.putExtra("COUNTER", "0");
        setResult(Constants.REQUEST_CODE, intent);
        finish();
        super.onBackPressed();
    }


}
