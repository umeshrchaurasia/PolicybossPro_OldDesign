package com.policyboss.magicfinmart.attendance;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.policyboss.magicfinmart.BaseActivity;
import com.policyboss.magicfinmart.R;
import com.policyboss.magicfinmart.location.LocationService;
import com.policyboss.magicfinmart.utility.Constants;
import com.policyboss.magicfinmart.utility.ReadDeviceID;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.Locale;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.DynamicController;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model.SwipeDetailsEntity;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity.RegisterRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response.SwipeDetailResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity;

// ILocationStateListener,
public class AttendanceRegistraionActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber, LocationService.ILocation {

    LocationService locationService;
    private static final int REQUEST_CHECK_SETTINGS = 0x1;

    final private int REQUEST_CODE_ASK_PERMISSIONS = 1111;

    private int PERMISSION_DENIED = 0;

    String[] perms = {
            "android.permission.ACCESS_FINE_LOCATION"

    };

    /*********************************************************************/
    DBPersistanceController dbController;
    UserConstantEntity userConstantEntity;

    EditText etEmail, etConfirmEmail, etMobile;
    //etUid,et_name, etUserPassword, etRePassword, etHrms, etDept ;
    TextView txtLatitude, txtlong, txtAddress;

    Button btnSubmit, btnMyloc;


    String lat, lon;
    List<SwipeDetailsEntity> lstAttendance;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_registraion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dbController = new DBPersistanceController(this);
        userConstantEntity = dbController.getUserConstantsData();

        initialize();
        Constants.hideKeyBoard(etEmail, AttendanceRegistraionActivity.this);

        // Initailize the Service Call and ServiceCallBack
        locationService = new LocationService(this);
        locationService.setLocationListener(this);

        if (!checkPermission()) {
            requestPermission();
        } else {

            locationService.createLocationRequest();
        }

    }

    //region permission

    private boolean checkPermission() {


        int fineLocation = ContextCompat.checkSelfPermission(getApplicationContext(), perms[0]);

        return fineLocation == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, perms, REQUEST_CODE_ASK_PERMISSIONS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults.length > 0) {


                    boolean fineLocation = grantResults[0] == PackageManager.PERMISSION_GRANTED;


                    if (!fineLocation) {

                        //Permission Denied, You cannot access location data and camera
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                            showMessageOKCancel("Required permissions to proceed Magic-finmart..!",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            // finish();
                                            if (2 > PERMISSION_DENIED) {
                                                PERMISSION_DENIED++;
                                                requestPermission();
                                            } else {
                                                dialogInterface.dismiss();

                                            }
                                        }
                                    });
                        } else {
                            // initialiseAndRetriveLocation();
                        }
                    }
                }
                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(AttendanceRegistraionActivity.this, R.style.AlertDialog_Theme)

                .setTitle("Retry")
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                //.setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    //endregion

    // region comment
//    private void initialiseAndRetriveLocation() {
//        //region init location
//        mLocationTracker = new LocationTracker(AttendanceRegistraionActivity.this);
//        //location callback method
//        mLocationTracker.setLocationStateListener(this);
//        //GoogleApiClient initialisation and location update
//        mLocationTracker.init();
//        //GoogleApiclient connect
//        mLocationTracker.onResume();
//
//
//    }

