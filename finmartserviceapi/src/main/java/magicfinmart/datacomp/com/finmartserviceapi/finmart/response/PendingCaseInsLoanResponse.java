package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PendingCasesEntity;

/**
 * Created by Rajeev Ranjan on 03/09/2018.
 */

public class PendingCaseInsLoanResponse extends APIResponse {

    /**
       */

    private MasterDataBean MasterData;

    public MasterDataBean getMasterData() {
        return MasterData;
    }

    public void setMasterData(MasterDataBean MasterData) {
        this.MasterData = MasterData;
    }

    public static class MasterDataBean {
        private List<PendingCasesEntity> Insurance;
        private List<PendingCasesEntity> Loan;

        public List<PendingCasesEntity> getInsurance() {
            return Insurance;
        }

        public void setInsurance(List<PendingCasesEntity> Insurance) {
            this.Insurance = Insurance;
        }

        public List<PendingCasesEntity> getLoan() {
            return Loan;
        }

        public void setLoan(List<PendingCasesEntity> Loan) {
            this.Loan = Loan;
        }
    }
}
