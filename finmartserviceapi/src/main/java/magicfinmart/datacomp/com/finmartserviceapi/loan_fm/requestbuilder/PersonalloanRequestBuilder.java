package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BLLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetBLDispalyResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetPersonalLoanResponse;

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


        @POST("/api/balance-transfer-with-qid")
        Call<GetBLDispalyResponse> getBLDispalyResponseQuotes(@Body BLLoanRequest blLoanRequest);
    }
}
