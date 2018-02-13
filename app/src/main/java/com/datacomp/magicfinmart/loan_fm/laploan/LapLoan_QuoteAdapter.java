package com.datacomp.magicfinmart.loan_fm.laploan;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;

/**
 * Created by IN-RB on 22-01-2018.
 */

public class LapLoan_QuoteAdapter extends RecyclerView.Adapter<LapLoan_QuoteAdapter.QuoteItem> {
    Fragment mFrament;
    List<FmHomeLoanRequest> mQuoteList;


    public LapLoan_QuoteAdapter(Fragment mFrament, List<FmHomeLoanRequest> mQuoteList) {
        this.mFrament = mFrament;
        this.mQuoteList = mQuoteList;
    }
    @Override
    public QuoteItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_quote_loan, parent, false);
        return new LapLoan_QuoteAdapter.QuoteItem(itemView);
    }

    @Override
    public void onBindViewHolder(LapLoan_QuoteAdapter.QuoteItem holder, int position) {


        if (holder instanceof LapLoan_QuoteAdapter.QuoteItem) {
            final FmHomeLoanRequest entity = mQuoteList.get(position);

            holder.txtPersonName.setText(""+ entity.getHomeLoanRequest().getApplicantNme());
            holder.txtQuoteDate.setText("" + entity.getHomeLoanRequest().getRow_created_date().split("T")[0].toString());

            holder.txtloanamount.setText("" + entity.getHomeLoanRequest().getPropertyCost());



        }
    }


    public class QuoteItem extends RecyclerView.ViewHolder {

        public TextView txtPersonName,  txtOverflowMenu,  txtloanamount , txtQuoteDate;


        public QuoteItem(View itemView) {
            super(itemView);
            txtQuoteDate = (TextView) itemView.findViewById(R.id.txtQuoteDate);
            txtloanamount = (TextView) itemView.findViewById(R.id.txtloanamount);
            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);
        }
    }

    @Override
    public int getItemCount() {
        return mQuoteList.size();
    }
}
