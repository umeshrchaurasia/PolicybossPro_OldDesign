package com.datacomp.magicfinmart.health.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.SortbyInsurer;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BenefitsEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.model.HealthSumAssured;

public class HealthQuoteAdapter extends RecyclerView.Adapter<HealthQuoteAdapter.ViewHolder> implements View.OnClickListener {


    public static final String HIDE_OPTIONS = "Hide Options";
    private LayoutInflater mInflater;
    Fragment mContext;
    List<HealthQuoteEntity> listHealthQuotes;


    // data is passed into the constructor
    HealthQuoteAdapter(Fragment context, List<HealthQuoteEntity> listQuotes) {
        mContext = context;
        this.mInflater = LayoutInflater.from(mContext.getActivity());
        this.listHealthQuotes = listQuotes;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_health_quote, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final HealthQuoteEntity entity = listHealthQuotes.get(position);
        holder.txtSumAssured.setText("" + Math.round(entity.getSumInsured()));
        holder.txtDeductible.setText("" + entity.getDeductible_Amount());
        holder.txtPlanName.setText("" + entity.getPlanName());
        holder.txtFinalPremium.setText("\u20B9 " + Math.round(entity.getNetPremium()) + "/Year");

        if (entity.getInsurerLogoName().equals("")) {
            holder.imgInsurer.setImageResource(new DBPersistanceController(mContext.getActivity())
                    .getInsurerImage(entity.getInsurerId()));
        } else {
            String imgURL = "http://www.policyboss.com/Images/insurer_logo/" + entity.getInsurerLogoName();
            Glide.with(mContext).load(imgURL)
                    .into(holder.imgInsurer);
        }
        holder.txtNoOfInsurer.setTag(R.id.txtNoOfInsurer, entity);
        holder.chkCompare.setTag(R.id.chkCompare, entity);

        holder.txtBuy.setTag(R.id.txtBuy, entity);
        holder.txtBuy.setOnClickListener(this);

        if (entity.isCompare()) {
            holder.chkCompare.setChecked(true);
        } else {
            holder.chkCompare.setChecked(false);
        }

        holder.chkCompare.setOnCheckedChangeListener(checkedChangeListener);

        if (!entity.getIsMore() && entity.getTotalChilds() > 0) {
            holder.txtNoOfInsurer.setText(" + \n" + String.valueOf(entity.getTotalChilds() + " \nMore"));
            holder.imgDropDown.setVisibility(View.VISIBLE);
            holder.txtNoOfInsurer.setOnClickListener(this);
        } else if (!entity.getIsMore() && entity.getTotalChilds() == 0) {
            holder.txtNoOfInsurer.setText("");
            holder.imgDropDown.setVisibility(View.GONE);
            holder.txtNoOfInsurer.setOnClickListener(null);
        } else {
            holder.txtNoOfInsurer.setText(HIDE_OPTIONS);
            holder.imgDropDown.setVisibility(View.VISIBLE);
            holder.txtNoOfInsurer.setOnClickListener(this);
        }

        for (int i = 0; i < entity.getLstbenfitsFive().size(); i++) {
            BenefitsEntity benefit = entity.getLstbenfitsFive().get(i);
            if (benefit.getBeneID() == 1) { //room rent
                holder.txtRoomRent.setText(benefit.getBenefit());
            } else if (benefit.getBeneID() == 2) { //icu
                holder.txtIcuRent.setText(benefit.getBenefit());
            } else if (benefit.getBeneID() == 3) { //pre hosp
                holder.txtPreHosp.setText(benefit.getBenefit());
            } else if (benefit.getBeneID() == 4) { //post
                holder.txtPostHosp.setText(benefit.getBenefit());
            }
        }
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            if (b) {
                HealthQuoteEntity entity = (HealthQuoteEntity) compoundButton.getTag(R.id.chkCompare);
                entity.setCompare(b);
                ((HealthQuoteFragment) mContext).addRemoveCompare(entity, b);
            }
        }
    };

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
        ImageView imgInsurer, imgDropDown;

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
            imgDropDown = (ImageView) itemView.findViewById(R.id.imgDropDown);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtNoOfInsurer:

                if (((TextView) view).getText() != HIDE_OPTIONS) {
                    ((HealthQuoteFragment) mContext).addMoreQuote(((HealthQuoteEntity) view.getTag(R.id.txtNoOfInsurer)).getInsurerId());
                    ((HealthQuoteEntity) view.getTag(R.id.txtNoOfInsurer)).setIsMore(true);
                    ((TextView) view).setText(HIDE_OPTIONS);

                } else {

                    ((TextView) view).setText(" + \n" + String.valueOf(((HealthQuoteEntity) view.getTag(R.id.txtNoOfInsurer)).getTotalChilds() + " \nMore"));
                    ((HealthQuoteEntity) view.getTag(R.id.txtNoOfInsurer)).setIsMore(false);
                    //remove all added insurer + check no of childs
                    removeInsurer(((HealthQuoteEntity) view.getTag(R.id.txtNoOfInsurer)));
                }
                break;

            case R.id.txtBuy:
                ((HealthQuoteFragment) mContext).redirectToBuy(((HealthQuoteEntity) view.getTag(R.id.txtBuy)));
                break;
        }
    }

    public void refreshNewQuote(List<HealthQuoteEntity> list) {
        listHealthQuotes.addAll(list);
        Collections.sort(listHealthQuotes, new SortbyInsurer());
        Collections.reverse(listHealthQuotes);
        notifyDataSetChanged();
    }

    public void removeRefresh(List<HealthQuoteEntity> list) {
        listHealthQuotes = list;
        Collections.sort(listHealthQuotes, new SortbyInsurer());
        Collections.reverse(listHealthQuotes);
        notifyDataSetChanged();
    }

    private void removeInsurer(HealthQuoteEntity entity) {

        List<HealthQuoteEntity> list = listHealthQuotes;
        for (Iterator<HealthQuoteEntity> iter = list.listIterator(); iter.hasNext(); ) {
            HealthQuoteEntity a = iter.next();
            if (a.getInsurerId() == entity.getInsurerId()) {
                if (a.getTotalChilds() == 0) {
                    iter.remove();
                }
            }
        }

        removeRefresh(list);
    }
}