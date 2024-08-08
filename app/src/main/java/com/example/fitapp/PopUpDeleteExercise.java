package com.example.fitapp;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;

public class PopUpDeleteExercise extends DeleteExerciseActivity_0_3 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_delete_exercise);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = ViewGroup.LayoutParams.WRAP_CONTENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getWindow().setLayout(width, height);

        // get data from previous activity
        Bundle intent = getIntent().getExtras();
        delete_exercise = intent.getParcelable("exercise_to_delete");

        // Handle back button press using OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish(); // or use super.onBackPressed() to go back
            }
        });
    }

    // close activity if clicked outside the activity window
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View popupView = findViewById(R.id.ac_po_up_de_ex_LinearLayout);
            if (popupView != null && !isPointInsideView(ev.getRawX(), ev.getRawY(), popupView)) {
                finish(); // Close the activity
                return true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private boolean isPointInsideView(float x, float y, View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int viewX = location[0];
        int viewY = location[1];
        int viewWidth = view.getWidth();
        int viewHeight = view.getHeight();
        return !(x < viewX || x > viewX + viewWidth || y < viewY || y > viewY + viewHeight);
    }

    public void YesDelete(View view) {
        viewModel.delete(delete_exercise);
        finish();
    }

    public void NoDelete(View view) {
        finish();
    }
}
