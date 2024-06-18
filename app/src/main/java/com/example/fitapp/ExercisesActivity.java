package com.example.fitapp;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

public class ExercisesActivity extends MainActivity implements MainMenuRecViewInterface {

    ArrayList<MainMenuRecViewItem> item_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item_list = new ArrayList<>();

        Intent intent = getIntent();
        item_list = intent.getParcelableArrayListExtra("RecViewItemsList");
        String item_type = item_list.get(0).getMainMenuRecViewType();

        Objects.requireNonNull(getSupportActionBar()).setTitle(item_type + " exercises");
        setContentView(R.layout.activity_main_menu);

        MainMenu_RecView = findViewById(R.id.id_ac_ma_me_RecView);

        MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
        adapter.setMainMenuRecView_items(item_list);

        MainMenu_RecView.setAdapter(adapter);
        MainMenu_RecView.setLayoutManager(new LinearLayoutManager(this));

        // Get the OnBackPressedDispatcher
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();

        // Register the callback
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Your custom logic here
                //Toast.makeText(getApplicationContext(), "Back button pressed!", Toast.LENGTH_SHORT).show();

                // If you want to handle the back press, do not call super.onBackPressed()
                // If you want the default behavior, you can finish the activity or call super
                 finish(); // Optionally finish the activity
                Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        //if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.chest_exercise))){
        //    RecViewItems = chest_exercises;
        //} else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.shoulders_exercise))) {
        //    RecViewItems = shoulder_exercises;
        //} else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.biceps_exercise))) {
        //    RecViewItems = biceps_exercises;
        //} else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.triceps_exercise))) {
        //    RecViewItems = triceps_exercises;
        //} else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.forearms_exercise))) {
        //    RecViewItems = forearms_exercises;
        //} else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.back_exercise))) {
        //    RecViewItems = back_exercises;
        //} else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.abs_exercise))) {
        //    RecViewItems = abs_exercises;
        //} else if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.legs_exercise))) {
        //    RecViewItems = legs_exercises;
        //}
        //
        //Intent intent = new Intent(this, ExercisesActivity.class);
        //intent.putParcelableArrayListExtra("RecViewItemsList", RecViewItems);
        //startActivity(intent);
    }
}