package com.policyboss.policybosspro.oauthtoken.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class OauthTokenViewModelFactory(private val repository: OauthTokenRepository) :ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(OauthTokenViewModel::class.java)){

            return OauthTokenViewModel(repository) as T
        }

        throw IllegalArgumentException("ViewModel class Not Found")

    }
}