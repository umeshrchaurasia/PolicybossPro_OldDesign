package magicfinmart.datacomp.com.finmartserviceapi;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MpsDataEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.RegisterRequestEntity;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "magic-finmart";
    private static final String MOTOR_VERSION = "motor_master_version";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_BIKE_MASTER_UPDATE = "isBikeMasterUpdate";
    private static final String IS_CAR_MASTER_UPDATE = "isCarMasterUpdate";
    private static final String IS_RTO_MASTER_UPDATE = "isRtoMasterUpdate";
    private static final String IS_INSURANCE_MASTER_UPDATE = "isRtoMasterUpdate";
    private static final String IS_DEVICE_TOKEN = "devicetoken";
    private static final String IS_RBL_CITY_MASTER = "isRblCityMaster";
    private static final String IS_EMPLOYER_NAME_MASTER = "employernamemaster";

    private static final String IS_ZOHO_MASTER = "iszohomaster";
    private static final String POSP_INFO = "pospinfo";
    private static final String IS_UPDATE_SHOWN = "updateshown";

    public static String PUSH_VERIFY_LOGIN = "push_verify_login";
    public static String NOTIFICATION_COUNTER = "Notification_Counter";
    public static String SHARED_KEY_PUSH_NOTIFY = "shared_notifyFlag";
    public static String SHARED_KEY_PUSH_WEB_URL = "shared_notify_webUrl";
    public static String SHARED_KEY_PUSH_WEB_TITLE = "shared_notify_webTitle";

    public static String MPS_DATA = "mps_data";


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    //region MPS

    public boolean setMPS(MpsDataEntity mpsDataEntity) {
        Gson gson = new Gson();
        editor.putString(MPS_DATA, gson.toJson(mpsDataEntity));
        return editor.commit();
    }

    public MpsDataEntity getMps() {
        Gson gson = new Gson();
        if (gson.fromJson(pref.getString(MPS_DATA, ""), MpsDataEntity.class) != null)
            return gson.fromJson(pref.getString(MPS_DATA, ""), MpsDataEntity.class);
        else
            return null;
    }

    public boolean removeMps() {
        editor.remove(MPS_DATA);
        return editor.commit();
    }

    //endregion

    public void setIsUpdateShown(boolean isFirstTime) {
        editor.putBoolean(IS_UPDATE_SHOWN, isFirstTime);
        editor.commit();
    }

    public boolean getUpdateShown() {
        return pref.getBoolean(IS_UPDATE_SHOWN, true);
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


    public void setIsEmployerNAmeUpdate(boolean isFirstTime) {
        editor.putBoolean(IS_EMPLOYER_NAME_MASTER, isFirstTime);
        editor.commit();
    }

    public boolean IsEmployerNAmeUpdate() {
        return pref.getBoolean(IS_EMPLOYER_NAME_MASTER, true);
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

    public String getToken() {
        return pref.getString(IS_DEVICE_TOKEN, "");
    }

    public int getNotificationCounter() {
        return pref.getInt(NOTIFICATION_COUNTER, 0);
    }

    public void setNotificationCounter(int counter) {
        editor.putInt(NOTIFICATION_COUNTER, counter);
        editor.commit();
    }


    public void setIsUserLogin(boolean isUserLogin) {
        editor.putBoolean(PUSH_VERIFY_LOGIN, isUserLogin);
        editor.commit();
    }

    public boolean getIsUserLogin() {
        return pref.getBoolean(PUSH_VERIFY_LOGIN, false);
    }

    public void setSharePushType(String type) {

        editor.putString(SHARED_KEY_PUSH_NOTIFY, type);
        editor.commit();
    }

    public String getSharePushType() {
        return pref.getString(SHARED_KEY_PUSH_NOTIFY, "");
    }


    public String getSharePushWebURL() {
        return pref.getString(SHARED_KEY_PUSH_WEB_URL, "");
    }

    public void setSharePushWebURL(String url) {

        editor.putString(SHARED_KEY_PUSH_WEB_URL, url);
        editor.commit();
    }

    public String getSharePushWebTitle() {
        return pref.getString(SHARED_KEY_PUSH_WEB_TITLE, "");
    }

    public void setSharePushWebTitle(String webtite) {

        editor.putString(SHARED_KEY_PUSH_WEB_TITLE, webtite);
        editor.commit();
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

    public void deletePospInfo() {
        pref.edit().remove(POSP_INFO).commit();
    }

    public void clearNotification() {
        pref.edit().remove(SHARED_KEY_PUSH_NOTIFY)
                .remove(SHARED_KEY_PUSH_WEB_URL)
                .remove(SHARED_KEY_PUSH_WEB_TITLE).commit();

    }

    // region delete Share Data

    public void clearAll() {
        pref.edit().remove(POSP_INFO)
                .remove(SHARED_KEY_PUSH_NOTIFY)
                .remove(SHARED_KEY_PUSH_WEB_URL)
                .remove(SHARED_KEY_PUSH_WEB_TITLE).commit();

    }

    //endregion

    //region clear Motor Master data
    public boolean updateMotorVersion(String MotorVersion) {
        pref.edit().remove(MOTOR_VERSION).commit();
        return pref.edit().putString(MOTOR_VERSION, MotorVersion).commit();
    }

    public String getMotorVersion() {
        return pref.getString(MOTOR_VERSION, "0");
    }

    //endregion

    //region clear Motor Master data

    public void clearMotorMaster() {
        pref.edit().remove(IS_CAR_MASTER_UPDATE)
                .remove(IS_BIKE_MASTER_UPDATE).commit();
    }
    //endregion

}