package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by Rajeev Ranjan on 09/05/2019.
 */
public class RaiseTicketCommentResponse extends APIResponse {


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
         * Message : Comment Added Successfully
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

        public void setMessageX(String MessageX) {
            this.Message = MessageX;
        }
    }
}
