package com.example.d1mys1klapo4ka.retrofitandgson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.AgencyList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private String BASE_URL = "http://server.gojob.com.ua/api/v1/agencies";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit client = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AgencyInterface service = client.create(AgencyInterface.class);
        Call<AgencyList> call = service.getName("Dimysik");

        call.enqueue(new Callback<AgencyList>() {

            @Override
            public void onResponse(Response<AgencyList> response, Retrofit retrofit) {

                if (response.isSuccess()) {
                    // request successful (status code 200, 201)
                    AgencyList result = response.body();
                    Log.e("@@@@@@", "onResponse: AgencyList"+ result );
                } else {
                    //request not successful (like 400,401,403 etc)
                    //Handle errors

                    Log.d("@@@@@@", "onResponse: Failed");
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
