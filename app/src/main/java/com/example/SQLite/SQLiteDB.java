package com.example.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dbtracnghiem.db";
    private static final String TABLE_NAME = "tracnghiem";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_QUESTION = "question";
    private static final String COLUMN_A = "ans_a";
    private static final String COLUMN_B = "ans_b";
    private static final String COLUMN_C = "ans_c";
    private static final String COLUMN_D = "ans_d";
    private static final String COLUMN_RESULT = "result";
    private static final String COLUMN_NUMEXAM = "num_exam";
    private static final String COLUMN_SKILL = "skill";
    private static final String COLUMN_IMAGE = "image";
    private static final String COLUMN_AUDIO = "audio";
    public static final String KEY_TOKEN = "token";
    private static final String DB_TABLE = "testing";

    public SQLiteDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TABLE_2 = "CREATE TABLE " + DB_TABLE
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_QUESTION + " TEXT,"
                + COLUMN_A + " TEXT,"
                + COLUMN_B + " TEXT,"
                + COLUMN_C + " TEXT,"
                + COLUMN_D + " TEXT,"
                + COLUMN_RESULT + " TEXT,"
                + COLUMN_NUMEXAM + " INTERGER,"
                + COLUMN_SKILL + " TEXT,"
                + COLUMN_IMAGE + " TEXT,"
                + COLUMN_AUDIO + " TEXT)";
        sqLiteDatabase.execSQL(TABLE_2);
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, "");
        values.put(COLUMN_QUESTION, "");
        values.put(COLUMN_A, "");
        values.put(COLUMN_B, "");
        values.put(COLUMN_C, "");
        values.put(COLUMN_D, "");
        values.put(COLUMN_RESULT, "");
        values.put(COLUMN_NUMEXAM, "");
        values.put(COLUMN_SKILL, "");
        values.put(COLUMN_IMAGE, "");
        values.put(COLUMN_AUDIO, "");
        sqLiteDatabase.insert(DB_TABLE, null, values);

        String TABLE_1 = "CREATE TABLE " + TABLE_NAME
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + KEY_TOKEN + " TEXT)";


        sqLiteDatabase.execSQL(TABLE_1);

        ContentValues val = new ContentValues();
        val.put(KEY_TOKEN, "");
        sqLiteDatabase.insert(TABLE_NAME, null, val);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        this.onCreate(sqLiteDatabase);
    }

    public void save(String key, String value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key, value);
        db.update(TABLE_NAME, values, null, null);
        db.close();
    }

    public String getToken(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_TOKEN}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor.getString(cursor.getColumnIndex(KEY_TOKEN));
    }
}