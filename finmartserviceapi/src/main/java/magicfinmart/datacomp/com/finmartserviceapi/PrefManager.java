package magicfinmart.datacomp.com.finmartserviceapi;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.RegisterRequestEntity;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "magic-finmart";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_BIKE_MASTER_UPDATE = "isBikeMasterUpdate";
    private static final String IS_CAR_MASTER_UPDATE = "isCarMasterUpdate";
    private static final String IS_RTO_MASTER_UPDATE = "isRtoMasterUpdate";
    private static final String IS_INSURANCE_MASTER_UPDATE = "isRtoMasterUpdate";
    private static final String IS_DEVICE_TOKEN = "devicetoken";
    private static final String IS_RBL_CITY_MASTER = "isRblCityMaster";

    private static final String IS_ZOHO_MASTER = "iszohomaster";
    private static final String POSP_INFO = "pospinfo";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setIsZohoMaster(boolean isFirstTime) {
        editor.putBoolean(IS_ZOHO_MASTER, isFirstTime);
        editor.commit();
    }

    public boolean getIsZohoMaster() {
        return pref.getBoolean(IS_ZOHO_MASTER, true);
    }

    public void setIsRblCityMaster(boolean isFirstTime) {
        editor.putBoolean(IS_RBL_CITY_MASTER, isFirstTime);
        editor.commit();
    }

    public boolean getIsRblCityMaster() {
        return pref.getBoolean(IS_RBL_CITY_MASTER, true);
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }


    public void setIsCarMasterUpdate(boolean isFirstTime) {
        editor.putBoolean(IS_CAR_MASTER_UPDATE, isFirstTime);
        editor.commit();
    }

    public boolean IsCarMasterUpdate() {
        return pref.getBoolean(IS_CAR_MASTER_UPDATE, true);
    }

    public void setIsBikeMasterUpdate(boolean isFirstTime) {
        editor.putBoolean(IS_BIKE_MASTER_UPDATE, isFirstTime);
        editor.commit();
    }

    public boolean IsBikeMasterUpdate() {
        return pref.getBoolean(IS_BIKE_MASTER_UPDATE, true);
    }


    public void setIsRtoMasterUpdate(boolean isFirstTime) {
        editor.putBoolean(IS_RTO_MASTER_UPDATE, isFirstTime);
        editor.commit();
    }

    public boolean IsRtoMasterUpdate() {
        return pref.getBoolean(IS_RTO_MASTER_UPDATE, true);
    }

    public void setIsInsuranceMasterUpdate(boolean isFirstTime) {
        editor.putBoolean(IS_INSURANCE_MASTER_UPDATE, isFirstTime);
        editor.commit();
    }

    public boolean IsInsuranceMasterUpdate() {
        return pref.getBoolean(IS_INSURANCE_MASTER_UPDATE, true);
    }

    public void setToken(String token) {

        editor.putString(IS_DEVICE_TOKEN, token);
        editor.commit();
    }

    public String  getToken()
    {
        return pref.getString(IS_DEVICE_TOKEN,"");
    }
    public boolean setPospInformation(RegisterRequestEntity registerRequestEntity) {
        try {
            Gson gson = new Gson();
            editor.putString(POSP_INFO, gson.toJson(registerRequestEntity));
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public RegisterRequestEntity getPospInformation() {
        String user = pref.getString(POSP_INFO, "");
        Gson gson = new Gson();
        RegisterRequestEntity registerRequestEntity = gson.fromJson(user, RegisterRequestEntity.class);
        if (registerRequestEntity != null)
            return registerRequestEntity;
        else
            return null;
    }

    public void deletePospInfo(){
        pref.edit().remove(POSP_INFO).commit();
    };


}