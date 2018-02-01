package magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity;

import android.os.Parcel;
import android.os.Parcelable;

import magicfinmart.datacomp.com.finmartserviceapi.Utility;


/**
 * Created by Nilesh Birhade on 03-07-2017.
 */

public class MotorRequestEntity implements Parcelable {



    /**
     * product_id : 10
     * vehicle_id : 50783
     * rto_id : 579
     * vehicle_insurance_type : renew
     * vehicle_manf_date : 2016-09-01
     * vehicle_registration_date : 2016-09-14
     * policy_expiry_date : 2017-09-12
     * prev_insurer_id : 9
     * vehicle_registration_type : individual
     * vehicle_ncb_current : 0
     * is_claim_exists : yes
     * method_type : Premium
     * execution_async : yes
     * electrical_accessory : 0
     * non_electrical_accessory : 0
     * registration_no : MH-01-AA-1234
     * is_llpd : no
     * is_antitheft_fit : no
     * voluntary_deductible : 0
     * is_external_bifuel : no
     * external_bifuel_value : 0
     * pa_owner_driver_si :
     * pa_named_passenger_si :
     * pa_unnamed_passenger_si :
     * pa_paid_driver_si :
     * vehicle_expected_idv : 0
     * first_name : Manish
     * middle_name :
     * last_name : Anand
     * mobile : 9798192909
     * email : anand.manish92@gmail.com
     * crn : 91566
     * ip_address : ::1
     * secret_key : SECRET-HZ07QRWY-JIBT-XRMQ-ZP95-J0RWP3DYRACW
     * client_key : CLIENT-CNTP6NYE-CU9N-DUZW-CSPI-SH1IS4DOVHB9
     */
    private String birth_date;
    private int product_id;
    private int vehicle_id;
    private int rto_id;
    private String vehicle_insurance_type;
    private String vehicle_manf_date;
    private String vehicle_registration_date;
    private String policy_expiry_date;
    private String prev_insurer_id;
    private String vehicle_registration_type;
    private String vehicle_ncb_current;
    private String is_claim_exists;
    private String method_type;
    private String execution_async;
    private String electrical_accessory;
    private String non_electrical_accessory;
    private String registration_no;
    private String is_llpd;
    private String is_antitheft_fit;
    private int voluntary_deductible;
    private String is_external_bifuel;
    private String external_bifuel_value;
    private String pa_owner_driver_si;
    private String pa_named_passenger_si;
    private String pa_unnamed_passenger_si;
    private String pa_paid_driver_si;
    private int vehicle_expected_idv;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String mobile;
    private String email;
    private int crn;
    private String ip_address;
    private String secret_key;
    private String client_key;



    /**
     * is_aai_member : no
     * external_bifuel_type :
     * external_bifuel_value : 0
     * ss_id : 0
     * geo_lat : 19.0790426
     * geo_long : 72.88183590000001
     */

    private String is_aai_member;
    private String external_bifuel_type;
    private int ss_id;
    private double geo_lat;
    private double geo_long;



    public int getIsTwentyfour() {
        return isTwentyfour;
    }

