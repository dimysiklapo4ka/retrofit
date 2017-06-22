package com.example.d1mys1klapo4ka.retrofitandgson.api;

import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.AgencyList;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AgencyInterface {

    @GET("/api/v1/agencies")
    Call<AgencyList> getAllData();

    @FormUrlEncoded
    @POST("/api/v1/agencies")
    Call<Void> addAgency(@Field("agency[name]") String name, @Field("agency[price]") String price,
                         @Field("agency[phone]") String phone, @Field("agency[address]") String address,
                         @Field("agency[schrdule]") String schrdule, @Field("agency[requisites]") String requisites,
                         @Field("agency[credit_card]") String creditCard);
}
