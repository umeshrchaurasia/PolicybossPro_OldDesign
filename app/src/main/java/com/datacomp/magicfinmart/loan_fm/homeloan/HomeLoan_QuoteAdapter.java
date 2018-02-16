package com.datacomp.magicfinmart.loan_fm.homeloan;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.homeloan.quote.HL_QuoteFragment;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;

/**
 * Created by IN-RB on 19-01-2018.
 */

public class HomeLoan_QuoteAdapter extends RecyclerView.Adapter<HomeLoan_QuoteAdapter.QuoteItem>  implements View.OnClickListener {

    Fragment mFrament;
    List<FmHomeLoanRequest> mQuoteList;

    public HomeLoan_QuoteAdapter(Fragment mFrament, List<FmHomeLoanRequest> mQuoteList) {
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
        return new HomeLoan_QuoteAdapter.QuoteItem(itemView);
    }

    @Override
    public void onBindViewHolder(QuoteItem holder, int position) {
//        holder.ivTripleDot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPopUp(view);
//            }
//        });

        if (holder instanceof HomeLoan_QuoteAdapter.QuoteItem) {
            final FmHomeLoanRequest entity = mQuoteList.get(position);

            holder.txtPersonName.setText(""+ entity.getHomeLoanRequest().getApplicantNme());
            holder.txtQuoteDate.setText("" + entity.getHomeLoanRequest().getRow_created_date().split("T")[0].toString());

            holder.txtloanamount.setText("" + entity.getHomeLoanRequest().getPropertyCost());


            //click listener


            holder.txtOverflowMenu.setOnClickListener(this);

            holder.txtPersonName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((HL_QuoteFragment)mFrament).redirectQuoteHL(entity);
                }
            });
            holder.txtQuoteDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((HL_QuoteFragment)mFrament).redirectQuoteHL(entity);
                }
            });
            holder.txtloanamount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((HL_QuoteFragment)mFrament).redirectQuoteHL(entity);
                }
            });




        }
    }
//    private void openPopUp(View v, final QuoteListEntity entity) {
//        final PopupMenu popupMenu = new PopupMenu(mFrament.getActivity(), v);
//        final Menu menu = popupMenu.getMenu();
//
//        popupMenu.getMenuInflater().inflate(R.menu.recycler_menu_quote, menu);
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.menuCall:
//                        Toast.makeText(mFrament.getActivity(), "WIP " + entity.getMotorRequestEntity().getMobile(), Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.menuSms:
//                        Toast.makeText(mFrament.getActivity(), "WIP SMS ", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.menuDelete:
//                        ((MotorQuoteFragment) mFrament).removeQuote(entity);
//                        break;
//                }
//                return false;
//            }
//        });
//
//        popupMenu.show();
//    }



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
                ((HL_QuoteFragment)mFrament).redirectQuoteHL((FmHomeLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.txtQuoteDate:
                ((HL_QuoteFragment)mFrament).redirectQuoteHL((FmHomeLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.txtPersonName:
                ((HL_QuoteFragment)mFrament).redirectQuoteHL((FmHomeLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.txtOverflowMenu:
                //openPopUp(view, (QuoteListEntity) view.getTag(view.getId()));
                break;

        }
    }

}
