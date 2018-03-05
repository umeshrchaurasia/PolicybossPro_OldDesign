package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.erploan;

import android.content.Context;

import com.google.gson.JsonParseException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import magicfinmart.datacomp.com.finmartserviceapi.R;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberERP;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder.ERPRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder.HomeloanRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.ErpLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.HomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.ERPSaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetQuoteResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by IN-RB on 04-03-2018.
 */

public class ErpLoanController implements IErpLoan {

    Context mContext;
    ERPRequestBuilder.ERPNetworkService erpNetworkService;

    public ErpLoanController(Context context) {
        this.mContext = context;
        erpNetworkService = new ERPRequestBuilder().getService();
    }


    @Override
    public void saveERPLoan(ErpLoanRequest erpLoanRequest, final IResponseSubcriberERP iResponseSubcriber) {

        erpNetworkService.saveErpLoanData(erpLoanRequest).enqueue(new Callback<ERPSaveResponse>() {
            @Override
            public void onResponse(Call<ERPSaveResponse> call, Response<ERPSaveResponse> response) {
                try {
                    if (response.body().getStatusId() == 0) {
                      //  iResponseSubcriber.OnSuccess(response.body(), response.body().getMsg());
                        iResponseSubcriber.OnSuccessERP(response.body(),response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }

                } catch (Exception e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<ERPSaveResponse> call, Throwable t) {
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
