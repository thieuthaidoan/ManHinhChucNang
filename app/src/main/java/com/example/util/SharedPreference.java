package com.example.util;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreference {
    public static String getToken(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("", MODE_PRIVATE);
        return preferences.getString("token", "");
    }
}
