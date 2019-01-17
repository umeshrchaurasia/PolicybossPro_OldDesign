package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UploadMotorEntity;

public class OfflineCommonResponse extends APIResponse {


    /**
     * MasterData : {"TransId":"4","RequestId":4,"SavedStatus":0,"Document":[{"docname":"Last year policy copy","docpath":"OfflineDoc/87/1544620796437.jpg","id":"58"},{"docname":"RC copy","docpath":"","id":""},{"docname":"Other 1","docpath":"","id":""},{"docname":"Other 2","docpath":"","id":""}]}
     */

    private UploadMotorEntity MasterData;

    public UploadMotorEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(UploadMotorEntity MasterData) {
        this.MasterData = MasterData;
    }


}
