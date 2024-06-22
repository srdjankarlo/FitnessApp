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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

//public class OneExerciseActivity_0_0_0 extends AppCompatActivity implements OneExerciseRecViewInterface {
public class OneExerciseActivity_0_0_0 extends AppCompatActivity {

    //OneExerciseRecViewAdapter recViewAdapter = new OneExerciseRecViewAdapter(this, this);
    RecyclerView recView;
    OneExerciseRecViewAdapter recViewAdapter = new OneExerciseRecViewAdapter(this);
    ViewPager2 viewPager2;
    DotsIndicator dotsIndicator;
    ArrayList<OneExerciseRecViewItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get intent and set action bar title
        //Intent intent = getIntent();
        //item = intent.getParcelableExtra("ExerciseName");
        //String name = item.getMainMenuRecViewTextView1();
        Bundle intent = getIntent().getExtras();
        String exercise_name = intent.getString("ExerciseName");

        // set layout
        setContentView(R.layout.activity_one_exercise);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle(exercise_name);

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        Objects.requireNonNull(bar).setBackgroundDrawable(color);

        // get image adapter
        viewPager2 = findViewById(R.id.id_ac_on_ex_ViewPager1);

        // get view pager dots
        dotsIndicator = findViewById(R.id.id_ac_on_ex_DotsIndicator);

        // Sample images
        int[] images = {R.drawable.back, R.drawable.abs, R.drawable.legs, R.drawable.shoulders};

        // set images in image pager adapter, set adapter and view pager dots
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(this, images);
        viewPager2.setAdapter(imagePagerAdapter);
        dotsIndicator.setViewPager2(viewPager2);

        // get the recycler view in order to manipulate it
        recView = findViewById(R.id.id_ac_on_ex_RecView1);

        // set the adapter for recycler view and show items in it
        // ToDo: first manage to add one item
        //items.add(new OneExerciseRecViewItem("formated_date", "weight_text", "reps_text", "duration"));
        recViewAdapter.setItems(items);

        recView.setAdapter(recViewAdapter);
        recView.setLayoutManager(new LinearLayoutManager(this));

    }

    //@Override
    //public void onItemClick(int position) {
    //
    //    //if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.chest_exercise))){
    //    //    Intent intent = new Intent(getApplicationContext(), ExercisesActivity_0_0.class);
    //    //    intent.putParcelableArrayListExtra("RecViewItemsList", chest_exercises);
    //    //    startActivity(intent);
    //    //}
    //
    //}

    // what to do when ADD button is pressed
    public void ADD(View view) {

        Date current_date = new Date();
        SimpleDateFormat date_formater = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String formated_date = date_formater.format(current_date);

        EditText edit_weight = (EditText) findViewById(R.id.id_ac_on_ex_TextView3);
        EditText edit_reps = (EditText) findViewById(R.id.id_ac_on_ex_TextView4);

        Editable editable_weight = edit_weight.getText();
        Editable editable_reps = edit_reps.getText();

        String weight_text = editable_weight.toString();
        String reps_text = editable_reps.toString();
        String duration = "ToDo";

        //items.add(new OneExerciseRecViewItem(formated_date, weight_text, reps_text, duration));
        OneExerciseRecViewItem new_item = new OneExerciseRecViewItem(formated_date, weight_text, reps_text, duration);

        recViewAdapter.addItem(new_item);

        edit_weight.getText().clear();
        edit_reps.getText().clear();
    }

    public void DurationTimer(View view) {
        // ToDo: make to be a stopwatch, click one time to start time, click second time to stop time and it cant be clicked again
    }
}