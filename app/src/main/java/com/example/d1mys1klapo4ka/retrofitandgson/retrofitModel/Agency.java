package com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel;

/**
 * Created by d1mys1klapo4ka on 17.06.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agency {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Object price;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("schrdule")
    @Expose
    private Object schrdule;
    @SerializedName("latitude")
    @Expose
    private Object latitude;
    @SerializedName("longitude")
    @Expose
    private Object longitude;
    @SerializedName("requisites")
    @Expose
    private Object requisites;
    @SerializedName("credit_card")
    @Expose
    private Object creditCard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getSchrdule() {
        return schrdule;
    }

    public void setSchrdule(Object schrdule) {
        this.schrdule = schrdule;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getRequisites() {
        return requisites;
    }

    public void setRequisites(Object requisites) {
        this.requisites = requisites;
    }

    public Object getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Object creditCard) {
        this.creditCard = creditCard;
    }

}
