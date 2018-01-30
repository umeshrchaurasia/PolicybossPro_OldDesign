package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteApplicationEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;

/**
 * Created by Nilesh Birhade on 25-01-2018.
 */

public class QuoteApplicationResponse extends APIResponse {


    /**
     * MasterData : {"quote":[{"VehicleRequestID":5,"birth_date":"1992-01-01T00:00:00.000Z","fba_id":35779,"product_id":1,"vehicle_id":328,"rto_id":579,"vehicle_insurance_type":"renew","vehicle_manf_date":"2017-01-01T00:00:00.000Z","vehicle_registration_date":"2018-01-25T00:00:00.000Z","policy_expiry_date":"2018-01-30T00:00:00.000Z","prev_insurer_id":2,"vehicle_registration_type":"individual","vehicle_ncb_current":"","is_claim_exists":"yes","method_type":"Premium","execution_async":"yes","electrical_accessory":"0","non_electrical_accessory":"0","registration_no":0,"is_llpd":"no","is_antitheft_fit":"no","voluntary_deductible":"0","is_external_bifuel":"no","external_bifuel_value":"","pa_owner_driver_si":"100000","pa_named_passenger_si":"0","pa_unnamed_passenger_si":"0","pa_paid_driver_si":"0","vehicle_expected_idv":0,"first_name":"nilesh","middle_name":"","last_name":"","mobile":"9930089095","email":"test@test.com","crn":0,"ip_address":"","secret_key":"SECRET-ODARQ6JP-9V2Q-7BIM-0NNM-DNRTXRWMRTAL","client_key":"CLIENT-GLF2SRA5-CFIF-4X2T-HC1Z-CXV4ZWQTFQ3T","is_aai_member":0,"external_bifuel_type":"","ss_id":0,"geo_lat":0,"geo_long":0,"isTwentyfour":0,"isActive":1,"created_date":"2018-01-30T06:28:05.000Z","type":"Quote","conversiondate":"2018-01-30T06:28:05.000Z","srn":"SRN-O1REUJCU-PPFG-AQVO-IIEV-4S9LXQIYTSLQ"}],"application":[{"VehicleRequestID":4,"birth_date":"1992-01-01T00:00:00.000Z","fba_id":35779,"product_id":1,"vehicle_id":328,"rto_id":579,"vehicle_insurance_type":"renew","vehicle_manf_date":"2017-01-01T00:00:00.000Z","vehicle_registration_date":"2018-01-25T00:00:00.000Z","policy_expiry_date":"2018-01-30T00:00:00.000Z","prev_insurer_id":2,"vehicle_registration_type":"individual","vehicle_ncb_current":"","is_claim_exists":"yes","method_type":"Premium","execution_async":"yes","electrical_accessory":"0","non_electrical_accessory":"0","registration_no":0,"is_llpd":"no","is_antitheft_fit":"no","voluntary_deductible":"0","is_external_bifuel":"no","external_bifuel_value":"","pa_owner_driver_si":"100000","pa_named_passenger_si":"0","pa_unnamed_passenger_si":"0","pa_paid_driver_si":"0","vehicle_expected_idv":0,"first_name":"nilesh","middle_name":"","last_name":"","mobile":"9930089095","email":"test@test.com","crn":0,"ip_address":"","secret_key":"SECRET-ODARQ6JP-9V2Q-7BIM-0NNM-DNRTXRWMRTAL","client_key":"CLIENT-GLF2SRA5-CFIF-4X2T-HC1Z-CXV4ZWQTFQ3T","is_aai_member":0,"external_bifuel_type":"","ss_id":0,"geo_lat":0,"geo_long":0,"isTwentyfour":0,"isActive":1,"created_date":"2018-01-29T09:29:45.000Z","type":"Application","conversiondate":"","srn":"SRN-123456-PPFG-AQVO-IIEV-4S9LXQIYTSLQ"}]}
     */

    private QuoteApplicationEntity MasterData;

    public QuoteApplicationEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(QuoteApplicationEntity MasterData) {
        this.MasterData = MasterData;
    }


}
