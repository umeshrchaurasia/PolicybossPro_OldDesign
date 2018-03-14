package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.ErpHomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.ErpPersonLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.ERPSaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.HomeLoanApplicationResponse;
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

        @POST("/LoginDtls.svc/XMLService/insHomeLoanApplnDtlsForAPP")
        Call<ERPSaveResponse> saveErpHomeLoanData(@Body ErpHomeLoanRequest erpLoanRequest);

        @POST("/LoginDtls.svc/XMLService/insLAPDtlsForAPP")
        Call<ERPSaveResponse> saveErpHoLoanAgainstPropertyData(@Body ErpHomeLoanRequest erpLoanRequest);

        @POST("/LoginDtls.svc/XMLService/insPersonalLoanApplnDtlsForAPP")
        Call<ERPSaveResponse> saveErpPersonalLoanData(@Body ErpPersonLoanRequest erpLoanRequest);


        @POST("/LoginDtls.svc/XMLService/dsplyHomeloanDtlsForAPP")
        Call<HomeLoanApplicationResponse> getHomeLoanApplication(@Body HashMap<String, String> body);

    }
}
