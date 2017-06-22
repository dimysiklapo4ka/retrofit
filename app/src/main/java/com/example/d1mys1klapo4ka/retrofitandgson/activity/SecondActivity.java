package com.example.d1mys1klapo4ka.retrofitandgson.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.d1mys1klapo4ka.retrofitandgson.R;
import com.example.d1mys1klapo4ka.retrofitandgson.api.AgencyInterface;
import com.example.d1mys1klapo4ka.retrofitandgson.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;

    private EditText name;
    private EditText price;
    private EditText phone;
    private EditText address;
    private EditText shrdule;
    private EditText requisites;
    private EditText creditCard;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_agency);

        name = (EditText)findViewById(R.id.et_name);
        price = (EditText)findViewById(R.id.et_price);
        phone = (EditText)findViewById(R.id.et_phone);
        address = (EditText)findViewById(R.id.et_address);
        shrdule = (EditText)findViewById(R.id.et_schtdule);
        requisites = (EditText)findViewById(R.id.et_requisites);
        creditCard = (EditText)findViewById(R.id.er_credit_card);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        final AgencyInterface api = RetrofitClient.getAgencyInterface();

        switch (v.getId()){
            case R.id.button:

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        Call call = api.addAgency(name.getText().toString(),price.getText().toString(),
                                phone.getText().toString(),address.getText().toString(),shrdule.getText().toString(),
                                requisites.getText().toString(), creditCard.getText().toString());

                        call.enqueue(new Callback() {
                            @Override
                            public void onResponse(Call call, retrofit2.Response response) {
                                Log.e("@@@@@@", "Upload : success");
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
        }
        }
    }

