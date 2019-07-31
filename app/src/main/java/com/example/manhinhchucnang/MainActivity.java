package com.example.manhinhchucnang;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.SQLite.SQLiteDB;
import com.example.api.api.APIServices;
import com.example.model.Question;
import com.example.slide.ScreenSlideActivity;
import com.example.slide.ScreenSlidePageFragment;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


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

    private List<Question> questionsSkill1 = new ArrayList<Question>();
    private List<Question> questionsSkill2 = new ArrayList<Question>();
    private List<Question> questionsSkill3 = new ArrayList<Question>();
    private List<Question> questionsSkill4 = new ArrayList<Question>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvents();
        db = new SQLiteDB(this);
        db.getReadableDatabase();
        // Load toan bo cau hoi thong qua API
        Question ques = new Question();
        ques.set_id(1);
        ques.setAns_a("abc1");
        ques.setAns_b("abc2");
        ques.setAns_c("abc3");
        ques.setAns_d("abc4");
        ques.setSkill(1);
        Question[] resultFromAPI = {ques};

        for (int i = 0; i < resultFromAPI.length; i++) {
            if (resultFromAPI[i].getSkill() == 1) {
                questionsSkill1.add(resultFromAPI[i]);
            } else if (resultFromAPI[i].getSkill() == 2) {
                questionsSkill2.add(resultFromAPI[i]);
            } else if (resultFromAPI[i].getSkill() == 3) {
                questionsSkill3.add(resultFromAPI[i]);
            } else {
                questionsSkill4.add(resultFromAPI[i]);
            }
        }

    }

    //    private void loadCategory() {
//        progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setMessage("Loading...");
//        progressDialog.setIndeterminate(false);
//        progressDialog.show();

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
            bt.setOnClickListener(view -> {
//                if (session.isLoggedIn()) {
//                    bt.setText("Logout");
//                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
//                }
//                else
//                    {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
            });
            final Button bt1 = findViewById(R.id.bt_skill_1);
            bt1.setOnClickListener(view -> {

                Intent intent2 = new Intent(MainActivity.this, ScreenSlideActivity.class);

                String json = new Gson().toJson(questionsSkill1);
                ScreenSlidePageFragment.newInstance(json);
                intent2.putExtra("listQuestion", json);
                startActivity(intent2);
            });
            final Button bt2 = findViewById(R.id.bt_skill_2);
            bt2.setOnClickListener(view -> {
                Intent intent2 = new Intent(MainActivity.this, ScreenSlideActivity.class);
                Bundle extras = new Bundle();
                extras.putString("listQuestion", new Gson().toJson(questionsSkill2));
                startActivity(intent2);
            });
            final Button bt3 = findViewById(R.id.bt_skill_3);
            bt3.setOnClickListener(view -> {
                Intent intent2 = new Intent(MainActivity.this, ScreenSlideActivity.class);
                Bundle extras = intent2.getExtras();
                extras.putString("listQuestion", new Gson().toJson(questionsSkill3));
                startActivity(intent2);
            });
            final Button bt4 = findViewById(R.id.bt_skill_4);
            bt4.setOnClickListener(view -> {
                Intent intent2 = new Intent(MainActivity.this, ScreenSlideActivity.class);
                Bundle extras = intent2.getExtras();
                extras.putString("listQuestion", new Gson().toJson(questionsSkill4));
                startActivity(intent2);
            });

        }
    }
}
