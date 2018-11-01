package com.datacomp.magicfinmart.scan_vehicle;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.DynamicController;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.VehicleInfoEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;

public class ScanVehicleActivity extends BaseActivity {


    private static final String TAG = "ScanVehicleActivity";
    private static final int requestPermissionID = 101;

    SurfaceView mCameraView;
    EditText etVehicleNo;
    CameraSource mCameraSource;
    Button btnGo;

    VehicleInfoEntity.VehicleInfo mVehicleInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_vehicle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mCameraView = findViewById(R.id.surfaceView);
        etVehicleNo = findViewById(R.id.etVehicleNo);
        btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // if (validateVehicle(etVehicleNo.getText().toString())) {
                    //service hit
                    showDialog();
                    fetchCarDetail();

               // } else {
                    Toast.makeText(ScanVehicleActivity.this, "Invalid vehicle No.", Toast.LENGTH_SHORT).show();
               // }

            }
        });

        startCameraSource();
    }

    private void fetchCarDetail() {
        showDialog();
        new DynamicController(this).getVehicleByVehicleNo(etVehicleNo.getText().toString(),
                new IResponseSubcriber() {

                    @Override
                    public void OnSuccess(APIResponse response, String message) {
                        cancelDialog();
                        if (response instanceof magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.VehicleInfoEntity) {
                            //bind vehicle

                            if (((VehicleInfoEntity) response).getGetRegNoDataResult() == null) {
                                Toast.makeText(ScanVehicleActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                                return;
                            } else if (((VehicleInfoEntity) response).getGetRegNoDataResult().size() == 0) {
                                Toast.makeText(ScanVehicleActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            mVehicleInfo = ((VehicleInfoEntity) response).getGetRegNoDataResult().get(0);
                            bindVehicle(mVehicleInfo);
                        }
                    }

                    @Override
                    public void OnFailure(Throwable t) {
                        cancelDialog();
                        Toast.makeText(ScanVehicleActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void bindVehicle(VehicleInfoEntity.VehicleInfo mVehicleInfo) {

        AlertDialog.Builder vehicleInfoAlertDialog;
        vehicleInfoAlertDialog = new AlertDialog.Builder(this);
        vehicleInfoAlertDialog.setCancelable(true);
        vehicleInfoAlertDialog.setTitle("Vehicle Detail");

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Name : " + mVehicleInfo.getClientName());
        stringBuilder.append("\nVehicle Name : " + mVehicleInfo.getMake() + "," + mVehicleInfo.getModel());
        stringBuilder.append("\nExpiry Date : " + mVehicleInfo.getExpiryDate());

        vehicleInfoAlertDialog.setMessage(stringBuilder);

        vehicleInfoAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = vehicleInfoAlertDialog.create();
        dialog.show();

    }


    private boolean validateVehicle(String vehicleNo) {

        String regxVehicle = "^[A-Z]{2}[0-9]{1,2}[A-Z]{1,2}[0-9]{4}\\$";

        if (!vehicleNo.matches(regxVehicle)) {
            return false;
        }

        if (etVehicleNo.getText().toString().matches(regxVehicle)) {
            return true;
        } else {
            return false;
        }
    }

    private void startCameraSource() {

        //Create the TextRecognizer
        final TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();

        if (!textRecognizer.isOperational()) {
            Log.w(TAG, "Detector dependencies not loaded yet");
        } else {

            //Initialize camerasource to use high resolution and set Autofocus on.
            mCameraSource = new CameraSource.Builder(getApplicationContext(), textRecognizer)
                    .setFacing(CameraSource.CAMERA_FACING_BACK)
                    .setRequestedPreviewSize(1280, 1024)
                    .setAutoFocusEnabled(true)
                    .setRequestedFps(2.0f)
                    .build();

            /**
             * Add call back to SurfaceView and check if camera permission is granted.
             * If permission is granted we can start our cameraSource and pass it to surfaceView
             */
            mCameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    try {

                        if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                            ActivityCompat.requestPermissions(ScanVehicleActivity.this,
                                    new String[]{Manifest.permission.CAMERA},
                                    requestPermissionID);
                            return;
                        }
                        mCameraSource.start(mCameraView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                }

                /**
                 * Release resources for cameraSource
                 */
                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    mCameraSource.stop();
                }
            });

            //Set the TextRecognizer's Processor.
            textRecognizer.setProcessor(new Detector.Processor<TextBlock>() {
                @Override
                public void release() {
                }

                /**
                 * Detect all the text from camera using TextBlock and the values into a stringBuilder
                 * which will then be set to the textView.
                 * */
                @Override
                public void receiveDetections(Detector.Detections<TextBlock> detections) {
                    final SparseArray<TextBlock> items = detections.getDetectedItems();
                    if (items.size() != 0) {

                        String validVehicleNo = "";
                        etVehicleNo.post(new Runnable() {
                            @Override
                            public void run() {

                                String stringBuilder = "";

                                for (int i = 0; i < items.size(); i++) {

                                    TextBlock item = items.valueAt(i);
                                    stringBuilder = item.getValue();
                                    break;
                                }
                                etVehicleNo.setText(stringBuilder);
                            }
                        });
                    }
                }
            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode != requestPermissionID) {
            Log.d(TAG, "Got unexpected permission result: " + requestCode);
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            try {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                mCameraSource.start(mCameraView.getHolder());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
