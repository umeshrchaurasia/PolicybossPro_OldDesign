package com.datacomp.magicfinmart.term.icici;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.creditcard.ICICICreditApplyActivity;
import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TermICICIActivity extends BaseActivity implements View.OnClickListener {
    Button btnGetQuote;
    EditText etFirstName, etLastName, etMobile;
    RadioButton rbMale, rbNoSmoker;
    EditText etDOB;
    Spinner spOptions, spPremiumTerm, spPremiumFrequency;
    TextView txtLumpSum, txtRegularIncome, txtIncreasingIncome;
    EditText etSumAssured, etPolicyTerm, etPremiumTerm, etCriticalIllness, etAccidentalBenefits;
    Button minusSum, plusSum, minusPTerm, plusPTerm, minusPreTerm, plusPreTerm, minusCritical, plusCritical, minusAcc, plusAcc;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    ArrayAdapter<String> policyOptionsAdapter, policyTermAdapter, premiumFrequencyAdapter;

    LinearLayout llAccidental, llCritical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_icici);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        setListener();
        setTextWatcher();
        bindSpinner();

        llCritical.setVisibility(View.GONE);
        llAccidental.setVisibility(View.GONE);

        etSumAssured.setText("10000000");
        etPolicyTerm.setText("20");
        etPremiumTerm.setText("20");

        etPolicyTerm.setFilters(new InputFilter[]{new InputFilterMinMax("1", "99")});
        etPremiumTerm.setFilters(new InputFilter[]{new InputFilterMinMax("1", "99")});
    }

    private void bindSpinner() {

        policyTermAdapter = new
                ArrayAdapter(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.icici_payment_term)) {

                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        if (convertView == null) {
                            LayoutInflater inflater = LayoutInflater.from(TermICICIActivity.this);
                            convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
                        }
                        // android.R.id.text1 is default text view in resource of the android.
                        // android.R.layout.simple_spinner_item is default layout in resources of android.

                        TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
                        String[] items = getResources().getStringArray(R.array.icici_payment_term);
                        tv.setText(items[position]);
                        tv.setTextColor(Color.BLACK);
                        tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                        return convertView;
                    }

                    @Override
                    public boolean isEnabled(int position) {
                        if (position == 0) {
                            // Disable the first item from Spinner
                            // First item will be use for hint
                            return false;
                        } else {
                            return true;
                        }
                    }

                    @Override
                    public View getDropDownView(int position, View convertView,
                                                ViewGroup parent) {
                        View view = super.getDropDownView(position, convertView, parent);
                        TextView tv = (TextView) view;
                        if (position == 0) {
                            // Set the hint text color gray
                            tv.setTextColor(Color.GRAY);
                        } else {
                            tv.setTextColor(Color.BLACK);
                        }
                        return view;
                    }
                };
        spPremiumTerm.setAdapter(policyTermAdapter);

        policyOptionsAdapter = new
                ArrayAdapter(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.icici_options)) {

                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        if (convertView == null) {
                            LayoutInflater inflater = LayoutInflater.from(TermICICIActivity.this);
                            convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
                        }
                        // android.R.id.text1 is default text view in resource of the android.
                        // android.R.layout.simple_spinner_item is default layout in resources of android.

                        TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
                        String[] items = getResources().getStringArray(R.array.icici_options);
                        tv.setText(items[position]);
                        tv.setTextColor(Color.BLACK);
                        tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                        return convertView;
                    }

                    @Override
                    public boolean isEnabled(int position) {
                        if (position == 0) {
                            // Disable the first item from Spinner
                            // First item will be use for hint
                            return false;
                        } else {
                            return true;
                        }
                    }

                    @Override
                    public View getDropDownView(int position, View convertView,
                                                ViewGroup parent) {
                        View view = super.getDropDownView(position, convertView, parent);
                        TextView tv = (TextView) view;
                        if (position == 0) {
                            // Set the hint text color gray
                            tv.setTextColor(Color.GRAY);
                        } else {
                            tv.setTextColor(Color.BLACK);
                        }
                        return view;
                    }
                };
        spOptions.setAdapter(policyOptionsAdapter);

        premiumFrequencyAdapter = new
                ArrayAdapter(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.icici_premium_frequency)) {

                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        if (convertView == null) {
                            LayoutInflater inflater = LayoutInflater.from(TermICICIActivity.this);
                            convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
                        }
                        // android.R.id.text1 is default text view in resource of the android.
                        // android.R.layout.simple_spinner_item is default layout in resources of android.

                        TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
                        String[] items = getResources().getStringArray(R.array.icici_premium_frequency);
                        tv.setText(items[position]);
                        tv.setTextColor(Color.BLACK);
                        tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                        return convertView;
                    }

                    @Override
                    public boolean isEnabled(int position) {
                        if (position == 0) {
                            // Disable the first item from Spinner
                            // First item will be use for hint
                            return false;
                        } else {
                            return true;
                        }
                    }

                    @Override
                    public View getDropDownView(int position, View convertView,
                                                ViewGroup parent) {
                        View view = super.getDropDownView(position, convertView, parent);
                        TextView tv = (TextView) view;
                        if (position == 0) {
                            // Set the hint text color gray
                            tv.setTextColor(Color.GRAY);
                        } else {
                            tv.setTextColor(Color.BLACK);
                        }
                        return view;
                    }
                };
        spPremiumFrequency.setAdapter(premiumFrequencyAdapter);
    }

    private void setTextWatcher() {
        etSumAssured.addTextChangedListener(new GenericTextWatcher(etSumAssured));
        etPolicyTerm.addTextChangedListener(new GenericTextWatcher(etPolicyTerm));
        etPremiumTerm.addTextChangedListener(new GenericTextWatcher(etPremiumTerm));
        etCriticalIllness.addTextChangedListener(new GenericTextWatcher(etCriticalIllness));
        etAccidentalBenefits.addTextChangedListener(new GenericTextWatcher(etAccidentalBenefits));
    }

    private void init() {
        llAccidental = (LinearLayout) findViewById(R.id.llAccidental);
        llCritical = (LinearLayout) findViewById(R.id.llCritical);

        btnGetQuote = (Button) findViewById(R.id.btnGetQuote);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etMobile = (EditText) findViewById(R.id.etMobile);
        etDOB = (EditText) findViewById(R.id.etDateofBirth);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbNoSmoker = (RadioButton) findViewById(R.id.rbNoSmoker);
        spOptions = (Spinner) findViewById(R.id.spOptions);
        spPremiumTerm = (Spinner) findViewById(R.id.spPremiumTerm);
        spPremiumFrequency = (Spinner) findViewById(R.id.spPremiumFrequency);
        txtLumpSum = (TextView) findViewById(R.id.txtLumpSum);
        txtRegularIncome = (TextView) findViewById(R.id.txtRegularIncome);
        txtIncreasingIncome = (TextView) findViewById(R.id.txtIncreasingIncome);
        etSumAssured = (EditText) findViewById(R.id.etSumAssured);
        etPolicyTerm = (EditText) findViewById(R.id.etPolicyTerm);
        etPremiumTerm = (EditText) findViewById(R.id.etPremiumTerm);
        etCriticalIllness = (EditText) findViewById(R.id.etCriticalIllness);
        etAccidentalBenefits = (EditText) findViewById(R.id.etAccidentalBenefits);
        minusSum = (Button) findViewById(R.id.minusSum);
        plusSum = (Button) findViewById(R.id.plusSum);
        minusPTerm = (Button) findViewById(R.id.minusPTerm);
        plusPTerm = (Button) findViewById(R.id.plusPTerm);
        minusPreTerm = (Button) findViewById(R.id.minusPreTerm);
        plusPreTerm = (Button) findViewById(R.id.plusPreTerm);
        minusCritical = (Button) findViewById(R.id.minusCritical);
        plusCritical = (Button) findViewById(R.id.plusCritical);
        minusAcc = (Button) findViewById(R.id.minusAcc);
        plusAcc = (Button) findViewById(R.id.plusAcc);
    }

    private void setListener() {
        btnGetQuote.setOnClickListener(this);
        etDOB.setOnClickListener(datePickerDialog);
        minusSum.setOnClickListener(this);
        plusSum.setOnClickListener(this);
        minusPTerm.setOnClickListener(this);
        plusPTerm.setOnClickListener(this);
        minusPreTerm.setOnClickListener(this);
        plusPreTerm.setOnClickListener(this);
        minusCritical.setOnClickListener(this);
        plusCritical.setOnClickListener(this);
        minusAcc.setOnClickListener(this);
        plusAcc.setOnClickListener(this);

        spOptions.setOnItemSelectedListener(optionSelected);

    }

    AdapterView.OnItemSelectedListener optionSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            manipulateInputs(spOptions.getSelectedItem().toString());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private void manipulateInputs(String s) {
        switch (s.toLowerCase()) {
            case "life":
                llCritical.setVisibility(View.GONE);
                llAccidental.setVisibility(View.GONE);
                break;
            case "life plus":
                llCritical.setVisibility(View.GONE);
                llAccidental.setVisibility(View.VISIBLE);
                break;
            case "life and health":
                llCritical.setVisibility(View.VISIBLE);
                llAccidental.setVisibility(View.GONE);
                break;
            case "all in one":
                llCritical.setVisibility(View.VISIBLE);
                llAccidental.setVisibility(View.VISIBLE);
                break;


        }
    }

    class GenericTextWatcher implements TextWatcher {
        View view;

        GenericTextWatcher(View v) {
            view = v;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    protected View.OnClickListener datePickerDialog = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (view.getId() == R.id.etDateofBirth) {
                DateTimePicker.showHealthAgeDatePicker(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                        if (view1.isShown()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(year, monthOfYear, dayOfMonth);
                            String currentDay = simpleDateFormat.format(calendar.getTime());
                            etDOB.setText(currentDay);
                        }
                    }
                });
            }

        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetQuote:
                break;
            case R.id.plusSum:
                changeSumAssured(true);
                break;
            case R.id.minusSum:
                changeSumAssured(false);
                break;
            case R.id.plusPTerm:
                changePolicyTerm(true);
                break;
            case R.id.minusPTerm:
                changePolicyTerm(false);
                break;
            case R.id.plusPreTerm:
                changePremiumTerm(true);
                break;
            case R.id.minusPreTerm:
                changePremiumTerm(false);
                break;
            case R.id.plusCritical:
                break;
            case R.id.minusCritical:
                break;
            case R.id.plusAcc:
                break;
            case R.id.minusAcc:
                break;
        }

    }

    private void changePolicyTerm(boolean b) {
        int policyTerm = Integer.parseInt(etPolicyTerm.getText().toString());
        if (b) {
            policyTerm = policyTerm + 1;
        } else {
            if (policyTerm > 1)
                policyTerm = policyTerm - 1;
            else
                policyTerm = 1;
        }

        etPolicyTerm.setText("" + policyTerm);
    }

    private void changePremiumTerm(boolean b) {
        int premiumTerm = Integer.parseInt(etPremiumTerm.getText().toString());
        if (b) {
            premiumTerm = premiumTerm + 1;
        } else {
            if (premiumTerm > 1)
                premiumTerm = premiumTerm - 1;
            else
                premiumTerm = 1;
        }

        etPremiumTerm.setText("" + premiumTerm);
    }


    private void changeSumAssured(boolean b) {
        int sumAssured = Integer.parseInt(etSumAssured.getText().toString());
        if (b) {
            sumAssured = sumAssured + 500000;
        } else {
            if (sumAssured > 2500000)
                sumAssured = sumAssured - 500000;
            else
                sumAssured = 2500000;
        }

        etSumAssured.setText("" + sumAssured);
    }

    public class InputFilterMinMax implements InputFilter {

        private int min, max;

        public InputFilterMinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public InputFilterMinMax(String min, String max) {
            this.min = Integer.parseInt(min);
            this.max = Integer.parseInt(max);
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try {
                int input = Integer.parseInt(dest.toString() + source.toString());
                if (isInRange(min, max, input))
                    return null;
            } catch (NumberFormatException nfe) {
            }
            return "";
        }

        private boolean isInRange(int a, int b, int c) {
            return b > a ? c >= a && c <= b : c >= b && c <= a;
        }
    }
}
