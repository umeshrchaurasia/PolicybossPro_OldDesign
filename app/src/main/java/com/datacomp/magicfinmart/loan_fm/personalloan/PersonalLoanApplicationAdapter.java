package com.datacomp.magicfinmart.loan_fm.personalloan;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;

/**
 * Created by IN-RB on 12-01-2018.
 */

public class PersonalLoanApplicationAdapter  extends RecyclerView.Adapter<PersonalLoanApplicationAdapter.ApplicationItem>implements Filterable {
    Fragment fragment;

    List<FmPersonalLoanRequest> mAppList;
    List<FmPersonalLoanRequest> mAppListFiltered;

    public PersonalLoanApplicationAdapter(Fragment context, List<FmPersonalLoanRequest> mApplicationList) {
        this.fragment = context;
        mAppList = mApplicationList;
        mAppListFiltered = mApplicationList;
    }



    public ApplicationItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_application_loan, parent, false);
        return new ApplicationItem(itemView);
    }

    @Override
    public void onBindViewHolder(ApplicationItem holder, int position) {
        if (holder instanceof ApplicationItem) {

            final FmPersonalLoanRequest entity = mAppListFiltered.get(position);

            if (entity.getPersonalLoanRequest().getApplNumb() != null) {
                holder.txtApplicationNumber.setText(""+String.valueOf(entity.getPersonalLoanRequest().getApplNumb()));
            }else
            {
                holder.txtApplicationNumber.setText("");
            }
            holder.txtPersonName.setText(entity.getPersonalLoanRequest().getApplicantNme());

            if (entity.getPersonalLoanRequest().getApplDate() != null) {
                holder.txtApplicationDate.setText("" + entity.getPersonalLoanRequest().getApplDate());
            }else
            {
                holder.txtApplicationDate.setText("");
            }

            holder.txtloanamount.setText(""+String.valueOf(entity.getPersonalLoanRequest().getLoanRequired()));



            holder.txtOverflowMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openPopUp(view, entity);
                }
            });

            try {
                Glide.with(fragment)
                        .load(entity.getPersonalLoanRequest().getbank_image())
                        .into(holder.imgbankLogo);

                Glide.with(fragment)
                        .load(entity.getPersonalLoanRequest().getProgress_image())
                        .into(holder.imgStatus);
                //change Fresco

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void openPopUp(View v, final FmPersonalLoanRequest entity) {
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
                        Toast.makeText(fragment.getActivity(), entity.getPersonalLoanRequest().getContact(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuSms:
                        Toast.makeText(fragment.getActivity(), entity.getPersonalLoanRequest().getContact(), Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });
        //displaying the popup
        popup.show();
    }
    @Override
    public int getItemCount() {
        if (mAppListFiltered == null) {
            return 0;
        } else {
            return mAppListFiltered.size();
        }
    }
    @Override
    public Filter getFilter() {
        return null;
    }

    public class ApplicationItem extends RecyclerView.ViewHolder {

        TextView txtOverflowMenu, txtApplicationDate, txtApplicationNumber, txtloanamount, txtPersonName;
        ImageView imgbankLogo,imgStatus;

        public ApplicationItem(View itemView) {
            super(itemView);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);
            txtApplicationDate = (TextView) itemView.findViewById(R.id.txtApplicationDate);
            txtApplicationNumber = (TextView) itemView.findViewById(R.id.txtApplicationNumber);
            txtloanamount = (TextView) itemView.findViewById(R.id.txtloanamount);
            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);
            imgbankLogo = (ImageView) itemView.findViewById(R.id.imgbankLogo);
            imgStatus = (ImageView) itemView.findViewById(R.id.imgStatus);
        }
    }
}
