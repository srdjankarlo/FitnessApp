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
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Chest 0"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Chest 1"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Chest 2"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Chest 3"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Chest 4"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Chest 5"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Chest 6"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Chest 7"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Chest 8"));
        chest_exercises.add(new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise),"Chest 9"));
        chest_exercise_counter = 10;

        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Shoulders 0"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Shoulders 1"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Shoulders 2"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Shoulders 3"));
        shoulder_exercises.add(new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Shoulders 4"));
        shoulder_exercise_counter = 5;

        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Biceps 0"));
        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Biceps 1"));
        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Biceps 2"));
        biceps_exercises.add(new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Biceps 3"));
        biceps_exercise_counter = 4;

        triceps_exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise), "Triceps 0"));
        triceps_exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise), "Triceps 1"));
        triceps_exercises.add(new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise), "Triceps 2"));
        triceps_exercise_counter = 3;

        forearms_exercises.add(new ExercisesItem(R.drawable.forearms, getString(R.string.forearms_exercise), "Forearms 0"));
        forearms_exercises.add(new ExercisesItem(R.drawable.forearms, getString(R.string.forearms_exercise), "Forearms 1"));
        forearms_exercise_counter = 2;

        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Back 0"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Back 1"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Back 2"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Back 3"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Back 4"));
        back_exercises.add(new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Back 5"));
        back_exercise_counter = 6;

        abs_exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Abs 0"));
        abs_exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Abs 1"));
        abs_exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Abs 2"));
        abs_exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Abs 3"));
        abs_exercises.add(new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Abs 4"));
        abs_exercise_counter = 5;

        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Legs 0"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Legs 1"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Legs 2"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Legs 3"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Legs 4"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Legs 5"));
        legs_exercises.add(new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Legs 6"));
        legs_exercise_counter = 7;

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