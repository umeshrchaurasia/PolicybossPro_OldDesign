package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.fastlane;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.FastLaneRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.FastLaneDataResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rajeev Ranjan on 23/01/2018.
 */

public class FastLaneController implements IFastLane {
    FastLaneRequestBuilder.FastLaneNetworkService fastLaneNetworkService;
    Context mContext;
    IResponseSubcriber iResponseSubcriber;

    public FastLaneController(Context context) {
        fastLaneNetworkService = new FastLaneRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void getVechileDetails(String RegistrationNumber, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> body = new HashMap<>();
        body.put("RegistrationNumber", RegistrationNumber);
        fastLaneNetworkService.getFastLaneData(body).enqueue(new Callback<FastLaneDataResponse>() {
            @Override
            public void onResponse(Call<FastLaneDataResponse> call, Response<FastLaneDataResponse> response) {
                if (response.body() != null) {

                    //callback of data
                    iResponseSubcriber.OnSuccess(response.body(), "");

                } else {
                    //failure
                    iResponseSubcriber.OnFailure(new RuntimeException("Enable to reach server, Try again later"));
                }
            }

            @Override
            public void onFailure(Call<FastLaneDataResponse> call, Throwable t) {
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
