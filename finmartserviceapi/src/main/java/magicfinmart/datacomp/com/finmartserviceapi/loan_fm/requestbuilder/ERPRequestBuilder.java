package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.ErpLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.HomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.ERPSaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.RBCustomerResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.retrobuilder.ERPRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by IN-RB on 04-03-2018.
 */

public class ERPRequestBuilder extends ERPRetroRequestBuilder {

    public ERPRequestBuilder.ERPNetworkService getService() {
        return super.build().create(ERPRequestBuilder.ERPNetworkService.class);
    }

    public interface ERPNetworkService {

        @POST("/LoginDtls.svc/XMLService/insBasicLeadData")
        Call<ERPSaveResponse> saveErpLoanData(@Body ErpLoanRequest erpLoanRequest);


    }
}
