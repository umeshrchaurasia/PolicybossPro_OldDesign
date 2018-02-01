package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.personalloan;

import android.content.Context;

import com.google.gson.JsonParseException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.R;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberBL;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestbuilder.PersonalloanRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BLLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.BLDispalyResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.GetPersonalLoanResponse;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.PersonalQuoteAppDispalyResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by IN-RB on 15-01-2018.
 */

public class PersonalLoanController  implements IPersonalLoan {

    Context mContext;
    PersonalloanRequestBuilder.PersonalloanNetworkService personalloanNetworkService;

    public PersonalLoanController(Context context) {
        this.mContext = context;
        personalloanNetworkService = new PersonalloanRequestBuilder().getService();
    }

    @Override
    public void getPersonalLoan(PersonalLoanRequest personalLoanRequest, final IResponseSubcriber iResponseSubcriber) {

        personalloanNetworkService.getPersonalQuotes(personalLoanRequest).enqueue(new Callback<GetPersonalLoanResponse>() {
            @Override
            public void onResponse(Call<GetPersonalLoanResponse> call, Response<GetPersonalLoanResponse> response) {
                if (response.body().getStatus_Id() == 0) {
                    iResponseSubcriber.OnSuccess(response.body(), response.body().getMsg());
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMsg()));
                }

            }

            @Override
            public void onFailure(Call<GetPersonalLoanResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(mContext.getResources().getString(R.string.net_connection)));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(mContext.getResources().getString(R.string.net_connection)));
                } else if (t instanceof JsonParseException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Invalid Json"));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException("Please Try after sometime.."));
                }
            }
        });
    }

    @Override
    public void getPersonalQuote(int ProductId, String BrokerID,String EmpCode, final IResponseSubcriber iResponseSubcriber) {

        HashMap<String, String> bodyParameter = new HashMap<String, String>();
        if (BrokerID.matches("0") || BrokerID.matches(""))
            BrokerID = "-1";
        bodyParameter.put("BrokerId", BrokerID);
        bodyParameter.put("flag", "RBAPP");
        bodyParameter.put("empcode",EmpCode);
        bodyParameter.put("ProductId", "" + ProductId);

        personalloanNetworkService.getPersonalBrokerQuotes(bodyParameter).enqueue(new Callback<PersonalQuoteAppDispalyResponse>() {
            @Override
            public void onResponse(Call<PersonalQuoteAppDispalyResponse> call, Response<PersonalQuoteAppDispalyResponse> response) {

                if (response.body().getStatus_Id() == 0) {
                    iResponseSubcriber.OnSuccess(response.body(), response.body().getMsg());
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMsg()));
                }
            }

            @Override
            public void onFailure(Call<PersonalQuoteAppDispalyResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(mContext.getResources().getString(R.string.net_connection)));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(mContext.getResources().getString(R.string.net_connection)));
                } else if (t instanceof JsonParseException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Invalid Json"));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException("Please Try after sometime.."));
                }
            }
        });


    }


    @Override
    public void getBLQuote(BLLoanRequest bLLoanRequest, final IResponseSubcriberBL iResponseSubcriber) {

        personalloanNetworkService.getBLDispalyResponseQuotes(bLLoanRequest).enqueue(new Callback<BLDispalyResponse>() {
            @Override
            public void onResponse(Call<BLDispalyResponse> call, Response<BLDispalyResponse> response) {
                if (response.body().getStatus() == 1) {
                    iResponseSubcriber.OnSuccess(response.body(), "Saved");
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException("Record Not Found"));
                }

            }

            @Override
            public void onFailure(Call<BLDispalyResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(mContext.getResources().getString(R.string.net_connection)));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(mContext.getResources().getString(R.string.net_connection)));
                } else if (t instanceof JsonParseException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Invalid Json"));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException("Please Try after sometime.."));
                }
            }
        });
    }
}
