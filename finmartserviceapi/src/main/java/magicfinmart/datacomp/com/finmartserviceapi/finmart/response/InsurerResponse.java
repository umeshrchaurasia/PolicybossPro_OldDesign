package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.motor.APIResponse;

public class InsurerResponse extends APIResponse {

    private List<InsurerEntity> MasterData;

    public List<InsurerEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<InsurerEntity> MasterData) {
        this.MasterData = MasterData;
    }

    public static class InsurerEntity {
        /**
         * insurer_id : 45
         * insurer_name : Acko
         */

        private String insurer_id;
        private String insurer_name;

        public String getInsurer_id() {
            return insurer_id;
        }

        public void setInsurer_id(String insurer_id) {
            this.insurer_id = insurer_id;
        }

        public String getInsurer_name() {
            return insurer_name;
        }

        public void setInsurer_name(String insurer_name) {
            this.insurer_name = insurer_name;
        }
    }
}
