package magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.modulepractice;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestbuilder.ModulePracticeRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.SyncRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.ModulePracticeResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.SyncTimeResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rajeev Ranjan on 17/04/2017.
 */

public class ModulePracticeControllar implements IModulePractice {

    ModulePracticeRequestBuilder.ModulePracticeNetworkService questionNetworkService;
    Context mContext;

    public ModulePracticeControllar(Context context) {
        questionNetworkService = new ModulePracticeRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void getModuleQuestion(int ModuleNo, int CategoryId, int UserId, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> bodyParameter = new HashMap<String, String>();

        bodyParameter.put("ModuleNo", "" + ModuleNo);
        bodyParameter.put("CategoryId", "" + CategoryId);
        bodyParameter.put("UserId", "" + UserId);
        questionNetworkService.getModulePractice(bodyParameter).enqueue(new Callback<ModulePracticeResponse>() {
            @Override
            public void onResponse(Call<ModulePracticeResponse> call, Response<ModulePracticeResponse> response) {
                try {
                    if (response.body().getStatusNo() == 0) {
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } catch (InterruptedException e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<ModulePracticeResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                }
            }
        });
    }

    @Override
    public void getSyncTime(SyncRequestEntity syncRequestEntity, final IResponseSubcriber iResponseSubcriber) {
        questionNetworkService.getSyncTime(syncRequestEntity).enqueue(new Callback<SyncTimeResponse>() {
            @Override
            public void onResponse(Call<SyncTimeResponse> call,Response<SyncTimeResponse> response) {
                try {
                    if (response.body().getStatusNo() == 0) {
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } catch (InterruptedException e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<SyncTimeResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                }
            }
        });
    }


}

