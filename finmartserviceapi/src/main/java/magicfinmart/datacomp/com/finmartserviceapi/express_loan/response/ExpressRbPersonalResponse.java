package magicfinmart.datacomp.com.finmartserviceapi.express_loan.response;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
/**
 * Created by IN-RB on 17-04-2018.
 */

public class ExpressRbPersonalResponse extends APIResponse {
    /**
     * MasterData : {"ReferenceCode":"#PLQER293F"}
     */

    private MasterDataEntity MasterData;

    public MasterDataEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(MasterDataEntity MasterData) {
        this.MasterData = MasterData;
    }

    public static class MasterDataEntity {
        /**
         * ReferenceCode : #PLQER293F
         */

        private String ReferenceCode;

        public String getReferenceCode() {
            return ReferenceCode;
        }

        public void setReferenceCode(String ReferenceCode) {
            this.ReferenceCode = ReferenceCode;
        }
    }



}
