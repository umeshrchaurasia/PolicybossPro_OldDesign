package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.creditcard;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.CreditCardRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CreditCardMasterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nilesh Birhade on 09/02/2018.
 */

public class CreditCardController implements ICreditCard {

    CreditCardRequestBuilder.CreditCardNetworkService creditCardNetworkService;
    Context mContext;

    public CreditCardController(Context context) {
        creditCardNetworkService = new CreditCardRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void getAllCreditCards(final IResponseSubcriber iResponseSubcriber) {

        creditCardNetworkService.getAllCreditCards().enqueue(new Callback<CreditCardMasterResponse>() {
            @Override
            public void onResponse(Call<CreditCardMasterResponse> call, Response<CreditCardMasterResponse> response) {

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
            public void onFailure(Call<CreditCardMasterResponse> call, Throwable t) {

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
