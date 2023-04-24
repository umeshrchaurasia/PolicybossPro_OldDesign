package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajeev Ranjan on 07/05/2019.
 */
public class MotorMyLeadEntity implements Parcelable {
    /**
     * Name : Mahesh
     * LeadId : 194
     * FBAID : 1976
     * CRN : 895139
     * ExpiryDate : 2019-05-31
     * Make : NA
     * Model : NA
     * RegNo : MH01BG1324
     * ss_id : 2335
     * VehicleRequestID : 16888
     * MobileNo : 9844556789
     * hasDisposition : 1
     * vehicle_registration_date :
     */

    private String Name;
    private String LeadId;
    private int FBAID;
    private String CRN;
    private String ExpiryDate;
    private String Make;
    private String Model;
    private String RegNo;
    private String ss_id;
    private String VehicleRequestID;
    private String MobileNo;
    private String hasDisposition;
    private String vehicle_registration_date;

    protected MotorMyLeadEntity(Parcel in) {
        Name = in.readString();
        LeadId = in.readString();
        FBAID = in.readInt();
        CRN = in.readString();
        ExpiryDate = in.readString();
        Make = in.readString();
        Model = in.readString();
        RegNo = in.readString();
        ss_id = in.readString();
        VehicleRequestID = in.readString();
        MobileNo = in.readString();
        hasDisposition = in.readString();
        vehicle_registration_date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(LeadId);
        dest.writeInt(FBAID);
        dest.writeString(CRN);
        dest.writeString(ExpiryDate);
        dest.writeString(Make);
        dest.writeString(Model);
        dest.writeString(RegNo);
        dest.writeString(ss_id);
        dest.writeString(VehicleRequestID);
        dest.writeString(MobileNo);
        dest.writeString(hasDisposition);
        dest.writeString(vehicle_registration_date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MotorMyLeadEntity> CREATOR = new Creator<MotorMyLeadEntity>() {
        @Override
        public MotorMyLeadEntity createFromParcel(Parcel in) {
            return new MotorMyLeadEntity(in);
        }

        @Override
        public MotorMyLeadEntity[] newArray(int size) {
            return new MotorMyLeadEntity[size];
        }
    };

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLeadId() {
        return LeadId;
    }

    public void setLeadId(String LeadId) {
        this.LeadId = LeadId;
    }

    public int getFBAID() {
        return FBAID;
    }

    public void setFBAID(int FBAID) {
        this.FBAID = FBAID;
    }

    public String getCRN() {
        return CRN;
    }

    public void setCRN(String CRN) {
        this.CRN = CRN;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String Make) {
        this.Make = Make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String RegNo) {
        this.RegNo = RegNo;
    }

    public String getSs_id() {
        return ss_id;
    }

    public void setSs_id(String ss_id) {
        this.ss_id = ss_id;
    }

    public String getVehicleRequestID() {
        return VehicleRequestID;
    }

    public void setVehicleRequestID(String VehicleRequestID) {
        this.VehicleRequestID = VehicleRequestID;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String MobileNo) {
        this.MobileNo = MobileNo;
    }

    public String getHasDisposition() {
        return hasDisposition;
    }

    public void setHasDisposition(String hasDisposition) {
        this.hasDisposition = hasDisposition;
    }

    public String getVehicle_registration_date() {
        return vehicle_registration_date;
    }

    public void setVehicle_registration_date(String vehicle_registration_date) {
        this.vehicle_registration_date = vehicle_registration_date;
    }


    /**
     * Name : NA
     * LeadId : 186
     * FBAID : 1976
     * CRN :
     * ExpiryDate : 07/05/2019
     * Make : NA
     * Model : NA
     * RegNo : WB12AG5379
     */


}
