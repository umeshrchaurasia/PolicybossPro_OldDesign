package magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.login;


import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.LoginRequestEntity;

/**
 * Created by Rajeev Ranjan on 23/03/2017.
 */

public interface ILogin {
    void login(LoginRequestEntity loginRequestEntity, IResponseSubcriber iResponseSubcriber);

    void logout(int UserId, int FBAID, IResponseSubcriber iResponseSubcriber);

    void requestAdmin(String email, IResponseSubcriber iResponseSubcriber);

    void getCertificate(IResponseSubcriber iResponseSubcriber);

    void loginByFBAId(LoginRequestEntity loginRequestEntity, IResponseSubcriber iResponseSubcriber);
}
