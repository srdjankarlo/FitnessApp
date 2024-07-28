package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddExerciseActivity_0_2 extends MuscleGroupsActivity_0 {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Category> categoryList;

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

        recyclerView = findViewById(R.id.ac_ad_ex_RecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        categoryList = new ArrayList<>();
        categoryList.add(new Category("Chest"));
        categoryList.add(new Category("Shoulders"));
        categoryList.add(new Category("Biceps"));
        categoryList.add(new Category("Triceps"));
        categoryList.add(new Category("Forearms"));
        categoryList.add(new Category("Back"));
        categoryList.add(new Category("Abs"));
        categoryList.add(new Category("Quads"));
        categoryList.add(new Category("Hamstrings"));
        categoryList.add(new Category("Glutes"));
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
            for (String category : chosenCategories){
                // ToDo: Make more combined categories images and rethink how to write this if
                if (category.equals("Chest")){
                    image = R.drawable.chest;
                } else if (category.equals("Shoulders")) {
                    image = R.drawable.shoulders;
                } else if (category.equals("Biceps")) {
                    image = R.drawable.biceps;
                } else if (category.equals("Triceps")) {
                    image = R.drawable.triceps;
                } else if (category.equals("Forearms")) {
                    image = R.drawable.forearms;
                } else if (category.equals("Back")) {
                    image = R.drawable.back;
                } else if (category.equals("Abs")) {
                    image = R.drawable.abs;
                } else if (category.equals("Quads")) {
                    image = R.drawable.quads;
                } else if (category.equals("Hamstrings")) {
                    image = R.drawable.hamstrings;
                } else if (category.equals("Glutes")) {
                    image = R.drawable.glutes;
                } else if (category.equals("Calves")) {
                    image = R.drawable.calves;
                }
            }

            viewModel.insert(new ExercisesItem(image, name_text, chosenCategories, true));

            edit_exercise_name.getText().clear();
            finish();
        }

    }
}