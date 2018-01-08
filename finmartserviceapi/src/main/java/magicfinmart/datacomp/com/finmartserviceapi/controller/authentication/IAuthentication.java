package magicfinmart.datacomp.com.finmartserviceapi.controller.authentication;


import magicfinmart.datacomp.com.finmartserviceapi.core.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.requestmodel.LoginRequest;

/**
 * Created by Nilesh Birhade on 05-01-2018.
 */

public interface IAuthentication {
    void login(LoginRequest loginRequest, IResponseSubcriber iResponseSubcriber);
}
