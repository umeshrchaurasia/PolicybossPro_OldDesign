package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder;

import java.util.HashMap;
import java.util.Map;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.CreateTicketrequest;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CreateTicketResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.DocumentResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.RaiseTicketViewResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TicketCategoryResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.RaiseTicketCommentResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TicketListResponse;
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
 * Created by Rajeev Ranjan on 23/01/2018.
 */

public class ZohoRequestBuilder extends FinmartRetroRequestBuilder {



    public ZohoRequestBuilder.ZohoNetworkService getService() {

        return super.build().create(ZohoRequestBuilder.ZohoNetworkService.class);
    }

    public interface ZohoNetworkService {


        @Headers("token:" + token)
        @POST("/api/get-ticket-categories")
        Call<TicketCategoryResponse> getTicketCategories();

        @Headers("token:" + token)
        @POST("/api/create-ticket")
        Call<CreateTicketResponse> createTicket(@Body CreateTicketrequest body);

               @Headers("token:" + token)
        @POST("/api/get-ticket-request")
        Call<TicketListResponse> getListOfTickets(@Body HashMap<String, String> body);

        @Headers("token:" + token)
        @POST("/api/create-ticket-comments")
        Call<RaiseTicketCommentResponse> saveTicketComment(@Body HashMap<String, String> body);


        @Headers("token:" + token)
        @POST("/api/get-ticket-comments")
        Call<RaiseTicketViewResponse> viewTicket(@Body HashMap<String, String> body);

        // File Upload

        @Headers("token:" + token)
        @Multipart
        @POST("/api/upload-doc-ticket-comment")
        Call<DocumentResponse> uploadDocumentRaiseTicket(@Part() MultipartBody.Part doc, @PartMap() Map<String, String> partMap);

    }
}
