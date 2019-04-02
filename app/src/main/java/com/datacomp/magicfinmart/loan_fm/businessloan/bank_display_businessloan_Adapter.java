package com.datacomp.magicfinmart.loan_fm.businessloan;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.personalloan.new_personalloan.bank_selection_personalloanActivity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.LstCityBankdetailEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.LstCitywiseBankLoanEntity;

/**
 * Created by IN-RB on 13-03-2019.
 */

public class bank_display_businessloan_Adapter extends RecyclerView.Adapter<bank_display_businessloan_Adapter.PLQuotesItem>{
    Activity mContext;
    List<LstCitywiseBankLoanEntity> quoteEntities;
    boolean isclick = false;

    //bank_display_personalloan.xml
    public bank_display_businessloan_Adapter(Activity mContext, List<LstCitywiseBankLoanEntity> quoteEntities) {
        this.mContext = mContext;
        this.quoteEntities = quoteEntities;
    }

    @Override
    public bank_display_businessloan_Adapter.PLQuotesItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.bank_display_personalloan,parent,false);
        return  new bank_display_businessloan_Adapter.PLQuotesItem(view);
    }

    @Override
    public void onBindViewHolder(final bank_display_businessloan_Adapter.PLQuotesItem holder, final int position) {
        final LstCitywiseBankLoanEntity quoteEntity1 = quoteEntities.get(position);
        LstCityBankdetailEntity quoteEntity;
        quoteEntity=quoteEntity1.getLstCityProdBank().get(0);
           //     = quoteEntity1.getLstCityProdBank();


        holder.tvsegment.setText(""+quoteEntity.getSeqment());
        holder.tvroi.setText(""+quoteEntity.getBest_ROI());
        holder.tvPer_Lac_EMI.setText(""+quoteEntity.getPer_Lac_EMI());
        holder.tvLoanAmount.setText(""+quoteEntity.getLoan_Amt());
        holder.tvTenure.setText(""+quoteEntity.getTenure());
        holder.tvAge.setText(""+quoteEntity.getAge());

        holder.tvminSalary.setText(""+quoteEntity.getMin_Salary());
        holder.tvWorkExperence.setText(""+quoteEntity.getMin_Work_Exp());
        holder.tvProcessingFees.setText(""+quoteEntity.getProcessing_Fees());
        holder.tvPrepayment.setText(""+quoteEntity.getPrepayment_charges());

        holder.tvCibilscore.setText(""+quoteEntity.getMin_Cibil_Score());
        holder.tvForeclosure.setText(""+quoteEntity.getForeclosure_charges());

        Glide.with(mContext)
                .load(quoteEntity1.getBank_URL())
                .into(holder.ivBankLogo);

        holder.rvhlknowmore.setVisibility(View.GONE);
        holder.ivArrow.setImageDrawable(mContext.getResources().getDrawable(R.drawable.down_arrow));
        holder.ivcloseArrow.setImageDrawable(mContext.getResources().getDrawable(R.drawable.down_arrow));

        holder.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((bank_selection_businessloanActivity)mContext).redirectToApplyBankBL(quoteEntity1);
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
    }

    @Override
    public int getItemCount() {
        return quoteEntities.size();
    }

    public class PLQuotesItem   extends RecyclerView.ViewHolder {
        TextView tvBankName, btnreadterm, btnApply,
                tvsegment, tvroi, tvPer_Lac_EMI,tvLoanAmount,
                tvTenure,tvAge,tvminSalary,tvWorkExperence,
                tvProcessingFees,tvPrepayment,tvCibilscore,tvForeclosure;
        ImageView ivBankLogo,ivArrow,ivcloseArrow;
        LinearLayout llbtnreadterms,llbtnApply,rvhlknowmore,llbacklist;

        public PLQuotesItem(View itemView) {
            super(itemView);

            tvCibilscore = (TextView) itemView.findViewById(R.id.tvCibilscore);
            tvForeclosure = (TextView) itemView.findViewById(R.id.tvForeclosure);
            tvBankName = (TextView) itemView.findViewById(R.id.tvBankName);
            btnreadterm = (TextView) itemView.findViewById(R.id.btnreadterm);
            tvBankName = (TextView) itemView.findViewById(R.id.tvBankName);
            btnApply = (TextView) itemView.findViewById(R.id.btnApply);
            tvsegment = (TextView) itemView.findViewById(R.id.tvsegment);
            tvroi = (TextView) itemView.findViewById(R.id.tvroi);
            tvPer_Lac_EMI = (TextView) itemView.findViewById(R.id.tvPer_Lac_EMI);

            tvLoanAmount =(TextView)itemView.findViewById(R.id.tvLoanAmount);
            tvTenure = (TextView) itemView.findViewById(R.id.tvTenure);
            tvAge = (TextView) itemView.findViewById(R.id.tvAge);
            tvminSalary = (TextView) itemView.findViewById(R.id.tvminSalary);
            tvWorkExperence = (TextView) itemView.findViewById(R.id.tvWorkExperence);
            tvProcessingFees = (TextView) itemView.findViewById(R.id.tvProcessingFees);
            tvPrepayment = (TextView) itemView.findViewById(R.id.tvPrepayment);

            ivBankLogo = (ImageView) itemView.findViewById(R.id.ivBankLogo);
            ivArrow = (ImageView) itemView.findViewById(R.id.ivArrow);
            ivcloseArrow = (ImageView) itemView.findViewById(R.id.ivcloseArrow);

            rvhlknowmore = (LinearLayout) itemView.findViewById(R.id.rvhlknowmore);


            llbtnreadterms = (LinearLayout) itemView.findViewById(R.id.llbtnreadterms);
            llbtnApply=(LinearLayout) itemView.findViewById(R.id.llbtnApply);
            llbacklist=(LinearLayout) itemView.findViewById(R.id.llbacklist);
        }
    }
}
