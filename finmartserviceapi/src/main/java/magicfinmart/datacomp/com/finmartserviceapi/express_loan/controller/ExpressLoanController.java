package magicfinmart.datacomp.com.finmartserviceapi.express_loan.controller;


import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.express_loan.requestbuilder.ExpressLoanRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.requestentity.HdfcPers_SaveRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.requestentity.SaveExpressLoanRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.ExpressLoanListResponse;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.ExpressQuoteListResponse;

import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.ExpressSaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.HdfcPers_SaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by IN-RB on 03-04-2018.
 */

public class ExpressLoanController implements IExpressLoan {


    ExpressLoanRequestBuilder.ExpressNetworkService expressNetworkService;
    Context mContext;

    public ExpressLoanController(Context context) {
        expressNetworkService = new ExpressLoanRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void getExpressQuoteList(String FBAID, final IResponseSubcriber iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<>();
        body.put("FBAID",FBAID);

        expressNetworkService.getExpressQuoteList(body).enqueue(new Callback<ExpressQuoteListResponse>() {
            @Override
            public void onResponse(Call<ExpressQuoteListResponse> call, Response<ExpressQuoteListResponse> response) {
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
            public void onFailure(Call<ExpressQuoteListResponse> call, Throwable t) {
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
    public void getExpressLoanList( final IResponseSubcriber iResponseSubcriber) {

        expressNetworkService.getExpressLoanList().enqueue(new Callback<ExpressLoanListResponse>() {
            @Override
            public void onResponse(Call<ExpressLoanListResponse> call, Response<ExpressLoanListResponse> response) {
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
            public void onFailure(Call<ExpressLoanListResponse> call, Throwable t) {
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
    public void saveExpressLoan(SaveExpressLoanRequestEntity saveExpressLoanRequestEntity, final IResponseSubcriber iResponseSubcriber) {

        expressNetworkService.saveExpressLoan(saveExpressLoanRequestEntity).enqueue(new Callback<ExpressSaveResponse>() {
            @Override
            public void onResponse(Call<ExpressSaveResponse> call, Response<ExpressSaveResponse> response) {
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
            public void onFailure(Call<ExpressSaveResponse> call, Throwable t) {
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
    public void saveHDFCPersonalLoan(HdfcPers_SaveRequestEntity hdfcPers_SaveRequestEntity, final IResponseSubcriber iResponseSubcriber) {

        expressNetworkService.saveHDFCPersonalLoan(hdfcPers_SaveRequestEntity).enqueue(new Callback<HdfcPers_SaveResponse>() {
            @Override
            public void onResponse(Call<HdfcPers_SaveResponse> call, Response<HdfcPers_SaveResponse> response) {
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
            public void onFailure(Call<HdfcPers_SaveResponse> call, Throwable t) {
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
