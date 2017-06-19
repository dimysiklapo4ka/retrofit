package com.example.d1mys1klapo4ka.retrofitandgson.api;

import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.Agency;
import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.AgencyList;

import java.util.List;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by d1mys1klapo4ka on 17.06.2017.
 */

public interface AgencyInterface {

    @GET("/api/v1/agencies")
    Call<AgencyList> getAllData();

    @POST("/api/v1/agencies")
    Response addAgency(@Field("name") String name, @Field("price") String price, @Field("phone") String phone,
                       @Field("address") String address, @Field("schrdule") String schrdule,
                       @Field("requisites") String requisites, @Field("credit_card") String creditCard);

//    @GET("/api/v1/agencies")
//    Call<Agency> getName(@Path("name") String name);
//
//    @GET("/agencies/{price}")
//    Call<Agency> agencyPrice(@Path("price") String price);
//
//    @GET("/agencies/{phone}")
//    Call<Agency> agencyPhone(@Path("phone") Object phone);
//
//    @GET("/agencies/{address}")
//    Call<Agency> agencyAddress(@Path("address") Object address);
//
//    @GET("/agencies/{schrdule}")
//    Call<Agency> agencySchrdule(@Path("schrdule") Object schrdule);
//
//    @GET("/agencies/{latitude}")
//    Call<Agency> agencyLatitude(@Path("latitude") Object latitude);
//
//    @GET("/agencies/{longitude}")
//    Call<Agency> agencyLongitude(@Path("longitude") Object longitude);
//
//    @GET("/agencies/{requisites}")
//    Call<Agency> agencyRequisites(@Path("requisites") Object requisites);
//
//    @GET("/agencies/{credit_card}")
//    Call<Agency> agencyCreditCard(@Path("credit_card") Object creditCard);
}
