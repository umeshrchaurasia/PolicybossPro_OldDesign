package com.datacomp.magicfinmart.mps;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

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
        return view;
    }

    private void setListener() {
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnPayNow.setTextColor(Color.WHITE);
                    btnPayNow.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                } else {
                    btnPayNow.setTextColor(Color.BLACK);
                    btnPayNow.setBackgroundColor(getResources().getColor(R.color.bg));
                }
            }
        });
    }

    private void init(View view) {
        txtTermsCondition = (TextView) view.findViewById(R.id.txtTermsCondition);
        txtSubscriptionAmount = (TextView) view.findViewById(R.id.txtSubscriptionAmount);
        txtGSTAmount = (TextView) view.findViewById(R.id.txtGSTAmount);
        txtTotalAmount = (TextView) view.findViewById(R.id.txtTotalAmount);
        chkAgree = (CheckBox) view.findViewById(R.id.chkAgree);
        btnPayNow = (Button) view.findViewById(R.id.btnPayNow);

    }

}
