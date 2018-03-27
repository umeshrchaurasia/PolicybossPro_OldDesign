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
import com.datacomp.magicfinmart.creditcard.AppliedCreditListActivity;
import com.datacomp.magicfinmart.health.HealthQuoteAppActivity;
import com.datacomp.magicfinmart.healthcheckupplans.HealthCheckUpPlansActivity;
import com.datacomp.magicfinmart.lifeinsurance.LifeDetailActivity;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.BalanceTransferDetailActivity;
import com.datacomp.magicfinmart.loan_fm.homeloan.HomeLoanDetailActivity;
import com.datacomp.magicfinmart.loan_fm.laploan.LapLoanDetailActivity;
import com.datacomp.magicfinmart.loan_fm.personalloan.PersonalLoanDetailActivity;
import com.datacomp.magicfinmart.motor.privatecar.activity.PrivateCarDetailActivity;
import com.datacomp.magicfinmart.motor.twowheeler.activity.TwoWheelerQuoteAppActivity;
import com.datacomp.magicfinmart.quicklead.QuickLeadActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.tracking.TrackingController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TrackingData;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TrackingRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity;

public class DashboardItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Fragment mContext;
    List<DashboardEntity> listInsur;
    DBPersistanceController dbPersistanceController;
    int fbaId = 0;

    public DashboardItemAdapter(Fragment context, List<DashboardEntity> list) {
        mContext = context;
        listInsur = list;
        dbPersistanceController = new DBPersistanceController(mContext.getActivity());
        if (dbPersistanceController.getUserData().getFBAId() != 0) {
            fbaId = dbPersistanceController.getUserData().getFBAId();
        }
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
                            new TrackingController(mContext.getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Motor insurance tab on home page"), Constants.PRIVATE_CAR), null);
                            break;
                        case 10:
                            //bike
                            //Toast.makeText(mContext.getContext(), "WIP.", Toast.LENGTH_SHORT).show();
                            mContext.startActivity(new Intent(mContext.getActivity(), TwoWheelerQuoteAppActivity.class));
                            new TrackingController(mContext.getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Two Wheeler tab on home page"), Constants.TWO_WHEELER), null);
                            break;
                        case 3:
                            //health
                            mContext.startActivity(new Intent(mContext.getActivity(), HealthQuoteAppActivity.class));
                            new TrackingController(mContext.getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Health insurance tab on home page"), Constants.HEALTH_INS), null);
                            break;
                        case 4:
                            //home loan
                            mContext.startActivity(new Intent(mContext.getActivity(), HomeLoanDetailActivity.class));
                            new TrackingController(mContext.getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Home Loan tab on home page"), Constants.HOME_LOAN), null);
                            break;
                        case 5:
                            //personal loan
                            mContext.startActivity(new Intent(mContext.getActivity(), PersonalLoanDetailActivity.class));
                            new TrackingController(mContext.getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Personal loan tab on home page"), Constants.PERSONA_LOAN), null);
                            break;
                        case 6:
                            //lap
                            mContext.startActivity(new Intent(mContext.getActivity(), LapLoanDetailActivity.class));
                            new TrackingController(mContext.getActivity()).sendData(new TrackingRequestEntity(new TrackingData("LAP tab on home page"), Constants.LAP), null);
                            break;
                        case 7:
                            //cc
                            // mContext.startActivity(new Intent(mContext.getActivity(), CreditCardMainActivity.class));
                            mContext.startActivity(new Intent(mContext.getActivity(), AppliedCreditListActivity.class));
                            new TrackingController(mContext.getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Credit Card tab on home page"), Constants.CREDIT_CARD), null);
                            break;
                        case 8:
                            //BT
                            mContext.startActivity(new Intent(mContext.getActivity(), BalanceTransferDetailActivity.class));
                            new TrackingController(mContext.getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Balance Transfer tab on home page"), Constants.BALANCE_TRANSFER), null);
                            break;
                        case 9:
                            //Other loan
//                            String brokerId = "";
//                            if (dbPersistanceController.getUserData().getLoanId() != null) {
//                                brokerId = dbPersistanceController.getUserData().getLoanId();
//                            }
//                            String source = "DC";
//                            mContext.startActivity(new Intent(mContext.getActivity(), CommonWebViewActivity.class)
//                                    .putExtra("URL", "http://www.rupeeboss.com/other-loans?brokerId=" + brokerId + "&Source=" + source)
//                                    .putExtra("NAME", "MAGIC FIN-MART")
//                                    .putExtra("TITLE", "MAGIC FIN-MART"));

                            mContext.startActivity(new Intent(mContext.getActivity(), QuickLeadActivity.class));
                            new TrackingController(mContext.getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Quick Lead tab on home page"), Constants.QUICK_LEAD), null);

                            break;
                        case 2:
                            //fin peace
                            mContext.startActivity(new Intent(mContext.getActivity(), CommonWebViewActivity.class)
                                    .putExtra("URL", "https://10oqcnw.finpeace.ind.in/app#/" + fbaId)
                                    .putExtra("NAME", "FIN-PEACE")
                                    .putExtra("TITLE", "FIN-PEACE"));
                            new TrackingController(mContext.getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Fin Peace tab on home page"), Constants.FIN_PEACE), null);
                            break;
                        case 11:
                            //health check up
                            mContext.startActivity(new Intent(mContext.getActivity(), HealthCheckUpPlansActivity.class));
                            new TrackingController(mContext.getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Health CheckUp"),  Constants.HEALTH_CHECKUP), null);
                            break;

                        case 12:
                            //Life Insurance
                            mContext.startActivity(new Intent(mContext.getActivity(), LifeDetailActivity.class));
                            new TrackingController(mContext.getActivity()).sendData(new TrackingRequestEntity(new TrackingData("Life insurance tab on home page"), Constants.LIFE_INS), null);
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