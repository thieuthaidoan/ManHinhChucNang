package com.example.api.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("token")
    @Expose
    private String token;
//    @SerializedName("fullName")
//    @Expose
//    private String fullName;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("email")
    @Expose
    private String email;

    public String getToken() {
        return token;
    }

//    public String getFullName() {
//        return fullName;
//    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
