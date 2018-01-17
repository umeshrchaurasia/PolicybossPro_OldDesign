package com.datacomp.magicfinmart.dashboard;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity;


public class DashboardRowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //private static final int ROW_HEADER = 5;
    private static final int ROW_INSURANCE = 0;
    private static final int ROW_LOAN = 1;
    private static final int ROW_MORE_SERVICES = 2;
    private static int TOTAL_ROW = 3;
    Fragment mFragment;
    DBPersistanceController mReal;

    public DashboardRowAdapter(Fragment fragment) {
        mFragment = fragment;
        mReal = new DBPersistanceController(mFragment.getActivity());
    }

    public class HeaderRow extends RecyclerView.ViewHolder {
        public HeaderRow(View view) {
            super(view);
        }
    }

    public class InsuranceHolder extends RecyclerView.ViewHolder {
        RecyclerView rvDashboard;
        TextView txtTypeName;

        public InsuranceHolder(View view) {
            super(view);
            rvDashboard = (RecyclerView) view.findViewById(R.id.rvDashboard);
            txtTypeName = (TextView) view.findViewById(R.id.txtTypeName);
        }
    }

    public class LoanHolder extends RecyclerView.ViewHolder {
        RecyclerView rvDashboard;
        TextView txtTypeName;

        public LoanHolder(View view) {
            super(view);
            rvDashboard = (RecyclerView) view.findViewById(R.id.rvDashboard);
            txtTypeName = (TextView) view.findViewById(R.id.txtTypeName);
        }
    }

    public class MoreServiceHolder extends RecyclerView.ViewHolder {
        RecyclerView rvDashboard;
        TextView txtTypeName;

        public MoreServiceHolder(View view) {
            super(view);
            rvDashboard = (RecyclerView) view.findViewById(R.id.rvDashboard);
            txtTypeName = (TextView) view.findViewById(R.id.txtTypeName);
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeaderRow) {

        } else if (holder instanceof InsuranceHolder) {

            List<DashboardEntity> listIns = mReal.getInsurProductList();
            ((InsuranceHolder) holder).txtTypeName.setText("INSURANCE");
            ((InsuranceHolder) holder).rvDashboard.setLayoutManager(new LinearLayoutManager(mFragment.getActivity()));
            ((InsuranceHolder) holder).rvDashboard.setAdapter(new DashboardItemAdapter(mFragment, listIns));

        } else if (holder instanceof LoanHolder) {
            List<DashboardEntity> listLoan = mReal.getLoanProductList();
            ((LoanHolder) holder).txtTypeName.setText("LOAN");
            ((LoanHolder) holder).rvDashboard.setLayoutManager(new LinearLayoutManager(mFragment.getActivity()));
            ((LoanHolder) holder).rvDashboard.setAdapter(new DashboardItemAdapter(mFragment, listLoan));

        } else if (holder instanceof MoreServiceHolder) {
            List<DashboardEntity> listMore = mReal.getMoreProductList();
            ((MoreServiceHolder) holder).txtTypeName.setText("MORE SERVICE");
            ((MoreServiceHolder) holder).rvDashboard.setLayoutManager(new LinearLayoutManager(mFragment.getActivity()));
            ((MoreServiceHolder) holder).rvDashboard.setAdapter(new DashboardItemAdapter(mFragment, listMore));
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