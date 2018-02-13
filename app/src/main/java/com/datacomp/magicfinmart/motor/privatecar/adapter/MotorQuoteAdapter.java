package com.datacomp.magicfinmart.motor.privatecar.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.fragment.MotorQuoteFragment;

import java.text.SimpleDateFormat;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;

/**
 * Created by Rajeev Ranjan on 11/01/2018.
 */

public class MotorQuoteAdapter extends RecyclerView.Adapter<MotorQuoteAdapter.QuoteItem> implements View.OnClickListener {
    Fragment mFrament;
    List<QuoteListEntity> mQuoteList;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public MotorQuoteAdapter(Fragment context, List<QuoteListEntity> list) {
        this.mFrament = context;
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

            holder.txtPersonName.setText(entity.getMotorRequestEntity().getFirst_name()
                    + " " + entity.getMotorRequestEntity().getLast_name());
            try {
                CarMasterEntity carMasterEntity = new DBPersistanceController(mFrament.getActivity())
                        .getVarientDetails(
                                "" + entity.getMotorRequestEntity().getVehicle_id());
                holder.txtVehicleName.setText(carMasterEntity.getMake_Name() + "," + carMasterEntity.getModel_Name());

            } catch (Exception e) {

            }
            holder.txtQuoteDate.setText(entity.getMotorRequestEntity().getCreated_date());
            holder.txtCrnNo.setText("" + entity.getMotorRequestEntity().getCrn());

//            holder.txtOverflowMenu.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    openPopUp(view, entity);
//                }
//            });


            //set tag for sharing entity

            holder.txtCrnNo.setTag(R.id.txtCrnNo, entity);
            holder.txtQuoteDate.setTag(R.id.txtQuoteDate, entity);
            holder.txtVehicleName.setTag(R.id.txtVehicleName, entity);
            holder.txtPersonName.setTag(R.id.txtPersonName, entity);
            holder.txtOverflowMenu.setTag(R.id.txtOverflowMenu, entity);

            //click listener
            holder.txtCrnNo.setOnClickListener(this);
            holder.txtQuoteDate.setOnClickListener(this);
            holder.txtVehicleName.setOnClickListener(this);
            holder.txtPersonName.setOnClickListener(this);
            holder.txtOverflowMenu.setOnClickListener(this);

        }
    }

    private void openPopUp(View v, final QuoteListEntity entity) {
        final PopupMenu popupMenu = new PopupMenu(mFrament.getActivity(), v);
        final Menu menu = popupMenu.getMenu();

        popupMenu.getMenuInflater().inflate(R.menu.recycler_menu_quote, menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuCall:
                        Toast.makeText(mFrament.getActivity(), "WIP " + entity.getMotorRequestEntity().getMobile(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuSms:
                        Toast.makeText(mFrament.getActivity(), "WIP SMS ", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuDelete:
                        ((MotorQuoteFragment) mFrament).removeQuote(entity);
                        break;
                }
                return false;
            }
        });

        popupMenu.show();
    }

    @Override
    public int getItemCount() {
        return mQuoteList.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtCrnNo:
            case R.id.txtQuoteDate:
            case R.id.txtVehicleName:
            case R.id.txtPersonName:
                ((MotorQuoteFragment) mFrament).redirectToInputQuote((QuoteListEntity) view.getTag(view.getId()));
                break;
            case R.id.txtOverflowMenu:
                openPopUp(view, (QuoteListEntity) view.getTag(view.getId()));
                break;

        }
    }

    public class QuoteItem extends RecyclerView.ViewHolder {

        //  public ImageView ivTripleDot;
        public TextView txtQuoteDate, txtVehicleName, txtPersonName, txtOverflowMenu, txtCrnNo;


        public QuoteItem(View itemView) {
            super(itemView);
            txtQuoteDate = (TextView) itemView.findViewById(R.id.txtQuoteDate);
            txtVehicleName = (TextView) itemView.findViewById(R.id.txtVehicleName);
            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);
            txtOverflowMenu = (TextView) itemView.findViewById(R.id.txtOverflowMenu);
            txtCrnNo = (TextView) itemView.findViewById(R.id.txtCrnNo);
        }
    }

    public void refreshAdapter(List<QuoteListEntity> list) {
        mQuoteList = list;
    }
}
