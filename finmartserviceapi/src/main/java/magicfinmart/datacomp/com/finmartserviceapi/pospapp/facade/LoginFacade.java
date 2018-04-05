package magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.LoginEntity;


/**
 * Created by Rajeev Ranjan on 02/02/2017.
 */

public class LoginFacade {
    Context mContext;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public LoginFacade(Context context) {
        mContext = context;
        sharedPreferences = mContext.getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, mContext.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public boolean storeUser(LoginEntity loginEntity) {
        try {
            Gson gson = new Gson();
            editor.remove(Constants.LOGIN_FACADE);

            editor.putString(Constants.LOGIN_FACADE, gson.toJson(loginEntity));

            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean storeUserProfile(String profilePic) {
        try {
            editor.putString(Constants.PROFILE_URL, profilePic);
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getUserProfile() {
        try {
            return sharedPreferences.getString(Constants.PROFILE_URL, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public LoginEntity getUser() {
        String user = sharedPreferences.getString(Constants.LOGIN_FACADE, "");
        Gson gson = new Gson();
        LoginEntity loginEntity = gson.fromJson(user, LoginEntity.class);
        return gson.fromJson(user, LoginEntity.class);
    }

    public boolean clearLoginCache() {
        editor.remove(Constants.LOGIN_FACADE);
        editor.remove(Constants.PROFILE_URL);
        editor.remove(Constants.PROFILE_PIC);
        return editor.commit();
    }


}
