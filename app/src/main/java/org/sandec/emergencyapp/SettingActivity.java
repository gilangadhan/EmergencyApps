/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package org.sandec.emergencyapp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class SettingActivity extends AppCompatActivity {
    //kenalin
    EditText nomerPolisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nomerPolisi= findViewById(R.id.edtNomorPolisi);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String polisi = nomerPolisi.getText().toString();
                if (polisi.isEmpty()){
                    nomerPolisi.setError("Tidak boleh kosong");
                }else {
                    //esekusi
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SettingActivity.this);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nomor_polisi", polisi);
                    editor.apply();
                }
            }
        });
    }
}
