package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.FestivalCompaignEntity;


public class FestivalCampaignResponse extends APIResponse {


    private List<FestivalCompaignEntity> MasterData;

    public List<FestivalCompaignEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<FestivalCompaignEntity> MasterData) {
        this.MasterData = MasterData;
    }


}
