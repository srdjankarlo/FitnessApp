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
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private CategoryAdapter categoryAdapter1;
    private CategoryAdapter categoryAdapter2;
    private List<Category> categoryList1;
    private List<Category> categoryList2;
    //ImageButton imageButton;
    //private ArrayList<Uri> imageUris = new ArrayList<>();
    CheckBox checkBox1;
    CheckBox checkBox2;

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

        recyclerView1 = findViewById(R.id.ac_ad_ex_RecView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2 = findViewById(R.id.ac_ad_ex_RecView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        categoryList1 = new ArrayList<>();
        categoryList1.add(new Category("Back", "AD1"));
        categoryList1.add(new Category("Chest", "AD1"));
        categoryList1.add(new Category("Shoulders", "AD1"));
        categoryList1.add(new Category("Triceps", "AD1"));
        categoryList1.add(new Category("Biceps", "AD1"));
        categoryList1.add(new Category("Forearms", "AD1"));
        categoryList1.add(new Category("Abs", "AD1"));
        categoryList1.add(new Category("Glutes", "AD1"));
        categoryList1.add(new Category("Quads", "AD1"));
        categoryList1.add(new Category("Hamstrings", "AD1"));
        categoryList1.add(new Category("Calves", "AD1"));
        categoryAdapter1 = new CategoryAdapter(this, categoryList1);
        recyclerView1.setAdapter(categoryAdapter1);

        categoryList2 = new ArrayList<>();
        categoryList2.add(new Category("Back", "AD2"));
        categoryList2.add(new Category("Chest", "AD2"));
        categoryList2.add(new Category("Shoulders", "AD2"));
        categoryList2.add(new Category("Triceps", "AD2"));
        categoryList2.add(new Category("Biceps", "AD2"));
        categoryList2.add(new Category("Forearms", "AD2"));
        categoryList2.add(new Category("Abs", "AD2"));
        categoryList2.add(new Category("Glutes", "AD2"));
        categoryList2.add(new Category("Quads", "AD2"));
        categoryList2.add(new Category("Hamstrings", "AD2"));
        categoryList2.add(new Category("Calves", "AD2"));
        categoryAdapter2 = new CategoryAdapter(this, categoryList2);
        recyclerView2.setAdapter(categoryAdapter2);

        checkBox1 = findViewById(R.id.ac_ad_ex_CheckBox1);
        checkBox2 = findViewById(R.id.ac_ad_ex_CheckBox2);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox2.setChecked(false);
                }
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox1.setChecked(false);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Returning false here hides the menu
        return false;
    }

    // Method to get primary muscles
    private List<String> getPrimaryCategories() {
        List<Category> selectedCategories = categoryAdapter1.getSelectedCategories();
        List<String> categories = new ArrayList<>();
        for (Category category : selectedCategories) {
            if (Objects.equals(category.getFromAdapter(), "AD1")){
                categories.add(category.getName());
            }
        }
        return categories;
    }

    // Method to get secondary muscles
    private List<String> getSecondaryCategories() {
        List<Category> selectedCategories = categoryAdapter2.getSelectedCategories();
        List<String> categories = new ArrayList<>();
        for (Category category : selectedCategories) {
            if (Objects.equals(category.getFromAdapter(), "AD2")){
                categories.add(category.getName());
            }
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
            List<String> chosenCategories1 = getPrimaryCategories();
            List<String> chosenCategories2 = getSecondaryCategories();
            chosenCategories2.removeAll(chosenCategories1);

            int image = R.drawable.weight;
            Set<String> set_categories = new HashSet<>(chosenCategories1);

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
            // ToDo: pay attention to equals and containsAll
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

            String place = "x";
            if (checkBox1.isChecked()){
                place = "Gym";
            }
            if (checkBox2.isChecked()){
                place = "Home";
            }

            viewModel.insert(new ExercisesItem(image, name_text, chosenCategories1, chosenCategories2, true, "", null, place));
            // ToDo: put Editable for explanation in the layout

            edit_exercise_name.getText().clear();
            finish();
        }

    }
}