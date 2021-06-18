package com.policyboss.policybosspro.loan_fm.MyBusinessLoan;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.policyboss.policybosspro.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BuisnessEnity;

public class BusinessPopUpAdapter extends RecyclerView.Adapter<BusinessPopUpAdapter.BusinessPopUPItem> {
    Activity mContext;
    List<BuisnessEnity> buisnessEnityList;


    public BusinessPopUpAdapter(Activity mContext, List<BuisnessEnity> buisnessList) {
        this.mContext = mContext;
        this.buisnessEnityList = buisnessList;
    }

    public class BusinessPopUPItem extends RecyclerView.ViewHolder{
        public TextView txtCustName,  txtAmount,  txtProduct,txtbank;

        public BusinessPopUPItem(View itemView) {
            super(itemView);
            txtCustName = (TextView)itemView.findViewById(R.id.txtCustName);
            txtAmount = (TextView)itemView.findViewById(R.id.txtAmount);
            txtProduct = (TextView)itemView.findViewById(R.id.txtProduct);
            txtbank= (TextView)itemView.findViewById(R.id.txtbank);
        }
    }

    @Override
    public BusinessPopUpAdapter.BusinessPopUPItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_business_item,parent,false);
        return new BusinessPopUpAdapter.BusinessPopUPItem(itemView);
    }

    @Override
    public void onBindViewHolder(BusinessPopUpAdapter.BusinessPopUPItem holder, int position) {

        final  BuisnessEnity buisnessEnity = buisnessEnityList.get(position);
        holder.txtCustName.setText(buisnessEnity.getCustName());
        holder.txtAmount.setText(""+ buisnessEnity.getLoanAmount());
        holder.txtProduct.setText(buisnessEnity.getProduct());
        holder.txtbank.setText(buisnessEnity.getBank());
    }

    @Override
    public int getItemCount() {
        return buisnessEnityList.size();
    }
}
