package com.datacomp.magicfinmart.health.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.health.healthquotetabs.HealthQuoteBottomTabsActivity;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.SortbyAge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.tracking.TrackingController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MemberListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TrackingData;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TrackingRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.model.HealthSumAssured;

/**
 * Created by Nilesh Birhade on 11/02/2018.
 */

public class HealthInputFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "HealthInputFragment";
    public static final String MEMBER_LIST = "member_list";
    public static final int REQUEST_MEMBER = 4444;

    Button btnSelf, btnFamily, btnParent;
    ImageView img1, img2, img3, img4, img5, img6;
    EditText et1, et2, et3, et4, et5, et6;
    RecyclerView rvSumAssured;
    AutoCompleteTextView acCity;
    ArrayAdapter<String> cityAdapter;

    List<String> cityList;

    List<MemberListEntity> memberList;

    // 0 - self , 1 -family , 2 - parent
    int coverFor = 0;
    HealthSumAssuredViewAdapter adapter;

    EditText etAmount, etPincode, etName, etMobile;

    Button btnGetHealthQuote;

    HealthQuote healthQuote;
    HealthRequestEntity healthRequestEntity;
    DBPersistanceController db;
    List<HealthSumAssured> listSumAssured;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_health_input, container, false);
        init(view);

        // set initial values
        healthQuote = new HealthQuote();
        cityList = new ArrayList<>();
        memberList = new ArrayList<>();
        healthRequestEntity = new HealthRequestEntity();

        cityList = new DBPersistanceController(getActivity()).getHealthCity();
        cityBinding();

        db = new DBPersistanceController(getActivity());
        listSumAssured = db.getSumAssured();

        sumAssuredBinding();

        setListener();

        //default disableAll
        disableAllInputs();

        if (getArguments() != null) {
            healthQuote = getArguments().getParcelable(HealthQuoteBottomTabsActivity.INPUT_DATA);
            healthRequestEntity = healthQuote.getHealthRequest();
            processMemberForAge();
            bindInput();
        } else {
            healthQuote.setAgent_source("App");
            healthQuote.setFba_id(new DBPersistanceController(getContext()).getUserData().getFBAId());
            //default self selected
            btnSelf.performClick();
        }


        return view;
    }

    private void processMemberForAge() {
        List<MemberListEntity> listM = new ArrayList<MemberListEntity>();
        if (healthRequestEntity.getMemberList() != null) {
            for (int i = 0; i < healthRequestEntity.getMemberList().size(); i++) {
                MemberListEntity entity = healthRequestEntity.getMemberList().get(i);
                entity.setAge(getAgeFromDate(entity.getMemberDOB()));
                listM.add(entity);
            }

        }
        healthRequestEntity.setMemberList(listM);
    }

    private void sumAssuredBinding() {

        adapter = new HealthSumAssuredViewAdapter(this, listSumAssured);
        rvSumAssured.setAdapter(adapter);
    }

    private void bindInput() {

        resetonClick();
        if (healthRequestEntity.getPolicyFor() != null)
            selectCoverFor(healthRequestEntity.getPolicyFor().toLowerCase());

        etAmount.setText(healthRequestEntity.getSumInsured());
        etMobile.setText(healthRequestEntity.getContactMobile());
        etName.setText(healthRequestEntity.getContactName());
        etPincode.setText(String.valueOf(healthRequestEntity.getPincode()));

        //select existing sum assured amount in recycler view

        for (int i = 0; i < listSumAssured.size(); i++) {
            if (listSumAssured.get(i).getSumAssuredAmount() == Long.parseLong(healthRequestEntity.getSumInsured())) {
                listSumAssured.get(i).setSelected(true);
                break;
            }
        }
        adapter.refreshBinding(listSumAssured);

        acCity.setText(db.getHealthCityName(healthRequestEntity.getCityID()));
        acCity.performCompletion();

        enableMembers();
    }

    private void enableMembers() {

        for (int i = 0; i < healthRequestEntity.getMemberList().size(); i++) {
            MemberListEntity entity = healthRequestEntity.getMemberList().get(i);
            if (i == 0) {
                et1.setText(String.valueOf(entity.getAge()));
                img1.setImageResource(R.mipmap.user_selected);
                img1.performClick();
            }
            if (i == 1) {
                et2.setText(String.valueOf(entity.getAge()));
                img2.setImageResource(R.mipmap.user_selected);
                img2.performClick();
            }

            if (i == 2) {
                et3.setText(String.valueOf(entity.getAge()));
                img3.setImageResource(R.mipmap.user_selected);
                img3.performClick();
            }

            if (i == 3) {
                et4.setText(String.valueOf(entity.getAge()));
                img4.setImageResource(R.mipmap.user_selected);
                img4.performClick();
            }

            if (i == 4) {
                et5.setText(String.valueOf(entity.getAge()));
                img5.setImageResource(R.mipmap.user_selected);
                img5.performClick();
            }
            if (i == 5) {
                et6.setText(String.valueOf(entity.getAge()));
                img6.setImageResource(R.mipmap.user_selected);
                img6.performClick();
            }
        }
    }

    private void selectCoverFor(String coverfor) {
        switch (coverfor) {
            case "self":
                btnSelf.performClick();
                break;
            case "family":
                btnFamily.performClick();
                break;
            case "parent":
                btnParent.performClick();
                break;
        }
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

        //for validating auto complete city
        acCity.setOnFocusChangeListener(acCityFocusChange);

    }

    View.OnFocusChangeListener acCityFocusChange = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean b) {
            if (!b) {

                String str = acCity.getText().toString();

                ListAdapter listAdapter = acCity.getAdapter();
                for (int i = 0; i < listAdapter.getCount(); i++) {
                    String temp = listAdapter.getItem(i).toString();
                    if (str.compareTo(temp) == 0) {
                        return;
                    }
                }

                acCity.setText("");
                acCity.setError("Invalid city");
                acCity.setFocusable(true);
            } else {
                acCity.setError(null);
            }
        }
    };

    private void cityBinding() {
        cityAdapter = new
                ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, cityList);
        acCity.setAdapter(cityAdapter);
        acCity.setThreshold(1);
    }

    private void init(View view) {

        acCity = (AutoCompleteTextView) view.findViewById(R.id.acCity);

        rvSumAssured = (RecyclerView) view.findViewById(R.id.rvSumAssured);

        int numberOfColumns = 4;
        rvSumAssured.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));


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
                new TrackingController(getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Get quote health : get quote button for health"), Constants.HEALTH_INS), null);
                //region validation
                memberList.clear();

                if((!et1.isEnabled()) && (!et2.isEnabled()) && (!et3.isEnabled()) && (!et4.isEnabled()) && (!et5.isEnabled()) &&(!et6.isEnabled()) )
                {

                    showAlert("Please Select Member");
                    return;
                }

                if(validateMemberAge() == false)
                {
                    return;
                }



                if (etAmount.getText().toString().trim().length() == 0) {

                    //Toast.makeText(getActivity(), "Select cover required.", Toast.LENGTH_SHORT).show();
                    showAlert("Select cover required.");
                    return;
                }

                if (acCity.getText().toString().length() == 0) {
                    acCity.setError("Select City.");
                    acCity.setFocusable(true);
                    return;
                }


                if (etName.getText().toString().trim().length() == 0) {
                    etName.setError("Enter Name");
                    etName.requestFocus();
                    etName.setFocusable(true);
                    return;
                }
//                if (etMobile.getText().toString().length() < 10) {
//                    etMobile.setError("Invalid mobile");
//                    etMobile.setFocusable(true);
//                    return;
//                }

                if (etPincode.getText().toString().trim().length() == 0) {
                    etPincode.setError("Enter Pincode");
                    etPincode.requestFocus();
                    etPincode.setFocusable(true);
                    return;
                }
                if (etPincode.getText().toString().length() < 6) {
                    etPincode.setError("Invalid Pincode");
                    etPincode.requestFocus();
                    etPincode.setFocusable(true);
                    return;
                }

                //endregion

                healthRequestEntity.setContactName(etName.getText().toString());
                healthRequestEntity.setContactMobile(etMobile.getText().toString());
                healthRequestEntity.setSumInsured(etAmount.getText().toString());
                healthRequestEntity.setPincode(Integer.parseInt(etPincode.getText().toString()));
                healthRequestEntity.setCityID(new DBPersistanceController(getActivity()).getHealthCityID(acCity.getText().toString()));


                if (coverFor == 0) { // self

                    healthRequestEntity.setPolicyFor("Self");
                    if (et1.isEnabled() && et1.getText().toString().length() != 0) {
                        MemberListEntity entity = new MemberListEntity();
                        int Age = Integer.parseInt(et1.getText().toString());
                        entity.setAge(Age);
                        entity.setMemberDOB(getDateFromAge(Age));


                        if (Age >= 18) {
                            entity.setMemberType("Adult");
                        } else {
                            entity.setMemberType("Child");
                        }

                        memberList.add(entity);
                    }

                    healthRequestEntity.setMemberList(memberList);
                    healthQuote.setHealthRequest(healthRequestEntity);


                } else if (coverFor == 1) { //family

                    healthRequestEntity.setPolicyFor("Family");
                    healthRequestEntity.setMaritalStatusID(2);

                    if (et1.isEnabled() && et1.getText().toString().length() != 0) {
                        MemberListEntity entity = new MemberListEntity();
                        int Age = Integer.parseInt(et1.getText().toString());
                        entity.setAge(Age);
                        entity.setMemberDOB(getDateFromAge(Age));


                        if (Age >= 18) {
                            entity.setMemberType("Adult");
                        } else {
                            entity.setMemberType("Child");
                        }

                        memberList.add(entity);
                    }
                    if (et2.isEnabled() && et2.getText().toString().length() != 0) {
                        MemberListEntity entity = new MemberListEntity();
                        int Age = Integer.parseInt(et2.getText().toString());
                        entity.setAge(Age);
                        entity.setMemberDOB(getDateFromAge(Age));
                        if (Age >= 18)
                            entity.setMemberType("Adult");
                        else
                            entity.setMemberType("Child");

                        memberList.add(entity);
                    }
                    if (et3.isEnabled() && et3.getText().toString().length() != 0) {
                        MemberListEntity entity = new MemberListEntity();
                        int Age = Integer.parseInt(et3.getText().toString());
                        entity.setAge(Age);
                        entity.setMemberDOB(getDateFromAge(Age));
                        if (Age >= 18)
                            entity.setMemberType("Adult");
                        else
                            entity.setMemberType("Child");


                        memberList.add(entity);
                    }
                    if (et4.isEnabled() && et4.getText().toString().length() != 0) {
                        MemberListEntity entity = new MemberListEntity();
                        int Age = Integer.parseInt(et4.getText().toString());
                        entity.setAge(Age);
                        entity.setMemberDOB(getDateFromAge(Age));

                        if (Age >= 18)
                            entity.setMemberType("Adult");
                        else
                            entity.setMemberType("Child");

                        memberList.add(entity);
                    }
                    if (et5.isEnabled() && et5.getText().toString().length() != 0) {
                        MemberListEntity entity = new MemberListEntity();
                        int Age = Integer.parseInt(et5.getText().toString());
                        entity.setAge(Age);
                        entity.setMemberDOB(getDateFromAge(Age));

                        if (Age >= 18)
                            entity.setMemberType("Adult");
                        else
                            entity.setMemberType("Child");

                        memberList.add(entity);
                    }
                    if (et6.isEnabled() && et6.getText().toString().length() != 0) {
                        MemberListEntity entity = new MemberListEntity();
                        int Age = Integer.parseInt(et6.getText().toString());
                        entity.setAge(Age);
                        entity.setMemberDOB(getDateFromAge(Age));

                        if (Age >= 18)
                            entity.setMemberType("Adult");
                        else
                            entity.setMemberType("Child");

                        memberList.add(entity);
                    }

                    healthRequestEntity.setMemberList(memberList);
                    healthQuote.setHealthRequest(healthRequestEntity);

                } else if (coverFor == 2) {  // parent

                    healthRequestEntity.setPolicyFor("Parent");
                    if (et1.isEnabled() && et1.getText().toString().length() != 0) {
                        MemberListEntity entity = new MemberListEntity();
                        int Age = Integer.parseInt(et1.getText().toString());
                        entity.setAge(Age);
                        entity.setMemberDOB(getDateFromAge(Age));

                        if (Age >= 18)
                            entity.setMemberType("Adult");
                        else
                            entity.setMemberType("Child");

                        memberList.add(entity);
                    }
                    if (et2.isEnabled() && et2.getText().toString().length() != 0) {
                        MemberListEntity entity = new MemberListEntity();
                        int Age = Integer.parseInt(et2.getText().toString());
                        entity.setAge(Age);
                        entity.setMemberDOB(getDateFromAge(Age));

                        if (Age >= 18)
                            entity.setMemberType("Adult");
                        else
                            entity.setMemberType("Child");

                        memberList.add(entity);
                    }


                    healthRequestEntity.setMemberList(memberList);
                    healthQuote.setHealthRequest(healthRequestEntity);
                }

                if (memberList.size() > 0) {

                    //sort member list by higher age
                    Collections.sort(memberList, new SortbyAge());
                    Collections.reverse(memberList);
                    healthQuote.getHealthRequest().setMemberList(memberList);

                    //open pop up
                    btnGetHealthQuote.setEnabled(false);
                    Intent intent = new Intent(getActivity(), HealthMemberDetailsDialogActivity.class);
                    intent.putExtra(MEMBER_LIST, healthQuote);
                    startActivityForResult(intent, REQUEST_MEMBER);

                } else {
                    Toast.makeText(getActivity(), "Please enter member age", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        btnGetHealthQuote.setEnabled(true);
        if (requestCode == REQUEST_MEMBER) {
            if (data != null) {
                healthQuote = (HealthQuote) data.getParcelableExtra(HealthMemberDetailsDialogActivity.UPDATE_MEMBER_QUOTE);

                //TODO: Health Quote accepted.
                //1. pass bundle to quote fragment
                //2. trigger quote fragment
                ((HealthQuoteBottomTabsActivity) getActivity()).redirectToQuote(healthQuote);
            }
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

        img1.setImageResource(R.mipmap.user_unselected);
        img2.setImageResource(R.mipmap.user_unselected);
        img3.setImageResource(R.mipmap.user_unselected);
        img4.setImageResource(R.mipmap.user_unselected);
        img5.setImageResource(R.mipmap.user_unselected);
        img6.setImageResource(R.mipmap.user_unselected);
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
                    img1.setImageResource(R.mipmap.user_selected);
                    et1.setEnabled(true);
                    et1.setFocusableInTouchMode(true);
                } else {
                    img1.setImageResource(R.mipmap.user_unselected);
                    et1.setEnabled(false);
                    et1.setText("");
                    et1.setFocusableInTouchMode(false);
                }
                break;
            case R.id.img2:
                if (!et2.isEnabled()) {
                    img2.setImageResource(R.mipmap.user_selected);
                    et2.setEnabled(true);
                    et2.setFocusableInTouchMode(true);
                } else {
                    img2.setImageResource(R.mipmap.user_unselected);
                    et2.setEnabled(false);
                    et2.setText("");
                    et2.setFocusableInTouchMode(false);
                }
                break;
            case R.id.img3:
                if (!et3.isEnabled()) {
                    img3.setImageResource(R.mipmap.user_selected);
                    et3.setEnabled(true);
                    et3.setFocusableInTouchMode(true);
                } else {
                    img3.setImageResource(R.mipmap.user_unselected);
                    et3.setEnabled(false);
                    et3.setText("");
                    et3.setFocusableInTouchMode(false);
                }
                break;
            case R.id.img4:
                if (!et4.isEnabled()) {
                    img4.setImageResource(R.mipmap.user_selected);
                    et4.setEnabled(true);
                    et4.setFocusableInTouchMode(true);
                } else {
                    img4.setImageResource(R.mipmap.user_unselected);
                    et4.setEnabled(false);
                    et4.setText("");
                    et4.setFocusableInTouchMode(false);
                }
                break;
            case R.id.img5:
                if (!et5.isEnabled()) {
                    img5.setImageResource(R.mipmap.user_selected);
                    et5.setEnabled(true);
                    et5.setFocusableInTouchMode(true);
                } else {
                    img5.setImageResource(R.mipmap.user_unselected);
                    et5.setEnabled(false);
                    et5.setText("");
                    et5.setFocusableInTouchMode(false);
                }
                break;
            case R.id.img6:
                if (!et6.isEnabled()) {
                    img6.setImageResource(R.mipmap.user_selected);
                    et6.setEnabled(true);
                    et6.setFocusableInTouchMode(true);
                } else {
                    img6.setImageResource(R.mipmap.user_unselected);
                    et6.setEnabled(false);
                    et6.setText("");
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

    private boolean validateMemberAge()
    {
//        if((et1.isEnabled() && et1.getText().toString().length() ==0)  || (et2.isEnabled() && et2.getText().toString().length() ==0) || (et3.isEnabled() && et3.getText().toString().length() ==0) ||
//                (et4.isEnabled() && et4.getText().toString().length() ==0)  || (et5.isEnabled() && et5.getText().toString().length() ==0) || (et6.isEnabled() && et6.getText().toString().length() ==0)   )
//        {
//            showAlert("Please Select Age");
//            return;
//        }

        if((et1.isEnabled() && et1.getText().toString().length() ==0))
        {
            showAlert("Please Select Age");
            et1.requestFocus();
            return false;
        }
        else if(et2.isEnabled() && et2.getText().toString().length() ==0)
        {
            showAlert("Please Select Age");
            et2.requestFocus();
            return false;
        }
        else if(et3.isEnabled() && et3.getText().toString().length() ==0)
        {
            showAlert("Please Select Age");
            et3.requestFocus();
            return false;
        }
        else if(et4.isEnabled() && et4.getText().toString().length() ==0)
        {
            showAlert("Please Select Age");
            et4.requestFocus();
            return false;
        }
        else if(et5.isEnabled() && et5.getText().toString().length() ==0)
        {
            showAlert("Please Select Age");
            et5.requestFocus();
            return false;
        }
        else if(et6.isEnabled() && et6.getText().toString().length() ==0)
        {
            showAlert("Please Select Age");
            et6.requestFocus();
            return false;
        }


        return  true;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.home_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                getActivity().finish();
                return true;


            case R.id.action_home:

                Intent intent = new Intent(getActivity(), HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                getActivity().finish();
                return true;


        }
        return super.onOptionsItemSelected(item);

    }

}
