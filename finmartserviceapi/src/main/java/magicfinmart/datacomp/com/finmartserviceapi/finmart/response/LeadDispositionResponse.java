package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LeadDispositionEntity;

/**
 * Created by Rajeev Ranjan on 17/05/2019.
 */
public class LeadDispositionResponse extends APIResponse {


    private List<LeadDispositionEntity> MasterData;

    public List<LeadDispositionEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<LeadDispositionEntity> MasterData) {
        this.MasterData = MasterData;
    }


}
