package com.datacomp.magicfinmart.health.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

/**
 * Created by Rajeev Ranjan on 29/01/2018.
 */

public class HealthInputFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "HealthInputFragment";
    Button btnSelf, btnFamily, btnParent;
    ImageView img1, img2, img3, img4, img5, img6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_health_input, container, false);
        init(view);
        setListener();
        return view;
    }

    private void setListener() {
        btnSelf.setOnClickListener(this);
        btnFamily.setOnClickListener(this);
        btnParent.setOnClickListener(this);
    }

    private void init(View view) {
        btnSelf = (Button) view.findViewById(R.id.btnSelf);
        btnFamily = (Button) view.findViewById(R.id.btnFamily);
        btnParent = (Button) view.findViewById(R.id.btnParent);
        img1 = (ImageView) view.findViewById(R.id.img1);
        img2 = (ImageView) view.findViewById(R.id.img2);
        img3 = (ImageView) view.findViewById(R.id.img3);
        img4 = (ImageView) view.findViewById(R.id.img4);
        img5 = (ImageView) view.findViewById(R.id.img5);
        img6 = (ImageView) view.findViewById(R.id.img6);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnSelf:
                changeButtonBackground(view);
                EnableInputView(view);
                break;
            case R.id.btnFamily:
                changeButtonBackground(view);
                EnableInputView(view);
                break;
            case R.id.btnParent:
                changeButtonBackground(view);
                EnableInputView(view);
                break;
        }
    }

    private void EnableInputView(View view) {
        switch (view.getId()) {
            case R.id.btnSelf:
                img1.setImageResource(R.drawable.vector_person_health_select);
                img2.setImageResource(R.drawable.vector_person_health_unselect);
                img3.setImageResource(R.drawable.vector_person_health_unselect);
                img4.setImageResource(R.drawable.vector_person_health_unselect);
                img5.setImageResource(R.drawable.vector_person_health_unselect);
                img6.setImageResource(R.drawable.vector_person_health_unselect);
                img1.setEnabled(true);
                img2.setEnabled(false);
                img3.setEnabled(false);
                img4.setEnabled(false);
                img5.setEnabled(false);
                img6.setEnabled(false);
                break;
            case R.id.btnFamily:
                img1.setImageResource(R.drawable.vector_person_health_select);
                img2.setImageResource(R.drawable.vector_person_health_select);
                img3.setImageResource(R.drawable.vector_person_health_select);
                img4.setImageResource(R.drawable.vector_person_health_select);
                img5.setImageResource(R.drawable.vector_person_health_select);
                img6.setImageResource(R.drawable.vector_person_health_select);
                img1.setEnabled(true);
                img2.setEnabled(true);
                img3.setEnabled(true);
                img4.setEnabled(true);
                img5.setEnabled(true);
                img6.setEnabled(true);
                break;
            case R.id.btnParent:
                img1.setImageResource(R.drawable.vector_person_health_select);
                img2.setImageResource(R.drawable.vector_person_health_select);
                img3.setImageResource(R.drawable.vector_person_health_unselect);
                img4.setImageResource(R.drawable.vector_person_health_unselect);
                img5.setImageResource(R.drawable.vector_person_health_unselect);
                img6.setImageResource(R.drawable.vector_person_health_unselect);
                img1.setEnabled(true);
                img2.setEnabled(true);
                img3.setEnabled(false);
                img4.setEnabled(false);
                img5.setEnabled(false);
                img6.setEnabled(false);
                break;
        }
    }

    private void changeButtonBackground(View button) {

        switch (button.getId()) {
            case R.id.btnSelf:
                btnSelf.setBackgroundColor(btnSelf.getContext().getResources().getColor(R.color.tab_color));
                btnFamily.setBackgroundColor(btnSelf.getContext().getResources().getColor(R.color.colorPrimary));
                btnParent.setBackgroundColor(btnSelf.getContext().getResources().getColor(R.color.colorPrimary));
                break;
            case R.id.btnFamily:
                btnSelf.setBackgroundColor(btnSelf.getContext().getResources().getColor(R.color.colorPrimary));
                btnFamily.setBackgroundColor(btnSelf.getContext().getResources().getColor(R.color.tab_color));
                btnParent.setBackgroundColor(btnSelf.getContext().getResources().getColor(R.color.colorPrimary));
                break;
            case R.id.btnParent:
                btnSelf.setBackgroundColor(btnSelf.getContext().getResources().getColor(R.color.colorPrimary));
                btnFamily.setBackgroundColor(btnSelf.getContext().getResources().getColor(R.color.colorPrimary));
                btnParent.setBackgroundColor(btnSelf.getContext().getResources().getColor(R.color.tab_color));
                break;
        }
    }
}
