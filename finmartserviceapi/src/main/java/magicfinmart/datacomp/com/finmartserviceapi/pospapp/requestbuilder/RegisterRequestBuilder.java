package magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestbuilder;


import magicfinmart.datacomp.com.finmartserviceapi.pospapp.PospRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.RegisterRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class RegisterRequestBuilder extends PospRetroRequestBuilder {
    public RegisterRequestBuilder.RegisterNetworkService getService() {

        return super.build().create(RegisterRequestBuilder.RegisterNetworkService.class);
    }

    public interface RegisterNetworkService {

        @POST(PospRetroRequestBuilder.secondaryUrl + "/Register")
        Call<RegisterResponse> register(@Body RegisterRequestEntity registerRequestEntity);
    }
}
