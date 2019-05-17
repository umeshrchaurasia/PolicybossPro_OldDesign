package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.SaveMotorRequestEntity;

public class OfflineMotorListEntity extends SaveMotorRequestEntity   {
    /**
     * SRN : SRN-H9I9THU2-AOUI-MTZY-XUAC-A8N4NDUMIDH6
     * VehicleRequestID : 4
     * fba_id : 52933
     * isActive : 1
     * selectedPrevInsID : 0
     * insImage :
     * quote : [{"TranId":"4","Document_name":"","document_path":""}]
     * motorRequestEntity : {"VehicleRequestID":4,"birth_date":null,"fba_id":52933,"product_id":1,"vehicle_id":3852,"rto_id":581,"vehicle_insurance_type":"new","vehicle_manf_date":"2019-01-01","vehicle_registration_date":"2019-01-13","policy_expiry_date":"","prev_insurer_id":0,"vehicle_registration_type":"individual","vehicle_ncb_current":"0","is_claim_exists":"yes","method_type":"Premium","execution_async":"yes","electrical_accessory":"0","non_electrical_accessory":"0","registration_no":"MH-03-ZZ-9999","is_llpd":"no","is_antitheft_fit":"no","voluntary_deductible":"0","is_external_bifuel":"no","external_bifuel_value":0,"pa_owner_driver_si":"","pa_named_passenger_si":"0","pa_unnamed_passenger_si":"0","pa_paid_driver_si":"0","vehicle_expected_idv":0,"first_name":"Test","middle_name":" ","last_name":"Test","mobile":"9967202591","email":"finmarttest@gmail.com","crn":"715652","ip_address":"230.153.27.52","secret_key":"SECRET-VG9N6EVV-MIK3-1GFC-ZRBV-PE7XIQ8DV4GY","client_key":"CLIENT-WF4GWODI-HMEB-Q7M6-CLES-DEJCRF7XLRVI","is_aai_member":"no","external_bifuel_type":"","ss_id":0,"geo_lat":19.0858499,"geo_long":72.8882851,"isTwentyfour":null,"isActive":1,"created_date":"16/01/2019","type":"Q","conversiondate":null,"srn":"SRN-H9I9THU2-AOUI-MTZY-XUAC-A8N4NDUMIDH6","agent_source":"","selectedPrevInsID":0,"PBStatus":null,"PBStatusDesc":null,"StatusPercent":0,"app_version":"2.1.7","device_id":"f-pdRe3xY-0:APA91bGx4CEiTyJMpkiao7koPHZz-JwTY7JSrKUQHMwpxv_L493RiU5Ql_UGiFv0RZuBJsR2s2NqIPFP7Y_Xnd4yjCV2vyYp4sIhbdnFeWErM5SC7a0VJmaVJ1G51DkZsKNUih4GOhZ0","erp_source":"","mac_address":"d0:4:1:5:45:3a","insImage":"","varid":0,"vehicle_insurance_subtype":"1CH_2TP","sendmobileno":"","sendmessage":"","SavedStatus":"0","TransId":4,"progress_image":""}
     */


    private List<OfflineQuoteListEntity> quote;


    public List<OfflineQuoteListEntity> getQuote() {
        return quote;
    }

    public void setQuote(List<OfflineQuoteListEntity> quote) {
        this.quote = quote;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(this.quote);
    }

    public OfflineMotorListEntity() {
    }

    protected OfflineMotorListEntity(Parcel in) {
        super(in);
        this.quote = in.createTypedArrayList(OfflineQuoteListEntity.CREATOR);
    }

    public static final Creator<OfflineMotorListEntity> CREATOR = new Creator<OfflineMotorListEntity>() {
        @Override
        public OfflineMotorListEntity createFromParcel(Parcel source) {
            return new OfflineMotorListEntity(source);
        }

        @Override
        public OfflineMotorListEntity[] newArray(int size) {
            return new OfflineMotorListEntity[size];
        }
    };
}
