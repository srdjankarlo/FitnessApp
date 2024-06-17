package com.example.fitapp;

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
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.menu_item_exercises);
        setContentView(R.layout.activity_main_menu);

        RecViewItems = exercises;

        common_RecView = findViewById(R.id.id_ac_ma_me_RecView);

        MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
        adapter.setCommon_rec_view_items(RecViewItems);

        common_RecView.setAdapter(adapter);
        common_RecView.setLayoutManager(new LinearLayoutManager(this));

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
            }
        });
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
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.menu_item_exercises);
            RecViewItems = exercises;

        } else if (id == R.id.id_ma_me_item_diet) {
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.menu_item_diet);
            RecViewItems = diet;

        } else if (id == R.id.id_ma_me_item_my_workouts){
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.menu_item_my_workouts);
            RecViewItems = item_list;

        } else if (id == R.id.id_ma_me_item_progress) {
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.menu_item_progress);
            RecViewItems = item_list;

        } else return true;  // this will leave activity_main layout if nothing was selected in menu

        common_RecView = findViewById(R.id.id_ac_ma_me_RecView);

        MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
        adapter.setCommon_rec_view_items(RecViewItems);

        common_RecView.setAdapter(adapter);
        common_RecView.setLayoutManager(new LinearLayoutManager(this));

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {
        if (Objects.equals(RecViewItems.get(position).getCommonRecViewTextView1(), getString(R.string.chest_exercise))){
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.chest_exercise);
            RecViewItems = chest_exercises;
        }

        //Intent intent = new Intent(this, MainMenuActivity.class);
        //intent.putParcelableArrayListExtra("RecViewItemsList", RecViewItems);
        //startActivity(intent);
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