package com.datacomp.magicfinmart.motor.privatecar.quote;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.addquote.AddQuoteActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MotorQuoteFragment extends BaseFragment implements View.OnClickListener {

    Button btnAddQuote;
    EditText etSearch;

    public MotorQuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_motor_quote, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        btnAddQuote = (Button) view.findViewById(R.id.btnAddQuote);
        etSearch = (EditText) view.findViewById(R.id.etSearch);

        btnAddQuote.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnAddQuote:
                startActivity(new Intent(getActivity(), AddQuoteActivity.class));
                break;
        }
    }
}
