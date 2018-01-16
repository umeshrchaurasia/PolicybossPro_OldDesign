package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.homeloan;


import android.content.Context;

import com.google.gson.JsonParseException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import magicfinmart.datacomp.com.finmartserviceapi.R;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder.HomeloanRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.HomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetQuoteResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Nilesh Birhade on 25-01-2017.
 */

public class HomeLoanController implements IHomeLoan {


    Context mContext;
    HomeloanRequestBuilder.HomeloanNetworkService homeloanNetworkService;

    public HomeLoanController(Context context) {
        this.mContext = context;
        homeloanNetworkService = new HomeloanRequestBuilder().getService();
    }


    @Override
    public void getHomeLoan(HomeLoanRequest homeLoanRequest, final IResponseSubcriber iResponseSubcriber) {

        homeloanNetworkService.getQuotes(homeLoanRequest).enqueue(new Callback<GetQuoteResponse>() {
            @Override
            public void onResponse(Call<GetQuoteResponse> call, Response<GetQuoteResponse> response) {
                try {
                    if (response.body().getStatus_Id() == 0) {
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMsg());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMsg()));
                    }

                } catch (Exception e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<GetQuoteResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(mContext.getResources().getString(R.string.net_connection)));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(mContext.getResources().getString(R.string.net_connection)));
                } else if (t instanceof JsonParseException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Invalid Json"));
                }else{
                    iResponseSubcriber.OnFailure(new RuntimeException("Please Try after sometime.."));
                }
            }
        });
    }
}
