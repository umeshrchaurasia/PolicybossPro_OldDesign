package com.datacomp.magicfinmart.pospapp.exam;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.pospapp.facedetection.FaceGraphic;
import com.datacomp.magicfinmart.pospapp.facedetection.ui.camera.CameraSourcePreview;
import com.datacomp.magicfinmart.pospapp.facedetection.ui.camera.GraphicOverlay;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.gson.Gson;
import com.datacomp.magicfinmart.R;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.submit.SubmitController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.AnswerFacade;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.LoginFacade;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.AnswerSet;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.SubmitRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.SubmitResponse;

public class QuestionsActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    RecyclerView rvQuestions;
    QuestionAdapter mAdapter;
    CountDownTimer countDownTimer, awyFromScreenTimer;
    TextView tvTimer, questionAttempted;
    TextView tvAway, tvLeft, tvFront, tvRight;
    Button btnSubmit;
    PowerManager.WakeLock wl;
    PowerManager pm;
    long currentTimerTime;
    int id, left, right, front;
    long prevUpdatedTime = 0;

    SubmitRequestEntity submitRequestEntity;


    private static final String TAG = "FaceTracker";

    private CameraSource mCameraSource = null;

    private CameraSourcePreview mPreview;
    private GraphicOverlay mGraphicOverlay;

    private static final int RC_HANDLE_GMS = 9001;
    // permission request codes need to be < 256
    private static final int RC_HANDLE_CAMERA_PERM = 2;
    SparseArray<Face> faceSparseArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialize();
        wakeUpScreen();
        rvQuestions.setHasFixedSize(true);

        //questionEntityList = realm.where(QuestionEntity.class).findAll();
        submitRequestEntity = new AnswerFacade(this).getAnswer();
        //submitRequestEntityList = realm.where(SubmitRequestEntity.class).findAll();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvQuestions.setLayoutManager(mLayoutManager);
        mAdapter = new QuestionAdapter(this, submitRequestEntity);
        rvQuestions.setAdapter(mAdapter);

        int rc = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (rc == PackageManager.PERMISSION_GRANTED) {
            createCameraSource();
            if (sharedPreferences.getLong(Constants.EXAM_TIMER, -1) < 0) {
                startTimer(TimeUnit.MINUTES.toMillis(submitRequestEntity.getExamTime()));
            } else {
                startTimer(sharedPreferences.getLong(Constants.EXAM_TIMER, -1));
            }
            id = submitRequestEntity.getFaceAway();
            left = submitRequestEntity.getFaceLeft();
            right = submitRequestEntity.getFaceRight();
            front = submitRequestEntity.getFaceFront();

            updateText(id, left, front, right);
        } else {
            requestCameraPermission();
        }
    }


    private void wakeUpScreen() {

        pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "MyTag");
        wl.acquire();
    }

    public void pauseTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void startTimer(long millis) {
        countDownTimer = new CountDownTimer(millis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                currentTimerTime = millisUntilFinished;
                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                tvTimer.setText(hms);
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }

    private void requestCameraPermission() {
        Log.w(TAG, "Camera permission is not granted. Requesting permission");

        final String[] permissions = new String[]{Manifest.permission.CAMERA};

        if (!ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM);
            return;
        }

        final Activity thisActivity = this;

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(thisActivity, permissions,
                        RC_HANDLE_CAMERA_PERM);
            }
        };

        Snackbar.make(mGraphicOverlay, R.string.permission_camera_rationale,
                Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.ok, listener)
                .show();
    }


    @Override
    protected void onResume() {
        super.onResume();

        startCameraSource();
    }

    /**
     * Stops the camera.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mPreview.stop();
        pauseTimer();
        saveInstance(currentTimerTime);

    }

    private void saveInstance(long currentTimerTime) {
        editor.putLong(Constants.EXAM_TIMER, currentTimerTime);
        editor.commit();

    }

    @Override
    protected void onStop() {
        super.onStop();
        pauseTimer();
    }

    /**
     * Releases the resources associated with the camera source, the associated detector, and the
     * rest of the processing pipeline.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCameraSource != null) {
            mCameraSource.release();
        }
    }


    private void initialize() {
        rvQuestions = (RecyclerView) findViewById(R.id.rvQuestions);
        mPreview = (CameraSourcePreview) findViewById(R.id.preview);
        mGraphicOverlay = (GraphicOverlay) findViewById(R.id.faceOverlay);
        tvTimer = (TextView) findViewById(R.id.tvTimer);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        questionAttempted = (TextView) findViewById(R.id.questionAttempted);
        sharedPreferences = getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        tvAway = (TextView) findViewById(R.id.tvAway);
        tvLeft = (TextView) findViewById(R.id.tvLeft);
        tvFront = (TextView) findViewById(R.id.tvFront);
        tvRight = (TextView) findViewById(R.id.tvRight);

    }

    /**
     * Creates and starts the camera.  Note that this uses a higher resolution in comparison
     * to other detection examples to enable the barcode detector to detect small barcodes
     * at long distances.
     */
    private void createCameraSource() {

        Context context = getApplicationContext();
        FaceDetector detector = new FaceDetector.Builder(context)
                .setMode(FaceDetector.ACCURATE_MODE)
                .setClassificationType(FaceDetector.NO_LANDMARKS)
                .setLandmarkType(FaceDetector.NO_LANDMARKS)
                .build();

        detector.setProcessor(
                new MultiProcessor.Builder<>(new QuestionsActivity.GraphicFaceTrackerFactory())
                        .build());

        if (!detector.isOperational()) {
            // Note: The first time that an app using face API is installed on a device, GMS will
            // download a native library to the device in order to do detection.  Usually this
            // completes before the app is run for the first time.  But if that download has not yet
            // completed, then the above call will not detect any faces.
            //
            // isOperational() can be used to check if the required native library is currently
            // available.  The detector will automatically become operational once the library
            // download completes on device.
            Log.w(TAG, "Face detector dependencies are not yet available.");
        }
        prevUpdatedTime = System.currentTimeMillis();
        mCameraSource = new CameraSource.Builder(context, detector)
                .setRequestedPreviewSize(640, 480)
                .setFacing(CameraSource.CAMERA_FACING_FRONT)
                .setRequestedFps(30.0f)
                .build();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(QuestionsActivity.this);
            builder.setTitle(R.string.app_name);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setMessage("Do you want to submit the evaluation ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            showProgressDialog();
                            submitRequestEntity.setMarksObtained(calculateResult(submitRequestEntity.getAnswerSet()));
                            submitRequestEntity.setFBAId(new LoginFacade(QuestionsActivity.this).getUser().getFBAId());
                            new SubmitController(QuestionsActivity.this).submitAnswer(submitRequestEntity, QuestionsActivity.this);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    private int calculateResult(List<AnswerSet> answerSets) {
        int marks = 0;
        for (AnswerSet answerSet : answerSets) {
            if (answerSet.getCorrectAnswer().equals(answerSet.getUserInput()) && !answerSet.getUserInput().isEmpty())
                marks = marks + answerSet.getMarks();
        }
        return marks;
    }

    @Override
    public void OnSuccess(APIResponse response, String message) throws InterruptedException {
        dismissDialog();
        if (response instanceof SubmitResponse) {
            if (response.getStatusNo() == 0) {
                editor.remove(Constants.EXAM_TIMER);
                editor.remove(Constants.QUESTION_FACADE);
                editor.putString(Constants.CERTIFICATE_URL, ((SubmitResponse) response).getPdfPath());
                editor.commit();
                startActivity(new Intent(this, ExamResultActivity.class)
                        .putExtra("SUBMIT_RESPONSE", (SubmitResponse) response));
            }
            Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        dismissDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }


    /**
     * Factory for creating a face tracker to be associated with a new face.  The multiprocessor
     * uses this factory to create face trackers as needed -- one for each individual.
     */
    private class GraphicFaceTrackerFactory implements MultiProcessor.Factory<Face> {
        @Override
        public Tracker<Face> create(Face face) {
            return new QuestionsActivity.GraphicFaceTracker(mGraphicOverlay);
        }
    }

    /**
     * Face tracker for each detected individual. This maintains a face graphic within the app's
     * associated face overlay.
     */
    private class GraphicFaceTracker extends Tracker<Face> {
        private GraphicOverlay mOverlay;
        private FaceGraphic mFaceGraphic;

        GraphicFaceTracker(GraphicOverlay overlay) {
            mOverlay = overlay;
            mFaceGraphic = new FaceGraphic(overlay);
        }

        /**
         * Start tracking the detected face instance within the face overlay.
         */
        @Override
        public void onNewItem(int faceId, Face item) {
            mFaceGraphic.setId(faceId);
        }

        /**
         * Update the position/characteristics of the face within the overlay.
         */
        @Override
        public void onUpdate(FaceDetector.Detections<Face> detectionResults, Face face) {
            mOverlay.add(mFaceGraphic);
            mFaceGraphic.updateFace(face);


            faceSparseArray = detectionResults.getDetectedItems();
            for (int i = 0; i < faceSparseArray.size(); i++) {

                final Face face1 = faceSparseArray.get(faceSparseArray.keyAt(i));
                if (System.currentTimeMillis() > (prevUpdatedTime + 1000))
                    if (face1 != null) {
                        if (face1.getEulerY() <= -20) {
                            right++;
                        }
                        if (face1.getEulerY() >= 20) {
                            left++;
                        }
                        if (face1.getEulerY() < 20 && face1.getEulerY() > -20) {
                            front++;
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateText(face1.getId(), left, front, right);
                            }
                        });

                    }

                Log.d("FACES", "ID : " + face1.getId() +
                                " EulerY : " + face1.getEulerY()
                        // " Width : " + face1.getWidth() +
                        //" Height : " + face1.getHeight() +
                        //" IsLeftEyeOpenProbability : " + face1.getIsLeftEyeOpenProbability() +
                        //" IsRightEyeOpenProbability : " + face1.getIsRightEyeOpenProbability() +
                        //" IsSmilingProbability : " + face1.getIsSmilingProbability() +
                        //" Landmarks : " + face1.getLandmarks().toString() +
                        //" Position : " + face1.getPosition()
                );

            }
        }

        /**
         * Hide the graphic when the corresponding face was not detected.  This can happen for
         * intermediate frames temporarily (e.g., if the face was momentarily blocked from
         * view).
         */
        @Override
        public void onMissing(FaceDetector.Detections<Face> detectionResults) {
            mOverlay.remove(mFaceGraphic);
            Log.d("FACES", "NO FACES");
            awyFromScreenTimer = new CountDownTimer(30 * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    Toast.makeText(QuestionsActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            };
        }

        /**
         * Called when the face is assumed to be gone for good. Remove the graphic annotation from
         * the overlay.
         */
        @Override
        public void onDone() {
            mOverlay.remove(mFaceGraphic);
        }
    }

    private void updateText(int id, int left, int front, int right) {
        Log.d("TRACK", "ID : " + id +
                " left : " + left +
                " front : " + front +
                " right : " + right
        );
        prevUpdatedTime = System.currentTimeMillis();
        tvAway.setText("" + id);
        tvLeft.setText("" + left);
        tvFront.setText("" + front);
        tvRight.setText("" + right);

       /* questionAttempted.setText("Away From Screen : " + id +
                "\nMoved Left : " + left + "" +
                "\nFacing Front : " + front + "" +
                "\nMoved right : " + right + ""
        );*/
        submitRequestEntity.setFaceFront(front);
        submitRequestEntity.setFaceRight(right);
        submitRequestEntity.setFaceAway(id);
        submitRequestEntity.setFaceLeft(left);
        Gson gson = new Gson();
        editor.putString(Constants.QUESTION_FACADE, gson.toJson(submitRequestEntity));
        editor.commit();
    }
    //==============================================================================================
    // Camera Source Preview
    //==============================================================================================

    /**
     * Starts or restarts the camera source, if it exists.  If the camera source doesn't exist yet
     * (e.g., because onResume was called before the camera source was created), this will be called
     * again when the camera source is created.
     */
    private void startCameraSource() {

        // check that the device has play services available.
        int code = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(
                getApplicationContext());
        if (code != ConnectionResult.SUCCESS) {
            Dialog dlg =
                    GoogleApiAvailability.getInstance().getErrorDialog(this, code, RC_HANDLE_GMS);
            dlg.show();
        }

        if (mCameraSource != null) {
            try {
                mPreview.start(mCameraSource, mGraphicOverlay);
            } catch (IOException e) {
                Log.e(TAG, "Unable to start camera source.", e);
                mCameraSource.release();
                mCameraSource = null;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != RC_HANDLE_CAMERA_PERM) {
            Log.d(TAG, "Got unexpected permission result: " + requestCode);
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }

        if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Camera permission granted - initialize the camera source");
            // we have permission, so create the camerasource
            createCameraSource();
            return;
        }

        Log.e(TAG, "Permission not granted: results len = " + grantResults.length +
                " Result code = " + (grantResults.length > 0 ? grantResults[0] : "(empty)"));

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Face Tracker sample")
                .setMessage(R.string.no_camera_permission)
                .setPositiveButton(R.string.ok, listener)
                .show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        wl.release();
    }
}
