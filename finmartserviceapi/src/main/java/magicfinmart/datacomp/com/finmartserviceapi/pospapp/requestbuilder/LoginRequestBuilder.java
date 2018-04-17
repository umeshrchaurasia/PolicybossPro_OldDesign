package magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestbuilder;


import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.PospRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.LoginRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.CertificateResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.LoginResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.LogoutResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.SendAdminResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class LoginRequestBuilder extends PospRetroRequestBuilder {
    public LoginRequestBuilder.LoginNetworkService getService() {

        return super.build().create(LoginRequestBuilder.LoginNetworkService.class);
    }

    public interface LoginNetworkService {

        @POST(PospRetroRequestBuilder.secondaryUrl + "/LoginByFBAId")
        Call<LoginResponse> LoginByFBAId(@Body LoginRequestEntity loginRequestEntity);

        @POST(PospRetroRequestBuilder.secondaryUrl + "/Login")
        Call<LoginResponse> login(@Body LoginRequestEntity loginRequestEntity);

        @POST(PospRetroRequestBuilder.secondaryUrl + "/Logout")
        Call<LogoutResponse> logout(@Body HashMap<String, String> bodyParameter);

        @POST(PospRetroRequestBuilder.secondaryUrl + "/SendAdminMail")
        Call<SendAdminResponse> requestAdmin(@Body HashMap<String, String> bodyParameter);

        @POST(PospRetroRequestBuilder.secondaryUrl + "/ViewCertificate")
        Call<CertificateResponse> getCertificate(@Body HashMap<String, String> bodyParameter);

    }
}
