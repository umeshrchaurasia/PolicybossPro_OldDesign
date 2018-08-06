package com.datacomp.magicfinmart.vehicle_details;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.VehicleMobileResponse;

public class VehicleDetailsAdapter extends RecyclerView.Adapter<VehicleDetailsAdapter.customerInfoItem> {

    Context mContex;
    List<VehicleMobileResponse.CustomerDetailsEntity> listCustDetails;

    public VehicleDetailsAdapter(Context context, List<VehicleMobileResponse.CustomerDetailsEntity> list) {
        this.mContex = context;
        listCustDetails = list;
    }

    @Override
    public customerInfoItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_vehicle_details, parent, false);
        return new customerInfoItem(itemView);
    }

    @Override
    public void onBindViewHolder(customerInfoItem holder, int position) {

        VehicleMobileResponse.CustomerDetailsEntity entity = listCustDetails.get(position);
        holder.txtCategory.setText(entity.getCategory());
        holder.txtDOB.setText("" + entity.getDOB());
        holder.txtClaimStatus.setText("" + entity.getClaimStatus());
        holder.txtEmail.setText(entity.getEmail());
        holder.txtExpiryDate.setText("" + entity.getExpiryDate());
        holder.txtInsuranceName.setText(entity.getInsuranceName());
        holder.txtMobileNo.setText("" + entity.getMobileNo());
        holder.txtName.setText("" + entity.getName());
        holder.txtPincode.setText("" + entity.getPincode());
        holder.txtPolicyNumber.setText("" + entity.getPolicyNumber());
        holder.txtPremium.setText("" + entity.getPremium());
        holder.txtVehicleRegNumber.setText("" + entity.getVehicleRegNumber());
    }


    @Override
    public int getItemCount() {
        if (listCustDetails == null)
            return 0;
        else
            return listCustDetails.size();
    }

    public class customerInfoItem extends RecyclerView.ViewHolder {


        TextView txtCategory, txtDOB, txtClaimStatus, txtEmail, txtExpiryDate, txtInsuranceName,
                txtMobileNo, txtName, txtPincode, txtPolicyNumber, txtPremium, txtVehicleRegNumber;

        public customerInfoItem(View itemView) {
            super(itemView);
            txtCategory = itemView.findViewById(R.id.txtCategory);
            txtDOB = itemView.findViewById(R.id.txtDOB);
            txtClaimStatus = itemView.findViewById(R.id.txtClaimStatus);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtExpiryDate = itemView.findViewById(R.id.txtExpiryDate);
            txtInsuranceName = itemView.findViewById(R.id.txtInsuranceName);
            txtMobileNo = itemView.findViewById(R.id.txtMobileNo);
            txtName = itemView.findViewById(R.id.txtName);
            txtPincode = itemView.findViewById(R.id.txtPincode);
            txtPolicyNumber = itemView.findViewById(R.id.txtPolicyNumber);
            txtPremium = itemView.findViewById(R.id.txtPremium);
            txtVehicleRegNumber = itemView.findViewById(R.id.txtVehicleRegNumber);
        }
    }


    public void refreshAdapter(List<VehicleMobileResponse.CustomerDetailsEntity> list) {
        listCustDetails = list;
        notifyDataSetChanged();
    }


}