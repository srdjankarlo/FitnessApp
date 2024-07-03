package com.example.fitapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

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
            exercises = new ArrayList<>();
    ArrayList<ExercisesItem> chest_exercises = new ArrayList<>(), shoulder_exercises = new ArrayList<>(),
            biceps_exercises = new ArrayList<>(), triceps_exercises = new ArrayList<>(),
            forearms_exercises = new ArrayList<>(), back_exercises = new ArrayList<>(),
            abs_exercises = new ArrayList<>(), legs_exercises = new ArrayList<>();

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
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Push-Ups"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Close Grip Push-Ups"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Wide Grip Push-Ups"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Decline Push-Ups"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Incline Push-Ups"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Parallel Bar Dips"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Bench Press"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Incline Press"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Decline Press"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Dumbbell Press"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Incline Dumbbell Press"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Decline Dumbbell Press"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Dumbbell Flys"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Incline Dumbbell Flys"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Decline Dumbbell Flys"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Cable Crossover Flys"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Peck Deck Flys"));
        chest_exercise_counter = 17;

        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Lateral Raises"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Bent-Over Lateral Raise"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Standing Back Presses"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Standing Front Presses"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Sitting Back Presses"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Sitting Front Presses"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Standing Dumbbell Presses"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Sitting Dumbbell Presses"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Upright Rows"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Peck Deck Rear-Delt Flys"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Front Weight Raise"));
        shoulder_exercise_counter = 11;

        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Synchronized Dumbbell Curls"));
        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Synchronized Hammer Curls"));
        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Synchronized Reverse Dumbbell Curls"));
        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Asynchronous Dumbbell Curls"));
        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Asynchronous Hammer Curls"));
        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Asynchronous Reverse Dumbbell Curls"));
        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Barbell Curls"));
        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Reverse Barbell Curls"));
        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "EZ-Bar Curls"));
        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Reverse EZ-Bar Curls"));
        biceps_exercise_counter = 10;

        triceps_exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise), "Push-Downs"));
        triceps_exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise), "Cable Push-Downs"));
        triceps_exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise), "Reverse Push-Downs"));
        triceps_exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise), "Parallel Bar Dips")); // this is also for chest, think somehow to connect the two
        triceps_exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise),"Close Grip Push-Ups")); // this is also for chest, think somehow to connect the two
        triceps_exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise), "Triceps Dips"));
        triceps_exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise), "Dumbbell Kickbacks"));
        triceps_exercise_counter = 7;

        forearms_exercises.add(new ExercisesItem(R.drawable.forearms, getString(R.string.forearms_exercise), "Barbel Wrist Curls"));
        forearms_exercises.add(new ExercisesItem(R.drawable.forearms, getString(R.string.forearms_exercise), "Dumbbell Wrist Curls"));
        forearms_exercises.add(new ExercisesItem(R.drawable.forearms, getString(R.string.forearms_exercise), "Dumbbell Wrist Twist"));
        // ToDo: these are also for biceps exercises, think somehow to connect them
        forearms_exercises.add(new ExercisesItem(R.drawable.forearms,getString(R.string.forearms_exercise), "Synchronized Hammer Curls"));
        forearms_exercises.add(new ExercisesItem(R.drawable.forearms,getString(R.string.forearms_exercise), "Synchronized Reverse Dumbbell Curls"));
        forearms_exercises.add(new ExercisesItem(R.drawable.forearms,getString(R.string.forearms_exercise), "Asynchronous Hammer Curls"));
        forearms_exercises.add(new ExercisesItem(R.drawable.forearms,getString(R.string.forearms_exercise), "Asynchronous Reverse Dumbbell Curls"));
        forearms_exercise_counter = 7;

        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Chin-Ups"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Reverse Chin-Ups"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Deadlifts"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Barbell Bent Over Row"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Dumbell Bent Over Row"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "T-Bar Bent Over Row"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Dumbbell Shrugs"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Barbell Shrugs"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Back Extensions"));
        back_exercise_counter = 9;

        abs_exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Incline Bench Sit-Ups"));
        abs_exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Sit-Ups"));
        abs_exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Crunches"));
        abs_exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Leg Raises"));
        abs_exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Hanging Leg Raises"));
        abs_exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Parallel Bar Leg Raises"));
        abs_exercise_counter = 6;

        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Leg Extensions"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Squats"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Dumbbell Squats"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Barbell Squats"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Lunges"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Dumbbell Lunges"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Barbell Lunges"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Bench Jump"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Good Mornings"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Single Leg Squats"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Open Jump"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Leg Curls"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Hip Thrust"));
        legs_exercise_counter = 13;
        // ToDo: separate legs into calfs, glutes, hamstrings, quads and what else

        // ToDo: add Category (List: MuslceGroup) attribute to the constructor so you can have all exercises in one place (list) and show those only for what category you want
        exercises.add(new MuscleGroupsItem(R.drawable.chest, getString(R.string.chest_exercise), String.valueOf(chest_exercises.size()) + " exercises"));
        exercises.add(new MuscleGroupsItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), String.valueOf(shoulder_exercises.size()) + " exercises"));
        exercises.add(new MuscleGroupsItem(R.drawable.biceps, getString(R.string.biceps_exercise), String.valueOf(biceps_exercises.size()) + " exercises"));
        exercises.add(new MuscleGroupsItem(R.drawable.triceps, getString(R.string.triceps_exercise), String.valueOf(triceps_exercises.size()) + " exercises"));
        exercises.add(new MuscleGroupsItem(R.drawable.forearms, getString(R.string.forearms_exercise), String.valueOf(forearms_exercises.size()) + " exercises"));
        exercises.add(new MuscleGroupsItem(R.drawable.back, getString(R.string.back_exercise), String.valueOf(back_exercises.size()) + " exercises"));
        exercises.add(new MuscleGroupsItem(R.drawable.abs, getString(R.string.abs_exercise), String.valueOf(abs_exercises.size()) + " exercises"));
        exercises.add(new MuscleGroupsItem(R.drawable.legs, getString(R.string.legs_exercise), String.valueOf(legs_exercises.size()) + " exercises"));

        // put exercises to show first
        RecViewItems = exercises;

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
            RecViewItems = exercises;

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
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", chest_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.shoulders_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", shoulder_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.biceps_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", biceps_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.triceps_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", triceps_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.forearms_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", forearms_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.back_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", back_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.abs_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", abs_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getName(), getString(R.string.legs_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", legs_exercises);
            startActivity(intent);
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