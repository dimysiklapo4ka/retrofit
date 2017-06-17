package com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel;

/**
 * Created by d1mys1klapo4ka on 17.06.2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgencyList {

    @SerializedName("agencies")
    @Expose
    private List<Agency> agencies = null;

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

}