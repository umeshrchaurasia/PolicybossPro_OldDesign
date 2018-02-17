package com.datacomp.magicfinmart.health.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import java.util.HashMap;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;

public class HealthQuoteExpandableListAdapter extends BaseExpandableListAdapter {


    List<HealthQuoteEntity> listDataHeader; // header titles
    // child data in format of header title, child title
    HashMap<HealthQuoteEntity, List<HealthQuoteEntity>> listDataChild;

    Context mContext;

    public HealthQuoteExpandableListAdapter(Context context, List<HealthQuoteEntity> listHeader,
                                            HashMap<HealthQuoteEntity, List<HealthQuoteEntity>> listChildData) {
        this.mContext = context;
        this.listDataHeader = listHeader;
        this.listDataChild = listChildData;
    }

    //child object return
    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final HealthQuoteEntity childText = (HealthQuoteEntity) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_elv_child_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);

        txtListChild.setText(String.valueOf(childText.getSumInsured()));

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        if (this.listDataChild.get(listDataHeader.get(groupPosition)) != null) {
            return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                    .size();
        } else {
            return 0;
        }
    }


    //header item return here.
    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        HealthQuoteEntity entity = (HealthQuoteEntity) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_elv_group_header, null);
        }


        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(entity.getPlanName());

        /*
        ((TextView) convertView
                .findViewById(R.id.txtSumAssured)).setText("" + entity.getSumInsured());
        ((TextView) convertView
                .findViewById(R.id.txtDeductible)).setText("" + entity.getDeductible_Amount());
        ((TextView) convertView
                .findViewById(R.id.txtPlanName)).setText("" + entity.getPlanName());
        ((TextView) convertView
                .findViewById(R.id.txtFinalPremium)).setText("\u20B9 " + Math.round(entity.getNetPremium()) + " /Year");

        ((ImageView) convertView
                .findViewById(R.id.imgInsurer))
                .setImageResource(new DBPersistanceController(mContext).getInsurerImage(entity.getInsurerId()));
*/

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}