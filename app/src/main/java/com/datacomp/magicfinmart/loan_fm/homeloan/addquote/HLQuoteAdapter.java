package com.datacomp.magicfinmart.loan_fm.homeloan.addquote;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
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
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetQuoteResponse;

/**
 * Created by IN-RB on 19-01-2018.
 */

public class HLQuoteAdapter extends RecyclerView.Adapter<HLQuoteAdapter.BankQuotesItem> {
    Fragment mContext;
    List<QuoteEntity> quoteEntities;
    GetQuoteResponse getQuoteResponse;

    public HLQuoteAdapter(Fragment context, List<QuoteEntity> quoteEntities, GetQuoteResponse tmpgetQuoteResponse) {
        mContext = context;
        this.quoteEntities = quoteEntities;
        this.getQuoteResponse = tmpgetQuoteResponse;
    }

    public class BankQuotesItem extends RecyclerView.ViewHolder {

        TextView tvLoanAmt, tvBestRate, tvBankName, tvBestEmi, tvLoanTenure, tvProcessingFee, btnApply, tvEligibleLoan, tvEmiperlac;
        ImageView ivBankLogo;

        public BankQuotesItem(View view) {
            super(view);
            tvEligibleLoan = (TextView) itemView.findViewById(R.id.tvEligibleLoan);
            tvBestRate = (TextView) itemView.findViewById(R.id.tvBestRate);
            tvBankName = (TextView) itemView.findViewById(R.id.tvBankName);
            tvBestEmi = (TextView) itemView.findViewById(R.id.tvBestEmi);
            tvLoanTenure = (TextView) itemView.findViewById(R.id.tvLoanTenure);
            tvProcessingFee = (TextView) itemView.findViewById(R.id.tvProcessingFee);
            btnApply = (TextView) itemView.findViewById(R.id.btnApply);
            ivBankLogo = (ImageView) itemView.findViewById(R.id.ivBankLogo);
            //  ivInfo = (ImageView) itemView.findViewById(R.id.ivInfo);
            tvEmiperlac = (TextView) itemView.findViewById(R.id.tvEmiperlac);
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
        holder.tvEligibleLoan.setText("" + "\u20B9" + " " + String.format("%.0f", quoteEntity.getLoan_eligible()));
        holder.tvBestRate.setText("" + quoteEntity.getRoi() + " %");
        holder.tvBankName.setText("" + quoteEntity.getBank_Code());
        holder.tvBestEmi.setText("" + "\u20B9" + " " + String.format("%.0f", quoteEntity.getEmi()));
        holder.tvLoanTenure.setText("" + quoteEntity.getLoanTenure() + " Years");
        holder.tvProcessingFee.setText("" + "\u20B9" + " " + String.format("%.0f", quoteEntity.getProcessingfee()));

        double loanr = Double.parseDouble(quoteEntity.getLoanRequired().toString());
        double emiperlac = (quoteEntity.getEmi() / loanr) * 100000;
        holder.tvEmiperlac.setText("" + "\u20B9" + " " + String.format("%.2f", emiperlac));

        Glide.with(mContext)
                .load(quoteEntity.getBank_Logo())
                .into(holder.ivBankLogo);
        //change Fresco


        holder.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //quote to app conversion
                ((QuoteFragment_hl) mContext).quoteToApp();

                //redirect to apply loan
                ((QuoteFragment_hl) mContext).redirectToApplyLoan(quoteEntity, getQuoteResponse.getUrl(), getQuoteResponse.getQuote_id());

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
