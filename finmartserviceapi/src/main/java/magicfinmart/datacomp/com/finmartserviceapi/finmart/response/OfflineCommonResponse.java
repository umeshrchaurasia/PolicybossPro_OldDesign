package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.OfflineSavedEntity;

public class OfflineCommonResponse extends APIResponse {

    private List<OfflineSavedEntity> MasterData;

    public List<OfflineSavedEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<OfflineSavedEntity> MasterData) {
        this.MasterData = MasterData;
    }


}
