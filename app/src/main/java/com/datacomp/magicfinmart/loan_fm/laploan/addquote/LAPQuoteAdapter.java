package com.datacomp.magicfinmart.loan_fm.laploan.addquote;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;

import java.math.BigDecimal;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.QuoteEntity;

/**
 * Created by IN-RB on 25-01-2018.
 */

public class LAPQuoteAdapter extends RecyclerView.Adapter<LAPQuoteAdapter.BankQuotesItem>  {

    Activity mContext;
    List<QuoteEntity> quoteEntities;

    public LAPQuoteAdapter(Activity context, List<QuoteEntity> quoteEntities) {
        mContext = context;
        this.quoteEntities = quoteEntities;
    }

    public class BankQuotesItem extends RecyclerView.ViewHolder {

        TextView tvLoanAmt, tvBestRate, tvBankName, tvBestEmi, tvLoanTenure, tvProcessingFee, btnApply, tvEligibleLoan;
        ImageView ivBankLogo, ivInfo;

        public BankQuotesItem(View view) {
            super(view);
            tvLoanAmt = (TextView) itemView.findViewById(R.id.tvLoanAmt);
            tvBestRate = (TextView) itemView.findViewById(R.id.tvBestRate);
            tvBankName = (TextView) itemView.findViewById(R.id.tvBankName);
            tvBestEmi = (TextView) itemView.findViewById(R.id.tvBestEmi);
            tvLoanTenure = (TextView) itemView.findViewById(R.id.tvLoanTenure);
            tvProcessingFee = (TextView) itemView.findViewById(R.id.tvProcessingFee);
            btnApply = (TextView) itemView.findViewById(R.id.btnApply);
            ivBankLogo = (ImageView) itemView.findViewById(R.id.ivBankLogo);
            ivInfo = (ImageView) itemView.findViewById(R.id.ivInfo);
            tvEligibleLoan = (TextView) itemView.findViewById(R.id.tvEligibleLoan);
        }
    }

    @Override
    public BankQuotesItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_quotes_hl_item, parent, false);
        return new BankQuotesItem(view);

    }

    @Override
    public void onBindViewHolder(BankQuotesItem holder, final int position) {

        final QuoteEntity quoteEntity = quoteEntities.get(position);
        holder.tvLoanAmt.setText("" + quoteEntity.getLoanRequired());
        holder.tvBestRate.setText("" + quoteEntity.getRoi());
        holder.tvBankName.setText("" + quoteEntity.getBank_Name());
        holder.tvBestEmi.setText("" + quoteEntity.getEmi());
        holder.tvLoanTenure.setText("" + quoteEntity.getLoanTenure());
        holder.tvProcessingFee.setText("" + quoteEntity.getProcessingfee());
        holder.tvEligibleLoan.setText("" + BigDecimal.valueOf(quoteEntity.getLoan_eligible()).toPlainString());
        Glide.with(mContext)
                .load(quoteEntity.getBank_Logo())
                .into(holder.ivBankLogo);
        //change Fresco


        holder.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((LapLoanQuoteActivity) mContext).redirectToApplyLoan(quoteEntity);

            }
        });
//        holder.ivInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mContext.startActivity(new Intent(mContext, QuoteInfoActivity.class).putExtra("QUOTEINFO", quoteEntity));
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return quoteEntities.size();
    }

}
