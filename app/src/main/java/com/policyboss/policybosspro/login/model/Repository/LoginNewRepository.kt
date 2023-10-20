package com.policyboss.policybosspro.login.model.Repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.Syncontact.SyncContactInterface

class LoginNewRepository(private  val apiService : SyncContactInterface) {

 suspend fun getLoginHorizonDetails(userId : String ) = flow {


     val response = apiService.getLoginDsasHorizonDetails(userId = userId)

     emit(response)
   }.flowOn(Dispatchers.IO)


}