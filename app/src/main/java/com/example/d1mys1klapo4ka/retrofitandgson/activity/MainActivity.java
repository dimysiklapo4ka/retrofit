package com.example.d1mys1klapo4ka.retrofitandgson.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.d1mys1klapo4ka.retrofitandgson.api.UserInterface;
import com.example.d1mys1klapo4ka.retrofitandgson.api.VacanciesInterface;
import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.UserModel;
import com.example.d1mys1klapo4ka.retrofitandgson.utils.InternetConection;
import com.example.d1mys1klapo4ka.retrofitandgson.adapter.AgencyAdapter;
import com.example.d1mys1klapo4ka.retrofitandgson.api.AgencyInterface;
import com.example.d1mys1klapo4ka.retrofitandgson.R;
import com.example.d1mys1klapo4ka.retrofitandgson.api.RetrofitClient;
import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.Agency;
import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.AgencyList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private View parentView;

    private List<Agency> agencies;
    private AgencyAdapter agencyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        agencies = new ArrayList<>();

        parentView = findViewById(R.id.parentLayout);

        listView = (ListView)findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (InternetConection.checInternet(getApplicationContext())){
                    final ProgressDialog dialog;

                    dialog = new ProgressDialog(MainActivity.this);
                    dialog.setTitle("Проверка интернет соединения");
                    dialog.setMessage("загрузка данных");
                    dialog.show();

                    AgencyInterface api = RetrofitClient.getAgencyInterface();

                    Call<AgencyList> call = api.getAllData();

                    call.enqueue(new Callback<AgencyList>() {
                        @Override
                        public void onResponse(Call<AgencyList> call, Response<AgencyList> response) {

                            dialog.dismiss();

                            if (response.isSuccessful()){

                                agencies = response.body().getAgencies();

                                agencyAdapter = new AgencyAdapter(MainActivity.this, agencies);

                                listView.setAdapter(agencyAdapter);
                            }else {

                                Log.e("@@@@@@", "agency json : " + "    случилась неведоммая хрень");
                            }
                        }

                        @Override
                        public void onFailure(Call<AgencyList> call, Throwable t) {

                            dialog.dismiss();
                        }
                    });
                }else {
                    Toast.makeText(MainActivity.this, "non internet connection",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button buttonSecondActivity = (Button)findViewById(R.id.bt_second_activity);

        buttonSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final VacanciesInterface api = RetrofitClient.getVacancyInterface();

                switch (v.getId()){
                    case R.id.bt_second_activity:

                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {

                                //Call call = api.addVacancy("jhgcdjvjd",1,4500.00,"ghiu","utguyhfg","yugfuyh","fniytfniy");
                                Call call = api.addVacancy("Сантехник", 1, 4500.00, "что то там", "Ukr", "xd", "xs");

                                call.enqueue(new Callback<Void>() {
                                    @Override
                                    public void onResponse(Call<Void> call, retrofit2.Response<Void> response) {
                                        Log.e("@@@@@@", "Upload : success" + call + "      " + response);
                                    }

                                    @Override
                                    public void onFailure(Call call, Throwable t) {
                                        Log.e("@@@@@@", "Upload : error");
                                    }
                                });

                            }
                        });
                        thread.start();
                        break;
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(intent);
            }
        }
        });
    }
}


