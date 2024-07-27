package com.example.fitapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class PopUpDietEdit extends DietActivity_0_1 {

    DietItem dietItem;
    EditText edit_name;
    EditText edit_weight;
    EditText edit_proteins;
    EditText edit_fats;
    EditText edit_carbs;
    EditText edit_calories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_diet_edit);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = ViewGroup.LayoutParams.WRAP_CONTENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getWindow().setLayout(width, height);

        // get data from previous activity
        Bundle intent = getIntent().getExtras();
        dietItem = intent.getParcelable("dietItem");

        String food_name = dietItem.getFood_name();
        int own_weight = dietItem.getOwn_weight();
        int proteins = dietItem.getProteins();
        int fats = dietItem.getFats();
        int carbs = dietItem.getCarbohydrates();
        int sugars = dietItem.getCalories();

        edit_name = findViewById(R.id.ac_po_up_di_EditText0);
        edit_name.setText(food_name);

        edit_weight = findViewById(R.id.ac_po_up_di_EditText1);
        edit_weight.setText(String.valueOf(own_weight));

        edit_proteins = findViewById(R.id.ac_po_up_di_EditText2);
        edit_proteins.setText(String.valueOf(proteins));

        edit_fats = findViewById(R.id.ac_po_up_di_EditText3);
        edit_fats.setText(String.valueOf(fats));

        edit_carbs = findViewById(R.id.ac_po_up_di_EditText4);
        edit_carbs.setText(String.valueOf(carbs));

        edit_calories = findViewById(R.id.ac_po_up_di_EditText5);
        edit_calories.setText(String.valueOf(sugars));
    }

    public void Update(View view) {
        // ToDo: make to work update in sense that strings are not allowed to be added where ints are expected
        EditText edit_name = findViewById(R.id.ac_po_up_di_EditText0);
        EditText edit_weight = findViewById(R.id.ac_po_up_di_EditText1);
        EditText edit_proteins = findViewById(R.id.ac_po_up_di_EditText2);
        EditText edit_fats = findViewById(R.id.ac_po_up_di_EditText3);
        EditText edit_carbs = findViewById(R.id.ac_po_up_di_EditText4);
        EditText edit_calories = findViewById(R.id.ac_po_up_di_EditText5);

        Editable editable_name = edit_name.getText();
        Editable editable_weight = edit_weight.getText();
        Editable editable_proteins = edit_proteins.getText();
        Editable editable_fats = edit_fats.getText();
        Editable editable_carbs = edit_carbs.getText();
        Editable editable_calories = edit_calories.getText();

        String name_text = (TextUtils.isEmpty(editable_name.toString())) ? "None" : editable_name.toString();
        int weight_text = (TextUtils.isEmpty(editable_weight.toString())) ? 0 : Integer.parseInt(editable_weight.toString());
        int proteins_text = (TextUtils.isEmpty(editable_proteins.toString())) ? 0 : Integer.parseInt(editable_proteins.toString());
        int fats_text = (TextUtils.isEmpty(editable_fats.toString())) ? 0 : Integer.parseInt(editable_fats.toString());
        int carbs_text = (TextUtils.isEmpty(editable_carbs.toString())) ? 0 : Integer.parseInt(editable_carbs.toString());
        int calories_text = (TextUtils.isEmpty(editable_calories.toString())) ? 0 : Integer.parseInt(editable_calories.toString());

        dietItem.setFood_name(name_text);
        dietItem.setOwn_weight(weight_text);
        dietItem.setProteins(proteins_text);
        dietItem.setFats(fats_text);
        dietItem.setCarbohydrates(carbs_text);
        dietItem.setCalories(calories_text);
        
        dietViewModel.update(dietItem);

        finish();
    }

    public void Delete(View view) {
        dietViewModel.delete(dietItem);
        finish();
    }

    // close activity if clicked outside the activity window
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View popupView = findViewById(R.id.ac_po_up_di_ConstraintLayout);
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