package magicfinmart.datacomp.com.finmartserviceapi.master.controller;

import android.content.Context;


import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.master.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.master.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.master.requestbuilder.MasterRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.master.response.AllCityMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.master.response.BikeMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.master.response.CarMasterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nilesh Birhade on 29-11-2017.
 */

public class MasterController implements IMasterFetch {

    MasterRequestBuilder.MasterNetworkService masterNetworkService;
    Context mContext;

    public MasterController(Context context) {
        mContext = context;
        masterNetworkService = new MasterRequestBuilder().getService();
    }

    @Override
    public void getCarMaster(final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ProductId", "1");

        masterNetworkService.getCarMaster(hashMap).enqueue(new Callback<CarMasterResponse>() {
            @Override
            public void onResponse(Call<CarMasterResponse> call, Response<CarMasterResponse> response) {
                if (response.body() != null) {
                    if (response.body().getStatusNo() == 0) {
                        new AsyncStoreCarMaster(mContext, response.body().getMasterData()).execute();
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException("Failed to fetch information."));
                }
            }

            @Override
            public void onFailure(Call<CarMasterResponse> call, Throwable t) {
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

    @Override
    public void getBikeMaster(final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ProductId", "10");

        masterNetworkService.getBikeMaster(hashMap).enqueue(new Callback<BikeMasterResponse>() {
            @Override
            public void onResponse(Call<BikeMasterResponse> call, Response<BikeMasterResponse> response) {

                if (response.body() != null) {
                    if (response.body().getStatusNo() == 0) {
                        new AsyncStoreBikeMaster(mContext, response.body().getMasterData()).execute();
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException("Failed to fetch information."));
                }
            }

            @Override
            public void onFailure(Call<BikeMasterResponse> call, Throwable t) {
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

    @Override
    public void getRTOMaster(final IResponseSubcriber iResponseSubcriber) {

        masterNetworkService.getAllCity().enqueue(new Callback<AllCityMasterResponse>() {
            @Override
            public void onResponse(Call<AllCityMasterResponse> call, Response<AllCityMasterResponse> response) {

                if (response.body() != null) {
                    if (response.body().getStatusNo() == 0) {
                        new AsyncRTOMaster(mContext, response.body().getListvehicle()).execute();
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException("Failed to fetch information."));
                }
            }

            @Override
            public void onFailure(Call<AllCityMasterResponse> call, Throwable t) {

            }
        });
    }
}
