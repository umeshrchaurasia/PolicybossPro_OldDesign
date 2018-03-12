package com.datacomp.magicfinmart.health.compare;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

public class HealthCompareViewAdapter extends RecyclerView.Adapter<HealthCompareViewAdapter.ViewHolder> {


    private LayoutInflater mInflater;
    Context mContext;


    // data is passed into the constructor
    HealthCompareViewAdapter(Context context) {
        mContext = context;
        this.mInflater = LayoutInflater.from(mContext);

    }


    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_benefits, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

//        holder.txtSumAssured.setText(listSumAssured.get(position).getDisplayValue());
//        if (listSumAssured.get(position).isSelected()) {
//            holder.txtSumAssured.setBackgroundResource(R.drawable.sumassuredborder_blue);
//        } else {
//            holder.txtSumAssured.setBackgroundResource(R.drawable.sumassured_border);
//        }
//        holder.txtSumAssured.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                holder.txtSumAssured.setBackgroundResource(R.drawable.sumassuredborder_blue);
//                for (int i = 0; i < listSumAssured.size(); i++) {
//                    listSumAssured.get(i).setSelected(false);
//                }
//                listSumAssured.get(position).setSelected(true);
//                ((HealthInputFragment) mContext).getSumAssured(listSumAssured.get(position).getSumAssuredAmount());
//                notifyDataSetChanged();
//            }
//        });
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return 22;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtSumAssured;

        ViewHolder(View itemView) {
            super(itemView);
            txtSumAssured = (TextView) itemView.findViewById(R.id.txtSumAssured);
        }


    }


}