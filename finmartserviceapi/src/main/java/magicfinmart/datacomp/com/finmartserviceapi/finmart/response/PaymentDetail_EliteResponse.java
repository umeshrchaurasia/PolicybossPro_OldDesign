package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import com.google.gson.annotations.SerializedName;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.PaymentEliteEntity;

public class PaymentDetail_EliteResponse extends APIResponse {


    /**
     * MasterData : {"CustID":14,"Fullname":"Platinum50","Email":"platinumplan50@gmail.com","Mobile":"9066778978","image":"https://www.rupeeboss.com/image/logo.png","Status":0,"planname":"ELITE PLATINUM","subplan":"PLATINUM50","sumassured":"50000","displayamount":"2044","amount":204400}
     */


    private PaymentEliteEntity MasterData;

    public PaymentEliteEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(PaymentEliteEntity MasterData) {
        this.MasterData = MasterData;
    }


}
