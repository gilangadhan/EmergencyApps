/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package org.sandec.emergencyapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class PanicActivity extends AppCompatActivity {

    LocationManager locationManager;
    Criteria criteria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();

        findViewById(R.id.btnMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PanicActivity.this, MainActivity.class));
            }
        });

        findViewById(R.id.imgPanic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(PanicActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(PanicActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(PanicActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_CHECKIN_PROPERTIES}, 100);
                    return;

                }
                Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
                sendPanic(location);
            }
        });
    }

    private void sendPanic(Location location) {
        String nomerOrangPenting = Helper.Read(PanicActivity.this, Helper.NOMOR_POLISI);
        if (nomerOrangPenting.isEmpty()){
            Toast.makeText(this, "Masukkan nomer di setting", Toast.LENGTH_SHORT).show();
        }else{
            String message = String.format("Hallo bro, aku lagi kena musibah. Lokasiku di titik ini %s,%s", location.getLatitude(), location.getLongitude());
            Intent kirimSms = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+nomerOrangPenting));
            kirimSms.putExtra("sms_body", message);
            startActivity(kirimSms);
        }
    }
}
