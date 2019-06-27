package com.datacomp.magicfinmart.dashboard;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.MyApplication;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.creditcard.AppliedCreditListActivity;
import com.datacomp.magicfinmart.health.HealthQuoteAppActivity;
import com.datacomp.magicfinmart.healthcheckupplans.HealthCheckUpListActivity;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.BalanceTransferDetailActivity;
import com.datacomp.magicfinmart.loan_fm.businessloan.NewbusinessApplicaionActivity;
import com.datacomp.magicfinmart.loan_fm.homeloan.HomeLoanDetailActivity;
import com.datacomp.magicfinmart.loan_fm.homeloan.new_HomeLoan.NewHomeApplicaionActivity;
import com.datacomp.magicfinmart.loan_fm.homeloan.new_HomeLoan.city_selecton_homeloan_Activity;
import com.datacomp.magicfinmart.loan_fm.laploan.LapLoanDetailActivity;
import com.datacomp.magicfinmart.loan_fm.laploan.newlaploan.NewLAPApplicaionActivity;
import com.datacomp.magicfinmart.loan_fm.personalloan.PersonalLoanDetailActivity;
import com.datacomp.magicfinmart.loan_fm.personalloan.new_personalloan.NewPersonalApplicaionActivity;
import com.datacomp.magicfinmart.motor.privatecar.activity.PrivateCarDetailActivity;
import com.datacomp.magicfinmart.motor.twowheeler.activity.TwoWheelerQuoteAppActivity;
import com.datacomp.magicfinmart.ncd.NCDActivity;
import com.datacomp.magicfinmart.offline_quotes.AddNewOfflineQuotesActivity;
import com.datacomp.magicfinmart.offline_quotes.OfflineQuotesListActivity;
import com.datacomp.magicfinmart.quicklead.QuickLeadActivity;
import com.datacomp.magicfinmart.term.termselection.TermSelectionActivity;
import com.datacomp.magicfinmart.ultralaksha.ultra_selection.UltraLakshaSelectionActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.RecyclerItemClickListener;
import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.tracking.TrackingController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TrackingData;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TrackingRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity;


