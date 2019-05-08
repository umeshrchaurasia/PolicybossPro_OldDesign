package com.datacomp.magicfinmart.helpfeedback.raiseticket;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.helpfeedback.raiseticket.adapter.RaiseTicketAdapter;
import com.datacomp.magicfinmart.myaccount.MyAccountActivity;
import com.datacomp.magicfinmart.utility.CircleTransform;
import com.datacomp.magicfinmart.utility.Constants;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register.RegisterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.zoho.ZohoController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TicketEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.DocumentResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TicketListResponse;
import okhttp3.MultipartBody;

public class RaiseTicketActivity extends BaseActivity implements IResponseSubcriber, View.OnClickListener, BaseActivity.PopUpListener {

    FloatingActionButton btnAddTicket;
    RecyclerView rvTicketList;
    RaiseTicketAdapter raiseTicketAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    List<QuoteListEntity> mQuoteList;
    QuoteListEntity removeQuoteEntity;
    ImageView ivSearch,ivUser;
    TextView tvAdd, tvSearch;
    EditText etSearch;
    List<TicketEntity> ticketEntities;
    DBPersistanceController dbPersistanceController;
    LoginResponseEntity loginResponseEntity;
    AlertDialog alertDialog,finmartContacttDialog;

    private static final int CAMERA_REQUEST = 1888;
    private static final int SELECT_PICTURE = 1800;

