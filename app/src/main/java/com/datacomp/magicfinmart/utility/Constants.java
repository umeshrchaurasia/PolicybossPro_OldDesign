package com.datacomp.magicfinmart.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Rajeev Ranjan on 10/01/2018.
 */

public class Constants {
    public static final Double GST = 0.18;
    public static final String SHARED_PREFERENCE_FINMART = "shared_finmart";
    public static final String EXTERNAL_LPG = "External Fitted LPG";
    public static final String EXTERNAL_CNG = "External Fitted CNG";

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
}
