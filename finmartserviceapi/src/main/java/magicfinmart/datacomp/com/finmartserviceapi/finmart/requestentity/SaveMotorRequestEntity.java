package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.MotorRequestEntity;

/**
 * Created by Nilesh Birhade on 29-01-2018.
 */

public class SaveMotorRequestEntity {

    MotorRequestEntity motorRequestEntity;
    String SRN;
    String VehicleRequestID;
    String fba_id;
    int isActive;

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
}
