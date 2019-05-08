package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;

/**
 * Created by Rajeev Ranjan on 08/05/2019.
 */
public class MotorLeadResponse extends APIResponse {
    /**
     * MasterData : {"SRN":"SRN-PBTP5GTB-2SP2-9U5E-DUAZ-NUCKCTZAYYYT_682529","VehicleRequestID":16805,"fba_id":1976,"isActive":1,"selectedPrevInsID":0,"insImage":"","motorRequestEntity":{"VehicleRequestID":16805,"birth_date":null,"fba_id":1976,"product_id":1,"vehicle_id":423,"rto_id":579,"vehicle_insurance_type":"renew","vehicle_manf_date":"2017-05-01","vehicle_registration_date":"2017-05-01","policy_expiry_date":"2019-01-08","prev_insurer_id":1,"vehicle_registration_type":"individual","vehicle_ncb_current":"0","is_claim_exists":"no","method_type":"Premium","execution_async":"yes","electrical_accessory":"0","non_electrical_accessory":"0","registration_no":"MH-01-ZZ-9999","is_llpd":"no","is_antitheft_fit":"no","voluntary_deductible":"0","is_external_bifuel":"no","external_bifuel_value":0,"pa_owner_driver_si":"1500000","pa_named_passenger_si":"0","pa_unnamed_passenger_si":"0","pa_paid_driver_si":"","vehicle_expected_idv":0,"first_name":"FM","middle_name":" ","last_name":"Test","mobile":"9898965656","email":"finmarttest@gmail.com","crn":"885359","ip_address":"156.244.149.63","secret_key":"SECRET-VG9N6EVV-MIK3-1GFC-ZRBV-PE7XIQ8DV4GY","client_key":"CLIENT-WF4GWODI-HMEB-Q7M6-CLES-DEJCRF7XLRVI","is_aai_member":"no","external_bifuel_type":"","ss_id":"2335","geo_lat":19.0858715,"geo_long":72.8882537,"isTwentyfour":1,"isActive":1,"created_date":"07/05/2019","type":"Q","conversiondate":null,"srn":"SRN-PBTP5GTB-2SP2-9U5E-DUAZ-NUCKCTZAYYYT_682529","agent_source":"","selectedPrevInsID":0,"PBStatus":null,"PBStatusDesc":null,"StatusPercent":0,"app_version":"2.2.2","device_id":"dRHRopQhT9U:APA91bH4IA7qSMmw1CVibaBlvK51h9iqRKj_8I9iWgQ-OFvU1y-8kARGJqh5PQifqEZgVApnKFWUdeDUd7jCZHMV-BvIyj1MRk9ZnsYRIFB8hIEfz7YV85U7Buip-LNMRtYsjQcmpTcq","erp_source":"","mac_address":"d8:32:e3:44:47:5e","insImage":"","varid":0,"vehicle_insurance_subtype":"1CH_0TP","sendmobileno":"","sendmessage":"","sub_fba_id":"0","is_policy_exist":"yes","is_breakin":"yes","progress_image":""}}
     */

    private QuoteListEntity MasterData;

    public QuoteListEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(QuoteListEntity MasterData) {
        this.MasterData = MasterData;
    }





}
