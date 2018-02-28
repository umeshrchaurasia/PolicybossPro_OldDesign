package com.datacomp.magicfinmart.loan_fm.laploan;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.laploan.quote.LAP_QuoteFragment;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;

/**
 * Created by IN-RB on 22-01-2018.
 */

public class LapLoan_QuoteAdapter extends RecyclerView.Adapter<LapLoan_QuoteAdapter.QuoteItem> implements View.OnClickListener {

    Fragment mFrament;
    List<FmHomeLoanRequest> mQuoteList;

    public LapLoan_QuoteAdapter(Fragment mFrament, List<FmHomeLoanRequest> mQuoteList) {
        this.mFrament = mFrament;
        this.mQuoteList = mQuoteList;
    }


    public class QuoteItem extends RecyclerView.ViewHolder {

        public TextView txtPersonName,  txtOverflowMenu,  txtloanamount , txtQuoteDate;


        public QuoteItem(View itemView) {
            super(itemView);
            txtQuoteDate = (TextView) itemView.findViewById(R.id.txtQuoteDate);
            txtloanamount = (TextView) itemView.findViewById(R.id.txtloanamount);
            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);
        }
    }
    @Override
    public QuoteItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_quote_loan, parent, false);
        return new LapLoan_QuoteAdapter.QuoteItem(itemView);
    }

    @Override
    public void onBindViewHolder(QuoteItem holder, int position) {


        if (holder instanceof LapLoan_QuoteAdapter.QuoteItem) {
            final FmHomeLoanRequest entity = mQuoteList.get(position);

            holder.txtPersonName.setText(""+ entity.getHomeLoanRequest().getApplicantNme());
            holder.txtQuoteDate.setText("" + entity.getHomeLoanRequest().getRow_created_date().split("T")[0].toString());

            holder.txtloanamount.setText("" + entity.getHomeLoanRequest().getLoanRequired());


            //click listener

            holder.txtPersonName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((LAP_QuoteFragment)mFrament).redirectQuoteHL(entity);
                }
            });
            holder.txtQuoteDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((LAP_QuoteFragment)mFrament).redirectQuoteHL(entity);
                }
            });
            holder.txtloanamount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((LAP_QuoteFragment)mFrament).redirectQuoteHL(entity);
                }
            });
            holder.txtOverflowMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openPopUp(view, entity);
                }
            });

        }
    }

    private void openPopUp(View v, final FmHomeLoanRequest entity) {
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
                        ((LAP_QuoteFragment)mFrament).callnumber(entity.getHomeLoanRequest().getContact());
                      //  Toast.makeText(mFrament.getActivity(), "WIP " + entity.getHomeLoanRequest().getContact(), Toast.LENGTH_SHORT).show();
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

    public void refreshAdapter(List<FmHomeLoanRequest> list) {
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
                ((LAP_QuoteFragment)mFrament).redirectQuoteHL((FmHomeLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.txtQuoteDate:
                ((LAP_QuoteFragment)mFrament).redirectQuoteHL((FmHomeLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.txtPersonName:
                ((LAP_QuoteFragment)mFrament).redirectQuoteHL((FmHomeLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.txtOverflowMenu:
                openPopUp(view, (FmHomeLoanRequest) view.getTag(view.getId()));
                break;

        }
    }
}

