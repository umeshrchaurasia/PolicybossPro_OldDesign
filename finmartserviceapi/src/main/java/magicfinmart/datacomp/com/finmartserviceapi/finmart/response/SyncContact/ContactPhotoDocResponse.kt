package magicfinmart.datacomp.com.finmartserviceapi.finmart.response.SyncContact

import magicfinmart.datacomp.com.finmartserviceapi.motor.APIResponse

data class ContactPhotoDocResponse(
    val MasterData: List<PhotoDocMasterData>,

) : APIResponse()

data class PhotoDocMasterData(
    val Message: String,
    val RowUpdated: Int,
    val SavedStatus: Int,
    val prv_file: String
)