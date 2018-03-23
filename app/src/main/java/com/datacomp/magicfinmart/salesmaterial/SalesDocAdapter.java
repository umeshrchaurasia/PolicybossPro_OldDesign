package com.datacomp.magicfinmart.salesmaterial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.design.CustomImageView;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity;

/**
 * Created by IN-RB on 23-02-2018.
 */

public class SalesDocAdapter extends RecyclerView.Adapter<SalesDocAdapter.SalesDocItem>{

    Context mContex;
    List<DocsEntity> docLst;

    public SalesDocAdapter(Context mContex, List<DocsEntity> docLst) {
        this.mContex = mContex;
        this.docLst = docLst;
    }


    public class SalesDocItem extends RecyclerView.ViewHolder{

        CustomImageView ivProduct;
        LinearLayout lyParent;


        public SalesDocItem(View itemView) {
            super(itemView);
            ivProduct = (CustomImageView) itemView.findViewById(R.id.ivProduct);
            lyParent = (LinearLayout) itemView.findViewById(R.id.lyParent);

        }
    }


    @Override
    public SalesDocAdapter.SalesDocItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_doc_item, parent, false);
        return new SalesDocAdapter.SalesDocItem(itemView);
    }

    @Override
    public void onBindViewHolder(SalesDocAdapter.SalesDocItem holder, int position) {

      final   DocsEntity docsEntity = docLst.get(position);

        Glide.with(mContex)
                .load(docsEntity.getImage_path())
                .placeholder(R.drawable.finmart_placeholder) // can also be a drawable
                .into(holder.ivProduct);

        holder.lyParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SalesDetailActivity)mContex).redirectToApplyMain(docsEntity);
            }
        });

    }

    @Override
    public int getItemCount() {
        return docLst.size();
    }
}
