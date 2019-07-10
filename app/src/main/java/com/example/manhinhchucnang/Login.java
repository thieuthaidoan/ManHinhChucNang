package com.example.manhinhchucnang;

public class Login {

    private String email;

    private String password;

    public Login(String username, String pass) {
        this.email = username;
        this.password = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
