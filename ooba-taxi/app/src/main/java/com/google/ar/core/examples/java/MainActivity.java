package com.google.ar.core.examples.java;

import android.Manifest;
import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.ar.core.examples.java.accountControl.AccountOptions;
import com.google.ar.core.examples.java.accountControl.LoginPage;
import com.google.ar.core.examples.java.dbManagement.AccountDB;
import com.google.ar.core.examples.java.helloar.R;
import com.google.ar.core.examples.java.helloar.databinding.NewActivityMainBinding;
import com.google.ar.core.examples.java.offerRide.TaxiIDScan;
import com.google.ar.core.examples.java.requestRide.RequestRideActivity;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private NewActivityMainBinding binding;
    private Button requestButton;
    private Button offerButton;
    private ImageButton loginButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = NewActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Fragment fragment = new Map_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

        requestButton = findViewById(R.id.request_ride_button);
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!AccountDB.loggedIn){
                    Toast.makeText(MainActivity.this, "You are not logged in", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, RequestRideActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!AccountDB.loggedIn){
                    Intent intent = new Intent(MainActivity.this, LoginPage.class);
                    MainActivity.this.startActivity(intent);
                }
                else{
                    Intent intent = new Intent(MainActivity.this, AccountOptions.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });

        offerButton = findViewById(R.id.offer_ride_button);
        offerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!AccountDB.loggedIn){
                    Toast.makeText(MainActivity.this, "You are not logged in", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, TaxiIDScan.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }




}
