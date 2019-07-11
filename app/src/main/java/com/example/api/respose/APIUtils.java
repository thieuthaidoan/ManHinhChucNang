package com.example.api.respose;

public class APIUtils {

    private APIUtils() {}
    public static final String BASE_URL = "https://reqres.in/api/";
    public static APIServices getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIServices.class);
    }
}