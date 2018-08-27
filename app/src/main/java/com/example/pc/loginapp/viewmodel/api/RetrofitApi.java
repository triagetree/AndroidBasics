package com.example.pc.loginapp.viewmodel.api;

import android.os.Build;

import com.example.pc.loginapp.BuildConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

    //public static final String BASE_URL = "http://hicare.speckyfox.com/api/";
    public static final String BASE_URL = "https://reqres.in";
    public static Retrofit retrofit = null;
    private static OkHttpClient httpClient=null;
    private static APIService apiService=null;

    private static final HttpLoggingInterceptor.Level HTTP_LOGGING_LEVEL = BuildConfig.DEBUG ?
            HttpLoggingInterceptor.Level.BODY : // debug log level
            HttpLoggingInterceptor.Level.NONE;  // release log level

    //Call By Aadi Base Url(Only use in CompanyBaseActivity)
    public static APIService getApiService(){

        if(apiService==null) {
            apiService = getApiClient().create(APIService.class);
        }
        return apiService;

    }

    //****///
    public static Retrofit  getApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHttpClient())
                    .build();
        }
        return retrofit;
    }


    public static OkHttpClient getHttpClient() {
        if (httpClient == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HTTP_LOGGING_LEVEL);
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .connectTimeout(100, TimeUnit.SECONDS);

            httpClient = enableTls12(clientBuilder).build();
        }
        return httpClient;
    }

    /**
     * Enables TLS 1.2 on Pre-Lollipop devices (16 >= Android API < 20)
     * Check: https://github.com/square/okhttp/issues/2372#issuecomment-244807676
     *
     * @param client OkHttpClient.Builder on which to apply the patch
     * @return OkHttpClient.Builder with the patch applied
     */
    private static OkHttpClient.Builder enableTls12(OkHttpClient.Builder client) {
        // the problem sill persists on some samsung devices with API 21, so it's necessary
        // to apply the patch till API 21
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 22) {
            try {
                SSLContext sc = SSLContext.getInstance("TLSv1.2");
                sc.init(null, null, null);
                client.sslSocketFactory(new Tls12SocketFactory(sc.getSocketFactory()));
                ConnectionSpec cs = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                        .tlsVersions(TlsVersion.TLS_1_2)
                        .build();
                List<ConnectionSpec> specs = new ArrayList<>();
                specs.add(cs);
                specs.add(ConnectionSpec.COMPATIBLE_TLS);
                specs.add(ConnectionSpec.CLEARTEXT);

                client.connectionSpecs(specs);
            } catch (Throwable exc) {
                //showLog("OkHttp", "Error while setting TLS 1.2 " + exc);
            }
        }

        return client;
    }
}

