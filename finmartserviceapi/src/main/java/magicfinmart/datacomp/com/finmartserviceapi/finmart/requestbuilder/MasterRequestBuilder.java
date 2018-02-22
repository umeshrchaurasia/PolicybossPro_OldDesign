package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder;


import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.BikeMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CarMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CityMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.ContactUsResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.InsuranceMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Created by IN-RB on 31-05-2017.
 */

public class MasterRequestBuilder extends FinmartRetroRequestBuilder {


    public MasterRequestBuilder.MasterNetworkService getService() {

        return super.build().create(MasterRequestBuilder.MasterNetworkService.class);
    }

    public interface MasterNetworkService {

        @Headers("token:" + token)
        @POST("/api/vehicle-details")
        Call<CarMasterResponse> getCarMaster(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/api/vehicle-details")
        Call<BikeMasterResponse> getBikeMaster(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @GET("/api/get-city-vehicle")
        Call<CityMasterResponse> getAllCity();

        @Headers("token:" + token)
        @GET("/api/get-insurance-company")
        Call<InsuranceMasterResponse> getInsuranceMasters();

        @Headers("token:" + token)
        @POST("/api/contact-us")
        Call<ContactUsResponse> getContactUs();

       /* @Headers("token:1234567890")
        @POST("/api/generate-otp")
        Call<FastLaneDataResponse> getFastLaneData(@Body HashMap<String, String> body);*/
    }
}
