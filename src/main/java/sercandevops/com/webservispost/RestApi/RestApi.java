package sercandevops.com.webservispost.RestApi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import sercandevops.com.webservispost.Model.Model;
import sercandevops.com.webservispost.Model.Result;


public interface RestApi {

    //@Headers("Cache-Control: max-age=640000")
    @FormUrlEncoded
    @POST("ekle.php")
    Call<Result> addUser(@Field("isim")String isim, @Field("soyisim")String soyisim);



    @POST("posts")
    Call<Model> addData(@Body Model model);



}
