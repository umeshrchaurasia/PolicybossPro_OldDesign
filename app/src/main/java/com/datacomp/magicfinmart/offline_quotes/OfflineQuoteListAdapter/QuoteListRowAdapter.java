package com.datacomp.magicfinmart.offline_quotes.OfflineQuoteListAdapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.dashboard.DashboardRowAdapter;
import com.datacomp.magicfinmart.offline_quotes.OfflineQuotesListActivity;
import com.datacomp.magicfinmart.utility.RecyclerItemClickListener;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.OfflineQuoteEntity;

/**
 * Created by IN-RB on 09-11-2018.
 */

public class QuoteListRowAdapter extends RecyclerView.Adapter<QuoteListRowAdapter.ListHolder> {


    Activity mContext;
    List<OfflineQuoteEntity> offlineQuoteList;

    public QuoteListRowAdapter(Activity mContext, List<OfflineQuoteEntity> offlineQuoteList) {
        this.mContext = mContext;
        this.offlineQuoteList = offlineQuoteList;
    }

    public class ListHolder extends RecyclerView.ViewHolder {
        RecyclerView rvOfflineItem ;
        TextView txtProductName , txtProductDesc , txtDate;
        public LinearLayout ivllEdit;
        public CardView card_view;
        public ListHolder(View view) {
            super(view);
            rvOfflineItem = (RecyclerView) view.findViewById(R.id.rvOfflineItem);
            txtProductName = (TextView) view.findViewById(R.id.txtProductName);
            txtProductDesc = (TextView) view.findViewById(R.id.txtProductDesc);
            txtDate =   (TextView) view.findViewById(R.id.txtDate);
            ivllEdit = (LinearLayout)itemView.findViewById(R.id.ivllEdit);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
        }
    }



    @Override
    public QuoteListRowAdapter.ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_offiline_recycler, parent, false);
        return new QuoteListRowAdapter.ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        final OfflineQuoteEntity quoteEntity = offlineQuoteList.get(position);
        try {
            ((ListHolder) holder).txtProductName.setText("" + quoteEntity.getProduct_name());
            ((ListHolder) holder).txtDate.setText("" + quoteEntity.getCreated_date());
            ((ListHolder) holder).txtProductDesc.setText("" + quoteEntity.getQuote_description());

            ((ListHolder) holder).rvOfflineItem.setLayoutManager(new LinearLayoutManager(mContext));
            ((ListHolder) holder).rvOfflineItem.setAdapter(new OfflineListItemAdapter(mContext, quoteEntity.getDocuments()));

            if(quoteEntity.getEditable().equals("1") ){
                ((ListHolder) holder).ivllEdit.setVisibility(View.VISIBLE);
            }else
            {
                ((ListHolder) holder).ivllEdit.setVisibility(View.GONE);
            }

            holder.card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(quoteEntity.getEditable().equals("1") ){
                        ((OfflineQuotesListActivity) mContext).redirectToEdit(quoteEntity);
                    }
                }
            });
            holder.ivllEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(quoteEntity.getEditable().equals("1") ){
                        ((OfflineQuotesListActivity) mContext).redirectToEdit(quoteEntity);
                    }
                }
            });
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }




    @Override
    public int getItemCount() {
        return offlineQuoteList.size();
    }
}
