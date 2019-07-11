package com.example.api.respose;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("success")
    @Expose
    private boolean success;
    public boolean isSuccess() {
        return success;
    }
}
