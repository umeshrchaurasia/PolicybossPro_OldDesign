package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder;

import java.util.HashMap;


import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.LICIllustrationRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.UltralakshaRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.DeleteTermQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthQuotetoAppResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TermCompareQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TermQuoteApplicationResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TermQuoteToAppResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakshaIllustrationResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakshaIllustrationResponseNew;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakshaRecalculateResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakshyaQuoteApplnResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UpdateCRNResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Rajeev Ranjan on 25/01/2018.
 */

public class TermRequestBuilder extends FinmartRetroRequestBuilder {

    public TermNetworkService getService() {

        return super.build().create(TermNetworkService.class);
    }

    public interface TermNetworkService {


        @Headers("token:" + token)
        @POST("/quote/Postfm/delete-smart-term-life")
        Call<DeleteTermQuoteResponse> deleteTermInsurance(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/quote/Postfm/smart-term-life")
        Call<TermCompareQuoteResponse> getTermCompareQuotes(@Body TermFinmartRequest body);

        @Headers("token:" + token)
        @POST("/quote/Postfm/get-smart-term-life")
        Call<TermQuoteApplicationResponse> getTermQuoteApplication(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/quote/Postfm/smart-term-quote-to-application")
        Call<TermQuoteToAppResponse> convertQuoteToApp(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/quote/Postfm/product-insurance-mappingId-update")
        Call<UpdateCRNResponse> updateCRN(@Body HashMap<String, String> body);

/*
        @Headers("token:" + token)
        @POST("/quote/Postfm/set-quote-application-smart-health")
        Call<HealthQuotetoAppResponse> convertHealthQuoteToApp(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/quote/Postfm/delete-smart-health")
        Call<HealthDeleteResponse> deleteQuote(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/quote/Postfm/compare-premium")
        Call<HealthQuoteCompareResponse> compareQuotes(@Body HealthCompareRequestEntity entity);

        @Headers("token:" + token)
        @POST("/quote/Postfm/GetCompareBenefits")
        Call<BenefitsListResponse> getBenefits(@Body HashMap<String, String> body);*/

        //region ultra laksha

        @Headers("token:" + token)
        @POST("/quote/Postfm/getultralakshyaquotelist")
        Call<UltraLakshyaQuoteApplnResponse> getUltraQuoteApplnList(@Body HashMap<String, String> body);


        @Headers("token:" + token)
        @POST("/quote/Postfm/liccombowrapper")
        Call<UltraLakshaRecalculateResponse> recalculateUltraLaksha(@Body UltralakshaRequestEntity entity);

        @Headers("token:" + token)
        @POST("/quote/Postfm/licillustration")
        Call<UltraLakshaIllustrationResponseNew> getIllustration(@Body LICIllustrationRequestEntity entity);

        //endregion
    }
}
