package com.example.manhinhchucnang;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.manhinhchucnang";

    /** Called when the user taps the Send button */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addEvents();
    }

    private void addEvents() {

//        (new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                    startActivity(intent);
//            }
//        });
}}
