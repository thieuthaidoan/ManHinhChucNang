package com.example.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ThiSinhDB";
    private static final String TABLE_NAME = "ThiSinh";

    public static final String KEY_TOKEN =  "token";

    public SQLiteDB(Context context)
    {
        context(super DATABASE_NAME,null,DATABASE_VERSION);
    }
}
