package com.example.api.api.results;

import com.example.api.api.response.SignupResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupResult {
    @SerializedName("results")
    @Expose

    public SignupResponse SignupResponse;

    public com.example.api.api.response.SignupResponse getSignupResponse() {
        return SignupResponse;
    }
}