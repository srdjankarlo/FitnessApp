package com.example.fitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Objects;

// Alt+shift to have multi select lines

public class MainActivity extends AppCompatActivity {

    //Intent intent = null;
    int id;
    RecyclerView common_RecView;
    // create array list to populate recycler view
    ArrayList<CommonRecycleViewItem> RecViewItems = new ArrayList<>(), item_list = new ArrayList<>(),
            exercises = new ArrayList<>(), diet = new ArrayList<>(),
            chest_exercises = new ArrayList<>(), shoulder_exercises = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // try get data from other activity
        //try {
        //    //  Block of code to try
        //    Intent intent = getIntent();
        //    item_list = intent.getParcelableArrayListExtra("RecViewItemsList");
        //
        //    setContentView(R.layout.activity_main_menu);
        //    common_RecView = findViewById(R.id.id_ac_ma_me_RecView);
        //
        //    CommonRecViewAdapter adapter = new CommonRecViewAdapter(this, this);
        //    adapter.setCommon_rec_view_items(item_list);
        //
        //    common_RecView.setAdapter(adapter);
        //    common_RecView.setLayoutManager(new LinearLayoutManager(this));
        //}
        //catch(Exception e) {
        //    //  Block of code to handle errors
        //    setContentView(R.layout.activity_main);
        //} finally {
        //    setContentView(R.layout.activity_main);
        //}

        // calling this activity's function to use ActionBar utility methods
        //ActionBar actionBar = getSupportActionBar();
        //assert actionBar != null;

        // set title in action bar - starting title is in AndroidManifest android:label
        // actionBar.setTitle(R.string.exercises);

        setContentView(R.layout.activity_main);

        // fill lists with items
        chest_exercises.add(new CommonRecycleViewItem(R.drawable.chest, "Chest 0", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new CommonRecycleViewItem(R.drawable.chest, "Chest 1", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new CommonRecycleViewItem(R.drawable.chest, "Chest 2", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new CommonRecycleViewItem(R.drawable.chest, "Chest 3", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new CommonRecycleViewItem(R.drawable.chest, "Chest 4", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new CommonRecycleViewItem(R.drawable.chest, "Chest 5", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new CommonRecycleViewItem(R.drawable.chest, "Chest 6", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new CommonRecycleViewItem(R.drawable.chest, "Chest 7", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new CommonRecycleViewItem(R.drawable.chest, "Chest 8", getString(R.string.chest_exercise), ""));
        chest_exercises.add(new CommonRecycleViewItem(R.drawable.chest, "Chest 9", getString(R.string.chest_exercise), ""));

        shoulder_exercises.add(new CommonRecycleViewItem(R.drawable.shoulders, "Shoulders 0", getString(R.string.shoulders_exercise), ""));
        shoulder_exercises.add(new CommonRecycleViewItem(R.drawable.shoulders, "Shoulders 1", getString(R.string.shoulders_exercise), ""));
        shoulder_exercises.add(new CommonRecycleViewItem(R.drawable.shoulders, "Shoulders 2", getString(R.string.shoulders_exercise), ""));
        shoulder_exercises.add(new CommonRecycleViewItem(R.drawable.shoulders, "Shoulders 3", getString(R.string.shoulders_exercise), ""));
        shoulder_exercises.add(new CommonRecycleViewItem(R.drawable.shoulders, "Shoulders 4", getString(R.string.shoulders_exercise), ""));
        shoulder_exercises.add(new CommonRecycleViewItem(R.drawable.shoulders, "Shoulders 5", getString(R.string.shoulders_exercise), ""));
        shoulder_exercises.add(new CommonRecycleViewItem(R.drawable.shoulders, "Shoulders 6", getString(R.string.shoulders_exercise), ""));
        shoulder_exercises.add(new CommonRecycleViewItem(R.drawable.shoulders, "Shoulders 7", getString(R.string.shoulders_exercise), ""));
        shoulder_exercises.add(new CommonRecycleViewItem(R.drawable.shoulders, "Shoulders 8", getString(R.string.shoulders_exercise), ""));

        diet.add(new CommonRecycleViewItem(R.drawable.fork_and_knife, "Meal 1", getString(R.string.menu_item_diet), ""));
        diet.add(new CommonRecycleViewItem(R.drawable.fork_and_knife, "Meal 2", getString(R.string.menu_item_diet), ""));

        exercises.add(new CommonRecycleViewItem(R.drawable.chest, getString(R.string.chest_exercise), getString(R.string.menu_item_exercises), String.valueOf(chest_exercises.size()) + " exercises"));
        exercises.add(new CommonRecycleViewItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), getString(R.string.menu_item_exercises), ""));
        exercises.add(new CommonRecycleViewItem(R.drawable.biceps, getString(R.string.biceps_exercise), getString(R.string.menu_item_exercises), ""));
        exercises.add(new CommonRecycleViewItem(R.drawable.triceps, getString(R.string.triceps_exercise), getString(R.string.menu_item_exercises), ""));
        exercises.add(new CommonRecycleViewItem(R.drawable.forearms, getString(R.string.forearms_exercise), getString(R.string.menu_item_exercises), ""));
        exercises.add(new CommonRecycleViewItem(R.drawable.back, getString(R.string.biceps_exercise), getString(R.string.menu_item_exercises), ""));
        exercises.add(new CommonRecycleViewItem(R.drawable.abs, getString(R.string.abs_exercise), getString(R.string.menu_item_exercises), ""));
        exercises.add(new CommonRecycleViewItem(R.drawable.legs, getString(R.string.legs_exercise), getString(R.string.menu_item_exercises), ""));

    }

    public void Button1(View view) {

    }

    public void Button2(View view) {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}