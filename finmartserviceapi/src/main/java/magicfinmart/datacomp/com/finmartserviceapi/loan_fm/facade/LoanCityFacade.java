package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.facade;

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


    private static final String  LoanCity_RESPONSE = "LoanCity_response";


    public LoanCityFacade(Context context) {
        mContext = context;
        sharedPreferences = context.getSharedPreferences(PrefManager.PREF_NAME, 0);
        editor = sharedPreferences.edit();
    }

    public boolean removeLoanCity()
    {
        editor.remove(LoanCity_RESPONSE);

        return editor.commit();
    }
    //region save response

    public boolean saveLoanCity(LoanCityResponse response) {
        Gson gson = new Gson();
        editor.remove(LoanCity_RESPONSE);
        editor.putString(LoanCity_RESPONSE, gson.toJson(response));
        return editor.commit();
    }



    //endregion


    //region city

    public LoanCityResponse getLoanMainCity() {
        if (new Gson().fromJson(sharedPreferences.getString(LoanCity_RESPONSE, "")
                , LoanCityResponse.class) != null) {
            return new Gson().fromJson(sharedPreferences.getString(LoanCity_RESPONSE, ""), LoanCityResponse.class);
        }
        return null;
    }

    public  List<LoanCityEntity> getLoanCity() {

        if (getLoanMainCity() != null) {

            if (getLoanMainCity().getResult().getLstCity() != null)
                return getLoanMainCity().getResult().getLstCity();
            else
                return null;
        }
        return null;
    }





    //endregion


}
