package com.datacomp.magicfinmart.pospapp.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.aboutus.AboutUsActivity;
import com.datacomp.magicfinmart.pospapp.certificates.CertificateActivity;
import com.datacomp.magicfinmart.pospapp.exam.StartExamActivity;
import com.datacomp.magicfinmart.pospapp.login.LoginActivity;
import com.datacomp.magicfinmart.pospapp.studymaterial.StudyMaterialAvailable;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;
import com.datacomp.magicfinmart.pospapp.webviews.studymaterial.StudyMaterialActivity;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.login.LoginController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.modulepractice.ModulePracticeControllar;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.userpic.UserPicController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.LoginFacade;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.LoginEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.SyncRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.LogoutResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.SyncTimeResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.UserPicResponse;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, IResponseSubcriber {
    TextView tvStartExam, tvStudyMaterial, txtUserName;
    LoginEntity loginEntity;
    ImageView cameraIcon, imgUser;
    Button btnNext;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private Uri fileUri;
    Bitmap bitmap;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 1112;
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 1;
    private static final String IMAGE_DIRECTORY_NAME = "ProfilePic";
    private static final int CAMERA_REQUEST = 1888;
    String[] perms = {"android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.CAMERA",
    };


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save file url in bundle as it will be null on scren orientation
        // changes
        outState.putParcelable("file_uri", fileUri);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // get the file url
        fileUri = savedInstanceState.getParcelable("file_uri");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_posp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loginEntity = new LoginFacade(this).getUser();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        bindNavigation(navigationView);
        initilize();
        setListener();
        //getting image from sharedpreferencs
        if (!sharedPreferences.getString(Constants.PROFILE_PIC, "").isEmpty()) {
            byte[] decodedString = Base64.decode(sharedPreferences.getString(Constants.PROFILE_PIC, ""), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            cameraIcon.setImageBitmap(decodedByte);
            imgUser.setImageBitmap(decodedByte);
            btnNext.setVisibility(View.VISIBLE);
            imgUser.setImageBitmap(decodedByte);
        } else {
            if (loginEntity.getUserPic() != null && !loginEntity.getUserPic().isEmpty()) {


                Glide.with(this)
                        .load(loginEntity.getUserPic()).asBitmap()
                        .into(new SimpleTarget<Bitmap>(100, 100) {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                                if (resource != null) {
                                    cameraIcon.setImageBitmap(resource); // Possibly runOnUiThread()
                                    btnNext.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                Glide.with(this)
                        .load(loginEntity.getUserPic()).asBitmap()
                        .into(new SimpleTarget<Bitmap>(100, 100) {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                                if (resource != null)
                                    imgUser.setImageBitmap(resource);

                                // Possibly runOnUiThread()
                            }
                        });

            }
        }
        // getting image from server

    }

    SimpleTarget target = new SimpleTarget<Bitmap>() {
        @Override
        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
            if (bitmap != null) {
                cameraIcon.setImageBitmap(bitmap);
                imgUser.setImageBitmap(bitmap);

            } else {
                btnNext.setVisibility(View.GONE);
            }
        }
    };

    private void bindNavigation(NavigationView navigationView) {
        View headerView = navigationView.getHeaderView(0);
        txtUserName = (TextView) headerView.findViewById(R.id.txtUserName);
        imgUser = (ImageView) headerView.findViewById(R.id.imgUser);
        txtUserName.setText(loginEntity.getFullName());
    }

    private void setListener() {
        tvStartExam.setOnClickListener(this);
        tvStudyMaterial.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        cameraIcon.setOnClickListener(this);
    }

    private void initilize() {
        tvStartExam = (TextView) findViewById(R.id.tvStartExam);
        tvStudyMaterial = (TextView) findViewById(R.id.tvStudyMaterial);
        cameraIcon = (ImageView) findViewById(R.id.cameraIcon);
        btnNext = (Button) findViewById(R.id.btnNext);
        sharedPreferences = getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_studyMaterial) {
            // Toast.makeText(this, "Coming Soon...", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, StudyMaterialAvailable.class));
        } /*else if (id == R.id.nav_startExam) {
            //startActivity(new Intent(MainActivity.this, StartExamActivity.class));

        }*/ else if (id == R.id.nav_logout) {
            showProgressDialog();
            new LoginController(MainActivity.this).logout(loginEntity.getUserId(), loginEntity.getFBAId(), MainActivity.this);

        } else if (id == R.id.nav_certificate) {
            startActivity(new Intent(MainActivity.this, CertificateActivity.class));
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNext:
                SyncRequestEntity syncRequestEntity = new SyncRequestEntity();
                syncRequestEntity.setFBAId(loginEntity.getFBAId());
                syncRequestEntity.setModuleNo(0);
                syncRequestEntity.setUserId(loginEntity.getUserId());
                syncRequestEntity.setCurrentStudyTime(0);
                syncRequestEntity.setCheckstatus("No");
                showProgressDialog();
                new ModulePracticeControllar(MainActivity.this).getSyncTime(syncRequestEntity, MainActivity.this);
                break;
            case R.id.cameraIcon:
                if (!isDeviceSupportCamera()) {
                    Toast.makeText(getApplicationContext(),
                            "Sorry! Your device doesn't support front camera",
                            Toast.LENGTH_LONG).show();
                } else {
                    if (checkPermission()) {
                        captureImage();
                    } else {
                        requestPermission();
                    }

                }
                break;
            case R.id.tvStartExam:
                startActivity(new Intent(MainActivity.this, StartExamActivity.class));
                break;
            case R.id.tvStudyMaterial:
                startActivity(new Intent(MainActivity.this, StudyMaterialActivity.class));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // successfully captured the image
                // display it in image view
                previewCapturedImage();
            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled Image capture
                Toast.makeText(getApplicationContext(),
                        "User cancelled image capture", Toast.LENGTH_SHORT)
                        .show();
            } else {
                // failed to capture image
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                        .show();
            }
        }
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            cameraIcon.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.VISIBLE);
            Bitmap mphoto = (Bitmap) data.getExtras().get("data");
            cameraIcon.setImageBitmap(mphoto);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            mphoto.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
            editor.putString(Constants.PROFILE_PIC, encoded);
            editor.commit();
        }
    }

    private void previewCapturedImage() {
        try {
            // hide video preview

            cameraIcon.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.VISIBLE);


            // bimatp factory
            BitmapFactory.Options options = new BitmapFactory.Options();

            // downsizing image as it throws OutOfMemory Exception for larger
            // images
            options.inSampleSize = 8;


            bitmap = BitmapFactory.decodeFile(fileUri.getPath(),
                    options);

            cameraIcon.setImageBitmap(bitmap);
            imgUser.setImageBitmap(bitmap);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
            editor.putString(Constants.PROFILE_PIC, encoded);
            editor.commit();

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void captureImage() {
      /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        // start the image capture Intent
        startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);*/


        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    private static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                        + IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");
        } else {
            return null;
        }

        return mediaFile;
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

    private boolean isDeviceSupportCamera() {
        if (getApplicationContext().getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA_FRONT)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults.length > 0) {
                    boolean writeExternal = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean camera = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if (camera && writeExternal)
                        captureImage();
                }
                break;
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) throws InterruptedException {

        if (response instanceof SyncTimeResponse) {
            dismissDialog();
            if (response.getStatusNo() == 0) {
                if (((SyncTimeResponse) response).isIsLogin()) {
                    String base64 = sharedPreferences.getString(Constants.PROFILE_PIC, "");
                    if (!base64.isEmpty()) {
                        showProgressDialog();
                        new UserPicController(this).uploadPic(base64, loginEntity.getUserId(), this);
                    } else {
                        if (loginEntity.getUserPic() != null && !loginEntity.getUserPic().isEmpty()) {

                          /*  loginEntity.setIsEligible(((SyncTimeResponse) response).isIsEligible());
                            new LoginFacade(MainActivity.this).storeUser(loginEntity);*/
                            startActivity(new Intent(this, HomeActivity.class));
                        }
                    }
                } else {
                    Toast.makeText(this, "You are already logged in some device .. ", Toast.LENGTH_SHORT).show();
                    new LoginController(MainActivity.this).logout(loginEntity.getUserId(), loginEntity.getFBAId(), MainActivity.this);
                }
            }
        }


        if (response instanceof UserPicResponse) {
            dismissDialog();
            if (response.getStatusNo() == 0) {
                startActivity(new Intent(this, HomeActivity.class));
            } else {
                Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
            }
        }
        if (response instanceof LogoutResponse) {
            if (response.getStatusNo() == 0) {
                editor.clear();
                editor.commit();
                Intent intent = new Intent(this, com.datacomp.magicfinmart.home.HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            } else {
                Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        dismissDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
