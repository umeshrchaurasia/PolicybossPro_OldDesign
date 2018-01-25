package com.datacomp.magicfinmart.motor.privatecar.quote;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.adapters.MotorQuoteAdapter;
import com.datacomp.magicfinmart.motor.privatecar.ActivityTabsPagerAdapter;
import com.datacomp.magicfinmart.motor.privatecar.addquote.AddQuoteActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MotorQuoteFragment extends BaseFragment implements View.OnClickListener {

    FloatingActionButton btnAddQuote;
    RecyclerView rvQuoteList;
    MotorQuoteAdapter motorQuoteAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    List<QuoteListEntity> mQuoteList;

    public MotorQuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_motor_quote, container, false);
        initView(view);
        mQuoteList = new ArrayList<>();
        mQuoteList = getArguments().getParcelableArrayList(ActivityTabsPagerAdapter.QUOTE_LIST);
        motorQuoteAdapter = new MotorQuoteAdapter(getActivity(), mQuoteList);
        rvQuoteList.setAdapter(motorQuoteAdapter);
        return view;
    }

    private void initView(View view) {
        btnAddQuote = (FloatingActionButton) view.findViewById(R.id.fbAddQuote);
        rvQuoteList = (RecyclerView) view.findViewById(R.id.rvQuoteList);
        rvQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvQuoteList.setLayoutManager(layoutManager);
        btnAddQuote.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fbAddQuote:
                startActivity(new Intent(getActivity(), AddQuoteActivity.class));
                break;
        }
    }
}
