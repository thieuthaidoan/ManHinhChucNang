package com.example.api.api.results;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.example.api.api.response.BaseResponse;
import com.example.api.api.response.LoginResponse;

public class LoginResult extends BaseResponse {
    @SerializedName("results")
    @Expose
    public LoginResponse LoginResponse;

    public com.example.api.api.response.LoginResponse getLoginResponse() { return LoginResponse;
    }
}
