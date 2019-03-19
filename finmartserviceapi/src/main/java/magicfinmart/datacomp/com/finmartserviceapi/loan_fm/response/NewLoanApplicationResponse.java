package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.NewLoanApplicationEnity;

/**
 * Created by IN-RB on 18-03-2019.
 */

public class NewLoanApplicationResponse extends APIResponseFM {

    private List<NewLoanApplicationEnity> MasterData;

    public List<NewLoanApplicationEnity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<NewLoanApplicationEnity> MasterData) {
        this.MasterData = MasterData;
    }


}
