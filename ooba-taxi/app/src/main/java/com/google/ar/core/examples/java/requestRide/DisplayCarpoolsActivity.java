package com.google.ar.core.examples.java.requestRide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.ar.core.examples.java.MainActivity;
import com.google.ar.core.examples.java.accountControl.LoginPage;
import com.google.ar.core.examples.java.dbManagement.TaxiFleetDB;
import com.google.ar.core.examples.java.helloar.R;
import com.google.ar.core.examples.java.helloar.WaitingActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DisplayCarpoolsActivity extends AppCompatActivity {
    Button b_sort_time, b_sort_rating,b_sort_price;
    private List<Ride> rides;
    String text;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carpool_display);

        b_sort_rating = (Button) findViewById(R.id.b_sort_rating);
        b_sort_time = (Button) findViewById(R.id.b_sort_time);
        b_sort_price = (Button) findViewById(R.id.b_sort_price);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(DisplayCarpoolsActivity.this, WaitingActivity.class);
                        DisplayCarpoolsActivity.this.startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Intent intent = new Intent(DisplayCarpoolsActivity.this, WaitingActivity.class);
                        DisplayCarpoolsActivity.this.startActivity(intent);
                    }
                })
        );
        customAdapter = new CustomAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);

        rides = TaxiFleetDB.getAvailableCarpools();
        customAdapter.setRides(rides);

        b_sort_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(rides, new CustomComparatorRatings());
                customAdapter.setRides(rides);
            }
        });

        b_sort_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(rides, new CustomComparatorTime());
                customAdapter.setRides(rides);
            }
        });

        b_sort_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(rides, new CustomComparatorPrice());
                customAdapter.setRides(rides);
            }
        });
    }

    private class CustomComparatorRatings implements Comparator<Ride> {

        @Override
        public int compare(Ride r0, Ride r1) {
            Double rating1 = r0.getRating();
            Double rating2 = r1.getRating();
            return rating1.compareTo(rating2)*-1;
        }
    }

    private class CustomComparatorTime implements Comparator<Ride> {

        @Override
        public int compare(Ride t0, Ride t1) {
            int time1 = t0.getTime();
            int time2 = t1.getTime();
            if (time1 < time2) {
                return -1;
            } else if (time1 > time2) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    private class CustomComparatorPrice implements Comparator<Ride> {

        @Override
        public int compare(Ride p0, Ride p1) {
            Double price1 = p0.getPrice();
            Double price2 = p1.getPrice();
            return price1.compareTo(price2);
        }
    }

}

