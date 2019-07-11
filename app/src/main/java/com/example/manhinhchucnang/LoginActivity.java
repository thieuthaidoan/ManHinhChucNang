package com.example.manhinhchucnang;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.SQLite.SQLiteDB;
import com.example.api.respose.APIServices;
import com.example.api.respose.APIUtils;
import com.example.api.respose.results.LoginResult;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText userName, passWord;
    private ProgressDialog progressDialog;
    private APIServices mAPIServices;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();
    }
    private void anhxa() {
        userName = (EditText) findViewById(R.id.username);
        passWord = (EditText) findViewById(R.id.password);
        tv = findViewById(R.id.tv_login);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                progressDialog = new ProgressDialog(LoginActivity.this);
//                //  progressDialog.setTitle("Vui Lòng Chờ !");
//                progressDialog.setMessage("Loading...");
//                progressDialog.setIndeterminate(false);
//                progressDialog.show();
//                login(userName.getText().toString(), passWord.getText().toString());
                Toast.makeText(LoginActivity.this, "dang nhap thanh cong@", Toast.LENGTH_SHORT).show();
            }
        });
//        findViewById(R.id.tv_login).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        findViewById(R.id.tv_signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
        findViewById(R.id.tv_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }
    private void login(String username, String pass) {
        mAPIServices = APIUtils.getAPIService();
        mAPIServices.login(new Login(username, pass)).enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(LoginActivity.this,"omeg@",Toast.LENGTH_SHORT);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"omeg@",Toast.LENGTH_SHORT);
            }
        });
    }
}


