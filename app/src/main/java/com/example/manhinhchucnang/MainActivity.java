package com.example.manhinhchucnang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.SQLite.SQLiteDB;
import com.example.adapter.CategoryAdapter;
import com.example.api.api.APIServices;
import com.example.api.api.APIUtils;
import com.example.api.api.results.GetCategoryResults;
import com.example.model.Category;
import com.example.slide.BlankFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
//    public static final String EXTRA_MESSAGE = "com.example.manhinhchucnang";
//    public static final int STATE_LOGIN = 0;
//    public static final int STATE_LOGOUT = 1;
    /** Called when the user taps the Send button */
//    TextView tv;
    ProgressDialog progressDialog;
    SQLiteDB db;
    GridView gridView;
    String token;
    Button bt, bt0, bt1, bt2, bt3, bt4;
    private APIServices mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvents();
        loadCategory();
        BlankFragment.newInstance();
    }

    private void loadCategory() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        db = new SQLiteDB(this);
        token = db.getToken();
        mAPIService = APIUtils.getAPIService();
        mAPIService.getCategories(token).enqueue(new Callback<GetCategoryResults>() {
            @Override
            public void onResponse(Call<GetCategoryResults> call, Response<GetCategoryResults> response) {
                if (response.body() != null) {
                    Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                    getCategorySuccess(response.body().getCategory());
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<GetCategoryResults> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getCategorySuccess(List<Category> response) {
        CategoryAdapter adapter = new CategoryAdapter(MainActivity.this, R.layout.activity_screen_slide, response);
        adapter.notifyDataSetChanged();
        gridView.setAdapter(adapter);
        progressDialog.dismiss();
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
