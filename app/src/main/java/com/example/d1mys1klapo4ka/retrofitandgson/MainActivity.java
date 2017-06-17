package com.example.d1mys1klapo4ka.retrofitandgson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;

import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.Agency;
import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.AgencyList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private String BASE_URL = "http://server.gojob.com.ua/";
    Retrofit retrofit;
    AgencyInterface agencyInterface;
    List<Agency> post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        post = new ArrayList<>();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        agencyInterface = retrofit.create(AgencyInterface.class);

//        try {
//            Response response = agencyInterface.getAllData().execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        agencyInterface.getAllData().enqueue(new Callback<AgencyList>() {
            @Override
            public void onResponse(Call<AgencyList> call, Response<AgencyList> response) {

                Log.e("@@@@@", "onResponse: getAllData: " + response.body());

            }

            @Override
            public void onFailure(Call<AgencyList> call, Throwable t) {

            }
        });
    }
}
