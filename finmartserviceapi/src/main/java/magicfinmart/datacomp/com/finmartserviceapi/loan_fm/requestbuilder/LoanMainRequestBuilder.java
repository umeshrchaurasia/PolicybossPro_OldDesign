package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmHomelLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmPersonalLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.QuoteApplicatLoanResonse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by IN-RB on 31-01-2018.
 */

public class LoanMainRequestBuilder extends FinmartRetroRequestBuilder {

    public LoanMainRequestBuilder.LoanMainNetworkService getService() {

        return super.build().create(LoanMainRequestBuilder.LoanMainNetworkService.class);
    }

    public interface LoanMainNetworkService {

        //    region HomeLoan

        @Headers("token:1234567890")
        @POST("/api/get-loan-request")
        Call<QuoteApplicatLoanResonse> getHLQuoteApplication(@Body HashMap<String, String> body);

        @Headers("token:1234567890")
//        @POST("/api/save-HLloan-request")
        @POST("/api/save-loan-request")
        Call<FmHomelLoanResponse> saveHLQuote(@Body FmHomeLoanRequest fmHomeLoanRequest);


        //endregion

        //    region PersonalLoan

        @Headers("token:1234567890")
        @POST("/api/save-PLloan-request")
        Call<FmPersonalLoanResponse> savePLQuote(@Body FmPersonalLoanRequest fmPersonalLoanRequest);

        //endregion
    }

}
