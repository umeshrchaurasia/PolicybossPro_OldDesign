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
import android.widget.Toast;

import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ApplicationListEntity;

/**
 * Created by Rajeev Ranjan on 11/01/2018.
 */

public class MotorApplicationAdapter extends RecyclerView.Adapter<MotorApplicationAdapter.ApplicationItem> {
    Context context;
    List<ApplicationListEntity> mAppList;

    public MotorApplicationAdapter(Context context, List<ApplicationListEntity> mApplicationList) {
        this.context = context;
        mAppList = mApplicationList;
    }

    @Override

    public ApplicationItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_application, parent, false);
        return new ApplicationItem(itemView);
    }

    @Override
    public void onBindViewHolder(ApplicationItem holder, int position) {
        if (holder instanceof ApplicationItem) {

            final ApplicationListEntity entity = mAppList.get(position);

            holder.txtPersonName.setText(entity.getFirst_name() + " " + entity.getLast_name());
            holder.txtCRN.setText(entity.getCrn());
            holder.txtCreatedDate.setText("" + entity.getCreated_date());
            holder.txtOverflowMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openPopUp(view, entity);
                }
            });
        }
    }

    private void openPopUp(View v, final ApplicationListEntity entity) {
        //creating a popup menu
        PopupMenu popup = new PopupMenu(context, v);
        //inflating menu from xml resource
        popup.inflate(R.menu.recycler_menu);
        //adding click listener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuCall:
                        Toast.makeText(context, "WIP " + entity.getMobile(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuSms:
                        Toast.makeText(context, "WIP SMS ", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuDelete:
                        Toast.makeText(context, "WIP DELETE", Toast.LENGTH_SHORT).show();
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

        public TextView txtOverflowMenu, txtCreatedDate, txtCRN, txtVehicleNo, txtPersonName;

        public ApplicationItem(View itemView) {
            super(itemView);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);
            txtCreatedDate = (TextView) itemView.findViewById(R.id.txtCreatedDate);
            txtCRN = (TextView) itemView.findViewById(R.id.txtCRN);
            txtVehicleNo = (TextView) itemView.findViewById(R.id.txtVehicleNo);
            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);
        }
    }
}
