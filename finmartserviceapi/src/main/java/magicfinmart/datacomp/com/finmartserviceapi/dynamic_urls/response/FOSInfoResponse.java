package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

public class FOSInfoResponse extends APIResponse {

    /**
     * MasterData : {"hidesubuser":"Y","hideloan":"Y"}
     */

    private FOSInfoEntity MasterData;

    public FOSInfoEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(FOSInfoEntity MasterData) {
        this.MasterData = MasterData;
    }

    public static class FOSInfoEntity {
        /**
         * hidesubuser : Y
         * hideloan : Y
         */

        private String hidesubuser;
        private String hideloan;

        public String getHidesubuser() {
            return hidesubuser;
        }

        public void setHidesubuser(String hidesubuser) {
            this.hidesubuser = hidesubuser;
        }

        public String getHideloan() {
            return hideloan;
        }

        public void setHideloan(String hideloan) {
            this.hideloan = hideloan;
        }
    }
}
