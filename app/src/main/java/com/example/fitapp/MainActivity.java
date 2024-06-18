package com.example.fitapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


// Alt+shift to have multi select lines
// fast double click ctrl+arrow up/down to select lines

public class MainActivity extends AppCompatActivity {

    //Intent intent = null;
    int id;
    RecyclerView MainMenu_RecView;
    // create array list to populate recycler view
    ArrayList<MainMenuRecViewItem> RecViewItems = new ArrayList<>(),
            exercises = new ArrayList<>(), diet = new ArrayList<>(),
            chest_exercises = new ArrayList<>(), shoulder_exercises = new ArrayList<>(),
            biceps_exercises = new ArrayList<>(), triceps_exercises = new ArrayList<>(),
            forearms_exercises = new ArrayList<>(), back_exercises = new ArrayList<>(),
            abs_exercises = new ArrayList<>(), legs_exercises = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set title in action bar - starting title is in AndroidManifest android:label
        // actionBar.setTitle(R.string.exercises);

        // set layout for the activity
        setContentView(R.layout.activity_main);

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

        diet.add(new MainMenuRecViewItem(R.drawable.fork_and_knife, "Meal 1", getString(R.string.menu_item_diet), ""));
        diet.add(new MainMenuRecViewItem(R.drawable.fork_and_knife, "Meal 2", getString(R.string.menu_item_diet), ""));
    }

    // yes button when pressed logic
    public void Button1(View view) {
        // ToDo
        Toast.makeText(getApplicationContext(), "Not implemented yet!", Toast.LENGTH_SHORT).show();
    }

    // no button when pressed logic
    public void Button2(View view) {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}