    String[] perms = {
            "android.permission.CAMERA",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.READ_EXTERNAL_STORAGE"

    };
    File Docfile;
    File file;
    Uri imageUri;
    InputStream inputStream;
    ExifInterface ei;
    Bitmap bitmapPhoto = null;
    private String PHOTO_File = "FBAPhotograph";
    MultipartBody.Part part;
    HashMap<String, String> body;
    private int PROFILE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raise_ticket);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbPersistanceController = new DBPersistanceController(this);
        loginResponseEntity = dbPersistanceController.getUserData();
        registerPopUp(this);
        initView();
        setListener();
        setTextWatcher();
    }

    private void initView() {
        ivSearch = (ImageView) findViewById(R.id.ivSearch);

        tvAdd = (TextView) findViewById(R.id.tvAdd);
        tvSearch = (TextView) findViewById(R.id.tvSearch);
        etSearch = (EditText) findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);

        btnAddTicket = (FloatingActionButton) findViewById(R.id.btnAddTicket);
        rvTicketList = (RecyclerView) findViewById(R.id.rvTicketList);
        rvTicketList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvTicketList.setLayoutManager(layoutManager);
        btnAddTicket.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        showDialog("Fetching Tickets..");
        new ZohoController(this).getListOfTickets("" + loginResponseEntity.getFBAId(), this);

    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof TicketListResponse) {

            if (response.getStatusNo() == 0) {
                ticketEntities = ((TicketListResponse) response).getMasterData();
                raiseTicketAdapter = new RaiseTicketAdapter(this, ticketEntities);
                rvTicketList.setAdapter(raiseTicketAdapter);
            }
        }  else if (response instanceof DocumentResponse) {
            if (response.getStatusNo() == 0) {

                // Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
                setDocumentUpload(((DocumentResponse) response).getMasterData().get(0).getPrv_file());

                    try {
                        updateLoginResponse(((DocumentResponse) response).getMasterData().get(0).getPrv_file());

                        dbPersistanceController.updateUserConstatntProfile(((DocumentResponse) response).getMasterData().get(0).getPrv_file());

                        // Todo : Firing Local BroadCase
                        Intent profileIntent = new Intent(Utility.USER_PROFILE_ACTION);
                        profileIntent.putExtra("PROFILE_PATH", ((DocumentResponse) response).getMasterData().get(0).getPrv_file());

                        LocalBroadcastManager.getInstance(RaiseTicketActivity.this).sendBroadcast(profileIntent);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }



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
            case R.id.tvAdd:
            case R.id.btnAddTicket:
                startActivity(new Intent(this, AddTicketActivity.class));
                break;
            case R.id.tvSearch:
            case R.id.ivSearch:
                InputMethodManager inputMethodManager =
                        (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInputFromWindow(
                        etSearch.getApplicationWindowToken(),
                        InputMethodManager.SHOW_FORCED, 0);
                /*InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(etSearch, InputMethodManager.SHOW_IMPLICIT);*/
                if (etSearch.getVisibility() == View.INVISIBLE) {
                    etSearch.setVisibility(View.VISIBLE);
                    etSearch.requestFocus();
                }
                break;

        }
    }

    private void setTextWatcher() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                raiseTicketAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


    public void PopUp_addcomment() {

//

            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomDialog);


            Button btn_submit;
            EditText et_Comment;
            ImageView ivCross,ivProfile;

            LayoutInflater inflater = this.getLayoutInflater();

            final View dialogView = inflater.inflate(R.layout.layout_addcomment, null);

            builder.setView(dialogView);
            finmartContacttDialog = builder.create();
             btn_submit = (Button) dialogView.findViewById(R.id.btn_submit);
            ivProfile = (ImageView) dialogView.findViewById(R.id.ivProfile);
              ivUser = (ImageView) findViewById(R.id.ivUser);
                 ivCross = (ImageView) dialogView.findViewById(R.id.ivCross);


        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryCamPopUp();
            }
        });


            btn_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finmartContacttDialog.dismiss();
                   // startActivity(new Intent(getActivity(), MyAttendanceActivity.class));

                }
            });





            ivCross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finmartContacttDialog.dismiss();

                }
            });
            finmartContacttDialog.setCancelable(false);
            finmartContacttDialog.show();
        }

    private void galleryCamPopUp() {

        if (!checkPermission()) {

            if (checkRationalePermission()) {
                //Show Information about why you need the permission
                requestPermission();

            } else {
                //Previously Permission Request was cancelled with 'Dont Ask Again',
                // Redirect to Settings after showing Information about why you need the permission

                //  permissionAlert(navigationView,"Need Call Permission","This app needs Call permission.");
                openPopUp(tvAdd, "Need  Permission", "This app needs all permissions.", "GRANT", true);


            }
        } else {

            showCamerGalleryPopUp();
        }
    }
    // region permission
    private boolean checkPermission() {

        int camera = ActivityCompat.checkSelfPermission(getApplicationContext(), perms[0]);

        int WRITE_EXTERNAL = ActivityCompat.checkSelfPermission(getApplicationContext(), perms[1]);
        int READ_EXTERNAL = ActivityCompat.checkSelfPermission(getApplicationContext(), perms[2]);

        return camera == PackageManager.PERMISSION_GRANTED
                && WRITE_EXTERNAL == PackageManager.PERMISSION_GRANTED
                && READ_EXTERNAL == PackageManager.PERMISSION_GRANTED;
    }

    private boolean checkRationalePermission() {

        boolean camera = ActivityCompat.shouldShowRequestPermissionRationale(RaiseTicketActivity.this, perms[0]);

        boolean write_external = ActivityCompat.shouldShowRequestPermissionRationale(RaiseTicketActivity.this, perms[1]);
        boolean read_external = ActivityCompat.shouldShowRequestPermissionRationale(RaiseTicketActivity.this, perms[2]);

        return camera || write_external || read_external;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, perms, Constants.PERMISSION_CAMERA_STORACGE_CONSTANT);
    }

    private void showCamerGalleryPopUp() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this, R.style.CustomDialog);

        LinearLayout lyCamera, lyGallery;
        LayoutInflater inflater = this.getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.layout_cam_gallery, null);

        builder.setView(dialogView);
        final android.support.v7.app.AlertDialog alertDialog = builder.create();
        // set the custom dialog components - text, image and button
        lyCamera = (LinearLayout) dialogView.findViewById(R.id.lyCamera);
        lyGallery = (LinearLayout) dialogView.findViewById(R.id.lyGallery);

        lyCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchCamera();
                alertDialog.dismiss();

            }
        });

        lyGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
                alertDialog.dismiss();

            }
        });
        alertDialog.setCancelable(true);
        alertDialog.show();
        //  alertDialog.getWindow().setLayout(900, 600);

        // for user define height and width..
    }


    private void launchCamera() {


        String FileName = "PHOTO_File";


        Docfile = createFile(FileName);

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            imageUri = Uri.fromFile(Docfile);
        } else {
            imageUri = FileProvider.getUriForFile(RaiseTicketActivity.this,
                    getString(R.string.file_provider_authority), Docfile);
        }


        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,
                imageUri);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }


    private void openGallery() {

        String FileName = "PHOTO_File";


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
                    file = saveImageToStorage(mphoto, PHOTO_File);
                    setProfilePhoto(mphoto);
                    part = Utility.getMultipartImage(file);
                    body = Utility.getBody(this, loginResponseEntity.getFBAId(), PROFILE, PHOTO_File);

                    new RegisterController(this).uploadDocuments(part, body, this);


        } else if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();
            Bitmap mphoto = null;
            try {
                mphoto = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                mphoto = getResizedBitmap(mphoto, 800);
                mphoto = rotateImageIfRequired(this, mphoto, Docfile);

                        showDialog();
                        setProfilePhoto(mphoto);
                        file = saveImageToStorage(mphoto, "PROFILE");
                        part = Utility.getMultipartImage(file);
                        body = Utility.getBody(this, loginResponseEntity.getFBAId(), PROFILE, PHOTO_File);
                        new RegisterController(this).uploadDocuments(part, body, this);



            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    private void setProfilePhoto(Bitmap mphoto) {

        bitmapPhoto = mphoto;        //original
    }
    public Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);

    }

    private void setDocumentUpload(String URL) {

            Glide.with(RaiseTicketActivity.this)
                    .load(URL)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .placeholder(R.drawable.circle_placeholder)
                    .skipMemoryCache(true)
                    .override(120, 120)
                    .transform(new CircleTransform(RaiseTicketActivity.this)) // applying the image transformer
                    .into(ivUser);

    }
    public void updateLoginResponse(final String fbaProfileUrl) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //loginResponseEntity.setFBAProfileUrl("http://qa.mgfm.in/" + fbaProfileUrl);
                loginResponseEntity.setFBAProfileUrl(fbaProfileUrl);
            }
        });
    }

}
