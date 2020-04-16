package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RazorPayEntity;

public class RazorPayResponse  extends APIResponse {


    private List<RazorPayEntity> MasterData;

    public List<RazorPayEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<RazorPayEntity> MasterData) {
        this.MasterData = MasterData;
    }


}
