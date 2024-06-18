package com.example.fitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Objects;

public class MainMenuActivity extends MainActivity implements MainMenuRecViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Main menu: " +  getString(R.string.menu_item_exercises));
        setContentView(R.layout.activity_main_menu);

        // put exercises to show first
        RecViewItems = exercises;

        MainMenu_RecView = findViewById(R.id.id_ac_ma_me_RecView);

        MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
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

        // this just opens new layout using item ids
        id = item.getItemId();
        if (id == R.id.id_ma_me_item_exercises){
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle("Main menu: " + getString(R.string.menu_item_exercises));
            RecViewItems = exercises;

        } else if (id == R.id.id_ma_me_item_diet) {
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle("Main menu: " + getString(R.string.menu_item_diet));
            RecViewItems = diet;

        } else if (id == R.id.id_ma_me_item_my_workouts){
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle("Main menu: " + getString(R.string.menu_item_my_workouts));
            //RecViewItems = item_list;

        } else if (id == R.id.id_ma_me_item_progress) {
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle("Main menu: " + getString(R.string.menu_item_progress));
            //RecViewItems = item_list;

        } else return true;  // this will leave activity_main layout if nothing was selected in menu

        MainMenu_RecView = findViewById(R.id.id_ac_ma_me_RecView);

        MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
        adapter.setMainMenuRecView_items(RecViewItems);

        MainMenu_RecView.setAdapter(adapter);
        MainMenu_RecView.setLayoutManager(new LinearLayoutManager(this));

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {
        if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.chest_exercise))){
            RecViewItems = chest_exercises;
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.shoulders_exercise))) {
            RecViewItems = shoulder_exercises;
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.biceps_exercise))) {
            RecViewItems = biceps_exercises;
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.triceps_exercise))) {
            RecViewItems = triceps_exercises;
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.forearms_exercise))) {
            RecViewItems = forearms_exercises;
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.back_exercise))) {
            RecViewItems = back_exercises;
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.abs_exercise))) {
            RecViewItems = abs_exercises;
        } else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.legs_exercise))) {
            RecViewItems = legs_exercises;
        }

        Intent intent = new Intent(getApplicationContext(), ExercisesActivity.class);
        intent.putParcelableArrayListExtra("RecViewItemsList", RecViewItems);
        startActivity(intent);
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