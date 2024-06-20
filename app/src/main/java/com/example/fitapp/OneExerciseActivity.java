package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

public class OneExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_exercise);

        ArrayList<MainMenuRecViewItem> item_list;

        Bundle intent = getIntent().getExtras();
        if (intent != null){
            String exercise = intent.getString("ExerciseName");
            Objects.requireNonNull(getSupportActionBar()).setTitle(exercise);
        }

    }
}