package com.datacomp.magicfinmart.loan_fm.balancetransfer.addquote;

import android.app.Activity;
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

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BLEntity;


import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetBLDispalyResponse;

/**
 * Created by IN-RB on 27-01-2018.
 */

public class BLQuoteAdapter extends RecyclerView.Adapter<BLQuoteAdapter.BLQuotesItem> {

    Fragment mContext;
    List<BLEntity> quoteEntities;

    GetBLDispalyResponse getblDispalyResponse ;
    Double LoanAmount=0.0;

    public BLQuoteAdapter(Fragment context, List<BLEntity> quoteEntities,GetBLDispalyResponse tmpgetgetblDispalyResponse,Double loanAmount ) {
        mContext = context;
        this.quoteEntities = quoteEntities;
        getblDispalyResponse = tmpgetgetblDispalyResponse;
        LoanAmount=loanAmount;
    }

    public BLQuoteAdapter() {
    }

    public class BLQuotesItem extends RecyclerView.ViewHolder {

        TextView tvLoanAmt, tvBestRate, tvBankName, tvpf,tvpf_type, tvLoanTenure, tvProcessingFee, btnApply,tvEligibleLoan;
        ImageView ivBankLogo;

        public BLQuotesItem(View view) {
            super(view);
            tvLoanAmt = (TextView) itemView.findViewById(R.id.tvLoanAmt);
            tvBestRate = (TextView) itemView.findViewById(R.id.tvBestRate);
            tvBankName = (TextView) itemView.findViewById(R.id.tvBankName);
            tvpf = (TextView) itemView.findViewById(R.id.tvpf);
            tvpf_type = (TextView) itemView.findViewById(R.id.tvpf_type);
            tvLoanTenure = (TextView) itemView.findViewById(R.id.tvLoanTenure);
            tvProcessingFee = (TextView) itemView.findViewById(R.id.tvProcessingFee);
            btnApply = (TextView) itemView.findViewById(R.id.btnApply);
            ivBankLogo = (ImageView) itemView.findViewById(R.id.ivBankLogo);
           // ivedit = (ImageView) itemView.findViewById(R.id.ivEdit);
           // tvEligibleLoan =(TextView)itemView.findViewById(R.id.tvEligibleLoan);
        }
    }

    @Override
    public BLQuoteAdapter.BLQuotesItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_bl_quote_item, parent, false);
        return new BLQuoteAdapter.BLQuotesItem(view);

    }

    @Override
    public void onBindViewHolder(BLQuoteAdapter.BLQuotesItem holder, final int position) {

        final BLEntity quoteEntity = quoteEntities.get(position);
        try {
        holder.tvLoanAmt.setText("" + "\u20B9" + " "+  BigDecimal.valueOf(Math.ceil(LoanAmount)).setScale(0, BigDecimal.ROUND_HALF_UP) );

       // textViewloanemi.setText("" + "\u20B9" + BigDecimal.valueOf(((EmiCalculatorResponse)response).getData().getAmount()).toPlainString());
        holder.tvBestRate.setText(""+ "\u20B9"+ " " + quoteEntity.getRoi() +" %");
        holder.tvBankName.setText("" + quoteEntity.getBank_Code());
        holder.tvpf.setText("" + quoteEntity.getPf());
        holder.tvpf_type.setText("" + quoteEntity.getPf_type());
        holder.tvProcessingFee.setText("" + "\u20B9" + " "+quoteEntity.getProcessingfee());
        //holder.tvEligibleLoan.setText(""+quoteEntity.getLoan_eligible());
        Glide.with(mContext)
                .load(quoteEntity.getBank_Logo())
                .into(holder.ivBankLogo);
        //change Fresco
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((QuoteFragment_bl) mContext).redirectToApplyBank(quoteEntity);
                //quote to app conversion
                //((QuoteFragment_bl) mContext).quoteToApp();
               // ((QuoteFragment_bl) mContext).redirectToApplyLoan(quoteEntity,getblDispalyResponse.getUrl(), getblDispalyResponse.getQuote_id());


            }
        });
//

    }

    @Override
    public int getItemCount() {
        return quoteEntities.size();
    }

}
