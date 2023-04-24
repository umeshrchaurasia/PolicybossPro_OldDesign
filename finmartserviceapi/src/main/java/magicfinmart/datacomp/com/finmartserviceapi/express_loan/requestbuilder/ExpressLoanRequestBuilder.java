package magicfinmart.datacomp.com.finmartserviceapi.express_loan.requestbuilder;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.express_loan.requestentity.EarlySalaryRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.requestentity.HdfcPers_SaveRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.requestentity.KotakPersonalSaveRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.requestentity.RBLPesonalLoanReqEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.requestentity.SaveExpressLoanRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.EarlySalaryLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.ExpressLoanListResponse;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.ExpressQuoteListResponse;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.ExpressRbPersonalResponse;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.ExpressSaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.HdfcPers_SaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.KotakPLEmployerNameResponse;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.KotakROICalResponse;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.kotakPers_SaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by IN-RB on 03-04-2018.
 */

public class ExpressLoanRequestBuilder extends FinmartRetroRequestBuilder {

    public ExpressLoanRequestBuilder.ExpressNetworkService getService() {

        return super.build().create(ExpressLoanRequestBuilder.ExpressNetworkService.class);
    }

    public interface ExpressNetworkService {

        @Headers("token:" + token)
        @POST("/quote/Postfm/get-early-salary")
        Call<ExpressQuoteListResponse> getExpressQuoteList(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/quote/Postfm/express-loan")
        Call<ExpressLoanListResponse> getExpressLoanList();

        @Headers("token:" + token)
        @POST("/quote/Postfm/save-loan")
        Call<ExpressSaveResponse> saveExpressLoan(@Body SaveExpressLoanRequestEntity body);

        @Headers("token:" + token)
        @POST("/quote/Postfm/hdfc-personal-loan")
        Call<HdfcPers_SaveResponse> saveHDFCPersonalLoan(@Body HdfcPers_SaveRequestEntity body);


        @Headers("token:" + token)
        @POST("/quote/Postfm/kotak-personal-loan")
        Call<kotakPers_SaveResponse> savekotakPersonalLoan(@Body KotakPersonalSaveRequestEntity body);

        @Headers("token:" + token)
        @POST("/quote/Postfm/get-kotak-pl-company-master")
       Call<KotakPLEmployerNameResponse> getEmployerNameKotakPL();


        @Headers("token:" + token)
        @POST("/quote/Postfm/get-kotak-pl-calc")
        Call<KotakROICalResponse> getKotakROICalculationList(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/quote/Postfm/save-early-salary")
        Call<EarlySalaryLoanResponse> saveEarlySalaryLoan(@Body EarlySalaryRequestEntity body);

        @Headers("token:" + token)
        @POST("/quote/Postfm/rb-personal-loan")
        Call<ExpressRbPersonalResponse> saveRblPersonalLoan(@Body RBLPesonalLoanReqEntity body);
//

//        @POST("/quote/premium_list_db")
//        Call<BikePremiumResponse> getPremiumList(@Body BikePremiumRequestEntity body);
//

    }



}
