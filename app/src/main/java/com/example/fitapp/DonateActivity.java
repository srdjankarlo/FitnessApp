package com.example.fitapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


// Alt+shift to have multi select lines
// fast double click ctrl+arrow up/down to select lines

public class DonateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set title in action bar - starting title is in AndroidManifest android:label
        // actionBar.setTitle(R.string.exercises);

        // set layout for the activity
        setContentView(R.layout.activity_donate);
    }

    // yes button when pressed logic
    public void Button1(View view) {
        // ToDo
        Toast.makeText(getApplicationContext(), "Not implemented yet!", Toast.LENGTH_SHORT).show();
    }

    // no button when pressed logic
    public void Button2(View view) {
        Intent intent = new Intent(this, MainMenuActivity_0.class);
        startActivity(intent);
    }
}