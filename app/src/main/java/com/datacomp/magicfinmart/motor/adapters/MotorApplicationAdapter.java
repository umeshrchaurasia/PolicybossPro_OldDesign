package com.datacomp.magicfinmart.motor.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ApplicationListEntity;

/**
 * Created by Rajeev Ranjan on 11/01/2018.
 */

public class MotorApplicationAdapter extends RecyclerView.Adapter<MotorApplicationAdapter.ApplicationItem> {
    Context context;
    List<ApplicationListEntity> mAppList;

    public MotorApplicationAdapter(Context context, List<ApplicationListEntity> mApplicationList) {
        this.context = context;
        mApplicationList = mAppList;
    }

    @Override

    public ApplicationItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_application, parent, false);
        return new ApplicationItem(itemView);
    }

    @Override
    public void onBindViewHolder(ApplicationItem holder, int position) {
        holder.txtOverflowMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPopUp(view);
            }
        });
    }

    private void openPopUp(View v) {
        //creating a popup menu
        PopupMenu popup = new PopupMenu(context, v);
        //inflating menu from xml resource
        popup.inflate(R.menu.recycler_menu);
        //adding click listener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu1:
                        //handle menu1 click
                        break;
                    case R.id.menu2:
                        //handle menu2 click
                        break;
                    case R.id.menu3:
                        //handle menu3 click
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
        if (mAppList == null) {
            return 0;
        } else {
            return mAppList.size();
        }
    }

    public class ApplicationItem extends RecyclerView.ViewHolder {

        public TextView txtOverflowMenu, txtCreatedDate, txtCRN, txtVehicleNo, txtInsurerName;

        public ApplicationItem(View itemView) {
            super(itemView);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);
        }
    }
}
