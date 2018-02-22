package com.datacomp.magicfinmart.loan_fm.personalloan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.PopupMenu;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.personalloan.quote.PL_QuoteFragment;

import java.util.List;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import android.widget.Toast;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;

/**
 * Created by IN-RB on 12-01-2018.
 */

public class PesonalLoan_QuoteAdapter extends RecyclerView.Adapter<PesonalLoan_QuoteAdapter.QuoteItem> implements View.OnClickListener{
    Fragment mFrament;
    List<FmPersonalLoanRequest> mQuoteList;

    public PesonalLoan_QuoteAdapter(Fragment mFrament,List<FmPersonalLoanRequest> mQuoteList) {
        this.mFrament = mFrament;
        this.mQuoteList = mQuoteList;
    }

    public class QuoteItem extends RecyclerView.ViewHolder {

        public TextView txtPersonName,  txtOverflowMenu,  txtloanamount , txtQuoteDate,tvQuoteDate,tvloanamount;


        public QuoteItem(View itemView) {
            super(itemView);
            txtQuoteDate = (TextView) itemView.findViewById(R.id.txtQuoteDate);
            txtloanamount = (TextView) itemView.findViewById(R.id.txtloanamount);
            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);

            tvloanamount = (TextView) itemView.findViewById(R.id.tvloanamount);
            tvQuoteDate = (TextView) itemView.findViewById(R.id.tvQuoteDate);
        }
    }

    @Override
    public QuoteItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_quote_loan, parent, false);
        return new PesonalLoan_QuoteAdapter.QuoteItem(itemView);
    }

    @Override
    public void onBindViewHolder(QuoteItem holder, int position) {


        if (holder instanceof PesonalLoan_QuoteAdapter.QuoteItem) {
            final FmPersonalLoanRequest entity = mQuoteList.get(position);

            holder.txtPersonName.setText("" + entity.getPersonalLoanRequest().getApplicantNme());
            holder.txtQuoteDate.setText("" + entity.getPersonalLoanRequest().getRow_created_date().split("T")[0].toString());

            holder.txtloanamount.setText("" + entity.getPersonalLoanRequest().getLoanRequired());


            //click listener

//            holder.txtPersonName.setOnClickListener(this);
//            holder.txtQuoteDate.setOnClickListener(this);
//            holder.txtloanamount.setOnClickListener(this);
//            holder.tvloanamount.setOnClickListener(this);
//            holder.tvQuoteDate.setOnClickListener(this);
//            holder.txtOverflowMenu.setOnClickListener(this);

            holder.txtPersonName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((PL_QuoteFragment)mFrament).redirectQuotePL(entity);
                }
            });
            holder.txtQuoteDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((PL_QuoteFragment)mFrament).redirectQuotePL(entity);
                }
            });
            holder.txtloanamount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((PL_QuoteFragment)mFrament).redirectQuotePL(entity);
                }
            });
            holder.tvloanamount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((PL_QuoteFragment)mFrament).redirectQuotePL(entity);
                }
            });
            holder.tvQuoteDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((PL_QuoteFragment)mFrament).redirectQuotePL(entity);
                }
            });
        }
    }

    private void openPopUp(View v, final FmPersonalLoanRequest entity) {
        //creating a popup menu
        PopupMenu popup = new PopupMenu(mFrament.getActivity(), v);
        //inflating menu from xml resource
        popup.inflate(R.menu.recycler_menu_application);
        //adding click listener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuCall:
                        Toast.makeText(mFrament.getActivity(), "WIP " + entity.getPersonalLoanRequest().getContact(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuSms:
                        Toast.makeText(mFrament.getActivity(), "WIP SMS ", Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });
        //displaying the popup
        popup.show();
    }
    public void refreshAdapter(List<FmPersonalLoanRequest> list) {
        mQuoteList = list;
    }

    @Override
    public int getItemCount() {
        return mQuoteList.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtloanamount:
                ((PL_QuoteFragment)mFrament).redirectQuotePL((FmPersonalLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.txtQuoteDate:
                ((PL_QuoteFragment)mFrament).redirectQuotePL((FmPersonalLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.tvQuoteDate:
                ((PL_QuoteFragment)mFrament).redirectQuotePL((FmPersonalLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.tvloanamount:
                ((PL_QuoteFragment)mFrament).redirectQuotePL((FmPersonalLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.txtPersonName:
                ((PL_QuoteFragment)mFrament).redirectQuotePL((FmPersonalLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.txtOverflowMenu:
                openPopUp(view, (FmPersonalLoanRequest) view.getTag(view.getId()));
                break;

        }
    }
}
