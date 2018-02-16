package com.datacomp.magicfinmart.health.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.model.HealthSumAssured;

public class HealthQuoteAdapter extends RecyclerView.Adapter<HealthQuoteAdapter.ViewHolder> {


    private LayoutInflater mInflater;
    Fragment mContext;
    List<HealthQuoteEntity> listHealthQuotes;


    // data is passed into the constructor
    HealthQuoteAdapter(Fragment context, List<HealthQuoteEntity> listQuotes) {
        mContext = context;
        this.mInflater = LayoutInflater.from(mContext.getActivity());
        this.listHealthQuotes = listQuotes;

    }


    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_health_quote, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

    }

    // total number of cells
    @Override
    public int getItemCount() {
        return 5;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtSumAssured, txtDeductible, txtPlanName, txtFinalPremium, txtBuy;
        TextView txtRoomRent,txtIcuRent,txtPostHosp,txtNoOfInsurer;
        CheckBox chkCompare;
        ImageView imgInsurer;

        ViewHolder(View itemView) {
            super(itemView);
            //txtSumAssured = (TextView) itemView.findViewById(R.id.txtSumAssured);
        }
    }


}