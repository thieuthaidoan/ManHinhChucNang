package com.example.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TestingDB";
    private static final String TABLE_NAME = "Testing";

    public static final String KEY_TOKEN = "token";


    public SQLiteDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
                + " (" + KEY_TOKEN + " TEXT)";

        sqLiteDatabase.execSQL(CREATE_TABLE);

        ContentValues values = new ContentValues();
        values.put(KEY_TOKEN, "");
        sqLiteDatabase.insert(TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(sqLiteDatabase);
    }

    public void save(String key, String value){
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