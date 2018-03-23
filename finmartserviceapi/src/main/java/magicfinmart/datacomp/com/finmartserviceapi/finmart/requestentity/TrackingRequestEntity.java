package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TrackingData;

/**
 * Created by Rajeev Ranjan on 21/03/2018.
 */

public class TrackingRequestEntity {
    /**
     * FBAID : 2143
     * Data : {"data":""}
     * Type : register
     */

    private String FBAID;
    private TrackingData Data;
    private String Type;

    public String getFBAID() {
        return FBAID;
    }

    public void setFBAID(String FBAID) {
        this.FBAID = FBAID;
    }

    public TrackingData getData() {
        return Data;
    }

    public void setData(TrackingData Data) {
        this.Data = Data;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }


}
