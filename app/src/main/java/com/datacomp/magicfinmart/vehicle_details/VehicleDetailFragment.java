package com.datacomp.magicfinmart.vehicle_details;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.inspection.utility.Utility;
import com.datacomp.magicfinmart.utility.Constants;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VehicleDetailFragment extends BaseFragment implements View.OnClickListener {

    RadioButton rbCarNumber, rbMobileNumber;
    EditText etVehicleDetail;
    Button btnVehicleDetails;
    TextView txtClientName, txtDOB, txtMfg, txtClaimNo, txtClaimSattlementType, txtClaimStatus,
            txtAddress, txtRegistrationNo, txtCarDetail, txtChasisNo, txtEngineNo, txtRTO, txtFuel;

    CardView cvVehicleDetail;

    TextView txtMobileData;

    public VehicleDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vehicle_detail, container, false);
        Constants.hideKeyBoard(rbCarNumber, getActivity());
        init(view);
        cvVehicleDetail.setVisibility(View.GONE);
        txtMobileData.setVisibility(View.GONE);
        return view;
    }

    private void init(View view) {
        txtMobileData = view.findViewById(R.id.txtMobileData);
        rbCarNumber = view.findViewById(R.id.rbCarNumber);
        rbMobileNumber = view.findViewById(R.id.rbMobileNumber);
        etVehicleDetail = view.findViewById(R.id.etVehicleDetail);
        btnVehicleDetails = view.findViewById(R.id.btnVehicleDetails);
        cvVehicleDetail = view.findViewById(R.id.cvVehicleDetail);


        txtClientName = view.findViewById(R.id.txtClientName);
        txtDOB = view.findViewById(R.id.txtDOB);
        txtAddress = view.findViewById(R.id.txtAddress);
        txtRegistrationNo = view.findViewById(R.id.txtRegistrationNo);
        txtCarDetail = view.findViewById(R.id.txtCarDetail);
        txtChasisNo = view.findViewById(R.id.txtChasisNo);
        txtEngineNo = view.findViewById(R.id.txtEngineNo);
        txtRTO = view.findViewById(R.id.txtRTO);
        txtFuel = view.findViewById(R.id.txtFuel);
        txtMfg = view.findViewById(R.id.txtMfg);

        txtClaimNo = view.findViewById(R.id.txtClaimNo);
        txtClaimSattlementType = view.findViewById(R.id.txtClaimSattlementType);
        txtClaimStatus = view.findViewById(R.id.txtClaimStatus);

        btnVehicleDetails.setOnClickListener(this);

        if (rbCarNumber.isChecked())
            etVehicleDetail.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        else if (rbMobileNumber.isChecked())
            etVehicleDetail.setInputType(InputType.TYPE_CLASS_NUMBER);

        rbCarNumber.setOnCheckedChangeListener(changeListener);
        rbMobileNumber.setOnCheckedChangeListener(changeListener);
    }


    CompoundButton.OnCheckedChangeListener changeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.getId() == R.id.rbCarNumber) {
                if (isChecked) {
                    Constants.hideKeyBoard(buttonView, getActivity());
                    etVehicleDetail.setInputType(InputType.TYPE_CLASS_TEXT);
                    //etVehicleDetail.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
                    etVehicleDetail.setText("");
                }
            } else if (buttonView.getId() == R.id.rbMobileNumber) {
                if (isChecked) {
                    Constants.hideKeyBoard(buttonView, getActivity());
                    etVehicleDetail.setInputType(InputType.TYPE_CLASS_NUMBER);
                    etVehicleDetail.setText("");
                }
            }
        }
    };

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnVehicleDetails) {

            //Hide keyboard
            Constants.hideKeyBoard(btnVehicleDetails, getActivity());

            //validation
            if (rbCarNumber.isChecked()) {

                if (etVehicleDetail.getText().toString().equalsIgnoreCase("")
                        || etVehicleDetail.getText().toString().length() < 9) {
                    etVehicleDetail.setError("Invalid vehicle number");
                    etVehicleDetail.requestFocus();
                    return;
                }
            } else if (rbMobileNumber.isChecked()) {
                if (!isValidePhoneNumber(etVehicleDetail)) {
                    etVehicleDetail.setError("Invalid phone number");
                    etVehicleDetail.requestFocus();
                    return;
                }
            }

            //server hit
            showDialog();

            if (rbCarNumber.isChecked()) {
                //1.vehicle
                new AsyncVehicle(getActivity(), true, etVehicleDetail.getText().toString(), new ICarDetail() {
                    @Override
                    public void getCarDetails(String strCarDetails) {
                        cancelDialog();
                        Gson gson = new Gson();
                        try {
                            VehicleInfoEntity entity = gson.fromJson(strCarDetails, VehicleInfoEntity.class);
                            bindVehicle(entity);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }).execute();

            } else {
                //2.mobile
                new AsyncVehicle(getActivity(), false, etVehicleDetail.getText().toString(), new ICarDetail() {
                    @Override
                    public void getCarDetails(String strCarDetails) {
                        cancelDialog();
                        try {
                            if (!strCarDetails.equalsIgnoreCase("")) {
                                List<String> elephantList = Arrays.asList(strCarDetails.split(","));
                                txtMobileData.setText(elephantList.toString());
                            } else {
                                Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }).execute();
            }
        }
    }

    private void bindVehicle(VehicleInfoEntity entity) {
        if (entity == null) {
            Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
            return;
        } else if (entity.getGetRegNoDataResult().size() == 0) {
            Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
            return;
        }

        cvVehicleDetail.setVisibility(View.VISIBLE);

        VehicleInfoEntity.GetRegNoDataResultBean v = entity.getGetRegNoDataResult().get(0);
        try {
            txtClientName.setText(v.getClientName());
            txtDOB.setText(v.getDOB());
            txtAddress.setText(v.getHolderaddress() + " " + v.getPOSPCode());
            txtRegistrationNo.setText(v.getRegistrationNo());
            txtCarDetail.setText(v.getMake() + "," + v.getModel() + "," + v.getSubModel());
            txtChasisNo.setText(v.getChasisNo());
            txtEngineNo.setText(v.getEngineNo());
            txtRTO.setText(v.getRTOCity() + "," + v.getRTOState());
            txtFuel.setText(v.getFuelType());
            txtMfg.setText("" + v.getMfgyear());

            txtClaimNo.setText("" + v.getClaimNo());
            txtClaimSattlementType.setText("" + v.getClaimSattlementType());
            txtClaimStatus.setText("" + v.getClaimStatus());

        } catch (Exception e) {

        }
    }

    private void bindNumber(String strMobileNumber) {
        txtMobileData.setVisibility(View.VISIBLE);
    }
}

