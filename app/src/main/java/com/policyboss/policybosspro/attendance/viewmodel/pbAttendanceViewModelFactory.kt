package com.policyboss.policybosspro.attendance.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.policyboss.policybosspro.attendance.pbAttendanceRepository
import com.policyboss.policybosspro.oauthtoken.model.repository.OauthTokenRepository
import com.policyboss.policybosspro.oauthtoken.model.viewmodel.OauthTokenViewModel

class pbAttendanceViewModelFactory(private val repository: pbAttendanceRepository) :
    ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(pbAttendanceViewModel::class.java)){

            return pbAttendanceViewModel(repository) as T
        }

        throw IllegalArgumentException("ViewModel class Not Found")

    }
}