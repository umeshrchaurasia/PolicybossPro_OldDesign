package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder;


import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.HomeLoanApplyRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.HomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.EmiCalculatorResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GenerateHLLeadResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.RBCustomerResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.retrobuilder.LoanRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public class HomeloanRequestBuilder extends LoanRetroRequestBuilder {

    public HomeloanNetworkService getService() {
        return super.build().create(HomeloanNetworkService.class);
    }

    public interface HomeloanNetworkService {

        @POST("/quote/Postfm/mobile-api-compare")
        Call<GetQuoteResponse> getQuotes(@Body HomeLoanRequest homeLoanRequest);

        @POST("/quote/Postfm/getcustomer")
        Call<RBCustomerResponse> getRupeeBossCustomer(@Body HashMap<String, String> body);



        @POST("/quote/Postfm/emi-calc-app")
        Call<EmiCalculatorResponse> getemicalculatordata(@Body HashMap<String, String> body);
    }
}
