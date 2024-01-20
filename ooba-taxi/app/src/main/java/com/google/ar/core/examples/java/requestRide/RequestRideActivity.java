package com.google.ar.core.examples.java.requestRide;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.ar.core.examples.java.Map_Fragment;
import com.google.ar.core.examples.java.helloar.BuildConfig;
import com.google.ar.core.examples.java.helloar.R;

public class RequestRideActivity extends AppCompatActivity{
    private LatLng pickUpLatLng;
    private LatLng dropOffLatLng;
    Button searchButton;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_ride_form);
        Fragment pickUpFragment = new Map_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.pick_up_map, pickUpFragment).commit();
        Fragment dropOffFragment = new Map_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.drop_off_map, dropOffFragment).commit();
        pickUpLatLng = ((Map_Fragment) pickUpFragment).getMarkerPos();
        dropOffLatLng = ((Map_Fragment) dropOffFragment).getMarkerPos();
        searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RequestRideActivity.this, DisplayCarpoolsActivity.class);
//                if (dropOffLatLng != null && pickUpLatLng != null) {
//                    intent.putExtra("drop-off longitude", dropOffLatLng.longitude);
//                    intent.putExtra("pick-up longitude", pickUpLatLng.longitude);
//                    intent.putExtra("drop-off latitude", dropOffLatLng.latitude);
//                    intent.putExtra("pick-up latitude", pickUpLatLng.latitude);
//                }
                RequestRideActivity.this.startActivity(intent);
            }
        });

    }

}
