package magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestbuilder;


import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.PospRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.SyncRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.ModulePracticeResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.SyncTimeResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by Rajeev Ranjan on 17/04/2017.
 */

public class ModulePracticeRequestBuilder extends PospRetroRequestBuilder {
    public ModulePracticeRequestBuilder.ModulePracticeNetworkService getService() {

        return super.build().create(ModulePracticeRequestBuilder.ModulePracticeNetworkService.class);
    }

    public interface ModulePracticeNetworkService {

        @POST(PospRetroRequestBuilder.secondaryUrl + "/GetPracticeSet")
        Call<ModulePracticeResponse> getModulePractice(@Body HashMap<String, String> bodyParameter);

        @POST(PospRetroRequestBuilder.secondaryUrl + "/SynchroniseTime")
        Call<SyncTimeResponse> getSyncTime(@Body SyncRequestEntity syncRequestEntity);
    }
}
