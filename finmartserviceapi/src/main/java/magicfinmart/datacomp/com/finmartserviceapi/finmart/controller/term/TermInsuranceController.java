package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.term;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.TermRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TermCompareQuoteResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nilesh Birhade on 09/02/2018.
 */

public class TermInsuranceController implements ITermInsurance {
    TermRequestBuilder.TermNetworkService termNetworkService;
    Context mContext;

    public TermInsuranceController(Context context) {
        termNetworkService = new TermRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void getTermQuoteApplicationList(int insurerID, IResponseSubcriber iResponseSubcriber) {

    }

    @Override
    public void getTermInsurer(TermFinmartRequest entity, final IResponseSubcriber iResponseSubcriber) {
        termNetworkService.getTermCompareQuotes(entity).enqueue(new Callback<TermCompareQuoteResponse>() {
            @Override
            public void onResponse(Call<TermCompareQuoteResponse> call, Response<TermCompareQuoteResponse> response) {

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
            public void onFailure(Call<TermCompareQuoteResponse> call, Throwable t) {
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
