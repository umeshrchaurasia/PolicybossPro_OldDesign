package com.datacomp.magicfinmart.onlineexpressloan.BankLoanListAdapter;

import android.app.Activity;
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

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.PersonalLoanEntity;

/**
 * Created by IN-RB on 05-04-2018.
 */

public class ExpressBankPersonalItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity mContext;
    DBPersistanceController dbPersistanceController;

    List<PersonalLoanEntity> personalLoanEntityList;

    public ExpressBankPersonalItemAdapter(Activity mContext, List<PersonalLoanEntity> temppersonalLoanEntityList) {
        this.mContext = mContext;
        this.personalLoanEntityList = temppersonalLoanEntityList;
        dbPersistanceController = new DBPersistanceController(mContext);
    }

    public class PersonLoanItemHolder extends RecyclerView.ViewHolder {
        TextView txtbankName, txtCardType;
        ImageView imgCard;
        CardView cvCCItem;
        Button btnApply, btnInfo;

        public PersonLoanItemHolder(View itemView) {
            super(itemView);
            txtbankName = (TextView) itemView.findViewById(R.id.txtbankName);
            txtCardType = (TextView) itemView.findViewById(R.id.txtCardType);

            imgCard = (ImageView) itemView.findViewById(R.id.imgCard);

            btnInfo = (Button) itemView.findViewById(R.id.btnInfo);
            btnApply = (Button) itemView.findViewById(R.id.btnApply);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_banlist_onlineexp_item, parent, false);
        return new ExpressBankPersonalItemAdapter.PersonLoanItemHolder(view);


        //layout_banlist_onlineexp_item
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof PersonLoanItemHolder){
            final PersonalLoanEntity plEntity = personalLoanEntityList.get(position);
            ((PersonLoanItemHolder) holder).txtbankName.setText(plEntity.getBank_Name());

            Glide.with(mContext)
                    .load(plEntity.getDocument1())
                    .placeholder(R.drawable.finmart_placeholder) // can also be a drawable
                    .into(((PersonLoanItemHolder) holder).imgCard);

        }

    }

    @Override
    public int getItemCount() {
        return personalLoanEntityList.size();
    }
}
