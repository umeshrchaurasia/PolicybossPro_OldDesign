package magicfinmart.datacomp.com.finmartserviceapi

import android.content.Context
import android.content.SharedPreferences
import android.provider.SyncStateContract.Constants
import android.util.Log
import com.google.gson.Gson
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.EMP
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.LoginNewResponse_DSAS_Horizon
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.OtpLoginMsg
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.POSP
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.POSP_USER

class LoginPrefManager (private val context: Context){

    private val PREF_NAME  = "loginPrefManager_policyBossPro"

    private val LoginHorizonKey = "LOGIN_DSAS_Horizon"
    private val LoginOTPDataKey = "Login_OTP_Data_Key"

    private val IS_DEVICE_TOKEN_Login = "devicetokenLogin"

    private val IS_DEVICE_ID = "deviceid"
    private val IS_DEVICE_Name = "devicename"

    private  val gson = Gson()

    private  val  sharedPreferences:SharedPreferences by lazy{
        context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
    }


    companion object {
        // Singleton instance
        @Volatile
        private var instance: LoginPrefManager? = null

        @JvmStatic
        fun getInstance(context: Context): LoginPrefManager {
            return instance ?: synchronized(this) {
                instance ?: LoginPrefManager(context).also { instance = it }
            }
        }
    }
//Important all API data
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



    fun getSSID() : String {

        val response = getLoginHorizonResponse()

        return response?.Ss_Id?:"0"
    }

    fun getFBAID() : String {

        val response = getLoginHorizonResponse()

      //  return response?.EMP?.FBA_ID?:"0"



        val usertype= response?.user_type?:""

        when(usertype){


            "POSP" ->{
               // return response?.POSP ?.Fba_Id?:"0"

               var Fba_Id = "0"
                response?.POSP?.let { posp ->
                    when (posp) {

                        is POSP -> {
                            Fba_Id = posp.Fba_Id?.takeIf { it.isNotEmpty() } ?: "0" // Retrieve and handle Fba_Id
                        }
                        else -> {
                            // Handle unexpected type (log, throw exception, etc.)
                            println("Unexpected POSP type: ${posp?.javaClass}")
                        }
                    }
                }
                return Fba_Id
            }
            "FOS" ->{
                var Fba_Id = "0"
                response?.POSP?.let { posp ->
                    when (posp) {

                        is POSP -> {
                            Fba_Id = posp.Fba_Id?.takeIf { it.isNotEmpty() } ?: "0" // Retrieve and handle Fba_Id
                        }
                        else -> {
                            // Handle unexpected type (log, throw exception, etc.)
                            println("Unexpected POSP type: ${posp?.javaClass}")
                        }
                    }
                }
                return Fba_Id

            }

            "EMP" ->{
                return response?.EMP?.FBA_ID?:"0"

            }
            "MISP" ->{
                return response?.EMP?.FBA_ID?:"0"


            }

        }

        return "0"
    }

    fun  getERPID() : String {

        val response = getLoginHorizonResponse()

        val erpIDID: String? = when (val obj = response?.POSP_USER) {
            is Map<*, *> -> {
                // Assume it's a Map, you can adjust this based on your actual JSON structure
                (obj["Erp_Id"] as? String) ?:"0"
            }
            else -> {

                ""
            }
        }

        Log.d("User Email ID.",erpIDID?:"0")
        return  erpIDID?:"0"

    }


    fun getName() : String {

        val response = getLoginHorizonResponse()

        val usertype= response?.user_type?:""

        when(usertype){


            "POSP" , "FOS" ->{

                val username: String? = when (val obj = response?.POSP_USER) {
                    is Map<*, *> -> {
                        // Assume it's a Map, you can adjust this based on your actual JSON structure
                        (obj["Name_On_PAN"] as? String)?.takeIf { it.isNotEmpty() } ?:
                        response?.EMP?.Emp_Name?:""
                    }
                    else -> {

                        ""
                    }
                }
                Log.d("User Name.",username?:"")
                return  username?:""

            }


            "EMP" ->{
                return response?.EMP?.Emp_Name?:""
            }
            "MISP" ->{
                return response?.EMP?.Emp_Name?:""
            }

        }

        return ""
    }




