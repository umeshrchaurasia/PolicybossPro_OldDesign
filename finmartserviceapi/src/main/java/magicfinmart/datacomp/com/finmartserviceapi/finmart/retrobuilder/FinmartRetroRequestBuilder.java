package magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rajeev Ranjan on 22/01/2018.
 */

public class FinmartRetroRequestBuilder {

    //protected String url = "http://services.rupeeboss.com/LoginDtls.svc/";
    static Retrofit restAdapter = null;
    // production url
    public static String URL = "http://api.magicfinmart.com";
    // Test Environment url
    //public static String URL = "http://qa.mgfm.in";
    public static final String token ="1234567890";


    protected Retrofit build() {
        if (restAdapter == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            Gson gson = new GsonBuilder()
                    .serializeNulls()
                    // .setLenient()
                    .create();

            okhttp3.OkHttpClient okHttpClient = new okhttp3.OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.MINUTES)
                    .writeTimeout(10, TimeUnit.MINUTES)
                    .readTimeout(10, TimeUnit.MINUTES)
                    .addInterceptor(interceptor)
                    .build();

            restAdapter = new Retrofit.Builder()
                    .baseUrl(URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }
        return restAdapter;
    }

}
