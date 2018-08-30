package com.datacomp.magicfinmart.posp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.register.RegisterActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register.RegisterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PincodeResponse;

public class AddPOSPUserActivity extends BaseActivity implements IResponseSubcriber, View.OnClickListener {

    EditText etFirstName, etLastName, etDob, etMobile1, etMobile2, etEmail, etPincode, etCity, etState;
    TextView txtMale, txtFemale;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    boolean isMale = false, isFemale = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pospuser);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init_widget();
    }

    private void init_widget() {
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etDob = findViewById(R.id.etDob);
        etMobile1 = findViewById(R.id.etMobile1);
        etMobile2 = findViewById(R.id.etMobile2);
        etEmail = findViewById(R.id.etEmail);
        etPincode = findViewById(R.id.etPincode);
        etCity = findViewById(R.id.etCity);
        etState = findViewById(R.id.etState);
        txtMale = findViewById(R.id.txtMale);
        txtFemale = findViewById(R.id.txtFemale);
        etPincode.addTextChangedListener(pincodeTextWatcher);

        txtMale.setOnClickListener(this);
        txtFemale.setOnClickListener(this);
        etDob.setOnClickListener(datePickerDialog);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtMale:
                isFemale = false;
                isMale = true;
                setGender(txtMale, txtFemale);
                break;
            case R.id.txtFemale:
                isFemale = true;
                isMale = false;
                setGender(txtFemale, txtMale);
                break;
        }
    }

    private void setGender(TextView clickedText, TextView textView1) {
        clickedText.setBackgroundResource(R.drawable.customeborder_blue);
        clickedText.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));

        textView1.setBackgroundResource(R.drawable.customeborder);
        textView1.setTextColor(ContextCompat.getColor(this, R.color.description_text));
    }


    protected View.OnClickListener datePickerDialog = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            Constants.hideKeyBoard(view, AddPOSPUserActivity.this);

            if (view.getId() == R.id.etDob) {
                DateTimePicker.showHealthAgeDatePicker(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                        if (view1.isShown()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(year, monthOfYear, dayOfMonth);
                            String currentDay = simpleDateFormat.format(calendar.getTime());
                            //store selected date in TAG
                            etDob.setTag(R.id.etDob, calendar.getTime());
                            etDob.setText(currentDay);
                        }
                    }
                });
            }
        }
    };

    //region textwatcher
    TextWatcher pincodeTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (start == 5) {
                etCity.setText("");
                etState.setText("");
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() == 6) {
                showDialog("Fetching City...");
                new RegisterController(AddPOSPUserActivity.this)
                        .getCityState(etPincode.getText().toString(), AddPOSPUserActivity.this);

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    @Override
    public void OnSuccess(APIResponse response, String message) {
        if (response instanceof PincodeResponse) {
            cancelDialog();
            if (response.getStatusNo() == 0) {
                Constants.hideKeyBoard(etPincode, this);
                etState.setText("" + ((PincodeResponse) response).getMasterData().getState_name());
                etCity.setText("" + ((PincodeResponse) response).getMasterData().getCityname());
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
