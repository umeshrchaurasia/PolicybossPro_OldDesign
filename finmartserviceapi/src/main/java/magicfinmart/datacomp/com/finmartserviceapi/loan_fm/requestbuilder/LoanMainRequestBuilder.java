package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BankSaveRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmBalanceLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.BankForNodeResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmBalanceLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmHomelLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmPersonalLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmSaveQuoteBLResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmSaveQuoteHomeLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmSaveQuotePersonalLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.NewLoanApplicationResponse;
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
        @POST("/quote/Postfm/get-loan-request")
        Call<FmHomelLoanResponse> getHLQuoteApplication(@Body HashMap<String, String> body);

        @Headers("token:1234567890")
//        @POST("/quote/Postfm/save-HLloan-request")
        @POST("/quote/Postfm/save-loan-request")
        Call<FmSaveQuoteHomeLoanResponse> saveHLQuote(@Body FmHomeLoanRequest fmHomeLoanRequest);


        //endregion

        //    region PersonalLoan


        @Headers("token:1234567890")
        @POST("/quote/Postfm/getloanrequest")
        Call<NewLoanApplicationResponse> getLoanApplication(@Body HashMap<String, String> body);

        @Headers("token:1234567890")
        @POST("/quote/Postfm/get-personalloan-request")
        Call<FmPersonalLoanResponse> getPLQuoteApplication(@Body HashMap<String, String> body);

        @Headers("token:1234567890")
        @POST("/quote/Postfm/manage-personalloan")
        Call<FmSaveQuotePersonalLoanResponse> savePLQuote(@Body FmPersonalLoanRequest fmPersonalLoanRequest);

        //endregion

        //bank save
        @Headers("token:1234567890")
        @POST("/quote/Postfm/update-bank-id")
        Call<BankForNodeResponse> savebankFbABuy(@Body BankSaveRequest bankSaveRequest);

        //BT


        @Headers("token:1234567890")
        @POST("/quote/Postfm/get-balance-transfer-request")
        Call<FmBalanceLoanResponse> getBLQuoteApplication(@Body HashMap<String, String> body);

        @Headers("token:1234567890")
        @POST("/quote/Postfm/ManageBalanceTransfer")
        Call<FmSaveQuoteBLResponse> saveBLQuote(@Body FmBalanceLoanRequest fmBalanceLoanRequest);
        //delete
        @Headers("token:1234567890")
        @POST("/quote/Postfm/delete-loan-request-loan")
        Call<FmSaveQuoteHomeLoanResponse> getdelete_loanrequest(@Body HashMap<String, String> body);

        @Headers("token:1234567890")
        @POST("/quote/Postfm/delete-personal-loan-request")
        Call<FmSaveQuotePersonalLoanResponse> getdelete_personalrequest(@Body HashMap<String, String> body);

        @Headers("token:1234567890")
        @POST("/quote/Postfm/delete-balance-transfer")
        Call<FmSaveQuoteBLResponse> getdelete_balancerequest(@Body HashMap<String, String> body);

    }

}
