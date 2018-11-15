package com.datacomp.magicfinmart.contact_lead;

import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.SelectUser;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register.RegisterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.ContactLeadRequestEntity;

public class ContactLeadActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {

    Cursor phones;
    ArrayList<SelectUser> selectUsers;
    ProgressBar progressBar;
    TextView txtOutput, txtCount;
    Button btnSync;
    LinearLayout lySync;

    int output = 0;
    int progress = 0;
    LoadContactTask loadContactTask = null;
    List<ContactlistEntity> contactlist, contactListDb;
    LoginResponseEntity loginResponseEntity;
    DBPersistanceController db;
    RecyclerView rvContactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_lead);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        db = new DBPersistanceController(this);
        loginResponseEntity = db.getUserData();

    }

    private void init() {

        rvContactList = findViewById(R.id.rvContactList);
        rvContactList.setLayoutManager(new LinearLayoutManager(this));

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txtOutput = (TextView) findViewById(R.id.txtOutput);
        txtCount = (TextView) findViewById(R.id.txtCount);

        btnSync = (Button) findViewById(R.id.btnSync);
        lySync = (LinearLayout) findViewById(R.id.lySync);
        txtOutput.setText("0");

        loadContactTask = new LoadContactTask();
        lySync.setVisibility(View.GONE);
        btnSync.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnSync) {
           // lySync.setVisibility(View.VISIBLE);
            //syncContactNumber();

            contactListDb = new DBPersistanceController(this).getContactList();
            List<ContactlistEntity> temp= new ArrayList<>();
            temp = contactListDb.subList(0,  2);
            ContactLeadRequestEntity contactRequestEntity = new ContactLeadRequestEntity();
            contactRequestEntity.setFbaid(String.valueOf(loginResponseEntity.getFBAId()));
            contactRequestEntity.setContactlist(temp);
            new RegisterController(ContactLeadActivity.this).uploadContact(contactRequestEntity, this);
        }

    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

    }

    @Override
    public void OnFailure(Throwable t) {

    }

    class LoadContactTaskA extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtCount.setText("" + phones.getCount());
            //setProgressBarIndeterminate(false);
            progressBar.setMax(phones.getCount());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // Get Contact list from Phone
            if (phones != null && phones.getCount() > 0) {
                try {
                    int i = 1;
                    while (phones.moveToNext()) {

                        Thread.sleep(1);

                        String name = "" + phones.getString(phones.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        String phoneNumber = "" + phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


                        SelectUser selectUser = new SelectUser();

                        selectUser.setName(name);
                        selectUser.setPhone(phoneNumber);

                        selectUsers.add(selectUser);
                        publishProgress(i++);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //phones.close();
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // setProgress(values[0]);
            output++;
            //  progress = (int)(((double)output/phones.getCount())*10000);
            //  setProgress(progress);
            progressBar.setProgress(values[0]);
            txtOutput.setText("" + values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //       cancelDialog();
            int i = selectUsers.size();
            txtOutput.setText("Done");


        }
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
        super.onBackPressed();
        loadContactTask.cancel(true);
    }


    private void syncContactNumber() {
        contactlist = new ArrayList<ContactlistEntity>();
        String[] PROJECTION = new String[]{
                ContactsContract.RawContacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.PHOTO_URI,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Photo.CONTACT_ID};

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String filter = "" + ContactsContract.Contacts.HAS_PHONE_NUMBER + " > 0 and " + ContactsContract.CommonDataKinds.Phone.TYPE + "=" + ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE;
        String order = ContactsContract.Contacts.DISPLAY_NAME + " ASC";// LIMIT " + limit + " offset " + lastId + "";

        phones = this.getContentResolver().query(uri, PROJECTION, filter, null, order);


        if (phones == null || phones.getCount() == 0) {
            Log.e("count", "" + phones.getCount());

        } else {

            new LoadContactTask().execute();

        }

    }

    class LoadContactTask extends AsyncTask<Void, Void, Void> {

        String name = "";
        String mobileNumber = "";
        String uri = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog("Syncing Contact..");
            //Toast.makeText(ContactLeadActivity.this, "Syncing Contact..", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // Get Contact list from Phone
            if (phones != null && phones.getCount() > 0) {
                try {
                    int i = 1;
                    while (phones.moveToNext()) {
                        name = "" + phones.getString(phones.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        mobileNumber = "" + phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        uri = "" + phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
                        ContactlistEntity contactEntity = new ContactlistEntity();
                        contactEntity.setName(name);
                        contactEntity.setMobileno(mobileNumber);
                        contactEntity.setUrl(uri);
                        contactlist.add(contactEntity);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //phones.close();
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //       cancelDialog();
            if (contactlist.size() > 0) {
                new AsyncContactMaster(ContactLeadActivity.this, contactlist).execute();


               /* ContactLeadRequestEntity contactRequestEntity = new ContactLeadRequestEntity();
                contactRequestEntity.setFbaid(String.valueOf(loginResponseEntity.getFBAId()));
                contactRequestEntity.setContactlist(contactlist);*/
                //new RegisterController(ContactLeadActivity.this).saveContactLead(contactRequestEntity, ContactLeadActivity.this);
            }


        }
    }

    public void contactSavedToDB() {
        cancelDialog();
        Toast.makeText(this, contactlist.size() + " Contacts Saved to local Database !", Toast.LENGTH_SHORT).show();
        //sendContactToServer();
    }

    public void sendContactToServer() {

        contactListDb = new DBPersistanceController(this).getContactList();


        if (contactListDb != null && contactListDb.size() > 0) {
            List<ContactlistEntity> temp;
            temp = contactListDb.subList(0,  2);

            ContactLeadRequestEntity contactRequestEntity = new ContactLeadRequestEntity();
            contactRequestEntity.setFbaid(String.valueOf(loginResponseEntity.getFBAId()));
            contactRequestEntity.setContactlist(temp);
            new RegisterController(ContactLeadActivity.this).uploadContact(contactRequestEntity, ContactLeadActivity.this);



           /* for (int i = 0; i < 100; i = i + 50) {

                if ((i + 50) < contactListDb.size()) {
                    temp = contactListDb.subList(i, i + 50);
                } else {
                    temp = contactListDb.subList(i, (contactListDb.size() - 1));
                }


            }*/

        }


    }
}
