package com.datacomp.magicfinmart.health.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
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

        HealthQuoteEntity entity = listHealthQuotes.get(position);

        if (position == 2 || position == 5 || position == 7) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.height = 0;
            holder.cvHealthQuote.setLayoutParams(params);
        }
        if (entity.getQuoteStatus().equals("Success")) {
            holder.txtSumAssured.setText("" + entity.getSumInsured());
            holder.txtDeductible.setText("" + entity.getDeductible_Amount());
            holder.txtPlanName.setText("" + entity.getPlanName());
            holder.txtFinalPremium.setText("\u20B9 " + Math.round(entity.getNetPremium()) + " /Year");

            holder.imgInsurer.setImageResource(new DBPersistanceController(mContext.getActivity()).getInsurerImage(entity.getInsurerId()));

        }

    }

    // total number of cells
    @Override
    public int getItemCount() {
        return listHealthQuotes.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cvHealthQuote;
        TextView txtSumAssured, txtDeductible, txtPlanName, txtFinalPremium, txtBuy;
        TextView txtRoomRent, txtIcuRent, txtPreHosp, txtPostHosp, txtNoOfInsurer;
        CheckBox chkCompare;
        ImageView imgInsurer;

        ViewHolder(View itemView) {
            super(itemView);
            cvHealthQuote = (CardView) itemView.findViewById(R.id.cvHealthQuote);
            txtSumAssured = (TextView) itemView.findViewById(R.id.txtSumAssured);
            txtDeductible = (TextView) itemView.findViewById(R.id.txtDeductible);
            txtPlanName = (TextView) itemView.findViewById(R.id.txtPlanName);
            txtFinalPremium = (TextView) itemView.findViewById(R.id.txtFinalPremium);
            txtBuy = (TextView) itemView.findViewById(R.id.txtBuy);
            txtRoomRent = (TextView) itemView.findViewById(R.id.txtRoomRent);
            txtIcuRent = (TextView) itemView.findViewById(R.id.txtIcuRent);
            txtPreHosp = (TextView) itemView.findViewById(R.id.txtPreHosp);
            txtPostHosp = (TextView) itemView.findViewById(R.id.txtPostHosp);
            txtNoOfInsurer = (TextView) itemView.findViewById(R.id.txtNoOfInsurer);

            chkCompare = (CheckBox) itemView.findViewById(R.id.chkCompare);
            imgInsurer = (ImageView) itemView.findViewById(R.id.imgInsurer);
        }
    }


}