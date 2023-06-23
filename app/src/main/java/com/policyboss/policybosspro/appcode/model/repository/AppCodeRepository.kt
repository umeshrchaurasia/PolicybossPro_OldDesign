package com.policyboss.policybosspro.appcode.model.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.Syncontact.SyncContactInterface

class AppCodeRepository(private val apiService : SyncContactInterface) {


    suspend fun getAuthToken(body : HashMap<String,String>) = flow {


        val response = apiService.getOauthToken(body)
        emit(response)

    }.flowOn(Dispatchers.IO)
}