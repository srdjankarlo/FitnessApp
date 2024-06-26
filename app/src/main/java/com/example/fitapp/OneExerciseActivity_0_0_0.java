package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.EditText;
import android.widget.TextView;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.text.SimpleDateFormat;
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
    TextView workTimer;
    TextView restTimer;
    ArrayList<OneExerciseItem> items = new ArrayList<>();
    private boolean stopwatchWorkIsRunning = false;
    private boolean stopwatchRestIsRunning = false;
    private Handler handler = new Handler();
    private long startWorkTime = 0;
    private long startRestTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ToDo: make slide image explanations for all exercises

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

        // get the timer text view
        workTimer = findViewById(R.id.id_ac_on_ex_TextView2_1);
        restTimer = findViewById((R.id.id_ac_on_ex_TextView2_2));

        // get the recycler view in order to manipulate it
        recView = findViewById(R.id.id_ac_on_ex_RecView1);

        // set the adapter for recycler view and show items in it
        // ToDo: first manage to add one item
        //items.add(new OneExerciseItem("formated_date", "weight_text", "reps_text", "duration"));
        recViewAdapter.setItems(items);
        recView.setAdapter(recViewAdapter);

        // to show items in reverse
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        recView.setLayoutManager(layoutManager);
        //recView.setLayoutManager(new LinearLayoutManager(this));

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

        EditText edit_weight = findViewById(R.id.id_ac_on_ex_TextView3);
        EditText edit_reps = findViewById(R.id.id_ac_on_ex_TextView4);
        TextView edit_work_duration = workTimer;
        TextView edit_rest_duration = restTimer;

        Editable editable_weight = edit_weight.getText();
        Editable editable_reps = edit_reps.getText();
        CharSequence editable_work_duration = edit_work_duration.getText();
        CharSequence editable_rest_duration = edit_rest_duration.getText();

        float weight_text = (TextUtils.isEmpty(editable_weight.toString())) ? 0 : Float.parseFloat(editable_weight.toString());
        int reps_text = (TextUtils.isEmpty(editable_reps.toString())) ? 0 : Integer.parseInt(editable_reps.toString());
        int work_duration = (TextUtils.isEmpty(editable_work_duration.toString())) ? 0 : Integer.parseInt(editable_work_duration.toString());
        int rest_duration = (TextUtils.isEmpty(editable_rest_duration.toString())) ? 0 : Integer.parseInt(editable_rest_duration.toString());

        OneExerciseItem new_item = new OneExerciseItem(current_date, weight_text, reps_text, work_duration, rest_duration);

        // add item to adapter and scroll to last item (in this case first item bcs we reversed recyclerview)
        recViewAdapter.addItem(new_item);
        recView.smoothScrollToPosition(recViewAdapter.getItemCount() - 1);

        if (!stopwatchWorkIsRunning){
            workTimer.setText("0");
        }
        
        if (!stopwatchRestIsRunning){
            restTimer.setText("0");
        }

        edit_weight.getText().clear();
        edit_reps.getText().clear();
    }

    private Runnable work_runnable = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startWorkTime;
            int seconds = (int) (millis / 1000);

            workTimer.setText(String.format("%03d", seconds));

            handler.postDelayed(this, 1000);
        }
    };

    private Runnable rest_runnable = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startRestTime;
            int seconds = (int) (millis / 1000);

            restTimer.setText(String.format("%03d", seconds));

            handler.postDelayed(this, 1000);
        }
    };

    public void WorkoutTimer(View view) {

        if (stopwatchWorkIsRunning){
            handler.removeCallbacks(work_runnable);
        } else {
            startWorkTime = System.currentTimeMillis();
            handler.post(work_runnable);
        }
        stopwatchWorkIsRunning = !stopwatchWorkIsRunning;
    }

    public void RestingTimer(View view) {

        if (stopwatchRestIsRunning){
            handler.removeCallbacks(rest_runnable);
        } else {
            startRestTime = System.currentTimeMillis();
            handler.post(rest_runnable);
        }
        stopwatchRestIsRunning = !stopwatchRestIsRunning;
    }
}