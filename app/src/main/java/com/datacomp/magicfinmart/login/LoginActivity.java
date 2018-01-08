package com.datacomp.magicfinmart.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.register.RegisterActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    EditText etEmail;
    TextView tvSignUp;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initWidgets();
        setListener();
    }

    private void setListener() {
        tvSignUp.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    private void initWidgets() {
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSignUp:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.btnSignIn:
                startActivity(new Intent(this, HomeActivity.class));
                break;
        }
    }
}
