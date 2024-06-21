package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class OneExerciseActivity_0_0_0 extends AppCompatActivity implements MainMenuRecViewInterface {

    MainMenuRecViewItem item = new MainMenuRecViewItem();
    MainMenuRecViewAdapter recViewAdapter = new MainMenuRecViewAdapter(this, this);
    ViewPager2 viewPager2;
    ArrayList<MainMenuRecViewItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get intent and set action bar title
        Intent intent = getIntent();
        item = intent.getParcelableExtra("ExerciseName");

        String name = item.getMainMenuRecViewTextView1();

        // set layout
        setContentView(R.layout.activity_one_exercise);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle(name);

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        Objects.requireNonNull(bar).setBackgroundDrawable(color);

        // image adapter setting
        viewPager2 = findViewById(R.id.id_ac_on_ex_ViewPager2_1);

        // Sample images
        int[] images = {R.drawable.back, R.drawable.abs, R.drawable.legs, R.drawable.shoulders};

        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(this, images);
        viewPager2.setAdapter(imagePagerAdapter);

    }

    @Override
    public void onItemClick(int position) {

        //if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.chest_exercise))){
        //    Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
        //    intent.putParcelableArrayListExtra("RecViewItemsList", chest_exercises);
        //    startActivity(intent);
        //}

    }

    public void ADD(View view) {
        // ToDo
        //Toast.makeText(getApplicationContext(), "Not implemented yet!", Toast.LENGTH_SHORT).show();
        EditText edit_weight = (EditText) findViewById(R.id.id_ac_on_ex_TextView2_0);
        EditText edit_reps = (EditText) findViewById(R.id.id_ac_on_ex_TextView2_1);
        Editable editable_weight = edit_weight.getText();
        Editable editable_reps = edit_reps.getText();
        String weight_text = editable_weight.toString();
        String weight_reps = editable_reps.toString();

        // ToDo: make recycler view item and layout and what not for one exercise or thing if to even use recycler view
        items.add(new MainMenuRecViewItem(R.drawable.abs, weight_text, "", weight_reps));

        RecyclerView recyclerView = findViewById(R.id.id_ac_on_ex_RecView1);

        recViewAdapter.setMainMenuRecView_items(items);
        recyclerView.setAdapter(recViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}