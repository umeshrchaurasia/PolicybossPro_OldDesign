package com.datacomp.magicfinmart.search_bo_fba

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.datacomp.magicfinmart.R
import kotlinx.android.synthetic.main.layout_bo_fba_search_item.view.*
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BOFbaEntity

class FBASearchAdapter(val fbaList: List<BOFbaEntity>, val iboFbaCallback: IBOFbaCallback, val context: Context) :
        RecyclerView.Adapter<FBASearchAdapter.FBAItem>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FBAItem {
        return FBAItem(LayoutInflater.from(context).inflate(R.layout.layout_bo_fba_search_item, parent, false))
    }

    override fun onBindViewHolder(holder: FBAItem, position: Int) {
        holder.txtFBAName.text = fbaList.get(position).fullName + " (FBA -" + fbaList.get(position).fbaid + ")"

        holder.llSearchFBA.setOnClickListener {
            iboFbaCallback.getBOFBA(fbaList.get(position))
        }
    }


    override fun getItemCount(): Int {
        if (fbaList != null)
            return fbaList.size
        else
            return 0
    }


    class FBAItem(v: View) : RecyclerView.ViewHolder(v) {
        var txtFBAName = v.txtFBAName
        var llSearchFBA = v.llSearchFBA
    }
}