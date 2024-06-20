package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

public class OneExerciseActivity extends AppCompatActivity implements MainMenuRecViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_exercise);

        ArrayList<MainMenuRecViewItem> item_list;

        // get intent and set action bar title
        Bundle intent = getIntent().getExtras();
        if (intent != null){
            String exercise = intent.getString("ExerciseName");
            Objects.requireNonNull(getSupportActionBar()).setTitle(exercise);
        }

        // image adapter setting
        ViewPager2 viewPager2 = findViewById(R.id.id_ac_on_ex_ViewPager2_1);

        // Sample images
        int[] images = {R.drawable.back, R.drawable.abs, R.drawable.legs, R.drawable.shoulders};

        ImagePagerAdapter adapter = new ImagePagerAdapter(this, images);
        viewPager2.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {

        //if (Objects.equals(RecViewItems.get(position).getMainMenuRecViewType(), getString(R.string.chest_exercise))){
        //    Intent intent = new Intent(getApplicationContext(), ExercisesActivity.class);
        //    intent.putParcelableArrayListExtra("RecViewItemsList", chest_exercises);
        //    startActivity(intent);
        //}
    }
}