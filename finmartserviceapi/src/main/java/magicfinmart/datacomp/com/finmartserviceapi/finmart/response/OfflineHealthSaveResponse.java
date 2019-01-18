package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by Rajeev Ranjan on 17/01/2019.
 */

public class OfflineHealthSaveResponse extends APIResponse {


    private List<OfflineHealthEntity> MasterData;

    public List<OfflineHealthEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<OfflineHealthEntity> MasterData) {
        this.MasterData = MasterData;
    }

    public static class OfflineHealthEntity {
        /**
         * SavedStatus : 0
         * Message : Record saved successfully.
         * HealthRequestId : 2
         */

        private int SavedStatus;
        private String Message;
        private int HealthRequestId;

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

        public int getHealthRequestId() {
            return HealthRequestId;
        }

        public void setHealthRequestId(int HealthRequestId) {
            this.HealthRequestId = HealthRequestId;
        }
    }
}
