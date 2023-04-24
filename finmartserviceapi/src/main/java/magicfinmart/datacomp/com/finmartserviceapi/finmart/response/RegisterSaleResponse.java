package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.SalesDataEntity;

/**
 * Created by IN-RB on 23-01-2019.
 */

public class RegisterSaleResponse extends APIResponse {

    private List<SalesDataEntity> MasterData;

    public List<SalesDataEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<SalesDataEntity> MasterData) {
        this.MasterData = MasterData;
    }


}
