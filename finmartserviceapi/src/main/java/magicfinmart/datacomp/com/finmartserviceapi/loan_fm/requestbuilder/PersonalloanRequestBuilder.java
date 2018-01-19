package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetPersonalLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.PersonalQuoteAppDispalyResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.retrobuilder.LoanRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by IN-RB on 15-01-2018.
 */

public class PersonalloanRequestBuilder extends LoanRetroRequestBuilder {

    public PersonalloanNetworkService getService() {
        return super.build().create(PersonalloanNetworkService.class);
    }
    public interface PersonalloanNetworkService{

        @POST("/api/personal-loan-mobile")
        Call<GetPersonalLoanResponse> getPersonalQuotes(@Body PersonalLoanRequest personalLoanRequest);

        @POST("/api/get-personal-loan-broker-quote")
        Call<PersonalQuoteAppDispalyResponse> getPersonalBrokerQuotes(@Body HashMap<String, String> bodyParameter);


    }
}
