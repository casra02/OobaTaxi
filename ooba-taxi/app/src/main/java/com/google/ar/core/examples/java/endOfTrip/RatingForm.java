package com.google.ar.core.examples.java.endOfTrip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.ar.core.examples.java.MainActivity;
import com.google.ar.core.examples.java.Map_Fragment;
import com.google.ar.core.examples.java.helloar.R;
import com.google.ar.core.examples.java.helloar.WaitingActivity;
import com.google.ar.core.examples.java.offerRide.TaxiIDScan;

import java.util.ArrayList;

public class RatingForm extends AppCompatActivity {
    private Button one_star;
    private Button two_star;
    private Button three_star;
    private Button four_star;
    private Button five_star;
    private ArrayList<Button> starButtonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_form);
        Fragment fragment = new Map_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
        starButtonList = new ArrayList<>();
        one_star = (Button) findViewById(R.id.one_star); starButtonList.add(one_star);
        two_star = (Button) findViewById(R.id.two_star); starButtonList.add(two_star);
        three_star = (Button) findViewById(R.id.three_star); starButtonList.add(three_star);
        four_star = (Button) findViewById(R.id.four_star); starButtonList.add(four_star);
        five_star = (Button) findViewById(R.id.five_star); starButtonList.add(five_star);

        for (int i = 0; i < starButtonList.size(); i++){
            starButtonList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(RatingForm.this, "Thanks for your feedback!", Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(RatingForm.this, MainActivity.class);
                    RatingForm.this.startActivity(myIntent);
                }
            });
        }
    }

}
