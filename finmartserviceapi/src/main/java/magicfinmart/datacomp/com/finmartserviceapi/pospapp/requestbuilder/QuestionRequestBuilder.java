package magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestbuilder;


import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.PospRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.QuestionResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class QuestionRequestBuilder extends PospRetroRequestBuilder {
    public QuestionRequestBuilder.QuestionNetworkService getService() {

        return super.build().create(QuestionRequestBuilder.QuestionNetworkService.class);
    }

    public interface QuestionNetworkService {
        @POST(PospRetroRequestBuilder.secondaryUrl + "/GetQuestionsByLogin")
        Call<QuestionResponse> getQuestionSet(@Body HashMap<String, String> bodyParameter);
    }
}
