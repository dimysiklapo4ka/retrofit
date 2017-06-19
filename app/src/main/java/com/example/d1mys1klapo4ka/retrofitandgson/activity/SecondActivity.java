package com.example.d1mys1klapo4ka.retrofitandgson.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.d1mys1klapo4ka.retrofitandgson.R;
import com.example.d1mys1klapo4ka.retrofitandgson.api.AgencyInterface;
import com.example.d1mys1klapo4ka.retrofitandgson.api.RetrofitClient;
import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.AgencyList;

import okhttp3.Response;
import retrofit2.Call;

/**
 * Created by dev on 19.06.17.
 */

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

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    Response response = api.addAgency(name.getText().toString(),price.getText().toString(),
                            phone.getText().toString(),address.getText().toString(),shrdule.getText().toString(),
                            requisites.getText().toString(), creditCard.getText().toString());

                }
            });
            thread.start();
        }
    }
