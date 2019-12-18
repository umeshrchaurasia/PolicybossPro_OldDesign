package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PospAgentEntity;

/**
 * Created by Rajeev Ranjan on 05/12/2019.
 */
public class PospAgentResponse extends APIResponse {


    private List<PospAgentEntity> MasterData;

    public List<PospAgentEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<PospAgentEntity> MasterData) {
        this.MasterData = MasterData;
    }


}
