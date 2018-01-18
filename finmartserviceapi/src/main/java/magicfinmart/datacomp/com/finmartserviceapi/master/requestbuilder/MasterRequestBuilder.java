package magicfinmart.datacomp.com.finmartserviceapi.master.requestbuilder;


import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.master.response.AllCityMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.master.response.BikeMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.master.response.CarMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.master.response.FastLaneResponse;
import magicfinmart.datacomp.com.finmartserviceapi.master.retromaster.MasterRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by IN-RB on 31-05-2017.
 */

public class MasterRequestBuilder extends MasterRetroRequestBuilder {


    public final static String SUB_URL = "/PBService.svc";

    public MasterRequestBuilder.MasterNetworkService getService() {

        return super.build().create(MasterRequestBuilder.MasterNetworkService.class);
    }

    public interface MasterNetworkService {

        @POST(SUB_URL + "/GetVehicleMasterDetails")
        Call<CarMasterResponse> getCarMaster(@Body HashMap<String, String> body);

        @POST(SUB_URL + "/GetVehicleMasterDetails")
        Call<BikeMasterResponse> getBikeMaster(@Body HashMap<String, String> body);

        @POST(SUB_URL + "/GetVechicalCityService")
        Call<AllCityMasterResponse> getAllCity();

        @POST(SUB_URL + "/FastLaneService")
        Call<FastLaneResponse> getFastLaneData(@Body HashMap<String, String> body);
    }
}
