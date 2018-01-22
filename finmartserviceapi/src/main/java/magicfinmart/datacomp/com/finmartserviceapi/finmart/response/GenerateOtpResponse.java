package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GenerateOtpEntity;

/**
 * Created by Rajeev Ranjan on 22/01/2018.
 */

public class GenerateOtpResponse extends APIResponse {

    private List<List<GenerateOtpEntity>> MasterData;

    public List<List<GenerateOtpEntity>> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<List<GenerateOtpEntity>> MasterData) {
        this.MasterData = MasterData;
    }


}
