package com.datacomp.magicfinmart.vehicle_details;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.InputType;
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
import com.datacomp.magicfinmart.utility.Constants;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.*;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.VehicleInfoEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;

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

    RecyclerView rvMobile;
    VehicleDetailsAdapter mAdapter;
    List<VehicleMobileResponse.CustomerDetailsEntity> listCustDetails;

    public VehicleDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vehicle_detail, container, false);
        Constants.hideKeyBoard(rbCarNumber, getActivity());
        listCustDetails = new ArrayList<>();
        init(view);

        cvVehicleDetail.setVisibility(View.GONE);
        txtMobileData.setVisibility(View.GONE);
        return view;
    }

    private void init(View view) {

        rvMobile = view.findViewById(R.id.rvMobile);
        rvMobile.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvMobile.setLayoutManager(layoutManager);
        mAdapter = new VehicleDetailsAdapter(getActivity(), listCustDetails);
        rvMobile.setAdapter(mAdapter);

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
                    etVehicleDetail.setText("");
                    rvMobile.setVisibility(View.GONE);
                    cvVehicleDetail.setVisibility(View.VISIBLE);
                }
            } else if (buttonView.getId() == R.id.rbMobileNumber) {
                if (isChecked) {
                    Constants.hideKeyBoard(buttonView, getActivity());
                    etVehicleDetail.setInputType(InputType.TYPE_CLASS_NUMBER);
                    etVehicleDetail.setText("");
                    rvMobile.setVisibility(View.VISIBLE);
                    listCustDetails.clear();
                    mAdapter.refreshAdapter(listCustDetails);
                    cvVehicleDetail.setVisibility(View.GONE);
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
                showDialog();
                new DynamicController(getActivity()).getVehicleByVehicleNo(etVehicleDetail.getText().toString(),
                        new IResponseSubcriber() {
                            @Override
                            public void OnSuccess(APIResponse response, String message) {
                                cancelDialog();
                                if (response instanceof magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.VehicleInfoEntity) {
                                    //bind vehicle
                                    bindVehicle(((magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.VehicleInfoEntity) response).getGetRegNoDataResult());
                                }
                            }

                            @Override
                            public void OnFailure(Throwable t) {
                                cancelDialog();
                                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

            } else {
                //2.mobile

                new DynamicController(getActivity()).getVehicleByMobileNo(etVehicleDetail.getText().toString(), new IResponseSubcriber() {
                    @Override
                    public void OnSuccess(APIResponse response, String message) {
                        cancelDialog();
                        if ((VehicleMobileResponse) response != null) {
                            if (((VehicleMobileResponse) response).getCustomerDetails().size() > 0) {
                                //bind recycler
                                mAdapter.refreshAdapter(((VehicleMobileResponse) response).getCustomerDetails());
                            }
                        }
                    }

                    @Override
                    public void OnFailure(Throwable t) {
                        cancelDialog();
                        Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }
    }

    private void bindVehicle(List<magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.VehicleInfoEntity.VehicleInfo> entity) {
        if (entity == null) {
            Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
            return;
        } else if (entity.size() == 0) {
            Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
            return;
        }

        cvVehicleDetail.setVisibility(View.VISIBLE);

        VehicleInfoEntity.VehicleInfo v = entity.get(0);
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

