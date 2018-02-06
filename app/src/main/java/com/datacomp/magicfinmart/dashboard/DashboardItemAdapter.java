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
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.health.HealthQuoteAppActivity;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.BalanceTransferDetailActivity;
import com.datacomp.magicfinmart.loan_fm.homeloan.HomeLoanDetailActivity;
import com.datacomp.magicfinmart.loan_fm.laploan.LapLoanDetailActivity;
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

                    switch (listInsur.get(position).getProductId()) {
                        case 1:
                            //car
                            mContext.startActivity(new Intent(mContext.getActivity(), PrivateCarDetailActivity.class));
                            break;
                        case 10:
                            //bike
                            break;
                        case 3:
                            //health
                            mContext.startActivity(new Intent(mContext.getActivity(), HealthQuoteAppActivity.class));
                            break;
                        case 4:
                            //home loan
                            mContext.startActivity(new Intent(mContext.getActivity(), HomeLoanDetailActivity.class));
                            break;
                        case 5:
                            //personal loan
                            mContext.startActivity(new Intent(mContext.getActivity(), PersonalLoanDetailActivity.class));
                            break;
                        case 6:
                            //lap
                            mContext.startActivity(new Intent(mContext.getActivity(), LapLoanDetailActivity.class));
                            break;
                        case 7:
                            //cc
                            break;
                        case 8:
                            //BT
                            mContext.startActivity(new Intent(mContext.getActivity(), BalanceTransferDetailActivity.class));
                            break;
                        case 9:
                            //Other loan
                            break;
                        case 2:
                            //fin peace
                            break;
                        case 11:
                            //health check up
                            break;
                        default:
                            Toast.makeText(mContext.getContext(), "Work in progress", Toast.LENGTH_SHORT).show();
                            break;

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