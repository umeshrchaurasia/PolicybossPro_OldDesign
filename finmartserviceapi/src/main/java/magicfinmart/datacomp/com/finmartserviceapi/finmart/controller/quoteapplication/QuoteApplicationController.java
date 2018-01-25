package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quoteapplication;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters.AsyncCarMaster;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.QuoteApplicationRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.QuoteApplicationResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nilesh Birhade on 25-01-2018.
 */

public class QuoteApplicationController implements IQuoteApp {

    QuoteApplicationRequestBuilder.QuoteApplicationNetworkService quoteApplicationNetworkService;
    Context mContext;

    public QuoteApplicationController(Context context) {
        mContext = context;
        quoteApplicationNetworkService = new QuoteApplicationRequestBuilder().getService();
    }

    @Override
    public void getQuoteAppList(String vehicleReqID, int fbaID, int productID, String crn, final IResponseSubcriber iResponseSubcriber) {
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("VehicleRequestID", vehicleReqID);
//        hashMap.put("fba_id", "" + fbaID);
//        hashMap.put("product_id", "" + productID);
//        hashMap.put("crn", "" + crn);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("VehicleRequestID", "");
        hashMap.put("fba_id", "" + "");
        hashMap.put("product_id", "");
        hashMap.put("crn", "");

        quoteApplicationNetworkService.getQuoteApplication(hashMap).enqueue(new Callback<QuoteApplicationResponse>() {
            @Override
            public void onResponse(Call<QuoteApplicationResponse> call, Response<QuoteApplicationResponse> response) {
                if (response.body() != null) {
                    if (response.body().getStatusNo() == 0) {
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException("Failed to fetch information."));
                }
            }

            @Override
            public void onFailure(Call<QuoteApplicationResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Check your internet connection"));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Check your internet connection"));
                } else if (t instanceof NumberFormatException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Unexpected server response"));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                }
            }
        });
    }
}
