package magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PbAttendance

data class pbAttendResponse(
    val Status : String,
    val message : String,
    val Details: List<Detail>

)