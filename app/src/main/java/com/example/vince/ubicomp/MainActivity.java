package com.example.vince.ubicomp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "User Text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
