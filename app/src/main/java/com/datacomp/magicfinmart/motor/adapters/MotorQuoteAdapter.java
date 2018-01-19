package com.datacomp.magicfinmart.motor.adapters;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.datacomp.magicfinmart.R;

/**
 * Created by Rajeev Ranjan on 11/01/2018.
 */

public class MotorQuoteAdapter extends RecyclerView.Adapter<MotorQuoteAdapter.QuoteItem> {
    Context context;

    public MotorQuoteAdapter(Context context) {
        this.context = context;
    }

    @Override

    public QuoteItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_quote, parent, false);
        return new MotorQuoteAdapter.QuoteItem(itemView);
    }

    @Override
    public void onBindViewHolder(QuoteItem holder, int position) {
//        holder.ivTripleDot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPopUp(view);
//            }
//        });
    }

    private void openPopUp(View v) {
        final PopupMenu popupMenu = new PopupMenu(context, v);
        final Menu menu = popupMenu.getMenu();

        popupMenu.getMenuInflater().inflate(R.menu.recycler_menu, menu);
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
        return 5;
    }

    public class QuoteItem extends RecyclerView.ViewHolder {

        //  public ImageView ivTripleDot;
        public CheckBox chkAddon;


        public QuoteItem(View itemView) {
            super(itemView);
            //ivTripleDot = (ImageView) itemView.findViewById(R.id.ivTripleDot);
        }
    }
}
