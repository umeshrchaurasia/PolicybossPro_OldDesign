package magicfinmart.datacomp.com.finmartserviceapi;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Nilesh Birhade on 11-01-2018.
 */

public class Utility {
    public static final String SECRET_KEY = "SECRET-ODARQ6JP-9V2Q-7BIM-0NNM-DNRTXRWMRTAL";
    public static final String CLIENT_KEY = "CLIENT-GLF2SRA5-CFIF-4X2T-HC1Z-CXV4ZWQTFQ3T";
    public static final String VERSION_CODE = "2.0";
    public static final String BIKEQUOTE_UNIQUEID = "bike_quote_uniqueid";
    public static final String CARQUOTE_UNIQUEID = "car_quote_uniqueid";
    public static final String QUOTE_COUNTER = "quote_counter";

    public static final String SHARED_PREFERENCE_POLICYBOSS = "shared_finmart";

    public static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCE_POLICYBOSS, MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getSharedPreferenceEditor(Context context) {
        return getSharedPreference(context).edit();
    }
}
