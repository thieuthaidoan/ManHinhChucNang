package com.example.manhinhchucnang;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.SQLite.SQLiteDB;
import com.example.api.api.APIServices;
import com.example.api.api.APIUtils;
import com.example.api.api.response.LoginResponse;
import com.example.model.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText userName, passWord;
    private ProgressDialog progressDialog;
    private APIServices mAPIServices;
    private static String token;
    TextView tv;
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();
    }

    private void anhxa() {
        userName = findViewById(R.id.username);
        passWord = findViewById(R.id.password);
        tv = findViewById(R.id.tv_login);
        findViewById(R.id.tv_signup).setOnClickListener(view -> {
            progressDialog = new ProgressDialog(LoginActivity.this);
            //  progressDialog.setTitle("Vui Lòng Chờ !");
            progressDialog.setMessage("Loading...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();
            new Thread(() -> {
                try {
                    startActivity(new Intent(LoginActivity.this, SignUpActivity.class));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }).start();

        });
        tv.setOnClickListener(view -> {

            progressDialog = new ProgressDialog(LoginActivity.this);
            //  progressDialog.setTitle("Vui Lòng Chờ !");
            progressDialog.setMessage("Loading...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();
            new Thread(() -> {
                try {
                    login(userName.getText().toString(), passWord.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }).start();

        });
    }
    private void login(String username, String pass){

        mAPIServices = APIUtils.getAPIService();
        mAPIServices.LogIn(new Login(username, pass)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(LoginActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(LoginActivity.this, "dang nhap thanh cong!", Toast.LENGTH_SHORT).show();
                    SQLiteDB db = new SQLiteDB(LoginActivity.this);
                    db.save(SQLiteDB.KEY_TOKEN, response.body().getToken());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
