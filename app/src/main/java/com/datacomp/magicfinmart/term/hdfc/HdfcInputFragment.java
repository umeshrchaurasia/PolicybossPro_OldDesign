package com.datacomp.magicfinmart.term.hdfc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

/**
 * Created by Rajeev Ranjan on 17/05/2018.
 */

public class HdfcInputFragment extends BaseFragment implements View.OnClickListener {

    //region header views
    LinearLayout llGender, llSmoker;
    EditText etFirstName, etLastName, etMobile, etDOB;
    TextView tvMale, tvFemale, tvYes, tvNo;
    boolean isMale, isSmoker;
    //endregion

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hdfc_input, container, false);
        init_view(view);
        return view;
    }

    private void init_view(View view) {

        tvMale = (TextView) view.findViewById(R.id.tvMale);
        tvFemale = (TextView) view.findViewById(R.id.tvFemale);
        tvYes = (TextView) view.findViewById(R.id.tvYes);
        tvNo = (TextView) view.findViewById(R.id.tvNo);
        etFirstName = (EditText) view.findViewById(R.id.etFirstName);
        etLastName = (EditText) view.findViewById(R.id.etLastName);
        etMobile = (EditText) view.findViewById(R.id.etMobile);
        etDOB = (EditText) view.findViewById(R.id.etDateofBirth);
        llGender = (LinearLayout) view.findViewById(R.id.llGender);
        llSmoker = (LinearLayout) view.findViewById(R.id.llSmoker);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvMale:
                isMale = true;
                tvFemale.setBackgroundResource(R.drawable.customeborder);
                tvMale.setBackgroundResource(R.drawable.customeborder_blue);
                break;
            case R.id.tvFemale:
                isMale = false;
                tvMale.setBackgroundResource(R.drawable.customeborder);
                tvFemale.setBackgroundResource(R.drawable.customeborder_blue);
                break;
            case R.id.tvYes:
                isSmoker = true;
                tvNo.setBackgroundResource(R.drawable.customeborder);
                tvYes.setBackgroundResource(R.drawable.customeborder_blue);
                break;
            case R.id.tvNo:
                isSmoker = false;
                tvYes.setBackgroundResource(R.drawable.customeborder);
                tvNo.setBackgroundResource(R.drawable.customeborder_blue);
                break;
        }
    }
}
