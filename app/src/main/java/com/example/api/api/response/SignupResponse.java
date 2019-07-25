package com.example.api.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupResponse {
    @SerializedName("_id")
    @Expose
    private String id;


    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("fullName")
    @Expose
    private String fullName;

    @SerializedName("created")
    @Expose
    private String created;

    @SerializedName("__v")
    @Expose
    private String __v;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCreated() {
        return created;
    }

    public String get__v() {
        return __v;
    }
}
