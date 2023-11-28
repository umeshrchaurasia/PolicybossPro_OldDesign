package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.Syncontact

import com.utility.finmartcontact.core.requestentity.CallLogRequestEntity
import com.utility.finmartcontact.core.requestentity.ContactLeadRequestEntity
import com.utility.finmartcontact.core.response.ContactLogResponse
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response.CheckboxsaveResponse
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response.Horizon_sync_contact_agree_Response
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.pbAttendance.pbAttendRequestEntity
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.syncContact.SaveCheckboxRequestEntity
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.AuthToken.OauthTokenResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.ContactLeadResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.DocumentResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.ForgotResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.AuthLoginResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.LoginNewResponse_DSAS_Horizon
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.LoginOTPResult
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.OtpLoginResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.OtpVerifyResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.UserNewSignUpResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PbAttendance.pbAttendResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by Rahul on 20/06/2022.
 */
interface SyncContactInterface {

    @POST()
   suspend fun saveContactLead(@Url url: String, @Body body : ContactLeadRequestEntity): Response<ContactLeadResponse>


    @POST()
    suspend fun saveCallLog(@Url url: String, @Body body : CallLogRequestEntity): Response<ContactLogResponse>

    @GET()
    suspend fun getHorizonDetails(@Url url: String): Response<Horizon_sync_contact_agree_Response>



    @POST()
    suspend fun savecheckboxdetails(@Url url: String, @Body body : SaveCheckboxRequestEntity): Response<CheckboxsaveResponse>

    @POST()
    suspend fun saveCallLogOld(@Url url: String, @Body body : CallLogRequestEntity): Call<ContactLogResponse>



    @POST()
    fun saveContactLeadOld(@Url url: String, @Body body : ContactLeadRequestEntity): Call<ContactLeadResponse>


    @Headers("token:" + FinmartRetroRequestBuilder.token)
    @POST()
    suspend fun saveDeviceDetails1(@Url url: String, @Body body : HashMap<String,String> ): Response<ContactLogResponse>

    @Headers("token:" + FinmartRetroRequestBuilder.token)
    @POST("/app_visitor/save_device_details")
    suspend fun saveDeviceDetails( @Body body : HashMap<String,String> ): Response<ContactLogResponse>


    @Headers("token:" + FinmartRetroRequestBuilder.token)
    @POST("/auth_tokens/generate_web_auth_token")
    suspend fun getOauthToken( @Body body : HashMap<String,String> ): Response<OauthTokenResponse>


    //For Multipart Sending Photos from Contact List
   @Headers("token:" + FinmartRetroRequestBuilder.token)
   @Multipart
   //@POST()
   @POST("/quote/Postfm_fileupload/upload-doc")
   fun uploadContactsPhotoDoc(

        //@Url url: String,
        @Part doc: MultipartBody.Part,
        @PartMap partMap: Map<String, String>
   ): Response<DocumentResponse>

 // *****************PB Attendance*******************************

  @POST
  suspend fun getPBAttendance(@Url strUrl : String,@Body body : pbAttendRequestEntity ): Response<pbAttendResponse>


    /****************************************************************************************
     *    Login Horizon API
     *************************************************************************************/


    @Headers("token:" + FinmartRetroRequestBuilder.token)
    @POST("/quote/Postfm/Getusersignup")
    suspend fun getusersignup(@Body body: HashMap<String,String>): Response<UserNewSignUpResponse?>


    @GET("posps/dsas/view/{userId}")
    suspend fun getLoginDsasHorizonDetails( @Path("userId") userId: String): Response<LoginNewResponse_DSAS_Horizon>

    @POST("postservicecall/otp_login")
    //005 temp
    suspend fun otpLoginHorizon(  @Body body : HashMap<String,String>): Response<OtpLoginResponse>
   // suspend fun otpLoginHorizon(  @Body body : HashMap<String,String>): Response<LoginOTPResult>


    @POST("auth_tokens/auth_login")
    suspend fun authLoginHorizon(  @Body body : HashMap<String,String>): Response<AuthLoginResponse>

    @GET("verifyOTP_New/{userId}/{mobileno}")
    suspend fun otpVerifyHorizon( @Path("userId") userId: String, @Path("mobileno") mobileno: String): Response<OtpVerifyResponse>

   // we can take any param in path eg "verifyOTP_New/{pathDaa}
    @GET("generateOTP_New/{mobNo}/ONBOARDING")
    suspend fun otpResendHorizon( @Path("mobNo") userId: String): Response<OtpVerifyResponse>

    @Headers("token:" + FinmartRetroRequestBuilder.token)
    @POST("/quote/Postfm/forgotPassword")
    suspend fun forgotPassword(@Body body: HashMap<String,String>): Response<ForgotResponse>

}