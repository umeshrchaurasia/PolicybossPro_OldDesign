package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.zoho;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.BuildConfig;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.ZohoRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.CreateTicketrequest;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CommonWebDocResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CreateTicketResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.DocumentResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.RaiseTicketCommentResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.RaiseTicketViewResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.RaiseTicketWebDocResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TicketCategoryResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.TicketListResponse;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rajeev Ranjan on 01/03/2018.
 */

public class ZohoController implements IZoho {



    ZohoRequestBuilder.ZohoNetworkService zohoNetworkService;

    Context mContext;

    public ZohoController(Context context) {
        mContext = context;
        zohoNetworkService = new ZohoRequestBuilder().getService();

    }

    @Override
    public void getTicketCategories(final IResponseSubcriber iResponseSubcriber) {
        zohoNetworkService.getTicketCategories().enqueue(new Callback<TicketCategoryResponse>() {
            @Override
            public void onResponse(Call<TicketCategoryResponse> call, Response<TicketCategoryResponse> response) {
                if (response.body() != null) {

                    //callback of data
                    if (response.body().getStatusNo() == 0) {
                        new AsyncZohoMaster(mContext, response.body().getMasterData()).execute();
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException("" + response.body().getMessage()));
                    }


                } else {
                    //failure
                    iResponseSubcriber.OnFailure(new RuntimeException("Enable to reach server, Try again later"));
                }
            }

            @Override
            public void onFailure(Call<TicketCategoryResponse> call, Throwable t) {
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
    public void createTicket(CreateTicketrequest createTicketrequest, final IResponseSubcriber iResponseSubcriber) {
        zohoNetworkService.createTicket(createTicketrequest).enqueue(new Callback<CreateTicketResponse>() {
            @Override
            public void onResponse(Call<CreateTicketResponse> call, Response<CreateTicketResponse> response) {
                if (response.body() != null) {

                    //callback of data
                    if (response.body().getStatusNo() == 0) {
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException("" + response.body().getMessage()));
                    }


                } else {
                    //failure
                    iResponseSubcriber.OnFailure(new RuntimeException("Enable to reach server, Try again later"));
                }
            }

            @Override
            public void onFailure(Call<CreateTicketResponse> call, Throwable t) {
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
    public void getListOfTickets(String fbaid, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("fbaid", fbaid);
        zohoNetworkService.getListOfTickets(body).enqueue(new Callback<TicketListResponse>() {
            @Override
            public void onResponse(Call<TicketListResponse> call, Response<TicketListResponse> response) {
                if (response.body() != null) {

                    //callback of data
                    if (response.body().getStatusNo() == 0) {
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException("" + response.body().getMessage()));
                    }


                } else {
                    //failure
                    iResponseSubcriber.OnFailure(new RuntimeException("Enable to reach server, Try again later"));
                }
            }

            @Override
            public void onFailure(Call<TicketListResponse> call, Throwable t) {
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
    public void uploadDocuments(MultipartBody.Part document, HashMap<String, String> body, final IResponseSubcriber iResponseSubcriber) {

        zohoNetworkService.uploadDocumentRaiseTicket(document, body).enqueue(new Callback<DocumentResponse>() {
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
    public void viewCommentOfTickets(String ticket_req_id, final IResponseSubcriber iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<String, String>();
        body.put("ticket_req_id", ticket_req_id);
        zohoNetworkService.viewTicket(body).enqueue(new Callback<RaiseTicketViewResponse>() {
            @Override
            public void onResponse(Call<RaiseTicketViewResponse> call, Response<RaiseTicketViewResponse> response) {
                if (response.body() != null) {

                    //callback of data
                    if (response.body().getStatusNo() == 0) {
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException("" + response.body().getMessage()));
                    }


                } else {
                    //failure
                    iResponseSubcriber.OnFailure(new RuntimeException("Enable to reach server, Try again later"));
                }
            }

            @Override
            public void onFailure(Call<RaiseTicketViewResponse> call, Throwable t) {
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
    public void saveCommentOfTickets(String ticket_req_id, String comment, String docpath, String statusId, final IResponseSubcriber iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<String, String>();
        body.put("ticket_req_id", ticket_req_id);
        body.put("comment", comment);
        body.put("docpath", docpath);
        body.put("ticket_status_id", statusId);
        zohoNetworkService.saveTicketComment(body).enqueue(new Callback<RaiseTicketCommentResponse>() {
            @Override
            public void onResponse(Call<RaiseTicketCommentResponse> call, Response<RaiseTicketCommentResponse> response) {
                if (response.body() != null) {

                    //callback of data
                    if (response.body().getStatusNo() == 0) {
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException("" + response.body().getMessage()));
                    }


                } else {
                    //failure
                    iResponseSubcriber.OnFailure(new RuntimeException("Enable to reach server, Try again later"));
                }
            }

            @Override
            public void onFailure(Call<RaiseTicketCommentResponse> call, Throwable t) {
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
    public void uploadRaiseTicketDocWeb(MultipartBody.Part document, final IResponseSubcriber iResponseSubcriber) {

        String url = BuildConfig.NODE_URL + "/mobile_raiseticket_doc";
        zohoNetworkService.uploadDocumentRaiseTicketWeb(url,document).enqueue(new Callback<RaiseTicketWebDocResponse>() {
            @Override
            public void onResponse(Call<RaiseTicketWebDocResponse> call, Response<RaiseTicketWebDocResponse> response) {
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
            public void onFailure(Call<RaiseTicketWebDocResponse> call, Throwable t) {
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
    public void uploadCommonDocuments(MultipartBody.Part document, HashMap<String, String> body, final IResponseSubcriber iResponseSubcriber) {

       // String url = BuildConfig.NODE_URL + "/policyboss_upload_doc";
        String url = "https://horizon.policyboss.com:5443/postservicecall/policyboss_upload_doc";

        zohoNetworkService.uploadCommonDocumentWeb(url , document, body).enqueue(new Callback<CommonWebDocResponse>() {
            @Override
            public void onResponse(Call<CommonWebDocResponse> call, Response<CommonWebDocResponse> response) {
                if (response.body() != null) {
                    if (response.body().getStatus().equals("Success")) {
                        //callback of data
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMsg());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMsg()));
                    }


                } else {
                    //failure
                    iResponseSubcriber.OnFailure(new RuntimeException("Enable to reach server, Try again later"));
                }
            }

            @Override
            public void onFailure(Call<CommonWebDocResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Server Error"));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Server Errorn"));
                } else if (t instanceof NumberFormatException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Unexpected server response"));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                }
            }
        });
    }
}
