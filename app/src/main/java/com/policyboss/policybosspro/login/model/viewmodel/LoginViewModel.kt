package com.policyboss.policybosspro.login.model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.policyboss.policybosspro.APIState
import com.policyboss.policybosspro.login.model.Repository.LoginNewRepository
import com.policyboss.policybosspro.utility.Constant
import com.policyboss.policybosspro.utility.UTILITY
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import magicfinmart.datacomp.com.finmartserviceapi.LoginPrefManager
import magicfinmart.datacomp.com.finmartserviceapi.PrefManager
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.ForgotResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.AuthLoginResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.DevicetokenResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.LoginNewResponse_DSAS_Horizon
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.LoginOTPResult
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.OtpLoginResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.OtpVerifyResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.UserNewSignUpResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.RetroHelper

class LoginViewModel( private val loginNewRepository: LoginNewRepository,
                      private val loginPrefManager: LoginPrefManager,

): ViewModel() {



    // region Declaration of Variable
    var remaingTime: Long = 0L

    //region Handele SSID
    private var ssid: String = ""
    private var OTP_mobNo: String = ""

    private fun setSsid(newSsid: String) {
        ssid = newSsid
    }

    fun getSsid(): String {
        return ssid
    }

    fun getOtpMobileNo(): String {
        return OTP_mobNo
    }
    //endregion


    //region get isUserSignUp or Not ?
    private  var getsignUpMutuableStateFlow : MutableStateFlow<APIState<UserNewSignUpResponse>> = MutableStateFlow(APIState.Empty())

    val getsignUpStateFlow : StateFlow<APIState<UserNewSignUpResponse>>
        get() = getsignUpMutuableStateFlow

    //endregion

    private var insertTokenMutuableStateFlow : MutableStateFlow<APIState<DevicetokenResponse>> = MutableStateFlow(APIState.Empty())

    val insertTokenStateFlow : StateFlow<APIState<DevicetokenResponse>>
        get() = insertTokenMutuableStateFlow

    //.........
    //region DSAS Login
    private  var loginMutuableStateFlow : MutableStateFlow<APIState<LoginNewResponse_DSAS_Horizon>> = MutableStateFlow(APIState.Empty())

    val LoginStateFlow : StateFlow<APIState<LoginNewResponse_DSAS_Horizon>>
        get() = loginMutuableStateFlow

  //endregion

    //region OTP via Login

    //region otp  Initialization
    private  var otpLoginMutuableStateFlow : MutableStateFlow<APIState<OtpLoginResponse>> = MutableStateFlow(APIState.Empty())

    val otpLoginStateFlow : StateFlow<APIState<OtpLoginResponse>>
        get() = otpLoginMutuableStateFlow
    //endregion


    //endregion



    //region OTP Verification via Login
    private  var otpVerificationMutuableStateFlow : MutableStateFlow<APIState<OtpVerifyResponse>> = MutableStateFlow(APIState.Empty())

    val otpVerificationStateFlow : StateFlow<APIState<OtpVerifyResponse>>
        get() = otpVerificationMutuableStateFlow

    //endregion


    //region OTP  Resend
    private  var otpResendMutuableStateFlow : MutableStateFlow<APIState<OtpVerifyResponse>> = MutableStateFlow(APIState.Empty())

    val otpResendStateFlow : StateFlow<APIState<OtpVerifyResponse>>
        get() = otpVerificationMutuableStateFlow

    //endregion

    //region Password via Login
    private  var authLoginMutuableStateFlow : MutableStateFlow<APIState<AuthLoginResponse>> = MutableStateFlow(APIState.Empty())

    val authLoginStateFlow : StateFlow<APIState<AuthLoginResponse>>
        get() = authLoginMutuableStateFlow

    //endregion

    //region forgotPassword ?
    private  var forgotPasswordMutuableStateFlow : MutableStateFlow<APIState<ForgotResponse>> = MutableStateFlow(APIState.Empty())

    val forgotPasswordStateFlow : StateFlow<APIState<ForgotResponse>>
        get() = forgotPasswordMutuableStateFlow

    //endregion

    //endregion


    fun getusersignup(appVersion: String, deviceCode : String) = viewModelScope.launch {

        var body = HashMap<String, String>()
        body.put("app_version", appVersion)
        body.put("ssid", "")
        body.put("fbaid", "")
        body.put("device_code", deviceCode)


        getsignUpMutuableStateFlow.value = APIState.Loading()

        setSsid("")
        loginNewRepository.getusersignup(body)
            .catch {
                getsignUpMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.NOData)
            }
            .collect{ data ->
                if (data?.isSuccessful == true){
                    if(data.body()?.StatusNo?:1 == 0)
                    {

                            getsignUpMutuableStateFlow.value = APIState.Success(data = data.body())

                    }
                    else{

                        otpLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.NOData)
                    }
                }
                else
                {
                    otpLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.NOData)
                }

            }


    }
    fun insert_notification_token(Ss_Id: String) = viewModelScope.launch {
        var body = HashMap<String,String>()
        body.put("Ss_Id",Ss_Id)
        body.put("Device_Id",loginPrefManager.getDEVICE_ID())
        body.put("Device_Name",loginPrefManager.getDEVICE_NAME())
        body.put("Token",loginPrefManager.getToken())

        insertTokenMutuableStateFlow.value = APIState.Loading()

        loginNewRepository.insert_notification_token(body)
            .catch {
                insertTokenMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.NOData)
            }
            .collect{data ->
                if(data?.isSuccessful == true) {
                    if (data.body()?.Status == "SUCCESS") {

                        insertTokenMutuableStateFlow.value = APIState.Success(data= data.body())

                    } else
                    {
                        insertTokenMutuableStateFlow.value   = APIState.Failure(errorMessage = Constant.NOData)
                    }
                }
                else
                {
                    insertTokenMutuableStateFlow.value  = APIState.Failure(errorMessage = Constant.NOData)
                }

            }
    }

    fun  getLoginDetailHorizon(ss_id : String) = viewModelScope.launch {

      //  loginMutuableStateFlow.value = APIState.Loading()

        try {

            loginNewRepository.getLoginHorizonDetails(ss_id)
                .catch {
                    loginMutuableStateFlow.value = APIState.Failure(errorMessage = it.message.toString())
                }.collect{  data ->
                    if (data.isSuccessful){
                        if(data.body()?.status?.uppercase().equals("SUCCESS"))
                        {
                            loginPrefManager.saveLoginHorizonResponse(data.body())
                            loginMutuableStateFlow.value = APIState.Success(data = data.body())

                            insert_notification_token(ss_id)
                        }
                        else{
                            loginMutuableStateFlow.value = APIState.Failure(errorMessage ="No Data Found")
                        }
                    }
                    else
                    {
                        loginMutuableStateFlow.value = APIState.Failure(errorMessage ="No Data Found")
                    }
                }


        }catch (ex : Exception){

            loginMutuableStateFlow.value = APIState.Failure(errorMessage = UTILITY.ErrorMessage)
        }

    }


     // temp005
    fun getotpLoginHorizon(login_id: String) = viewModelScope.launch {

        var body = HashMap<String, String>()
        body.put("login_id", login_id)

        otpLoginMutuableStateFlow.value = APIState.Loading()

        setSsid("")
        loginNewRepository.otpLoginHorizon(body)
            .catch {
                otpLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.ServerError)
            }
            .collect{ data ->
g                if (data.isSuccessful){
                    if(data.body()?.Status?.uppercase().equals("SUCCESS"))
                    {
                        //loginPrefManager.saveLoginOTPResponse(data.body()?.Msg)
                        otpLoginMutuableStateFlow.value = APIState.Success(data = data.body())

                        //Set SSID and After Verify mob no. Call dsasLogin Horizon Details using SsID
                        setSsid(data.body()?.Msg?.Ss_Id?.toString() ?:"")
                        OTP_mobNo = data.body()?.Msg?.Mobile_No?.toString() ?:""
                    }
                    else{

                        otpLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.InValidUser)
                    }
                }
                else
                {
                    otpLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.InValidUser)
                }

            }


    }


    fun getotpLoginHorizon1(login_id: String) = viewModelScope.launch {

        var body = HashMap<String, String>()
        body.put("login_id", login_id)

        otpLoginMutuableStateFlow.value = APIState.Loading()

        setSsid("")

        try {
            val resultRespAsync = async { RetroHelper.api.otpLoginHorizon(body) }
            val resultResp = resultRespAsync.await()

            when(resultResp.code()){

                200 ->{
                    if (resultResp.isSuccessful) {


                        if(resultResp.body()?.Status?.uppercase().equals("SUCCESS"))
                        {
                            //loginPrefManager.saveLoginOTPResponse(data.body()?.Msg)
                            otpLoginMutuableStateFlow.value = APIState.Success(data = resultResp.body())

                            //Set SSID and After Verify mob no. Call dsasLogin Horizon Details using SsID
                            setSsid(resultResp.body()?.Msg?.Ss_Id?.toString() ?:"")
                            OTP_mobNo = resultResp.body()?.Msg?.Mobile_No?.toString() ?:""
                        }
                        else{

                            otpLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.InValidUser)
                        }
                    }
                }
                503 ->{
                    otpLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.ServerError)

                }
                404 ->{
                    otpLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.ServerNotFound)

                }else ->{
                    otpLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.InValidUser)
                }

            }

        }catch (ex : Exception){

            otpLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.ServerError)
        }

    }



    fun  otpVerifyHorizon(otp : String, mobileno : String) = viewModelScope.launch {


        // Loading is start from Verify
        otpVerificationMutuableStateFlow.value = APIState.Loading()
        //loginMutuableStateFlow.value = APIState.Loading()

        try {

            loginNewRepository.otpVerifyHorizon(otp, mobileno)
                .catch {
                    otpVerificationMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.InValidOTP)
                }.collect{  data ->
                    if (data.isSuccessful){
                        if(data.body()?.Msg?.uppercase().equals("SUCCESS"))
                        {

                            // Success is trigger after DSS Horizon Api if successfully called
                            // otpVerificationMutuableStateFlow.value = APIState.Success(data = data.body())

                            if(getSsid().isNotEmpty()){
                                getLoginDetailHorizon(getSsid())

                            }else{

                                otpVerificationMutuableStateFlow.value = APIState.Failure(errorMessage = "SSID not generated.Please contact admin")

                            }

                        }
                        else{
                            otpVerificationMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.InValidOTP)
                        }
                    }
                    else
                    {
                        otpVerificationMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.InValidOTP)
                    }
                }


        }catch (ex : Exception){

            otpVerificationMutuableStateFlow.value = APIState.Failure(errorMessage = UTILITY.ErrorMessage)
        }

    }

    fun  otpResendHorizon(mobNo : String) = viewModelScope.launch {


      // otpResendMutuableStateFlow.value = APIState.Loading()

        try {

            loginNewRepository.otpResendHorizon(mobNo)
                .catch {
                   // otpResendMutuableStateFlow.value = APIState.Failure(errorMessage = it.message.toString())
                }.collect{  data ->
                    if (data.isSuccessful){
                        if(data.body()?.Msg?.uppercase().equals("SUCCESS"))
                        {

                          //  otpResendMutuableStateFlow.value = APIState.Success(data = data.body())
                        }
                        else{
                           // otpResendMutuableStateFlow.value = APIState.Failure(errorMessage ="No Data Found")
                        }
                    }
                    else
                    {
                       // otpResendMutuableStateFlow.value = APIState.Failure(errorMessage ="No Data Found")
                    }
                }


        }catch (ex : Exception){

            otpResendMutuableStateFlow.value = APIState.Failure(errorMessage = UTILITY.ErrorMessage)
        }

    }

    //region commented
    fun getAuthLoginHorizonOld(username: String, password : String) = viewModelScope.launch {

        //region Commment
//        var body = HashMap<String, String>()
//        body.put("username", username)
//        body.put("password", password)
//
//        ssid = ""
//        authLoginMutuableStateFlow.value = APIState.Loading()
//
//        loginNewRepository.authLoginHorizon(body)
//            .catch {
//                authLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.NOData)
//            }
//            .collect{ data ->
//                if (data.isSuccessful){
//                    if(data.body()?.Status?.uppercase().equals("SUCCESS"))
//                    {
//
//                        authLoginMutuableStateFlow.value = APIState.Success(data = data.body())
//
//                        setSsid(data.body()?.SS_ID?:"")
//
//                        data.body()?.SS_ID?.let {
//
//                            loginNewRepository.getLoginHorizonDetails(it)
//                        }
//                    }
//                    else{
//
//                        authLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.InValidUser)
//                    }
//                }
//                else
//                {
//                    authLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.NOData)
//                }
//
//            }
//
        //endregion

    }

    fun  otpVerifyHorizonOld(otp : String) = viewModelScope.launch {


        otpVerificationMutuableStateFlow.value = APIState.Loading()

        try {

            loginNewRepository.otpVerifyHorizon(otp,"")
                .catch {
                    otpVerificationMutuableStateFlow.value = APIState.Failure(errorMessage = it.message.toString())
                }.collect{  data ->
                    if (data.isSuccessful){
                        if(data.body()?.Msg?.uppercase().equals("SUCCESS"))
                        {

                            // otpVerificationMutuableStateFlow.value = APIState.Success(data = data.body())

                            getLoginDetailHorizon(getSsid())
                        }
                        else{
                            otpVerificationMutuableStateFlow.value = APIState.Failure(errorMessage ="No Data Found")
                        }
                    }
                    else
                    {
                        otpVerificationMutuableStateFlow.value = APIState.Failure(errorMessage ="No Data Found")
                    }
                }


        }catch (ex : Exception){

            otpVerificationMutuableStateFlow.value = APIState.Failure(errorMessage = UTILITY.ErrorMessage)
        }

    }

    //endregion
    fun getAuthLoginHorizon(username: String, password : String) = viewModelScope.launch {

        var body = HashMap<String, String>()
        body.put("username", username)
        body.put("password", password)

        setSsid("")

        authLoginMutuableStateFlow.value = APIState.Loading()

        loginNewRepository.authLoginHorizon(body)
            .catch {
                authLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.ServerError)
            }
            .collect{ data ->
                if (data.isSuccessful){
                    if(data.body()?.Status?.uppercase().equals("SUCCESS"))
                    {

                       // authLoginMutuableStateFlow.value = APIState.Success(data = data.body())

                        // Success is trigger after DSS Horizon Api if successfully called

                        data.body()?.SS_ID?.let {

                            getLoginDetailHorizon(it)
                        }?: also {
                            loginMutuableStateFlow.value = APIState.Failure(errorMessage = "SSID not generated.Please contact admin")
                        }



                    }
                    else{

//                        authLoginMutuableStateFlow.value =
//                            APIState.Failure(errorMessage = data.body()?.Msg?.ExceptionMessage ?: Constant.InValidPass)

                        authLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.InValidPass)
                    }
                }
                else
                {
                    authLoginMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.ServerError)
                }

            }


    }


    fun forgotPassword(emailID: String ,appVersion: String, deviceCode : String) = viewModelScope.launch {

        var body = HashMap<String, String>()
        body.put("EmailID", emailID)
        body.put("app_version", appVersion)
        body.put("ssid", "")
        body.put("fbaid", "")
        body.put("device_code", deviceCode)


        getsignUpMutuableStateFlow.value = APIState.Loading()

        setSsid("")
        loginNewRepository.forgotPassword(body)
            .catch {
                forgotPasswordMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.NOData)
            }
            .collect{ data ->
                if (data?.isSuccessful == true){
                    if(data.body()?.statusNo?:1 == 0)
                    {

                        forgotPasswordMutuableStateFlow.value = APIState.Success(data = data.body())

                    }
                    else{

                        forgotPasswordMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.NOData)
                    }
                }
                else
                {
                    forgotPasswordMutuableStateFlow.value = APIState.Failure(errorMessage = Constant.NOData)
                }

            }


    }



}

