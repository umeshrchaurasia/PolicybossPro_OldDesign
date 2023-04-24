package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quoteapplication;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MotorMyLeadEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.QuoteApplicationRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.SaveMotorRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.BOFbaListResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LeadDispositionResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LeadDispositionSaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.MotorLeadResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.MotorViewLeadResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.QuoteAppUpdateDeleteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.QuoteApplicationResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.SaveQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.QuoteApplicationRequestEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nilesh Birhade on 25-01-2018.
 */

public class QuoteApplicationController implements IQuoteApp {

    QuoteApplicationRequestBuilder.QuoteApplicationNetworkService quoteApplicationNetworkService;
    Context mContext;

    public QuoteApplicationController(Context context) {
        mContext = context;
        quoteApplicationNetworkService = new QuoteApplicationRequestBuilder().getService();
    }

    @Override
    public void getQuoteAppList(int count, int type, String firstname, String vehicleReqID, int fbaID, int productID, String crn, final IResponseSubcriber iResponseSubcriber) {

        QuoteApplicationRequestEntity entity = new QuoteApplicationRequestEntity();
        entity.setCount(count);
        entity.setCrn(crn);
        entity.setFba_id(String.valueOf(fbaID));
        entity.setFirst_name(firstname);
        entity.setProduct_id(String.valueOf(productID));
        entity.setType(String.valueOf(type));
        entity.setVehicleRequestID(vehicleReqID);

      /*  HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("VehicleRequestID", vehicleReqID);
        hashMap.put("fba_id", "" + fbaID);
        hashMap.put("product_id", "" + productID);
        hashMap.put("crn", "" + crn);
        hashMap.put("first_name", firstname);
        hashMap.put("count", String.valueOf(count));
        hashMap.put("type", String.valueOf(type));*/


        quoteApplicationNetworkService.getQuoteApplication(entity).enqueue(new Callback<QuoteApplicationResponse>() {
            @Override
            public void onResponse(Call<QuoteApplicationResponse> call, Response<QuoteApplicationResponse> response) {
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
            public void onFailure(Call<QuoteApplicationResponse> call, Throwable t) {
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
    public void saveQuote(SaveMotorRequestEntity entity, final IResponseSubcriber iResponseSubcriber) {

        quoteApplicationNetworkService.saveMotorRequest(entity).enqueue(new Callback<SaveQuoteResponse>() {
            @Override
            public void onResponse(Call<SaveQuoteResponse> call, Response<SaveQuoteResponse> response) {

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
            public void onFailure(Call<SaveQuoteResponse> call, Throwable t) {
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
    public void convertQuoteToApp(String vehicleRequestID, String selectedPrevInsID, String insurerImage, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("VehicleRequestID", vehicleRequestID);
        body.put("selectedPrevInsID", selectedPrevInsID);
        body.put("insImage", insurerImage);

        quoteApplicationNetworkService.quoteToApplication(body).enqueue(new Callback<QuoteAppUpdateDeleteResponse>() {
            @Override
            public void onResponse(Call<QuoteAppUpdateDeleteResponse> call, Response<QuoteAppUpdateDeleteResponse> response) {
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
            public void onFailure(Call<QuoteAppUpdateDeleteResponse> call, Throwable t) {
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
    public void deleteQuote(String vehicleRequestID, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("VehicleRequestID", vehicleRequestID);
        quoteApplicationNetworkService.deleteQuote(body).enqueue(new Callback<QuoteAppUpdateDeleteResponse>() {
            @Override
            public void onResponse(Call<QuoteAppUpdateDeleteResponse> call, Response<QuoteAppUpdateDeleteResponse> response) {
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
            public void onFailure(Call<QuoteAppUpdateDeleteResponse> call, Throwable t) {
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
    public void ModifyLead(MotorMyLeadEntity entity, final IResponseSubcriber iResponseSubcriber) {

        quoteApplicationNetworkService.modifyLead(entity).enqueue(new Callback<MotorLeadResponse>() {
            @Override
            public void onResponse(Call<MotorLeadResponse> call, Response<MotorLeadResponse> response) {

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
            public void onFailure(Call<MotorLeadResponse> call, Throwable t) {
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
    public void ViewLead(String VehicleRequestID, String LeadId, final IResponseSubcriber iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<String, String>();
        body.put("VehicleRequestID", VehicleRequestID);
        body.put("LeadId", LeadId);
        quoteApplicationNetworkService.modifyLeadView(body).enqueue(new Callback<MotorViewLeadResponse>() {
            @Override
            public void onResponse(Call<MotorViewLeadResponse> call, Response<MotorViewLeadResponse> response) {
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
            public void onFailure(Call<MotorViewLeadResponse> call, Throwable t) {
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
    public void EditLead(String VehicleRequestID, String LeadId, final IResponseSubcriber iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<String, String>();
        body.put("VehicleRequestID", VehicleRequestID);
        body.put("LeadId", LeadId);
        quoteApplicationNetworkService.modifyLeadEdit(body).enqueue(new Callback<MotorViewLeadResponse>() {
            @Override
            public void onResponse(Call<MotorViewLeadResponse> call, Response<MotorViewLeadResponse> response) {
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
            public void onFailure(Call<MotorViewLeadResponse> call, Throwable t) {
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
    public void getLeadDispositionMaster(final IResponseSubcriber iResponseSubcriber) {


        quoteApplicationNetworkService.getLeadDispositionMaster().enqueue(new Callback<LeadDispositionResponse>() {
            @Override
            public void onResponse(Call<LeadDispositionResponse> call, Response<LeadDispositionResponse> response) {
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
            public void onFailure(Call<LeadDispositionResponse> call, Throwable t) {
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
    public void saveLeadDisposition(String leadid, String dispositionid, String vehiclerequestid, String comment, final IResponseSubcriber iResponseSubcriber) {


        HashMap<String, String> body = new HashMap<String, String>();
        body.put("leadid", leadid);
        body.put("dispositionid", dispositionid);
        body.put("vehiclerequestid", vehiclerequestid);
        body.put("comment", comment);
        quoteApplicationNetworkService.saveLeadDisposition(body).enqueue(new Callback<LeadDispositionSaveResponse>() {
            @Override
            public void onResponse(Call<LeadDispositionSaveResponse> call, Response<LeadDispositionSaveResponse> response) {
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
            public void onFailure(Call<LeadDispositionSaveResponse> call, Throwable t) {
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
    public void getBOFbaList(String fbaID, String searchKeyWord, final IResponseSubcriber iResponseSubcriber) {

        HashMap<String, String> body = new HashMap<String, String>();
        body.put("fbaid", fbaID);
        body.put("count", "0");
        body.put("search", searchKeyWord);

        quoteApplicationNetworkService.getBOFbaList(body).enqueue(new Callback<BOFbaListResponse>() {
            @Override
            public void onResponse(Call<BOFbaListResponse> call, Response<BOFbaListResponse> response) {

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
            public void onFailure(Call<BOFbaListResponse> call, Throwable t) {

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
