package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quicklead;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.creditcard.ICreditCard;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters.AsyncRblCityMaster;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.CreditCardRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.QuickLeadRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.CCICICIRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.CCRblRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.QuickLeadRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.AppliedCreditCardResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CCICICIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CCRblResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CreditCardMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.QuickLeadResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.RblCityMasterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nilesh Birhade on 09/02/2018.
 */

public class QuickLeadController implements IQuickLead {

    QuickLeadRequestBuilder.QuickLeadNetworkService quickLeadNetworkService;
    Context mContext;

    public QuickLeadController(Context context) {
        quickLeadNetworkService = new QuickLeadRequestBuilder().getService();
        mContext = context;
    }


    @Override
    public void saveQuickLead(QuickLeadRequestEntity quickLeadRequestEntity, final IResponseSubcriber iResponseSubcriber) {

        quickLeadNetworkService.getAllCreditCards(quickLeadRequestEntity).enqueue(new Callback<QuickLeadResponse>() {
            @Override
            public void onResponse(Call<QuickLeadResponse> call, Response<QuickLeadResponse> response) {
                if (response.body() != null) {
                    if (response.body().getStatusNo() == 0) {
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException("Unable to save information, Please try again"));
                }
            }

            @Override
            public void onFailure(Call<QuickLeadResponse> call, Throwable t) {

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
