package com.datacomp.magicfinmart.motor.privatecar.addquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends BaseFragment {


    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(getActivity(), "INPUT FRAGMENT", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

}
