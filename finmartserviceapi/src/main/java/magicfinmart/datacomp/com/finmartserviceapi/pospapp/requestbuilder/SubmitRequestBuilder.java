package magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestbuilder;


import magicfinmart.datacomp.com.finmartserviceapi.pospapp.PospRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.SubmitRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.SubmitResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by Rajeev Ranjan on 03/04/2017.
 */

public class SubmitRequestBuilder extends PospRetroRequestBuilder {
    public SubmitRequestBuilder.SubmitNetworkService getService() {

        return super.build().create(SubmitRequestBuilder.SubmitNetworkService.class);
    }

    public interface SubmitNetworkService {
        @POST(PospRetroRequestBuilder.secondaryUrl + "/SubmitExam")
        Call<SubmitResponse> submitAnswer(@Body SubmitRequestEntity submitRequestEntity);
    }
}
