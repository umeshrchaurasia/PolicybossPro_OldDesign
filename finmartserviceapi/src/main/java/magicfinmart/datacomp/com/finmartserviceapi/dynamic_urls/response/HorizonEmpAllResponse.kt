package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response

data class HorizonEmpAllResponse(
    /* val DEVICE: DEVICE,
   val EMP: EMP,
    val HR: Any,
    val POSP: POSP,
    val POSP_INSURER: String,
    val RM: RM,

    val channel: String,
    val product: String,*/
    val SYNC_CONTACT: SYNCCONTACTX,
    val status: String,
    val user_type: String
)
/*
data class POSP(
    val Aadhar: String,
    val Account_Type: Any,
    val Agent_City: String,
    val Already_Posp: Any,
    val Bank_Account_No: Any,
    val Bank_Branch: Any,
    val Bank_Name: Any,
    val Birthdate: String,
    val Certification_Datetime: Any,
    val Channel: String,
    val Created_On: String,
    val Cust_Id: Int,
    val Document_Name: Any,
    val Document_Type: Any,
    val ERPID_CreatedDate: Any,
    val Education: Any,
    val Email_Id: String,
    val Erp_Id: Any,
    val Experience: Any,
    val FOS_Code: Any,
    val Father_Name: Any,
    val Fba_Id: Any,
    val First_Name: String,
    val Gender: Any,
    val Ifsc_Code: Any,
    val Income: Any,
    val IsFOS: Any,
    val Is_Active: Boolean,
    val Is_App_Installed: Int,
    val Is_Certified: Int,
    val Is_Contact_Sync: Int,
    val Is_Paid: Int,
    val Last_Name: Any,
    val Last_Status: String,
    val Legal_case: Any,
    val Micr_Code: Any,
    val Middle_Name: Any,
    val Mobile_No: String,
    val Modified_On: Any,
    val Name_as_in_Bank: Any,
    val Nominee_Aadhar: Any,
    val Nominee_Account_Type: Any,
    val Nominee_Bank_Account_Number: Any,
    val Nominee_Bank_Branch: Any,
    val Nominee_Bank_City: Any,
    val Nominee_Bank_Name: Any,
    val Nominee_First_Name: Any,
    val Nominee_Gender: Any,
    val Nominee_Ifsc_Code: Any,
    val Nominee_Last_Name: Any,
    val Nominee_Micr_Code: Any,
    val Nominee_Middle_Name: Any,
    val Nominee_Name_as_in_Bank: Any,
    val Nominee_Pan: Any,
    val Nominee_Relationship: Any,
    val POSP_DeActivatedDateAtIIB: Any,
    val POSP_DeActivatedtoIIB: Any,
    val POSP_UploadedtoIIB: Any,
    val POSP_UploadingDateAtIIB: Any,
    val Paid_On: Any,
    val Pan_No: Any,
    val Permanant_Add1: Any,
    val Permanant_Add2: Any,
    val Permanant_Add3: Any,
    val Permanant_City: Any,
    val Permanant_Landmark: Any,
    val Permanant_Pincode: Int,
    val Permanant_State: Any,
    val Posp_Category: Any,
    val Posp_Id: Int,
    val Posp_Onboarding_Photo: String,
    val Present_Add1: Any,
    val Present_Add2: Any,
    val Present_Add3: Any,
    val Present_City: Any,
    val Present_Landmark: Any,
    val Present_Pincode: Any,
    val Present_State: Any,
    val Recruitment_Status: String,
    val RegAmount: Int,
    val Reporting_Agent_Name: Any,
    val Reporting_Agent_Uid: Any,
    val Reporting_Email_ID: Any,
    val Reporting_Mobile_Number: Any,
    val Service_Tax_Number: Any,
    val Sm_Posp_Id: Any,
    val Sm_Posp_Name: Any,
    val Sources: String,
    val Ss_Id: Int,
    val Status_Remark: Any,
    val SubVertical: String,
    val Telephone_No: Any,
    val TrainingEndDate: Any,
    val TrainingStartDate: Any,
    val Training_UserLog: Any,
    val Vertical: String,
    val Vertical_Head: String,
    val Vertical_Head_UID: Int,
    val _id: String,
    val undefined: Any
)


data class DEVICE(
    val ACTION_NEEDED: String,
    val Activated_On: String,
    val App_Version: String,
    val Created_On: String,
    var Days_From_Last_Active: Int,
    val Device_Id: Int,
    val Device_Identifier: String,
    val Device_Name: String,
    val Installed_On: String,
    val Ip_Address: String,
    val Modified_On: String,
    val OS_Detail: String,
  //  val Request_Core: RequestCore,
    val SS_ID: Int,
    val __v: Int,
    val _id: String
)

data class EMP(
    val AdharCardNumber: Int,
    val Advt_Source_Id: Int,
    val Alternate_Email: Int,
    val Alternate_Number: Int,
    val BloodGroup: Int,
    val Branch: Int,
    val CreatedOn: Long,
    val DOB: Int,
    val DOJ: Int,
    val Dailer_Id: Int,
    val DateOfBirth: Int,
    val Department_ID: Int,
    val Designation_ID: Int,
    val Email_Id: String,
    val Emp_Code: Int,
    val Emp_Id: Int,
    val Emp_Name: String,
    val Emp_Password: Int,
    val FBA_ID: Int,
    val IsActive: Int,
    val IsPasswordChanged: Int,
    val Is_FSM: Int,
    val LMSBuyer_Id: Int,
    val LastPasswordChangedDate: Int,
    val LastUpdatedBy: Int,
    val Mobile_Number: Long,
    val Pan: Int,
    val Password_New: Int,
    val PathofSnaps: Int,
    val Remarks: Int,
    val Reporting_Email_ID: Int,
    val Reporting_Manager_Emp_Id: Int,
    val Reporting_Mobile_Number: Int,
    val Reporting_UID_Name: Int,
    val Role_ID: Int,
    val UID: Int,
    val Updated_On: Int,
    val VendorCode: Int,
    val _id: String
)

data class RequestCore(
    val Base: String,
    val Board: String,
    val Brand: String,
    val FingerPrint: String,
    val Host: String,
    val ID: String,
    val Incremental: String,
    val Manufacture: String,
    val Model: String,
    val SDK: String,
    val Type: String,
    val User: String,
    val VersionCode: String
)

data class RM(
    val message: Any,
    val rm_details: RmDetails,
    val rm_reporting_details: RmReportingDetails,
    val status: String
)


data class RmDetails(
    val agent_city: String,
    val email: String,
    val mobile: String,
    val name: String,
    val rm_reporting_uid: Int,
    val ss_id: Int,
    val uid: Int
)

data class RmReportingDetails(
    val agent_city: String,
    val email: String,
    val mobile: String,
    val name: String,
    val ss_id: Int,
    val uid: Int
)
*/

data class SYNCCONTACTX(
    val ACTION_NEEDED: String,

    val Branch: String,
    val Channel: String,
    val City: String,
    var Days_From_Last_Sync: Int ? = 0,
    val Dec_Lead: Int,
    var FIRST_SYNC_CAMPAIGN_CREATIVE: String?="",

    val Name: String,

    val RE_SYNC_CAMPAIGN_CREATIVE: String,
    val RM: String,
    val RM_REPORT_TO: String,


    var Sync_Contact_Summary_Id: Int ? = 0,
    val Type: String,

    val _id: String,

    var erp_id: Int ? = 0,
    var fba_id: Int ? = 0,
    val first_synced_on: String,

    val last_synced_on: String,

    var ss_id: Int ? = 0,
    var sync: Int ? = 0,
    val valid: Int
)