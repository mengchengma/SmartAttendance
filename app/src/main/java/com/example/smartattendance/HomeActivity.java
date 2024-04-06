package com.example.smartattendance;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity implements LocationListener {
    protected double latitude, longitude;
    TextView txtLat, txtLong;

    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find the EditText with the correct ID from the layout file
        txtLat = (TextView) findViewById(R.id.txtvLat);
        txtLong = (TextView) findViewById(R.id.txtvLong);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != )
        // Now you can use welcomeEditText to perform any operations you need
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        LocationListener.super.onStatusChanged(provider, status, extras);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }
}


