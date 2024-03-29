package com.example.manhinhchucnang;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.api.api.APIServices;
import com.example.api.api.APIUtils;
import com.example.api.api.results.SignupResult;
import com.example.model.Signup;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    EditText fullName, tvEmail, passWord, rePassword;
    private ProgressDialog progressDialog;
    private APIServices mAPIServices;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        anhxa();
    }

    private void anhxa() {
        fullName = (EditText) findViewById(R.id.name_register);
        tvEmail = (EditText) findViewById(R.id.email_register);
        passWord = (EditText) findViewById(R.id.pass_register);
        rePassword = (EditText) findViewById(R.id.re_pass_register);
        findViewById(R.id.btn_signup_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (passWord.getText().toString() == rePassword.getText().toString()) {
                progressDialog = new ProgressDialog(SignUpActivity.this);
                //  progressDialog.setTitle("Vui Lòng Chờ !");
                progressDialog.setMessage("Loading...");
                progressDialog.setIndeterminate(false);
                progressDialog.show();
                signup(tvEmail.getText().toString()
//                        , fullName.getText().toString()
                        , passWord.getText().toString());
                }
//                else {
//                    Toast.makeText(SignUpActivity.this, "re-pass wrong!", Toast.LENGTH_SHORT).show();
//                }
//            }
        });
    }

    private boolean checkInternet() {
        final ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            // notify user you are online
            return true;
        } else
            return false;
    }

    private void signup(
//            String name,
            String email, String pass) {

        mAPIServices = APIUtils.getAPIService();
        mAPIServices.SignUp(new Signup(email, pass)).enqueue(new Callback<SignupResult>() {
            @Override
            public void onResponse(Call<SignupResult> call, Response<SignupResult> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(SignUpActivity.this, response.body().getSignupResponse().toString(), Toast.LENGTH_SHORT).show();
//                    if (checkInternet()) {
                        Toast.makeText(SignUpActivity.this, "Dang ki thanh cong", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                        finish();
//                    } else {
//                        Toast.makeText(SignUpActivity.this, "vui long kiem tra internet", Toast.LENGTH_SHORT).show();
//                    }
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<SignupResult> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Sign Up false", Toast.LENGTH_SHORT).show();
            }
        });

    }


//    private void signup(String name, String pass, String mail) {
//        mAPIService = APIUtils.getAPIService();
//        mAPIService.SignUp(new Signup(name,pass,mail)).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<SignupResult> call, Response<SignupResult> response) {
//                if (response.body().isSuccess()){
//                    Toast.makeText(SignUpActivity.this, response.body().getSignupResult().toString(), Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
//                    finish();
//                    progressDialog.dismiss();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SignupResult> call, Throwable t) {
//                Toast.makeText(SignUpActivity.this, "SignUp false", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}