public class DashboardRowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //private static final int ROW_HEADER = 5;
    private static final int ROW_INSURANCE = 0;
    private static final int ROW_LOAN = 1;
    private static final int ROW_MORE_SERVICES = 2;
    private static int TOTAL_ROW = 3;
    Fragment mFragment;
    DBPersistanceController mReal;
    Context mContext;

    public DashboardRowAdapter(Fragment fragment) {
        mFragment = fragment;
        mContext = mFragment.getActivity();
        mReal = new DBPersistanceController(mFragment.getActivity());
    }

    public class HeaderRow extends RecyclerView.ViewHolder {
        public HeaderRow(View view) {
            super(view);
        }
    }

    public class InsuranceHolder extends RecyclerView.ViewHolder {
        RecyclerView rvDashboard;
        TextView txtTypeName, tvPoweredBy;
        ImageView ivLogo;

        public InsuranceHolder(View view) {
            super(view);
            rvDashboard = (RecyclerView) view.findViewById(R.id.rvDashboard);
            txtTypeName = (TextView) view.findViewById(R.id.txtTypeName);
            ivLogo = view.findViewById(R.id.ivLogo);
            tvPoweredBy = view.findViewById(R.id.tvPoweredBy);
        }
    }

    public class LoanHolder extends RecyclerView.ViewHolder {
        RecyclerView rvDashboard;
        TextView txtTypeName, tvPoweredBy;
        ImageView ivLogo;

        public LoanHolder(View view) {
            super(view);
            rvDashboard = (RecyclerView) view.findViewById(R.id.rvDashboard);
            txtTypeName = (TextView) view.findViewById(R.id.txtTypeName);
            ivLogo = view.findViewById(R.id.ivLogo);
            tvPoweredBy = view.findViewById(R.id.tvPoweredBy);
        }
    }

    public class MoreServiceHolder extends RecyclerView.ViewHolder {
        RecyclerView rvDashboard;
        TextView txtTypeName, tvPoweredBy;
        ImageView ivLogo;
        CardView card_view;

        public MoreServiceHolder(View view) {
            super(view);
            rvDashboard = (RecyclerView) view.findViewById(R.id.rvDashboard);
            txtTypeName = (TextView) view.findViewById(R.id.txtTypeName);
            ivLogo = view.findViewById(R.id.ivLogo);
            tvPoweredBy = view.findViewById(R.id.tvPoweredBy);
            card_view = view.findViewById(R.id.card_view);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
//            case ROW_HEADER:
//                view = LayoutInflater.from(parent.getContext()).inflate(
//                        R.layout.layout_dashboard_header, parent, false);
//                return new HeaderRow(view);

            case ROW_INSURANCE:
                view = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.layout_dashboard_recycler, parent, false);
                return new InsuranceHolder(view);

            case ROW_LOAN:
                view = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.layout_dashboard_recycler, parent, false);
                return new LoanHolder(view);

            case ROW_MORE_SERVICES:
                view = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.layout_dashboard_recycler, parent, false);
                return new MoreServiceHolder(view);

            default:
                break;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof HeaderRow) {

        } else if (holder instanceof InsuranceHolder) {

            final List<DashboardEntity> listIns = mReal.getInsurProductList();
            ((InsuranceHolder) holder).txtTypeName.setText("INSURANCE");
            ((InsuranceHolder) holder).ivLogo.setImageDrawable(mContext.getResources().getDrawable(R.drawable.logo_policyboss1));
            ((InsuranceHolder) holder).rvDashboard.setLayoutManager(new LinearLayoutManager(mFragment.getActivity()));
            ((InsuranceHolder) holder).rvDashboard.setAdapter(new DashboardItemAdapter(mFragment, listIns));

            ((InsuranceHolder) holder).rvDashboard.addOnItemTouchListener(
                    new RecyclerItemClickListener(((InsuranceHolder) holder).rvDashboard,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    if (mReal.getUserConstantsData().getEnableInsuranceBusiness().equals("1")) {
                                        switchMenus(listIns.get(position));
                                    } else {
                                        Toast.makeText(mContext, "Your not authorize to sell Insurance..", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }));


        } else if (holder instanceof LoanHolder) {
            final List<DashboardEntity> listLoan = mReal.getLoanProductList();
            ((LoanHolder) holder).txtTypeName.setText("LOANS");
            ((LoanHolder) holder).ivLogo.setImageDrawable(mContext.getResources().getDrawable(R.drawable.logo_rupeeboss1));

            ((LoanHolder) holder).rvDashboard.setLayoutManager(new LinearLayoutManager(mFragment.getActivity()));
            ((LoanHolder) holder).rvDashboard.setAdapter(new DashboardItemAdapter(mFragment, listLoan));

            ((LoanHolder) holder).rvDashboard.addOnItemTouchListener(
                    new RecyclerItemClickListener(((LoanHolder) holder).rvDashboard,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    switchMenus(listLoan.get(position));
                                }
                            }));


        } else if (holder instanceof MoreServiceHolder) {

            final List<DashboardEntity> listMore = mReal.getMoreProductList();

            ((MoreServiceHolder) holder).txtTypeName.setText("MORE SERVICES");
            ((MoreServiceHolder) holder).tvPoweredBy.setVisibility(View.GONE);
            ((MoreServiceHolder) holder).ivLogo.setVisibility(View.GONE);
            ((MoreServiceHolder) holder).rvDashboard.setLayoutManager(new LinearLayoutManager(mFragment.getActivity()));
            ((MoreServiceHolder) holder).rvDashboard.setAdapter(new DashboardItemAdapter(mFragment, listMore));

            ((MoreServiceHolder) holder).rvDashboard.addOnItemTouchListener(
                    new RecyclerItemClickListener(((MoreServiceHolder) holder).rvDashboard,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    switchMenus(listMore.get(position));
                                }
                            }));

        }

    }

    private void switchMenus(DashboardEntity dashboardEntity) {
        int productID = dashboardEntity.getProductId();

        switch (productID) {


            case 1:

                //car
                mContext.startActivity(new Intent(mContext, PrivateCarDetailActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Motor insurance tab on home page"), Constants.PRIVATE_CAR), null);
                MyApplication.getInstance().trackEvent(Constants.PRIVATE_CAR, "Clicked", "Motor insurance tab on home page");
                break;


            case 2:
                //fin peace
                mContext.startActivity(new Intent(mContext, CommonWebViewActivity.class)
                        .putExtra("URL", "https://10oqcnw.finpeace.ind.in/app#/"
                                + mReal.getUserData().getFBAId())
                        .putExtra("NAME", "FIN-PEACE")
                        .putExtra("TITLE", "FIN-PEACE"));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Fin Peace tab on home page"), Constants.FIN_PEACE), null);
                MyApplication.getInstance().trackEvent(Constants.FIN_PEACE, "Clicked", "Fin Peace tab on home page");
                break;
            case 3:
                //health

                // mContext.startActivity(new Intent(mContext, HealthQuoteAppActivity.class));


                if (mReal.getConstantsData().getHealthappenable().equalsIgnoreCase("1")) {
                    mContext.startActivity(new Intent(mContext, HealthQuoteAppActivity.class));
                } else {

                    String healthUrl = mReal.getUserConstantsData().getHealthurl();
                    //String healthUrl = new DBPersistanceController(mContext).getUserConstantsData().getHealthurltemp();

                    String ipaddress = "0.0.0.0";
                    try {
                        ipaddress = Utility.getMacAddress(mContext);
                    } catch (Exception io) {
                        ipaddress = "0.0.0.0";
                    }

                    String append = "&ip_address=" + ipaddress
                            + "&app_version=" + Utility.getVersionName(mContext)
                            + "&device_id=" + Utility.getDeviceId(mContext);
                    healthUrl = healthUrl + append;

                    if (mReal.getConstantsData().getHealthThrowBrowser() != null &&
                            mReal.getConstantsData().getHealthThrowBrowser().equalsIgnoreCase("1")) {
                        Utility.loadWebViewUrlInBrowser(mContext, healthUrl);
                    } else {
                        mContext.startActivity(new Intent(mContext, CommonWebViewActivity.class)
                                .putExtra("URL", healthUrl)
                                .putExtra("NAME", "Health Insurance")
                                .putExtra("TITLE", "Health Insurance"));
                    }
                }


                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Health insurance tab on home page"), Constants.HEALTH_INS), null);
                MyApplication.getInstance().trackEvent(Constants.HEALTH_INS, "Clicked", "Health insurance tab on home page");
                break;
            case 7:
                //home loan
                mContext.startActivity(new Intent(mContext, NewHomeApplicaionActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Home Loan tab on home page"), Constants.HOME_LOAN), null);
                MyApplication.getInstance().trackEvent(Constants.HOME_LOAN, "Clicked", "Home Loan tab on home page");
                break;
            case 5:
                //personal loan
                mContext.startActivity(new Intent(mContext, NewPersonalApplicaionActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Personal loan tab on home page"), Constants.PERSONA_LOAN), null);
                MyApplication.getInstance().trackEvent(Constants.PERSONA_LOAN, "Clicked", "Personal loan tab on home page");
                break;
            case 8:
                //lap
                mContext.startActivity(new Intent(mContext, NewLAPApplicaionActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("LAP tab on home page"), Constants.LAP), null);
                MyApplication.getInstance().trackEvent(Constants.LAP, "Clicked", "LAP tab on home page");
                break;
            case 4:
                //cc
                // mContext.startActivity(new Intent(mContext, CreditCardMainActivity.class));
                mContext.startActivity(new Intent(mContext, AppliedCreditListActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Credit Card tab on home page"), Constants.CREDIT_CARD), null);
                MyApplication.getInstance().trackEvent(Constants.CREDIT_CARD, "Clicked", "Credit Card tab on home page");
                break;
            case 6:
                //BT
                //  mContext.startActivity(new Intent(mContext, BalanceTransferDetailActivity.class));
                mContext.startActivity(new Intent(mContext, NewbusinessApplicaionActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Business tab on home page"), Constants.BUSINESS_LOAN), null);
                MyApplication.getInstance().trackEvent(Constants.BUSINESS_LOAN, "Clicked", "Business tab on home page");
                break;
            case 9:

                mContext.startActivity(new Intent(mContext, QuickLeadActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Quick Lead tab on home page"), Constants.QUICK_LEAD), null);
                MyApplication.getInstance().trackEvent(Constants.QUICK_LEAD, "Clicked", "Quick Lead tab on home page");
                break;

            case 10:
                //bike
                //Toast.makeText(mContext.getContext(), "WIP.", Toast.LENGTH_SHORT).show();
                mContext.startActivity(new Intent(mContext, TwoWheelerQuoteAppActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Two Wheeler tab on home page"), Constants.TWO_WHEELER), null);
                MyApplication.getInstance().trackEvent(Constants.TWO_WHEELER, "Clicked", "Two Wheeler tab on home page");
                break;


            case 11:
                //health check up
                mContext.startActivity(new Intent(mContext, HealthCheckUpListActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Health CheckUp"), Constants.HEALTH_CHECKUP), null);
                MyApplication.getInstance().trackEvent(Constants.HEALTH_CHECKUP, "Clicked", "Health CheckUp tab on home page");
                break;

            case 12:
                //Life Insurance
                mContext.startActivity(new Intent(mContext, TermSelectionActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Life insurance tab on home page"), Constants.LIFE_INS), null);
                MyApplication.getInstance().trackEvent(Constants.LIFE_INS, "Clicked", "Life insurance tab on home page");
                break;

            case 13:
                Utility.loadWebViewUrlInBrowser(mContext,
                        "http://www.rupeeboss.com/equifax-finmart?fbaid="
                                + String.valueOf(mReal.getUserData().getFBAId()));
                break;


            case 14:
                Utility.loadWebViewUrlInBrowser(mContext,
                        "https://yesbankbot.buildquickbots.com/chat/rupeeboss/staff/?userid=" + String.valueOf(mReal.getUserData().getFBAId()) + "&usertype=FBA&vkey=b34f02e9-8f1c");
               /* mContext.startActivity(new Intent(mContext, CommonWebViewActivity.class)
                        .putExtra(                break;
"URL", "https://yesbankbot.buildquickbots.com/chat/rupeeboss/staff/?userid=" + String.valueOf(mReal.getUserData().getFBAId()) + "&usertype=FBA&vkey=b34f02e9-8f1c")
                        .putExtra("NAME", "" + "Loan On Messenger")
                        .putExtra("TITLE", "" + "Loan On Messenger"));*/

            case 15: //ncd
                //car
                mContext.startActivity(new Intent(mContext, NCDActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Campaign "), Constants.CAMPAIGN), null);
                MyApplication.getInstance().trackEvent(Constants.CAMPAIGN, "Clicked", "CAMPAIGN");

                break;
            case 16:
                mContext.startActivity(new Intent(mContext, AddNewOfflineQuotesActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Offline quote "), Constants.CAMPAIGN), null);
                MyApplication.getInstance().trackEvent(Constants.OFFLINE, "Clicked", "OFFLINE");
                break;

            case 17: // added by Nilesh 13.02.2019 -- Ultra laksh
                mContext.startActivity(new Intent(mContext, UltraLakshaSelectionActivity.class));
                new TrackingController(mContext).sendData(new TrackingRequestEntity(new TrackingData("Ultra lakshya"), Constants.CAMPAIGN), null);
                MyApplication.getInstance().trackEvent(Constants.ULTRA_LAKSHA, "Clicked", "ULTRA_LAKSHYA");
                break;


        }

        if (productID >= 20) {
            mContext.startActivity(new Intent(mContext, CommonWebViewActivity.class)
                    .putExtra("URL", "" + dashboardEntity.getLink())
                    .putExtra("NAME", "" + dashboardEntity.getProductName())
                    .putExtra("TITLE", "" + dashboardEntity.getProductName()));
        }
    }

    @Override
    public int getItemCount() {
        return TOTAL_ROW;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            //  case ROW_HEADER:
            //      return ROW_HEADER;
            case ROW_INSURANCE:
                return ROW_INSURANCE;
            case ROW_LOAN:
                return ROW_LOAN;
            case ROW_MORE_SERVICES:
                return ROW_MORE_SERVICES;
            default:
                break;
        }
        return position;
    }


}