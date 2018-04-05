package com.datacomp.magicfinmart.pospapp.exam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.pospapp.utility.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.question.QuestionController;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.AnswerFacade;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.LoginFacade;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.LoginEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.QuestionEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.AnswerSet;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.SubmitRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.QuestionResponse;

public class StartExamActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {
    Button btnStart;
    TextView tvTimer, tvMsg;

    LinearLayout llexamTimer;
    CountDownTimer countDownTimer;
    public boolean timerCheck = false;
    int totalMarks, totalTime, passMarks;
    List<QuestionEntity> questionEntityList;
    LoginEntity loginEntity;
    SubmitRequestEntity submitRequestEntity;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_exam);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loginEntity = new LoginFacade(this).getUser();
        initialize();
        setListener();


    }

    @Override
    protected void onResume() {
        super.onResume();
        countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                btnStart.setVisibility(View.VISIBLE);
                llexamTimer.setVisibility(View.GONE);
            }
        };
        countDownTimer.start();
        new QuestionController(this).getQuestion(loginEntity.getCategoryId(), loginEntity.getUserId(), this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void setListener() {
        tvTimer.setOnClickListener(this);
        btnStart.setOnClickListener(this);
    }

    private void initialize() {
        tvTimer = (TextView) findViewById(R.id.tvTimer);
        btnStart = (Button) findViewById(R.id.btnStart);
        llexamTimer = (LinearLayout) findViewById(R.id.llexamTimer);
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        sharedPreferences = getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                startActivity(new Intent(StartExamActivity.this, QuestionsActivity.class));
                break;
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) throws InterruptedException {
        if (response instanceof QuestionResponse) {
            if (response.getStatusNo() == 0) {
                if (!((QuestionResponse) response).isIsAttempted()) {
                    questionEntityList = ((QuestionResponse) response).getQuestionSet();
                    totalMarks = ((QuestionResponse) response).getTotalMarks();
                    totalTime = ((QuestionResponse) response).getTotalTime();
                    passMarks = ((QuestionResponse) response).getPassMarks();
                    putAllQuestionInDb(questionEntityList);
                } else {
                    countDownTimer.cancel();
                    tvTimer.setVisibility(View.GONE);
                    btnStart.setVisibility(View.GONE);
                    Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else if (response.getStatusNo() == 1) {
                countDownTimer.cancel();
                tvTimer.setVisibility(View.GONE);
                btnStart.setVisibility(View.GONE);
                showAlertDialog(response.getMessage());
            }
        }
    }

    private void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle("Exit");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();
            }
        });
        builder.setCancelable(false);
        builder.show();

    }

    @Override
    public void OnFailure(Throwable t) {
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void putAllQuestionInDb(final List<QuestionEntity> questionEntityList) {

        submitRequestEntity = new SubmitRequestEntity();
        submitRequestEntity.setAnswerSet(getAnswerSetFromQuestionSet(questionEntityList));
        submitRequestEntity.setExamTime(totalTime);
        submitRequestEntity.setFaceAway(0);
        submitRequestEntity.setFaceFront(0);
        submitRequestEntity.setFaceLeft(0);
        submitRequestEntity.setFaceRight(0);
        submitRequestEntity.setMarksObtained(0);
        submitRequestEntity.setTotalMarks(totalMarks);
        submitRequestEntity.setPassMarks(passMarks);
        submitRequestEntity.setQuestionSetId(questionEntityList.get(0).getQuestionSetId());
        submitRequestEntity.setUniqueQuestionSetId(questionEntityList.get(0).getUniqueQuestionSetId());
        submitRequestEntity.setUserId(loginEntity.getUserId());
        new AnswerFacade(this).clearQuestionCache();
        new AnswerFacade(this).storeAnswers(submitRequestEntity);
    }

    private List<AnswerSet> getAnswerSetFromQuestionSet(List<QuestionEntity> questionEntityList) {

        List<AnswerSet> answerSets = new ArrayList<AnswerSet>();
        for (QuestionEntity questionEntity : questionEntityList) {

            AnswerSet answerSet = new AnswerSet();

            answerSet.setCategoryId(questionEntity.getCategoryId());
            answerSet.setCategoryName(questionEntity.getCategoryName());
            answerSet.setCorrectAnswer(questionEntity.getCorrectAnswer());
            answerSet.setLevelId(questionEntity.getLevelId());
            answerSet.setLevelName(questionEntity.getLevelName());
            answerSet.setMarks(questionEntity.getMarks());
            answerSet.setOptionA(questionEntity.getOptionA());
            answerSet.setOptionB(questionEntity.getOptionB());
            answerSet.setOptionC(questionEntity.getOptionC());
            answerSet.setOptionD(questionEntity.getOptionD());
            answerSet.setQuestion(questionEntity.getQuestion());
            answerSet.setQuestionSetId(questionEntity.getQuestionSetId());
            answerSet.setQuestionId(questionEntity.getQuestionId());
            answerSet.setUniqueQuestionSetId(questionEntity.getUniqueQuestionSetId());
            answerSets.add(answerSet);
        }
        return answerSets;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

