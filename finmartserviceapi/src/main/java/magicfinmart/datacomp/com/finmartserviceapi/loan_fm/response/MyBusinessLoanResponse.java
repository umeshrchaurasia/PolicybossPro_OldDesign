package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseERP;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.ResultDataMyBuisness;

public class MyBusinessLoanResponse  extends APIResponseERP {

    private ResultDataMyBuisness result;

    public ResultDataMyBuisness getResult() {
        return result;
    }

    public void setResult(ResultDataMyBuisness result) {
        this.result = result;
    }

}
