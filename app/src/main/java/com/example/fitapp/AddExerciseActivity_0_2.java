package com.example.fitapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import android.Manifest;

public class AddExerciseActivity_0_2 extends MuscleGroupsActivity_0 {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Category> categoryList;
    private static final int PICK_IMAGE = 100;
    private static final int REQUEST_PERMISSION_READ_EXTERNAL_STORAGE = 200;
    ImageButton imageButton;
    private ArrayList<Uri> imageUris;
    private Uri imageUri;
    private ActivityResultLauncher<Intent> pickImageLauncher;
    private ActivityResultLauncher<String> requestPermissionLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set layout
        setContentView(R.layout.activity_add_exercise);

        // Initialize the pickImageLauncher
        pickImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            imageUri = data.getData();
                            imageButton.setImageURI(imageUri);
                            imageUris.add(imageUri); // Add the Uri to the ArrayList
                        }
                    }
                });

        // Initialize the requestPermissionLauncher
        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(),
                isGranted -> {
                    if (isGranted) {
                        openImagePicker();
                    } else {
                        Toast.makeText(this, "Permission denied to read external storage", Toast.LENGTH_SHORT).show();
                    }
                });

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Custom Exercise");

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        bar.setBackgroundDrawable(color);

        imageButton = findViewById(R.id.ac_ad_ex_ImageButton1);
        imageUris = new ArrayList<>();
        imageButton.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
            } else {
                openImagePicker();
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

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickImageLauncher.launch(intent);
    }

    //@Override
    //public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    //    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    //    if (requestCode == REQUEST_PERMISSION_READ_EXTERNAL_STORAGE) {
    //        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
    //            openImagePicker();
    //        } else {
    //            Toast.makeText(this, "Permission denied to read external storage", Toast.LENGTH_SHORT).show();
    //        }
    //    }
    //}

    //@Override
    //protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    //    super.onActivityResult(requestCode, resultCode, data);
    //    if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
    //        imageUri = data.getData();
    //        grantUriPermission(getPackageName(), imageUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
    //        getContentResolver().takePersistableUriPermission(imageUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
    //        imageButton.setImageURI(imageUri);
    //        imageUris.add(imageUri); // Add the Uri to the ArrayList
    //    }
    //}

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

            viewModel.insert(new ExercisesItem(image, name_text, chosenCategories, true, "", imageUris));
            // ToDo: put Editable for explanation in the layout

            edit_exercise_name.getText().clear();
            finish();
        }

    }
}