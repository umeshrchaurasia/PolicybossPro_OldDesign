package magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew

data class OtpLoginResponse(
    val Msg: OtpLoginMsg?,
    val Status: String?
)

data class OtpLoginMsg(
    val Mobile_No: Long,
    val Name: String,
    val OTP_Status: String,
    val Ss_Id: Int
)

//data class test1(
//    val Msg: Msg,
//    val Status: String
//)
//
//data class Msg(
//    val Mobile_No: Long,
//    val Name: String,
//    val OTP_Status: String,
//    val Ss_Id: Int
//)