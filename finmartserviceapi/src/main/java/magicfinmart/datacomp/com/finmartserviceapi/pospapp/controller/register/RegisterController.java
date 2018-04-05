package magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.register;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestbuilder.RegisterRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.RegisterRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.RegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class RegisterController implements IRegister {


    RegisterRequestBuilder.RegisterNetworkService registerNetworkService;
    Context mContext;

    public RegisterController(Context context) {
        registerNetworkService = new RegisterRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void register(RegisterRequestEntity registerRequestEntity, final IResponseSubcriber iResponseSubcriber) {
        registerNetworkService.register(registerRequestEntity).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
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
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
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
