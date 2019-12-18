package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity;

/**
 * Created by Rajeev Ranjan on 05/12/2019.
 */
public class MultiLangResponse extends APIResponse {


    private List<MultiLangEntity> MasterData;

    public List<MultiLangEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<MultiLangEntity> MasterData) {
        this.MasterData = MasterData;
    }


}
