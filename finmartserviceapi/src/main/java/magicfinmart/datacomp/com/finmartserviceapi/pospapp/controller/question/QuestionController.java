package magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.question;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestbuilder.QuestionRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.QuestionResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class QuestionController implements IQuestion {


    QuestionRequestBuilder.QuestionNetworkService questionNetworkService;
    Context mContext;

    public QuestionController(Context context) {
        questionNetworkService = new QuestionRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void getQuestion(int CategoryId, int UserId, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> bodyParameter = new HashMap<String, String>();


        bodyParameter.put("CategoryId", "" + CategoryId);
        bodyParameter.put("UserId", "" + UserId);
        questionNetworkService.getQuestionSet(bodyParameter).enqueue(new Callback<QuestionResponse>() {
            @Override
            public void onResponse(Call<QuestionResponse> call, Response<QuestionResponse> response) {
                try {
                    iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                } catch (InterruptedException e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<QuestionResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                }
            }
        });
    }
}
