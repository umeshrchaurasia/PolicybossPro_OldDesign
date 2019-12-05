package com.datacomp.magicfinmart.dashboard;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity;

public class DashboardItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Fragment mContext;
    List<DashboardEntity> listInsur;
    DBPersistanceController dbPersistanceController;
    int fbaId = 0;
    String LangType;

    public DashboardItemAdapter(Fragment context, List<DashboardEntity> list,String langType) {
        mContext = context;
        listInsur = list;
        LangType = langType;
        dbPersistanceController = new DBPersistanceController(mContext.getActivity());
        if (dbPersistanceController.getUserData().getFBAId() != 0) {
            fbaId = dbPersistanceController.getUserData().getFBAId();
        }
    }

    public class DashboardItemHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon, imgNew;
        TextView txtProductName, txtProductDesc;
        CardView card_view;

        public DashboardItemHolder(View view) {
            super(view);
            card_view = (CardView) view.findViewById(R.id.card_view);
            imgIcon = (ImageView) view.findViewById(R.id.imgIcon);
            imgNew = (ImageView) view.findViewById(R.id.imgNew);
            txtProductName = (TextView) view.findViewById(R.id.txtProductName);
            txtProductDesc = (TextView) view.findViewById(R.id.txtProductDesc);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.dashboard_rv_item, parent, false);
        return new DashboardItemHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof DashboardItemHolder) {
            if (listInsur.get(position).getIcon() == -1) {
                Glide.with(mContext).load(listInsur.get(position).getServerIcon())
                        .into(((DashboardItemHolder) holder).imgIcon);
            } else {
                ((DashboardItemHolder) holder).imgIcon.setImageResource(listInsur.get(position).getIcon());
            }


            if(LangType != "") {

                ((DashboardItemHolder) holder).txtProductName.setText(dbPersistanceController.getLanguageData(LangType,listInsur.get(position).getProductName()));
                ((DashboardItemHolder) holder).txtProductDesc.setText(dbPersistanceController.getLanguageData(LangType,listInsur.get(position).getProductDetails()));

                setLanguage(mContext,LangType,  ((DashboardItemHolder) holder).txtProductName);
                setLanguage(mContext,LangType,  ((DashboardItemHolder) holder).txtProductDesc);
            }else{

                ((DashboardItemHolder) holder).txtProductName.setText(listInsur.get(position).getProductName());
                ((DashboardItemHolder) holder).txtProductDesc.setText(listInsur.get(position).getProductDetails());

            }



            //changed product id 17 to 12 for Commercial vehicle
            //date : 26/11/2019
            if (listInsur.get(position).getProductId() == 12) {
                ((DashboardItemHolder) holder).imgNew.setVisibility(View.VISIBLE);
                Glide.with(mContext).
                        load(R.drawable.newicon)
                        .asGif()
                        .crossFade()
                        .into(((DashboardItemHolder) holder).imgNew);


                ((DashboardItemHolder) holder).card_view.setBackgroundResource(R.drawable.customeborder_blue_thin);
            } else {
                ((DashboardItemHolder) holder).imgNew.setVisibility(View.GONE);
                ((DashboardItemHolder) holder).card_view.setBackgroundResource(R.drawable.customeborder_grey_thin);
            }

        }
    }

    @Override
    public int getItemCount() {
        return listInsur.size();
    }


    public void setLanguage(Fragment mcontext, String langType, TextView tv) {

        Typeface typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
                "fonts/english.ttf");
        if (langType.equals("EN")) {

            // English
            typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
                    "fonts/english.ttf");
            //tv.setTypeface(fontHindi);
        } else if (langType.equals("HI")) {
            typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
                    "fonts/hindi.ttf");
        } else if (langType.equals("MA")) {
            typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
                    "fonts/marathi.ttf");
        } else if (langType.equals("GU")) {
            typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
                    "fonts/gujrati.ttf");
        }

        tv.setTypeface(typeface);

//        for (int i = 0; i < viewList.size(); i++) {
//            viewList.get(i).setTypeface(typeface);
//        }


    }

}