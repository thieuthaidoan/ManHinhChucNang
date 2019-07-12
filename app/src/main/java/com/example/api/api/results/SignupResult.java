package com.example.api.api.results;

import com.example.api.api.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupResult extends BaseResponse {
    @SerializedName("results")
    @Expose
    public SignupResult SignupResult;
    public com.example.api.api.results.SignupResult getSignupResult(){
        return SignupResult;
    }
}