package com.datacomp.magicfinmart.loan_fm.personalloan.addquote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.personalloan.loan_apply.PersonalLoanApplyActivity;
import com.datacomp.magicfinmart.utility.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.PersonalQuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetPersonalLoanResponse;

/**
 * Created by Rahul on 24/01/2018.
 */

public class QuoteFragment extends BaseFragment {

    TextView txtAppName , txtLoanAmnt ,txtLoanTenure, txtOccupation, txtMonthlyIncome,txtExistEmi ,txtCount;

    GetPersonalLoanResponse getPersonalLoanResponse;
    PersonalLoanRequest personalLoanRequest;
    RecyclerView rvPLQuotes;

    PLQuoteAdapter mAdapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_personal_loan_quote, container, false);
        initialize(view);
        return view;
    }

    private void initialize(View view) {

        txtAppName = (TextView) view.findViewById(R.id.txtAppName);
        txtLoanAmnt = (TextView) view.findViewById(R.id.txtLoanAmnt);
        txtLoanTenure = (TextView) view.findViewById(R.id.txtLoanTenure);
        txtOccupation = (TextView) view.findViewById(R.id.txtOccupation);
        txtMonthlyIncome = (TextView) view.findViewById(R.id.txtMonthlyIncome);
        txtExistEmi = (TextView) view.findViewById(R.id.txtExistEmi);
        txtCount = (TextView) view.findViewById(R.id.txtCount);

        rvPLQuotes = (RecyclerView) view.findViewById(R.id.rvPLQuotes);
        rvPLQuotes.setLayoutManager(new LinearLayoutManager(getActivity()));

// bundle.putParcelable(Constants.PL_REQUEST, personalLoanRequest);
        Bundle bundle = getArguments();

        if (bundle != null) {
            getPersonalLoanResponse = bundle.getParcelable(Constants.PERSONAL_LOAN_QUOTES);
            personalLoanRequest =  bundle.getParcelable(Constants.PL_REQUEST);
            if (getPersonalLoanResponse != null) {

                mAdapter = new PLQuoteAdapter(getActivity(), getPersonalLoanResponse.getData());
                rvPLQuotes.setAdapter(mAdapter);

                if(getPersonalLoanResponse.getData().size() >0)
                {
                   txtCount.setText(""+getPersonalLoanResponse.getData().size() + " Results from www.rupeeboss.com" );
                    txtCount.setVisibility(View.VISIBLE);
                }else{
                    txtCount.setText("");
                    txtCount.setVisibility(View.GONE);
                }

                if(personalLoanRequest != null)
                {
                    txtAppName.setText(""+personalLoanRequest.getApplicantNme() );
                    txtLoanAmnt.setText(""+personalLoanRequest.getLoanRequired() );
                    txtLoanTenure.setText(""+personalLoanRequest.getLoanTenure() );

                    if(personalLoanRequest.getApplicantSource().equals("1"))
                    {
                        txtOccupation.setText("SALARIED" );
                    }else{
                        txtOccupation.setText("SELF-EMP" );
                    }


                    txtMonthlyIncome.setText(""+personalLoanRequest.getApplicantIncome() );
                    txtExistEmi.setText(""+personalLoanRequest.getApplicantObligations() );
                }
            }
        }
    }

    public void redirectToApplyLoan(PersonalQuoteEntity entity) {
//

        startActivity(new Intent(getActivity(), PersonalLoanApplyActivity.class)
                .putExtra("PL", entity)
                .putExtra("PL_URL", getPersonalLoanResponse.getUrl())
                .putExtra("PL_QUOTE_ID", getPersonalLoanResponse.getQuote_id()));
    }


    private void shareData() {
        View rootView = getActivity().getWindow().getDecorView().findViewById(R.id.rvPLQuotes);

        datashareList(getScreenShot(rootView), "Quotes Details", "");

    }


    public Bitmap getScreenShot(View view) {
        View screenView = view.getRootView();
        screenView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(screenView.getDrawingCache());
        screenView.setDrawingCacheEnabled(false);
        return bitmap;
    }


    private void datashareList(Bitmap bitmap, String strSubject, String strDetail) {

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

            PackageManager pm = getActivity().getPackageManager();


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

            startActivity(openInChooser);
        } catch (Exception e) {

            // Toast.makeText(getActivity(), "Please check your permissions settings.Permission issue.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    shareData();
                } else {
                    //code for deny
                }
                break;
        }
    }


}