//    @Override
//    public void onLocationChanged(Location location) {
//        if (mLocation == null) {
//            showGoogleMap();
//            return;
//        }
//    }
//
//    @Override
//    public void onConnected() {
//
//        if (mLocationTracker.mLocation == null) {
//
//            showGoogleMap();
//            return;
//        } else {
//            mLocation = mLocationTracker.mLocation;
//        }
//    }
//
//    @Override
//    public void onConnectionFailed() {
//        Toast.makeText(this, "Enable to get your current Location, Try again", Toast.LENGTH_LONG).show();
//    }

    //endregion

    private void initialize() {

        etMobile = findViewById(R.id.etMobile);
        etEmail = findViewById(R.id.etEmail);
        etConfirmEmail = findViewById(R.id.etConfirmEmail);

        txtLatitude = findViewById(R.id.textViewlat);
        txtlong = (TextView) findViewById(R.id.textViewlog);
        txtAddress = (TextView) findViewById(R.id.txtAddress);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnMyloc = findViewById(R.id.btnMyloc);


        etConfirmEmail.setOnFocusChangeListener(confirmEmailFocus);
        btnSubmit.setOnClickListener(this);
        btnMyloc.setOnClickListener(this);

    }

    View.OnFocusChangeListener confirmEmailFocus = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                if (!etEmail.getText().toString().equals(etConfirmEmail.getText().toString())) {
                    //etConfirmEmail.requestFocus();
                    etConfirmEmail.setError("Email Mismatch");
                }
            }
        }
    };


    @Override
    protected void onResume() {
        super.onResume();

    }


    private void showGoogleMap() {

        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(AttendanceRegistraionActivity.this);
            builder.setTitle("Oops! Your location not found.");

            builder.setMessage("Kindly go to google map , set your current location and try again.");

            String positiveText = "OK";
            builder.setPositiveButton(positiveText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 19.0857745, 72.8883218);
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                            AttendanceRegistraionActivity.this.startActivity(intent);

                        }
                    });


            final AlertDialog dialog = builder.create();
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();

        } catch (Exception ex) {
            Toast.makeText(this, "Please try again..", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.btnMyloc) {

            if (!checkPermission()) {
                requestPermission();
            } else {

                locationService.createLocationRequest();
//                initialiseAndRetriveLocation();
//
//                if (mLocationTracker != null) {
//
//
//                    lat = String.valueOf(mLocation.getLatitude());
//                    lon = String.valueOf(mLocation.getLongitude());
//
//                    txtLatitude.setText(lat);
//                    txtlong.setText(lon);
//                }
            }
        } else if (view.getId() == R.id.btnSubmit) {
            Constants.hideKeyBoard(view, AttendanceRegistraionActivity.this);
            String mobileNo = etMobile.getText().toString();
            if (!isValidePhoneNumber(etMobile)) {
                etMobile.setError("ENTER VALID MOBILE");
                etMobile.requestFocus();
                return;
            }

            if (!isValideEmailID(etEmail)) {
                etEmail.setError("ENTER VALID EMAIL");
                etEmail.requestFocus();
                return;
            }

            if (!etEmail.getText().toString().equals(etConfirmEmail.getText().toString())) {
                etConfirmEmail.requestFocus();
                etConfirmEmail.setError("EMAIL MISMATCH");
                return;
            }
            if (txtLatitude.getText().equals("")) {
                Snackbar.make(etMobile, "Click Get Location", Snackbar.LENGTH_SHORT).show();
                return;
            }

            RegisterRequestEntity objregister = new RegisterRequestEntity();

            objregister.setEmailid(etEmail.getText().toString());
            objregister.setLat(txtLatitude.getText().toString());
            objregister.setLng(txtlong.getText().toString());
            objregister.setmobileno(etMobile.getText().toString());
            objregister.setUid(userConstantEntity.getUserid());
            objregister.setDeviceId(new ReadDeviceID(this).getAndroidID());
            objregister.setDeviceToken("");

            showDialog();
            new DynamicController(this).attendanceRegister(objregister, this);


        }

    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

        cancelDialog();
        if (response instanceof SwipeDetailResponse) {
            if (response.getStatusNo() == 0) {

                etMobile.setText("");
                etEmail.setText("");

                Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("MESSAGE", "Done");
                setResult(5, intent);
                finish();


            } else {
                Snackbar.make(etMobile, response.getMessage(), Snackbar.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void OnFailure(Throwable t) {

        cancelDialog();
        Snackbar.make(btnSubmit, t.getMessage(), Snackbar.LENGTH_SHORT).show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onBackPressed() {


        setResult(5, null);
        finish();
        super.onBackPressed();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationService.stopLocationUpdates();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            // Google Api Location Request Callback (ie User click on OK and NO,THANKS )
            // Check for the integer request code originally supplied to startResolutionForResult().
            case REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        locationService.startLocationUpdates();
                        break;
                    case Activity.RESULT_CANCELED:
                        locationService.stopLocationUpdates();
                        break;
                }
                break;
        }
    }


    @Override
    public void getLocation(Location mLocation) {

        if (mLocation != null) {

            locationService.stopLocationUpdates();
           // Toast.makeText(this, "Location Callback" + mLocation.getLatitude() + " And " + mLocation.getLongitude(), Toast.LENGTH_LONG).show();


            lat = String.valueOf(mLocation.getLatitude());
            lon = String.valueOf(mLocation.getLongitude());

            txtLatitude.setText(lat);
            txtlong.setText(lon);

        }
    }
}
