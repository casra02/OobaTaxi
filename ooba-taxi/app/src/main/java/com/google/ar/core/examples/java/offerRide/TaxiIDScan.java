package com.google.ar.core.examples.java.offerRide;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.ar.core.examples.java.MainActivity;
import com.google.ar.core.examples.java.dbManagement.TaxiFleetDB;
import com.google.ar.core.examples.java.helloar.R;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;


public class TaxiIDScan extends AppCompatActivity {

    Button btn_scan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi_idscan);
        btn_scan = findViewById(R.id.btn_scan);
        btn_scan.setOnClickListener(v ->
        {
            scanCode();
        });
    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Put volume up to turn flash on!");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barcodeLauncher.launch(options);
    }

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if(result.getContents() == null) {
                    Toast.makeText(TaxiIDScan.this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    // Add offer info in Taxi Fleet DB
                    // res = results.getContent()
                    // split up the string into name and taxi ID
                    TaxiFleetDB.initialize();
                    TaxiFleetDB.add(result.getContents());
                    Toast.makeText(TaxiIDScan.this, "Offer Sent!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(TaxiIDScan.this, MainActivity.class);
                    TaxiIDScan.this.startActivity(intent);
                }
            });





}