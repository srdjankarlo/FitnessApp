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


    // create array list to populate recycler view
    ArrayList<MuscleGroupsItem> RecViewItems = new ArrayList<>(),
            category = new ArrayList<>();
    ArrayList<ExercisesItem> exercises = new ArrayList<>();
    ArrayList<ExercisesItem> chest_exercises, shoulder_exercises, biceps_exercises,
            triceps_exercises, forearms_exercises, back_exercises, abs_exercises, quads_exercises,
            hamstrings_exercises, glutes_exercises, calves_exercises;

    int num_chest_exercises, num_shoulder_exercises, num_biceps_exercises, num_triceps_exercises,
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

        // fill lists with items for exercises
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Push-Ups"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest", "Triceps"),"Close Grip Push-Ups"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Wide Grip Push-Ups"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Decline Push-Ups"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Incline Push-Ups"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest", "Triceps"),"Parallel Bar Dips"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Bench Press"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Incline Press"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Decline Press"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Dumbbell Press"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Incline Dumbbell Press"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Decline Dumbbell Press"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Dumbbell Flys"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Incline Dumbbell Flys"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Decline Dumbbell Flys"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Cable Crossover Flys"));
        exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), Arrays.asList("Chest"),"Peck Deck Flys"));
        chest_exercise_counter = 17;

        exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), Arrays.asList("Shoulders"), "Lateral Raises"));
        exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), Arrays.asList("Shoulders"), "Bent-Over Lateral Raise"));
        exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), Arrays.asList("Shoulders"), "Standing Back Presses"));
        exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), Arrays.asList("Shoulders"), "Standing Front Presses"));
        exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), Arrays.asList("Shoulders"), "Sitting Back Presses"));
        exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), Arrays.asList("Shoulders"), "Sitting Front Presses"));
        exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), Arrays.asList("Shoulders"), "Standing Dumbbell Presses"));
        exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), Arrays.asList("Shoulders"), "Sitting Dumbbell Presses"));
        exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), Arrays.asList("Shoulders"), "Upright Rows"));
        exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), Arrays.asList("Shoulders", "Back"), "Peck Deck Rear-Delt Flys"));
        exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), Arrays.asList("Shoulders"), "Front Weight Raise"));
        shoulder_exercise_counter = 11;

        exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), Arrays.asList("Biceps"), "Synchronized Dumbbell Curls"));
        exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), Arrays.asList("Biceps", "Forearms"), "Synchronized Hammer Curls"));
        exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), Arrays.asList("Biceps", "Forearms"), "Synchronized Reverse Dumbbell Curls"));
        exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), Arrays.asList("Biceps"), "Asynchronous Dumbbell Curls"));
        exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), Arrays.asList("Biceps", "Forearms"), "Asynchronous Hammer Curls"));
        exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), Arrays.asList("Biceps", "Forearms"), "Asynchronous Reverse Dumbbell Curls"));
        exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), Arrays.asList("Biceps"), "Barbell Curls"));
        exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), Arrays.asList("Biceps", "Forearms"), "Reverse Barbell Curls"));
        exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), Arrays.asList("Biceps"), "EZ-Bar Curls"));
        exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), Arrays.asList("Biceps", "Forearms"), "Reverse EZ-Bar Curls"));
        biceps_exercise_counter = 10;

        exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise),Arrays.asList("Triceps"), "Push-Downs"));
        exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise),Arrays.asList("Triceps"), "Cable Push-Downs"));
        exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise),Arrays.asList("Triceps"), "Reverse Push-Downs"));
        //exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise),Arrays.asList("Triceps"), "Parallel Bar Dips")); // this is also for chest, think somehow to connect the two
        //exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise),Arrays.asList("Triceps"), "Close Grip Push-Ups")); // this is also for chest, think somehow to connect the two
        exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise),Arrays.asList("Triceps"), "Triceps Dips"));
        exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise),Arrays.asList("Triceps"), "Dumbbell Kickbacks"));
        triceps_exercise_counter = 7;

        exercises.add(new ExercisesItem(R.drawable.forearms, getString(R.string.forearms_exercise), Arrays.asList("Forearms"), "Barbel Wrist Curls"));
        exercises.add(new ExercisesItem(R.drawable.forearms, getString(R.string.forearms_exercise), Arrays.asList("Forearms"), "Dumbbell Wrist Curls"));
        exercises.add(new ExercisesItem(R.drawable.forearms, getString(R.string.forearms_exercise), Arrays.asList("Forearms"), "Dumbbell Wrist Twist"));
        // ToDo: these are also for biceps exercises, think somehow to connect them
        //exercises.add(new ExercisesItem(R.drawable.forearms,getString(R.string.forearms_exercise), "Synchronized Hammer Curls"));
        //exercises.add(new ExercisesItem(R.drawable.forearms,getString(R.string.forearms_exercise), "Synchronized Reverse Dumbbell Curls"));
        //exercises.add(new ExercisesItem(R.drawable.forearms,getString(R.string.forearms_exercise), "Asynchronous Hammer Curls"));
        //exercises.add(new ExercisesItem(R.drawable.forearms,getString(R.string.forearms_exercise), "Asynchronous Reverse Dumbbell Curls"));
        forearms_exercise_counter = 7;

        exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), Arrays.asList("Back"), "Chin-Ups"));
        exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), Arrays.asList("Back", "Biceps"), "Reverse Chin-Ups"));
        exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), Arrays.asList("Back"), "Deadlifts"));
        exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), Arrays.asList("Back"), "Barbell Bent Over Row"));
        exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), Arrays.asList("Back"), "Dumbell Bent Over Row"));
        exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), Arrays.asList("Back"), "T-Bar Bent Over Row"));
        exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), Arrays.asList("Back"), "Dumbbell Shrugs"));
        exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), Arrays.asList("Back"), "Barbell Shrugs"));
        exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), Arrays.asList("Back"), "Back Extensions"));
        back_exercise_counter = 9;

        exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), Arrays.asList("Abs"),"Incline Bench Sit-Ups"));
        exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), Arrays.asList("Abs"),"Sit-Ups"));
        exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), Arrays.asList("Abs"),"Crunches"));
        exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), Arrays.asList("Abs"),"Leg Raises"));
        exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), Arrays.asList("Abs"),"Hanging Leg Raises"));
        exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), Arrays.asList("Abs"),"Parallel Bar Leg Raises"));
        abs_exercise_counter = 6;

        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs"), "Leg Extensions"));
        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs"), "Squats"));
        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs"), "Dumbbell Squats"));
        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs"), "Barbell Squats"));
        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs"), "Lunges"));
        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs"), "Dumbbell Lunges"));
        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs"), "Barbell Lunges"));
        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs"), "Bench Jump"));
        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs", "Glutes", "Hamstrings"), "Good Mornings"));
        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs"), "Single Leg Squats"));
        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs"), "Open Jump"));
        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs", "Hamstrings"), "Leg Curls"));
        exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), Arrays.asList("Legs"), "Hip Thrust"));
        legs_exercise_counter = 13;
        // ToDo: separate legs into calfs, glutes, hamstrings, quads and what else

        // Filter the exercises to get only those of type "Forearms"
        chest_exercises = (ArrayList<ExercisesItem>) exercises.stream().filter(exercise -> exercise.getCategories().contains("Chest")).collect(Collectors.toList());
        shoulder_exercises = (ArrayList<ExercisesItem>) exercises.stream().filter(exercise -> exercise.getCategories().contains("Shoulders")).collect(Collectors.toList());;
        biceps_exercises = (ArrayList<ExercisesItem>) exercises.stream().filter(exercise -> exercise.getCategories().contains("Biceps")).collect(Collectors.toList());;
        triceps_exercises = (ArrayList<ExercisesItem>) exercises.stream().filter(exercise -> exercise.getCategories().contains("Triceps")).collect(Collectors.toList());;
        forearms_exercises = (ArrayList<ExercisesItem>) exercises.stream().filter(exercise -> exercise.getCategories().contains("Forearms")).collect(Collectors.toList());;
        back_exercises = (ArrayList<ExercisesItem>) exercises.stream().filter(exercise -> exercise.getCategories().contains("Back")).collect(Collectors.toList());;
        abs_exercises = (ArrayList<ExercisesItem>) exercises.stream().filter(exercise -> exercise.getCategories().contains("Abs")).collect(Collectors.toList());;
        quads_exercises = (ArrayList<ExercisesItem>) exercises.stream().filter(exercise -> exercise.getCategories().contains("Quads")).collect(Collectors.toList());;
        hamstrings_exercises = (ArrayList<ExercisesItem>) exercises.stream().filter(exercise -> exercise.getCategories().contains("Hamstrings")).collect(Collectors.toList());;
        glutes_exercises = (ArrayList<ExercisesItem>) exercises.stream().filter(exercise -> exercise.getCategories().contains("Glutes")).collect(Collectors.toList());;
        calves_exercises = (ArrayList<ExercisesItem>) exercises.stream().filter(exercise -> exercise.getCategories().contains("Calves")).collect(Collectors.toList());;

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

        // ToDo: add Category (List: MuslceGroup) attribute to the constructor so you can have all exercises in one place (list) and show those only for what category you want
        category.add(new MuscleGroupsItem(R.drawable.chest, getString(R.string.chest_exercise), String.valueOf(num_chest_exercises) + " exercises"));
        category.add(new MuscleGroupsItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), String.valueOf(num_shoulder_exercises) + " exercises"));
        category.add(new MuscleGroupsItem(R.drawable.biceps, getString(R.string.biceps_exercise), String.valueOf(num_biceps_exercises) + " exercises"));
        category.add(new MuscleGroupsItem(R.drawable.triceps, getString(R.string.triceps_exercise), String.valueOf(num_triceps_exercises) + " exercises"));
        category.add(new MuscleGroupsItem(R.drawable.forearms, getString(R.string.forearms_exercise), String.valueOf(num_forearms_exercises) + " exercises"));
        category.add(new MuscleGroupsItem(R.drawable.back, getString(R.string.back_exercise), String.valueOf(num_back_exercises) + " exercises"));
        category.add(new MuscleGroupsItem(R.drawable.abs, getString(R.string.abs_exercise), String.valueOf(num_abs_exercises) + " exercises"));
        category.add(new MuscleGroupsItem(R.drawable.quads, getString(R.string.quads_exercise), String.valueOf(num_quads_exercises) + " exercises"));
        category.add(new MuscleGroupsItem(R.drawable.hamstrings, getString(R.string.hamstrings_exercise), String.valueOf(num_hamstrings_exercises) + " exercises"));
        category.add(new MuscleGroupsItem(R.drawable.glutes, getString(R.string.glutes_exercise), String.valueOf(num_glutes_exercises) + " exercises"));
        category.add(new MuscleGroupsItem(R.drawable.calves, getString(R.string.calves_exercise), String.valueOf(num_calves_exercises) + " exercises"));

        // put exercises to show first
        RecViewItems = category;

        // get the recycler view in order to manipulate it
        MainMenu_RecView = findViewById(R.id.ac_mu_groups_RecView);

        // set the adapter for recycler view and show items in it
        //MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
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
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle("Main menu: " + getString(R.string.menu_item_diet));
            //RecViewItems = diet;
            Intent intent = new Intent(getApplicationContext(), DietActivity_0_1.class);
            //intent.putParcelableArrayListExtra("RecViewItemsList", diet);
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
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", chest_exercises);
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.shoulders_exercise))) {
            if(num_shoulder_exercises == 0){
                Toast.makeText(this, "No shoulders exercises", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", shoulder_exercises);
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.biceps_exercise))) {
            if(num_biceps_exercises == 0){
                Toast.makeText(this, "No biceps exercises", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", biceps_exercises);
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.triceps_exercise))) {
            if(num_triceps_exercises == 0){
                Toast.makeText(this, "No triceps exercises", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", triceps_exercises);
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.forearms_exercise))) {
            if(num_forearms_exercises == 0){
                Toast.makeText(this, "No forearms exercises", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", forearms_exercises);
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.back_exercise))) {
            if(num_back_exercises == 0){
                Toast.makeText(this, "No back exercises", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", back_exercises);
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.abs_exercise))) {
            if(num_abs_exercises == 0){
                Toast.makeText(this, "No abs exercises", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", abs_exercises);
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.quads_exercise))) {
            if(num_quads_exercises == 0){
                Toast.makeText(this, "No quads exercises", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", quads_exercises);
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.hamstrings_exercise))) {
            if(num_hamstrings_exercises == 0){
                Toast.makeText(this, "No hamstrings exercises", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", hamstrings_exercises);
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.glutes_exercise))) {
            if(num_glutes_exercises == 0){
                Toast.makeText(this, "No glutes exercises", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", glutes_exercises);
                startActivity(intent);
            }
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.calves_exercise))) {
            if(num_calves_exercises == 0){
                Toast.makeText(this, "No calves exercises", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
                intent.putParcelableArrayListExtra("RecViewItemsList", calves_exercises);
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