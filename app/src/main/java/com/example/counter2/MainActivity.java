package com.example.counter2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Button my_start_button;
    Button my_pause_button;
    Button my_reset_button;
    Chronometer my_chronometer;

    //private Long last_pause =(long)0;

    //Long last_pause=(long)0;

    long last_pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_start_button = (Button) findViewById(R.id.start_button);
        my_pause_button = (Button) findViewById(R.id.pause_button);
        my_reset_button = (Button) findViewById(R.id.reset_button);

        my_chronometer = (Chronometer) findViewById(R.id.my_chronometer);


        my_pause_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                last_pause= SystemClock.elapsedRealtime();
                my_chronometer.stop();
                my_pause_button.setEnabled(false);
                my_start_button.setEnabled(true);


            }
        });

        my_start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(last_pause !=0)
               {
                my_chronometer.setBase(my_chronometer.getBase()+SystemClock.elapsedRealtime() -last_pause);

               }
                else
                {
                    my_chronometer.setBase(SystemClock.elapsedRealtime());
                }
                my_chronometer.start();
                my_pause_button.setEnabled(true);
                my_start_button.setEnabled(false);


            }
        });


        my_reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                my_chronometer.stop();
                my_chronometer.setBase(SystemClock.elapsedRealtime());
                last_pause=0;
                my_pause_button.setEnabled(false);
                my_start_button.setEnabled(true);


            }
        });

    }
}
