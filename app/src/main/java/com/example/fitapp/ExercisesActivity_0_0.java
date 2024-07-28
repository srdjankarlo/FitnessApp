package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
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

public class ExercisesActivity_0_0 extends MuscleGroupsActivity_0 implements ExercisesInterface {

    ArrayList<ExercisesItem> muscleGroupItems = new ArrayList<>();
    ExercisesAdapter muscleGroupAdapter = new ExercisesAdapter(this, this);
    RecyclerView recyclerView;
    List<String> muscleGroupCategory;
    String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get data from previous activity
        Intent intent = getIntent();
        muscleGroupItems = intent.getParcelableArrayListExtra("RecViewItemsList");

        // get the type of the item
        muscleGroupCategory = muscleGroupItems.get(0).getCategories();
        categoryName = muscleGroupCategory.get(0);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Returning false here hides the menu
        return false;
    }

    @Override
    public void onItemClick(int position) {

        ExercisesItem exercisesItem = muscleGroupItems.get(position);
        Intent intent = new Intent(ExercisesActivity_0_0.this, OneExerciseActivity_0_0_0.class);
        intent.putExtra("ExercisesItem", exercisesItem);
        startActivity(intent);
    }
}