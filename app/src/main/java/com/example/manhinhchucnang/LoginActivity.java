package com.example.manhinhchucnang;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.example.SQLite.SQLiteDB;
import com.example.api.api.APIServices;
import com.example.api.api.APIUtils;
import com.example.api.api.response.BaseResponse;
import com.example.api.api.response.LoginResponse;
import com.example.api.api.results.LoginResult;
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
            new Thread(new Runnable() {
                public void run() {
                    try {
                        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    progressDialog.dismiss();
                }
            }).start();

        });
        findViewById(R.id.tv_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(LoginActivity.this);
                //  progressDialog.setTitle("Vui Lòng Chờ !");
                progressDialog.setMessage("Loading...");
                progressDialog.setIndeterminate(false);
                progressDialog.show();
                new Thread(new Runnable() {
                            public void run() {
                                try {
                            login(userName.getText().toString(), passWord.getText().toString());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                }).start();

            }
        });
    }
    private void login(String username, String pass){

        mAPIServices = APIUtils.getAPIService();
        mAPIServices.LogIn(new Login(username, pass)).enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                Log.d(String.valueOf(response.body().isSuccess()), "day la cai gi do");
                if (response.body().isSuccess()){
                    Log.d("dang nhap thanh cong",toString());
                    Toast.makeText(LoginActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    SQLiteDB db = new SQLiteDB(LoginActivity.this);
                    db.save(SQLiteDB.KEY_TOKEN, response.body().getLoginResponse().getToken());
                    Intent intent =new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    public class HttpGetRequest extends AsyncTask<String, Void, String> {
//        public static final String REQUEST_METHOD = "GET";
//        public static final int READ_TIMEOUT = 15000;
//        public static final int CONNECTION_TIMEOUT = 15000;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//        }
//        @Override
//        protected String doInBackground(String... params) {
//            String stringUrl = params[0];
//            String result;
//            String inputLine;
//            try {
//                //Create a URL object holding our url
//                URL myUrl = new URL("https://reqres.in/api/login");
//                //Create a connection
//                HttpURLConnection connection = (HttpURLConnection)
//                        myUrl.openConnection();
//                //Set methods and timeouts
//                connection.setRequestMethod(REQUEST_METHOD);
//                connection.setReadTimeout(READ_TIMEOUT);
//                connection.setConnectTimeout(CONNECTION_TIMEOUT);
//
//                //Connect to our url
//                connection.connect();
//                //Create a new InputStreamReader
//                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
//                //Create a new buffered reader and String Builder
//                BufferedReader reader = new BufferedReader(streamReader);
//                StringBuilder stringBuilder = new StringBuilder();
//                //Check if the line we are reading is not null
//                while ((inputLine = reader.readLine()) != null) {
//                    stringBuilder.append(inputLine);
//                }
//                //Close our InputStream and Buffered reader
//                reader.close();
//                streamReader.close();
//                //Set our result equal to our stringBuilder
//                result = stringBuilder.toString();
//            } catch (IOException e) {
//                e.printStackTrace();
//                result = null;
//            }
//            return result;
//        }
//
//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
//        }
//    }
}
