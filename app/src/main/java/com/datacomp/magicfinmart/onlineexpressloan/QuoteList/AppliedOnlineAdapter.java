package com.datacomp.magicfinmart.onlineexpressloan.QuoteList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;


import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.ExpressQuoteEntity;

/**
 * Created by IN-RB on 03-04-2018.
 */

public class AppliedOnlineAdapter extends RecyclerView.Adapter<AppliedOnlineAdapter.ViewHolder> implements Filterable {
    private LayoutInflater mInflater;
    Context mContext;
    List<ExpressQuoteEntity> listCreditCards;
    List<ExpressQuoteEntity> mCreditCardFiltered;

    // data is passed into the constructor
    AppliedOnlineAdapter(Context context, List<ExpressQuoteEntity> list) {
        mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        listCreditCards = list;
        mCreditCardFiltered = list;
    }


    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_applied_onlineadapter_item, parent, false);
        return new AppliedOnlineAdapter.ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(final AppliedOnlineAdapter.ViewHolder holder, final int position) {

        ExpressQuoteEntity entity = mCreditCardFiltered.get(position);

        AppliedOnlineAdapter.ViewHolder hold = (AppliedOnlineAdapter.ViewHolder) holder;


        hold.txtAppNo.setText(entity.getApplicationID());
        hold.txtBankName.setText(entity.getBank_Code());
        hold.txtCreditType.setText(entity.getFullName());
       // hold.txtEmail.setText(entity.get());
        hold.txtName.setText(entity.getFullName());
        hold.txtMobile.setText(entity.getMobileNo());
        hold.txtloantype.setText(entity.getLoanType());
    }

    public void refreshAdapter(List<ExpressQuoteEntity> list) {
        mCreditCardFiltered = list;
        notifyDataSetChanged();
    }

    // total number of cells
    @Override
    public int getItemCount() {
        if (mCreditCardFiltered != null)
            return mCreditCardFiltered.size();
        else
            return 0;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mCreditCardFiltered = listCreditCards;
                } else {
                    List<ExpressQuoteEntity> filerList = new ArrayList<>();

                    for (ExpressQuoteEntity row : listCreditCards) {
                        if (row.getFullName().toLowerCase().contains(charString.toLowerCase())
                                || row.getMobileNo().toLowerCase().contains(charString.toLowerCase())
                                || row.getApplicationID().toLowerCase().contains(charSequence.toString())) {
                            filerList.add(row);
                        }
                    }

                    mCreditCardFiltered = filerList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mCreditCardFiltered;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mCreditCardFiltered = (ArrayList<ExpressQuoteEntity>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtEmail, txtMobile, txtBankName, txtCreditType, txtAppNo, txtloantype;

        ViewHolder(View v) {
            super(v);
            txtName = (TextView) v.findViewById(R.id.txtName);
            txtEmail = (TextView) v.findViewById(R.id.txtEmail);
            txtMobile = (TextView) v.findViewById(R.id.txtMobile);
            txtBankName = (TextView) v.findViewById(R.id.txtBankName);
            txtCreditType = (TextView) v.findViewById(R.id.txtCreditType);
            txtAppNo = (TextView) v.findViewById(R.id.txtAppNo);
            txtloantype = (TextView) v.findViewById(R.id.txtloantype);
        }
    }

}
