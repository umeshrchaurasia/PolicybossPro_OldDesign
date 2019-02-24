package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UltraMainEntity;

/**
 * Created by Rajeev Ranjan on 19/02/2019.
 */

public class UltraLakshyaQuoteApplnResponse extends APIResponse {
    /**
     * MasterData : {"quote":[{"PkRequestId":1,"Name":"umesh test","Email":"finmarttest@gmail.com","MobileNo":"9224966668","FBAID":1976,"SumAssured":"1000000","Frequency":"Yearly","InsuredDob":"23-09-1984","InsuredGender":"M","IsTobaacoUser":"False","PolicyTerm":"20","CreatedDate":"2019-02-16T10:02:57.000Z","IsActive":1,"ULRequest":"","ULResponse":"","CRN":"234212","Status":"","QuoteApplicationStatus":"Q","SumAssuredHdFc":"5000000"},{"PkRequestId":2,"Name":"umesh test","Email":"finmarttest@gmail.com","MobileNo":"9224966668","FBAID":1976,"SumAssured":"1000000","Frequency":"Yearly","InsuredDob":"23-09-1984","InsuredGender":"M","IsTobaacoUser":"False","PolicyTerm":"20","CreatedDate":"2019-02-16T10:22:05.000Z","IsActive":1,"ULRequest":"","ULResponse":"","CRN":"234220","Status":"","QuoteApplicationStatus":"Q","SumAssuredHdFc":"5000000"},{"PkRequestId":3,"Name":"Test test","Email":"finmarttest@gmail.com","MobileNo":"9224966668","FBAID":1976,"SumAssured":"5000000","Frequency":"Yearly","InsuredDob":"23-09-1985","InsuredGender":"M","IsTobaacoUser":"False","PolicyTerm":"15","CreatedDate":"2019-02-16T10:22:45.000Z","IsActive":1,"ULRequest":"","ULResponse":"","CRN":"234221","Status":"","QuoteApplicationStatus":"Q","SumAssuredHdFc":"25000000"}],"application":[{"PkRequestId":1,"Name":"umesh test","Email":"finmarttest@gmail.com","MobileNo":"9224966668","FBAID":1976,"SumAssured":"1000000","Frequency":"Yearly","InsuredDob":"23-09-1984","InsuredGender":"M","IsTobaacoUser":"False","PolicyTerm":"20","CreatedDate":"2019-02-16T10:02:57.000Z","IsActive":1,"ULRequest":"","ULResponse":"","CRN":"234212","Status":"","QuoteApplicationStatus":"Q","SumAssuredHdFc":"5000000"}]}
     */

    private UltraMainEntity MasterData;

    public UltraMainEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(UltraMainEntity MasterData) {
        this.MasterData = MasterData;
    }



}
