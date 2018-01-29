package com.datacomp.magicfinmart.loan_fm.laploan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.datacomp.magicfinmart.R;

/**
 * Created by IN-RB on 22-01-2018.
 */

public class LapLoan_QuoteAdapter extends RecyclerView.Adapter<LapLoan_QuoteAdapter.QuoteItem> {
    Context context;


    public LapLoan_QuoteAdapter(Context context) {
        this.context = context;
    }
    @Override
    public QuoteItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_quote_loan, parent, false);
        return new LapLoan_QuoteAdapter.QuoteItem(itemView);
    }

    @Override
    public void onBindViewHolder(LapLoan_QuoteAdapter.QuoteItem holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }
    public class QuoteItem extends RecyclerView.ViewHolder {

        //   public ImageView ivTripleDot;
        public CheckBox chkAddon;


        public QuoteItem(View itemView) {
            super(itemView);
            //ivTripleDot = (ImageView) itemView.findViewById(R.id.ivTripleDot);
        }
    }
}
