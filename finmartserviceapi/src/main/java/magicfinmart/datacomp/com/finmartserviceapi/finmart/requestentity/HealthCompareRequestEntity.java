package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

/**
 * Created by Nilesh Birhade on 08-03-2018.
 */

public class HealthCompareRequestEntity {



    private String HealthRequestId;
    private String PlanID;

    public String getPlanID() {
        return PlanID;
    }

    public void setPlanID(String planID) {
        PlanID = planID;
    }

    public String getHealthRequestId() {
        return HealthRequestId;
    }

    public void setHealthRequestId(String HealthRequestId) {
        this.HealthRequestId = HealthRequestId;
    }



}
