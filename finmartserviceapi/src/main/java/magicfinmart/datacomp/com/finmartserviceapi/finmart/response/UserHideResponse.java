package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserHideEntity;

public class UserHideResponse  extends APIResponse {


    /**
     * MasterData : {"hidesubuser":"Y"}
     */

    private UserHideEntity MasterData;

    public UserHideEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(UserHideEntity MasterData) {
        this.MasterData = MasterData;
    }


}
