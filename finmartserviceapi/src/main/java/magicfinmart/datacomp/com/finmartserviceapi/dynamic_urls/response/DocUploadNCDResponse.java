package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response;

import com.google.gson.annotations.SerializedName;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by IN-RB on 11-12-2018.
 */

public class DocUploadNCDResponse extends APIResponse {


    /**
     * MasterData : {"SavedStatus":0,"Message":"Record saved successfully."}
     */

    private MasterDataBean MasterData;

    public MasterDataBean getMasterData() {
        return MasterData;
    }

    public void setMasterData(MasterDataBean MasterData) {
        this.MasterData = MasterData;
    }

    public static class MasterDataBean {
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

        public void setMessageX(String MessageX) {
            this.Message = MessageX;
        }
    }
}
