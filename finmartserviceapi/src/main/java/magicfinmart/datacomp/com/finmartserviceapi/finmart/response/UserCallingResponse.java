package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserCallingEntity;

/**
 * Created by Rajeev Ranjan on 25/06/2019.
 */
public class UserCallingResponse extends APIResponse {


    private List<UserCallingEntity> MasterData;

    public List<UserCallingEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<UserCallingEntity> MasterData) {
        this.MasterData = MasterData;
    }


}
