package magicfinmart.datacomp.com.finmartserviceapi.pospapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import magicfinmart.datacomp.com.finmartserviceapi.BuildConfig;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class PospRetroRequestBuilder {

//http://49.50.95.141:97/EducationAppWebService.svc/GetQuestionsByLogin
//protected String basicUrl = "http://49.50.95.141:97";
///EducationAppWebService.svc/GetQuestionsByLogin

    //live url rupeeboss
    //protected String basicUrl = "http://49.50.95.141:97";
   // public final static String secondaryUrl = "/EducationAppWebService.svc";

    //live url policyboss
    //protected String basicUrl = "http://edu.policyboss.com";
    public final static String secondaryUrl = "/eduappservice/EducationAppWebService.svc";


    //uat url
    //protected String basicUrl = "http://49.50.95.141:99";
    //public final static String secondaryUrl = "/EducationAppWebService.svc";

    //uat url
    //protected String basicUrl = "http://uat.oyeraddi.com";
    //public final static String secondaryUrl = "/EducationappUat/EducationAppWebService.svc/";
    static Retrofit restAdapter = null;


    /*protected Retrofit build() {
        if (restAdapter == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient httpClient = new OkHttpClient();
            httpClient.setReadTimeout(90, TimeUnit.SECONDS);
            httpClient.setConnectTimeout(90, TimeUnit.SECONDS);
            httpClient.interceptors().add(logging);
            restAdapter = new Retrofit.Builder()
                    .baseUrl(basicUrl)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return restAdapter;
    }*/

    protected Retrofit build() {
        if (restAdapter == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            okhttp3.OkHttpClient okHttpClient = new okhttp3.OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.MINUTES)
                    .writeTimeout(10, TimeUnit.MINUTES)
                    .readTimeout(10, TimeUnit.MINUTES)
                    .addInterceptor(interceptor)
                    .build();

            restAdapter = new Retrofit.Builder()
                    .baseUrl(BuildConfig.POSP_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }
        return restAdapter;
    }

}