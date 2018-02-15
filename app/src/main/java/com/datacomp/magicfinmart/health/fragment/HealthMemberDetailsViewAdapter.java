package com.datacomp.magicfinmart.health.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MemberListEntity;

public class HealthMemberDetailsViewAdapter extends RecyclerView.Adapter<HealthMemberDetailsViewAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    Context mContext;
    List<MemberListEntity> listMemberList;

    // data is passed into the constructor
    HealthMemberDetailsViewAdapter(Context context, List<MemberListEntity> listMemberList) {
        mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.listMemberList = listMemberList;
    }

    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_memberdetails, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        MemberListEntity entity = listMemberList.get(position);
        if (position == 0) {
            //enable llmaried
            holder.llMarried.setVisibility(View.VISIBLE);
            holder.rbMale.setChecked(true);
            holder.spHealthRelation.setSelection(1);

        } else if (position == 1) {
            //hide in all positions
            holder.llMarried.setVisibility(View.GONE);

            holder.rbFemale.setChecked(true);
            if (entity.getAge() > 18)
                holder.spHealthRelation.setSelection(2);
            else
                holder.spHealthRelation.setSelection(5);

        } else {
            holder.llMarried.setVisibility(View.GONE);

            holder.rbMale.setChecked(true);
            holder.spHealthRelation.setSelection(4);
        }

    }

    // total number of cells
    @Override
    public int getItemCount() {
        return listMemberList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llMarried;
        Switch swUnMarried;
        RadioButton rbMale, rbFemale;
        Spinner spHealthRelation;

        ViewHolder(View itemView) {
            super(itemView);
            llMarried = (LinearLayout) itemView.findViewById(R.id.llMarried);
            swUnMarried = (Switch) itemView.findViewById(R.id.swUnMarried);
            rbMale = (RadioButton) itemView.findViewById(R.id.rbMale);
            rbFemale = (RadioButton) itemView.findViewById(R.id.rbFemale);
            spHealthRelation = (Spinner) itemView.findViewById(R.id.spHealthRelation);
        }


    }


}