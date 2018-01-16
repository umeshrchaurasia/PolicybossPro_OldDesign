package magicfinmart.datacomp.com.finmartserviceapi.master.model;

import io.realm.RealmObject;

public class VehicleMasterEntity extends RealmObject {
    /**
     * IsActive : True
     * RTO_City : Port Blair
     * RTO_CodeDiscription : (AN01) Port Blair
     * State_Id : 1
     * State_Name : ANDAMAN-NICOBAR
     * VehicleCity_Id : 1
     * VehicleCity_RTOCode : AN01
     * VehicleTariff_Zone : B
     */

    private String IsActive;
    private String RTO_City;
    private String RTO_CodeDiscription;
    private int State_Id;
    private String State_Name;
    private int VehicleCity_Id;
    private String VehicleCity_RTOCode;
    private String VehicleTariff_Zone;

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String IsActive) {
        this.IsActive = IsActive;
    }

    public String getRTO_City() {
        return RTO_City;
    }

    public void setRTO_City(String RTO_City) {
        this.RTO_City = RTO_City;
    }

    public String getRTO_CodeDiscription() {
        return RTO_CodeDiscription;
    }

    public void setRTO_CodeDiscription(String RTO_CodeDiscription) {
        this.RTO_CodeDiscription = RTO_CodeDiscription;
    }

    public int getState_Id() {
        return State_Id;
    }

    public void setState_Id(int State_Id) {
        this.State_Id = State_Id;
    }

    public String getState_Name() {
        return State_Name;
    }

    public void setState_Name(String State_Name) {
        this.State_Name = State_Name;
    }

    public int getVehicleCity_Id() {
        return VehicleCity_Id;
    }

    public void setVehicleCity_Id(int VehicleCity_Id) {
        this.VehicleCity_Id = VehicleCity_Id;
    }

    public String getVehicleCity_RTOCode() {
        return VehicleCity_RTOCode;
    }

    public void setVehicleCity_RTOCode(String VehicleCity_RTOCode) {
        this.VehicleCity_RTOCode = VehicleCity_RTOCode;
    }

    public String getVehicleTariff_Zone() {
        return VehicleTariff_Zone;
    }

    public void setVehicleTariff_Zone(String VehicleTariff_Zone) {
        this.VehicleTariff_Zone = VehicleTariff_Zone;
    }


    //add spaces in RTO code description for better search in auto complete
    private String addSpaceInRTOCode(String rtoCode) {
        // String str = "(MH46) Mumbai";
        int insertPos = rtoCode.length() - rtoCode.length();
        if (insertPos >= 0) {
            char ch = rtoCode.charAt(insertPos);
            if (!Character.isWhitespace(ch)) {
                rtoCode = new StringBuilder(rtoCode).insert(insertPos + 1, ' ').toString();
            }
        }
        String rtoSpaceForward = rtoCode;
        int forwardSpace = 5;
        if (forwardSpace >= 0) {
            char ch = rtoSpaceForward.charAt(forwardSpace);
            if (!Character.isWhitespace(ch)) {
                rtoSpaceForward = new StringBuilder(rtoCode).insert(forwardSpace + 1, ' ').toString();
            }
        }
        return rtoSpaceForward;
    }
}