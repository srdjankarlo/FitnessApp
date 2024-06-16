package com.example.fitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private RecyclerView muscle_groups_RecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set what layout to show when app starts
        setContentView(R.layout.activity_main);

        // calling this activity's function to use ActionBar utility methods
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;

        // set title in action bar - starting title is in AndroidManifest android:label
        // actionBar.setTitle(R.string.exercises);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // show our main_menu.xml menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // this just opens new layout using item ids
        int id = item.getItemId();
        if (id == R.id.id_ma_me_item_exercises){
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.menu_item_exercises);

            // ToDo: 9:16:50 on this video https://youtu.be/fis26HvvDII for RecyclerView for muscle groups
            // ToDo: watch again but follow what he does and try to understand and write comments

            // change layout and instantiate recycler view
            setContentView(R.layout.common_rec_view_layout);
            muscle_groups_RecView = findViewById(R.id.id_co_re_vi_la_RecView);

            // create array list to populate recycler view
            ArrayList<CommonRecycleViewItem> muscle_groups = new ArrayList<>();
            muscle_groups.add(new CommonRecycleViewItem("Chest", R.drawable.chest, getString(R.string.menu_item_exercises)));
            muscle_groups.add(new CommonRecycleViewItem("Shoulders", R.drawable.shoulders, getString(R.string.menu_item_exercises)));
            muscle_groups.add(new CommonRecycleViewItem("Biceps", R.drawable.biceps, getString(R.string.menu_item_exercises)));
            muscle_groups.add(new CommonRecycleViewItem("Triceps", R.drawable.triceps, getString(R.string.menu_item_exercises)));
            muscle_groups.add(new CommonRecycleViewItem("Forearms", R.drawable.forearms, getString(R.string.menu_item_exercises)));
            muscle_groups.add(new CommonRecycleViewItem("Back", R.drawable.back, getString(R.string.menu_item_exercises)));
            muscle_groups.add(new CommonRecycleViewItem("Abs", R.drawable.abs, getString(R.string.menu_item_exercises)));
            muscle_groups.add(new CommonRecycleViewItem("Legs", R.drawable.legs, getString(R.string.menu_item_exercises)));

            CommonRecViewAdapter adapter = new CommonRecViewAdapter(this);
            adapter.setCommon_rec_view_items(muscle_groups);

            muscle_groups_RecView.setAdapter(adapter);
            muscle_groups_RecView.setLayoutManager(new LinearLayoutManager(this));

            // ToDo: this video https://youtu.be/7GPUpvcU1FE explains how to enable to click on recycler view item

            return true;

        } else if (id == R.id.id_ma_me_item_my_workouts){
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.menu_item_my_workouts);

            // make to open new page with my workouts or stay on the same page if that page is allready on
            return true;

        } else if (id == R.id.id_ma_me_item_progress) {
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.menu_item_progress);

            // make to open new page with progress or stay on the same page if that page is allready on
            return true;

        } else if (id == R.id.id_ma_me_item_diet) {
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.menu_item_diet);

            setContentView(R.layout.common_rec_view_layout);
            muscle_groups_RecView = findViewById(R.id.id_co_re_vi_la_RecView);

            // create array list to populate recycler view
            ArrayList<CommonRecycleViewItem> diet = new ArrayList<>();
            diet.add(new CommonRecycleViewItem("Meal 1", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));
            diet.add(new CommonRecycleViewItem("Meal 2", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));
            diet.add(new CommonRecycleViewItem("Meal 3", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));
            diet.add(new CommonRecycleViewItem("Meal 4", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));
            diet.add(new CommonRecycleViewItem("Meal 5", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));
            diet.add(new CommonRecycleViewItem("Meal 6", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));
            diet.add(new CommonRecycleViewItem("Meal 7", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));
            diet.add(new CommonRecycleViewItem("Meal 8", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));

            CommonRecViewAdapter adapter = new CommonRecViewAdapter(this);
            adapter.setCommon_rec_view_items(diet);

            muscle_groups_RecView.setAdapter(adapter);
            muscle_groups_RecView.setLayoutManager(new LinearLayoutManager(this));

            // make to open new page with diet or stay on the same page if that page is allready on
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

}