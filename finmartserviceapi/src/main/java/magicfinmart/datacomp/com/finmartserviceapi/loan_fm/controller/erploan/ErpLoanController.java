package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.erploan;

import android.content.Context;

import com.google.gson.JsonParseException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.R;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberERP;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder.ERPRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.ErpHomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.ErpPersonLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.ERPSaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.HomeLoanApplicationResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.PersonalLoanApplicationResponse;
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
    public void getHomeLoanApplication(String ApplnId, final IResponseSubcriberERP iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<>();
        body.put("ApplnId", ApplnId);

        erpNetworkService.getHomeLoanApplication(body).enqueue(new Callback<HomeLoanApplicationResponse>() {
            @Override
            public void onResponse(Call<HomeLoanApplicationResponse> call, Response<HomeLoanApplicationResponse> response) {
                try {

                    iResponseSubcriber.OnSuccessERP(response.body(),response.body().getMessage());


                } catch (Exception e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<HomeLoanApplicationResponse> call, Throwable t) {
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

    @Override
    public void saveERPHomeLoan(ErpHomeLoanRequest erpLoanRequest, final IResponseSubcriberERP iResponseSubcriber) {

        erpNetworkService.saveErpHomeLoanData(erpLoanRequest).enqueue(new Callback<ERPSaveResponse>() {
            @Override
            public void onResponse(Call<ERPSaveResponse> call, Response<ERPSaveResponse> response) {
                try {

                    iResponseSubcriber.OnSuccessERP(response.body(),response.body().getMessage());


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

    @Override
    public void saveERPLoanAgainstProperty(ErpHomeLoanRequest erpLoanRequest, final IResponseSubcriberERP iResponseSubcriber) {

        erpNetworkService.saveErpHoLoanAgainstPropertyData(erpLoanRequest).enqueue(new Callback<ERPSaveResponse>() {
            @Override
            public void onResponse(Call<ERPSaveResponse> call, Response<ERPSaveResponse> response) {
                try {

                    iResponseSubcriber.OnSuccessERP(response.body(),response.body().getMessage());


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


    //personal

    public void getPersonalLoanApplication(String ApplnId, final IResponseSubcriberERP iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<>();
        body.put("ApplnId", ApplnId);

        erpNetworkService.getPersonalLoanApplication(body).enqueue(new Callback<PersonalLoanApplicationResponse>() {
            @Override
            public void onResponse(Call<PersonalLoanApplicationResponse> call, Response<PersonalLoanApplicationResponse> response) {
                try {

                    iResponseSubcriber.OnSuccessERP(response.body(),response.body().getMessage());


                } catch (Exception e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<PersonalLoanApplicationResponse> call, Throwable t) {
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
    @Override
    public void saveERPPersonalLoan(ErpPersonLoanRequest erpLoanRequest, final IResponseSubcriberERP iResponseSubcriber) {

        erpNetworkService.saveErpPersonalLoanData(erpLoanRequest).enqueue(new Callback<ERPSaveResponse>() {
            @Override
            public void onResponse(Call<ERPSaveResponse> call, Response<ERPSaveResponse> response) {
                try {

                    iResponseSubcriber.OnSuccessERP(response.body(),response.body().getMessage());


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
