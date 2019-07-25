package com.example.adapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.SQLite.SQLiteDB;
import com.example.model.Question;

import java.util.ArrayList;

public class QuestionAdapter {
    private SQLiteDB dbHelper;
    public static ArrayList<Question> mArrayList;
    public ArrayList<Question> getQuestion(int num_exam, String skill) {

        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tracnghiem Where num_exam ='" + num_exam + "AND skill = '" + skill + "'", null);
        mArrayList = new ArrayList<>();
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            // The Cursor is now set to the right position

            Question item;
            item = new Question(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)
                    , cursor.getInt(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10));
            mArrayList.add(item);

        }
        return mArrayList;

    }
}
