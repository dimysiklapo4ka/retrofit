package com.example.d1mys1klapo4ka.retrofitandgson;

import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.Agency;
import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.AgencyList;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by d1mys1klapo4ka on 17.06.2017.
 */

public interface AgencyInterface {

    @GET("/agencies/{name}")
    Call<AgencyList> getName(@Path("name") String name);

    @GET("/agencies/{price}")
    Call<AgencyList> agencyPrice(@Path("price") String price);

    @GET("/agencies/{phone}")
    Call<AgencyList> agencyPhone(@Path("phone") Object phone);

    @GET("/agencies/{address}")
    Call<AgencyList> agencyAddress(@Path("address") Object address);

    @GET("/agencies/{schrdule}")
    Call<AgencyList> agencySchrdule(@Path("schrdule") Object schrdule);

    @GET("/agencies/{latitude}")
    Call<AgencyList> agencyLatitude(@Path("latitude") Object latitude);

    @GET("/agencies/{longitude}")
    Call<AgencyList> agencyLongitude(@Path("longitude") Object longitude);

    @GET("/agencies/{requisites}")
    Call<AgencyList> agencyRequisites(@Path("requisites") Object requisites);

    @GET("/agencies/{credit_card}")
    Call<AgencyList> agencyCreditCard(@Path("credit_card") Object creditCard);
}
