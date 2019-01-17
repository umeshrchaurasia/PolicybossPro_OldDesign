package com.datacomp.magicfinmart.offline_quotes;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.utility.Constants;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.offline_quotes.OfflineQuotesController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocumentEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.OfflineQuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UploadMotorEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CreateQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.DocumentResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineInputEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineInputResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.RequiredDocEntity;
import okhttp3.MultipartBody;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.bumptech.glide.load.resource.bitmap.TransformationUtils.rotateImage;

public class AddOfflineQuotesActivity extends BaseActivity implements IResponseSubcriber, View.OnClickListener {


    Button  btnHome;
    ArrayAdapter<OfflineInputEntity> offlineTypeAdapter;
    List<OfflineInputEntity> offlineInputEntities;
    List<RequiredDocEntity> requiredDocEntities;
    LinearLayout  llDocumentUpload;
    UploadDocumentsAdapter uploadDocumentsAdapter;
    RecyclerView rvDocUpload;


    //OfflineQuoteEntity quoteEntity;
    UploadMotorEntity uploadMotorEntity;
    List<RequiredDocEntity> li;

    String[] perms = {
            "android.permission.CAMERA",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.READ_EXTERNAL_STORAGE"

    };
    HashMap<String, String> body;
    MultipartBody.Part part;
    File Docfile;
    File file;
    Uri imageUri;
    InputStream inputStream;
    ExifInterface ei;
    private static final int CAMERA_REQUEST = 1888;
    private static final int SELECT_PICTURE = 1800;

    DocumentEntity documentEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offline_quotes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init_widgets();


