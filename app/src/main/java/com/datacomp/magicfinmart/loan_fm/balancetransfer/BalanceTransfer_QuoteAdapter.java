package com.datacomp.magicfinmart.loan_fm.balancetransfer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.PopupMenu;

import com.datacomp.magicfinmart.R;

/**
 * Created by IN-RB on 26-01-2018.
 */

public class BalanceTransfer_QuoteAdapter extends RecyclerView.Adapter<BalanceTransfer_QuoteAdapter.QuoteItem> {

    Context context;

    public BalanceTransfer_QuoteAdapter(Context context) {
        this.context = context;
    }

    @Override
    public QuoteItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_quote_bl, parent, false);
        return new BalanceTransfer_QuoteAdapter.QuoteItem(itemView);
    }

    @Override
    public void onBindViewHolder(QuoteItem holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class QuoteItem extends RecyclerView.ViewHolder {

        public CheckBox chkAddon;

        public QuoteItem(View itemView) {
            super(itemView);
        }
    }
}
