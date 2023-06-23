package com.policyboss.policybosspro.appcode.model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.policyboss.policybosspro.appcode.model.repository.AppCodeRepository


class AppCodeViewModelFactory(private val repository: AppCodeRepository) :ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(AppCodeViewModel::class.java)){

            return AppCodeViewModel(repository) as T
        }

        throw IllegalArgumentException("ViewModel class Not Found")

    }
}