package com.policyboss.policybosspro.utility

import android.content.Context
import android.util.Log

import kotlinx.coroutines.*
import magicfinmart.datacomp.com.finmartserviceapi.BuildConfig
import magicfinmart.datacomp.com.finmartserviceapi.Utility
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.RetroHelper


class CoroutineHelper {



    companion object{

        @JvmStatic
        fun saveDeviceDetails(context: Context,   ss_id : String, action_type : String)  {


            CoroutineScope(Dispatchers.IO).launch {
                try { //showDialog()

                    withContext(Dispatchers.IO) {

                        var url = BuildConfig.FINMART_URL + "/app_visitor/save_device_details"
                        val body = HashMap<String,String>()
                        body.put("ss_id",ss_id)
                        body.put("device_id",UTILITY.getDeviceID(context))

                        body.put("device_name",UTILITY.getDeviceName())
                        body.put("os_detail",UTILITY.getOS())
                        body.put("device_info",UTILITY.getDeviceDetail(context))
                        body.put("action_type",action_type)
                       // val resultRespAsync = async { RetroHelper.api.saveDeviceDetails(url, body) }
                        val resultRespAsync = async { RetroHelper.api.saveDeviceDetails(body) }
                        val resultResp = resultRespAsync.await()
                        if (resultResp.isSuccessful) {
                            // cancelDialog()

                           // val a = resultResp.body()?.status?: ""

                            if(resultResp.body()?.status?.uppercase().equals("SUCCESS")){

                                var response = resultResp.body()


                                Log.d(Constants.TAG,"save_device_details:"+ "SUCCESS" )

                            }else{

                                Log.d(Constants.TAG,"save_device_details: Failure")
                            }


                            // delay(8000)



                        }else{

                            Log.d(Constants.TAG,"save_device_details:"+ resultResp.errorBody())
                            // cancelDialog()
                        }


                    }

                }catch (e: Exception){

                    Log.d(Constants.TAG,"save_device_details: Failure")

                }
            }

        }


    }

}