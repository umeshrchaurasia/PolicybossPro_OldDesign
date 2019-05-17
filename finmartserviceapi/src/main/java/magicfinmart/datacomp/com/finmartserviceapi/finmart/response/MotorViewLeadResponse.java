package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;

/**
 * Created by Rajeev Ranjan on 15/05/2019.
 */
public class MotorViewLeadResponse extends APIResponse {

    private QuoteListEntity MasterData;

    public QuoteListEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(QuoteListEntity MasterData) {
        this.MasterData = MasterData;
    }

}
