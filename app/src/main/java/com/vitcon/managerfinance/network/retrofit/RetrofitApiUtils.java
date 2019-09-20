package com.vitcon.managerfinance.network.retrofit;

public class RetrofitApiUtils {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static RetrofitApi instance;
    public static RetrofitApi getInstance() {
        if (instance == null) {
            instance = RetrofitClient.getClient(BASE_URL).create(RetrofitApi.class);
        }
        return instance;
    }
}
