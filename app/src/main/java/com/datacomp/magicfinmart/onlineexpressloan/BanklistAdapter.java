package com.datacomp.magicfinmart.onlineexpressloan;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.creditcard.CreditCardActivity;
import com.datacomp.magicfinmart.creditcard.CreditCardsAdapter;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.ExpressLoanEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.PersonalLoanEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.ShortTermPersonalLoanEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CreditCardEntity;

/**
 * Created by IN-RB on 04-04-2018.
 */

public class BanklistAdapter   extends RecyclerView.Adapter<BanklistAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    Context mContext;
    List<ExpressLoanEntity> listCreditCards;

    public BanklistAdapter(Context context, List<ExpressLoanEntity> list) {
        mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        listCreditCards = list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_banlist_onlineexp_item, parent, false);
        return new BanklistAdapter.ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ViewHolder hold = (ViewHolder) holder;
        final ExpressLoanEntity entity = listCreditCards.get(position);

        List<PersonalLoanEntity> personalLoanEntityList = entity.getPersonalLoan();
        List<ShortTermPersonalLoanEntity> shortTermPersonalLoanEntityList = entity.getShortTermPersonalLoan();


//
//        hold.txtbankName.setText("" + entity.getPersonalLoan().get(0).getBank_Name());
//        hold.txtCardType.setText(entity.getCreditCardType());
//        if (entity.getDisplaycardname() == null) {
//            hold.txtDisplayCardName.setVisibility(View.GONE);
//        } else {
//            hold.txtDisplayCardName.setVisibility(View.VISIBLE);
//            hold.txtDisplayCardName.setText(entity.getDisplaycardname());
//        }
//        if (entity.getImagePath() != null) {
//            Glide.with(mContext).load(entity.getImagePath()).into(hold.imgCard);
//        }
//
//        String desc[] = entity.getDescription().split("\\|");
//        final StringBuilder sb = new StringBuilder();
//        for (String s : desc) {
//            sb.append("*  " + s.trim() + "\n");
//        }
//        hold.txtCCDesc.setText("" + sb.toString());
//
//        hold.btnInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialogMessage(sb.toString(), entity.getDisplaycardname());
//            }
//        });
//
//        hold.btnApply.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((CreditCardActivity) mContext).redirectToApply(entity);
//            }
//        });
    }



    @Override
    public int getItemCount() {
        return listCreditCards.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtbankName, txtCardType;
        ImageView imgCard;
        CardView cvCCItem;
        Button btnApply, btnInfo;

        ViewHolder(View v) {
            super(v);
            txtbankName = (TextView) v.findViewById(R.id.txtbankName);
            txtCardType = (TextView) v.findViewById(R.id.txtCardType);

            imgCard = (ImageView) v.findViewById(R.id.imgCard);

            btnInfo = (Button) v.findViewById(R.id.btnInfo);
            btnApply = (Button) v.findViewById(R.id.btnApply);

        }
    }

    public void refreshCreditCards(List<ExpressLoanEntity> list) {
        listCreditCards = list;
        notifyDataSetChanged();
    }

    private void dialogMessage(String displayMessage, String cardType) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setCancelable(true);
        builder.setTitle(cardType);

        builder.setMessage(displayMessage)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();

                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
        TextView msgTxt = (TextView) dialog.findViewById(android.R.id.message);
        msgTxt.setTextSize(12.0f);
    }
}