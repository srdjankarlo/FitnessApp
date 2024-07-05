package com.example.fitapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MuscleGroupsActivity_0 extends AppCompatActivity implements MuscleGroupsInterface {

    int id;
    int chest_exercise_counter;
    int shoulder_exercise_counter;
    int biceps_exercise_counter;
    int triceps_exercise_counter;
    int forearms_exercise_counter;
    int back_exercise_counter;
    int abs_exercise_counter;
    int legs_exercise_counter;
    RecyclerView MainMenu_RecView;

    MuscleGroupsAdapter adapter = new MuscleGroupsAdapter(this, this);

    ExercisesViewModel viewModel;

    // create array list to populate recycler view
    ArrayList<MuscleGroupsItem> RecViewItems = new ArrayList<>(),
            category = new ArrayList<>();
    List<ExercisesItem> exercises = new ArrayList<>();
    List<ExercisesItem> chest_exercises, shoulder_exercises, biceps_exercises,
            triceps_exercises, forearms_exercises, back_exercises, abs_exercises, quads_exercises,
            hamstrings_exercises, glutes_exercises, calves_exercises;

    public int num_chest_exercises, num_shoulder_exercises, num_biceps_exercises, num_triceps_exercises,
            num_forearms_exercises, num_back_exercises, num_abs_exercises, num_quads_exercises,
            num_hamstrings_exercises, num_glutes_exercises, num_calves_exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the activity layout
        setContentView(R.layout.activity_muscle_groups);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Main menu: " +  getString(R.string.menu_item_exercises));

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        bar.setBackgroundDrawable(color);

        //// fill lists with items for exercises
        //exercises.add(new ExercisesItem(R.drawable.chest, "Push-Ups", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Close Grip Push-Ups", Arrays.asList("Chest", "Triceps")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Wide Grip Push-Ups", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Decline Push-Ups", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Incline Push-Ups", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Parallel Bar Dips", Arrays.asList("Chest", "Triceps")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Bench Press", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Incline Press", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Decline Press", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Dumbbell Press", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Incline Dumbbell Press", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Decline Dumbbell Press", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Dumbbell Flys", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Incline Dumbbell Flys", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Decline Dumbbell Flys", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Cable Crossover Flys", Arrays.asList("Chest")));
        //exercises.add(new ExercisesItem(R.drawable.chest, "Peck Deck Flys", Arrays.asList("Chest")));
        //
        //exercises.add(new ExercisesItem(R.drawable.shoulders, "Lateral Raises", Arrays.asList("Shoulders")));
        //exercises.add(new ExercisesItem(R.drawable.shoulders, "Bent-Over Lateral Raise", Arrays.asList("Shoulders")));
        //exercises.add(new ExercisesItem(R.drawable.shoulders, "Standing Back Presses", Arrays.asList("Shoulders")));
        //exercises.add(new ExercisesItem(R.drawable.shoulders, "Standing Front Presses", Arrays.asList("Shoulders")));
        //exercises.add(new ExercisesItem(R.drawable.shoulders, "Sitting Back Presses", Arrays.asList("Shoulders")));
        //exercises.add(new ExercisesItem(R.drawable.shoulders, "Sitting Front Presses", Arrays.asList("Shoulders")));
        //exercises.add(new ExercisesItem(R.drawable.shoulders, "Standing Dumbbell Presses", Arrays.asList("Shoulders")));
        //exercises.add(new ExercisesItem(R.drawable.shoulders, "Sitting Dumbbell Presses", Arrays.asList("Shoulders")));
        //exercises.add(new ExercisesItem(R.drawable.shoulders, "Upright Rows", Arrays.asList("Shoulders")));
        //exercises.add(new ExercisesItem(R.drawable.shoulders, "Peck Deck Rear-Delt Flys", Arrays.asList("Shoulders", "Back")));
        //exercises.add(new ExercisesItem(R.drawable.shoulders, "Front Weight Raise", Arrays.asList("Shoulders")));
        //
        //exercises.add(new ExercisesItem(R.drawable.biceps, "Synchronized Dumbbell Curls", Arrays.asList("Biceps")));
        //exercises.add(new ExercisesItem(R.drawable.biceps, "Synchronized Hammer Curls", Arrays.asList("Biceps", "Forearms")));
        //exercises.add(new ExercisesItem(R.drawable.biceps, "Synchronized Reverse Dumbbell Curls", Arrays.asList("Biceps", "Forearms")));
        //exercises.add(new ExercisesItem(R.drawable.biceps, "Asynchronous Dumbbell Curls", Arrays.asList("Biceps")));
        //exercises.add(new ExercisesItem(R.drawable.biceps, "Asynchronous Hammer Curls", Arrays.asList("Biceps", "Forearms")));
        //exercises.add(new ExercisesItem(R.drawable.biceps, "Asynchronous Reverse Dumbbell Curls", Arrays.asList("Biceps", "Forearms")));
        //exercises.add(new ExercisesItem(R.drawable.biceps, "Barbell Curls", Arrays.asList("Biceps")));
        //exercises.add(new ExercisesItem(R.drawable.biceps, "Reverse Barbell Curls", Arrays.asList("Biceps", "Forearms")));
        //exercises.add(new ExercisesItem(R.drawable.biceps, "EZ-Bar Curls", Arrays.asList("Biceps")));
        //exercises.add(new ExercisesItem(R.drawable.biceps, "Reverse EZ-Bar Curls", Arrays.asList("Biceps", "Forearms")));
        //
        //exercises.add(new ExercisesItem(R.drawable.triceps, "Push-Downs", Arrays.asList("Triceps")));
        //exercises.add(new ExercisesItem(R.drawable.triceps, "Cable Push-Downs", Arrays.asList("Triceps")));
        //exercises.add(new ExercisesItem(R.drawable.triceps, "Reverse Push-Downs", Arrays.asList("Triceps")));
        //exercises.add(new ExercisesItem(R.drawable.triceps, "Triceps Dips", Arrays.asList("Triceps")));
        //exercises.add(new ExercisesItem(R.drawable.triceps, "Dumbbell Kickbacks", Arrays.asList("Triceps")));
        //
        //exercises.add(new ExercisesItem(R.drawable.forearms, "Barbel Wrist Curls", Arrays.asList("Forearms")));
        //exercises.add(new ExercisesItem(R.drawable.forearms, "Dumbbell Wrist Curls", Arrays.asList("Forearms")));
        //exercises.add(new ExercisesItem(R.drawable.forearms, "Dumbbell Wrist Twist", Arrays.asList("Forearms")));
        //
        //exercises.add(new ExercisesItem(R.drawable.back, "Chin-Ups", Arrays.asList("Back")));
        //exercises.add(new ExercisesItem(R.drawable.back, "Reverse Chin-Ups", Arrays.asList("Back", "Biceps")));
        //exercises.add(new ExercisesItem(R.drawable.back, "Deadlifts", Arrays.asList("Back")));
        //exercises.add(new ExercisesItem(R.drawable.back, "Barbell Bent Over Row", Arrays.asList("Back")));
        //exercises.add(new ExercisesItem(R.drawable.back, "Dumbell Bent Over Row", Arrays.asList("Back")));
        //exercises.add(new ExercisesItem(R.drawable.back, "T-Bar Bent Over Row", Arrays.asList("Back")));
        //exercises.add(new ExercisesItem(R.drawable.back, "Dumbbell Shrugs", Arrays.asList("Back")));
        //exercises.add(new ExercisesItem(R.drawable.back, "Barbell Shrugs", Arrays.asList("Back")));
        //exercises.add(new ExercisesItem(R.drawable.back, "Back Extensions", Arrays.asList("Back")));
        //
        //exercises.add(new ExercisesItem(R.drawable.abs, "Incline Bench Sit-Ups", Arrays.asList("Abs")));
        //exercises.add(new ExercisesItem(R.drawable.abs, "Sit-Ups", Arrays.asList("Abs")));
        //exercises.add(new ExercisesItem(R.drawable.abs, "Crunches", Arrays.asList("Abs")));
        //exercises.add(new ExercisesItem(R.drawable.abs, "Leg Raises", Arrays.asList("Abs")));
        //exercises.add(new ExercisesItem(R.drawable.abs, "Hanging Leg Raises", Arrays.asList("Abs")));
        //exercises.add(new ExercisesItem(R.drawable.abs, "Parallel Bar Leg Raises", Arrays.asList("Abs")));
        //
        //exercises.add(new ExercisesItem(R.drawable.quads, "Leg Extensions", Arrays.asList("Quads")));
        //exercises.add(new ExercisesItem(R.drawable.quads, "Squats", Arrays.asList("Quads", "Glutes")));
        //exercises.add(new ExercisesItem(R.drawable.quads, "Dumbbell Squats", Arrays.asList("Quads", "Glutes")));
        //exercises.add(new ExercisesItem(R.drawable.quads, "Barbell Squats", Arrays.asList("Quads", "Glutes")));
        //exercises.add(new ExercisesItem(R.drawable.quads, "Lunges", Arrays.asList("Quads")));
        //exercises.add(new ExercisesItem(R.drawable.quads, "Dumbbell Lunges", Arrays.asList("Quads")));
        //exercises.add(new ExercisesItem(R.drawable.quads, "Barbell Lunges", Arrays.asList("Quads")));
        //exercises.add(new ExercisesItem(R.drawable.quads, "Bench Jump", Arrays.asList("Quads", "Hamstrings")));
        //exercises.add(new ExercisesItem(R.drawable.glutes, "Good Mornings", Arrays.asList("Glutes", "Hamstrings")));
        //exercises.add(new ExercisesItem(R.drawable.quads, "Single Leg Squats", Arrays.asList("Quads")));
        //exercises.add(new ExercisesItem(R.drawable.quads, "Open Jump", Arrays.asList("Quads")));
        //exercises.add(new ExercisesItem(R.drawable.hamstrings, "Leg Curls", Arrays.asList("Hamstrings", "Calves")));
        //exercises.add(new ExercisesItem(R.drawable.glutes, "Hip Thrust", Arrays.asList("Glutes", "Hamstrings")));
        // instead of all that do this
        viewModel = new ViewModelProvider(this).get(ExercisesViewModel.class);
        viewModel.inserInitialData();

        // Filter the exercises to get only those of wanted category
        // ToDo: figure out how to get all exercises from view model
        //// Fetch and observe exercises by category
        //viewModel.getExercisesByCategory("Chest").observe(this, new Observer<List<ExercisesItem>>() {
        //    @Override
        //    public void onChanged(List<ExercisesItem> exercisesItems) {
        //        // Update UI with exercisesItems
        //        for (ExercisesItem item : exercisesItems) {
        //            System.out.println(item.getExerciseName());
        //        }
        //    }
        //});

        // Fetch and observe exercises by category

        viewModel.getAllExercisesData().observe(this, new Observer<List<ExercisesItem>>() {
            @Override
            public void onChanged(List<ExercisesItem> exercisesItems) {
                // Update UI with exercisesItems
                exercises.clear();
                exercises.addAll(exercisesItems);

                chest_exercises = exercises.stream().filter(exercise -> exercise.getCategories().contains("Chest")).collect(Collectors.toList());
                shoulder_exercises = exercises.stream().filter(exercise -> exercise.getCategories().contains("Shoulders")).collect(Collectors.toList());;
                biceps_exercises = exercises.stream().filter(exercise -> exercise.getCategories().contains("Biceps")).collect(Collectors.toList());;
                triceps_exercises = exercises.stream().filter(exercise -> exercise.getCategories().contains("Triceps")).collect(Collectors.toList());;
                forearms_exercises = exercises.stream().filter(exercise -> exercise.getCategories().contains("Forearms")).collect(Collectors.toList());;
                back_exercises = exercises.stream().filter(exercise -> exercise.getCategories().contains("Back")).collect(Collectors.toList());;
                abs_exercises = exercises.stream().filter(exercise -> exercise.getCategories().contains("Abs")).collect(Collectors.toList());;
                quads_exercises = exercises.stream().filter(exercise -> exercise.getCategories().contains("Quads")).collect(Collectors.toList());;
                hamstrings_exercises = exercises.stream().filter(exercise -> exercise.getCategories().contains("Hamstrings")).collect(Collectors.toList());;
                glutes_exercises = exercises.stream().filter(exercise -> exercise.getCategories().contains("Glutes")).collect(Collectors.toList());;
                calves_exercises = exercises.stream().filter(exercise -> exercise.getCategories().contains("Calves")).collect(Collectors.toList());;

                num_chest_exercises = (int) exercises.stream().filter(exercise -> exercise.getCategories().contains("Chest")).count();
                num_shoulder_exercises = (int) exercises.stream().filter(exercise -> exercise.getCategories().contains("Shoulders")).count();
                num_biceps_exercises = (int) exercises.stream().filter(exercise -> exercise.getCategories().contains("Biceps")).count();
                num_triceps_exercises = (int) exercises.stream().filter(exercise -> exercise.getCategories().contains("Triceps")).count();
                num_forearms_exercises = (int) exercises.stream().filter(exercise -> exercise.getCategories().contains("Forearms")).count();
                num_back_exercises = (int) exercises.stream().filter(exercise -> exercise.getCategories().contains("Back")).count();
                num_abs_exercises = (int) exercises.stream().filter(exercise -> exercise.getCategories().contains("Abs")).count();
                num_quads_exercises = (int) exercises.stream().filter(exercise -> exercise.getCategories().contains("Quads")).count();
                num_hamstrings_exercises = (int) exercises.stream().filter(exercise -> exercise.getCategories().contains("Hamstrings")).count();
                num_glutes_exercises = (int) exercises.stream().filter(exercise -> exercise.getCategories().contains("Glutes")).count();
                num_calves_exercises = (int) exercises.stream().filter(exercise -> exercise.getCategories().contains("Calves")).count();
            }
        });

        category.add(new MuscleGroupsItem(R.drawable.chest, getString(R.string.chest_exercise)));
        category.add(new MuscleGroupsItem(R.drawable.shoulders, getString(R.string.shoulders_exercise)));
        category.add(new MuscleGroupsItem(R.drawable.biceps, getString(R.string.biceps_exercise)));
        category.add(new MuscleGroupsItem(R.drawable.triceps, getString(R.string.triceps_exercise)));
        category.add(new MuscleGroupsItem(R.drawable.forearms, getString(R.string.forearms_exercise)));
        category.add(new MuscleGroupsItem(R.drawable.back, getString(R.string.back_exercise)));
        category.add(new MuscleGroupsItem(R.drawable.abs, getString(R.string.abs_exercise)));
        category.add(new MuscleGroupsItem(R.drawable.quads, getString(R.string.quads_exercise)));
        category.add(new MuscleGroupsItem(R.drawable.hamstrings, getString(R.string.hamstrings_exercise)));
        category.add(new MuscleGroupsItem(R.drawable.glutes, getString(R.string.glutes_exercise)));
        category.add(new MuscleGroupsItem(R.drawable.calves, getString(R.string.calves_exercise)));

        // put exercises to show first
        RecViewItems = category;

        // get the recycler view in order to manipulate it
        MainMenu_RecView = findViewById(R.id.ac_mu_groups_RecView);

        // set the adapter for recycler view and show items in it
        adapter.setMuscleGroupsItems(RecViewItems);
        MainMenu_RecView.setAdapter(adapter);
        MainMenu_RecView.setLayoutManager(new LinearLayoutManager(this));

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
        //        finish(); // Optionally finish the activity
        //    }
        //});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // get the id of clicked menu item
        id = item.getItemId();
        if (id == R.id.id_ma_me_item_exercises){
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle("Main menu: " + getString(R.string.menu_item_exercises));
            RecViewItems = category;

        } else if (id == R.id.id_ma_me_item_diet) {
            // diet activity doesnt need any data from main activity
            Intent intent = new Intent(getApplicationContext(), DietActivity_0_1.class);
            startActivity(intent);

        } else if (id == R.id.id_ma_me_item_my_workouts){
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle("Main menu: " + getString(R.string.menu_item_my_workouts));
            //RecViewItems = item_list;

        } else if (id == R.id.id_ma_me_item_progress) {
            // ToDo: add progress to exercises or something
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle("Main menu: " + getString(R.string.menu_item_progress));
            //RecViewItems = item_list;

        } else return true;  // this will leave activity_main layout if nothing was selected in menu

        //// set the adapter for recycler view and show items in it
        //MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
        adapter.setMuscleGroupsItems(RecViewItems);
        MainMenu_RecView.setAdapter(adapter);
        MainMenu_RecView.setLayoutManager(new LinearLayoutManager(this));

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {

        // for exercises
        if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.chest_exercise))){
            if(num_chest_exercises == 0){
                Toast.makeText(this, "No chest exercises", Toast.LENGTH_SHORT).show();
            } else {
                // ToDo: figure out how to show num of exercises in muscle_groups_item.xml instead of a Toast
                Toast.makeText(this, "Available " + num_chest_exercises + " chest exercises", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", new ArrayList<>(chest_exercises));
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.shoulders_exercise))) {
            if(num_shoulder_exercises == 0){
                Toast.makeText(this, "No shoulders exercises", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Available " + num_shoulder_exercises + " shoulders exercises", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", new ArrayList<>(shoulder_exercises));
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.biceps_exercise))) {
            if(num_biceps_exercises == 0){
                Toast.makeText(this, "No biceps exercises", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Available " + num_biceps_exercises + " biceps exercises", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", new ArrayList<>(biceps_exercises));
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.triceps_exercise))) {
            if(num_triceps_exercises == 0){
                Toast.makeText(this, "No triceps exercises", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Available " + num_triceps_exercises + " triceps exercises", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", new ArrayList<>(triceps_exercises));
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.forearms_exercise))) {
            if(num_forearms_exercises == 0){
                Toast.makeText(this, "No forearms exercises", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Available " + num_forearms_exercises + " forearms exercises", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", new ArrayList<>(forearms_exercises));
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.back_exercise))) {
            if(num_back_exercises == 0){
                Toast.makeText(this, "No back exercises", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Available " + num_back_exercises + " back exercises", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", new ArrayList<>(back_exercises));
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.abs_exercise))) {
            if(num_abs_exercises == 0){
                Toast.makeText(this, "No abs exercises", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Available " + num_abs_exercises + " abs exercises", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", new ArrayList<>(abs_exercises));
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.quads_exercise))) {
            if(num_quads_exercises == 0){
                Toast.makeText(this, "No quads exercises", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Available " + num_quads_exercises + " quads exercises", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", new ArrayList<>(quads_exercises));
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.hamstrings_exercise))) {
            if(num_hamstrings_exercises == 0){
                Toast.makeText(this, "No hamstrings exercises", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Available " + num_hamstrings_exercises + " hamstrings exercises", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", new ArrayList<>(hamstrings_exercises));
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.glutes_exercise))) {
            if(num_glutes_exercises == 0){
                Toast.makeText(this, "No glutes exercises", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Available " + num_glutes_exercises + " glutes exercises", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", new ArrayList<>(glutes_exercises));
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.calves_exercise))) {
            if(num_calves_exercises == 0){
                Toast.makeText(this, "No calves exercises", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Available " + num_calves_exercises + " calves exercises", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", new ArrayList<>(calves_exercises));
                startActivity(intent);
            }
        }

    }

    // deprecated
    /*
    @Override
    public void onBackPressed() {
        // Your custom logic here
        Toast.makeText(this, "Back button pressed!", Toast.LENGTH_SHORT).show();

        // Call the super class method if you want to allow the default behavior
        // super.onBackPressed();
    }*/

}