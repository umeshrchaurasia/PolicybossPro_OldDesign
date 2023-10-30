package com.policyboss.policybosspro.login.model.Repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.Syncontact.SyncContactInterface
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.POSP

class LoginNewRepository(private  val apiService : SyncContactInterface) {


    suspend fun getusersignup(body : HashMap<String,String> ) = flow {


        val response = apiService.getusersignup(body = body)

        emit(response)
    }.flowOn(Dispatchers.IO)

    suspend fun getLoginHorizonDetails(userId : String ) = flow {


     val response = apiService.getLoginDsasHorizonDetails(userId = userId)

        emit(response)
   }.flowOn(Dispatchers.IO)


    suspend fun otpLoginHorizon(body : HashMap<String,String> ) = flow {


        val response = apiService.otpLoginHorizon(body = body)

        emit(response)
    }.flowOn(Dispatchers.IO)

    suspend fun otpVerifyHorizon(userId : String ) = flow {


        val response = apiService.otpVerifyHorizon(userId = userId)

        emit(response)
    }.flowOn(Dispatchers.IO)

    suspend fun otpResendHorizon(userId : String ) = flow {


        val response = apiService.otpResendHorizon(userId = userId)

        emit(response)
    }.flowOn(Dispatchers.IO)

    suspend fun authLoginHorizon(body : HashMap<String,String> ) = flow {


        val response = apiService.authLoginHorizon(body = body)

        emit(response)
    }.flowOn(Dispatchers.IO)

    //otpVerifyHorizon

    suspend fun forgotPassword(body : HashMap<String,String> ) = flow {


        val response = apiService.forgotPassword(body = body)

        emit(response)
    }.flowOn(Dispatchers.IO)


}