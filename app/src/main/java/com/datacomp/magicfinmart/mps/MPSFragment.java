package com.datacomp.magicfinmart.mps;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MpsDataEntity;

public class MPSFragment extends BaseFragment {
    Button btnPayNow;
    CheckBox chkAgree;
    TextView txtTermsCondition, txtSubscriptionAmount, txtGSTAmount, txtTotalAmount;

    public MPSFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mps, container, false);
        init(view);
        setListener();
        bindData();
        btnPayNow.setEnabled(false);
        return view;
    }

    private void bindData() {
        MpsDataEntity mpsDataEntity = new PrefManager(getActivity()).getMps();
        btnPayNow.setText("PAY ₹ " + mpsDataEntity.getTotalAmt());
        txtSubscriptionAmount.setText("₹ " + mpsDataEntity.getMRP());
        txtGSTAmount.setText("₹ " + mpsDataEntity.getServTaxAmt());
        txtTotalAmount.setText("₹ " + mpsDataEntity.getTotalAmt());

    }

    private void setListener() {
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnPayNow.setEnabled(true);
                    btnPayNow.setTextColor(Color.WHITE);
                    btnPayNow.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                } else {
                    btnPayNow.setEnabled(false);
                    btnPayNow.setTextColor(Color.BLACK);
                    btnPayNow.setBackgroundColor(getResources().getColor(R.color.bg));
                }
            }
        });

        btnPayNow.setOnClickListener(payNow);
        txtTermsCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTermsCondition();
            }
        });
    }

    private void showTermsCondition() {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setCancelable(true);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.layout_mps_terms_condition, null);
        WebView wv = (WebView) dialogView.findViewById(R.id.wvTerms);

        wv.loadUrl("file:///android_asset/MpsTerm.html");
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
        });
        alert.setView(dialogView);
        alert.show().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, 1000);

    }

    View.OnClickListener payNow = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getActivity(), CommonWebViewActivity.class)
                    .putExtra("URL", new PrefManager(getActivity()).getMps().getPaymentURL())
                    .putExtra("NAME", "MAGIC PLATINUM SUBS.")
                    .putExtra("TITLE", "MAGIC PLATINUM SUBS."));
        }
    };

    private void init(View view) {
        txtTermsCondition = (TextView) view.findViewById(R.id.txtTermsCondition);
        txtSubscriptionAmount = (TextView) view.findViewById(R.id.txtSubscriptionAmount);
        txtGSTAmount = (TextView) view.findViewById(R.id.txtGSTAmount);
        txtTotalAmount = (TextView) view.findViewById(R.id.txtTotalAmount);
        chkAgree = (CheckBox) view.findViewById(R.id.chkAgree);
        btnPayNow = (Button) view.findViewById(R.id.btnPayNow);

    }

}
