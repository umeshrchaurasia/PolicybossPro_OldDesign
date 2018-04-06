package com.datacomp.magicfinmart.onlineexpressloan.BankLoanListAdapter;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.ExpressLoanEntity;

/**
 * Created by IN-RB on 05-04-2018.
 */

public class ExpressBankRowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int ROW_PERSONAL = 0;
    private static final int ROW_STPERSONAL = 1;
    private static int TOTAL_ROW = 2;

    Activity mContext;
    DBPersistanceController mReal;
    ExpressLoanEntity expressLoanEntity;


    public ExpressBankRowAdapter(Activity mContext, ExpressLoanEntity tempexpressLoanEntity) {
        this.mContext = mContext;

        this.expressLoanEntity = tempexpressLoanEntity;


    }


    public class PersonalHolder extends RecyclerView.ViewHolder{

        RecyclerView rvExpress;
        TextView txtTypeName;

        public PersonalHolder(View view) {
            super(view);

            rvExpress = (RecyclerView) view.findViewById(R.id.rvExpress);
            txtTypeName = (TextView) view.findViewById(R.id.txtTypeName);
        }
    }


    public class STPersonalHolder extends RecyclerView.ViewHolder{

        RecyclerView rvExpress;
        TextView txtTypeName;

        public STPersonalHolder(View view) {
            super(view);

            rvExpress = (RecyclerView) view.findViewById(R.id.rvExpress);
            txtTypeName = (TextView) view.findViewById(R.id.txtTypeName);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        switch (viewType){

            case ROW_PERSONAL:
                view = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.layout_express_recycler, parent, false);
                return new ExpressBankRowAdapter.PersonalHolder(view);

            case ROW_STPERSONAL:
                view = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.layout_express_recycler, parent, false);
                return new ExpressBankRowAdapter.STPersonalHolder(view);

            default:
                break;
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof PersonalHolder){

            ((ExpressBankRowAdapter.PersonalHolder) holder).txtTypeName.setText("PERSONAL LOAN");
            ((ExpressBankRowAdapter.PersonalHolder) holder).rvExpress.setLayoutManager(new LinearLayoutManager(mContext));
            ((ExpressBankRowAdapter.PersonalHolder) holder).rvExpress.setAdapter(new ExpressBankPersonalItemAdapter(mContext,expressLoanEntity.getPersonalLoan()));
        } else if(holder instanceof STPersonalHolder){


            ((ExpressBankRowAdapter.STPersonalHolder) holder).txtTypeName.setText("SHORT-PERSONAL LOAN");
            ((ExpressBankRowAdapter.STPersonalHolder) holder).rvExpress.setLayoutManager(new LinearLayoutManager(mContext));
            ((ExpressBankRowAdapter.STPersonalHolder) holder).rvExpress.setAdapter(new ExpressBankSTPersonalItemAdapter(mContext,expressLoanEntity.getShortTermPersonalLoan()));
        }

    }

    @Override
    public int getItemCount() {
        {
            return TOTAL_ROW;
        }
    }

    @Override
    public int getItemViewType(int position) {

        switch (position) {

            case ROW_PERSONAL:
                return ROW_PERSONAL;
            case ROW_STPERSONAL:
                return ROW_STPERSONAL;

            default:
                break;
        }
        return position;
    }
}
