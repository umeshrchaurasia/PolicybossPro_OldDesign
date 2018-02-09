package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.RegisterRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.GenerateOtpResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PincodeResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.RegisterFbaResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.VerifyOtpResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Rajeev Ranjan on 22/01/2018.
 */

public class RegisterRequestBuilder extends FinmartRetroRequestBuilder {

    public RegisterRequestBuilder.RegisterQuotesNetworkService getService() {

        return super.build().create(RegisterRequestBuilder.RegisterQuotesNetworkService.class);
    }

    public interface RegisterQuotesNetworkService {

        @Headers("token:" + token)
        @POST("/api/generate-otp")
        Call<GenerateOtpResponse> generateOtp(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/api/retrive-otp")
        Call<VerifyOtpResponse> verifyOtp(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/api/get-city-and-state")
        Call<PincodeResponse> getCityStateCityPincode(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/api/insert-fba-registration")
        Call<RegisterFbaResponse> registerFba(@Body RegisterRequestEntity body);
    }
}
