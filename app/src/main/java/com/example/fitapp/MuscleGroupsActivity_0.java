package com.example.fitapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MuscleGroupsActivity_0 extends AppCompatActivity implements MuscleGroupsInterface {

    int id;
    RecyclerView MainMenu_RecView;

    MuscleGroupsAdapter adapter = new MuscleGroupsAdapter(this, this);

    ExercisesViewModel viewModel;

    // create array list to populate recycler view
    ArrayList<MuscleGroupsItem> RecViewItems = new ArrayList<>();

    // list of type ExerciseItem, store all ExercisesItem items
    List<ExercisesItem> exercises = new ArrayList<>();
    List<ExercisesItem> chest_exercises, shoulder_exercises, biceps_exercises,
            triceps_exercises, forearms_exercises, back_exercises, abs_exercises, quads_exercises,
            hamstrings_exercises, glutes_exercises, calves_exercises;

    public int num_chest_exercises, num_shoulder_exercises, num_biceps_exercises, num_triceps_exercises,
            num_forearms_exercises, num_back_exercises, num_abs_exercises, num_quads_exercises,
            num_hamstrings_exercises, num_glutes_exercises, num_calves_exercises;

    ArrayList<ExercisesItem> exercisesList = new ArrayList<>();
    ArrayList<ExercisesItem> customExercisesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the activity layout
        setContentView(R.layout.activity_muscle_groups);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Main menu: " +  getString(R.string.menu_item_exercises));

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        bar.setBackgroundDrawable(color);

        // fill view model with exercises
        viewModel = new ViewModelProvider(this).get(ExercisesViewModel.class);
        viewModel.inserInitialData();

        // Fetch and observe exercises by category
        viewModel.getAllExercisesData().observe(this, new Observer<List<ExercisesItem>>() {
            @Override
            public void onChanged(List<ExercisesItem> exercisesItems) {
                // Update UI with exercisesItems
                exercises.clear();
                exercises.addAll(exercisesItems);

                back_exercises = exercises.stream().filter(exercise -> exercise.getPrimary().contains("Back")).collect(Collectors.toList());
                chest_exercises = exercises.stream().filter(exercise -> exercise.getPrimary().contains("Chest")).collect(Collectors.toList());
                shoulder_exercises = exercises.stream().filter(exercise -> exercise.getPrimary().contains("Shoulders")).collect(Collectors.toList());
                triceps_exercises = exercises.stream().filter(exercise -> exercise.getPrimary().contains("Triceps")).collect(Collectors.toList());
                biceps_exercises = exercises.stream().filter(exercise -> exercise.getPrimary().contains("Biceps")).collect(Collectors.toList());
                forearms_exercises = exercises.stream().filter(exercise -> exercise.getPrimary().contains("Forearms")).collect(Collectors.toList());
                abs_exercises = exercises.stream().filter(exercise -> exercise.getPrimary().contains("Abs")).collect(Collectors.toList());
                quads_exercises = exercises.stream().filter(exercise -> exercise.getPrimary().contains("Quads")).collect(Collectors.toList());
                hamstrings_exercises = exercises.stream().filter(exercise -> exercise.getPrimary().contains("Hamstrings")).collect(Collectors.toList());
                glutes_exercises = exercises.stream().filter(exercise -> exercise.getPrimary().contains("Glutes")).collect(Collectors.toList());
                calves_exercises = exercises.stream().filter(exercise -> exercise.getPrimary().contains("Calves")).collect(Collectors.toList());

                num_back_exercises = (int) exercises.stream().filter(exercise -> exercise.getPrimary().contains("Back")).count();
                num_chest_exercises = (int) exercises.stream().filter(exercise -> exercise.getPrimary().contains("Chest")).count();
                num_shoulder_exercises = (int) exercises.stream().filter(exercise -> exercise.getPrimary().contains("Shoulders")).count();
                num_triceps_exercises = (int) exercises.stream().filter(exercise -> exercise.getPrimary().contains("Triceps")).count();
                num_biceps_exercises = (int) exercises.stream().filter(exercise -> exercise.getPrimary().contains("Biceps")).count();
                num_forearms_exercises = (int) exercises.stream().filter(exercise -> exercise.getPrimary().contains("Forearms")).count();
                num_abs_exercises = (int) exercises.stream().filter(exercise -> exercise.getPrimary().contains("Abs")).count();
                num_quads_exercises = (int) exercises.stream().filter(exercise -> exercise.getPrimary().contains("Quads")).count();
                num_hamstrings_exercises = (int) exercises.stream().filter(exercise -> exercise.getPrimary().contains("Hamstrings")).count();
                num_glutes_exercises = (int) exercises.stream().filter(exercise -> exercise.getPrimary().contains("Glutes")).count();
                num_calves_exercises = (int) exercises.stream().filter(exercise -> exercise.getPrimary().contains("Calves")).count();

                setupMuscleGroups();
            }
        });

        // get the recycler view in order to manipulate it
        MainMenu_RecView = findViewById(R.id.ac_mu_groups_RecView);

    }

    private void setupMuscleGroups(){

        // populate list with items that will be shown in recycler view
        RecViewItems.clear();
        RecViewItems.add(new MuscleGroupsItem(R.drawable.back, getString(R.string.back_exercise), num_back_exercises));
        RecViewItems.add(new MuscleGroupsItem(R.drawable.chest, getString(R.string.chest_exercise), num_chest_exercises));
        RecViewItems.add(new MuscleGroupsItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), num_shoulder_exercises));
        RecViewItems.add(new MuscleGroupsItem(R.drawable.triceps, getString(R.string.triceps_exercise), num_triceps_exercises));
        RecViewItems.add(new MuscleGroupsItem(R.drawable.biceps, getString(R.string.biceps_exercise), num_biceps_exercises));
        RecViewItems.add(new MuscleGroupsItem(R.drawable.forearms, getString(R.string.forearms_exercise), num_forearms_exercises));
        RecViewItems.add(new MuscleGroupsItem(R.drawable.abs, getString(R.string.abs_exercise), num_abs_exercises));
        RecViewItems.add(new MuscleGroupsItem(R.drawable.glutes, getString(R.string.glutes_exercise), num_glutes_exercises));
        RecViewItems.add(new MuscleGroupsItem(R.drawable.quads, getString(R.string.quads_exercise), num_quads_exercises));
        RecViewItems.add(new MuscleGroupsItem(R.drawable.hamstrings, getString(R.string.hamstrings_exercise), num_hamstrings_exercises));
        RecViewItems.add(new MuscleGroupsItem(R.drawable.calves, getString(R.string.calves_exercise), num_calves_exercises));

        // set the adapter for recycler view and show items in it
        adapter.setMuscleGroupsItems(RecViewItems);
        MainMenu_RecView.setAdapter(adapter);
        MainMenu_RecView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Handle item selection
        // get the id of clicked menu item
        id = item.getItemId();
        if (id == R.id.ma_me_item_diet) {
            // diet activity doesnt need any data from main activity
            Intent intent = new Intent(getApplicationContext(), DietActivity_0_1.class);
            startActivity(intent);
        } else if (id == R.id.ma_me_AddExercise) {
            // add exercise doesnt need any data to be passed because that activity extends this activity
            Intent intent = new Intent(getApplicationContext(), AddExerciseActivity_0_2.class);
            startActivity(intent);
        } else if (id == R.id.ma_me_DeleteExercise) {
            viewModel.getAllExercisesData().observe(this, new Observer<List<ExercisesItem>>() {
                @Override
                public void onChanged(List<ExercisesItem> exercisesItems) {
                    // Update UI with exercisesItems
                    exercisesList.clear();
                    exercisesList.addAll(exercisesItems);

                    customExercisesList = (ArrayList<ExercisesItem>) exercisesList.stream().filter(ExercisesItem::getCustomExercise).collect(Collectors.toList());
                }
            });

            if (customExercisesList.size() == 0){
                Toast.makeText(MuscleGroupsActivity_0.this, "No custom exercises to delete", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), DeleteExerciseActivity_0_3.class);
                startActivity(intent);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {

        // for exercises
        MuscleGroupsItem selectedItem = RecViewItems.get(position);
        String selectedName = selectedItem.getName();

        // Map exercise categories to lists and counts
        Map<String, List<ExercisesItem>> categoryExercisesMap = new HashMap<>();
        categoryExercisesMap.put(getString(R.string.back_exercise), back_exercises);
        categoryExercisesMap.put(getString(R.string.chest_exercise), chest_exercises);
        categoryExercisesMap.put(getString(R.string.shoulders_exercise), shoulder_exercises);
        categoryExercisesMap.put(getString(R.string.triceps_exercise), triceps_exercises);
        categoryExercisesMap.put(getString(R.string.biceps_exercise), biceps_exercises);
        categoryExercisesMap.put(getString(R.string.forearms_exercise), forearms_exercises);
        categoryExercisesMap.put(getString(R.string.abs_exercise), abs_exercises);
        categoryExercisesMap.put(getString(R.string.quads_exercise), quads_exercises);
        categoryExercisesMap.put(getString(R.string.hamstrings_exercise), hamstrings_exercises);
        categoryExercisesMap.put(getString(R.string.glutes_exercise), glutes_exercises);
        categoryExercisesMap.put(getString(R.string.calves_exercise), calves_exercises);

        Map<String, Integer> categoryCountMap = new HashMap<>();
        categoryCountMap.put(getString(R.string.back_exercise), num_back_exercises);
        categoryCountMap.put(getString(R.string.chest_exercise), num_chest_exercises);
        categoryCountMap.put(getString(R.string.shoulders_exercise), num_shoulder_exercises);
        categoryCountMap.put(getString(R.string.triceps_exercise), num_triceps_exercises);
        categoryCountMap.put(getString(R.string.biceps_exercise), num_biceps_exercises);
        categoryCountMap.put(getString(R.string.forearms_exercise), num_forearms_exercises);
        categoryCountMap.put(getString(R.string.abs_exercise), num_abs_exercises);
        categoryCountMap.put(getString(R.string.quads_exercise), num_quads_exercises);
        categoryCountMap.put(getString(R.string.hamstrings_exercise), num_hamstrings_exercises);
        categoryCountMap.put(getString(R.string.glutes_exercise), num_glutes_exercises);
        categoryCountMap.put(getString(R.string.calves_exercise), num_calves_exercises);

        List<ExercisesItem> exercisesList = categoryExercisesMap.get(selectedName);
        int exerciseCount = categoryCountMap.get(selectedName);

        if (exerciseCount == 0) {
            Toast.makeText(this, "No " + selectedName.toLowerCase() + " exercises", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
            intent.putParcelableArrayListExtra("RecViewItemsList", new ArrayList<>(exercisesList));
            intent.putExtra("Exercise name", selectedName);
            startActivity(intent);
        }
    }

}