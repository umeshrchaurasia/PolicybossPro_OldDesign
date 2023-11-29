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

        return response?.EMP?.Emp_Id?:"0"
    }

    fun getFBAID() : String {

        val response = getLoginHorizonResponse()

        return response?.EMP?.FBA_ID?:"0"
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