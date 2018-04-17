package magicfinmart.datacomp.com.finmartserviceapi.express_loan.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
/**
 * Created by IN-RB on 17-04-2018.
 */

public class ExpressRbPersonalResponse extends APIResponse {


    private List<MasterDataEntity> MasterData;

    public List<MasterDataEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<MasterDataEntity> MasterData) {
        this.MasterData = MasterData;
    }

    public static class MasterDataEntity {
        /**
         * SavedStatus : 0
         * Message : Record saved successfully.
         */

        private int SavedStatus;

        private String Message;

        public int getSavedStatus() {
            return SavedStatus;
        }

        public void setSavedStatus(int SavedStatus) {
            this.SavedStatus = SavedStatus;
        }

        public String getMessageX() {
            return Message;
        }

        public void setMessageX(String Message) {
            this.Message = Message;
        }
    }
}
