package com.datacomp.magicfinmart.lifeinsurance.CompareInsurance.addquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment_CompareIns extends BaseFragment implements View.OnClickListener {

    DBPersistanceController databaseController;

    LoginResponseEntity loginEntity;
    public InputFragment_CompareIns() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_add_compareins_quote, container, false);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
