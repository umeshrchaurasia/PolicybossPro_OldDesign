package com.datacomp.magicfinmart.creditcard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AppliedCreditCardEntity;

public class AppliedCreditCardsAdapter extends RecyclerView.Adapter<AppliedCreditCardsAdapter.ViewHolder> {


    private LayoutInflater mInflater;
    Context mContext;
    List<AppliedCreditCardEntity> listCreditCards;

    // data is passed into the constructor
    AppliedCreditCardsAdapter(Context context, List<AppliedCreditCardEntity> list) {
        mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        listCreditCards = list;
    }


    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_credit_card_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ViewHolder hold = (ViewHolder) holder;

    }


    // total number of cells
    @Override
    public int getItemCount() {
        return listCreditCards.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View v) {
            super(v);

        }
    }


}