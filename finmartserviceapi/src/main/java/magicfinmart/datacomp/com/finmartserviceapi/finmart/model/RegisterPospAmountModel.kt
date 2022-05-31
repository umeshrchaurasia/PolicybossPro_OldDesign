package magicfinmart.datacomp.com.finmartserviceapi.finmart.model

data class RegisterPospAmountModel(
    val id: Int,
    val posp_amount: String,
    val posp_desc: String,
    val posp_header_desc: String,
    val posp_sub_header_desc: String,
    val posp_name: String,
    var isCheck : Boolean
)