package magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestbuilder;


import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.PospRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.SendEmailResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by Rajeev Ranjan on 27/04/2017.
 */

public class SendEmailRequestBuilder extends PospRetroRequestBuilder {
    public SendEmailRequestBuilder.SendEmailNetworkService getService() {

        return super.build().create(SendEmailRequestBuilder.SendEmailNetworkService.class);
    }

    public interface SendEmailNetworkService {

        @POST(PospRetroRequestBuilder.secondaryUrl + "/SendEmailLink")
        Call<SendEmailResponse> sendEmail(@Body HashMap<String, String> bodyParameter);
    }
}
