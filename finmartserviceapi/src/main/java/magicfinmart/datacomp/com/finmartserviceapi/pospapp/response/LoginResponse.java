package magicfinmart.datacomp.com.finmartserviceapi.pospapp.response;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.LoginEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;


/**
 * Created by Rajeev Ranjan on 23/03/2017.
 */

public class LoginResponse extends APIResponse {
    /**
     * result : {"Category":"Caller","CategoryId":1,"Email":"vinit@gmail.com","FullName":"Vinit Chindarkar","MobileNumber":9833223456,"Password":"123456","UserId":1}
     */

    private LoginEntity result;

    public LoginEntity getResult() {
        return result;
    }

    public void setResult(LoginEntity result) {
        this.result = result;
    }

}
