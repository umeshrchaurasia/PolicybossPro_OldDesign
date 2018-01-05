package magicfinmart.datacomp.com.finmartserviceapi;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetroRequestBuilder {

    //protected String url = "http://services.rupeeboss.com/LoginDtls.svc/";
    static Retrofit restAdapter = null;
    // production url
    protected String url = "http://www.rupeeboss.com";

    public final static String SUB_URL = "/api";


    protected Retrofit build() {
        if (restAdapter == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.MINUTES)
                    .writeTimeout(10, TimeUnit.MINUTES)
                    .readTimeout(10, TimeUnit.MINUTES)
                    .addInterceptor(interceptor)
                    .build();

            restAdapter = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }
        return restAdapter;
    }

}