package com.datacomp.magicfinmart.motor.privatecar.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.fragment.MotorLeadFragment;
import com.datacomp.magicfinmart.motor.privatecar.fragment.MotorQuoteFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MotorMyLeadEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;

/**
 * Created by Rajeev Ranjan on 07/05/2019.
 */
public class MotorLeadAdapter extends RecyclerView.Adapter<MotorLeadAdapter.LeadItem> implements View.OnClickListener, Filterable {

    Fragment mFrament;
    List<MotorMyLeadEntity> mLeadList;
    List<MotorMyLeadEntity> mLeadListFiltered;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public MotorLeadAdapter(Fragment context, List<MotorMyLeadEntity> list) {
        this.mFrament = context;
        this.mLeadList = list;
        mLeadListFiltered = list;
    }


    public class LeadItem extends RecyclerView.ViewHolder {

        public TextView txtQuoteDate, txtVehicleName, txtPersonName, txtCrnNo ,txtNew ,txtEdit;
        LinearLayout llDetails;


        public LeadItem(View itemView) {
            super(itemView);
            txtQuoteDate = (TextView) itemView.findViewById(R.id.txtQuoteDate);
            txtVehicleName = (TextView) itemView.findViewById(R.id.txtVehicleName);
            txtPersonName = (TextView) itemView.findViewById(R.id.txtPersonName);

            txtCrnNo = (TextView) itemView.findViewById(R.id.txtCrnNo);
            txtNew = (TextView) itemView.findViewById(R.id.txtNew);
            txtEdit = (TextView) itemView.findViewById(R.id.txtEdit);

            llDetails = (LinearLayout) itemView.findViewById(R.id.llDetails);

        }
    }

    @Override
    public MotorLeadAdapter.LeadItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_motor_lead, parent, false);
        return new MotorLeadAdapter.LeadItem(itemView);
    }

    @Override
    public void onBindViewHolder(MotorLeadAdapter.LeadItem holder, int position) {

        if (holder instanceof MotorLeadAdapter.LeadItem) {

            final MotorMyLeadEntity entity = mLeadListFiltered.get(position);

           if(entity.getCRN().trim().equals(""))
           {
               holder.txtNew.setText("NEW");
               holder.txtNew.setBackgroundResource(R.drawable.add_icon_resize);
               holder.txtNew.setVisibility(View.VISIBLE);

               holder.txtEdit.setVisibility(View.GONE);
           }else{
               holder.txtNew.setText("VIEW");
               holder.txtNew.setBackgroundResource(R.drawable.view_icon_resize);
               holder.txtNew.setVisibility(View.VISIBLE);

               holder.txtEdit.setVisibility(View.VISIBLE);
           }

            holder.txtPersonName.setText(entity.getName());
            holder.txtVehicleName.setText(entity.getMake() + "," + entity.getModel());


            holder.txtQuoteDate.setText(entity.getExpiryDate());
            holder.txtCrnNo.setText("" + entity.getCRN());

            holder.txtNew.setTag(R.id.txtNew, entity);
            holder.txtEdit.setTag(R.id.txtEdit, entity);

            holder.txtNew.setOnClickListener(this);
            holder.txtEdit.setOnClickListener(this);
        }


    }

    @Override
    public int getItemCount() {
        if (mLeadListFiltered != null)
            return mLeadListFiltered.size();
        else
            return 0;
    }

    public void refreshAdapter(List<MotorMyLeadEntity> list) {
        mLeadList = list;
        mLeadListFiltered = list;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

//            case R.id.txtNew:
//
//               if( ((Button)view).getText().equals("VIEW")) {
//                   ((MotorLeadFragment) mFrament).redirectToInputQuote((MotorMyLeadEntity) view.getTag(view.getId()));
//               }else{
//                   ((MotorLeadFragment) mFrament).redirectToInputQuote((MotorMyLeadEntity) view.getTag(view.getId()));
//               }
//                break;
//            case R.id.txtEdit:
//                ((MotorLeadFragment) mFrament).redirectToInputQuote((MotorMyLeadEntity) view.getTag(view.getId()));
//                break;

            case R.id.txtNew:
            case R.id.txtEdit:
                ((MotorLeadFragment) mFrament).redirectToInputQuote((MotorMyLeadEntity) view.getTag(view.getId()));
                break;

        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mLeadListFiltered = mLeadList;
                } else {
                    List<MotorMyLeadEntity> filteredList = new ArrayList<>();
                    for (MotorMyLeadEntity row : mLeadList) {
                        CarMasterEntity carMasterEntity = new CarMasterEntity();

                        if (row.getName().toLowerCase().contains(charString.toLowerCase())

                                || String.valueOf(row.getCRN()).contains(charString.toLowerCase())) {

                            filteredList.add(row);
                        }

//                        if (carMasterEntity != null) {
//                            if (carMasterEntity.getMake_Name().toLowerCase().contains(charString.toLowerCase())
//                                    || carMasterEntity.getModel_Name().toLowerCase().contains(charString.toLowerCase())) {
//                                filteredList.add(row);
//                            }
//                        }

                    }

                    mLeadListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mLeadListFiltered;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mLeadListFiltered = (ArrayList<MotorMyLeadEntity>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
