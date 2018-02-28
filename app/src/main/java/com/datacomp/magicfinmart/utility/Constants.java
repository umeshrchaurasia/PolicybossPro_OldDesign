package com.datacomp.magicfinmart.utility;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;

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
    public static String PUSH_NOTIFY = "pushNotify";
    public static int REQUEST_CODE = 22;
    public static String PRODUCT_ID = "salesProductID";
    public static String DOC_DATA = "docData";

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

    private void datashareList(Context context, Bitmap bitmap, String strSubject, String strDetail) {

        String prdSubject = strSubject;
        String prdDetail = strDetail;
        try {

            //  File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Screenshots" + System.currentTimeMillis() + ".png");

            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Screenshots", Utility.getCurrentMobileDateTime() + ".png");
            // Utility.getCurrentMobileDateTime()
            file.getParentFile().mkdirs();
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.close();

            Uri screenshotUri = Uri.fromFile(file);

            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, prdDetail);

            shareIntent.setType("text/plain");

            PackageManager pm = context.getPackageManager();


            List<ResolveInfo> resInfo = pm.queryIntentActivities(shareIntent, 0);
            List<LabeledIntent> intentList = new ArrayList<LabeledIntent>();
            ///////////
            for (int i = 0; i < resInfo.size(); i++) {
                // Extract the label, append it, and repackage it in a LabeledIntent
                ResolveInfo ri = resInfo.get(i);
                String packageName = ri.activityInfo.packageName;
                String processName = ri.activityInfo.processName;
                String AppName = ri.activityInfo.name;

                if ((packageName.contains("android.email") || packageName.contains("twitter") || (packageName.contains("whatsapp")) || packageName.contains("android.gm") || packageName.contains("com.google.android.apps.plus")) || (packageName.contains("apps.docs")) && processName.contains("android.apps.docs:Clipboard") || (packageName.contains("android.talk")) && AppName.contains("hangouts")) {

                    shareIntent.setComponent(new ComponentName(packageName, ri.activityInfo.name));

                    if (packageName.contains("android.email")) {
                        shareIntent.setType("image/*");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, prdSubject);
                        shareIntent.putExtra(Intent.EXTRA_TEXT, prdDetail);
                        shareIntent.setPackage(packageName);

                    } else if (packageName.contains("twitter")) {

                        shareIntent.setType("image/*");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, prdSubject);
                        shareIntent.putExtra(Intent.EXTRA_TEXT, prdDetail);
                        shareIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                        shareIntent.setPackage(packageName);

                    }
//                    else if (packageName.contains("facebook.katana")) {
//                        shareIntent.setType("text/plain");
//                        shareIntent.putExtra(Intent.EXTRA_TEXT, product.getImageUrl());
//                        shareIntent.setPackage("com.facebook.katana");
//                        //shareIntent.putExtra(Intent.EXTRA_STREAM, Deeplink);
//                    }
//                    else if (packageName.contains("facebook.orca")) {
//                        shareIntent.setType("image/*");
//                        shareIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
//                        shareIntent.putExtra(Intent.EXTRA_TEXT, prdDetail);
//                        shareIntent.setPackage("com.facebook.orca");
//
//                    }

                    else if (packageName.contains("whatsapp")) {
                        shareIntent.setType("image/*");

                        shareIntent.putExtra(Intent.EXTRA_TEXT, prdDetail);
                        shareIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                        shareIntent.setPackage(packageName);


                    } else if (packageName.contains("com.google.android.apps.plus")) {
                        shareIntent.setType("image/*");
                        shareIntent.putExtra(Intent.EXTRA_TEXT, prdDetail);
                        shareIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                        shareIntent.setPackage(packageName);

                    } else if (packageName.contains("android.talk")) {
                        if (AppName.contains("hangouts")) {
                            shareIntent.setType("image/*");
                            shareIntent.putExtra(Intent.EXTRA_TEXT, prdDetail);
                            shareIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                            shareIntent.setPackage(packageName);
                        }

                    } else if (packageName.contains("apps.docs")) {
                        if (processName.contains("android.apps.docs:Clipboard")) {
                            shareIntent.setType("text/plain");
                            shareIntent.putExtra(Intent.EXTRA_TEXT, prdDetail);
                            shareIntent.setPackage(packageName);
                        }

                    } else if (packageName.contains("android.gm")) {
                        shareIntent.setType("image/*");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, prdSubject);
                        shareIntent.putExtra(Intent.EXTRA_TEXT, prdDetail);
                        shareIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                        shareIntent.setPackage(packageName);

                    } else {
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_TEXT, prdDetail);

                    }

                    intentList.add(new LabeledIntent(shareIntent, packageName, ri.loadLabel(pm), ri.icon));

                }
            }


            if (intentList.size() > 1) {
                intentList.remove(intentList.size() - 1);
            }

            Intent openInChooser = Intent.createChooser(shareIntent, "Share Via");

            // convert intentList to array
            LabeledIntent[] extraIntents = intentList.toArray(new LabeledIntent[intentList.size()]);
            openInChooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, extraIntents);

            context.startActivity(openInChooser);
        } catch (Exception e) {

            // Toast.makeText(getActivity(), "Please check your permissions settings.Permission issue.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    public static  void shareToWhatsApp(Context context, String strDetail) {
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, strDetail);
        try {
            context.startActivity(whatsappIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "Whatsapp Not Installed", Toast.LENGTH_SHORT).show();
        }
    }
}
