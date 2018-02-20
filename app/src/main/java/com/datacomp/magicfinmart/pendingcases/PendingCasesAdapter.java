package com.datacomp.magicfinmart.pendingcases;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.health.quoappfragment.HealthApplicationFragment;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthApplication;
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

    }


    private void openPopUp(View v, final PendingCasesEntity entity) {
        //creating a popup menu
        PopupMenu popup = new PopupMenu(mContex, v);
        //inflating menu from xml resource
        popup.inflate(R.menu.recycler_menu_application);
        //adding click listener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuCall:
                        Toast.makeText(mContex, "WIP ", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuSms:
                        Toast.makeText(mContex, "WIP SMS ", Toast.LENGTH_SHORT).show();
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
            case R.id.txtSumAssured:
            case R.id.imgInsurerLogo:

                break;
            case R.id.txtOverflowMenu:

                break;

        }
    }

    @Override
    public int getItemCount() {
        return 5;
        //return mAppList.size();
    }

    public class ApplicationItem extends RecyclerView.ViewHolder {

        TextView txtOverflowMenu, txtCreatedDate, txtCRN, txtSumAssured, txtPersonName;
        ImageView imgInsurerLogo;

        public ApplicationItem(View itemView) {
            super(itemView);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);
            txtCreatedDate = (TextView) itemView.findViewById(R.id.txtCreatedDate);
            txtCRN = (TextView) itemView.findViewById(R.id.txtCRN);
            txtSumAssured = (TextView) itemView.findViewById(R.id.txtSumAssured);
            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);
            imgInsurerLogo = (ImageView) itemView.findViewById(R.id.imgInsurerLogo);
        }
    }


    public void refreshAdapter(List<PendingCasesEntity> list) {
        mAppList = list;
    }


}
