package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by IN-RB on 18-01-2019.
 */

public class CertificateResponse extends APIResponse {

    /**
     * MasterData : https://posp.policyboss.com/Pos/AppointmentLetter/413
     */

    private String MasterData;

    public String getMasterData() {
        return MasterData;
    }

    public void setMasterData(String MasterData) {
        this.MasterData = MasterData;
    }
}
