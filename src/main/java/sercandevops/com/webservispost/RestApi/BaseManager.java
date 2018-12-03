package sercandevops.com.webservispost.RestApi;

public class BaseManager {


    protected RestApi getRestApi(String URL){
        RestApiClient restApiClient = new RestApiClient(URL);


        return restApiClient.getRestApi();
    }
}
