package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Objects;

public class ExercisesActivity_0_0 extends MuscleGroupsActivity_0 implements ExercisesInterface {

    ArrayList<ExercisesItem> muscleGroupItems = new ArrayList<>();
    ExercisesAdapter muscleGroupAdapter = new ExercisesAdapter(this, this);
    ExercisesItem muscleGroupItem;
    RecyclerView recyclerView;
    String muscleGroupName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ToDo: make all exercises for each muscle group

        // get data from previous activity
        Intent intent = getIntent();
        muscleGroupItems = intent.getParcelableArrayListExtra("RecViewItemsList");

        // get the type of the item
        muscleGroupName = muscleGroupItems.get(0).getMuscleGroup();
        //muscleGroupName = muscleGroupName.split(" ")[0];

        // set layout
        setContentView(R.layout.activity_exercises);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle(muscleGroupName + " exercises");

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

        // ToDo: make database for added exercises also, do that in Activity_0, storing exercises in Activity_0 and adding exercises here in this activity

        //// Get the OnBackPressedDispatcher
        //OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        //
        //// Register the callback
        //onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
        //    @Override
        //    public void handleOnBackPressed() {
        //        // Your custom logic here
        //        //Toast.makeText(getApplicationContext(), "Back button pressed!", Toast.LENGTH_SHORT).show();
        //
        //        // If you want to handle the back press, do not call super.onBackPressed()
        //        // If you want the default behavior, you can finish the activity or call super
        //        // finish(); // Optionally finish the activity
        //        Intent intent = new Intent(getApplicationContext(), MainMenuActivity_0.class);
        //        startActivity(intent);
        //    }
        //});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.exercises_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.ex_me_item1:
                //ToDo: make database to store exercises and tidy this up a bit
                if (Objects.equals(muscleGroupName, getString(R.string.chest_exercise))){
                    muscleGroupItem = new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), "Chest " + chest_exercise_counter);
                    chest_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(chest_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    chest_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.shoulders_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Shoulders " + shoulder_exercise_counter);
                    shoulder_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(shoulder_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    shoulder_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.biceps_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Biceps " + biceps_exercise_counter);
                    biceps_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(biceps_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    biceps_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.triceps_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise), "Triceps " + triceps_exercise_counter);
                    triceps_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(triceps_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    triceps_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.forearms_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.forearms, getString(R.string.forearms_exercise), "Forearms " + forearms_exercise_counter);
                    forearms_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(forearms_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    forearms_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.back_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Back " + back_exercise_counter);
                    back_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(back_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    back_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.abs_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Abs " + abs_exercise_counter);
                    abs_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(abs_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    abs_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.legs_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Legs " + legs_exercise_counter);
                    legs_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(legs_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    legs_exercise_counter += 1;
                }


                //Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
                //return true;

            //case R.id.action_about:
            //    Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
            //    return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(int position) {

        //MainMenuRecViewItem exercise = item_list.get(position);
        String exercise_name = muscleGroupItems.get(position).getExerciseName();
        ExercisesItem exercisesItem = muscleGroupItems.get(position);

        Intent intent = new Intent(this, OneExerciseActivity_0_0_0.class);
        //intent.putExtra("ExercisesName", exercise_name);
        intent.putExtra("ExercisesItem", exercisesItem);
        startActivity(intent);
    }
}