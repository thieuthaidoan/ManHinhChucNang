package com.example.api.respose.results;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.example.api.respose.BaseResponse;
import com.example.api.respose.LoginResponse;
public class LoginResult extends BaseResponse {
    @SerializedName("results")
    @Expose
    public LoginResponse LoginResponse;

    public com.example.api.respose.LoginResponse getLoginResponse() {
        return LoginResponse;
    }
}
