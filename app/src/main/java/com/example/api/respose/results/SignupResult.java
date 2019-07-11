package com.example.api.respose.results;

import com.example.api.respose.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupResult extends BaseResponse {
    @SerializedName("results")
    @Expose
    public SignupResult SignupResult;
    public com.example.api.respose.results.SignupResult getSignupResult(){
        return SignupResult;
    }
}
