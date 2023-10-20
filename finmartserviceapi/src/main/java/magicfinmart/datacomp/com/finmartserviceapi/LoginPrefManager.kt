package magicfinmart.datacomp.com.finmartserviceapi

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.EMP
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.LoginNewResponse_DSAS_Horizon
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.POSP

class LoginPrefManager (private val context: Context){

    private val PREF_NAME  = "loginPrefManager_policyBossPro"

    private val LoginHorizonKey = "LOGIN_DSAS_Horizon"
    private  val gson = Gson()

    private  val  sharedPreferences:SharedPreferences by lazy{
        context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
    }


//    companion object {
//        // Singleton instance
//        @Volatile
//        private var instance: LoginPrefManager? = null
//
//        @JvmStatic
//        fun getInstance(context: Context): LoginPrefManager {
//            return instance ?: synchronized(this) {
//                instance ?: LoginPrefManager(context).also { instance = it }
//            }
//        }
//    }

    fun saveLoginHorizonResponse(  loginHorizon : LoginNewResponse_DSAS_Horizon?){

        loginHorizon?.let { response ->

            val json = gson.toJson(response)
            sharedPreferences.edit().putString(LoginHorizonKey, json).apply()

        }


    }

    fun getLoginHorizonResponse() : LoginNewResponse_DSAS_Horizon?  {

        val LoginResponse = sharedPreferences.getString(LoginHorizonKey,null)

        return gson.fromJson(LoginResponse,LoginNewResponse_DSAS_Horizon::class.java )
    }


    fun getEmpData() : EMP ? {

        val response = getLoginHorizonResponse()

        return response?.EMP
    }

    fun getPospData() : POSP? {

        val response = getLoginHorizonResponse()

        return response?.POSP
    }


    fun getSSID() : String {

        val response = getLoginHorizonResponse()

        return response?.POSP?.Ss_Id?:"0"
    }

    fun getFBAID() : String {

        val response = getLoginHorizonResponse()

        return response?.POSP?.Fba_Id?:"0"
    }
}