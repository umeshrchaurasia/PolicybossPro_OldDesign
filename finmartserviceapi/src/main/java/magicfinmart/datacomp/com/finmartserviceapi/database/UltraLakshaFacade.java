package magicfinmart.datacomp.com.finmartserviceapi.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HDFCEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LICEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakshaRecalculateResponse;

public class UltraLakshaFacade {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context mContext;


    private static final String ULTRA_LAKSHA_RESPONSE = "ultra_laksha_response";

    public UltraLakshaFacade(Context context) {
        mContext = context;
        sharedPreferences = context.getSharedPreferences(PrefManager.PREF_NAME, 0);
        editor = sharedPreferences.edit();
    }

    public boolean saveRecalculateUltraLaksha(UltraLakshaRecalculateResponse response) {
        Gson gson = new Gson();
        editor.remove(ULTRA_LAKSHA_RESPONSE);
        editor.putString(ULTRA_LAKSHA_RESPONSE, gson.toJson(response));
        return editor.commit();
    }

    public UltraLakshaRecalculateResponse getUltraLaksha() {
        if (new Gson().fromJson(sharedPreferences.getString(ULTRA_LAKSHA_RESPONSE, "")
                , UltraLakshaRecalculateResponse.class) != null) {
            return new Gson().fromJson(sharedPreferences.getString(ULTRA_LAKSHA_RESPONSE, ""), UltraLakshaRecalculateResponse.class);
        }
        return null;
    }

    public HDFCEntity getUltraLakshaHDFC() {

        if (getUltraLaksha() != null) {

            if (getUltraLaksha().getMasterData().getHDFC() != null)
                return getUltraLaksha().getMasterData().getHDFC().get(0);
            else
                return null;
        }
        return null;
    }

    public LICEntity getUltraLakshaLIC() {

        if (getUltraLaksha() != null) {

            if (getUltraLaksha().getMasterData().getLIC() != null)
                return getUltraLaksha().getMasterData().getLIC().get(0);
            else
                return null;
        }
        return null;
    }
}
