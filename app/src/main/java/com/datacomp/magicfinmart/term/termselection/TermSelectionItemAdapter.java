package com.datacomp.magicfinmart.term.termselection;

import android.content.Context;
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
import com.datacomp.magicfinmart.creditcard.AppliedCreditListActivity;
import com.datacomp.magicfinmart.health.HealthQuoteAppActivity;
import com.datacomp.magicfinmart.healthcheckupplans.HealthCheckUpPlansActivity;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.BalanceTransferDetailActivity;
import com.datacomp.magicfinmart.loan_fm.homeloan.HomeLoanDetailActivity;
import com.datacomp.magicfinmart.loan_fm.laploan.LapLoanDetailActivity;
import com.datacomp.magicfinmart.loan_fm.personalloan.PersonalLoanDetailActivity;
import com.datacomp.magicfinmart.motor.privatecar.activity.PrivateCarDetailActivity;
import com.datacomp.magicfinmart.motor.twowheeler.activity.TwoWheelerQuoteAppActivity;
import com.datacomp.magicfinmart.quicklead.QuickLeadActivity;
import com.datacomp.magicfinmart.term.TermQuoteApplicationActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.tracking.TrackingController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TrackingData;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TrackingRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity;
import magicfinmart.datacomp.com.finmartserviceapi.model.TermSelectionEntity;

public class TermSelectionItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    List<TermSelectionEntity> listInsur;

    public TermSelectionItemAdapter(Context context) {
        mContext = context;
        listInsur = new DBPersistanceController(mContext).getTermCompanyList();
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
                R.layout.layout_term_selection_item, parent, false);
        return new DashboardItemHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof DashboardItemHolder) {
            //((DashboardItemHolder) holder).imgIcon.setImageResource(listInsur.get(position).getIcon());
            ((DashboardItemHolder) holder).txtProductName.setText(listInsur.get(position).getCompanyName());
            ((DashboardItemHolder) holder).card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    switch (listInsur.get(position).getCompantID()) {
                        case 28: //HDFC
                            //car
                            mContext.startActivity(new Intent(mContext,TermQuoteApplicationActivity.class).putExtra("",28));
                            new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Term HDFC Selection"), Constants.LIFE_INS), null);
                            break;
                        case 39: //ICICI

                            new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Term ICICI Selection"), Constants.LIFE_INS), null);
                            break;
                        case 43: //Edelweiss
                            new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Term EDELWEISS Selection"), Constants.LIFE_INS), null);
                            break;

                        default:
                            Toast.makeText(mContext, "Work in progress", Toast.LENGTH_SHORT).show();
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