package com.datacomp.magicfinmart.loan_fm.balancetransfer.addquote;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BLEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.BLSavingEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BLLoanRequest;

/**
 * Created by IN-RB on 27-01-2018.
 */

public class BLQuoteAdapter extends RecyclerView.Adapter<BLQuoteAdapter.PLQuotesItem> {

    Activity mContext;
    List<BLEntity> quoteEntities;

    BLLoanRequest blLoanRequest;

    public BLQuoteAdapter(Activity context, List<BLEntity> quoteEntities,BLLoanRequest blLoanRequest) {
        mContext = context;
        this.quoteEntities = quoteEntities;

        this.blLoanRequest = blLoanRequest;
    }

    public class PLQuotesItem extends RecyclerView.ViewHolder {

        TextView tvLoanAmt, tvBestRate, tvBankName, tvpf,tvpf_type, tvLoanTenure, tvProcessingFee, btnApply,tvEligibleLoan;
        ImageView ivBankLogo;

        public PLQuotesItem(View view) {
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
    public BLQuoteAdapter.PLQuotesItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_bl_quote_item, parent, false);
        return new BLQuoteAdapter.PLQuotesItem(view);

    }

    @Override
    public void onBindViewHolder(BLQuoteAdapter.PLQuotesItem holder, final int position) {

        final BLEntity quoteEntity = quoteEntities.get(position);
        holder.tvLoanAmt.setText("" + "\u20B9" + " "+ blLoanRequest.getLoanamount());

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


        holder.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   ((BLMainActivity) mContext).redirectToApplyLoan(quoteEntity,blLoanRequest,0);

            }
        });


    }

    @Override
    public int getItemCount() {
        return quoteEntities.size();
    }

}
