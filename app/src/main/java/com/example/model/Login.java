package com.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Login implements Serializable {

    @SerializedName("email")
    @Expose
    private String user;
    @SerializedName("password")
    @Expose
    private String password;

    public Login(String username, String pass) {
        this.user = username;
        this.password = pass;
    }

    public String getEmail() {
        return user;
    }

    public void setEmail(String email) {
        this.user = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

}
