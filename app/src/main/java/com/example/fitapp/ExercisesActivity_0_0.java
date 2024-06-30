package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class ExercisesActivity_0_0 extends MainMenuActivity_0 implements MainMenuRecViewInterface {

    ArrayList<MainMenuRecViewItem> item_list = new ArrayList<>();
    MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
    RecyclerView MainMenu_RecView;
    String item_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ToDo: make all exercises for each muscle group

        // get data from previous activity
        Intent intent = getIntent();
        item_list = intent.getParcelableArrayListExtra("RecViewItemsList");

        // get the type of the item
        item_type = item_list.get(0).getMainMenuRecViewType();

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.exercises_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.ex_me_item1:
                //ToDo: make database to store exercises and tidy this up a bit
                if (Objects.equals(item_type, getString(R.string.chest_exercise))){
                    chest_exercises.add(new MainMenuRecViewItem(R.drawable.chest, "Chest " + chest_exercise_counter, getString(R.string.chest_exercise), ""));
                    adapter.setMainMenuRecView_items(chest_exercises);
                    MainMenu_RecView.setAdapter(adapter);
                    MainMenu_RecView.setLayoutManager(new LinearLayoutManager(this));
                    item_list.add(new MainMenuRecViewItem(R.drawable.chest, "Chest " + chest_exercise_counter, getString(R.string.chest_exercise), ""));
                    chest_exercise_counter += 1;
                }
                //else if () {
                //
                //} else if () {
                //
                //} else if () {
                //
                //} else if () {
                //
                //} else if () {
                //
                //} else if () {
                //
                //} else if () {
                //
                //}


                //Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
                //return true;

            //case R.id.action_about:
            //    Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
            //    return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(int position) {

        //MainMenuRecViewItem exercise = item_list.get(position);
        String exercise_name = item_list.get(position).getMainMenuRecViewTextView1();

        Intent intent = new Intent(this, OneExerciseActivity_0_0_0.class);
        intent.putExtra("ExerciseName", exercise_name);
        startActivity(intent);
    }
}