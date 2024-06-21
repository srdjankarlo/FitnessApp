package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

public class ExercisesActivity_0_0 extends AppCompatActivity implements MainMenuRecViewInterface {

    ArrayList<MainMenuRecViewItem> item_list = new ArrayList<>();
    MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
    RecyclerView MainMenu_RecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get data from previous activity
        Intent intent = getIntent();
        item_list = intent.getParcelableArrayListExtra("RecViewItemsList");

        // get the type of the item
        String item_type = item_list.get(0).getMainMenuRecViewType();

        // set layout
        setContentView(R.layout.activity_main_menu);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle(item_type + " exercises");

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        bar.setBackgroundDrawable(color);

        // get the recycler view in order to manipulate it
        MainMenu_RecView = findViewById(R.id.id_ac_ma_me_RecView);

        // set the adapter for recycler view and show items in it
        //MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
        adapter.setMainMenuRecView_items(item_list);

        MainMenu_RecView.setAdapter(adapter);
        MainMenu_RecView.setLayoutManager(new LinearLayoutManager(this));

        // ToDo: set this up again, the fix didnt work
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
    public void onItemClick(int position) {

        // ToDo: make logic for when particular exercise is clicked and make layout for it
        MainMenuRecViewItem exercise = item_list.get(position);

        Intent intent = new Intent(this, OneExerciseActivity_0_0_0.class);
        intent.putExtra("ExerciseName", exercise);
        startActivity(intent);
    }
}