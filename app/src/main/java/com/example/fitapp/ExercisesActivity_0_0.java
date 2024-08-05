package com.example.fitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExercisesActivity_0_0 extends MuscleGroupsActivity_0 implements ExercisesInterface {

    ArrayList<ExercisesItem> muscleGroupItems = new ArrayList<>();
    ArrayList<ExercisesItem> originalMuscleGroupItems = new ArrayList<>();
    ExercisesAdapter muscleGroupAdapter = new ExercisesAdapter(this, this);
    RecyclerView recyclerView;
    List<String> muscleGroupCategory;
    String categoryName;
    int menu_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get data from previous activity
        Intent intent = getIntent();
        muscleGroupItems = intent.getParcelableArrayListExtra("RecViewItemsList");
        originalMuscleGroupItems = muscleGroupItems;

        // get the type of the item
        muscleGroupCategory = muscleGroupItems.get(0).getPrimary();
        categoryName = intent.getStringExtra("Exercise name");

        // set layout
        setContentView(R.layout.activity_exercises);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle(categoryName + " exercises");

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        bar.setBackgroundDrawable(color);

        // get the recycler view in order to manipulate it
        recyclerView = findViewById(R.id.ac_ex_RecView);

        // set the adapter for recycler view and show items in it
        //MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
        muscleGroupAdapter.setExercisesItems(muscleGroupItems);

        recyclerView.setAdapter(muscleGroupAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
    //    // Returning false here hides the menu
    //    return false;
    //}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.second_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Handle item selection
        // get the id of clicked menu item
        menu_id = item.getItemId();
        if (menu_id == R.id.se_me_item1) {
            muscleGroupItems = originalMuscleGroupItems;

            long count = muscleGroupItems.size();

            Toast.makeText(ExercisesActivity_0_0.this, "Available : " + count + " exercises", Toast.LENGTH_SHORT).show();
        } else if (menu_id == R.id.se_me_item2) {
            muscleGroupItems = (ArrayList<ExercisesItem>) muscleGroupItems.stream()
                    .filter(exercise -> "Gym".equals(exercise.getPlace()))
                    .collect(Collectors.toList());

            long count = muscleGroupItems.stream()
                    .filter(exercise -> "Gym".equals(exercise.getPlace()))
                    .count();

            Toast.makeText(ExercisesActivity_0_0.this, "Available " + count + " Gym exercises", Toast.LENGTH_SHORT).show();
        } else if (menu_id == R.id.se_me_item3) {
            muscleGroupItems = (ArrayList<ExercisesItem>) muscleGroupItems.stream()
                    .filter(exercise -> "Home".equals(exercise.getPlace()))
                    .collect(Collectors.toList());

            long count = muscleGroupItems.stream()
                    .filter(exercise -> "Home".equals(exercise.getPlace()))
                    .count();

            Toast.makeText(ExercisesActivity_0_0.this, "Available " + count + " Home exercises", Toast.LENGTH_SHORT).show();
        }

        muscleGroupAdapter.setExercisesItems(muscleGroupItems);

        muscleGroupItems = originalMuscleGroupItems;

        //return super.onOptionsItemSelected(item);
        return true;
    }

    @Override
    public void onItemClick(int position) {

        ExercisesItem exercisesItem = muscleGroupItems.get(position);
        Intent intent = new Intent(ExercisesActivity_0_0.this, OneExerciseActivity_0_0_0.class);
        intent.putExtra("ExercisesItem", exercisesItem);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(intent);
    }
}