package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class DietActivity_0_1 extends AppCompatActivity implements DietInterface {

    protected DietAdapter adapter;
    RecyclerView RecView;
    DietViewModel dietViewModel;
    public int sumProteins = 0, sumFats = 0, sumCarbs = 0, sumCals = 0;
    TextView tvProteins, tvFats, tvCarbs, tvCals;
    String formatedCurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set layout
        setContentView(R.layout.activity_diet);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Diet tracker");

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        bar.setBackgroundDrawable(color);

        // get the recycler view in order to manipulate it
        RecView = findViewById(R.id.id_ac_di_RecView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // to show items in reverse
        // layoutManager.setReverseLayout(true);
        // layoutManager.setStackFromEnd(true);

        RecView.setLayoutManager(layoutManager);
        RecView.setHasFixedSize(true);

        // set the adapter for recycler view and show items in it
        adapter = new DietAdapter(this, this);
        //adapter.setItems(item_list); // items are set in adapter in view model
        RecView.setAdapter(adapter);  // To show items in recycler view, attach adapter to it

        long currentTimestamp = System.currentTimeMillis();
        Date currentDate = new Date(currentTimestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        formatedCurrentDate = sdf.format(currentDate);

        dietViewModel = new ViewModelProvider(this).get(DietViewModel.class);
        dietViewModel.getAllDietData().observe(this, new Observer<List<DietItem>>() {
            @Override
            public void onChanged(List<DietItem> dietItems) {
                adapter.setItems(dietItems);
                calculateDailyIntake(dietItems);
            }
        });
    }

    /*
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
                if (Objects.equals(muscleGroupName, getString(R.string.chest_exercise))){
                    muscleGroupItem = new ExercisesItem(R.drawable.chest, getString(R.string.chest_exercise), "Chest " + chest_exercise_counter);
                    chest_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(chest_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    chest_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.shoulders_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.shoulders, getString(R.string.shoulders_exercise), "Shoulders " + shoulder_exercise_counter);
                    shoulder_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(shoulder_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    shoulder_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.biceps_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.biceps, getString(R.string.biceps_exercise), "Biceps " + biceps_exercise_counter);
                    biceps_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(biceps_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    biceps_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.triceps_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.triceps, getString(R.string.triceps_exercise), "Triceps " + triceps_exercise_counter);
                    triceps_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(triceps_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    triceps_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.forearms_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.forearms, getString(R.string.forearms_exercise), "Forearms " + forearms_exercise_counter);
                    forearms_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(forearms_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    forearms_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.back_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.back, getString(R.string.back_exercise), "Back " + back_exercise_counter);
                    back_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(back_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    back_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.abs_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.abs, getString(R.string.abs_exercise), "Abs " + abs_exercise_counter);
                    abs_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(abs_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    abs_exercise_counter += 1;
                } else if (Objects.equals(muscleGroupName, getString(R.string.legs_exercise))) {
                    muscleGroupItem = new ExercisesItem(R.drawable.legs, getString(R.string.legs_exercise), "Legs " + legs_exercise_counter);
                    legs_exercises.add(muscleGroupItem);
                    muscleGroupAdapter.setExercisesItems(legs_exercises);
                    recyclerView.setAdapter(muscleGroupAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    muscleGroupItems.add(muscleGroupItem);
                    legs_exercise_counter += 1;
                }


                //Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
                //return true;

            //case R.id.action_about:
            //    Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
            //    return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    public void AddMeal(View view) {

        long current_date = System.currentTimeMillis();
        EditText edit_name = findViewById(R.id.ac_di_EditTextFoodName);
        EditText edit_own_weight = findViewById(R.id.ac_di_EditTextOwnWeight);
        EditText edit_proteins = findViewById(R.id.ac_di_EditTextProteins);
        EditText edit_fats = findViewById(R.id.ac_di_EditTextFats);
        EditText edit_carbs = findViewById(R.id.ac_di_EditTextCarbs);
        EditText edit_calories = findViewById(R.id.ac_di_EditTextCals);

        Editable editable_name = edit_name.getText();
        Editable editable_ow = edit_own_weight.getText();
        Editable editable_proteins = edit_proteins.getText();
        Editable editable_fats = edit_fats.getText();
        Editable editable_carbs = edit_carbs.getText();
        Editable editable_calories = edit_calories.getText();

        String name_text = (TextUtils.isEmpty(editable_name.toString())) ? "None" : editable_name.toString();
        int ow_text = (TextUtils.isEmpty(editable_ow.toString())) ? 0 : Integer.parseInt(editable_ow.toString());
        int proteins_text = (TextUtils.isEmpty(editable_proteins.toString())) ? 0 : Integer.parseInt(editable_proteins.toString());
        int fats_text = (TextUtils.isEmpty(editable_fats.toString())) ? 0 : Integer.parseInt(editable_fats.toString());
        int carbs_text = (TextUtils.isEmpty(editable_carbs.toString())) ? 0 : Integer.parseInt(editable_carbs.toString());
        int calories_text = (TextUtils.isEmpty(editable_calories.toString())) ? 0 : Integer.parseInt(editable_calories.toString());

        DietItem new_item = new DietItem(current_date, name_text, ow_text, proteins_text, fats_text, carbs_text, calories_text);
        dietViewModel.insert(new_item);

        edit_name.getText().clear();
        edit_own_weight.getText().clear();
        edit_proteins.getText().clear();
        edit_fats.getText().clear();
        edit_carbs.getText().clear();
        edit_calories.getText().clear();
    }

    public void calculateDailyIntake(List<DietItem> dietItems){
        sumProteins = 0;
        sumFats = 0;
        sumCarbs = 0;
        sumCals = 0;

        for(DietItem dietItem : dietItems){
            long item_timestamp = dietItem.getDate();
            Date itemDate = new Date(item_timestamp);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            String formatedItemDate = simpleDateFormat.format(itemDate);
            if(Objects.equals(formatedCurrentDate, formatedItemDate)){
                sumProteins += dietItem.getProteins();
                sumFats += dietItem.getFats();
                sumCarbs += dietItem.getCarbohydrates();
                sumCals += dietItem.getCalories();
            }
        }

        tvProteins = findViewById(R.id.ac_di_TextViewProteins);
        tvFats = findViewById(R.id.ac_di_TextViewFats);
        tvCarbs = findViewById(R.id.ac_di_TextViewCarbs);
        tvCals = findViewById(R.id.ac_di_TextViewCalories);

        if(tvProteins != null && tvFats != null && tvCarbs != null && tvCals != null) {
            tvProteins.setText(sumProteins + "g");
            tvFats.setText(sumFats + "g");
            tvCarbs.setText(sumCarbs + "g");
            tvCals.setText(sumCals + "kcal");
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getApplicationContext(), PopUpDietEdit.class);
        intent.putExtra("dietItem", adapter.getDietAtPosition(position));
        startActivity(intent);
    }
}