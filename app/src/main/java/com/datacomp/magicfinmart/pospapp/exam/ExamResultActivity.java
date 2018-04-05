package com.datacomp.magicfinmart.pospapp.exam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.certificates.CertificateActivity;
import com.datacomp.magicfinmart.pospapp.home.MainActivity;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.LoginFacade;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.LoginEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.SubmitResponse;

public class ExamResultActivity extends BaseActivity implements View.OnClickListener {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    LoginEntity loginEntity;
    ImageView ivCongrats;
    TextView tvName, tvTotalMarks, tvMarksObtained, tvPassingMarks, tvResultStatus, tvMessage, tvAttemptsLeft;
    Button btnViewCertificate;
    SubmitResponse submitResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loginEntity = new LoginFacade(this).getUser();
        initialize();
        submitResponse = getIntent().getParcelableExtra("SUBMIT_RESPONSE");
        if (submitResponse != null)
            bindData(submitResponse);

    }

    private void bindData(SubmitResponse submitResponse) {
        tvName.setText(loginEntity.getFullName());
        if (submitResponse.getMarksObtained() >= submitResponse.getPassingMarks()) {
            btnViewCertificate.setVisibility(View.VISIBLE);
            ivCongrats.setImageDrawable(getResources().getDrawable(R.drawable.congratulations));
            tvResultStatus.setText("PASS");
            tvMessage.setText("Thank You for giving the exam !!\nYou will receive your passing certificate on the registered Mail Id. ");
            tvAttemptsLeft.setText("" + submitResponse.getNoofAttempt());
        } else {
            btnViewCertificate.setVisibility(View.VISIBLE);
            btnViewCertificate.setText("Home");
            ivCongrats.setVisibility(View.GONE);
            tvResultStatus.setText("FAIL");
            tvResultStatus.setTextColor(Color.RED);
            tvMessage.setText("Thank you for giving the evaluation. Since you have not passed this evaluation , you will be allowed to re-attempt this 5 times within a period of 90 days.");
            tvMessage.setTextColor(Color.RED);
            tvAttemptsLeft.setText("" + submitResponse.getNoofAttempt());
        }
        tvTotalMarks.setText("" + submitResponse.getTotalMarks());
        tvMarksObtained.setText("" + submitResponse.getMarksObtained());
        tvPassingMarks.setText("" + submitResponse.getPassingMarks());
        tvAttemptsLeft.setText("" + submitResponse.getNoofAttempt());

    }

    private void initialize() {
        sharedPreferences = getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        ivCongrats = (ImageView) findViewById(R.id.ivCongrats);
        tvTotalMarks = (TextView) findViewById(R.id.tvTotalMarks);
        tvMarksObtained = (TextView) findViewById(R.id.tvMarksObtained);
        tvPassingMarks = (TextView) findViewById(R.id.tvPassingMarks);
        tvResultStatus = (TextView) findViewById(R.id.tvResultStatus);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        tvName = (TextView) findViewById(R.id.tvName);
        tvAttemptsLeft = (TextView) findViewById(R.id.tvAttemptsLeft);
        btnViewCertificate = (Button) findViewById(R.id.btnViewCertificate);
        btnViewCertificate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnViewCertificate) {
            if (!btnViewCertificate.getText().equals("Home"))
                startActivity(new Intent(ExamResultActivity.this, CertificateActivity.class));
            else {
                finish();
                if (submitResponse.getNoofAttempt() >= 5) {
                    loginEntity.setIsEligible(false);
                    loginEntity.setCurrentStudyTime(0);
                    loginEntity.setNoofAttempt(0);
                    new LoginFacade(ExamResultActivity.this).storeUser(loginEntity);
                }
                Intent intent = new Intent(ExamResultActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

        }
    }
}
