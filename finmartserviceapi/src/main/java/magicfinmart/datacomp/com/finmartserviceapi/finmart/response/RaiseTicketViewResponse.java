package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RaiseTickeViewEntity;

/**
 * Created by Rajeev Ranjan on 09/05/2019.
 */
public class RaiseTicketViewResponse extends APIResponse {


    private List<RaiseTickeViewEntity> MasterData;

    public List<RaiseTickeViewEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<RaiseTickeViewEntity> MasterData) {
        this.MasterData = MasterData;
    }


}
