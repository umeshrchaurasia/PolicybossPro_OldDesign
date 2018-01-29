package com.datacomp.magicfinmart.loan_fm.personalloan;

import android.content.Context;
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
 * Created by IN-RB on 12-01-2018.
 */

public class PersonalLoanApplicationAdapter  extends RecyclerView.Adapter<PersonalLoanApplicationAdapter.ApplicationItem>{
    Context context;
    public PersonalLoanApplicationAdapter(Context context) {
        this.context = context;
    }
    @Override
    public ApplicationItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_application_loan, parent, false);
        return new ApplicationItem(itemView);
    }

    @Override
    public void onBindViewHolder(PersonalLoanApplicationAdapter.ApplicationItem holder, int position) {
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

        popupMenu.getMenuInflater().inflate(R.menu.recycler_menu_quote, menu);

        popupMenu.show();
    }
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
