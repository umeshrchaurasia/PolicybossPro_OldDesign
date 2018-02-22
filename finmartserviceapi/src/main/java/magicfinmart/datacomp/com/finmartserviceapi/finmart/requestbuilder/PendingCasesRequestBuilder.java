package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthDeleteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PendingCaseDeleteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PendingCasesResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Rajeev Ranjan on 25/01/2018.
 */

public class PendingCasesRequestBuilder extends FinmartRetroRequestBuilder {

    public PendingNetworkService getService() {

        return super.build().create(PendingNetworkService.class);
    }

    public interface PendingNetworkService {

        @Headers("token:" + token)
        @POST("/api/pending-cases")
        Call<PendingCasesResponse> getPendingCases(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/api/delete-pending-cases")
        Call<PendingCaseDeleteResponse> deletePendingCase(@Body HashMap<String, String> body);
    }
}
