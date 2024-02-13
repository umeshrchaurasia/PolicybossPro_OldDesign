package magicfinmart.datacomp.com.finmartserviceapi

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.EMP
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.LoginNewResponse_DSAS_Horizon
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.OtpLoginMsg

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

        val usertype= response?.user_type?:""

        when(usertype){


            "POSP" ->{
                return response?.POSP?.Fba_Id?:"0"
            }
            "FOS" ->{
                return response?.POSP?.Fba_Id?:"0"
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

        return response?.POSP?.Erp_Id?:""
    }


    fun getName() : String {

        val response = getLoginHorizonResponse()

        val usertype= response?.user_type?:""

        when(usertype){


            "POSP" ->{
                return response?.POSP_USER?.Name_On_PAN?:""
            }
            "FOS" ->{
                return response?.POSP_USER?.Name_On_PAN?:""
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


            "POSP" ->{
                return response?.POSP_USER?.Mobile_No?:"0"
            }
            "FOS" ->{
                return response?.POSP_USER?.Mobile_No?:"0"
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


            "POSP" ->{
                return response?.POSP?.Email_Id?:"0"
            }
            "FOS" ->{
                return response?.POSP?.Email_Id?:"0"
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


    fun getUserId() : String {

        val response = getLoginHorizonResponse()

        val usertype= response?.user_type?:""

        when(usertype){


            "POSP" ->{
                return response?.POSP_USER?.User_Id?:"0"
            }
            "FOS" ->{
                return response?.POSP_USER?.User_Id?:"0"
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