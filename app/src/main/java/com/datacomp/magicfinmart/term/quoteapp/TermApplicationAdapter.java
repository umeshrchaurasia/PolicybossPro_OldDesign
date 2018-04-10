package com.datacomp.magicfinmart.term.quoteapp;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.health.quoappfragment.HealthApplicationFragment;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthApplication;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;

/**
 * Created by Nilesh on 05/02/2018.
 */

public class TermApplicationAdapter extends RecyclerView.Adapter<TermApplicationAdapter.ApplicationItem> implements View.OnClickListener, Filterable {
    Fragment fragment;
    List<TermFinmartRequest> mAppList;
    List<TermFinmartRequest> mAppListFiltered;

    public TermApplicationAdapter(Fragment context, List<TermFinmartRequest> mApplicationList) {
        this.fragment = context;
        mAppList = mApplicationList;
        mAppListFiltered = mApplicationList;
    }

    @Override

    public ApplicationItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_term_item_application, parent, false);
        return new ApplicationItem(itemView);
    }

    @Override
    public void onBindViewHolder(ApplicationItem holder, int position) {
        if (holder instanceof ApplicationItem) {
            TermFinmartRequest entity = mAppListFiltered.get(position);
            holder.txtCRN.setText(entity.getTermRequestEntity().getCrn());
            holder.txtCreatedDate.setText(entity.getTermRequestEntity().getCreated_date());
            holder.txtPersonName.setText(entity.getTermRequestEntity().getContactName());


            try {

                Glide.with(fragment).load(entity.getInsImage()).into(holder.imgInsurerLogo);

                if (entity.getStatus_progress() == 25 || entity.getStatus_progress() == 0) {
                    holder.imgProgressStatus.setImageDrawable(fragment.getResources().getDrawable(R.mipmap.status_25));
                } else if (entity.getStatus_progress() == 50) {
                    holder.imgProgressStatus.setImageDrawable(fragment.getResources().getDrawable(R.mipmap.status_50));
                } else {
                    holder.imgProgressStatus.setImageDrawable(fragment.getResources().getDrawable(R.mipmap.status_100));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            holder.txtCRN.setTag(R.id.txtCRN, entity);
            holder.txtCreatedDate.setTag(R.id.txtCreatedDate, entity);
            holder.txtPersonName.setTag(R.id.txtPersonName, entity);
            holder.txtOverflowMenu.setTag(R.id.txtOverflowMenu, entity);
            holder.imgInsurerLogo.setTag(R.id.imgInsurerLogo, entity);
            holder.llApp.setTag(R.id.llApp, entity);
            holder.llbottom.setTag(R.id.llbottom, entity);


            holder.txtCRN.setOnClickListener(this);
            holder.txtCreatedDate.setOnClickListener(this);
            holder.txtPersonName.setOnClickListener(this);
            holder.txtOverflowMenu.setOnClickListener(this);
            holder.imgInsurerLogo.setOnClickListener(this);
            holder.llApp.setOnClickListener(this);
            holder.llbottom.setOnClickListener(this);


        }
    }


    private void openPopUp(View v, final TermFinmartRequest entity) {
        //creating a popup menu
        PopupMenu popup = new PopupMenu(fragment.getActivity(), v);
        //inflating menu from xml resource
        popup.inflate(R.menu.recycler_menu_application);
        //adding click listener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuCall:
                        //((HealthApplicationFragment) fragment).dialNumber(entity.getHealthRequest().getContactMobile());
                        break;
                    case R.id.menuSms:
                        //((HealthApplicationFragment) fragment).sendSms(entity.getHealthRequest().getContactMobile());
                        break;

                }
                return false;
            }
        });
        //displaying the popup
        popup.show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.txtCRN:
            case R.id.txtCreatedDate:
            case R.id.txtPersonName:
            case R.id.imgInsurerLogo:
            case R.id.llbottom:
            case R.id.llApp:
                //((HealthApplicationFragment) fragment).redirectToQuote((HealthApplication) view.getTag(view.getId()));
                break;
            case R.id.txtOverflowMenu:
                openPopUp(view, (TermFinmartRequest) view.getTag(view.getId()));
                break;

        }
    }

    @Override
    public int getItemCount() {
        if (mAppListFiltered == null) {
            return 0;
        } else {
            return mAppListFiltered.size();
        }
    }

    public class ApplicationItem extends RecyclerView.ViewHolder {

        TextView txtOverflowMenu, txtCreatedDate, txtCRN, txtPersonName;
        ImageView imgInsurerLogo, imgProgressStatus;
        LinearLayout llbottom, llApp;

        public ApplicationItem(View itemView) {
            super(itemView);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);
            txtCreatedDate = (TextView) itemView.findViewById(R.id.txtCreatedDate);
            txtCRN = (TextView) itemView.findViewById(R.id.txtCRN);
            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);
            imgInsurerLogo = (ImageView) itemView.findViewById(R.id.imgInsurerLogo);
            imgProgressStatus = (ImageView) itemView.findViewById(R.id.imgProgressStatus);
            llbottom = (LinearLayout) itemView.findViewById(R.id.llbottom);
            llApp = (LinearLayout) itemView.findViewById(R.id.llApp);
        }
    }


    public void refreshAdapter(List<TermFinmartRequest> list) {
        mAppListFiltered = list;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mAppListFiltered = mAppList;
                } else {
                    List<TermFinmartRequest> filteredList = new ArrayList<>();
                    for (TermFinmartRequest row : mAppList) {
                        if (row.getTermRequestEntity().getContactName().toLowerCase().contains(charString.toLowerCase())
                                || row.getTermRequestEntity().getCrn().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    mAppListFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mAppListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mAppListFiltered = (ArrayList<TermFinmartRequest>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
