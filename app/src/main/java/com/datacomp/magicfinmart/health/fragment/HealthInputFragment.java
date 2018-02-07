package com.datacomp.magicfinmart.health.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;

/**
 * Created by Rajeev Ranjan on 29/01/2018.
 */

public class HealthInputFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "HealthInputFragment";
    Button btnSelf, btnFamily, btnParent;
    ImageView img1, img2, img3, img4, img5, img6;
    EditText et1, et2, et3, et4, et5, et6;
    ArrayAdapter<String> listsumAssured;
    Spinner spSumAssured;
    RecyclerView rvSumAssured;

    // 0 - self , 1 -family , 2 - parent
    int coverFor = 0;
    HealthSumAssuredViewAdapter adapter;

    EditText etAmount, etPincode, etName, etMobile;

    Button btnGetHealthQuote;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_health_input, container, false);

        init(view);

        setListener();

        // spinner binding
        spinnerBinding();

        //default disableAll
        disableAllInputs();

        return view;
    }

    private void spinnerBinding() {
        listsumAssured = new
                ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.health_sum_assured)) {
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
        spSumAssured.setAdapter(listsumAssured);
    }

    //region initialise all

    private void disableAllInputs() {
        img1.setEnabled(false);
        img2.setEnabled(false);
        img3.setEnabled(false);
        img4.setEnabled(false);
        img5.setEnabled(false);
        img6.setEnabled(false);

        et1.setEnabled(false);
        et2.setEnabled(false);
        et3.setEnabled(false);
        et4.setEnabled(false);
        et5.setEnabled(false);
        et6.setEnabled(false);
    }

    private void setListener() {
        btnSelf.setOnClickListener(this);
        btnFamily.setOnClickListener(this);
        btnParent.setOnClickListener(this);
        btnGetHealthQuote.setOnClickListener(this);
    }

    private void init(View view) {
        spSumAssured = (Spinner) view.findViewById(R.id.spSumAssured);
        rvSumAssured = (RecyclerView) view.findViewById(R.id.rvSumAssured);

        int numberOfColumns = 4;
        rvSumAssured.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        adapter = new HealthSumAssuredViewAdapter(this);
        rvSumAssured.setAdapter(adapter);

        btnSelf = (Button) view.findViewById(R.id.btnSelf);
        btnFamily = (Button) view.findViewById(R.id.btnFamily);
        btnParent = (Button) view.findViewById(R.id.btnParent);

        img1 = (ImageView) view.findViewById(R.id.img1);
        img2 = (ImageView) view.findViewById(R.id.img2);
        img3 = (ImageView) view.findViewById(R.id.img3);
        img4 = (ImageView) view.findViewById(R.id.img4);
        img5 = (ImageView) view.findViewById(R.id.img5);
        img6 = (ImageView) view.findViewById(R.id.img6);

        et1 = (EditText) view.findViewById(R.id.etOne);
        et2 = (EditText) view.findViewById(R.id.etTwo);
        et3 = (EditText) view.findViewById(R.id.etThree);
        et4 = (EditText) view.findViewById(R.id.etFour);
        et5 = (EditText) view.findViewById(R.id.etFive);
        et6 = (EditText) view.findViewById(R.id.etSix);

        etAmount = (EditText) view.findViewById(R.id.etAmount);
        etPincode = (EditText) view.findViewById(R.id.etPincode);
        etName = (EditText) view.findViewById(R.id.etName);
        etMobile = (EditText) view.findViewById(R.id.etMobile);
        btnGetHealthQuote = (Button) view.findViewById(R.id.btnGetHealthQuote);
    }

    //endregion

    public void getSumAssured(long amount) {
        etAmount.setText(String.valueOf(amount));
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnSelf:
                coverFor = 0;
                resetonClick();
                enableInputsForSelf();
                break;
            case R.id.btnFamily:
                coverFor = 1;
                resetonClick();
                enableInputForFamily();
                break;
            case R.id.btnParent:
                coverFor = 2;
                resetonClick();
                enableInputForParent();
                break;

            case R.id.img1:
                enableOne(view);
                break;
            case R.id.img2:
                enableOne(view);
                break;
            case R.id.img3:
                enableOne(view);
                break;
            case R.id.img4:
                enableOne(view);
                break;
            case R.id.img5:
                enableOne(view);
                break;
            case R.id.img6:
                enableOne(view);
                break;

            case R.id.btnGetHealthQuote:
                break;
        }
    }

    private void enableInputForParent() {

        btnSelf.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        btnFamily.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        btnParent.setBackgroundColor(getResources().getColor(R.color.tab_color));

        img1.setEnabled(true);
        img2.setEnabled(true);
        img3.setEnabled(false);
        img4.setEnabled(false);
        img5.setEnabled(false);
        img6.setEnabled(false);

        et1.setFocusable(false);
        et2.setFocusable(false);
        et3.setFocusable(false);
        et4.setFocusable(false);
        et5.setFocusable(false);
        et6.setFocusable(false);

        img1.setFocusable(true);
        img2.setFocusable(true);
        img3.setFocusable(false);
        img4.setFocusable(false);
        img5.setFocusable(false);
        img6.setFocusable(false);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(null);
        img4.setOnClickListener(null);
        img5.setOnClickListener(null);
        img6.setOnClickListener(null);

    }

    private void enableInputForFamily() {

        btnSelf.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        btnFamily.setBackgroundColor(getResources().getColor(R.color.tab_color));
        btnParent.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        img1.setEnabled(true);
        img2.setEnabled(true);
        img3.setEnabled(true);
        img4.setEnabled(true);
        img5.setEnabled(true);
        img6.setEnabled(true);

        et1.setFocusable(false);
        et2.setFocusable(false);
        et3.setFocusable(false);
        et4.setFocusable(false);
        et5.setFocusable(false);
        et6.setFocusable(false);

        img1.setFocusable(true);
        img2.setFocusable(true);
        img3.setFocusable(true);
        img4.setFocusable(true);
        img5.setFocusable(true);
        img6.setFocusable(true);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);

    }

    private void enableInputsForSelf() {

        btnSelf.setBackgroundColor(getResources().getColor(R.color.tab_color));
        btnFamily.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        btnParent.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        img1.setEnabled(true);
        et1.setFocusable(false);
        img1.setFocusable(true);

        img1.setOnClickListener(this);
        img2.setOnClickListener(null);
        img3.setOnClickListener(null);
        img4.setOnClickListener(null);
        img5.setOnClickListener(null);
        img6.setOnClickListener(null);
    }

    private void resetonClick() {

        img1.setImageResource(R.drawable.vector_person_health_unselect);
        img2.setImageResource(R.drawable.vector_person_health_unselect);
        img3.setImageResource(R.drawable.vector_person_health_unselect);
        img4.setImageResource(R.drawable.vector_person_health_unselect);
        img5.setImageResource(R.drawable.vector_person_health_unselect);
        img6.setImageResource(R.drawable.vector_person_health_unselect);
        et1.setEnabled(false);
        et1.setText("");
        et2.setEnabled(false);
        et2.setText("");
        et3.setEnabled(false);
        et3.setText("");
        et4.setEnabled(false);
        et4.setText("");
        et5.setEnabled(false);
        et5.setText("");
        et6.setEnabled(false);
        et6.setText("");
        et1.setFocusableInTouchMode(false);
        et2.setFocusableInTouchMode(false);
        et3.setFocusableInTouchMode(false);
        et4.setFocusableInTouchMode(false);
        et5.setFocusableInTouchMode(false);
        et6.setFocusableInTouchMode(false);

    }

    private void enableOne(View view) {

        switch (view.getId()) {
            case R.id.img1:
                if (!et1.isEnabled()) {
                    img1.setImageResource(R.drawable.vector_person_health_select);
                    et1.setEnabled(true);
                    et1.setFocusableInTouchMode(true);
                } else {
                    img1.setImageResource(R.drawable.vector_person_health_unselect);
                    et1.setEnabled(false);
                    et1.setFocusableInTouchMode(false);
                }
                break;
            case R.id.img2:
                if (!et2.isEnabled()) {
                    img2.setImageResource(R.drawable.vector_person_health_select);
                    et2.setEnabled(true);
                    et2.setFocusableInTouchMode(true);
                } else {
                    img2.setImageResource(R.drawable.vector_person_health_unselect);
                    et2.setEnabled(false);
                    et2.setFocusableInTouchMode(false);
                }
                break;
            case R.id.img3:
                if (!et3.isEnabled()) {
                    img3.setImageResource(R.drawable.vector_person_health_select);
                    et3.setEnabled(true);
                    et3.setFocusableInTouchMode(true);
                } else {
                    img3.setImageResource(R.drawable.vector_person_health_unselect);
                    et3.setEnabled(false);
                    et3.setFocusableInTouchMode(false);
                }
                break;
            case R.id.img4:
                if (!et4.isEnabled()) {
                    img4.setImageResource(R.drawable.vector_person_health_select);
                    et4.setEnabled(true);
                    et4.setFocusableInTouchMode(true);
                } else {
                    img4.setImageResource(R.drawable.vector_person_health_unselect);
                    et4.setEnabled(false);
                    et4.setFocusableInTouchMode(false);
                }
                break;
            case R.id.img5:
                if (!et5.isEnabled()) {
                    img5.setImageResource(R.drawable.vector_person_health_select);
                    et5.setEnabled(true);
                    et5.setFocusableInTouchMode(true);
                } else {
                    img5.setImageResource(R.drawable.vector_person_health_unselect);
                    et5.setEnabled(false);
                    et5.setFocusableInTouchMode(false);
                }
                break;
            case R.id.img6:
                if (!et6.isEnabled()) {
                    img6.setImageResource(R.drawable.vector_person_health_select);
                    et6.setEnabled(true);
                    et6.setFocusableInTouchMode(true);
                } else {
                    img6.setImageResource(R.drawable.vector_person_health_unselect);
                    et6.setEnabled(false);
                    et6.setFocusableInTouchMode(false);
                }
                break;
        }
    }

    //region image click

    private void enableInputs() {

        switch (coverFor) {
            case 0: //self

                break;
            case 1: //family
                break;
            case 2: //parent
                break;
            default:
                break;
        }
    }

    //endregion

}
