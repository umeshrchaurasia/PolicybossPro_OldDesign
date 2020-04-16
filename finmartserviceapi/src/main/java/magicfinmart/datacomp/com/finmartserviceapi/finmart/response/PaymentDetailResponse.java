package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import com.google.gson.annotations.SerializedName;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PaymentDetailEntity;


public class PaymentDetailResponse extends APIResponse {


    /**
     * MasterData : {"CustID":"8407152","Name":"tttttt Test","Email":"testpay@yahoo.com","Mobile":"8198868870","image":"http://api.magicfinmart.com/images/salesmaterial/razorpay/finlog.png","dispmsg":"Please Create CustomerId","Status":0}
     */

    private PaymentDetailEntity MasterData;

    public PaymentDetailEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(PaymentDetailEntity MasterData) {
        this.MasterData = MasterData;
    }


}
