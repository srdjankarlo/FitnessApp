package com.example.fitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Objects;

public class ChestExercisesActivity extends AppCompatActivity {

    private RecyclerView common_RecView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.chest_exercise);
        setContentView(R.layout.activity_chest_exercises);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;

        common_RecView = findViewById(R.id.id_co_re_vi_la_RecView);

        // create array list to populate recycler view
        ArrayList<CommonRecycleViewItem> exercises = new ArrayList<>();
        exercises.add(new CommonRecycleViewItem("Chest 0", R.drawable.chest, getString(R.string.chest_exercise)));
        exercises.add(new CommonRecycleViewItem("Chest 1", R.drawable.chest, getString(R.string.chest_exercise)));
        exercises.add(new CommonRecycleViewItem("Chest 2", R.drawable.chest, getString(R.string.chest_exercise)));
        exercises.add(new CommonRecycleViewItem("Chest 3", R.drawable.chest, getString(R.string.chest_exercise)));
        exercises.add(new CommonRecycleViewItem("Chest 4", R.drawable.chest, getString(R.string.chest_exercise)));
        exercises.add(new CommonRecycleViewItem("Chest 5", R.drawable.chest, getString(R.string.chest_exercise)));
        exercises.add(new CommonRecycleViewItem("Chest 6", R.drawable.chest, getString(R.string.chest_exercise)));
        exercises.add(new CommonRecycleViewItem("Chest 7", R.drawable.chest, getString(R.string.chest_exercise)));
        exercises.add(new CommonRecycleViewItem("Chest 8", R.drawable.chest, getString(R.string.chest_exercise)));
        exercises.add(new CommonRecycleViewItem("Chest 9", R.drawable.chest, getString(R.string.chest_exercise)));

        CommonRecViewAdapter adapter = new CommonRecViewAdapter(this);
        adapter.setCommon_rec_view_items(exercises);

        common_RecView.setAdapter(adapter);
        common_RecView.setLayoutManager(new LinearLayoutManager(this));
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
        if (id == R.id.id_ma_me_item_my_workouts){
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
            common_RecView = findViewById(R.id.id_co_re_vi_la_RecView);

            // create array list to populate recycler view
            //ArrayList<CommonRecycleViewItem> diet = new ArrayList<>();
            //diet.add(new CommonRecycleViewItem("Meal 1", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));
            //diet.add(new CommonRecycleViewItem("Meal 2", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));
            //diet.add(new CommonRecycleViewItem("Meal 3", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));
            //diet.add(new CommonRecycleViewItem("Meal 4", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));
            //diet.add(new CommonRecycleViewItem("Meal 5", R.drawable.fork_and_knife, getString(R.string.menu_item_diet)));

            Intent intent = getIntent();
            ArrayList<CommonRecycleViewItem> diet = intent.getParcelableArrayListExtra("customObjectList");

            CommonRecViewAdapter adapter = new CommonRecViewAdapter(this);
            adapter.setCommon_rec_view_items(diet);

            common_RecView.setAdapter(adapter);
            common_RecView.setLayoutManager(new LinearLayoutManager(this));

            // make to open new page with diet or stay on the same page if that page is allready on
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    
}