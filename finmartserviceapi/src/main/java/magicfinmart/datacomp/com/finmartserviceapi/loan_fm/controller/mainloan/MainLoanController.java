package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.mainloan;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;


import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder.LoanMainRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmHomelLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmPersonalLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmSaveQuoteHomeLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.FmSaveQuotePersonalLoanResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by IN-RB on 31-01-2018.
 */

public class MainLoanController implements IMainLoan {

    LoanMainRequestBuilder.LoanMainNetworkService loanMainNetworkService;
    Context mContext;


    public MainLoanController(Context mContext) {
        loanMainNetworkService = new LoanMainRequestBuilder().getService();
        this.mContext = mContext;
    }

    // region Home Loan
    @Override
    public void getHLQuoteApplicationData(String fbaid, String type, final IResponseSubcriberFM iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<>();
        body.put("fbaid", fbaid);
        body.put("type", type);
        loanMainNetworkService.getHLQuoteApplication(body).enqueue(new Callback<FmHomelLoanResponse>() {
            @Override
            public void onResponse(Call<FmHomelLoanResponse> call, Response<FmHomelLoanResponse> response) {
                if (response.body() != null) {

                    //callback of data
                    iResponseSubcriber.OnSuccessFM(response.body(), "");

                } else {
                    //failure
                    iResponseSubcriber.OnFailure(new RuntimeException("Enable to reach server, Try again later"));
                }
            }

            @Override
            public void onFailure(Call<FmHomelLoanResponse> call, Throwable t) {
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
    public void saveHLQuoteData(FmHomeLoanRequest fmHomeLoanRequest,final IResponseSubcriberFM iResponseSubcriber) {

        loanMainNetworkService.saveHLQuote(fmHomeLoanRequest).enqueue(new Callback<FmSaveQuoteHomeLoanResponse>() {
            @Override
            public void onResponse(Call<FmSaveQuoteHomeLoanResponse> call, Response<FmSaveQuoteHomeLoanResponse> response) {
                if (response.body() != null) {

                    //callback of data
                    iResponseSubcriber.OnSuccessFM(response.body(), "");

                } else {
                    //failure
                    iResponseSubcriber.OnFailure(new RuntimeException("Enable to reach server, Try again later"));
                }

            }

            @Override
            public void onFailure(Call<FmSaveQuoteHomeLoanResponse> call, Throwable t) {
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
   //endregion

    // region Personal Loan
    @Override
    public void savePLQuoteData(FmPersonalLoanRequest fmPersonalLoanRequest, final IResponseSubcriberFM iResponseSubcriber) {

        loanMainNetworkService.savePLQuote(fmPersonalLoanRequest).enqueue(new Callback<FmSaveQuotePersonalLoanResponse>() {
            @Override
            public void onResponse(Call<FmSaveQuotePersonalLoanResponse> call, Response<FmSaveQuotePersonalLoanResponse> response) {
                if (response.body() != null) {

                    //callback of data
                    iResponseSubcriber.OnSuccessFM(response.body(), "");

                } else {
                    //failure
                    iResponseSubcriber.OnFailure(new RuntimeException("Enable to reach server, Try again later"));
                }

            }

            @Override
            public void onFailure(Call<FmSaveQuotePersonalLoanResponse> call, Throwable t) {
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
    public void getPLQuoteApplication(String fbaid, final IResponseSubcriberFM iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<>();
        body.put("FBA_id", fbaid);

        loanMainNetworkService.getPLQuoteApplication(body).enqueue(new Callback<FmPersonalLoanResponse>() {
            @Override
            public void onResponse(Call<FmPersonalLoanResponse> call, Response<FmPersonalLoanResponse> response) {
                if (response.body() != null) {

                    //callback of data
                    iResponseSubcriber.OnSuccessFM(response.body(), "");

                } else {
                    //failure
                    iResponseSubcriber.OnFailure(new RuntimeException("Enable to reach server, Try again later"));
                }
            }

            @Override
            public void onFailure(Call<FmPersonalLoanResponse> call, Throwable t) {
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



    //endregion
}

