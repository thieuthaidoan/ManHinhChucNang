package com.example.manhinhchucnang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.manhinhchucnang";
    public static final int STATE_LOGIN = 0;
    public static final int STATE_LOGOUT = 1;
    /** Called when the user taps the Send button */
//    TextView tv;
//    Button bt,bt0,bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvents();

    }

    private void addEvents() {


        setContentView(R.layout.activity_main);
        {
            Button bt = findViewById(R.id.login);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
        }
    }




            }
