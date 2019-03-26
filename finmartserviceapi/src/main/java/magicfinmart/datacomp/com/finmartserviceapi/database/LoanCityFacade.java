package magicfinmart.datacomp.com.finmartserviceapi.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.LoanCityEntity;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.LoanCityResponse;

public class LoanCityFacade {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context mContext;


    private static final String LOAN_CITY_RESPONSE = "loan_city_response";


    public LoanCityFacade(Context context) {
        mContext = context;
        sharedPreferences = context.getSharedPreferences(PrefManager.PREF_NAME, 0);
        editor = sharedPreferences.edit();
    }

    public boolean removeLoanCity() {
        editor.remove(LOAN_CITY_RESPONSE);
        return editor.commit();
    }
    //region save response

    public boolean saveLoanCity(LoanCityResponse response) {
        Gson gson = new Gson();
        removeLoanCity();
        editor.putString(LOAN_CITY_RESPONSE, gson.toJson(response));
        return editor.commit();
    }


    //endregion


    //region city

    public LoanCityResponse getLoanMainCity() {

        String strJson = sharedPreferences.getString(LOAN_CITY_RESPONSE, "");
        LoanCityResponse response = new Gson().fromJson(strJson, LoanCityResponse.class);
        if (response != null) {
            return response;
        }
        return null;
    }

    public List<LoanCityEntity> getLoanCity() {
        LoanCityResponse response = getLoanMainCity();
        if (response != null) {
            return response.getResult().getLstCity();
        }
        return null;
    }


    //endregion


}
