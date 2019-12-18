package com.datacomp.magicfinmart.attendance


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.datacomp.magicfinmart.BaseFragment

import com.datacomp.magicfinmart.R
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController

/**
 * A simple [Fragment] subclass.
 */
class AttendanceFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attendance, container, false)
    }

    private fun getUID(): String {

        DBPersistanceController(activity).userConstantsData.ui
    }


}
