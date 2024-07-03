package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//public class OneExerciseActivity_0_0_0 extends AppCompatActivity implements OneExerciseRecViewInterface {
public class OneExerciseActivity_0_0_0 extends AppCompatActivity implements OneExerciseInterface {

    //OneExerciseRecViewAdapter recViewAdapter = new OneExerciseRecViewAdapter(this, this);
    RecyclerView recView;
    OneExerciseAdapter recViewAdapter;
    ViewPager2 viewPager2;
    DotsIndicator dotsIndicator;
    TextView workTimer;
    TextView restTimer;
    Button workButtonTimer;
    Button restButtonTimer;
    ArrayList<OneExerciseItem> items = new ArrayList<>();
    private boolean stopwatchWorkIsRunning = false;
    private boolean stopwatchRestIsRunning = false;
    private Handler handler = new Handler();
    private long startWorkTime = 0;
    private long startRestTime = 0;
    private long elapsedWorkTime = 0;
    private long elapsedRestTime = 0;
    private String exercise_name;
    OneExerciseViewModel oneExerciseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get intent and set action bar title
        Bundle intent = getIntent().getExtras();
        ExercisesItem exercisesItem = intent.getParcelable("ExercisesItem");
        exercise_name = exercisesItem.getExerciseName();

        // set layout
        setContentView(R.layout.activity_one_exercise);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle(exercise_name);

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        Objects.requireNonNull(bar).setBackgroundDrawable(color);

        // get image adapter
        viewPager2 = findViewById(R.id.ac_on_ex_ViewPager1);

        // get view pager dots
        dotsIndicator = findViewById(R.id.ac_on_ex_DotsIndicator1);

        // Sample images for particular exercise
        int[] images = {};
        String muscleGroup = exercisesItem.getMuscleGroup();
        if (Objects.equals(muscleGroup, getString(R.string.chest_exercise))){
            images = new int[]{R.drawable.chest, R.drawable.weight};
        } else if (Objects.equals(muscleGroup, getString(R.string.shoulders_exercise))) {
            images = new int[]{R.drawable.shoulders, R.drawable.weight};
        } else if (Objects.equals(muscleGroup, getString(R.string.biceps_exercise))) {
            images = new int[]{R.drawable.biceps, R.drawable.weight};
        } else if (Objects.equals(muscleGroup, getString(R.string.triceps_exercise))) {
            images = new int[]{R.drawable.triceps, R.drawable.weight};
        } else if (Objects.equals(muscleGroup, getString(R.string.forearms_exercise))) {
            images = new int[]{R.drawable.forearms, R.drawable.weight};
        } else if (Objects.equals(muscleGroup, getString(R.string.back_exercise))) {
            images = new int[]{R.drawable.back, R.drawable.weight};
        } else if (Objects.equals(muscleGroup, getString(R.string.abs_exercise))) {
            images = new int[]{R.drawable.abs, R.drawable.weight};
        } else if (Objects.equals(muscleGroup, getString(R.string.legs_exercise))) {
            images = new int[]{R.drawable.legs, R.drawable.weight};
        }

        // set images in image pager adapter, set adapter and view pager dots
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(this, images);
        viewPager2.setAdapter(imagePagerAdapter);
        dotsIndicator.setViewPager2(viewPager2);

        // get the timer text view
        workTimer = findViewById(R.id.ac_on_ex_TextView1);
        restTimer = findViewById((R.id.ac_on_ex_TextView2));

        // get the buttons
        workButtonTimer = findViewById(R.id.ac_on_ex_Button1);
        restButtonTimer = findViewById(R.id.ac_on_ex_Button2);

        // get the recycler view in order to manipulate it
        recView = findViewById(R.id.id_ac_on_ex_RecView1);

        // set the adapter for recycler view and show items in it
        recViewAdapter = new OneExerciseAdapter(this, this);
        recView.setAdapter(recViewAdapter);

        // to show items in reverse
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        recView.setLayoutManager(layoutManager);

