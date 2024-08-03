package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
//import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
//import android.Manifest;

public class AddExerciseActivity_0_2 extends MuscleGroupsActivity_0 {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Category> categoryList;
    //ImageButton imageButton;
    private ArrayList<Uri> imageUris = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set layout
        setContentView(R.layout.activity_add_exercise);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Custom Exercise");

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        bar.setBackgroundDrawable(color);

        //imageButton = findViewById(R.id.ac_ad_ex_ImageButton1);

        recyclerView = findViewById(R.id.ac_ad_ex_RecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        categoryList = new ArrayList<>();
        categoryList.add(new Category("Back"));
        categoryList.add(new Category("Chest"));
        categoryList.add(new Category("Shoulders"));
        categoryList.add(new Category("Triceps"));
        categoryList.add(new Category("Biceps"));
        categoryList.add(new Category("Forearms"));
        categoryList.add(new Category("Abs"));
        categoryList.add(new Category("Glutes"));
        categoryList.add(new Category("Quads"));
        categoryList.add(new Category("Hamstrings"));
        categoryList.add(new Category("Calves"));

        categoryAdapter = new CategoryAdapter(this, categoryList);
        recyclerView.setAdapter(categoryAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Returning false here hides the menu
        return false;
    }

    // Method to get selected exercises
    private List<String> getSelectedCategories() {
        List<Category> selectedCategories = categoryAdapter.getSelectedCategories();
        List<String> categories = new ArrayList<>();
        for (Category category : selectedCategories) {
            categories.add(category.getName());
        }
        return categories;
    }

    public void AddCustomExercise(View view) {

        EditText edit_exercise_name = findViewById(R.id.ac_ad_ex_EditText1);

        Editable editable_name = edit_exercise_name.getText();

        String name_text = (TextUtils.isEmpty(editable_name.toString())) ? "None" : editable_name.toString();
        if (name_text.equals("None")){
            Toast.makeText(this, "Enter name for Custom Exercise", Toast.LENGTH_SHORT).show();
        } else {
            List<String> chosenCategories = getSelectedCategories();

            int image = R.drawable.weight;
            Set<String> set_categories = new HashSet<>(chosenCategories);

            // set of all possibilities to check
            Set<String> set_back = new HashSet<>(Arrays.asList("Back"));
            Set<String> set_chest = new HashSet<>(Arrays.asList("Chest"));
            Set<String> set_shoulders = new HashSet<>(Arrays.asList("Shoulders"));
            Set<String> set_triceps = new HashSet<>(Arrays.asList("Triceps"));
            Set<String> set_biceps = new HashSet<>(Arrays.asList("Biceps"));
            Set<String> set_forearms = new HashSet<>(Arrays.asList("Forearms"));
            Set<String> set_abs = new HashSet<>(Arrays.asList("Abs"));

            Set<String> set_glutes = new HashSet<>(Arrays.asList("Glutes"));
            Set<String> set_glutes_quads = new HashSet<>(Arrays.asList("Glutes", "Quads"));
            Set<String> set_glutes_quads_hamstrings = new HashSet<>(Arrays.asList("Glutes", "Quads", "Hamstrings"));
            Set<String> set_glutes_quads_hamstrings_calves = new HashSet<>(Arrays.asList("Glutes", "Quads", "Hamstrings", "Calves"));
            Set<String> set_glutes_hamstrings = new HashSet<>(Arrays.asList("Glutes", "Hamstrings"));
            Set<String> set_glutes_hamstrings_calves = new HashSet<>(Arrays.asList("Glutes", "Hamstrings", "Calves"));
            Set<String> set_glutes_calves = new HashSet<>(Arrays.asList("Glutes", "Calves"));

            Set<String> set_quads = new HashSet<>(Arrays.asList("Quads"));
            Set<String> set_quads_hamstrings = new HashSet<>(Arrays.asList("Quads", "Hamstrings"));
            Set<String> set_quads_hamstrings_calves = new HashSet<>(Arrays.asList("Quads", "Hamstrings", "Calves"));
            Set<String> set_quads_calves = new HashSet<>(Arrays.asList("Quads", "Calves"));

            Set<String> set_hamstrings = new HashSet<>(Arrays.asList("Hamstrings"));
            Set<String> set_hamstrings_calves = new HashSet<>(Arrays.asList("Hamstrings", "Calves"));

            Set<String> set_calves = new HashSet<>(Arrays.asList("Calves"));

            // find what combination of categories is it
            // ToDo: input more
            if (set_categories.equals(set_back)){
                image = R.drawable.back;
            } else if (set_categories.equals(set_chest)) {
                image = R.drawable.chest;
            } else if (set_categories.equals(set_shoulders)) {
                image = R.drawable.shoulders;
            } else if (set_categories.equals(set_triceps)) {
                image = R.drawable.triceps;
            } else if (set_categories.equals(set_biceps)) {
                image = R.drawable.biceps;
            } else if (set_categories.equals(set_forearms)) {
                image = R.drawable.forearms;
            } else if (set_categories.equals(set_abs)) {
                image = R.drawable.abs;
            } else if (set_categories.equals(set_glutes)) {
                image = R.drawable.glutes;
            } else if (set_categories.containsAll(set_glutes_quads)) {
                image = R.drawable.glutes_quads;
            } else if (set_categories.containsAll(set_glutes_quads_hamstrings)) {
                image = R.drawable.glutes_quads_hamstrings;
            } else if (set_categories.containsAll(set_glutes_quads_hamstrings_calves)) {
                image = R.drawable.glutes_quads_hamstrings_calves;
            } else if (set_categories.containsAll(set_glutes_hamstrings)) {
                image = R.drawable.glutes_hamstrings;
            } else if (set_categories.containsAll(set_glutes_hamstrings_calves)) {
                image = R.drawable.glutes_hamstrings_calves;
            } else if (set_categories.containsAll(set_glutes_calves)) {
                image = R.drawable.glutes_calves;
            } else if (set_categories.equals(set_quads)) {
                image = R.drawable.quads;
            } else if (set_categories.containsAll(set_quads_hamstrings)) {
                image = R.drawable.quads_hamstrings;
            } else if (set_categories.containsAll(set_quads_hamstrings_calves)) {
                image = R.drawable.quads_hamstrings_calves;
            } else if (set_categories.containsAll(set_quads_calves)) {
                image = R.drawable.quads_calves;
            } else if (set_categories.equals(set_hamstrings)) {
                image = R.drawable.hamstrings;
            } else if (set_categories.containsAll(set_hamstrings_calves)) {
                image = R.drawable.hamstrings_calves;
            } else if (set_categories.equals(set_calves)) {
                image = R.drawable.calves;
            } else {
                image = R.drawable.weight;
            }

            viewModel.insert(new ExercisesItem(image, name_text, chosenCategories, true, "", imageUris));
            // ToDo: put Editable for explanation in the layout

            edit_exercise_name.getText().clear();
            finish();
        }

    }
}