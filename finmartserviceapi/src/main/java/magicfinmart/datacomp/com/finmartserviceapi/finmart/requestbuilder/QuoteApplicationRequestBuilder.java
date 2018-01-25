package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder;


import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.QuoteApplicationResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Created by Nilesh birhade on 25-01-2018.
 */

public class QuoteApplicationRequestBuilder extends FinmartRetroRequestBuilder {


    public QuoteApplicationRequestBuilder.QuoteApplicationNetworkService getService() {

        return super.build().create(QuoteApplicationRequestBuilder.QuoteApplicationNetworkService.class);
    }

    public interface QuoteApplicationNetworkService {

        @Headers("token:1234567890")
        @POST("/api/get-vehicle-request")
        Call<QuoteApplicationResponse> getQuoteApplication(@Body HashMap<String, String> body);

        @Headers("token:1234567890")
        @POST("/api/save-loan-request")
        Call<QuoteApplicationResponse> saveQuote(@Body HashMap<String, String> body);

       /* @Headers("token:1234567890")
        @POST("/api/generate-otp")
        Call<FastLaneDataResponse> getFastLaneData(@Body HashMap<String, String> body);*/
    }
}
