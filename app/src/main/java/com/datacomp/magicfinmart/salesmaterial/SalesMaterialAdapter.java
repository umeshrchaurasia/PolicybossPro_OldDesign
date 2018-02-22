package com.datacomp.magicfinmart.salesmaterial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity;

/**
 * Created by Nilesh on 05/02/2018.
 */

public class SalesMaterialAdapter extends RecyclerView.Adapter<SalesMaterialAdapter.SalesMaterialItem> {

    Context mContex;
    List<SalesProductEntity> mlistSalesProduct;

    public SalesMaterialAdapter(Context context, List<SalesProductEntity> list) {
        this.mContex = context;
        mlistSalesProduct = list;
    }

    @Override
    public SalesMaterialItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_sales_product_item, parent, false);
        return new SalesMaterialItem(itemView);
    }

    @Override
    public void onBindViewHolder(SalesMaterialItem holder, int position) {
        SalesMaterialItem item = (SalesMaterialItem) holder;
        SalesProductEntity entity = mlistSalesProduct.get(position);
        if (entity.getCount() != 0) {
            item.txtCount.setText(String.valueOf(entity.getCount()));
        } else {
            item.txtCount.setVisibility(View.INVISIBLE);
        }
        item.txtProductName.setText(entity.getProduct_Name());

        Glide.with(mContex).load(entity.getProduct_image()).into(item.imgProduct);
    }


    @Override
    public int getItemCount() {
        return mlistSalesProduct.size();
    }

    public class SalesMaterialItem extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView txtCount, txtProductName;

        public SalesMaterialItem(View itemView) {
            super(itemView);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
            txtCount = (TextView) itemView.findViewById(R.id.txtCount);
            txtProductName = (TextView) itemView.findViewById(R.id.txtProductName);
        }
    }

}
