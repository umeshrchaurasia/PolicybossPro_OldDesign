package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity;

/**
 * Created by IN-RB on 01-02-2018.
 */

public class FmPersonalLoanRequest {


    /**
     * loan_requestID : 5
     * fba_id : 35779
     * PersonalLoanRequest : {"ApplicantDOB":"1997-01-15","ApplicantGender":"M","ApplicantIncome":"19200","ApplicantNme":"test","ApplicantObligations":"400","ApplicantSource":"1","BrokerId":"0","LoanRequired":"500000","LoanTenure":"4","api_source":"","empcode":"","loanid":"1"}
     */

    private String loan_requestID;
    private String fba_id;
    private PersonalLoanRequest PersonalLoanRequest;

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

    public PersonalLoanRequest getPersonalLoanRequest() {
        return PersonalLoanRequest;
    }

    public void setPersonalLoanRequest(PersonalLoanRequest PersonalLoanRequest) {
        this.PersonalLoanRequest = PersonalLoanRequest;
    }

//    public static class PersonalLoanRequest {
//        /**
//         * ApplicantDOB : 1997-01-15
//         * ApplicantGender : M
//         * ApplicantIncome : 19200
//         * ApplicantNme : test
//         * ApplicantObligations : 400
//         * ApplicantSource : 1
//         * BrokerId : 0
//         * LoanRequired : 500000
//         * LoanTenure : 4
//         * api_source :
//         * empcode :
//         * loanid : 1
//         */
//
//        private String ApplicantDOB;
//        private String ApplicantGender;
//        private String ApplicantIncome;
//        private String ApplicantNme;
//        private String ApplicantObligations;
//        private String ApplicantSource;
//        private String BrokerId;
//        private String LoanRequired;
//        private String LoanTenure;
//        private String api_source;
//        private String empcode;
//        private String loanid;
//
//        public String getApplicantDOB() {
//            return ApplicantDOB;
//        }
//
//        public void setApplicantDOB(String ApplicantDOB) {
//            this.ApplicantDOB = ApplicantDOB;
//        }
//
//        public String getApplicantGender() {
//            return ApplicantGender;
//        }
//
//        public void setApplicantGender(String ApplicantGender) {
//            this.ApplicantGender = ApplicantGender;
//        }
//
//        public String getApplicantIncome() {
//            return ApplicantIncome;
//        }
//
//        public void setApplicantIncome(String ApplicantIncome) {
//            this.ApplicantIncome = ApplicantIncome;
//        }
//
//        public String getApplicantNme() {
//            return ApplicantNme;
//        }
//
//        public void setApplicantNme(String ApplicantNme) {
//            this.ApplicantNme = ApplicantNme;
//        }
//
//        public String getApplicantObligations() {
//            return ApplicantObligations;
//        }
//
//        public void setApplicantObligations(String ApplicantObligations) {
//            this.ApplicantObligations = ApplicantObligations;
//        }
//
//        public String getApplicantSource() {
//            return ApplicantSource;
//        }
//
//        public void setApplicantSource(String ApplicantSource) {
//            this.ApplicantSource = ApplicantSource;
//        }
//
//        public String getBrokerId() {
//            return BrokerId;
//        }
//
//        public void setBrokerId(String BrokerId) {
//            this.BrokerId = BrokerId;
//        }
//
//        public String getLoanRequired() {
//            return LoanRequired;
//        }
//
//        public void setLoanRequired(String LoanRequired) {
//            this.LoanRequired = LoanRequired;
//        }
//
//        public String getLoanTenure() {
//            return LoanTenure;
//        }
//
//        public void setLoanTenure(String LoanTenure) {
//            this.LoanTenure = LoanTenure;
//        }
//
//        public String getApi_source() {
//            return api_source;
//        }
//
//        public void setApi_source(String api_source) {
//            this.api_source = api_source;
//        }
//
//        public String getEmpcode() {
//            return empcode;
//        }
//
//        public void setEmpcode(String empcode) {
//            this.empcode = empcode;
//        }
//
//        public String getLoanid() {
//            return loanid;
//        }
//
//        public void setLoanid(String loanid) {
//            this.loanid = loanid;
//        }
//    }
}
