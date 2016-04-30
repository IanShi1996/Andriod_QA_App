package com.example.ruian.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Receive intent
        Intent intent = getIntent();
        countDown(10000);
    }

    /**
     * Creates a countdown timer which modifies the time remaining in the activity
     *
     * @param initialTime The initial time to start the countdown with
     */
    public void countDown(long initialTime) {
        // Get text from XML
        final TextView text = (TextView) findViewById(R.id.textView);
        // Store this instance to pass to function
        final MainActivity mainActivity = this;

        // Create timer
        CountDownTimer timer = new CountDownTimer(initialTime, 1000) {
            // Changes text per tick
            public void onTick(long millisUntilFinished) {
                text.setText(Long.toString(millisUntilFinished / 1000));
            }
            // Transitions to other activity
            public void onFinish() {
                Intent intent = new Intent(mainActivity, Main2Activity.class);
                startActivity(intent);
            }
        }.start();
    }

    /**
     * Creates and executes an intent to return to previous activity
     */
    public void onClickReturn(View v) {
        // Change to previous activity
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
