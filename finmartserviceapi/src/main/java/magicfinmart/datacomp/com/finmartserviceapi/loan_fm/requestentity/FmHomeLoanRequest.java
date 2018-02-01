package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity;

/**
 * Created by IN-RB on 01-02-2018.
 */

public class FmHomeLoanRequest {


    /**
     * loan_requestID : 5
     * fba_id : 35779
     * HomeLoanRequest : {"ApplicantDOB":"1997-01-02","ApplicantGender":"M","ApplicantIncome":"","ApplicantNme":"test Verma","ApplicantObligations":"700","ApplicantSource":"2","BrokerId":"0","City":"Mumbai","CoApplicantDOB":"1997-01-16","CoApplicantDepreciation":"5444","CoApplicantDirectorRemuneration":"5000","CoApplicantGender":"M","CoApplicantIncome":"","CoApplicantObligations":"","CoApplicantProfitAfterTax":"200","CoApplicantSource":"2","CoApplicantTurnover":"54000","CoApplicantYes":"Y","Depreciation":"2888","DirectorRemuneration":"500","LoanRequired":"5600000","LoanTenure":"22","ProductId":"12","ProfitAfterTax":"400","PropertyCost":"7000000","PropertyID":"1","Turnover":"858655","api_source":"Finmart","empcode":""}
     */

    private String loan_requestID;
    private String fba_id;
    private HomeLoanRequest HomeLoanRequest;

    public String getLoan_requestID() {
        return loan_requestID;
    }

    public void setLoan_requestID(String loan_requestID) {
        this.loan_requestID = loan_requestID;
    }

    public String getFba_id() {
        return fba_id;
    }

    public void setFba_id(String fba_id) {
        this.fba_id = fba_id;
    }

    public HomeLoanRequest getHomeLoanRequest() {
        return HomeLoanRequest;
    }

    public void setHomeLoanRequest(HomeLoanRequest HomeLoanRequest) {
        this.HomeLoanRequest = HomeLoanRequest;
    }

}
