package com.datacomp.magicfinmart.dashboard;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.personalloan.PersonalLoanDetailActivity;
import com.datacomp.magicfinmart.motor.privatecar.PrivateCarDetailActivity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity;

public class DashboardItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Fragment mContext;
    List<DashboardEntity> listInsur;

    public DashboardItemAdapter(Fragment context, List<DashboardEntity> list) {
        mContext = context;
        listInsur = list;
    }

    public class DashboardItemHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView txtProductName, txtProductDesc;
        CardView card_view;

        public DashboardItemHolder(View view) {
            super(view);
            card_view = (CardView) view.findViewById(R.id.card_view);
            imgIcon = (ImageView) view.findViewById(R.id.imgIcon);
            txtProductName = (TextView) view.findViewById(R.id.txtProductName);
            txtProductDesc = (TextView) view.findViewById(R.id.txtProductDesc);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.dashboard_rv_item, parent, false);
        return new DashboardItemHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof DashboardItemHolder) {
            ((DashboardItemHolder) holder).imgIcon.setImageResource(listInsur.get(position).getIcon());
            ((DashboardItemHolder) holder).txtProductName.setText(listInsur.get(position).getProductName());
            ((DashboardItemHolder) holder).txtProductDesc.setText(listInsur.get(position).getProductDetails());
            ((DashboardItemHolder) holder).card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if( listInsur.get(position).getProductName().equals("PERSONAL LOAN" ))
                    {
                        mContext.startActivity(new Intent(mContext.getActivity(), PersonalLoanDetailActivity.class));
                    } else
                    {
                        mContext.startActivity(new Intent(mContext.getActivity(), PrivateCarDetailActivity.class));
                    }

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listInsur.size();
    }


}