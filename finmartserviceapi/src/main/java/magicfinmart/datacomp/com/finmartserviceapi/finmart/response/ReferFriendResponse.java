package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by Nilesh Birhade on 26-06-2018.
 */

public class ReferFriendResponse extends APIResponse {

    private List<ReferFriendEntity> MasterData;

    public List<ReferFriendEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<ReferFriendEntity> MasterData) {
        this.MasterData = MasterData;
    }

    public static class ReferFriendEntity {
        /**
         * SavedStatus : 0
         * Message : Referer code validated successfully.
         */

        private int SavedStatus;
        @SerializedName("Message")
        private String MessageX;

        public int getSavedStatus() {
            return SavedStatus;
        }

        public void setSavedStatus(int SavedStatus) {
            this.SavedStatus = SavedStatus;
        }

        public String getMessageX() {
            return MessageX;
        }

        public void setMessageX(String MessageX) {
            this.MessageX = MessageX;
        }
    }
}
