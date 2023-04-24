package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by IN-RB on 17-01-2019.
 */

public class Offline_TermResponse extends APIResponse {


    private List<MasterDataBean> MasterData;

    public List<MasterDataBean> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<MasterDataBean> MasterData) {
        this.MasterData = MasterData;
    }

    public static class MasterDataBean {
        /**
         * SavedStatus : 0
         * lifetermofflinequoteid : 9
         */

        private int SavedStatus;
        private int lifetermofflinequoteid;

        public int getSavedStatus() {
            return SavedStatus;
        }

        public void setSavedStatus(int SavedStatus) {
            this.SavedStatus = SavedStatus;
        }

        public int getLifetermofflinequoteid() {
            return lifetermofflinequoteid;
        }

        public void setLifetermofflinequoteid(int lifetermofflinequoteid) {
            this.lifetermofflinequoteid = lifetermofflinequoteid;
        }
    }
}
