package magicfinmart.datacomp.com.finmartserviceapi.pospapp.response;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.RegisterEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;


/**
 * Created by Rajeev Ranjan on 23/03/2017.
 */

public class RegisterResponse extends APIResponse {
    /**
     * result : {"Category":"Caller","CategoryId":1,"Email":"rajeev@gmail.com","FullName":"Rajeev Ranjan","MobileNumber":9833112345,"Password":"121212","UserId":5}
     */

    private RegisterEntity result;

    public RegisterEntity getResult() {
        return result;
    }

    public void setResult(RegisterEntity result) {
        this.result = result;
    }


}
