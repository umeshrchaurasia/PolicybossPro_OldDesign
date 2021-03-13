package com.policyboss.magicfinmart.attendance

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.policyboss.magicfinmart.R
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model.SwipeDetailsEntity

/**
 * Created by Rajeev Ranjan on 30/12/2019.
 */
class AttendanceAdapter(val context: Context, val attendDetailEntityList: List<SwipeDetailsEntity>) : RecyclerView.Adapter<AttendanceAdapter.AttendeanceItem>() {


    class AttendeanceItem(view: View) : RecyclerView.ViewHolder(view) {



        val txtDate = view.findViewById<TextView>(R.id.txtDate);
        val txtloc = view.findViewById<TextView>(R.id.txtLoc);
        val txtCity = view.findViewById<TextView>(R.id.txtCity);
        val txtType = view.findViewById<TextView>(R.id.txtType);
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendeanceItem {

        return AttendanceAdapter.AttendeanceItem(
                LayoutInflater.from(context).inflate(
                        R.layout.attendance_item,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {
        return attendDetailEntityList.size
    }

    override fun onBindViewHolder(holder: AttendeanceItem, position: Int) {


        val swipeDetailsEntity = attendDetailEntityList[position]

        holder.txtDate.text = swipeDetailsEntity.datetime
        holder.txtType.text = swipeDetailsEntity.entrytype

    }
}