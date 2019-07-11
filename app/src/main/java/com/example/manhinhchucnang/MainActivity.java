package com.example.manhinhchucnang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.manhinhchucnang";
    ProgressDialog progressDialog;
    /** Called when the user taps the Send button */
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvents();

    }

    private void addEvents() {
//    GridView gridView;
//        gridView.login.(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                    startActivity(intent);
//            }
//        });

}
    private class LoadAsyctask extends AsyncTask<Void, Void, Void> {


            @Override
            protected Void doInBackground(Void... params) {
            return null;
        }

            @Override
            protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }
    }
}
