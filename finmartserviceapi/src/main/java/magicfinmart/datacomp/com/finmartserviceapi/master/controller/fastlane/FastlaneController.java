package magicfinmart.datacomp.com.finmartserviceapi.master.controller.fastlane;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.master.requestbuilder.MasterRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.master.response.FastLaneResponse;
import magicfinmart.datacomp.com.finmartserviceapi.motor.IResponseSubcriber;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rajeev Ranjan on 17/01/2018.
 */

public class FastlaneController implements IFastLane {
    MasterRequestBuilder.MasterNetworkService masterNetworkService;
    Context mContext;

    public FastlaneController(Context context) {
        mContext = context;
        masterNetworkService = new MasterRequestBuilder().getService();
    }
    @Override
    public void getFastLaneData(String vehicle, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("RegistrationNumber", vehicle);

        masterNetworkService.getFastLaneData(hashMap).enqueue(new Callback<FastLaneResponse>() {
            @Override
            public void onResponse(Call<FastLaneResponse> call, Response<FastLaneResponse> response) {
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
            public void onFailure(Call<FastLaneResponse> call, Throwable t) {
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
