package com.example.fitapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class PopUpOneExerciseEdit extends OneExerciseActivity_0_0_0 {

    OneExerciseItem oneExerciseItem;
    EditText edit_set, edit_weight, edit_reps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_one_exercise_edit);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = ViewGroup.LayoutParams.WRAP_CONTENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getWindow().setLayout(width, height);

        Bundle intent = getIntent().getExtras();
        oneExerciseItem = intent.getParcelable("oneExerciseItem");

        int set = oneExerciseItem.getSetNumber();
        float weight = oneExerciseItem.getItemWeight();
        int reps = oneExerciseItem.getItemReps();

        edit_set = findViewById(R.id.ac_po_up_on_ex_ed_EditText1);
        edit_weight = findViewById(R.id.ac_po_up_on_ex_ed_EditText2);
        edit_reps = findViewById(R.id.ac_po_up_on_ex_ed_EditText3);

        edit_set.setText(String.valueOf(set));
        edit_weight.setText(String.valueOf(weight));
        edit_reps.setText(String.valueOf(reps));
    }

    public void Update(View view) {
        // ToDo: make to work update in sense that strings are not allowed to be added where ints are expected
        EditText edit_set = findViewById(R.id.ac_po_up_on_ex_ed_EditText1);
        EditText edit_weight = findViewById(R.id.ac_po_up_on_ex_ed_EditText2);
        EditText edit_reps = findViewById(R.id.ac_po_up_on_ex_ed_EditText3);

        Editable editable_set = edit_set.getText();
        Editable editable_weight = edit_weight.getText();
        Editable editable_reps = edit_reps.getText();

        int set_text = (TextUtils.isEmpty(editable_set.toString())) ? 0 : Integer.parseInt(editable_set.toString());
        float weight_text = (TextUtils.isEmpty(editable_weight.toString())) ? 0 : Float.parseFloat(editable_weight.toString());
        int reps_text = (TextUtils.isEmpty(editable_reps.toString())) ? 0 : Integer.parseInt(editable_reps.toString());

        oneExerciseItem.setSetNumber(set_text);
        oneExerciseItem.setItemWeight(weight_text);
        oneExerciseItem.setItemReps(reps_text);

        oneExerciseViewModel.update(oneExerciseItem);

        // finish the activity
        finish();
    }

    public void Delete(View view) {
        oneExerciseViewModel.delete(oneExerciseItem);

        // finish the activity
        finish();
    }

    // close activity if clicked outside the activity window
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View popupView = findViewById(R.id.ac_po_up_on_ex_ed_ConstraintLayout);
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
}