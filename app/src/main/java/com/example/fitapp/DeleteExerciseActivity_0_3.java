package com.example.fitapp;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DeleteExerciseActivity_0_3 extends MuscleGroupsActivity_0 implements ExercisesInterface{

    ExercisesAdapter ex_adapter = new ExercisesAdapter(this, this);
    ArrayList<ExercisesItem> exercisesList = new ArrayList<>();
    ArrayList<ExercisesItem> customExercisesList = new ArrayList<>();
    RecyclerView recyclerView;
    ExercisesItem delete_exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set layout
        setContentView(R.layout.activity_delete_exercise);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Delete Custom Exercise");

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        bar.setBackgroundDrawable(color);

        // Fetch and observe exercises by category
        viewModel.getAllExercisesData().observe(this, new Observer<List<ExercisesItem>>() {
            @Override
            public void onChanged(List<ExercisesItem> exercisesItems) {
                // Update UI with exercisesItems
                exercisesList.clear();
                exercisesList.addAll(exercisesItems);

                customExercisesList = (ArrayList<ExercisesItem>) exercisesList.stream().filter(ExercisesItem::getCustomExercise).collect(Collectors.toList());

                setupExercises();
            }
        });

        // get the recycler view in order to manipulate it
        recyclerView = findViewById(R.id.ac_de_ex_RecView);

        // Handle back button press using OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish(); // or use super.onBackPressed() to go back
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Returning false here hides the menu
        return false;
    }

    private void setupExercises(){
        // set the adapter for recycler view and show items in it
        ex_adapter.setExercisesItems(customExercisesList);
        recyclerView.setAdapter(ex_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int position) {
        delete_exercise = customExercisesList.get(position);  // get the item you want to delete
        Intent intent = new Intent(getApplicationContext(), PopUpDeleteExercise.class);
        intent.putExtra("exercise_to_delete", ex_adapter.getExerciseAtPosition(position));
        startActivity(intent);
    }


}