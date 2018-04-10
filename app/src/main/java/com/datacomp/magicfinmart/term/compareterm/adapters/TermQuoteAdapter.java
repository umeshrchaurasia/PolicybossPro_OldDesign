package com.datacomp.magicfinmart.term.compareterm.adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TermCompareResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TermCompareQuoteResponse;

public class TermQuoteAdapter extends RecyclerView.Adapter<TermQuoteAdapter.TermQuoteItem> {


    Fragment mContext;
    TermCompareQuoteResponse response;

    List<TermCompareResponseEntity> listQuotes;
    DBPersistanceController dbPersistanceController;

    public TermQuoteAdapter(Fragment mContext, TermCompareQuoteResponse response) {
        this.mContext = mContext;
        this.response = response;
        dbPersistanceController = new DBPersistanceController(mContext.getContext());
        if (response.getMasterData() != null)
            this.listQuotes = response.getMasterData().getResponse();
        else
            this.listQuotes = null;
    }

    @Override
    public TermQuoteItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_bikequote_item_new, parent, false);
        return new TermQuoteAdapter.TermQuoteItem(itemView);
    }

    @Override
    public void onBindViewHolder(TermQuoteItem holder, int position) {
/*
        final TermCompareResponseEntity responseEntity = listQuotes.get(position);

        holder.txtInsurerName.setText(responseEntity.getInsurerName());
        // holder.txtIDV.setText(responseEntity);
        if (responseEntity.getPremium_Breakup() != null) {
            if (responseEntity.isAddonApplied()) {
                holder.txtFinalPremium.setText("\u20B9 " + Math.round(Double.parseDouble(responseEntity.getFinal_premium_with_addon())));
            } else {
                holder.txtFinalPremium.setText("\u20B9 " + Math.round(Double.parseDouble(responseEntity.getPremium_Breakup().getFinal_premium())));
            }

        } else {
            holder.txtFinalPremium.setText("");
        }

        holder.txtIDV.setText("\u20B9 " + String.valueOf(responseEntity.getLM_Custom_Request().getVehicle_expected_idv()));
        //holder.imgInsurerLogo.setImageResource(dbPersistanceController.getInsImage(Integer.parseInt(responseEntity.getInsurer().getInsurer_ID())));
        Glide.with(mContext)
                //.load(dbgetProfessionalID1(Integer.parseInt(responseEntity.getInsurer().getInsurer_ID())))
                .load("http://www.policyboss.com/Images/insurer_logo/" + responseEntity.getInsurerLogoName())
                .into(holder.imgInsurerLogo);

        holder.txtFinalPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((QuoteFragment) mContext).redirectToPopUpPremium(responseEntity, response.getSummary(), responseEntity.getLM_Custom_Request().getVehicle_expected_idv());
            }
        });
        holder.txtPremiumBreakUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((QuoteFragment) mContext).redirectToPopUpPremium(responseEntity, response.getSummary(), responseEntity.getLM_Custom_Request().getVehicle_expected_idv());
            }
        });

        holder.txtBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((QuoteFragment) mContext).redirectToBuy(responseEntity);
            }
        });

        if (responseEntity.getKeyFeatures() != null) {

            holder.llAddon.setVisibility(View.VISIBLE);
            holder.rvAddOn.setHasFixedSize(true);
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext.getActivity(), 2);
            holder.rvAddOn.setLayoutManager(mLayoutManager);
            GridAddonAdapter adapter = new GridAddonAdapter(mContext.getActivity(), responseEntity.getListAppliedAddons());
            holder.rvAddOn.setAdapter(adapter);

        } else {
            holder.llAddon.setVisibility(View.GONE);
        }*/
    }

    @Override
    public int getItemCount() {
        if (listQuotes != null) {
            return listQuotes.size();
        } else {
            return 0;
        }
    }

    public void setQuoteResponse(TermCompareQuoteResponse response) {
        this.response = response;
        if (response.getMasterData() != null)
            this.listQuotes = response.getMasterData().getResponse();
    }

    public class TermQuoteItem extends RecyclerView.ViewHolder {
        public TextView txtInsurerName, txtIDV, txtFinalPremium, txtPremiumBreakUp, txtBuy;
        ImageView imgInsurerLogo;
        LinearLayout llAddon;
        RecyclerView rvAddOn;

        public TermQuoteItem(View itemView) {
            super(itemView);
            llAddon = (LinearLayout) itemView.findViewById(R.id.llAddon);
            rvAddOn = (RecyclerView) itemView.findViewById(R.id.rvAddOn);
            txtInsurerName = (TextView) itemView.findViewById(R.id.txtInsuranceCompName);
            txtIDV = (TextView) itemView.findViewById(R.id.txtIDV);
            txtBuy = (TextView) itemView.findViewById(R.id.txtBuy);
            txtFinalPremium = (TextView) itemView.findViewById(R.id.txtFinalPremium);
            imgInsurerLogo = (ImageView) itemView.findViewById(R.id.imgInsurerLogo);
            txtPremiumBreakUp = (TextView) itemView.findViewById(R.id.txtPremiumBreakUp);
        }
    }


}
