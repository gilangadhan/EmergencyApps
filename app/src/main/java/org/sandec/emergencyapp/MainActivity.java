/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package org.sandec.emergencyapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //kenalin
    ImageView polisi, ambulan, pemadam, basarnas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hubungin
        polisi = findViewById(R.id.imgPolisi);
        ambulan = findViewById(R.id.imgAmbulance);
        pemadam = findViewById(R.id.imgPemadam);
        basarnas = findViewById(R.id.imgBasarnas);
        //ngapainnya
        polisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomorPolisi = Helper.Read(MainActivity.this, Helper.NOMOR_POLISI);
                if (nomorPolisi.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Masukkan nomor di Setting menu", Toast.LENGTH_SHORT).show();
                } else {
                    String uriString = "tel:" +nomorPolisi;
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(uriString));
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.setting) {
            startActivity(new Intent(MainActivity.this, SettingActivity.class));
        } else if (item.getItemId() == R.id.exit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
