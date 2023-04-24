package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import com.google.gson.annotations.SerializedName;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PaymentDetailEntity;


public class PaymentDetailResponse extends APIResponse {


    /**
       */

    private PaymentDetailEntity MasterData;

    public PaymentDetailEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(PaymentDetailEntity MasterData) {
        this.MasterData = MasterData;
    }


}
