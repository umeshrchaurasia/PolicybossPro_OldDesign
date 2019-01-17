package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

import android.os.Parcel;
import android.os.Parcelable;

import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.MotorRequestEntity;

/**
 * Created by Nilesh Birhade on 29-01-2018.
 */

public class SaveMotorRequestEntity implements Parcelable {

    MotorRequestEntity motorRequestEntity;
    String SRN;
    String VehicleRequestID;
    String fba_id;
    String comment;
    int isActive;
    private String vehicle_insurance_type;


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getVehicle_insurance_type() {
        return vehicle_insurance_type;
    }

    public void setVehicle_insurance_type(String vehicle_insurance_type) {
        this.vehicle_insurance_type = vehicle_insurance_type;
    }

    public MotorRequestEntity getMotorRequestEntity() {
        return motorRequestEntity;
    }

    public void setMotorRequestEntity(MotorRequestEntity motorRequestEntity) {
        this.motorRequestEntity = motorRequestEntity;
    }

    public String getSRN() {
        return SRN;
    }

    public void setSRN(String SRN) {
        this.SRN = SRN;
    }

    public String getVehicleRequestID() {
        return VehicleRequestID;
    }

    public void setVehicleRequestID(String vehicleRequestID) {
        VehicleRequestID = vehicleRequestID;
    }

    public String getFba_id() {
        return fba_id;
    }

    public void setFba_id(String fba_id) {
        this.fba_id = fba_id;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.motorRequestEntity, flags);
        dest.writeString(this.SRN);
        dest.writeString(this.VehicleRequestID);
        dest.writeString(this.fba_id);
        dest.writeString(this.comment);
        dest.writeInt(this.isActive);
        dest.writeString(this.vehicle_insurance_type);
    }

    public SaveMotorRequestEntity() {
    }

    protected SaveMotorRequestEntity(Parcel in) {
        this.motorRequestEntity = in.readParcelable(MotorRequestEntity.class.getClassLoader());
        this.SRN = in.readString();
        this.VehicleRequestID = in.readString();
        this.fba_id = in.readString();
        this.comment = in.readString();
        this.isActive = in.readInt();
        this.vehicle_insurance_type = in.readString();
    }

    public static final Parcelable.Creator<SaveMotorRequestEntity> CREATOR = new Parcelable.Creator<SaveMotorRequestEntity>() {
        @Override
        public SaveMotorRequestEntity createFromParcel(Parcel source) {
            return new SaveMotorRequestEntity(source);
        }

        @Override
        public SaveMotorRequestEntity[] newArray(int size) {
            return new SaveMotorRequestEntity[size];
        }
    };
}
