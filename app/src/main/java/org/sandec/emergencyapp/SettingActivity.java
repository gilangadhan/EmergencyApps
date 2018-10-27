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
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {
    //kenalin
    EditText nomerPolisi, nomorPemadam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nomerPolisi= findViewById(R.id.edtNomorPolisi);
        nomorPemadam = findViewById(R.id.edtNomorPemadam);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String polisi = nomerPolisi.getText().toString();
                String pemadam = nomorPemadam.getText().toString();
                if (polisi.isEmpty()) {
                    nomerPolisi.setError("Tidak boleh kosong");
                }else if (pemadam.isEmpty()){
                    nomorPemadam.setError("Tidak Boleh Kosong");
                }else {
                    //esekusi
                    Helper.Save(SettingActivity.this, Helper.NOMOR_POLISI, polisi);
                    Helper.Save(SettingActivity.this, Helper.NOMOR_PEMADAM, pemadam);
                    Toast.makeText(SettingActivity.this, "Sukses Simpan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
