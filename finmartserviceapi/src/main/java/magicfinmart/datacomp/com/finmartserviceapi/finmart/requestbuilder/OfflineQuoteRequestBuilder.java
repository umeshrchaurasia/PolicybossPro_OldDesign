package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder;

import java.util.HashMap;
import java.util.Map;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.CCRblRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.SaveHealthRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.SaveMotorRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CCRblResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CreateQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.DocumentResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineCommonResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineHealthResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineHealthSaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineInputResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineMotorListResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.Offline_TermResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TermCompareQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TermQuoteApplicationResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.FinmartRetroRequestBuilder;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by Nilesh birhade on 23/02/2018.
 */

public class OfflineQuoteRequestBuilder extends FinmartRetroRequestBuilder {

    public OfflineQuoteNetworkService getService() {

        return super.build().create(OfflineQuoteNetworkService.class);
    }

    public interface OfflineQuoteNetworkService {

        @Headers("token:" + token)
        @POST("/quote/Postfm/credit-card-rbl")
        Call<CCRblResponse> applyRbl(@Body CCRblRequestEntity ccRblRequestEntity);

        @Headers("token:" + token)
        @POST("/quote/Postfm/get-offline-quote-material")
        Call<OfflineInputResponse> getOfflineInput();

        @Headers("token:" + token)
        @POST("/quote/Postfm/offline-quotes-request")
        Call<CreateQuoteResponse> createQuote(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @Multipart
        @POST("/quote/Postfm/upload-doc-offline-quotes ")
        Call<DocumentResponse> uploadDocumentOfflineQuotes(@Part() MultipartBody.Part doc, @PartMap() Map<String, String> partMap);

        @Headers("token:" + token)
        @POST("/quote/Postfm/get-offline-quotes")
        Call<OfflineQuoteResponse> getOfflineQuote(@Body HashMap<String, String> body);


        //region offline quote new

        @Headers("token:" + token)
        @POST("/quote/Postfm/manage-vehicle-offline")
        Call<OfflineCommonResponse> saveOfflineMotor(@Body SaveMotorRequestEntity saveMotorRequestEntity);


        @Headers("token:" + token)
        @POST("/quote/Postfm/get-vehicle-offline-quote")
        Call<OfflineMotorListResponse> getOfflineMotorList(@Body HashMap<String, String> body);

        // Health
//life
        @Headers("token:" + token)
        @POST("/quote/Postfm/smart-term-life-offline-quote")
        Call<Offline_TermResponse> getTermCompareQuotes_offline(@Body TermFinmartRequest body);

        @Headers("token:" + token)
        @POST("/quote/Postfm/manage-health-request-offline")
        Call<OfflineHealthSaveResponse> saveOfflineHealth(@Body SaveHealthRequestEntity saveMotorRequestEntity);


        @Headers("token:" + token)
        @POST("/quote/Postfm/get-health-request-offline")
        Call<OfflineHealthResponse> getOfflineHealthList(@Body HashMap<String, String> body);
        @Headers("token:" + token)
        @POST("/quote/Postfm/get-smart-term-life-offline-quote")
        Call<TermQuoteApplicationResponse> getTermQuoteApplication_offline(@Body HashMap<String, String> body);
        //endregion

    }
}
