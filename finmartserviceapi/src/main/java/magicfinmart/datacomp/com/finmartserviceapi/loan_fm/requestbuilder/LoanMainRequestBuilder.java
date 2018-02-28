package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BankSaveRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmHomelLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmPersonalLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmSaveQuoteHomeLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmSaveQuotePersonalLoanResponse;

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
        Call<FmHomelLoanResponse> getHLQuoteApplication(@Body HashMap<String, String> body);

        @Headers("token:1234567890")
//        @POST("/api/save-HLloan-request")
        @POST("/api/save-loan-request")
        Call<FmSaveQuoteHomeLoanResponse> saveHLQuote(@Body FmHomeLoanRequest fmHomeLoanRequest);


        //endregion

        //    region PersonalLoan

        @Headers("token:1234567890")
        @POST("/api/get-personalloan-request")
        Call<FmPersonalLoanResponse> getPLQuoteApplication(@Body HashMap<String, String> body);

        @Headers("token:1234567890")
        @POST("/api/manage-personalloan")
        Call<FmSaveQuotePersonalLoanResponse> savePLQuote(@Body FmPersonalLoanRequest fmPersonalLoanRequest);

        //endregion

        //bank save
        @Headers("token:1234567890")
        @POST("/api/update-bank-id")
        Call<FmSaveQuotePersonalLoanResponse> savebankFbABuy(@Body BankSaveRequest bankSaveRequest);
    }

}