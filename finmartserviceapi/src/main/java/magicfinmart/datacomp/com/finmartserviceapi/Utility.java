package magicfinmart.datacomp.com.finmartserviceapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Nilesh Birhade on 11-01-2018.
 */

public class Utility {
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;
    public static final String SECRET_KEY = "SECRET-ODARQ6JP-9V2Q-7BIM-0NNM-DNRTXRWMRTAL";
    public static final String CLIENT_KEY = "CLIENT-GLF2SRA5-CFIF-4X2T-HC1Z-CXV4ZWQTFQ3T";
    public static final String VERSION_CODE = "2.0";
    public static final String BIKEQUOTE_UNIQUEID = "bike_quote_uniqueid";
    public static final String CARQUOTE_UNIQUEID = "car_quote_uniqueid";
    public static final String QUOTE_COUNTER = "quote_counter";
    public static final String SHARED_PREFERENCE_POLICYBOSS = "shared_finmart";
    public static final String HMLOAN_APPLICATION = "hmLoan_Application_LoanApply";
    public static final String PLLOAN_APPLICATION = "plLoan_Application_LoanApply";
    public static final String BTLOAN_APPLICATION = "btLoan_Application_LoanApply";

    public static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCE_POLICYBOSS, MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getSharedPreferenceEditor(Context context) {
        return getSharedPreference(context).edit();
    }

    public static String getCurrentMobileDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmmss");
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }

    public static MultipartBody.Part getMultipartImage(File file) {
        RequestBody imgBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part imgFile = MultipartBody.Part.createFormData("DocFile", file.getName(), imgBody);
        return imgFile;
    }

    public static MultipartBody.Part getMultipartVideo(File file) {
        RequestBody imgBody = RequestBody.create(MediaType.parse("video/*"), file);
        MultipartBody.Part imgFile = MultipartBody.Part.createFormData("video", file.getName(), imgBody);
        return imgFile;
    }

//    public static HashMap<String, String> getBody(Context context,int FbaID,String DocTyp, String docName, String DocExt) {
//        HashMap<String, String> body = new HashMap<String, String>();
//
//
//        body.put("FBAID", String.valueOf(FbaID) );
//        body.put("DocType",DocTyp);
//        body.put("DocName", docName);
//        body.put("DocExt",DocExt);
//
//        return body;
//    }


    public static HashMap<String, String> getBody(Context context, int FbaID, int DocTyp, String DocName) {
        HashMap<String, String> body = new HashMap<String, String>();


        body.put("FBAID", String.valueOf(FbaID));
        body.put("DocType", String.valueOf(DocTyp));
        body.put("DocName", DocName);


        return body;
    }


    public static File createDirIfNotExists() {
        boolean ret = true;

        File file = new File(Environment.getExternalStorageDirectory(), "/FINMART");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.e("TravellerLog :: ", "Problem creating Image folder");
                ret = false;
            }
        }
        return file;
    }

    public static File createShareDirIfNotExists() {
        boolean ret = true;

        File file = new File(Environment.getExternalStorageDirectory(), "/FINMART/QUOTES");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.e("TravellerLog :: ", "Problem creating Quotes folder");
                ret = false;
            }
        }
        return file;
    }

    public static int checkShareStatus() {
        int temp = 1;
        return temp;
    }
}
