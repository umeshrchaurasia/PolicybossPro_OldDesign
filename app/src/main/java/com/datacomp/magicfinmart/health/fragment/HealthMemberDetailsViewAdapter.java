package com.datacomp.magicfinmart.health.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.motor.privatecar.fragment.InputFragment;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MemberListEntity;

public class HealthMemberDetailsViewAdapter extends RecyclerView.Adapter<HealthMemberDetailsViewAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    Context mContext;
    List<MemberListEntity> listMemberList;
    String[] relationShip;

    // data is passed into the constructor
    HealthMemberDetailsViewAdapter(Context context, List<MemberListEntity> listMemberList) {
        mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.listMemberList = listMemberList;
        relationShip = mContext.getResources().getStringArray(R.array.health_relationship);
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

        final MemberListEntity entity = listMemberList.get(position);
        ArrayAdapter<String> relationAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item,
                relationShip) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setPadding(8, 12, 4, 12);
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        holder.spHealthRelation.setAdapter(relationAdapter);
        holder.spHealthRelation.setTag(R.id.spHealthRelation, entity);
        holder.rbMale.setTag(R.id.llMarried, entity);
        holder.rbFemale.setTag(R.id.llMarried, entity);
        holder.swUnMarried.setTag(R.id.swUnMarried, entity);
        holder.txtMarried.setTextColor(mContext.getResources().getColor(R.color.colorAccent));


        holder.spHealthRelation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MemberListEntity memberListEntity = (MemberListEntity) holder.spHealthRelation.getTag(R.id.spHealthRelation);
                memberListEntity.setMemberRelationShip(holder.spHealthRelation.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        holder.swUnMarried.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                MemberListEntity entity = (MemberListEntity) compoundButton.getTag(compoundButton.getId());
                if (b) {
                    //if true maritial status ID =1
                    //false maritial status ID =2
                    holder.txtMarried.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
                    holder.txtSingle.setTextColor(mContext.getResources().getColor(R.color.description_text));
                    ((HealthMemberDetailsDialogActivity) mContext).updateMemberList(entity, 1, position);
                } else {
                    ((HealthMemberDetailsDialogActivity) mContext).updateMemberList(entity, 2, position);
                    holder.txtMarried.setTextColor(mContext.getResources().getColor(R.color.description_text));
                    holder.txtSingle.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
                }
            }
        });

        holder.rbMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    entity.setMemberGender("M");

                } else {
                    entity.setMemberGender("F");
                }
                //update fragment
                ((HealthMemberDetailsDialogActivity) mContext).updateMemberList(entity, 0, position);
            }
        });
        if (position == 0) {
            //enable llmaried
            holder.llMarried.setVisibility(View.VISIBLE);
            holder.rbMale.setChecked(true);
            holder.spHealthRelation.setSelection(1);
            entity.setMemberGender("M");

        } else if (position == 1) {
            //hide in all positions
            holder.llMarried.setVisibility(View.GONE);

            holder.rbFemale.setChecked(true);

            if (entity.getAge() > 18)
                holder.spHealthRelation.setSelection(2);
            else
                holder.spHealthRelation.setSelection(5);

            entity.setMemberGender("F");

        } else if (position == 2) {
            holder.llMarried.setVisibility(View.GONE);

            holder.rbMale.setChecked(true);

            if (entity.getAge() > 18)
                holder.spHealthRelation.setSelection(3);
            else
                holder.spHealthRelation.setSelection(5);

            entity.setMemberGender("M");

        } else if (position == 3) {
            holder.llMarried.setVisibility(View.GONE);

            holder.rbFemale.setChecked(true);

            if (entity.getAge() > 18)
                holder.spHealthRelation.setSelection(4);
            else
                holder.spHealthRelation.setSelection(5);

            entity.setMemberGender("F");

        } else if (position == 4) {
            holder.llMarried.setVisibility(View.GONE);

            holder.rbMale.setChecked(true);

            if (entity.getAge() > 18)
                holder.spHealthRelation.setSelection(3);
            else
                holder.spHealthRelation.setSelection(5);

            entity.setMemberGender("M");

        } else if (position == 5) {
            holder.llMarried.setVisibility(View.GONE);

            holder.rbMale.setChecked(true);

            if (entity.getAge() > 18)
                holder.spHealthRelation.setSelection(3);
            else
                holder.spHealthRelation.setSelection(5);

            entity.setMemberGender("M");
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
        TextView txtSingle, txtMarried;

        ViewHolder(View itemView) {
            super(itemView);
            llMarried = (LinearLayout) itemView.findViewById(R.id.llMarried);
            swUnMarried = (Switch) itemView.findViewById(R.id.swUnMarried);
            rbMale = (RadioButton) itemView.findViewById(R.id.rbMale);
            rbFemale = (RadioButton) itemView.findViewById(R.id.rbFemale);
            spHealthRelation = (Spinner) itemView.findViewById(R.id.spHealthRelation);
            txtMarried = (TextView) itemView.findViewById(R.id.txtMarried);
            txtSingle = (TextView) itemView.findViewById(R.id.txtSingle);

        }


    }


}