    public void setIsTwentyfour(int isTwentyfour) {
        this.isTwentyfour = isTwentyfour;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConversiondate() {
        return conversiondate;
    }

    public void setConversiondate(String conversiondate) {
        this.conversiondate = conversiondate;
    }

    //mysql extra parameter
    private int isTwentyfour;
    private int isActive;
    private String created_date;
    private String type;
    private String conversiondate;


    public MotorRequestEntity() {
        this.birth_date = "1992-01-01";
        this.product_id = 0;
        this.vehicle_id = 0;
        this.rto_id = 0;
        this.secret_key = Utility.SECRET_KEY;
        this.client_key = Utility.CLIENT_KEY;
        this.execution_async = "yes";
        this.vehicle_insurance_type = "";
        this.vehicle_manf_date = "";
        this.vehicle_registration_date = "";
        this.policy_expiry_date = "";
        this.prev_insurer_id = "";
        this.vehicle_registration_type = "";
        this.vehicle_ncb_current = "";
        this.is_claim_exists = "";
        this.method_type = "";
        this.electrical_accessory = "0";
        this.non_electrical_accessory = "0";
        this.registration_no = "";
        this.is_llpd = "";
        this.is_antitheft_fit = "no";
        this.voluntary_deductible = 0;
        this.is_external_bifuel = "";
        this.external_bifuel_value = "";
        this.pa_owner_driver_si = "";
        this.pa_named_passenger_si = "";
        this.pa_unnamed_passenger_si = "";
        this.pa_paid_driver_si = "";
        this.vehicle_expected_idv = 0;
        this.first_name = "";
        this.middle_name = "";
        this.last_name = "";
        this.mobile = "";
        this.email = "";
        this.crn = 0;
        this.ip_address = "";
    }


    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getRto_id() {
        return rto_id;
    }

    public void setRto_id(int rto_id) {
        this.rto_id = rto_id;
    }

    public String getVehicle_insurance_type() {
        return vehicle_insurance_type;
    }

    public void setVehicle_insurance_type(String vehicle_insurance_type) {
        this.vehicle_insurance_type = vehicle_insurance_type;
    }

    public String getVehicle_manf_date() {
        return vehicle_manf_date;
    }

    public void setVehicle_manf_date(String vehicle_manf_date) {
        this.vehicle_manf_date = vehicle_manf_date;
    }

    public String getVehicle_registration_date() {
        return vehicle_registration_date;
    }

    public void setVehicle_registration_date(String vehicle_registration_date) {
        this.vehicle_registration_date = vehicle_registration_date;
    }

    public String getPolicy_expiry_date() {
        return policy_expiry_date;
    }

    public void setPolicy_expiry_date(String policy_expiry_date) {
        this.policy_expiry_date = policy_expiry_date;
    }

    public String getPrev_insurer_id() {
        return prev_insurer_id;
    }

    public void setPrev_insurer_id(String prev_insurer_id) {
        this.prev_insurer_id = prev_insurer_id;
    }

    public String getVehicle_registration_type() {
        return vehicle_registration_type;
    }

    public void setVehicle_registration_type(String vehicle_registration_type) {
        this.vehicle_registration_type = vehicle_registration_type;
    }

    public String getVehicle_ncb_current() {
        return vehicle_ncb_current;
    }

    public void setVehicle_ncb_current(String vehicle_ncb_current) {
        this.vehicle_ncb_current = vehicle_ncb_current;
    }

    public String getIs_claim_exists() {
        return is_claim_exists;
    }

    public void setIs_claim_exists(String is_claim_exists) {
        this.is_claim_exists = is_claim_exists;
    }

    public String getMethod_type() {
        return method_type;
    }

    public void setMethod_type(String method_type) {
        this.method_type = method_type;
    }

    public String getExecution_async() {
        return execution_async;
    }

    public void setExecution_async(String execution_async) {
        this.execution_async = execution_async;
    }

    public String getElectrical_accessory() {
        return electrical_accessory;
    }

    public void setElectrical_accessory(String electrical_accessory) {
        this.electrical_accessory = electrical_accessory;
    }

    public String getNon_electrical_accessory() {
        return non_electrical_accessory;
    }

    public void setNon_electrical_accessory(String non_electrical_accessory) {
        this.non_electrical_accessory = non_electrical_accessory;
    }

    public String getRegistration_no() {
        return registration_no;
    }

    public void setRegistration_no(String registration_no) {
        this.registration_no = registration_no;
    }

    public String getIs_llpd() {
        return is_llpd;
    }

    public void setIs_llpd(String is_llpd) {
        this.is_llpd = is_llpd;
    }

    public String getIs_antitheft_fit() {
        return is_antitheft_fit;
    }

    public void setIs_antitheft_fit(String is_antitheft_fit) {
        this.is_antitheft_fit = is_antitheft_fit;
    }

    public int getVoluntary_deductible() {
        return voluntary_deductible;
    }

    public void setVoluntary_deductible(int voluntary_deductible) {
        this.voluntary_deductible = voluntary_deductible;
    }

    public String getIs_external_bifuel() {
        return is_external_bifuel;
    }

    public void setIs_external_bifuel(String is_external_bifuel) {
        this.is_external_bifuel = is_external_bifuel;
    }

    public String getExternal_bifuel_value() {
        return external_bifuel_value;
    }

    public void setExternal_bifuel_value(String external_bifuel_value) {
        this.external_bifuel_value = external_bifuel_value;
    }

    public String getPa_owner_driver_si() {
        return pa_owner_driver_si;
    }

    public void setPa_owner_driver_si(String pa_owner_driver_si) {
        this.pa_owner_driver_si = pa_owner_driver_si;
    }

    public String getPa_named_passenger_si() {
        return pa_named_passenger_si;
    }

    public void setPa_named_passenger_si(String pa_named_passenger_si) {
        this.pa_named_passenger_si = pa_named_passenger_si;
    }

    public String getPa_unnamed_passenger_si() {
        return pa_unnamed_passenger_si;
    }

    public void setPa_unnamed_passenger_si(String pa_unnamed_passenger_si) {
        this.pa_unnamed_passenger_si = pa_unnamed_passenger_si;
    }

    public String getPa_paid_driver_si() {
        return pa_paid_driver_si;
    }

    public void setPa_paid_driver_si(String pa_paid_driver_si) {
        this.pa_paid_driver_si = pa_paid_driver_si;
    }

    public int getVehicle_expected_idv() {
        return vehicle_expected_idv;
    }

    public void setVehicle_expected_idv(int vehicle_expected_idv) {
        this.vehicle_expected_idv = vehicle_expected_idv;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public String getClient_key() {
        return client_key;
    }

    public void setClient_key(String client_key) {
        this.client_key = client_key;
    }



    public String getIs_aai_member() {
        return is_aai_member;
    }

    public void setIs_aai_member(String is_aai_member) {
        this.is_aai_member = is_aai_member;
    }

    public String getExternal_bifuel_type() {
        return external_bifuel_type;
    }

    public void setExternal_bifuel_type(String external_bifuel_type) {
        this.external_bifuel_type = external_bifuel_type;
    }

    public int getSs_id() {
        return ss_id;
    }

    public void setSs_id(int ss_id) {
        this.ss_id = ss_id;
    }

    public double getGeo_lat() {
        return geo_lat;
    }

    public void setGeo_lat(double geo_lat) {
        this.geo_lat = geo_lat;
    }

    public double getGeo_long() {
        return geo_long;
    }

    public void setGeo_long(double geo_long) {
        this.geo_long = geo_long;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.birth_date);
        dest.writeInt(this.product_id);
        dest.writeInt(this.vehicle_id);
        dest.writeInt(this.rto_id);
        dest.writeString(this.vehicle_insurance_type);
        dest.writeString(this.vehicle_manf_date);
        dest.writeString(this.vehicle_registration_date);
        dest.writeString(this.policy_expiry_date);
        dest.writeString(this.prev_insurer_id);
        dest.writeString(this.vehicle_registration_type);
        dest.writeString(this.vehicle_ncb_current);
        dest.writeString(this.is_claim_exists);
        dest.writeString(this.method_type);
        dest.writeString(this.execution_async);
        dest.writeString(this.electrical_accessory);
        dest.writeString(this.non_electrical_accessory);
        dest.writeString(this.registration_no);
        dest.writeString(this.is_llpd);
        dest.writeString(this.is_antitheft_fit);
        dest.writeInt(this.voluntary_deductible);
        dest.writeString(this.is_external_bifuel);
        dest.writeString(this.external_bifuel_value);
        dest.writeString(this.pa_owner_driver_si);
        dest.writeString(this.pa_named_passenger_si);
        dest.writeString(this.pa_unnamed_passenger_si);
        dest.writeString(this.pa_paid_driver_si);
        dest.writeInt(this.vehicle_expected_idv);
        dest.writeString(this.first_name);
        dest.writeString(this.middle_name);
        dest.writeString(this.last_name);
        dest.writeString(this.mobile);
        dest.writeString(this.email);
        dest.writeInt(this.crn);
        dest.writeString(this.ip_address);
        dest.writeString(this.secret_key);
        dest.writeString(this.client_key);
        dest.writeString(this.is_aai_member);
        dest.writeString(this.external_bifuel_type);
        dest.writeInt(this.ss_id);
        dest.writeDouble(this.geo_lat);
        dest.writeDouble(this.geo_long);
        dest.writeInt(this.isTwentyfour);
        dest.writeInt(this.isActive);
        dest.writeString(this.created_date);
        dest.writeString(this.type);
        dest.writeString(this.conversiondate);
    }

    protected MotorRequestEntity(Parcel in) {
        this.birth_date = in.readString();
        this.product_id = in.readInt();
        this.vehicle_id = in.readInt();
        this.rto_id = in.readInt();
        this.vehicle_insurance_type = in.readString();
        this.vehicle_manf_date = in.readString();
        this.vehicle_registration_date = in.readString();
        this.policy_expiry_date = in.readString();
        this.prev_insurer_id = in.readString();
        this.vehicle_registration_type = in.readString();
        this.vehicle_ncb_current = in.readString();
        this.is_claim_exists = in.readString();
        this.method_type = in.readString();
        this.execution_async = in.readString();
        this.electrical_accessory = in.readString();
        this.non_electrical_accessory = in.readString();
        this.registration_no = in.readString();
        this.is_llpd = in.readString();
        this.is_antitheft_fit = in.readString();
        this.voluntary_deductible = in.readInt();
        this.is_external_bifuel = in.readString();
        this.external_bifuel_value = in.readString();
        this.pa_owner_driver_si = in.readString();
        this.pa_named_passenger_si = in.readString();
        this.pa_unnamed_passenger_si = in.readString();
        this.pa_paid_driver_si = in.readString();
        this.vehicle_expected_idv = in.readInt();
        this.first_name = in.readString();
        this.middle_name = in.readString();
        this.last_name = in.readString();
        this.mobile = in.readString();
        this.email = in.readString();
        this.crn = in.readInt();
        this.ip_address = in.readString();
        this.secret_key = in.readString();
        this.client_key = in.readString();
        this.is_aai_member = in.readString();
        this.external_bifuel_type = in.readString();
        this.ss_id = in.readInt();
        this.geo_lat = in.readDouble();
        this.geo_long = in.readDouble();
        this.isTwentyfour = in.readInt();
        this.isActive = in.readInt();
        this.created_date = in.readString();
        this.type = in.readString();
        this.conversiondate = in.readString();
    }

    public static final Parcelable.Creator<MotorRequestEntity> CREATOR = new Parcelable.Creator<MotorRequestEntity>() {
        @Override
        public MotorRequestEntity createFromParcel(Parcel source) {
            return new MotorRequestEntity(source);
        }

        @Override
        public MotorRequestEntity[] newArray(int size) {
            return new MotorRequestEntity[size];
        }
    };
}