        if (getIntent().getParcelableExtra(Constants.OFFLINE_DOC_DATA) != null) {
            uploadMotorEntity = getIntent().getParcelableExtra(Constants.OFFLINE_DOC_DATA);


            bindDocumentUpload(uploadMotorEntity.getDocument());


        }

    }



    private List<RequiredDocEntity> getRequiredDocEntities(int productId) {
        List<RequiredDocEntity> list = new ArrayList<>();
        for (RequiredDocEntity requiredDocEntity : this.requiredDocEntities) {
            if (requiredDocEntity.getId() == productId) {
                list.add(requiredDocEntity);
            }
        }
        return list;
    }

    private void init_widgets() {

        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(this);

        llDocumentUpload = findViewById(R.id.llDocumentUpload);

        rvDocUpload = findViewById(R.id.rvDocUpload);
        rvDocUpload.setLayoutManager(new LinearLayoutManager(this));


    }



    private void bindDocumentUpload(List<DocumentEntity> list) {
        uploadDocumentsAdapter = new UploadDocumentsAdapter(this, list);
        rvDocUpload.setAdapter(uploadDocumentsAdapter);
    }



    private void setDocumentUpload(String urlPath) {

        if (documentEntity != null) {
            documentEntity.setDocpath(urlPath);
            uploadDocumentsAdapter.updateList(documentEntity);
        }

    }

    private void checkDocUploade(List<CreateQuoteResponse.MasterDataBean.DocstatusBean> docstatus) {

//        if (docstatus.size() > 0) {
//            for (int i = 0; i < li.size(); i++) {
//                requiredDocEntity = li.get(i);
//                for (CreateQuoteResponse.MasterDataBean.DocstatusBean objDoc : docstatus) {
//                    if (requiredDocEntity.getDocname().toUpperCase().trim().equalsIgnoreCase(objDoc.getDocument_name().toUpperCase().trim())) {
//                        requiredDocEntity.setUploaded(true);
//                        li.set(i, requiredDocEntity);
//                    }
//                }
//            }
//        }
    }


    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof DocumentResponse) {
            if (response.getStatusNo() == 0) {
                setDocumentUpload(((DocumentResponse) response).getMasterData().get(0).getPrv_file());
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnHome:
                Toast.makeText(this, "Data Save Successfully...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("MarkTYPE", "FROM_HOME");
                startActivity(intent);

                finish();
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_home:

                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("MarkTYPE", "FROM_HOME");
                startActivity(intent);

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }





    //region  upload documents methods



    private boolean checkPermission() {

        int camera = ActivityCompat.checkSelfPermission(getApplicationContext(), perms[0]);

        int WRITE_EXTERNAL = ActivityCompat.checkSelfPermission(getApplicationContext(), perms[1]);
        int READ_EXTERNAL = ActivityCompat.checkSelfPermission(getApplicationContext(), perms[2]);

        return camera == PackageManager.PERMISSION_GRANTED
                && WRITE_EXTERNAL == PackageManager.PERMISSION_GRANTED
                && READ_EXTERNAL == PackageManager.PERMISSION_GRANTED;
    }

    public void galleryCamPopUp(DocumentEntity entity) {
        this.documentEntity = entity;
        if (!checkPermission()) {

            if (checkRationalePermission()) {
                //Show Information about why you need the permission
                requestPermission();

            } else {
                //Previously Permission Request was cancelled with 'Dont Ask Again',
                // Redirect to Settings after showing Information about why you need the permission

                //  permissionAlert(navigationView,"Need Call Permission","This app needs Call permission.");
                openPopUp(btnHome, "Need  Permission", "This app needs all permissions.", "GRANT", true);


            }
        } else {

            showCamerGalleryPopUp(documentEntity);
        }
    }

    private boolean checkRationalePermission() {

        boolean camera = ActivityCompat.shouldShowRequestPermissionRationale(this, perms[0]);

        boolean write_external = ActivityCompat.shouldShowRequestPermissionRationale(this, perms[1]);
        boolean read_external = ActivityCompat.shouldShowRequestPermissionRationale(this, perms[2]);

        return camera || write_external || read_external;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, perms, Constants.PERMISSION_CAMERA_STORACGE_CONSTANT);
    }

    private void showCamerGalleryPopUp(final DocumentEntity requiredDocEntity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomDialog);

        LinearLayout lyCamera, lyGallery;
        LayoutInflater inflater = this.getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.layout_cam_gallery, null);

        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        // set the custom dialog components - text, image and button
        lyCamera = (LinearLayout) dialogView.findViewById(R.id.lyCamera);
        lyGallery = (LinearLayout) dialogView.findViewById(R.id.lyGallery);

        lyCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchCamera(requiredDocEntity);
                alertDialog.dismiss();

            }
        });

        lyGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(requiredDocEntity);
                alertDialog.dismiss();

            }
        });
        alertDialog.setCancelable(true);
        alertDialog.show();
        //  alertDialog.getWindow().setLayout(900, 600);

        // for user define height and width..
    }

    private void launchCamera(DocumentEntity requiredDocEntity) {


        String FileName = requiredDocEntity.getDocname();

        Docfile = createFile(FileName);

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            imageUri = Uri.fromFile(Docfile);
        } else {
            imageUri = FileProvider.getUriForFile(this,
                    getString(R.string.file_provider_authority), Docfile);
        }


        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,
                imageUri);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }


    private void openGallery(DocumentEntity requiredDocEntity) {

        String FileName = requiredDocEntity.getDocname();

        Docfile = createFile(FileName);

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    private Bitmap rotateImageIfRequired(Context context, Bitmap bitmap, File file) {
        Bitmap rotatedBitmap = null;
        try {

            // region Handling Default Rotation Of Image
            Uri uri = Uri.fromFile(file);
            inputStream = context.getContentResolver().openInputStream(uri);

            if (Build.VERSION.SDK_INT > 23) {
                ei = new ExifInterface(inputStream);
            } else {

                // ei = new ExifInterface("/storage/emulated/0/FINMART/FBAPhotograph.jpg");
                ei = new ExifInterface(file.getAbsolutePath());
            }


            int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);


            switch (orientation) {

                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotatedBitmap = rotateImage(bitmap, 90);
                    break;

                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotatedBitmap = rotateImage(bitmap, 180);
                    break;

                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotatedBitmap = rotateImage(bitmap, 270);
                    break;

                case ExifInterface.ORIENTATION_NORMAL:
                default:
                    rotatedBitmap = bitmap;

            }
            //endregion

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rotatedBitmap;
    }


    public HashMap<String, String> getBody(Context context, DocumentEntity requiredDocEntity, String ReqId) {
        HashMap<String, String> body = new HashMap<String, String>();

        body.put("FBAID", "" + new DBPersistanceController(context).getUserData().getFBAId());
        body.put("DocType", "OFFLINE");
        body.put("DocName", requiredDocEntity.getDocname());
        body.put("quoteid", "" + ReqId);
        return body;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap mphoto = null;
            try {
                mphoto = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                mphoto = getResizedBitmap(mphoto, 800);
                mphoto = rotateImageIfRequired(this, mphoto, Docfile);

            } catch (Exception e) {
                e.printStackTrace();
            }


            showDialog();
            file = saveImageToStorage(mphoto, documentEntity.getDocname());
            part = Utility.getMultipartImage(file);
            body = getBody(this, documentEntity,uploadMotorEntity.getTransId());
            new OfflineQuotesController(this).uploadDocuments(part, body, this);

        } else if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();
            Bitmap mphoto = null;
            try {
                mphoto = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                mphoto = getResizedBitmap(mphoto, 800);
                mphoto = rotateImageIfRequired(this, mphoto, Docfile);


                showDialog();
                file = saveImageToStorage(mphoto, documentEntity.getDocname());
                part = Utility.getMultipartImage(file);
                body = getBody(this, documentEntity,uploadMotorEntity.getTransId());
                new OfflineQuotesController(this).uploadDocuments(part, body, this);

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    //endregion
}
