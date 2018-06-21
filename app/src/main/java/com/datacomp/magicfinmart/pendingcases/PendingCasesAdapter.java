package com.datacomp.magicfinmart.pendingcases;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PendingCasesEntity;

/**
 * Created by Nilesh on 05/02/2018.
 */

public class PendingCasesAdapter extends RecyclerView.Adapter<PendingCasesAdapter.ApplicationItem> implements View.OnClickListener {

    Context mContex;
    List<PendingCasesEntity> mAppList;

    public PendingCasesAdapter(Context context, List<PendingCasesEntity> list) {
        this.mContex = context;
        mAppList = list;

    }

    @Override
    public ApplicationItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_pending_item, parent, false);
        return new ApplicationItem(itemView);
    }

    @Override
    public void onBindViewHolder(ApplicationItem holder, int position) {

        if (holder instanceof ApplicationItem) {
            ApplicationItem item = (ApplicationItem) holder;
            PendingCasesEntity entity = mAppList.get(position);

            item.txtCustName.setText(entity.getCustomerName());
            item.txtCategory.setText(entity.getCategory());
            item.txtPendingDays.setText(String.valueOf(entity.getPendingdays()));
            item.txtType.setText(entity.getQatype());

            Glide.with(mContex).load(entity.getBankImage())
                    .into(item.imgInsurerLogo);

            item.txtOverflowMenu.setTag(R.id.txtOverflowMenu, entity);
            item.txtOverflowMenu.setOnClickListener(this);


            try {
                /*if (Integer.parseInt(entity.getApplnStatus()) == 0) {
                    item.imgStatus.setImageResource(R.mipmap.status_0);
                } else if (Integer.parseInt(entity.getApplnStatus()) == 25) {
                    item.imgStatus.setImageResource(R.mipmap.status_25);
                } else if (Integer.parseInt(entity.getApplnStatus()) == 50) {
                    item.imgStatus.setImageResource(R.mipmap.status_50);
                } else if (Integer.parseInt(entity.getApplnStatus()) == 100) {
                    item.imgStatus.setImageResource(R.mipmap.status_100);
                }*/

                pgStatus(item.imgStatus, Integer.parseInt(entity.getApplnStatus()));
            } catch (Exception e) {
                item.imgStatus.setImageResource(R.mipmap.status_25);
            }
        }

    }

    public void pgStatus(ImageView imgPg, int status) {
        switch (status) {
            case 0:
                imgPg.setImageResource(R.mipmap.status_0);
                break;
            case 10:
                imgPg.setImageResource(R.mipmap.status_10);
                break;
            case 20:
                imgPg.setImageResource(R.mipmap.status_20);
                break;
            case 25:
                imgPg.setImageResource(R.mipmap.status_25);
                break;
            case 30:
                imgPg.setImageResource(R.mipmap.status_30);
                break;
            case 40:
                imgPg.setImageResource(R.mipmap.status_40);
                break;
            case 50:
                imgPg.setImageResource(R.mipmap.status_50);
                break;
            case 60:
                imgPg.setImageResource(R.mipmap.status_60);
                break;
            case 70:
                imgPg.setImageResource(R.mipmap.status_70);
                break;
            case 80:
                imgPg.setImageResource(R.mipmap.status_80);
                break;
            case 90:
                imgPg.setImageResource(R.mipmap.status_90);
                break;
            case 100:
                imgPg.setImageResource(R.mipmap.status_100);
                break;
            default:
                imgPg.setImageResource(R.mipmap.status_0);
                break;

        }
    }


    private void openPopUp(View v, final PendingCasesEntity entity) {
        //creating a popup menu
        PopupMenu popup = new PopupMenu(mContex, v);
        //inflating menu from xml resource
        popup.inflate(R.menu.recycler_menu_quote);
        //adding click listener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuCall:
                        ((PendingCasesActivity) mContex).dialNumber(entity.getMobile());
                        //Toast.makeText(mContex, "WIP ", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuSms:
                        ((PendingCasesActivity) mContex).sendSms(entity.getMobile());
                        //Toast.makeText(mContex, "WIP SMS ", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuDelete:
                        ((PendingCasesActivity) mContex).deletePendingcases(entity);
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
            case R.id.txtOverflowMenu:
                openPopUp(view, (PendingCasesEntity) view.getTag(R.id.txtOverflowMenu));
                break;

        }
    }

    @Override
    public int getItemCount() {
        return mAppList.size();
    }

    public class ApplicationItem extends RecyclerView.ViewHolder {

        TextView txtOverflowMenu, txtCustName, txtType, txtCategory, txtPendingDays;
        ImageView imgStatus, imgInsurerLogo;

        public ApplicationItem(View itemView) {
            super(itemView);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);
            txtCustName = (TextView) itemView.findViewById(R.id.txtCustName);
            txtCategory = (TextView) itemView.findViewById(R.id.txtCategory);
            txtType = (TextView) itemView.findViewById(R.id.txtType);
            txtPendingDays = (TextView) itemView.findViewById(R.id.txtPendingDays);
            imgStatus = (ImageView) itemView.findViewById(R.id.imgStatus);
            imgInsurerLogo = (ImageView) itemView.findViewById(R.id.imgInsurerLogo);
        }
    }


    public void refreshAdapter(List<PendingCasesEntity> list) {
        mAppList = list;
    }


}
