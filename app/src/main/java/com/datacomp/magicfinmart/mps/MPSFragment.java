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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MpsDataEntity;

public class MPSFragment extends BaseFragment implements IResponseSubcriber {
    Button btnPayNow, btnApplyPromo;
    CheckBox chkAgree;
    TextView txtTermsCondition, txtSubscriptionAmount, txtGSTAmount, txtTotalAmount, txtPromoCode;
    LinearLayout llPromo;

    public MPSFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mps, container, false);
        init(view);
        setListener();
        MpsDataEntity mpsDataEntity = new PrefManager(getActivity()).getMps();
        bindData(mpsDataEntity);
        btnPayNow.setEnabled(false);
        txtPromoCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llPromo.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    private void bindData(MpsDataEntity mpsDataEntity) {

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
        btnApplyPromo.setOnClickListener(applyNow);
        txtTermsCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTermsCondition();
            }
        });
    }

    View.OnClickListener applyNow = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

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
        llPromo = (LinearLayout) view.findViewById(R.id.llPromo);
        txtPromoCode = (TextView) view.findViewById(R.id.txtPromoCode);
        txtTermsCondition = (TextView) view.findViewById(R.id.txtTermsCondition);
        txtSubscriptionAmount = (TextView) view.findViewById(R.id.txtSubscriptionAmount);
        txtGSTAmount = (TextView) view.findViewById(R.id.txtGSTAmount);
        txtTotalAmount = (TextView) view.findViewById(R.id.txtTotalAmount);
        chkAgree = (CheckBox) view.findViewById(R.id.chkAgree);
        btnPayNow = (Button) view.findViewById(R.id.btnPayNow);
        btnApplyPromo = (Button) view.findViewById(R.id.btnApplyPromo);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

        bindData(null);
    }

    @Override
    public void OnFailure(Throwable t) {

    }
}
