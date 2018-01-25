package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder;


import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.BikeMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CarMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CityMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.InsuranceMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Created by Nilesh birhade on 25-01-2018.
 */

public class QuoteApplicationRequestBuilder extends FinmartRetroRequestBuilder {


    public QuoteApplicationRequestBuilder.MasterNetworkService getService() {

        return super.build().create(QuoteApplicationRequestBuilder.MasterNetworkService.class);
    }

    public interface MasterNetworkService {

        @Headers("token:1234567890")
        @POST("/api/get-loan-request")
        Call<CarMasterResponse> getQuoteApplication(@Body HashMap<String, String> body);

        @Headers("token:1234567890")
        @POST("/api/save-loan-request")
        Call<BikeMasterResponse> saveQuote(@Body HashMap<String, String> body);

       /* @Headers("token:1234567890")
        @POST("/api/generate-otp")
        Call<FastLaneDataResponse> getFastLaneData(@Body HashMap<String, String> body);*/
    }
}
