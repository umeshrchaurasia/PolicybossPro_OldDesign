package com.datacomp.magicfinmart.term.icici;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

public class TermICICIActivity extends BaseActivity implements View.OnClickListener {
    Button btnGetQuote;
    EditText etFirstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_icici);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        setListener();
    }

    private void init() {
        btnGetQuote = (Button) findViewById(R.id.btnGetQuote);
    }

    private void setListener() {
        btnGetQuote.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
