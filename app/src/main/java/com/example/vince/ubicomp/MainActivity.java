package com.example.vince.ubicomp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;


import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuItem;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements SensorEventListener{

    public static final String EXTRA_MESSAGE = "User Text";
    private TextView accel_text;
    private Sensor mySensor;
    private SensorManager SM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create our sensor manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register Sensor listerner
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        //Assign TextView for accel text
        accel_text = (TextView)findViewById(R.id.textView2);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        accel_text.setText("{" + event.values[0] + ", " + event.values[1] + ", " + event.values[2] + "}");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //not used
    }

    public void showMessage(View view){
        // Get the edit text UI element
        EditText editText = (EditText) findViewById(R.id.edit_message);

        //Now get the message
        String msg = editText.getText().toString();

        //Show the message as a notif
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    /** Called when the user clicks the newActivity button */
    public void newActivity(View view) {
        // Get the edit text UI element
        EditText editText = (EditText) findViewById(R.id.edit_message);

        // Now get the message
        String msg = editText.getText().toString();

        // Create a new Intent
        Intent intent = new Intent(this, Second.class);

        //Send the message
        intent.putExtra(EXTRA_MESSAGE, msg);

        // start the activity
        startActivity(intent);
    }
}
