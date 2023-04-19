package magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PbAttendance

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PbAttendHistoryEntity

data class PbAttendanceResponse(
    val Details: List<PbAttendHistoryEntity>,
    val Status : String?,
    val message : String?
)