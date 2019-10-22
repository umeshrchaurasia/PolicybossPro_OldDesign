package com.datacomp.magicfinmart.festivelink;

import android.content.Context;
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

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.festivelinkEntity;


public class festivelinkAdapter  extends RecyclerView.Adapter<festivelinkAdapter.MyViewHolder>{

    Context mContext;
    List<festivelinkEntity> lstShareMessageEntities;

    public festivelinkAdapter(Context mContext, List<festivelinkEntity> lstShareMessageEntities) {
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
    final festivelinkEntity lstShareMessageEntity = lstShareMessageEntities.get(position);
        holder.txtName.setText(lstShareMessageEntity.getName());
        holder.txttitle.setText(lstShareMessageEntity.getTitle());

        if (lstShareMessageEntity.getImagelink()!= null) {

            Glide.with(mContext)
                    .load(lstShareMessageEntity.getImagelink())
                    .into(holder.imglink);
        }
        holder.btnCallshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  datashareList(lstShareMessageEntity.getTitle(), lstShareMessageEntity.getMsgBody(), lstShareMessageEntity.getLink());
            }
        });

        holder.btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  datashareList(lstShareMessageEntity.getTitle(), lstShareMessageEntity.getMsgBody(), lstShareMessageEntity.getLink());
            }
        });

        holder.btnemail.setOnClickListener(new View.OnClickListener() {
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
        public TextView txtName, txttitle;
        ImageView btnCallshare,imglink,btnsms,btnemail;
        public MyViewHolder(@NonNull View view) {
            super(view);
            txtName = (TextView) itemView.findViewById(R.id.txtFollowupName);

            txttitle = (TextView) itemView.findViewById(R.id.txttitle);
            btnsms = (ImageView) itemView.findViewById(R.id.btnsms);
            btnCallshare = (ImageView) itemView.findViewById(R.id.btnCallshare);
            btnemail = (ImageView) itemView.findViewById(R.id.btnemail);
            imglink = (ImageView) itemView.findViewById(R.id.imglink);
        }
    }
}
