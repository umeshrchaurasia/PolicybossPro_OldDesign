package com.datacomp.magicfinmart.loan_fm.balancetransfer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.PopupMenu;

import com.datacomp.magicfinmart.R;

/**
 * Created by IN-RB on 26-01-2018.
 */

public class BalanceTransferApplicationAdapter  extends RecyclerView.Adapter<BalanceTransferApplicationAdapter.ApplicationItem>{
    Context context;
    public BalanceTransferApplicationAdapter(Context context) {
        this.context = context;
    }
    @Override
    public ApplicationItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_application_bl, parent, false);
        return new ApplicationItem(itemView);
    }

    @Override
    public void onBindViewHolder(BalanceTransferApplicationAdapter.ApplicationItem holder, int position) {
//        holder.ivTripleDot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPopUp(view);
//            }
//        });
    }

//    private void openPopUp(View v) {
//        final PopupMenu popupMenu = new PopupMenu(context, v);
//        final Menu menu = popupMenu.getMenu();
//
//        popupMenu.getMenuInflater().inflate(R.menu.recycler_menu, menu);
//
//        popupMenu.show();
//    }
    @Override
    public int getItemCount() {
        return 2;
    }

    public class ApplicationItem extends RecyclerView.ViewHolder {

        //  public ImageView ivTripleDot;
        public CheckBox chkAddon;


        public ApplicationItem(View itemView) {
            super(itemView);
            // ivTripleDot = (ImageView) itemView.findViewById(R.id.ivTripleDot);
        }
    }
}
