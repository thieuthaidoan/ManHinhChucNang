package com.example.manhinhchucnang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.SQLite.SQLiteDB;
import com.example.api.api.APIServices;
import com.example.slide.ScreenSlideActivity;
import com.example.slide.ScreenSlidePageFragment;


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
    private APIServices mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvents();
//        loadCategory();
//       ScreenSlidePageFragment.newInstance();
    }

    //    private void loadCategory() {
//        progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setMessage("Loading...");
//        progressDialog.setIndeterminate(false);
//        progressDialog.show();
//        db = new SQLiteDB(this);
//        token = db.getToken();
//        mAPIService = APIUtils.getAPIService();
//        mAPIService.getCategories(token).enqueue(new Callback<GetCategoryResults>() {
//            @Override
//            public void onResponse(Call<GetCategoryResults> call, Response<GetCategoryResults> response) {
//                if (response.body() != null) {
//                    Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
//
//                    getCategorySuccess(response.body().getCategory());
//                }
//                progressDialog.dismiss();
//            }
//
//            @Override
//            public void onFailure(Call<GetCategoryResults> call, Throwable t) {
//                progressDialog.dismiss();
//                Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void getCategorySuccess(List<Category> response) {
//        CategoryAdapter adapter = new CategoryAdapter(MainActivity.this, R.layout.activity_screen_slide, response);
//        adapter.notifyDataSetChanged();
//        gridView.setAdapter(adapter);
//        progressDialog.dismiss();
//    }
    private void addEvents() {

        setContentView(R.layout.activity_main);
        {
            final Button bt = findViewById(R.id.login);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
            final Button bt1 = findViewById(R.id.bt_skill_1);
            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = new Intent(MainActivity.this, ScreenSlideActivity.class);
                    startActivity(intent2);
                }
            });
        }
    }
}
