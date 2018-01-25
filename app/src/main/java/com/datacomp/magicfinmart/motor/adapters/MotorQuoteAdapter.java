package com.datacomp.magicfinmart.motor.adapters;

import android.content.Context;
import android.provider.Settings;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;

/**
 * Created by Rajeev Ranjan on 11/01/2018.
 */

public class MotorQuoteAdapter extends RecyclerView.Adapter<MotorQuoteAdapter.QuoteItem> {
    Context mcontext;
    List<QuoteListEntity> mQuoteList;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public MotorQuoteAdapter(Context context, List<QuoteListEntity> list) {
        this.mcontext = context;
        mQuoteList = list;

    }

    @Override

    public QuoteItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_quote, parent, false);
        return new MotorQuoteAdapter.QuoteItem(itemView);


    }

    @Override
    public void onBindViewHolder(QuoteItem holder, int position) {

        if (holder instanceof QuoteItem) {
            final QuoteListEntity entity = mQuoteList.get(position);

            holder.txtPersonName.setText(entity.getFirst_name() + " " + entity.getLast_name());

            CarMasterEntity carMasterEntity = new DBPersistanceController(mcontext).getVarientDetails("" + entity.getVehicle_id());
            holder.txtVehicleName.setText(carMasterEntity.getMake_Name() + "," + carMasterEntity.getModel_Name());
            holder.txtQuoteDate.setText(entity.getCreated_date());


            holder.txtOverflowMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openPopUp(view, entity);
                }
            });
        }
    }

    private void openPopUp(View v, final QuoteListEntity entity) {
        final PopupMenu popupMenu = new PopupMenu(mcontext, v);
        final Menu menu = popupMenu.getMenu();

        popupMenu.getMenuInflater().inflate(R.menu.recycler_menu, menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuCall:
                        Toast.makeText(mcontext, "WIP " + entity.getMobile(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuSms:
                        Toast.makeText(mcontext, "WIP SMS ", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuDelete:
                        Toast.makeText(mcontext, "WIP DELETE", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
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

    public class QuoteItem extends RecyclerView.ViewHolder {

        //  public ImageView ivTripleDot;
        public TextView txtQuoteDate, txtVehicleName, txtPersonName, txtOverflowMenu;


        public QuoteItem(View itemView) {
            super(itemView);
            txtQuoteDate = (TextView) itemView.findViewById(R.id.txtQuoteDate);
            txtVehicleName = (TextView) itemView.findViewById(R.id.txtVehicleName);
            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);
        }
    }
}
