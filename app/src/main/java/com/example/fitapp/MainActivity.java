package com.example.fitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
        if (id == R.id.id_ma_item_exercises){
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.exercises);

            // ToDo: 9:16:50 on this video https://youtu.be/fis26HvvDII for RecyclerView for muscle groups
            // ToDo: watch again but follow what he does and try to understand and write comments

            // change layout and instantiate recycler view
            setContentView(R.layout.muscle_groups);
            muscle_groups_RecView = findViewById(R.id.id_mu_gr_RecView);

            // create array list to populate recycler view
            ArrayList<MuscleGroup> muscle_groups = new ArrayList<>();
            muscle_groups.add(new MuscleGroup("Chest", R.drawable.chest));
            muscle_groups.add(new MuscleGroup("Shoulders", R.drawable.shoulders));
            muscle_groups.add(new MuscleGroup("Biceps", R.drawable.biceps));
            muscle_groups.add(new MuscleGroup("Triceps", R.drawable.triceps));
            muscle_groups.add(new MuscleGroup("Forearms", R.drawable.forearms));
            muscle_groups.add(new MuscleGroup("Back", R.drawable.back));
            muscle_groups.add(new MuscleGroup("Abs", R.drawable.abs));
            muscle_groups.add(new MuscleGroup("Legs", R.drawable.legs));

            MuGrRecViewAdapter adapter = new MuGrRecViewAdapter(this);
            adapter.setMuscle_groups(muscle_groups);

            muscle_groups_RecView.setAdapter(adapter);
            muscle_groups_RecView.setLayoutManager(new LinearLayoutManager(this));

            // ToDo: this video https://youtu.be/7GPUpvcU1FE explains how to enable to click on recycler view item

            return true;

        } else if (id == R.id.id_ma_item_my_workouts){
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.my_workouts);

            // make to open new page with my workouts or stay on the same page if that page is allready on
            return true;

        } else if (id == R.id.id_ma_item_progrress) {
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.progress);

            // make to open new page with progress or stay on the same page if that page is allready on
            return true;

        } else if (id == R.id.id_ma_item_diet) {
            // change action bar title and icon
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.diet);

            // make to open new page with diet or stay on the same page if that page is allready on
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

}