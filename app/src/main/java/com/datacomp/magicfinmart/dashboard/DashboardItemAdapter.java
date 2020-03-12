package com.datacomp.magicfinmart.dashboard;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity;

public class DashboardItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Fragment mContext;
    List<DashboardMultiLangEntity> listInsur;
    DBPersistanceController dbPersistanceController;
    int fbaId = 0;
    String LangType;

    public DashboardItemAdapter(Fragment context, List<DashboardMultiLangEntity> list, String langType) {
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
        LinearLayout lyParent;


        public DashboardItemHolder(View view) {
            super(view);
            card_view = (CardView) view.findViewById(R.id.card_view);
            imgIcon = (ImageView) view.findViewById(R.id.imgIcon);
            imgNew = (ImageView) view.findViewById(R.id.imgNew);
            txtProductName = (TextView) view.findViewById(R.id.txtProductName);
            txtProductDesc = (TextView) view.findViewById(R.id.txtProductDesc);
            lyParent = (LinearLayout) view.findViewById(R.id.lyParent);

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
                Glide.with(mContext.getActivity()).load(listInsur.get(position).getServerIcon())
                        .into(((DashboardItemHolder) holder).imgIcon);
            } else {
                ((DashboardItemHolder) holder).imgIcon.setImageResource(listInsur.get(position).getIcon());
            }


            if ((!LangType.isEmpty()) && (!dbPersistanceController.getLangData(LangType,
                    listInsur.get(position).getProductNameKey()).trim().equals(""))) {
                ((DashboardItemHolder) holder).txtProductName.setText(dbPersistanceController.getLangData(LangType,
                        listInsur.get(position).getProductNameKey()));
                ((DashboardItemHolder) holder).txtProductDesc.setText(dbPersistanceController.getLangData(LangType,
                        listInsur.get(position).getProductDetailsKey()));


                ((BaseFragment) mContext).setLanguage(LangType, ((DashboardItemHolder) holder).txtProductName);
                ((BaseFragment) mContext).setLanguage(LangType, ((DashboardItemHolder) holder).txtProductDesc);


            } else {

                ((DashboardItemHolder) holder).txtProductName.setText(listInsur.get(position).getProductName());
                ((DashboardItemHolder) holder).txtProductDesc.setText(listInsur.get(position).getProductDetails());

            }


            if(listInsur.get(position).getIsExclusive() != null) {



                if (!listInsur.get(position).getProductBackgroundColor().isEmpty()) {

                    ((DashboardItemHolder) holder).lyParent.setBackgroundColor(Color.parseColor("#" + listInsur.get(position).getProductBackgroundColor()));
                } else {
                    ((DashboardItemHolder) holder).lyParent.setBackgroundColor(ContextCompat.getColor(mContext.getActivity(), R.color.white));
                }


                if (!listInsur.get(position).getProductNameFontColor().isEmpty()) {
                    ((DashboardItemHolder) holder).txtProductName.setTextColor(Color.parseColor("#" + listInsur.get(position).getProductNameFontColor()));
                } else {
                    ((DashboardItemHolder) holder).txtProductName.setTextColor(ContextCompat.getColor(mContext.getActivity(), R.color.dashboard_title));
                }

                if (!listInsur.get(position).getProductDetailsFontColor().isEmpty()) {
                    ((DashboardItemHolder) holder).txtProductDesc.setTextColor(Color.parseColor("#" + listInsur.get(position).getProductDetailsFontColor()));
                } else {
                    ((DashboardItemHolder) holder).txtProductDesc.setTextColor(ContextCompat.getColor(mContext.getActivity(), R.color.header_text_color));
                }

                if (listInsur.get(position).getIsExclusive().equals("Y")) {
                    ((DashboardItemHolder) holder).imgNew.setVisibility(View.VISIBLE);
                    Glide.with(mContext.getActivity()).
                            load(R.drawable.newicon)
                            .asGif()
                            .crossFade()
                            .into(((DashboardItemHolder) holder).imgNew);


                   // ((DashboardItemHolder) holder).card_view.setBackgroundResource(R.drawable.customeborder_blue_thin);
                } else {
                    ((DashboardItemHolder) holder).imgNew.setVisibility(View.GONE);
                  //  ((DashboardItemHolder) holder).card_view.setBackgroundResource(R.drawable.customeborder_grey_thin);
                }
            }


            //changed product id 17 to 12 for Commercial vehicle
            //date : 26/11/2019
//            if (listInsur.get(position).getProductId() == 12) {
//                ((DashboardItemHolder) holder).imgNew.setVisibility(View.VISIBLE);
//                Glide.with(mContext.getActivity()).
//                        load(R.drawable.newicon)
//                        .asGif()
//                        .crossFade()
//                        .into(((DashboardItemHolder) holder).imgNew);
//
//
//                ((DashboardItemHolder) holder).card_view.setBackgroundResource(R.drawable.customeborder_blue_thin);
//            } else {
//                ((DashboardItemHolder) holder).imgNew.setVisibility(View.GONE);
//                ((DashboardItemHolder) holder).card_view.setBackgroundResource(R.drawable.customeborder_grey_thin);
//            }





        }
    }

    @Override
    public int getItemCount() {
        return listInsur.size();
    }


//    public void setLanguage(Fragment mcontext, String langType, TextView tv) {
//
//        Typeface typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
//                "fonts/english.ttf");
//
//
//        switch (langType) {
//
//            case "English":
//                // English
//                typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
//                        "fonts/english.ttf");
//                break;
//
//            case "Hindi":
//                typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
//                        "fonts/hindi.ttf");
//                break;
//
//            case "Marathi":
//                typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
//                        "fonts/marathi.ttf");
//                break;
//
//            case "Gujrathi":
//                typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
//                        "fonts/gujrati.ttf");
//                break;
//
//
//            default:
//                typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
//                        "fonts/english.ttf");
//        }
//
//
//        tv.setTypeface(typeface);
//
//
//    }

//    public void setMenuLanguage( String langType, MenuItem tv) {
//
//        Typeface typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
//                "fonts/english.ttf");
//
//
//        switch (langType) {
//
//            case "English":
//                // English
//                typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
//                        "fonts/english.ttf");
//                break;
//
//            case "Hindi":
//                typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
//                        "fonts/hindi.ttf");
//                break;
//
//            case "Marathi":
//                typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
//                        "fonts/marathi.ttf");
//                break;
//
//            case "Gujrathi":
//                typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
//                        "fonts/gujrati.ttf");
//                break;
//
//
//            default:
//                typeface = Typeface.createFromAsset(mContext.getActivity().getAssets(),
//                        "fonts/english.ttf");
//        }
//
//
//      //  tv.setTypeface(typeface);
//
//        /////////////////////////////////////////////////////////////////////////////////////////////
//
//    }

}