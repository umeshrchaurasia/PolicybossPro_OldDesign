package magicfinmart.datacomp.com.finmartserviceapi.inspection.requestbuilder;


import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.inspection.InspectionRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.inspection.entity.VehRegRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.inspection.response.GetOtpResponse;
import magicfinmart.datacomp.com.finmartserviceapi.inspection.response.VehicleRegResponse;
import magicfinmart.datacomp.com.finmartserviceapi.inspection.response.VerifyOtpResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Rajeev Ranjan on 24/05/2017.
 */

public class AuthenticationRequestBuilder extends InspectionRetroRequestBuilder {
    //sub url
    public static final String sub_url = "/api/";


    public AuthenticationNetworkService getService() {

        return super.build().create(AuthenticationNetworkService.class);
    }

    public interface AuthenticationNetworkService {

        @POST(SUB_URL + "/vehicle-registration")
        Call<VehicleRegResponse> registerVehicle(@Body VehRegRequestEntity vehRegRequestEntity);

        @POST(SUB_URL + "/vehicle-inspection-otp")
        Call<GetOtpResponse> getOtp(@Body HashMap<String, String> body);

        @POST(SUB_URL + "/vehicle-inspection-verify-otp")
        Call<VerifyOtpResponse> verifyOtp(@Body HashMap<String, String> body);

    }
}
