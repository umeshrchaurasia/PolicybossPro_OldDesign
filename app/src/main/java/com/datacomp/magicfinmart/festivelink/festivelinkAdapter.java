package com.datacomp.magicfinmart.festivelink;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.R;

import java.util.List;

import butterknife.internal.Utils;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.FestivalCompaignEntity;


public class festivelinkAdapter extends RecyclerView.Adapter<festivelinkAdapter.MyViewHolder> {

    Context mContext;
    List<FestivalCompaignEntity> lstShareMessageEntities;
  //  private static   Uri imageUri = null;
    public festivelinkAdapter(Context mContext, List<FestivalCompaignEntity> lstShareMessageEntities) {
        this.mContext = mContext;
        this.lstShareMessageEntities = lstShareMessageEntities;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.festive_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final FestivalCompaignEntity lstShareMessageEntity = lstShareMessageEntities.get(position);
        holder.txtName.setText(lstShareMessageEntity.getName());
        holder.txttitle.setText(lstShareMessageEntity.getTitle());
        holder.txtshorturl.setText(lstShareMessageEntity.getShorturl());

        if (lstShareMessageEntity.getImagelink() != null) {

                        Glide.with(mContext)
                    .load(lstShareMessageEntity.getImagelink())
                    .into(holder.imageView);

        }
        holder.btnCallshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String whatsAppMessage = lstShareMessageEntity.getShorturl();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, whatsAppMessage);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_STREAM,lstShareMessageEntity.getImagelink());
                intent.setType("image/jpeg");
                intent.setPackage("com.whatsapp");
                mContext.startActivity(intent);
           }
        });

        holder.btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  datashareList(lstShareMessageEntity.getTitle(), lstShareMessageEntity.getMsgBody(), lstShareMessageEntity.getLink());
            }
        });


    }

    @Override
    public int getItemCount() {
        return lstShareMessageEntities.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName, txttitle,txtshorturl;
        ImageView btnCallshare, imageView, btnsms, btnemail;

        public MyViewHolder(@NonNull View view) {
            super(view);
            txtName = (TextView) itemView.findViewById(R.id.txtname);
            txtshorturl = (TextView) itemView.findViewById(R.id.txtname);
            txttitle = (TextView) itemView.findViewById(R.id.txttitle);
            btnsms = (ImageView) itemView.findViewById(R.id.btnsms);
            btnCallshare = (ImageView) itemView.findViewById(R.id.btnCallshare);
            btnemail = (ImageView) itemView.findViewById(R.id.btnemail);
            imageView = (ImageView) itemView.findViewById(R.id.imglink);
        }
    }
}
