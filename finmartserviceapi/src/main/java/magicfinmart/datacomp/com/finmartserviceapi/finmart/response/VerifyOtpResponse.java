package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ValidateOtpEntity;

/**
 * Created by Rajeev Ranjan on 22/01/2018.
 */

public class VerifyOtpResponse extends APIResponse {
    private List<List<ValidateOtpEntity>> MasterData;

    public List<List<ValidateOtpEntity>> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<List<ValidateOtpEntity>> MasterData) {
        this.MasterData = MasterData;
    }


}
