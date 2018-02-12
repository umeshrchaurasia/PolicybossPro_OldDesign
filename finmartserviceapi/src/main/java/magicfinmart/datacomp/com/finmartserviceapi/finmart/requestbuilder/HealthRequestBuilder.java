package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthQuoteAppResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthQuotetoAppResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Rajeev Ranjan on 25/01/2018.
 */

public class HealthRequestBuilder extends FinmartRetroRequestBuilder {

    public HealthNetworkService getService() {

        return super.build().create(HealthNetworkService.class);
    }

    public interface HealthNetworkService {

        @Headers("token:" + token)
        @POST("/api/get-smart-health")
        Call<HealthQuoteAppResponse> getHealthQuoteAppList(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/api/smart-health")
        Call<HealthQuoteResponse> getHealthQuote(@Body HealthRequestEntity body);

        @Headers("token:" + token)
        @POST("/api/set-quote-application-smart-health")
        Call<HealthQuotetoAppResponse> convertHealthQuoteToApp(@Body HashMap<String, String> body);
    }
}
