package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.HealthCheckUPRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Nilesh Birhade on 06-08-2018.
 */

public class DynamicUrlBuilder extends HealthCheckUPRetroRequestBuilder {


    public GenericUrlNetworkService getService() {
        return super.build().create(GenericUrlNetworkService.class);
    }

    public interface GenericUrlNetworkService {

        @GET
        Call<VehicleInfoEntity> getVehicleByVehicleNo(@Url String strUrl);

        @POST
        Call<VehicleMobileResponse> getVehicleByMobNo(@Url String strUrl, @Body HashMap<String, String> body);
    }
}
