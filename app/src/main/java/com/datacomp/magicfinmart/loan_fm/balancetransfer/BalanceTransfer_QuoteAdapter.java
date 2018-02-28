package com.datacomp.magicfinmart.loan_fm.balancetransfer;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.loan_fm.balancetransfer.quote.BL_QuoteFragment;

import org.w3c.dom.Text;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmBalanceLoanRequest;

/**
 * Created by IN-RB on 26-01-2018.
 */

public class BalanceTransfer_QuoteAdapter extends RecyclerView.Adapter<BalanceTransfer_QuoteAdapter.QuoteItem>  implements View.OnClickListener {

    Fragment mFrament;
    List<FmBalanceLoanRequest> mQuoteList;


    public BalanceTransfer_QuoteAdapter(Fragment mFrament,List<FmBalanceLoanRequest> mQuoteList) {
        this.mFrament = mFrament;
        this.mQuoteList = mQuoteList;
    }
    @Override
    public QuoteItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_quote_bl, parent, false);
        return new BalanceTransfer_QuoteAdapter.QuoteItem(itemView);
    }

    @Override
    public void onBindViewHolder(QuoteItem holder, int position) {


        if (holder instanceof BalanceTransfer_QuoteAdapter.QuoteItem) {
            final FmBalanceLoanRequest entity = mQuoteList.get(position);

            try {
                if (entity.getBLLoanRequest().getApplicantName() != null) {
                    holder.txtPersonName.setText("" + entity.getBLLoanRequest().getApplicantName());
                }
                else
                {
                    holder.txtPersonName.setText("");
                }
                if (entity.getBLLoanRequest().getRow_createddate() != null) {
                    holder.txtQuoteDate.setText("" + entity.getBLLoanRequest().getRow_createddate().split("T")[0].toString());

                }
                else
                {
                    holder.txtQuoteDate.setText("");
                }


                if (Integer.toString(entity.getBLLoanRequest().getProduct_id()).matches("12")) {
                    holder.txttype.setText("HOME");
                } else if (Integer.toString(entity.getBLLoanRequest().getProduct_id()).matches("9")) {
                    holder.txttype.setText("PERSONAL");
                } else if (Integer.toString(entity.getBLLoanRequest().getProduct_id()).matches("7")) {
                    holder.txttype.setText("LAP");
                }
                holder.txtloanamount.setText("" + entity.getBLLoanRequest().getLoanamount());

            }catch (Exception ex)
            {
                ex.printStackTrace();
            }


            holder.txtPersonName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((BL_QuoteFragment)mFrament).redirectQuoteBL(entity);
                }
            });
            holder.txtQuoteDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((BL_QuoteFragment)mFrament).redirectQuoteBL(entity);
                }
            });
            holder.txtloanamount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((BL_QuoteFragment)mFrament).redirectQuoteBL(entity);
                }
            });
            holder.tvloanamount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((BL_QuoteFragment)mFrament).redirectQuoteBL(entity);
                }
            });
            holder.tvQuoteDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((BL_QuoteFragment)mFrament).redirectQuoteBL(entity);
                }
            });
            holder.txttype.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((BL_QuoteFragment)mFrament).redirectQuoteBL(entity);
                }
            });
            holder.tvtype.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((BL_QuoteFragment)mFrament).redirectQuoteBL(entity);
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


    private void openPopUp(View v, final FmBalanceLoanRequest entity) {
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

                                ((BL_QuoteFragment)mFrament).callnumber(entity.getBLLoanRequest().getContact());
                       // Toast.makeText(mFrament.getActivity(), "WIP " + entity.getBLLoanRequest().getContact(), Toast.LENGTH_SHORT).show();
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


    public void refreshAdapter(List<FmBalanceLoanRequest> list) {
        mQuoteList = list;
    }

    public class QuoteItem extends RecyclerView.ViewHolder {

        public TextView txtPersonName,  txtOverflowMenu,  txtloanamount , txtQuoteDate,tvQuoteDate,tvloanamount,txttype,tvtype;


        public QuoteItem(View itemView) {
            super(itemView);
            txtQuoteDate = (TextView) itemView.findViewById(R.id.txtQuoteDate);
            txtloanamount = (TextView) itemView.findViewById(R.id.txtloanamount);
            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);

            tvloanamount = (TextView) itemView.findViewById(R.id.tvloanamount);
            tvQuoteDate = (TextView) itemView.findViewById(R.id.tvQuoteDate);
            txttype = (TextView)itemView.findViewById(R.id.txttype);
            tvtype=(TextView)itemView.findViewById(R.id.tvtype);
        }
    }

    @Override
    public int getItemCount() {
        return mQuoteList.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtloanamount:
                ((BL_QuoteFragment)mFrament).redirectQuoteBL((FmBalanceLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.txtQuoteDate:
                ((BL_QuoteFragment)mFrament).redirectQuoteBL((FmBalanceLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.tvQuoteDate:
                ((BL_QuoteFragment)mFrament).redirectQuoteBL((FmBalanceLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.tvloanamount:
                ((BL_QuoteFragment)mFrament).redirectQuoteBL((FmBalanceLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.txtPersonName:
                ((BL_QuoteFragment)mFrament).redirectQuoteBL((FmBalanceLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.txttype:
                ((BL_QuoteFragment)mFrament).redirectQuoteBL((FmBalanceLoanRequest) view.getTag(view.getId()));
                break;
            case R.id.tvtype:
                ((BL_QuoteFragment)mFrament).redirectQuoteBL((FmBalanceLoanRequest) view.getTag(view.getId()));
                break;

            case R.id.txtOverflowMenu:
                openPopUp(view, (FmBalanceLoanRequest) view.getTag(view.getId()));
                break;

        }
    }
}
