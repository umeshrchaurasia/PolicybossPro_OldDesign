package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls;

import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity.GenerateLeadRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity.UploadNCDRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response.GenerateLeadResponse;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response.NCDResponse;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response.UploadNCDResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Nilesh Birhade on 06-08-2018.
 */

public class DynamicUrlBuilder extends GenericRetroRequestBuilder {


    public GenericUrlNetworkService getService() {
        return super.build().create(GenericUrlNetworkService.class);
    }

    public interface GenericUrlNetworkService {

        @GET
        Call<VehicleInfoEntity> getVehicleByVehicleNo(@Url String strUrl);

        @GET
        Call<VehicleMobileResponse> getVehicleByMobNo(@Url String strGetUrl);

        @Headers("token:" + token)
        @POST
        Call<GenerateLeadResponse> saveGenerateLead(@Url String strUrl, @Body GenerateLeadRequestEntity entity);

        @Headers("token:" + token)
        @POST
        Call<NCDResponse> getNCD(@Url String strUrl);

        @Headers("token:" + token)
        @POST
        Call<UploadNCDResponse> uploadNCD(@Url String s, @Body UploadNCDRequestEntity entity);
    }
}
