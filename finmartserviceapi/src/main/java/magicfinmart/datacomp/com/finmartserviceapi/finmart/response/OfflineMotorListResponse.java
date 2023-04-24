package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.OfflineMotorListEntity;

public class OfflineMotorListResponse extends APIResponse {


    private List<OfflineMotorListEntity> MasterData;

    public List<OfflineMotorListEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<OfflineMotorListEntity> MasterData) {
        this.MasterData = MasterData;
    }

   }
