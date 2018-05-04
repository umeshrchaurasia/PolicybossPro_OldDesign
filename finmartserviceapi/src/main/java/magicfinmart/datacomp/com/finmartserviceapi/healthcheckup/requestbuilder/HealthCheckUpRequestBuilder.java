package magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.requestbuilder;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.HealthCheckUPRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.requestmodels.HealthPacksDetailsRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.requestmodels.HealthPacksRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.response.HealthPackDetailsResponse;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.response.HealthPackResponse;
import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.response.HealthShortLinkResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Rajeev Ranjan on 15/02/2018.
 */

public class HealthCheckUpRequestBuilder extends HealthCheckUPRetroRequestBuilder {
    public HealthCheckNetworkService getService() {

        return super.build().create(HealthCheckNetworkService.class);
    }

    public interface HealthCheckNetworkService {


        @POST("/Products/HAMobileProductService.asmx/PackDetails")
        Call<HealthPackResponse> getHealthPacks(@Body HealthPacksRequestEntity body);

        @POST("/Products/HAMobileProductService.asmx/PackParam")
        Call<HealthPackDetailsResponse> getHealthPacksDetails(@Body HealthPacksDetailsRequestEntity body);



    }
}