        // get the data from database
        oneExerciseViewModel = new ViewModelProvider(this).get(OneExerciseViewModel.class);
        oneExerciseViewModel.getAllOneExerciseData(exercise_name).observe(this, new Observer<List<OneExerciseItem>>() {
            @Override
            public void onChanged(List<OneExerciseItem> oneExerciseItems) {
                // add items in adapter so they can be shown
                recViewAdapter.setItems(oneExerciseItems);
            }
        });

    }

    public void ADD_EXERCISE(View view) {

        long current_date = System.currentTimeMillis();

        EditText edit_set = findViewById(R.id.ac_on_ex_EditText1);
        EditText edit_weight = findViewById(R.id.ac_on_ex_EditText2);
        EditText edit_reps = findViewById(R.id.ac_on_ex_EditText3);
        TextView edit_work_duration = workTimer;
        TextView edit_rest_duration = restTimer;

        Editable editable_set = edit_set.getText();
        Editable editable_weight = edit_weight.getText();
        Editable editable_reps = edit_reps.getText();
        CharSequence editable_work_duration = edit_work_duration.getText();
        CharSequence editable_rest_duration = edit_rest_duration.getText();

        int set_text = (TextUtils.isEmpty(editable_set.toString())) ? 0 : Integer.parseInt(editable_set.toString());
        float weight_text = (TextUtils.isEmpty(editable_weight.toString())) ? 0 : Float.parseFloat(editable_weight.toString());
        int reps_text = (TextUtils.isEmpty(editable_reps.toString())) ? 0 : Integer.parseInt(editable_reps.toString());
        int work_duration = (TextUtils.isEmpty(editable_work_duration.toString())) ? 0 : Integer.parseInt(editable_work_duration.toString());
        int rest_duration = (TextUtils.isEmpty(editable_rest_duration.toString())) ? 0 : Integer.parseInt(editable_rest_duration.toString());

        OneExerciseItem new_item = new OneExerciseItem(exercise_name, current_date, set_text, weight_text, reps_text, work_duration, rest_duration);
        oneExerciseViewModel.insert(new_item);

        stopWorkTimer();
        resetWorkTimer();
        stopRestTimer();
        resetRestTimer();
        
        // scroll to last item (in this case first item bcs we reversed recyclerview)
        recView.smoothScrollToPosition(recViewAdapter.getItemCount());

        edit_set.getText().clear();
        edit_weight.getText().clear();
        edit_reps.getText().clear();
    }

    @Override
    public void onItemClick(int position) {
        // ToDo: logic to delete or update diet item

        Toast.makeText(OneExerciseActivity_0_0_0.this, "Item clicked", Toast.LENGTH_SHORT).show();

        //Intent intent = new Intent(getApplicationContext(), PopUpDietEdit.class);
        ////intent.putExtra("position", position);
        //intent.putExtra("dietItem", adapter.getDietAtPosition(position));
        //startActivity(intent);
        ////startActivity(new Intent(DietActivity_0_1.this, PopUpDietEdit.class));
    }

    private Runnable work_runnable = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startWorkTime + elapsedWorkTime;
            int seconds = (int) (millis / 1000);

            workTimer.setText(String.format("%03d", seconds));

            handler.postDelayed(this, 1000);
        }
    };

    private Runnable rest_runnable = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startRestTime + elapsedRestTime;
            int seconds = (int) (millis / 1000);

            restTimer.setText(String.format("%03d", seconds));

            handler.postDelayed(this, 1000);
        }
    };

    public void WorkoutTimer(View view) {

        if(stopwatchWorkIsRunning){
            stopWorkTimer();
        } else {
            startWorkTimer();
        }
    }

    public void ResetWorkoutT(View view){
        resetWorkTimer();
    }

    public void startWorkTimer(){
        startWorkTime = System.currentTimeMillis();
        handler.postDelayed(work_runnable, 0);
        stopwatchWorkIsRunning = true;
        workButtonTimer.setText("Stop Workout Timer");
    }

    public void stopWorkTimer(){
        handler.removeCallbacks(work_runnable);
        elapsedWorkTime += System.currentTimeMillis() - startWorkTime;
        stopwatchWorkIsRunning = false;
        workButtonTimer.setText("Start Workout Timer");
    }

    public void resetWorkTimer(){
        workTimer.setText("000");
        elapsedWorkTime = 0;
        stopwatchWorkIsRunning = false;
        workButtonTimer.setText("Start Workout Timer");
    }

    public void RestingTimer(View view) {

        if(stopwatchRestIsRunning){
            stopRestTimer();
        } else {
            startRestTimer();
        }
    }

    public void ResetRestingT(View view){
        resetRestTimer();
    }

    public void startRestTimer(){
        startRestTime = System.currentTimeMillis();
        handler.postDelayed(rest_runnable, 0);
        stopwatchRestIsRunning = true;
        restButtonTimer.setText("Stop Rest Timer");
    }

    public void stopRestTimer(){
        handler.removeCallbacks(rest_runnable);
        elapsedRestTime += System.currentTimeMillis() - startRestTime;
        stopwatchRestIsRunning = false;
        restButtonTimer.setText("Start Rest Timer");
    }

    public void resetRestTimer(){
        restTimer.setText("000");
        elapsedRestTime = 0;
        stopwatchRestIsRunning = false;
        restButtonTimer.setText("Start Rest Timer");
    }
}