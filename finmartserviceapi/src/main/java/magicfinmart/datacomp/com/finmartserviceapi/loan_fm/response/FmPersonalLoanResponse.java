package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response;


import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.APIResponseFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.PersonalMainEntity;

/**
 * Created by IN-RB on 01-02-2018.
 */

public class FmPersonalLoanResponse extends APIResponseFM {
    private PersonalMainEntity MasterData;

    public PersonalMainEntity getMasterData() {
        return MasterData;
    }
    public void setMasterData(PersonalMainEntity MasterData) {
        this.MasterData = MasterData;
    }

//
//    private List<MasterData> MasterData;
//
//    public List<MasterData> getMasterData() {
//        return MasterData;
//    }
//
//    public void setMasterData(List<MasterData> MasterData) {
//        this.MasterData = MasterData;
//    }
//
//    public  class MasterData {
//        /**
//         * SavedStatus : 0
//         * Message : Saved Successfully
//         * LoanRequestID : 8
//         */
//
//        private int SavedStatus;
//
//        private String Message;
//        private int LoanRequestID;
//
//        public int getSavedStatus() {
//            return SavedStatus;
//        }
//
//        public void setSavedStatus(int SavedStatus) {
//            this.SavedStatus = SavedStatus;
//        }
//
//        public String getMessageFm() {
//            return Message;
//        }
//
//        public void setMessageFm(String MessageX) {
//            this.Message = MessageX;
//        }
//
//        public int getLoanRequestID() {
//            return LoanRequestID;
//        }
//
//        public void setLoanRequestID(int LoanRequestID) {
//            this.LoanRequestID = LoanRequestID;
//        }
//    }
}
