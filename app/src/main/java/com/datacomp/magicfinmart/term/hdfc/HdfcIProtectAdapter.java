package com.datacomp.magicfinmart.term.hdfc;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import java.util.List;

/**
 * Created by IN-RB on 21-05-2018.
 */

public class HdfcIProtectAdapter  extends RecyclerView.Adapter<HdfcIProtectAdapter.MyViewHolder>{

    Activity mContext;
    List<String> IprotectLst;

    public HdfcIProtectAdapter(Activity mContext, List<String> iprotectLst) {
        this.mContext = mContext;
        IprotectLst = iprotectLst;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtTitle , txtMessage,txtDate ,txtStatus,txtbar;
        public ImageView ivNotify;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtMessage = (TextView)itemView.findViewById(R.id.txtMessage);
            ivNotify = (ImageView) itemView.findViewById(R.id.ivNotify);

        }
    }


    @Override
    public HdfcIProtectAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.push_notify_item, parent, false);

        return new HdfcIProtectAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 0;
    }
}
