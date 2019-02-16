package magicfinmart.datacomp.com.finmartserviceapi.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HDFCEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.IllustrationRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LICEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakshaIllustrationResponseNew;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakshaRecalculateResponse;

public class UserBehaviourFacade {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context mContext;


    private static final String BLUETOOTH = "bluetooth";
    private static final String WIFI_LIST = "wifi_list";
    private static final String LOCAL_LANGUAGE = "local_language";
    private static final String INSTALL_PACKAGES = "install_packages";

    public UserBehaviourFacade(Context context) {
        mContext = context;
        sharedPreferences = context.getSharedPreferences(PrefManager.PREF_NAME, 0);
        editor = sharedPreferences.edit();
    }

    //region save response

    public boolean saveBluetooth(String response) {
        editor.remove(BLUETOOTH);
        editor.putString(BLUETOOTH, response);
        return editor.commit();
    }


    public boolean saveWifi(String response) {
        editor.remove(WIFI_LIST);
        editor.putString(WIFI_LIST, response);
        return editor.commit();
    }

    public boolean saveLocalLang(String response) {
        editor.remove(LOCAL_LANGUAGE);
        editor.putString(LOCAL_LANGUAGE, response);
        return editor.commit();
    }

    public boolean savePackages(String response) {
        editor.remove(INSTALL_PACKAGES);
        editor.putString(INSTALL_PACKAGES, response);
        return editor.commit();
    }

    //endregion


    //region get All Data

    public String getBluetooth() {
        return sharedPreferences.getString(BLUETOOTH, "");
    }

    public String getPackages() {
        return sharedPreferences.getString(INSTALL_PACKAGES, "");
    }

    public String getLocalLanguage() {
        return sharedPreferences.getString(LOCAL_LANGUAGE, "");
    }

    public String getWifiList() {
        return sharedPreferences.getString(WIFI_LIST, "");
    }

    //endregion
}
