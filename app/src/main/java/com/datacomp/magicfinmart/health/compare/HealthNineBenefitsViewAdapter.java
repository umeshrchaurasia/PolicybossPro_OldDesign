package com.datacomp.magicfinmart.health.compare;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BenefitsEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;

public class HealthNineBenefitsViewAdapter extends RecyclerView.Adapter<HealthNineBenefitsViewAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    Context mContext;
    List<BenefitsEntity> listBenefits;

    HealthNineBenefitsViewAdapter(Context context, List<BenefitsEntity> list) {
        mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        listBenefits = list;
    }


    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_benefits_nine, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.txtBenefitsName.setText(listBenefits.get(position).getBeneDesc());

        if (listBenefits.get(position).isSelected()) {
            holder.txtSelect.setBackgroundResource(R.color.colorAccent);
            //holder.llBenefits.performClick();
        } else {
            holder.txtSelect.setBackgroundResource(R.color.seperator);
        }

        holder.llBenefits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HealthCompareActivity) mContext).updateBenefits(listBenefits.get(position).getBeneDesc());
                updateList(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listBenefits.size();
    }

    public void updateList(int position) {
        for (int i = 0; i < listBenefits.size(); i++) {
            listBenefits.get(i).setSelected(false);
        }
        listBenefits.get(position).setSelected(true);
        notifyDataSetChanged();


    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtBenefitsName, txtSelect;
        LinearLayout llBenefits;
        ImageView imgBenefits;


        ViewHolder(View itemView) {
            super(itemView);
            txtBenefitsName = (TextView) itemView.findViewById(R.id.txtBenefitsName);
            txtSelect = (TextView) itemView.findViewById(R.id.txtSelect);
            imgBenefits = (ImageView) itemView.findViewById(R.id.imgBenefits);
            llBenefits = (LinearLayout) itemView.findViewById(R.id.llBenefits);
        }
    }


}