package com.example.fitapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import android.Manifest;

public class AddExerciseActivity_0_2 extends MuscleGroupsActivity_0 {

    private static final int REQUEST_CODE_READ_EXTERNAL_STORAGE = 1;
    private static final int REQUEST_CODE_PICK_IMAGE = 2;

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Category> categoryList;
    ImageButton imageButton;
    private Bitmap imageBitmap;
    private ArrayList<Bitmap> imageBitmaps = new ArrayList<>();

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

        imageButton = findViewById(R.id.ac_ad_ex_ImageButton1);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AddExerciseActivity_0_2.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(AddExerciseActivity_0_2.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            REQUEST_CODE_READ_EXTERNAL_STORAGE);
                } else {
                    pickImageFromGallery();
                }
            }
        });

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

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_READ_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                pickImageFromGallery();
            } else {
                Toast.makeText(this, "Permission denied to read external storage", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            try {
                imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                imageBitmaps.add(imageBitmap);
                imageButton.setImageBitmap(imageBitmap);  // Optionally set the bitmap to the ImageButton
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

            viewModel.insert(new ExercisesItem(image, name_text, chosenCategories, true, "", imageBitmaps));
            // ToDo: put Editable for explanation in the layout

            edit_exercise_name.getText().clear();
            finish();
        }

    }
}