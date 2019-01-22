package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SmsTemplateEntity;

/**
 * Created by Rajeev Ranjan on 21/01/2019.
 */

public class SmsTemplateResponse extends APIResponse {


    private List<SmsTemplateEntity> MasterData;

    public List<SmsTemplateEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<SmsTemplateEntity> MasterData) {
        this.MasterData = MasterData;
    }


}
