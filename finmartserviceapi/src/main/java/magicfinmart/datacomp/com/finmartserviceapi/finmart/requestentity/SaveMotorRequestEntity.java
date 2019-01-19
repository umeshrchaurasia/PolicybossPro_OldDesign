package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

import android.os.Parcel;
import android.os.Parcelable;

import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.MotorRequestEntity;

/**
 * Created by Nilesh Birhade on 29-01-2018.
 */

public class SaveMotorRequestEntity implements Parcelable  {

    MotorRequestEntity motorRequestEntity;
    String SRN;
    String VehicleRequestID;
    String fba_id;
    String comment;
    int isActive;
    private String vehicle_insurance_type;


    protected SaveMotorRequestEntity(Parcel in) {
        motorRequestEntity = in.readParcelable(MotorRequestEntity.class.getClassLoader());
        SRN = in.readString();
        VehicleRequestID = in.readString();
        fba_id = in.readString();
        comment = in.readString();
        isActive = in.readInt();
        vehicle_insurance_type = in.readString();
    }

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



    public SaveMotorRequestEntity() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(motorRequestEntity, flags);
        dest.writeString(SRN);
        dest.writeString(VehicleRequestID);
        dest.writeString(fba_id);
        dest.writeString(comment);
        dest.writeInt(isActive);
        dest.writeString(vehicle_insurance_type);
    }
}
