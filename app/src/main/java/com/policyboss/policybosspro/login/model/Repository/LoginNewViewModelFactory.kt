package com.policyboss.policybosspro.login.model.Repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import magicfinmart.datacomp.com.finmartserviceapi.LoginPrefManager
import com.policyboss.policybosspro.login.model.viewmodel.LoginViewModel

class LoginNewViewModelFactory(
    private val repository: LoginNewRepository,
    private val loginPrefManager: LoginPrefManager
    ) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(LoginViewModel::class.java)){

            return LoginViewModel(repository, loginPrefManager) as T
        }

        throw IllegalArgumentException("ViewModel class Not Found")

    }

}