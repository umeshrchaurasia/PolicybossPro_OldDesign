package com.datacomp.magicfinmart.health.quoappfragment;

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
import com.datacomp.magicfinmart.motor.privatecar.fragment.MotorQuoteFragment;

import java.text.SimpleDateFormat;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;

/**
 * Created by Nilesh birhade on 05/02/2018.
 */

public class HealthQuoteAdapter extends RecyclerView.Adapter<HealthQuoteAdapter.QuoteItem> implements View.OnClickListener {
    Fragment mFrament;
    List<HealthQuote> mQuoteList;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public HealthQuoteAdapter(Fragment context, List<HealthQuote> list) {
        this.mFrament = context;
        mQuoteList = list;

    }

    @Override

    public QuoteItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_health_item_quote, parent, false);
        return new HealthQuoteAdapter.QuoteItem(itemView);


    }

    @Override
    public void onBindViewHolder(QuoteItem holder, int position) {

        if (holder instanceof QuoteItem) {
            final HealthQuote quote = mQuoteList.get(position);
            holder.txtPersonName.setText(quote.getHealthRequest().getContactName());
            holder.txtSumAssured.setText(quote.getHealthRequest().getSumInsured());
            holder.txtQuoteDate.setText(quote.getHealthRequest().getCreated_date());

            holder.txtPersonName.setTag(R.id.txtPersonName, quote);
            holder.txtSumAssured.setTag(R.id.txtSumAssured, quote);
            holder.txtQuoteDate.setTag(R.id.txtQuoteDate, quote);
            holder.txtOverflowMenu.setTag(R.id.txtOverflowMenu, quote);

            holder.txtOverflowMenu.setOnClickListener(this);
            holder.txtPersonName.setOnClickListener(this);
            holder.txtQuoteDate.setOnClickListener(this);
            holder.txtSumAssured.setOnClickListener(this);
        }

    }

    private void openPopUp(View v, final HealthQuote entity) {
        final PopupMenu popupMenu = new PopupMenu(mFrament.getActivity(), v);
        final Menu menu = popupMenu.getMenu();

        popupMenu.getMenuInflater().inflate(R.menu.recycler_menu_quote, menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuCall:
                        Toast.makeText(mFrament.getActivity(), "" + entity.getHealthRequest().getContactMobile(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuSms:
                        Toast.makeText(mFrament.getActivity(), "SMS", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuDelete:
                        Toast.makeText(mFrament.getActivity(), "DELETE", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        popupMenu.show();
    }

    @Override
    public int getItemCount() {
        return mQuoteList.size();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.txtSumAssured:
            case R.id.txtPersonName:
            case R.id.txtQuoteDate:
                ((HealthQuoteListFragment) mFrament).quoteItemClick((HealthQuote) view.getTag(view.getId()));
                break;
            case R.id.txtOverflowMenu:
                openPopUp(view, (HealthQuote) view.getTag(view.getId()));
                break;

        }
    }

    public class QuoteItem extends RecyclerView.ViewHolder {

        //  public ImageView ivTripleDot;
        public TextView txtQuoteDate, txtSumAssured, txtPersonName, txtOverflowMenu;


        public QuoteItem(View itemView) {
            super(itemView);
            txtQuoteDate = (TextView) itemView.findViewById(R.id.txtQuoteDate);
            txtSumAssured = (TextView) itemView.findViewById(R.id.txtSumAssured);
            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);
        }
    }

    public void refreshAdapter(List<HealthQuote> list) {
        mQuoteList = list;
    }
}
