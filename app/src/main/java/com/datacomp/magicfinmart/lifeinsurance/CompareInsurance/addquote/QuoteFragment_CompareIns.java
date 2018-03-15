package com.datacomp.magicfinmart.lifeinsurance.CompareInsurance.addquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment_CompareIns extends Fragment {


    public QuoteFragment_CompareIns() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.content_add_compareins_quote, container, false);
        return view;
    }

}
