package com.example.gyroscope;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second_activity extends AppCompatActivity {

    private TextView accelerometer;
    private Button btn;

    private SensorManager sm;
    private Sensor s;
    private SensorEventListener sv;

     private float x, y, z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        accelerometer = findViewById(R.id.accelerometer);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class );

                startActivity(intent);
            }
        });

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sv = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                
                float x = event.values[0];
                   float y = event.values[0];
                   float z = event.values[0];

                   accelerometer.setText("Данные акселерометра (м|c2):\nx = " + String.format("%.2f", x)
                           + "\ny = " + String.format("%.2f", y) + "\nz = " + String.format("%.2f", z));

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }
/*
    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(sv, s, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(sv);
    }
*/
}

