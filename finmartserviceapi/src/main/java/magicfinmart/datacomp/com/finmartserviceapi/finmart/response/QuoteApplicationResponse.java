package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteApplicationEntity;

/**
 * Created by Nilesh Birhade on 25-01-2018.
 */

public class QuoteApplicationResponse extends APIResponse {

    /**
     * MasterData : {"quote":[{"VehicleRequestID":5,"birth_date":"2018-01-22T00:00:00.000Z","fba_id":5,"product_id":4,"vehicle_id":2,"rto_id":2,"vehicle_insurance_type":"Testsadsaf","vehicle_manf_date":"2018-01-22T00:00:00.000Z","vehicle_registration_date":"2018-01-22T00:00:00.000Z","policy_expiry_date":"2018-01-22T00:00:00.000Z","prev_insurer_id":1,"vehicle_registration_type":"B","vehicle_ncb_current":"B","is_claim_exists":"1","method_type":"B","execution_async":"1","electrical_accessory":"1","non_electrical_accessory":"1","registration_no":1,"is_llpd":"1","is_antitheft_fit":"1","voluntary_deductible":"1","is_external_bifuel":"1","external_bifuel_value":"1","pa_owner_driver_si":"1","pa_named_passenger_si":"1","pa_unnamed_passenger_si":"1","pa_paid_driver_si":"1","vehicle_expected_idv":1,"first_name":"test","middle_name":"123","last_name":"456","mobile":"3456778908","email":"test.gus@.scom","crn":"asdasda2132144 v34234423435","ip_address":"192.168.0.0","secret_key":"1234","client_key":"1234","is_aai_member":"1","external_bifuel_type":"1","ss_id":12,"geo_lat":123,"geo_long":123,"isTwentyfour":null,"isActive":1,"created_date":"2018-01-25T08:24:33.000Z"}],"application":[{"VehicleRequestID":5,"birth_date":"2018-01-22T00:00:00.000Z","fba_id":5,"product_id":4,"vehicle_id":2,"rto_id":2,"vehicle_insurance_type":"Testsadsaf","vehicle_manf_date":"2018-01-22T00:00:00.000Z","vehicle_registration_date":"2018-01-22T00:00:00.000Z","policy_expiry_date":"2018-01-22T00:00:00.000Z","prev_insurer_id":1,"vehicle_registration_type":"B","vehicle_ncb_current":"B","is_claim_exists":"1","method_type":"B","execution_async":"1","electrical_accessory":"1","non_electrical_accessory":"1","registration_no":1,"is_llpd":"1","is_antitheft_fit":"1","voluntary_deductible":"1","is_external_bifuel":"1","external_bifuel_value":"1","pa_owner_driver_si":"1","pa_named_passenger_si":"1","pa_unnamed_passenger_si":"1","pa_paid_driver_si":"1","vehicle_expected_idv":1,"first_name":"test","middle_name":"123","last_name":"456","mobile":"3456778908","email":"test.gus@.scom","crn":"ADADAD1233232ddsdsd3233ff","ip_address":"192.168.0.0","secret_key":"1234","client_key":"1234","is_aai_member":"1","external_bifuel_type":"1","ss_id":12,"geo_lat":123,"geo_long":123,"isTwentyfour":null,"isActive":1,"created_date":"2018-01-25T08:24:33.000Z"}]}
     */

    private QuoteApplicationEntity MasterData;

    public QuoteApplicationEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(QuoteApplicationEntity MasterData) {
        this.MasterData = MasterData;
    }

}
