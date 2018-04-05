package magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestbuilder;


import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.PospRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.UserPicResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by Rajeev Ranjan on 06/04/2017.
 */

public class UserPicRequestBuilder extends PospRetroRequestBuilder {
    public UserPicRequestBuilder.UserPicNetworkService getService() {

        return super.build().create(UserPicRequestBuilder.UserPicNetworkService.class);
    }

    public interface UserPicNetworkService {

        @POST(PospRetroRequestBuilder.secondaryUrl + "/CaptureEmployeePic")
        Call<UserPicResponse> uploadPicture(@Body HashMap<String, String> bodyParameter);
    }
}
