package com.datacomp.magicfinmart.offline_quotes.OfflineQuoteForm.offline_motor;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.OfflineMotorListEntity;


public class OfflineMotorListItemAdapter extends RecyclerView.Adapter<OfflineMotorListItemAdapter.OfflineMotorItem> {

    Activity mcontext;
    List<OfflineMotorListEntity> offlineMotorList;

    public OfflineMotorListItemAdapter(Activity mcontext, List<OfflineMotorListEntity> documentsOfflineList) {
        this.mcontext = mcontext;
        this.offlineMotorList = documentsOfflineList;
    }


    public class OfflineMotorItem extends RecyclerView.ViewHolder {

        TextView txtDocName;
        LinearLayout lyParent;


        public OfflineMotorItem(View view) {
            super(view);
            txtDocName = (TextView) view.findViewById(R.id.txtDocName);
            lyParent = (LinearLayout) view.findViewById(R.id.lyParent);
        }
    }

    @Override
    public OfflineMotorItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_offiline_doc_item, parent, false);
        return new OfflineMotorItem(view);
    }

    @Override
    public void onBindViewHolder(OfflineMotorItem holder, int position) {


    }


    @Override
    public int getItemCount() {
        return offlineMotorList.size();
    }
}
