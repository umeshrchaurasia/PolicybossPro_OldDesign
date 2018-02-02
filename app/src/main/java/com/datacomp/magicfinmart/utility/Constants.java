package com.datacomp.magicfinmart.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.datacomp.magicfinmart.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Rajeev Ranjan on 10/01/2018.
 */

public class Constants {
    public static final Double GST = 0.18;
    public static final String SHARED_PREFERENCE_FINMART = "shared_finmart";
    public static final String EXTERNAL_LPG = "External Fitted LPG";
    public static final String EXTERNAL_CNG = "External Fitted CNG";
    public static String PERSONAL_LOAN_QUOTES = "personalloanquotes";
    public static String BL_LOAN_QUOTES = "balanceTransferloanquotes";
    public static String BL_LOAN_SERVICE = "balanceTransferloanservice";
    public static String BL_REQUEST = "balanceTransferRequest";
    public static String HOME_LOAN_QUOTES = "homeloanquotes";
    public static String HL_REQUEST = "homeloanRequest";
    public static String PL_REQUEST = "personalloanRequest";
    public static String LAP_REQUEST = "loanagainstpropertyRequest";
    public static String CITY_FACADE = "citylist";
    public static String HOMELOAN_REQUEST_FACADE = "homeloanrequest";
    public static String PRODUCT_FACADE = "productlist";
    public static String PROPERTY_FACADE = "propertylist";
    public static String LOGIN_FACADE = "logindata";
    public static String PROFILE_URL = "profileurl";
    public static String QUOTES = "quotes";
    public static String DEVICE_ID = "deviceid";
    public static String DEVICE_TOKEN = "devicetoken";
    public static String PAN_NUMBER = "pannumber";
    public static String PASSWORD = "password";
    public static String WEB_URL = "WEBURL";

    public static void hideKeyBoard(View view, Context context) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(Constants.SHARED_PREFERENCE_FINMART, MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getSharedPreferenceEditor(Context context) {
        return getSharedPreference(context).edit();
    }

    public static List<String> getPastFifteenYear(String selectedDate) {

        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        ArrayList<String> arrayListYear = new ArrayList<>();
        int year, startYear, endYear;

        Calendar calendar = Calendar.getInstance();
        if (selectedDate != "") {
            try {
                calendar.setTime(df.parse(selectedDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        year = calendar.get(Calendar.YEAR);
        startYear = year;
        endYear = startYear - 15;
        arrayListYear.add("Select Manufacture year");
        for (int i = startYear; i >= endYear; i--) {
            arrayListYear.add("" + i);
        }

        return arrayListYear;
    }

    public static SpannableStringBuilder setStarToLabel(String text) {
        String simple = text;
        String colored = "*";
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(simple);
        int start = builder.length();
        builder.append(colored);
        int end = builder.length();
        builder.setSpan(new ForegroundColorSpan(Color.RED), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return builder;
    }
}