    fun getMobileNo() : String {

        val response = getLoginHorizonResponse()

        val usertype= response?.user_type?:""

        when(usertype){


            "POSP" , "FOS" ->{


                val mobileNo: String? = when (val obj = response?.POSP_USER) {
                    is Map<*, *> -> {
                        // Assume it's a Map, you can adjust this based on your actual JSON structure
                        (obj["Mobile_No"] as? String)?.takeIf { it.isNotEmpty() } ?:""
                    }
                    else -> {

                        ""
                    }
                }

                Log.d("MOBILE NO.",mobileNo?:"")
                return  mobileNo?:""

            }


            "EMP" ->{
                return response?.EMP?.Mobile_Number?:"0"
            }
            "MISP" ->{
                return response?.EMP?.Mobile_Number?:"0"
            }

        }

        return "0"
    }

    fun getEmailId() : String {

        val response = getLoginHorizonResponse()

        val usertype= response?.user_type?:""

        when(usertype){


            "POSP" , "FOS" ->{

                val emailID: String? = when (val obj = response?.POSP_USER) {
                    is Map<*, *> -> {
                        // Assume it's a Map, you can adjust this based on your actual JSON structure
                        (obj["Email_Id"] as? String)?.takeIf { it.isNotEmpty() } ?:""
                    }
                    else -> {

                        ""
                    }
                }

                Log.d("User Email ID.",emailID?:"")
                return  emailID?:""

            }


            "EMP" ->{
                return response?.EMP?.Email_Id?:"0"
            }
            "MISP" ->{
                return response?.EMP?.Email_Id?:"0"
            }

        }

        return ""
    }

 fun getUserType():String{


         val response = getLoginHorizonResponse()
       //  val usertype= response?.user_type?:""

         return response?.user_type?:""

 }
    fun getUserId() : String {

        val response = getLoginHorizonResponse()

        val usertype= response?.user_type?:""

        when(usertype){


            "POSP" ->{
                return response?.EMP?.UID?:"0"
            }
            "FOS" ->{
                return response?.EMP?.UID?:"0"
            }

            "EMP" ->{
                return response?.EMP?.UID?:"0"
            }
            "MISP" ->{
                return response?.EMP?.UID?:"0"
            }

        }

        return "0"
    }
    fun getappVersion() : String {

        val response = getLoginHorizonResponse()

        return response?.DEVICE?.App_Version?:""
    }

    fun getdeviceID() : String {

        val response = getLoginHorizonResponse()

        return response?.DEVICE?.Device_Identifier?:""
    }

    fun clear() {
        val strToken = getToken()
        sharedPreferences.edit().clear().apply()
        setToken(strToken)
    }

    fun saveLoginOTPResponse(  loginOTP : OtpLoginMsg?){

        loginOTP?.let { response ->

            val json = gson.toJson(response)
            sharedPreferences.edit().putString(LoginOTPDataKey, json).apply()

        }


    }

    fun getLoginOTPResponse() : OtpLoginMsg?  {

        val loginOTP = sharedPreferences.getString(LoginOTPDataKey,null)

        return gson.fromJson(loginOTP,OtpLoginMsg::class.java )
    }

    fun getSSIDByOTP() : String {

        val response = getLoginOTPResponse()

        return response?.Ss_Id?.toString() ?:"0"
    }

    fun setToken(token: String) {
        sharedPreferences.edit()
            .putString(IS_DEVICE_TOKEN_Login, token)
            .apply()
    }

    fun getToken(): String {
        return sharedPreferences.getString(IS_DEVICE_TOKEN_Login, "") ?: ""
    }

    fun setDEVICE_ID(token: String) {
        sharedPreferences.edit()
            .putString(IS_DEVICE_ID, token)
            .apply()
    }

    fun getDEVICE_ID(): String {
        return sharedPreferences.getString(IS_DEVICE_ID, "") ?: ""
    }

    fun setDEVICE_NAME(token: String) {
        sharedPreferences.edit()
            .putString(IS_DEVICE_Name, token)
            .apply()
    }

    fun getDEVICE_NAME(): String {
        return sharedPreferences.getString(IS_DEVICE_Name, "") ?: ""
    }
}