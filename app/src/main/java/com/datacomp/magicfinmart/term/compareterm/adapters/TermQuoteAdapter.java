package com.datacomp.magicfinmart.term.compareterm.adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.term.compareterm.TermQuoteFragment;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TermCompareResponseEntity;

public class TermQuoteAdapter extends RecyclerView.Adapter<TermQuoteAdapter.TermQuoteItem> {


    Fragment mContext;

    List<TermCompareResponseEntity> listQuotes;
    DBPersistanceController dbPersistanceController;

    public TermQuoteAdapter(Fragment mContext, List<TermCompareResponseEntity> listQuotes) {
        this.mContext = mContext;
        this.listQuotes = listQuotes;
        dbPersistanceController = new DBPersistanceController(mContext.getContext());

    }

    @Override
    public TermQuoteItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_termquote_item, parent, false);
        return new TermQuoteAdapter.TermQuoteItem(itemView);
    }

    @Override
    public void onBindViewHolder(TermQuoteItem holder, int position) {
        final TermCompareResponseEntity responseEntity = listQuotes.get(position);

        holder.txtPlanNAme.setText("" + responseEntity.getProductPlanName());
        holder.txtCover.setText("" + responseEntity.getSumAssured());
        holder.txtPolicyTerm.setText(responseEntity.getPolicyTermYear() + "Yrs.");
        holder.txtFinalPremium.setText("\u20B9 " + responseEntity.getNetPremium() + "/Year");
        // holder.txtFinalPremium.setText("\u20B9 " + Math.round(Double.parseDouble(responseEntity.getFinal_premium_with_addon())));

        Glide.with(mContext)
                .load("http://www.policyboss.com/Images/insurer_logo/" + responseEntity.getInsurerLogoName())
                .into(holder.imgInsurerLogo);

        holder.txtCustomise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((TermQuoteFragment) mContext).redirectToPopUpPremium(responseEntity, response.getSummary(), responseEntity.getLM_Custom_Request().getVehicle_expected_idv());
            }
        });
        holder.txtRiders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((TermQuoteFragment) mContext).redirectToPopUpPremium(responseEntity, response.getSummary(), responseEntity.getLM_Custom_Request().getVehicle_expected_idv());
            }
        });

        holder.txtFinalPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TermQuoteFragment) mContext).redirectToBuy(responseEntity);
            }
        });

        if (responseEntity.getKeyFeatures() != null) {
            holder.llAddon.setVisibility(View.VISIBLE);
            holder.rvAddOn.setHasFixedSize(true);
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext.getActivity(), 2);
            holder.rvAddOn.setLayoutManager(mLayoutManager);
            GridTermAdapter adapter = new GridTermAdapter(mContext.getActivity(), responseEntity.getKeyFeatures().split("\\|"));
            holder.rvAddOn.setAdapter(adapter);

        } else {
            holder.llAddon.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        if (listQuotes != null) {
            return listQuotes.size();
        } else {
            return 0;
        }
    }

    public class TermQuoteItem extends RecyclerView.ViewHolder {
        public TextView txtPlanNAme, txtCover, txtFinalPremium, txtPolicyTerm, txtAge, txtCustomise, txtRiders;
        ImageView imgInsurerLogo;
        LinearLayout llAddon;
        RecyclerView rvAddOn;

        public TermQuoteItem(View itemView) {
            super(itemView);
            llAddon = (LinearLayout) itemView.findViewById(R.id.llAddon);
            rvAddOn = (RecyclerView) itemView.findViewById(R.id.rvAddOn);
            txtAge = (TextView) itemView.findViewById(R.id.txtAge);
            txtCustomise = (TextView) itemView.findViewById(R.id.txtCustomise);
            txtRiders = (TextView) itemView.findViewById(R.id.txtRiders);
            txtPlanNAme = (TextView) itemView.findViewById(R.id.txtPlanNAme);
            txtCover = (TextView) itemView.findViewById(R.id.txtCover);
            txtFinalPremium = (TextView) itemView.findViewById(R.id.txtFinalPremium);
            imgInsurerLogo = (ImageView) itemView.findViewById(R.id.imgInsurerLogo);
            txtPolicyTerm = (TextView) itemView.findViewById(R.id.txtPolicyTerm);
        }
    }


}
