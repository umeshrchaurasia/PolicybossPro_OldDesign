package com.policyboss.policybosspro.notification;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.policyboss.policybosspro.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.NotificationEntity;

/**
 * Created by IN-RB on 22-02-2018.
 */

public class NotificationAdapter  extends RecyclerView.Adapter<NotificationAdapter.NotificationItem> {

    Activity mContext;
    List<NotificationEntity>  NotificationLst;

    public NotificationAdapter(Activity mContext, List<NotificationEntity> notificationLst) {
        this.mContext = mContext;
        NotificationLst = notificationLst;
    }

    public class NotificationItem extends RecyclerView.ViewHolder
    {
        public TextView txtTitle , txtMessage,txtDate ,txtStatus,txtbar;
        public ImageView ivNotify,imgBigNotify, imgArrow;
        public LinearLayout lyParent;
        public RelativeLayout rlBigImg, rlArrow;
        View viewBigImg ;
        public NotificationItem(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtMessage = (TextView)itemView.findViewById(R.id.txtMessage);
            txtDate = (TextView)itemView.findViewById(R.id.txtDate);
            txtStatus = (TextView)itemView.findViewById(R.id.txtStatus);
            txtbar = (TextView)itemView.findViewById(R.id.txtbar);
            ivNotify = (ImageView) itemView.findViewById(R.id.ivNotify);
            imgArrow  = (ImageView) itemView.findViewById(R.id.imgArrow);
            imgBigNotify = (ImageView) itemView.findViewById(R.id.imgBigNotify);
            lyParent = (LinearLayout) itemView.findViewById(R.id.lyParent);
            rlBigImg = (RelativeLayout) itemView.findViewById(R.id.rlBigImg);
            viewBigImg  = (View) itemView.findViewById(R.id.viewBigImg);
            rlArrow = (RelativeLayout) itemView.findViewById(R.id.rlArrow);
        }
    }


    @Override
    public NotificationAdapter.NotificationItem onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.push_notify_item, parent, false);

        return new NotificationAdapter.NotificationItem(itemView);

    }

    @Override
    public void onBindViewHolder(NotificationItem holder, int position) {

        final NotificationEntity notificationEntity = NotificationLst.get(position);
        holder.txtTitle.setText( "" +notificationEntity.getTitle());
        holder.txtMessage.setText( "" +notificationEntity.getBody());
        holder.txtDate.setText( "" +notificationEntity.getDate());


        Glide.with(mContext)
                .load(notificationEntity.getImg_url())
                .placeholder(R.drawable.notification_ic) // can also be a drawable
                .into(holder.ivNotify);

        if(notificationEntity.getImg_url().trim().isEmpty()){
            holder.rlBigImg.setVisibility(View.GONE);
            holder.viewBigImg.setVisibility(View.GONE);
            holder.imgArrow.setVisibility(View.INVISIBLE);

        }
        else{
            if(notificationEntity.isOpen()){

                holder.rlBigImg.setVisibility(View.GONE);
                holder.viewBigImg.setVisibility(View.GONE);
                holder.imgArrow.setVisibility(View.VISIBLE);


            }
            else{

                holder.rlBigImg.setVisibility(View.VISIBLE);
                holder.viewBigImg.setVisibility(View.VISIBLE);
                holder.imgArrow.setVisibility(View.VISIBLE);

                Glide.with(mContext)
                        .load(notificationEntity.getImg_url())
                        .into(holder.imgBigNotify);
                // NotificationLst.get(position).setOpen(false);
            }
        }





        holder.lyParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ((NotificationActivity)mContext).redirectToApplyLoan(notificationEntity);
            }

        });

        holder.rlArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateList(notificationEntity);
            }

        });
    }

    private void updateList(NotificationEntity notificationEntity) {

        int pos = 0;
        for(int i=0; i<NotificationLst.size(); i++){

            if(NotificationLst.get(i).getMessage_id() == notificationEntity.getMessage_id()){

                pos = i;
                if(notificationEntity.isOpen()){
                    NotificationLst.get(i).setOpen(false);
                }else{
                    NotificationLst.get(i).setOpen(true);
                }
                break;


            }
        }

        notifyItemChanged(pos ,notificationEntity);
       // notifyDataSetChanged();
        //  refreshAdapter(lstSpecial);
    }


    @Override
    public int getItemCount() {
        return NotificationLst.size();
    }
}
