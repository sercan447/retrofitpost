package sercandevops.com.webservispost.RestApi;

import retrofit2.Call;
import sercandevops.com.webservispost.Model.Model;
import sercandevops.com.webservispost.Model.Result;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }


    public Call<Result> ekle(String ad,String soyad){

        Call<Result> x = getRestApi(BaseUrl.URL).addUser(ad,soyad);

        return x;
    }

    public Call<Model> modelEkle(Model model){

        Call<Model> mod = getRestApi(BaseUrl.URL2).addData(model);

        return mod;
    }
}
