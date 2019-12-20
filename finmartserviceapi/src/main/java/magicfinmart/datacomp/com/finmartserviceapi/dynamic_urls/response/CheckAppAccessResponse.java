package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response;

import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model.CheckAppAccessEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

public class CheckAppAccessResponse extends APIResponse {

    /**
     * result : {"department":"IT","email":"vinit@gmail.com","empstatus":"Active","hrmsid":"4547676","isfirstlogin":0,"lat":"19.0857338","lng":"72.8881863","mobilenumber":9833118670,"name":"Test User","password":"2210","uid":"11111"}
     */

    private CheckAppAccessEntity result;

    public CheckAppAccessEntity getResult() {
        return result;
    }

    public void setResult(CheckAppAccessEntity result) {
        this.result = result;
    }


}
