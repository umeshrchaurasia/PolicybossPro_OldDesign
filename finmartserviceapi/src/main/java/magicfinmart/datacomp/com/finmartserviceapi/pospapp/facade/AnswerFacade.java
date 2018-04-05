package magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.SubmitRequestEntity;


/**
 * Created by Rajeev Ranjan on 04/04/2017.
 */

public class AnswerFacade {
    Context mContext;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public AnswerFacade(Context context) {
        mContext = context;
        sharedPreferences = mContext.getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, mContext.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public boolean storeAnswers(SubmitRequestEntity submitRequestEntity) {
        try {
            Gson gson = new Gson();
            editor.putString(Constants.QUESTION_FACADE, gson.toJson(submitRequestEntity));
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public SubmitRequestEntity getAnswer() {
        String answer = sharedPreferences.getString(Constants.QUESTION_FACADE, "");
        Gson gson = new Gson();
        SubmitRequestEntity submitRequestEntity = gson.fromJson(answer, SubmitRequestEntity.class);
        return gson.fromJson(answer, SubmitRequestEntity.class);
    }

    public boolean clearQuestionCache() {
        editor.remove(Constants.QUESTION_FACADE);
        return editor.commit();
    }


}
