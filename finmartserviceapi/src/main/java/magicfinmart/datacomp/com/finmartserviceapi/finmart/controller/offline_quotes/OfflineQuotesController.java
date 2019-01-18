package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.offline_quotes;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.OfflineQuoteRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.SaveHealthRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.SaveMotorRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CreateQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.DocumentResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineCommonResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineHealthResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineHealthSaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineInputResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineMotorListResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.OfflineQuoteResponse;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rajeev Ranjan on 05/11/2018.
 */

public class OfflineQuotesController implements IOfflineQuote {


    OfflineQuoteRequestBuilder.OfflineQuoteNetworkService offlineQuoteNetworkService;
    Context mContext;
    LoginResponseEntity loginResponseEntity;

    public OfflineQuotesController(Context context) {
        offlineQuoteNetworkService = new OfflineQuoteRequestBuilder().getService();
        mContext = context;
        loginResponseEntity = new DBPersistanceController(mContext).getUserData();
    }

    //region Deprecated

    @Override
    public void getOfflineInput(final IResponseSubcriber iResponseSubcriber) {

        offlineQuoteNetworkService.getOfflineInput().enqueue(new Callback<OfflineInputResponse>() {
            @Override
            public void onResponse(Call<OfflineInputResponse> call, Response<OfflineInputResponse> response) {
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
            public void onFailure(Call<OfflineInputResponse> call, Throwable t) {
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
    public void createQuote(String ProductName, String ProductDiscription, String id, final IResponseSubcriber iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<>();
        body.put("id", id);
        body.put("FBAID", "" + loginResponseEntity.getFBAId());
        body.put("ProductName", ProductName);
        body.put("ProductDiscription", ProductDiscription);

        offlineQuoteNetworkService.createQuote(body).enqueue(new Callback<CreateQuoteResponse>() {
            @Override
            public void onResponse(Call<CreateQuoteResponse> call, Response<CreateQuoteResponse> response) {
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
            public void onFailure(Call<CreateQuoteResponse> call, Throwable t) {
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
    public void uploadDocuments(MultipartBody.Part document, HashMap<String, String> body,
                                final IResponseSubcriber iResponseSubcriber) {
        offlineQuoteNetworkService.uploadDocumentOfflineQuotes(document, body).enqueue(new Callback<DocumentResponse>() {
            @Override
            public void onResponse(Call<DocumentResponse> call, Response<DocumentResponse> response) {
                if (response.body() != null) {
                    if (response.body().getStatusNo() == 0) {
                        //callback of data
                        iResponseSubcriber.OnSuccess(response.body(), "");
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }


                } else {
                    //failure
                    iResponseSubcriber.OnFailure(new RuntimeException("Enable to reach server, Try again later"));
                }
            }

            @Override
            public void onFailure(Call<DocumentResponse> call, Throwable t) {
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
    public void getOfflineQuote(final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> body = new HashMap<>();

        body.put("FBAID", "" + loginResponseEntity.getFBAId());


        offlineQuoteNetworkService.getOfflineQuote(body).enqueue(new Callback<OfflineQuoteResponse>() {
            @Override
            public void onResponse(Call<OfflineQuoteResponse> call, Response<OfflineQuoteResponse> response) {
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
            public void onFailure(Call<OfflineQuoteResponse> call, Throwable t) {
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


    @Override
    public void getOfflineMotorList(String count, final IResponseSubcriber iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<>();
        body.put("count", count);
        body.put("fba_id", "52933");// + loginResponseEntity.getFBAId());

        offlineQuoteNetworkService.getOfflineMotorList(body).enqueue(new Callback<OfflineMotorListResponse>() {
            @Override
            public void onResponse(Call<OfflineMotorListResponse> call, Response<OfflineMotorListResponse> response) {

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
            public void onFailure(Call<OfflineMotorListResponse> call, Throwable t) {

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
    public void saveMotorOffline(SaveMotorRequestEntity entity, final IResponseSubcriber iResponseSubcriber) {

        offlineQuoteNetworkService.saveOfflineMotor(entity).enqueue(new Callback<OfflineCommonResponse>() {
            @Override
            public void onResponse(Call<OfflineCommonResponse> call, Response<OfflineCommonResponse> response) {

                if (response.body() != null) {
                    if (response.body().getStatusNo() == 0) {

                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException("Error.. Please try again later"));
                }

            }

            @Override
            public void onFailure(Call<OfflineCommonResponse> call, Throwable t) {

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
    public void getOfflineHealthList(String fba_id, String count, final IResponseSubcriber iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<>();
        body.put("count", count);
        body.put("fba_id",fba_id);// + loginResponseEntity.getFBAId());

        offlineQuoteNetworkService.getOfflineHealthList(body).enqueue(new Callback<OfflineHealthResponse>() {
            @Override
            public void onResponse(Call<OfflineHealthResponse> call, Response<OfflineHealthResponse> response) {

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
            public void onFailure(Call<OfflineHealthResponse> call, Throwable t) {

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
    public void saveHealthOffline(SaveHealthRequestEntity entity, final IResponseSubcriber iResponseSubcriber) {

        offlineQuoteNetworkService.saveOfflineHealth(entity).enqueue(new Callback<OfflineHealthSaveResponse>() {
            @Override
            public void onResponse(Call<OfflineHealthSaveResponse> call, Response<OfflineHealthSaveResponse> response) {

                if (response.body() != null) {
                    if (response.body().getStatusNo() == 0) {

                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException("Error.. Please try again later"));
                }

            }

            @Override
            public void onFailure(Call<OfflineHealthSaveResponse> call, Throwable t) {

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
