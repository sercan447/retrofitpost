package sercandevops.com.webservispost.RestApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {

    private RestApi mRestApi;


    public RestApiClient(String restApiServiceUrl){

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
               // .retryOnConnectionFailure(true)
                .connectTimeout(3L, TimeUnit.SECONDS)
                .writeTimeout(3L, TimeUnit.SECONDS)
                .readTimeout(3L, TimeUnit.SECONDS);

        OkHttpClient okHttpClient = builder.build();
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(restApiServiceUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        mRestApi = retrofit.create(RestApi.class);

    }



    public RestApi getRestApi(){
        return mRestApi;
    }
}
