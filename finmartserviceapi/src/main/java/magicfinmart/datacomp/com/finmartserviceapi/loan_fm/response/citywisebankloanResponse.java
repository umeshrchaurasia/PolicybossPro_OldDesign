package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseERP;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.LstCitywiseBankLoanEntity;

public class citywisebankloanResponse extends APIResponseERP {

    private List<LstCitywiseBankLoanEntity> result;

    public List<LstCitywiseBankLoanEntity> getResult() {
        return result;
    }

    public void setResult(List<LstCitywiseBankLoanEntity> result) {
        this.result = result;
    }


}
