package magicfinmart.datacomp.com.finmartserviceapi.requestbuilder;


import magicfinmart.datacomp.com.finmartserviceapi.core.FinmartRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.requestmodel.LoginRequest;
import magicfinmart.datacomp.com.finmartserviceapi.response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import static magicfinmart.datacomp.com.finmartserviceapi.core.FinmartRetroRequestBuilder.SUB_URL;

public class AuthenticationRequestBuilder extends FinmartRetroRequestBuilder {

    public AuthenticationNetworkService getService() {

        return super.build().create(AuthenticationNetworkService.class);
    }

    public interface AuthenticationNetworkService {

        @POST(SUB_URL + "/Login/ProcessLogin")
        Call<LoginResponse> registerVehicle(@Body LoginRequest loginRequest);

    }
}
