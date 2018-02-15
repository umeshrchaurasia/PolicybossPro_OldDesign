package com.datacomp.magicfinmart.loan_fm.personalloan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.PopupMenu;

import com.datacomp.magicfinmart.R;
import java.util.List;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;

/**
 * Created by IN-RB on 12-01-2018.
 */

public class PesonalLoan_QuoteAdapter extends RecyclerView.Adapter<PesonalLoan_QuoteAdapter.QuoteItem> {
    Fragment mFrament;
    List<FmPersonalLoanRequest> mQuoteList;

    public PesonalLoan_QuoteAdapter(Fragment mFrament,List<FmPersonalLoanRequest> mQuoteList) {
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
        return new PesonalLoan_QuoteAdapter.QuoteItem(itemView);
    }

    @Override
    public void onBindViewHolder(QuoteItem holder, int position) {
//        holder.ivTripleDot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPopUp(view);
//            }
//        });

        if (holder instanceof PesonalLoan_QuoteAdapter.QuoteItem) {
            final FmPersonalLoanRequest entity = mQuoteList.get(position);

            holder.txtPersonName.setText(""+ entity.getPersonalLoanRequest().getApplicantNme());
            holder.txtQuoteDate.setText("" + entity.getPersonalLoanRequest().getRow_created_date().split("T")[0].toString());

            holder.txtloanamount.setText("" + entity.getPersonalLoanRequest().getLoanRequired());

        }
    }

    private void openPopUp(View v) {
        final PopupMenu popupMenu = new PopupMenu(mFrament.getActivity(), v);
        final Menu menu = popupMenu.getMenu();

        popupMenu.getMenuInflater().inflate(R.menu.recycler_menu_quote, menu);
        //popupMenu.setOnMenuItemClickListener(onMenuItemClickListener);

      /*  switch (Settings.Global.listMode) {
            case Settings.Global.LIST_STYLE_NORMAL: {
                menu.findItem(R.id.nav_call).setVisible(false);
                break;
            }
            case Settings.Global.LIST_STYLE_FAVORITE: {
                menu.findItem(R.id.action_add_to_favorite).setVisible(false);
                break;
            }
            case Settings.Global.LIST_STYLE_WATCH_LIST: {
                menu.findItem(R.id.action_add_to_watch_list).setVisible(false);
                break;
            }
            case Settings.Global.LIST_STYLE_DOWNLOAD: {
                menu.findItem(R.id.action_download).setVisible(false);
                break;
            }
        }

        itemPosition = (int) view.getTag(R.id.tag_item_position);*/
        popupMenu.show();
    }
    @Override
    public int getItemCount() {
        return mQuoteList.size();
    }
}
