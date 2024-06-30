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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class MainMenuActivity_0 extends DonateActivity implements MainMenuRecViewInterface {

    int id;
    int chest_exercise_counter;
    RecyclerView MainMenu_RecView;

    MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);


    // create array list to populate recycler view
    ArrayList<MainMenuRecViewItem> RecViewItems = new ArrayList<>(),
            exercises = new ArrayList<>(),
            chest_exercises = new ArrayList<>(), shoulder_exercises = new ArrayList<>(),
            biceps_exercises = new ArrayList<>(), triceps_exercises = new ArrayList<>(),
            forearms_exercises = new ArrayList<>(), back_exercises = new ArrayList<>(),
            abs_exercises = new ArrayList<>(), legs_exercises = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the activity layout
        setContentView(R.layout.activity_main_menu);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Main menu: " +  getString(R.string.menu_item_exercises));


        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        bar.setBackgroundDrawable(color);

        // fill lists with items for exercises
        chest_exercises.add(new MainMenuRecViewItem(R.drawable.chest, "Chest 0", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new MainMenuRecViewItem(R.drawable.chest, "Chest 1", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new MainMenuRecViewItem(R.drawable.chest, "Chest 2", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new MainMenuRecViewItem(R.drawable.chest, "Chest 3", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new MainMenuRecViewItem(R.drawable.chest, "Chest 4", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new MainMenuRecViewItem(R.drawable.chest, "Chest 5", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new MainMenuRecViewItem(R.drawable.chest, "Chest 6", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new MainMenuRecViewItem(R.drawable.chest, "Chest 7", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new MainMenuRecViewItem(R.drawable.chest, "Chest 8", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new MainMenuRecViewItem(R.drawable.chest, "Chest 9", getString(R.string.chest_exercise), ""));
        chest_exercise_counter = 10;

        shoulder_exercises.add(new MainMenuRecViewItem(R.drawable.shoulders, "Shoulders 0", getString(R.string.shoulders_exercise), ""));
        shoulder_exercises.add(new MainMenuRecViewItem(R.drawable.shoulders, "Shoulders 1", getString(R.string.shoulders_exercise), ""));
        shoulder_exercises.add(new MainMenuRecViewItem(R.drawable.shoulders, "Shoulders 2", getString(R.string.shoulders_exercise), ""));
        shoulder_exercises.add(new MainMenuRecViewItem(R.drawable.shoulders, "Shoulders 3", getString(R.string.shoulders_exercise), ""));
        shoulder_exercises.add(new MainMenuRecViewItem(R.drawable.shoulders, "Shoulders 4", getString(R.string.shoulders_exercise), ""));

        biceps_exercises.add(new MainMenuRecViewItem(R.drawable.biceps, "Biceps 0", getString(R.string.biceps_exercise), ""));
        biceps_exercises.add(new MainMenuRecViewItem(R.drawable.biceps, "Biceps 1", getString(R.string.biceps_exercise), ""));
        biceps_exercises.add(new MainMenuRecViewItem(R.drawable.biceps, "Biceps 2", getString(R.string.biceps_exercise), ""));
        biceps_exercises.add(new MainMenuRecViewItem(R.drawable.biceps, "Biceps 3", getString(R.string.biceps_exercise), ""));

        triceps_exercises.add(new MainMenuRecViewItem(R.drawable.triceps, "Triceps 0", getString(R.string.triceps_exercise), ""));
        triceps_exercises.add(new MainMenuRecViewItem(R.drawable.triceps, "Triceps 1", getString(R.string.triceps_exercise), ""));
        triceps_exercises.add(new MainMenuRecViewItem(R.drawable.triceps, "Triceps 2", getString(R.string.triceps_exercise), ""));

        forearms_exercises.add(new MainMenuRecViewItem(R.drawable.forearms, "Forearms 0", getString(R.string.forearms_exercise), ""));
        forearms_exercises.add(new MainMenuRecViewItem(R.drawable.forearms, "Forearms 1", getString(R.string.forearms_exercise), ""));

        back_exercises.add(new MainMenuRecViewItem(R.drawable.back, "Back 0", getString(R.string.back_exercise), ""));
        back_exercises.add(new MainMenuRecViewItem(R.drawable.back, "Back 1", getString(R.string.back_exercise), ""));
        back_exercises.add(new MainMenuRecViewItem(R.drawable.back, "Back 2", getString(R.string.back_exercise), ""));
        back_exercises.add(new MainMenuRecViewItem(R.drawable.back, "Back 3", getString(R.string.back_exercise), ""));
        back_exercises.add(new MainMenuRecViewItem(R.drawable.back, "Back 4", getString(R.string.back_exercise), ""));
        back_exercises.add(new MainMenuRecViewItem(R.drawable.back, "Back 5", getString(R.string.back_exercise), ""));

        abs_exercises.add(new MainMenuRecViewItem(R.drawable.abs, "Abs 0", getString(R.string.abs_exercise), ""));
        abs_exercises.add(new MainMenuRecViewItem(R.drawable.abs, "Abs 1", getString(R.string.abs_exercise), ""));
        abs_exercises.add(new MainMenuRecViewItem(R.drawable.abs, "Abs 2", getString(R.string.abs_exercise), ""));
        abs_exercises.add(new MainMenuRecViewItem(R.drawable.abs, "Abs 3", getString(R.string.abs_exercise), ""));
        abs_exercises.add(new MainMenuRecViewItem(R.drawable.abs, "Abs 4", getString(R.string.abs_exercise), ""));

        legs_exercises.add(new MainMenuRecViewItem(R.drawable.legs, "Legs 0", getString(R.string.legs_exercise), ""));
        legs_exercises.add(new MainMenuRecViewItem(R.drawable.legs, "Legs 1", getString(R.string.legs_exercise), ""));
        legs_exercises.add(new MainMenuRecViewItem(R.drawable.legs, "Legs 2", getString(R.string.legs_exercise), ""));
        legs_exercises.add(new MainMenuRecViewItem(R.drawable.legs, "Legs 3", getString(R.string.legs_exercise), ""));
        legs_exercises.add(new MainMenuRecViewItem(R.drawable.legs, "Legs 4", getString(R.string.legs_exercise), ""));
        legs_exercises.add(new MainMenuRecViewItem(R.drawable.legs, "Legs 5", getString(R.string.legs_exercise), ""));
        legs_exercises.add(new MainMenuRecViewItem(R.drawable.legs, "Legs 6", getString(R.string.legs_exercise), ""));

        exercises.add(new MainMenuRecViewItem(R.drawable.chest, getString(R.string.chest_exercise), getString(R.string.chest_exercise), String.valueOf(chest_exercises.size()) + " exercises"));
        exercises.add(new MainMenuRecViewItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), getString(R.string.shoulders_exercise), String.valueOf(shoulder_exercises.size()) + " exercises"));
        exercises.add(new MainMenuRecViewItem(R.drawable.biceps, getString(R.string.biceps_exercise), getString(R.string.biceps_exercise), String.valueOf(biceps_exercises.size()) + " exercises"));
        exercises.add(new MainMenuRecViewItem(R.drawable.triceps, getString(R.string.triceps_exercise), getString(R.string.triceps_exercise), String.valueOf(triceps_exercises.size()) + " exercises"));
        exercises.add(new MainMenuRecViewItem(R.drawable.forearms, getString(R.string.forearms_exercise), getString(R.string.forearms_exercise), String.valueOf(forearms_exercises.size()) + " exercises"));
        exercises.add(new MainMenuRecViewItem(R.drawable.back, getString(R.string.back_exercise), getString(R.string.back_exercise), String.valueOf(back_exercises.size()) + " exercises"));
        exercises.add(new MainMenuRecViewItem(R.drawable.abs, getString(R.string.abs_exercise), getString(R.string.abs_exercise), String.valueOf(abs_exercises.size()) + " exercises"));
        exercises.add(new MainMenuRecViewItem(R.drawable.legs, getString(R.string.legs_exercise), getString(R.string.legs_exercise), String.valueOf(legs_exercises.size()) + " exercises"));

        // put exercises to show first
        RecViewItems = exercises;

        // get the recycler view in order to manipulate it
        MainMenu_RecView = findViewById(R.id.id_ac_ma_me_RecView);

        // set the adapter for recycler view and show items in it
        //MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
        adapter.setMainMenuRecView_items(RecViewItems);
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
        adapter.setMainMenuRecView_items(RecViewItems);
        MainMenu_RecView.setAdapter(adapter);
        MainMenu_RecView.setLayoutManager(new LinearLayoutManager(this));

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {

        // for exercises
        if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.chest_exercise))){
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", chest_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.shoulders_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", shoulder_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.biceps_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", biceps_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.triceps_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", triceps_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.forearms_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", forearms_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.back_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", back_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.abs_exercise))) {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", abs_exercises);
            startActivity(intent);
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.legs_exercise))) {
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