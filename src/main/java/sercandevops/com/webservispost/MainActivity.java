package sercandevops.com.webservispost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sercandevops.com.webservispost.Model.Model;
import sercandevops.com.webservispost.Model.Result;
import sercandevops.com.webservispost.RestApi.ManagerAll;

public class MainActivity extends AppCompatActivity {

    TextView tc;
    EditText edad,edsoyad;
    String ad="s";
    String soyad="d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tc = findViewById(R.id.tectmetin);
        edad = findViewById(R.id.edad);
        edsoyad = findViewById(R.id.edsoyad);


    }


    public void istek(){


        Call<Result> x = ManagerAll.getInstance().ekle(ad,soyad);

        x.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                    Toast.makeText(getApplicationContext(),"basarili kayit",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("dene","basarisiz");
                Toast.makeText(getApplicationContext(),"basarisiz kayit"+t.toString(),Toast.LENGTH_LONG).show();

                tc.setText(t.getMessage()+"\n"+t.getLocalizedMessage()+"\n"+t.toString());
            }
        });
    }

    public void istek2(){


        Model model = new Model();
                model.setTitle("ahmet");
                model.setUserId(489);
                model.setBody("içerik");
              //  model.setId(1);

        Call<Model> x = ManagerAll.getInstance().modelEkle(model);

        x.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if(response.isSuccessful()){

                    tc.setText("Code : "+response.code()+
                            "\ntoString : "+response.toString()+
                            "\nBody : "+response.body()+
                            "\n");

                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

                tc.setText(t.getMessage()+"\n"+t.getMessage());
            }
        });
    }

    public void deleteFromEditText(){
        edad.setText("");
        edsoyad.setText("");
    }

    public void KayitYap(View view) {
        ad = edad.getText().toString();
        soyad = edsoyad.getText().toString();

        //if(!ad.equals("") && !soyad.equals("")){

            istek();
            deleteFromEditText();
       // }else{
           // Toast.makeText(getApplicationContext(),"Boş gecilemez.",Toast.LENGTH_LONG).show();
       // }

    }
}
