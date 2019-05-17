package com.datacomp.magicfinmart.loan_fm.homeloan.new_HomeLoan;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;


import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.LstCityBankdetailEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.LstCitywiseBankLoanEntity;

/**
 * Created by IN-RB on 13-03-2019.
 */

public class bank_display_homeloan_Adapter extends RecyclerView.Adapter<bank_display_homeloan_Adapter.PLQuotesItem>{
    Activity mContext;
    List<LstCitywiseBankLoanEntity> quoteEntities;
    boolean isclick = false;
    bank_display_homeloanChild_Adapter mAdapter;

    //bank_display_personalloan.xml
    public bank_display_homeloan_Adapter(Activity mContext, List<LstCitywiseBankLoanEntity> quoteEntities) {
        this.mContext = mContext;
        this.quoteEntities = quoteEntities;
    }

    @Override
    public bank_display_homeloan_Adapter.PLQuotesItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.bank_display_homeloan,parent,false);
        return  new bank_display_homeloan_Adapter.PLQuotesItem(view);
    }

    @Override
    public void onBindViewHolder(final bank_display_homeloan_Adapter.PLQuotesItem holder, final int position) {
         final LstCitywiseBankLoanEntity quoteEntity1 = quoteEntities.get(position);
       // LstCityBankdetailEntity quoteEntity;
        //quoteEntity=quoteEntity1.getLstCityProdBank().get(0);


        Glide.with(mContext)
                .load(quoteEntity1.getBank_URL())
                .into(holder.ivBankLogo);

    //    holder.rvhlknowmore.setVisibility(View.GONE);
        holder.ivArrow.setImageDrawable(mContext.getResources().getDrawable(R.drawable.down_arrow));
        holder.ivcloseArrow.setImageDrawable(mContext.getResources().getDrawable(R.drawable.down_arrow));

        holder.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((bank_selection_homeloanActivity)mContext).redirectToApplyBank(quoteEntity1);
            }
        });
        holder.ivArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isclick)
                {
                    isclick=false;
                    holder.ivArrow.setImageDrawable(mContext.getResources().getDrawable(R.drawable.down_arrow));
                    holder.ivcloseArrow.setImageDrawable(mContext.getResources().getDrawable(R.drawable.down_arrow));

                    holder.rvhlknowmore.setVisibility(View.GONE);
                }else {
                    isclick=true;
                    holder.ivArrow.setImageDrawable(mContext.getResources().getDrawable(R.drawable.up_arrow));
                    holder.ivcloseArrow.setImageDrawable(mContext.getResources().getDrawable(R.drawable.up_arrow));

                    holder.rvhlknowmore.setVisibility(View.VISIBLE);
                }
            }
        });
        holder.llbacklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
               holder.ivArrow.performClick();
            }
        });
        holder.llbtnreadterms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.ivArrow.performClick();
            }
        });

        if(quoteEntity1.getLstCityProdBank().size() > 0) {
            holder.rvhomeloanQuotes.setLayoutManager(new LinearLayoutManager(mContext));
            mAdapter = new bank_display_homeloanChild_Adapter(mContext, quoteEntity1.getLstCityProdBank());
            holder.rvhomeloanQuotes.setAdapter(mAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return quoteEntities.size();
    }

    public class PLQuotesItem   extends RecyclerView.ViewHolder {
        TextView tvBankName, btnreadterm, btnApply;
        ImageView ivBankLogo,ivArrow,ivcloseArrow;
        LinearLayout llbtnreadterms,llbtnApply,rvhlknowmore,llbacklist;
        RecyclerView rvhomeloanQuotes;
        public PLQuotesItem(View itemView) {
            super(itemView);

            rvhomeloanQuotes = (RecyclerView) itemView.findViewById(R.id.rvhomeloanQuotes);

            ivBankLogo = (ImageView) itemView.findViewById(R.id.ivBankLogo);
            ivArrow = (ImageView) itemView.findViewById(R.id.ivArrow);
            ivcloseArrow = (ImageView) itemView.findViewById(R.id.ivcloseArrow);
            btnApply = (TextView) itemView.findViewById(R.id.btnApply);
            rvhlknowmore = (LinearLayout) itemView.findViewById(R.id.rvhlknowmore);
            llbtnreadterms = (LinearLayout) itemView.findViewById(R.id.llbtnreadterms);
            llbtnApply=(LinearLayout) itemView.findViewById(R.id.llbtnApply);
            llbacklist=(LinearLayout) itemView.findViewById(R.id.llbacklist);
        }
    }
}
