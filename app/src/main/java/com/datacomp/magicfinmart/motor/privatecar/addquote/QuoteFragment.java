package com.datacomp.magicfinmart.motor.privatecar.addquote;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.master.model.MasterDataEntity;
import magicfinmart.datacomp.com.finmartserviceapi.motor.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.motor.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.motor.controller.MotorController;
import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.MotorRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.motor.response.BikePremiumResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends BaseFragment implements IResponseSubcriber {

    MotorRequestEntity motorRequestEntity;
    TextView tvVarient, tvMakeModel, tvFuel, tvCrn, tvCount;
    Switch swAddon;
    BikePremiumResponse bikePremiumResponse;
    Context context;
    DBPersistanceController dataBaseController;
    MasterDataEntity masterDataEntity;

    public QuoteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote, container, false);
        Toast.makeText(getActivity(), "Quote Fragment ", Toast.LENGTH_SHORT).show();
        dataBaseController = new DBPersistanceController(getActivity());
        motorRequestEntity = AddQuoteBottomActivity.motorRequestEntity;
        initView(view);
        setListener();
        updateHeader();
        fetchQuotes();
        return view;
    }

    private void setListener() {
        swAddon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
    }

    private void updateHeader() {
        if (motorRequestEntity != null)
            masterDataEntity = dataBaseController.getVarientDetails(motorRequestEntity.getVehicle_id());
        if (masterDataEntity != null) {

            tvVarient.setText(masterDataEntity.getVariant_Name());
            tvFuel.setText(masterDataEntity.getFuel_Name());
            tvMakeModel.setText(masterDataEntity.getMake_Name() + " , " + masterDataEntity.getModel_Name());
        }
        if (bikePremiumResponse != null) {
            if (bikePremiumResponse.getSummary().getPB_CRN() != null) {
                tvCrn.setText("" + bikePremiumResponse.getSummary().getPB_CRN());
                tvCount.setText("" + bikePremiumResponse.getSummary().getSuccess() + " results from qa.policyboss.com");
            }
        }
    }

    private void updateCrn() {
        if (bikePremiumResponse != null) {
            if (bikePremiumResponse.getSummary().getPB_CRN() != null) {
                tvCrn.setText("" + bikePremiumResponse.getSummary().getPB_CRN());
                tvCount.setText("" + bikePremiumResponse.getSummary().getSuccess() + " results from qa.policyboss.com");
            }
        }
    }

    private void initView(View view) {
        tvVarient = (TextView) view.findViewById(R.id.tvVarient);
        tvMakeModel = (TextView) view.findViewById(R.id.tvMakeModel);
        tvFuel = (TextView) view.findViewById(R.id.tvFuel);
        tvCrn = (TextView) view.findViewById(R.id.tvCrn);
        tvCount = (TextView) view.findViewById(R.id.tvCount);
        swAddon = (Switch) view.findViewById(R.id.swAddon);
    }


    public void updateInputQuotefragment(MotorRequestEntity motorRequestEntity) {
        this.motorRequestEntity = motorRequestEntity;
    }

    public void fetchQuotes() {
        new MotorController(getActivity()).getMotorQuote(1, this);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        if (response instanceof BikePremiumResponse) {
            bikePremiumResponse = (BikePremiumResponse) response;
            updateCrn();
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
