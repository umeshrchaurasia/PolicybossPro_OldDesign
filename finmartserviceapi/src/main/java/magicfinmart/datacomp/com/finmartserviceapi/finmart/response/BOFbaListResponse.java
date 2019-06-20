package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BOFbaEntity;

public class BOFbaListResponse extends APIResponse {


    private List<BOFbaEntity> MasterData;

    public List<BOFbaEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<BOFbaEntity> MasterData) {
        this.MasterData = MasterData;
    }


}
