package com.google.ar.core.examples.java.helloar;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.ar.core.examples.java.Map_Fragment;
import com.google.ar.core.examples.java.endOfTrip.RatingForm;
import com.google.ar.core.examples.java.helloar.databinding.WaitingPageBinding;


public class WaitingActivity extends AppCompatActivity {

    private WaitingPageBinding binding;
    private TextView etaText;
    private Button playButton;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 120000; // 2 mins

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = WaitingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Fragment fragment = new Map_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
        etaText = (TextView) findViewById(R.id.eta_text);
        playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(WaitingActivity.this, HelloArActivity.class);
                WaitingActivity.this.startActivity(myIntent);
            }
        });
        startTimer();
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                // Start end of trip page activity
                Intent myIntent = new Intent(WaitingActivity.this, RatingForm.class);
                WaitingActivity.this.startActivity(myIntent);
            }
        }.start();
    }

    public void updateTimer(){
        int minutes = (int) timeLeftInMilliseconds/60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;
        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        etaText.setText("ETA: " + timeLeftText);
    }




}
