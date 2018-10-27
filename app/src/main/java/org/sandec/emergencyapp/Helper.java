/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package org.sandec.emergencyapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Helper {

    public static final String NOMOR_POLISI = "nomor_polisi";
    public static final String NOMOR_AMBULAN = "nomor_ambulan";
    public static final String NOMOR_PEMADAM = "nomor_pemadam";
    public static final String NOMOR_BASARNAS = "nomor_basarnas";

    public static void Save(Context context, String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String Read(Context context, String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(key, "");
    }
}
