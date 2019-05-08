package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.MotorRequestEntity;

public class QuoteListEntity implements Parcelable {

    private String vehicle_insurance_type;
    private String SRN;
    private int VehicleRequestID;
    private int fba_id;
    private int isActive;
    private int LeadId;
    private MotorRequestEntity motorRequestEntity;
    public QuoteListEntity() {
    }

    protected QuoteListEntity(Parcel in) {
        vehicle_insurance_type = in.readString();
        SRN = in.readString();
        VehicleRequestID = in.readInt();
        fba_id = in.readInt();
        isActive = in.readInt();
        LeadId = in.readInt();
        motorRequestEntity = in.readParcelable(MotorRequestEntity.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(vehicle_insurance_type);
        dest.writeString(SRN);
        dest.writeInt(VehicleRequestID);
        dest.writeInt(fba_id);
        dest.writeInt(isActive);
        dest.writeInt(LeadId);
        dest.writeParcelable(motorRequestEntity, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuoteListEntity> CREATOR = new Creator<QuoteListEntity>() {
        @Override
        public QuoteListEntity createFromParcel(Parcel in) {
            return new QuoteListEntity(in);
        }

        @Override
        public QuoteListEntity[] newArray(int size) {
            return new QuoteListEntity[size];
        }
    };

    public String getVehicle_insurance_type() {
        return vehicle_insurance_type;
    }

    public void setVehicle_insurance_type(String vehicle_insurance_type) {
        this.vehicle_insurance_type = vehicle_insurance_type;
    }

    public String getSRN() {
        return SRN;
    }

    public void setSRN(String SRN) {
        this.SRN = SRN;
    }

    public int getVehicleRequestID() {
        return VehicleRequestID;
    }

    public void setVehicleRequestID(int vehicleRequestID) {
        VehicleRequestID = vehicleRequestID;
    }

    public int getFba_id() {
        return fba_id;
    }

    public void setFba_id(int fba_id) {
        this.fba_id = fba_id;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getLeadId() {
        return LeadId;
    }

    public void setLeadId(int leadId) {
        LeadId = leadId;
    }

    public MotorRequestEntity getMotorRequestEntity() {
        return motorRequestEntity;
    }

    public void setMotorRequestEntity(MotorRequestEntity motorRequestEntity) {
        this.motorRequestEntity = motorRequestEntity;
    }




}